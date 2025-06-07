package gui.Paneles;

import gui.Ventanas.VentanaIngresarMoneda;
import gui.utils.Init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelInsertaMonedas extends JPanel{
    private PanelPrincipal panelPrincipal;
    public static boolean ventanaAbierta = false;

    public PanelInsertaMonedas(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

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
