package gui;

import logica.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SeleccionarMoneda extends JPanel implements MouseListener {
    Moneda moneda;
    JLabel valueLabel = new JLabel();

    public SeleccionarMoneda(Moneda moneda) {
        this.moneda = moneda;
        setBackground(new Color(50, 50, 50));
        setPreferredSize(new Dimension(50, 50));
        setLayout(null);

        valueLabel.setText(String.valueOf(moneda.getValor()));
        valueLabel.setBounds(15, 0, 50, 50);

        add(valueLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, 50, 50);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
