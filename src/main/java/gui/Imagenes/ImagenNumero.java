package gui.Imagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Esta clase se utiliza para mostrar los números que se utilizar para identificar
 * y comprar los productos
 */
public class ImagenNumero extends JPanel {
    public static final int SIZE = 45;
    JLabel numero = new JLabel();
    private final Color ColorCirculo;

    /**
     * Se almacenan los datos necesarios para renderizar el número
     * @param x: coordenada horizontal
     * @param y: coordenada vertical
     * @param num: valor numérico a mostrar
     * @param ColorFondo: Color de fonto
     * @param ColorCirculo: Color del círculo
     * @param ColorNumero: Color del número
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
     * Se renderza como un círculo con un fondo de color y el número en el centro
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(ColorCirculo);
        g.fillOval(0, 0, 45, 45);
    }
}
