package gui.Imagenes;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase se utiliza para mostrar los números que se utilizan para identificar
 * y comprar los productos.
 * @see JPanel
 * @see Color
 */
public class ImagenNumero extends JPanel {
    public static final int SIZE = 45;
    JLabel numero = new JLabel();
    private final Color ColorCirculo;

    /**
     * Almacena los datos necesarios para renderizar el número.
     * @param x: coordenada horizontal.
     * @param y: coordenada vertical.
     * @param num: valor numérico a mostrar.
     * @param ColorFondo: Color de fondo.
     * @param ColorCirculo: Color del círculo.
     * @param ColorNumero: Color del número.
     */
    public ImagenNumero(int x, int y, int num, Color ColorFondo, Color ColorCirculo, Color ColorNumero) {
        this.ColorCirculo = ColorCirculo;
        setSize(new Dimension(SIZE, SIZE));
        setPreferredSize(new Dimension(SIZE, SIZE));
        setMaximumSize(new Dimension(SIZE, SIZE));
        setBackground(ColorFondo);
        setBounds(x, y, SIZE, SIZE);

        numero.setText(String.valueOf(num));
        numero.setForeground(ColorNumero);
        numero.setFont(new Font("Arial", Font.BOLD, 23));
        numero.setBounds(x,y,SIZE,SIZE);
        add(numero);

    }

    /**
     * Se renderiza como un círculo con un fondo de color y el número en el centro
     * @param g Objeto utilizado para renderizar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(ColorCirculo);
        g.fillOval(0, 0, 45, 45);
    }
}
