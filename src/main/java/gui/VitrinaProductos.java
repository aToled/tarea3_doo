package gui;

import logica.Productos;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VitrinaProductos extends JPanel {
    private static class BordeRedondo implements Border {

        private final int radio;

        BordeRedondo(int radio) {
            this.radio = radio;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radio+1, this.radio+1, this.radio+2, this.radio);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radio, radio);
        }
    }

    private static class ImagenProducto extends JPanel {
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

        @Override
        protected void paintComponent(Graphics g) {
            if (img != null) {
                g.drawImage(img, 0, 0, null);
            } else {
                g.drawString("Imagen no disponible", 10, 20);
            }
        }
    }

    public void establecerPosicion(ImagenProducto p, int fila, int col, int profundidad) {
        int x = 0 + col * ImagenProducto.SIZE + col * 10 + profundidad * 5;
        int y = 50 + fila * ImagenProducto.SIZE + fila * 25 - profundidad * 5;
        p.setBounds(x, y, ImagenProducto.SIZE, ImagenProducto.SIZE);
    }

    public VitrinaProductos() {
        //setBackground(new Color(150, 150, 150));
        //setBorder(new BordeRedondo(100));
        setOpaque(false);
        setLayout(null);

        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(Productos.COCA);
            establecerPosicion(p, 0, 0, i);
            add(p);
        }

        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(Productos.SPRITE);
            establecerPosicion(p, 0, 1, i);
            add(p);
        }

        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(Productos.FANTA);
            establecerPosicion(p, 0, 2, i);
            add(p);
        }

        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(Productos.SNICKERS);
            establecerPosicion(p, 1, 0, i);
            add(p);
        }

        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(Productos.SUPER8);
            establecerPosicion(p, 1, 1, i);
            add(p);
        }

        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(Productos.CHOCMAN);
            establecerPosicion(p, 1, 2, i);
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
