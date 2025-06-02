package gui;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class VentanaIngresarMoneda extends JFrame {
    private Expendedor expendedor;

    public VentanaIngresarMoneda(Expendedor expendedor) {
        this.expendedor = expendedor;

        // Configuración de la ventana
        setTitle("Ingresar moneda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(400, 400));
        // Centraliza la ventana
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        SeleccionarMoneda sm1 = new SeleccionarMoneda(new Moneda100());
        sm1.setBounds(0,0, 75, 75);

        SeleccionarMoneda sm2 = new SeleccionarMoneda(new Moneda500());
        sm2.setBounds(0,0, 75, 75);

        SeleccionarMoneda sm3 = new SeleccionarMoneda(new Moneda1000());
        sm3.setBounds(0,0, 75, 75);

        SeleccionarMoneda sm4 = new SeleccionarMoneda(new Moneda1500());
        sm4.setBounds(0,0, 75, 75);

        add(sm1);
        add(sm2);
        add(sm3);
        add(sm4);
    }

    public void monedaSeleccionada(Moneda moneda) {
        // TODO: Ver donde guardar estas monedas

        dispose();
    }

    public void mostrar() {
        setVisible(true);
    }
}

