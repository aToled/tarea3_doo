package gui;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class VentanaIngresarMoneda extends JFrame {
    private Expendedor expendedor = Init.expendedor;

    public VentanaIngresarMoneda() {
        // Configuración de la ventana
        setTitle("Ingresar moneda");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(50*2+10, 50*3+10));
        // Centraliza la ventana
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        SeleccionarMoneda sm1 = new SeleccionarMoneda(new Moneda100());
        sm1.setBounds(0,0, 50, 50);

        SeleccionarMoneda sm2 = new SeleccionarMoneda(new Moneda500());
        sm2.setBounds(50+10,0, 50, 50);

        SeleccionarMoneda sm3 = new SeleccionarMoneda(new Moneda1000());
        sm3.setBounds(0,50+10, 50, 50);

        SeleccionarMoneda sm4 = new SeleccionarMoneda(new Moneda1500());
        sm4.setBounds(50+10,50+10, 50, 50);

        add(sm1);
        add(sm2);
        add(sm3);
        add(sm4);
    }

    public void monedaSeleccionada(Moneda moneda) throws PagoIncorrectoException {
        Init.expendedor.Ingresar_Monedas(moneda);
        dispose();
    }

    public void mostrar() {
        setVisible(true);
    }
}

