package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ImagenNumero extends JPanel {
    public static final int SIZE = 45;
    JLabel numero = new JLabel();
    private final Color ColorCirculo;

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(ColorCirculo);
        g.fillOval(0, 0, 45, 45);
    }
}
