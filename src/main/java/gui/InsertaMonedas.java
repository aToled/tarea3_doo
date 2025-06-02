package gui;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InsertaMonedas extends JPanel{
    PanelPrincipal panelPrincipal;
    Expendedor expendedor;

    public InsertaMonedas(PanelPrincipal panelPrincipal, Expendedor expendedor) {
        this.panelPrincipal = panelPrincipal;
        this.expendedor = expendedor;

        setBackground(new Color(0, 0, 0));
        setBounds(20, 250, 25, 125);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                VentanaIngresarMoneda ventanaIngresarMoneda = new VentanaIngresarMoneda(expendedor);
                ventanaIngresarMoneda.mostrar();
            }
        });
    }
}
