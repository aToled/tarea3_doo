package gui;

import logica.Moneda;

import javax.swing.*;
import java.awt.*;

public class ImagenMoneda extends JPanel {
    Moneda moneda;

    public ImagenMoneda(Moneda moneda) {
        this.moneda = moneda;
        setBackground(new Color(50, 50, 50));
        setPreferredSize(new Dimension(50, 50));
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, 50, 50);
    }
}
