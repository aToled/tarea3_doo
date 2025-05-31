package gui;

import logica.Productos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagenProducto extends JPanel {
    public int x = 0;
    public int y = 0;
    public static final int SIZE = 125;
    private BufferedImage img;

    /**
     * Crea un nuevo panel que representa la imagen de un producto.
     * @param producto
     */
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

    /**
     * Establece la posicion del producto en la vitrina según su fila, columna y profundidad.
     * @param fila: tal fila.
     * @param col: tal columna.
     * @param profundidad: tal profundidad.
     */
    public void establecerPosicion(int fila, int col, int profundidad) {
        this.x = 30 + col * SIZE + col * 100 + profundidad * 5;
        this.y = 50 + fila * SIZE + fila * 100 - profundidad * 5;
        setBounds(this.x, this.y, SIZE, SIZE);
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
