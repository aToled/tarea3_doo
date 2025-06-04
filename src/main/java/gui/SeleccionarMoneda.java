package gui;

import logica.Moneda;
import logica.PagoIncorrectoException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeleccionarMoneda extends JPanel{
    Moneda moneda;
    JLabel valorLabel;
    JLabel serieLabel;

    public SeleccionarMoneda(Moneda moneda, VentanaIngresarMoneda ventana) {
        this.moneda = moneda;
        setPreferredSize(new Dimension(50, 50));
        setLayout(null);

        valorLabel = new JLabel("$" + String.valueOf(moneda.getValor()));
        valorLabel.setBounds(13, -10, 50, 50);

        serieLabel = new JLabel(String.valueOf(moneda.getSerie()));
        serieLabel.setBounds(5, 10, 50, 50);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    ventana.monedaSeleccionada(moneda);
                } catch (PagoIncorrectoException exception){
                    exception.printStackTrace();
                }
                System.out.println(moneda);
            }
        });

        add(valorLabel);
        add(serieLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, 50, 50);
    }
}
