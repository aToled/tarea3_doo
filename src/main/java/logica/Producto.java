package logica;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Un Molde de producto genérico que se almacena en un depósito y es comprado por un comprador.
 */
public abstract class Producto extends JPanel {
    private final int serie;
    public int x = 0;
    public int y = 0;
    public static final int SIZE = 125;
    private BufferedImage img;

    /**
     * Crea el Producto con un numero de serie al azar.
     */
    public Producto(Productos producto) {
        this.serie= (int) (Math.random()*1000000);;
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
     * Comprador almacena el string retornado por esta clase cada vez que consume
     * el producto
     * @return String único que cada producto debe especificar
     */
    public abstract String consumir();

    /**
     * @return Número único para identificar cada producto
     */
    public int getSerie() {
        return serie;
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
