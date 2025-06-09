package gui.Imagenes;

import logica.Productos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Esta clase se utiliza para renderizar un producto en la ventana
 */
public class ImagenProducto extends JPanel {
    public static final int SIZE = 125;
    private BufferedImage img;

    /**
     * Crea un nuevo panel que representa la imagen de un producto.
     * @param producto
     */
    public ImagenProducto(Productos producto) {
        setSize(new Dimension(SIZE, SIZE));
        setOpaque(false);

        String userDirectory = new File("").getAbsolutePath()+ "/resources/" + producto.nombre + ".png";
        try {
            img = ImageIO.read(new File(userDirectory));
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
        int x = 30 + col * SIZE + col * 100 + profundidad * 5;
        int y = 50 + fila * SIZE + fila * 100 - profundidad * 5;
        setBounds(x, y, SIZE, SIZE);
    }

    /**
     * Se renderiza a través de una imagen las cuales se encuentran en la carpeta resources
     * @param g Objeto para renderizar
     */
    @Override
    protected void paintComponent(Graphics g) {
        if (img != null) {
            g.drawImage(img, 0, 0, null);
        } else {
            g.drawString("Imagen no disponible", 10, 20);
        }
    }
}
