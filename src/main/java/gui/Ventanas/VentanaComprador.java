package gui.Ventanas;

import gui.Paneles.PanelComprador;

import javax.swing.*;

/**
 * Ventana que muestra las monedas que posee el comprador ademas de un botón
 * que permite entregar más monedas al comprador por si se solicita
 */
public class VentanaComprador extends JFrame {
    public VentanaComprador(){
        // Configuración de la ventana:
        setTitle("Comprador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300,400);
        setLocation(200,45);
        setResizable(false);

        PanelComprador p = new PanelComprador();
        add(p);
    }

    public void mostrar(){
        setVisible(true);
    }
}
