package gui;

import logica.Productos;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

public class VitrinaProductos extends JPanel {
    private static class Animacion {
        private ImagenProducto p;
        private Timer timerAnimacion;
        private boolean condicionDeParadaAlcanzada = false;

        public Animacion(ImagenProducto p) {
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
            this.y = 25 + fila * ImagenProducto.SIZE + fila * 70 - profundidad * 5;
            setBounds(this.x, this.y, ImagenProducto.SIZE, ImagenProducto.SIZE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (img != null) {
                g.drawImage(img, 0, 0, null);
            } else {
                g.drawString("Imagen no disponible", 10, 20);
            }
        }
    }

    private static class ImagenNumero extends JPanel {
        public int x = 0;
        public int y = 0;
        private static final int SIZE = 40;
        private BufferedImage img;

        public ImagenNumero(int x, int y, int n) {
            setSize(new Dimension(SIZE, SIZE));
            setPreferredSize(new Dimension(SIZE, SIZE));
            setMaximumSize(new Dimension(SIZE, SIZE));

            setBounds(x, y, SIZE, SIZE);

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
                g.drawImage(img, 0, 0, null);
            } else {
                g.drawString("Imagen no disponible", 10, 20);
            }
        }
    }

    public VitrinaProductos() {
        //setBackground(new Color(150, 150, 150));
        //setBorder(new BordeRedondo(100));
        setOpaque(false);
        setLayout(null);

        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 2; col++) {
                int x = 50 + col * ImagenProducto.SIZE + col * 50;
                int y = 25 + fila * ImagenProducto.SIZE + fila * 70;
                x += ImagenProducto.SIZE/2 - ImagenNumero.SIZE/2;
                y += ImagenProducto.SIZE + 7;
                ImagenNumero num = new ImagenNumero(x, y, fila*2+col+1);
                add(num);
            }
        }

        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(Productos.COCA);
            p.establecerPosicion(0, 0, i);
            add(p);

            if (i == 0) {
                Animacion a = new Animacion(p);
                a.iniciarOContinuarMovimiento();
            }
        }

        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(Productos.SPRITE);
            p.establecerPosicion(0, 1, i);
            add(p);
        }

        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(Productos.FANTA);
            p.establecerPosicion(1, 0, i);
            add(p);
        }

        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(Productos.SNICKERS);
            p.establecerPosicion(1, 1, i);
            add(p);
        }

        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(Productos.SUPER8);
            p.establecerPosicion(2, 0, i);
            add(p);
        }

        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(Productos.CHOCMAN);
            p.establecerPosicion(2, 1, i);
            add(p);
        }
    }

    // Se crea un borde redondo y se pinta de color gris claro el interior
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create(); // Objeto utilizado para pintar

        // Antialiasing hace los bordes más suaves
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth();
        int alto = getHeight();

        // Se crea el borde
        Shape formaRedondeada = new RoundRectangle2D.Double(0, 0, ancho, alto, 50, 50);

        // Color de fondo (dentro de los bordes)
        g2d.setColor(new Color(150, 150, 150));

        g2d.fill(formaRedondeada);

        g2d.dispose(); // Liberar los recursos del objeto Graphics2D
    }
}
