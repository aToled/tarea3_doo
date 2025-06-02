package gui;

import logica.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SeleccionarMoneda extends JPanel{
    Moneda moneda;
    JLabel valueLabel = new JLabel();

    public SeleccionarMoneda(Moneda moneda) {
        this.moneda = moneda;
        setPreferredSize(new Dimension(50, 50));
        setLayout(null);

        valueLabel.setText(String.valueOf(moneda.getValor()));
        valueLabel.setBounds(15, 0, 50, 50);

        addMouseListener(new MyMouseListener(moneda));

        add(valueLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, 50, 50);
    }

    private static class MyMouseListener extends MouseAdapter {
        Moneda moneda;

        public MyMouseListener(Moneda moneda) {
            this.moneda = moneda;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            System.out.println("Moneda seleccionada: " + moneda.getValor());
        }
    }
}
