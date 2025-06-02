package gui;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InsertaMonedas extends JPanel {
    PanelPrincipal panelPrincipal;
    Expendedor expendedor;

    public InsertaMonedas(PanelPrincipal panelPrincipal, Expendedor expendedor) {
        this.panelPrincipal = panelPrincipal;
        this.expendedor = expendedor;

        setBackground(new Color(0, 0, 0));
        setBounds(20, 250, 25, 125);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MyMouseListener(expendedor));
    }

    private static class MyMouseListener extends MouseAdapter {
        Expendedor expendedor;

        public MyMouseListener(Expendedor expendedor) {
            this.expendedor = expendedor;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            VentanaIngresarMoneda ventanaIngresarMoneda = new VentanaIngresarMoneda(expendedor);
            ventanaIngresarMoneda.mostrar();
        }
    }
}
