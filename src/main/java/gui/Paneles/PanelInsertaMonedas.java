package gui.Paneles;

import gui.Ventanas.VentanaIngresarMoneda;
import gui.utils.Init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Aquí es donde el usuario puede ingresar monedas al depósito
 * @see JPanel
 */
public class PanelInsertaMonedas extends JPanel {
    public static boolean ventanaAbierta = false;

    /**
     * Al pulsar sobre el panel se abrirá un menu en el cual el usuario selecciona
     * la moneda que desea ingresar
     */
    public PanelInsertaMonedas() {
        setBackground(Color.BLACK);
        setBounds(20, 280, 25, 125);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if (ventanaAbierta) return;
                ventanaAbierta = true;

                VentanaIngresarMoneda ventanaIngresarMoneda = new VentanaIngresarMoneda();
                ventanaIngresarMoneda.mostrar();
                Init.panelDeCompras.actualizarTexto();
                Init.panelDeCompras.getDispensadorMonedas().repaint();
            }
        });
    }
}
