package gui.Paneles;

import gui.Ventanas.VentanaIngresarMoneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSeleccionarMoneda extends JPanel{
    JLabel valorLabel;

    public PanelSeleccionarMoneda(int valor_moneda, VentanaIngresarMoneda ventana) {
        setPreferredSize(new Dimension(50, 50));
        setLayout(null);

        valorLabel = new JLabel("$" + valor_moneda);
        valorLabel.setBounds(10, 0, 50, 50);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.monedaSeleccionada(valor_moneda);
            }
        });

        add(valorLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, 50, 50);
    }
}
