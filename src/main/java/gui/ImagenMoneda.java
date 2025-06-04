package gui;

import logica.Moneda;

import javax.swing.*;
import java.awt.*;

public class ImagenMoneda extends JPanel {
    Moneda moneda;
    JLabel valorLabel;
    JLabel serieLabel;

    public ImagenMoneda(Moneda moneda) {
        this.moneda = moneda;

        valorLabel = new JLabel("$" + String.valueOf(moneda.getValor()));
        valorLabel.setBounds(13, -10, 50, 50);

        serieLabel = new JLabel(String.valueOf(moneda.getSerie()));
        serieLabel.setBounds(5, 10, 50, 50);

        add(valorLabel);
        add(serieLabel);

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
