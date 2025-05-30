package gui;

import logica.Expendedor;
import logica.Productos;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;

public class PanelExpendedor extends JLayeredPane {
    private Expendedor expendedor;
    private PanelPrincipal panelPrincipal;
    private ArrayList<ImagenProducto> imagenProductos = new ArrayList<>();
    private ArrayList<ImagenNumero> imagenNumeros = new ArrayList<>();

    private static class Animacion {
        private final PanelPrincipal panelPrincipal;
        private final ImagenProducto p;
        private Timer timerAnimacion;
        private boolean condicionDeParadaAlcanzada = false;

        public Animacion(PanelPrincipal panelPrincipal, ImagenProducto p) {
            this.panelPrincipal = panelPrincipal;
            this.p = p;
        }

        public void iniciarOContinuarMovimiento() {
            if (condicionDeParadaAlcanzada) {
                System.out.println("La condición de parada ya fue alcanzada. Reinicia para mover de nuevo.");
                return;
            }

            if (timerAnimacion == null) {
                timerAnimacion = new Timer(10, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        // Lógica de movimiento y condición de parada
                        p.y += 1;
                        p.setBounds(p.x, p.y, ImagenProducto.SIZE, ImagenProducto.SIZE);
                        p.invalidate();

                        panelPrincipal.repaint();
                        System.out.println(p.x + " / " + p.y);
                        if (p.y >= 600) {
                            detenerAnimacion();
                        }
                    }
                });
                timerAnimacion.start();
                System.out.println("Animación iniciada.");
            } else if (!timerAnimacion.isRunning()) {
                timerAnimacion.start();
                System.out.println("Animación continuada.");
            } else {
                System.out.println("La animación ya está en curso.");
            }
        }

        private void detenerAnimacion() {
            if (timerAnimacion != null && timerAnimacion.isRunning()) {
                timerAnimacion.stop();
                condicionDeParadaAlcanzada = true; // Marcar que la condición se cumplió
                System.out.println("Animación detenida.");
            }
        }
    }

    private static class ImagenProducto extends JPanel {
        public int x = 0;
        public int y = 0;
        private static final int SIZE = 125;
        private BufferedImage img;

        public ImagenProducto(Productos producto) {
            setSize(new Dimension(SIZE, SIZE));
            setPreferredSize(new Dimension(SIZE, SIZE));
            setMaximumSize(new Dimension(SIZE, SIZE));

            String userDirectory = new File("").getAbsolutePath();
            try {
                File file = new File(userDirectory + "/resources/" + producto.nombre + ".png");

                img = ImageIO.read(file);
            } catch (IOException e) {
                System.out.println("Error al cargar la imagen: " + e.getMessage());
            }
        }

        public void establecerPosicion(int fila, int col, int profundidad) {
            this.x = 50 + col * ImagenProducto.SIZE + col * 50 + profundidad * 5;
            this.y = 45 + fila * ImagenProducto.SIZE + fila * 70 - profundidad * 5;
            setBounds(this.x, this.y, ImagenProducto.SIZE, ImagenProducto.SIZE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (img != null) {
                g.drawImage(img, this.x, this.y, null);
            } else {
                g.drawString("Imagen no disponible", this.x, this.y);
            }
        }
    }

    private static class ImagenNumero extends JPanel {
        public int x = 0;
        public int y = 0;
        private static final int SIZE = 40;
        private BufferedImage img;

        public ImagenNumero(int x, int y, int n) {
            this.x = x;
            this.y = y;

            setSize(new Dimension(SIZE, SIZE));
            setPreferredSize(new Dimension(SIZE, SIZE));
            setMaximumSize(new Dimension(SIZE, SIZE));

            setBounds(this.x, this.y, SIZE, SIZE);

            String userDirectory = new File("").getAbsolutePath();
            try {
                File file = new File(userDirectory + "/resources/" + n + ".png");

                img = ImageIO.read(file);
            } catch (IOException e) {
                System.out.println("Error al cargar la imagen: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (img != null) {
                g.drawImage(img, this.x, this.y, null);
            } else {
                g.drawString("Imagen no disponible", this.x, this.y);
            }
        }
    }

    public PanelExpendedor(PanelPrincipal panelPrincipal, Expendedor expendedor) {
        this.expendedor = expendedor;
        this.panelPrincipal = panelPrincipal;

        setOpaque(false);
        setLayout(null);

        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 2; col++) {
                int x = 50 + col * ImagenProducto.SIZE + col * 50;
                int y = 45 + fila * ImagenProducto.SIZE + fila * 70;
                x += ImagenProducto.SIZE/2 - ImagenNumero.SIZE/2;
                y += ImagenProducto.SIZE + 7;
                ImagenNumero num = new ImagenNumero(x, y, fila*2+col+1);
                imagenNumeros.add(num);
            }
        }

        agregarProductos(0, 0, expendedor.coca.size(), Productos.COCA);
        agregarProductos(0, 1, expendedor.sprite.size(), Productos.SPRITE);
        agregarProductos(1, 0, expendedor.fanta.size(), Productos.FANTA);
        agregarProductos(1, 1, expendedor.snickers.size(), Productos.SNICKERS);
        agregarProductos(2, 0, expendedor.super8.size(), Productos.SUPER8);
        agregarProductos(2, 1, expendedor.chocman.size(), Productos.CHOCMAN);
    }

    void agregarProductos(int fila, int col, int cantidad, Productos producto) {
        for (int i = 0; i < cantidad; i++) {
            ImagenProducto p = new ImagenProducto(producto);
            p.establecerPosicion(fila, col, i);
            imagenProductos.add(p);

            if (fila == 0 && col == 0 && i == 0) {
                System.out.println("x");
                Animacion a = new Animacion(panelPrincipal, p);
            }
        }
    }

    // Se crea un borde redondo y se pinta de color gris claro el interior
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create(); // Objeto utilizado para pintar

        // Antialiasing hace los bordes más suaves
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = 420;
        int alto = 620;

        // Segundo (de fondo)
        Shape formaRedondeada0 = new RoundRectangle2D.Double(15, 5, ancho, alto, 50, 50);

        // Color de fondo (dentro de los bordes)
        g2d.setColor(new Color(160, 160, 160));

        g2d.fill(formaRedondeada0);


        // Se crea el borde
        Shape formaRedondeada = new RoundRectangle2D.Double(5, 15, ancho, alto, 50, 50);

        // Color de fondo (dentro de los bordes)
        g2d.setColor(new Color(150, 150, 150));

        g2d.fill(formaRedondeada);

        for (ImagenProducto p : imagenProductos) {
            p.paintComponent(g);
        }

        for (ImagenNumero n : imagenNumeros) {
            n.paintComponent(g);
        }



        g2d.dispose(); // Liberar los recursos del objeto Graphics2D
    }
}
