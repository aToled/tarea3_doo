package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagenNumero extends JPanel {
    public int x = 0;
    public int y = 0;
    public static final int SIZE = 40;
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
