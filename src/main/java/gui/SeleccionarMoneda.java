package gui;

import logica.Moneda;
import logica.PagoIncorrectoException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeleccionarMoneda extends JPanel{
    Moneda moneda;
    JLabel valueLabel = new JLabel();

    public SeleccionarMoneda(Moneda moneda, VentanaIngresarMoneda ventana) {
        this.moneda = moneda;
        setPreferredSize(new Dimension(50, 50));
        setLayout(null);

        valueLabel.setText(String.valueOf(moneda.getValor()));
        valueLabel.setBounds(13, 1, 50, 50);

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

        add(valueLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, 50, 50);
    }
}
