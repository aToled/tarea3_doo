package gui;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class DispensadorMonedas extends JPanel {
    PanelPrincipal panelPrincipal;
    Expendedor expendedor;

    public DispensadorMonedas(PanelPrincipal panelPrincipal, Expendedor expendedor) {
        this.panelPrincipal = panelPrincipal;
        this.expendedor = expendedor;

        setBackground(new Color(0,0,255));
        setLayout(null);
        setBounds(40, 400, 100, 300);

        JPanel panelMonedas = new JPanel();
        panelMonedas.setBackground(new Color(255,255,0));
        panelMonedas.setBounds(12,0,75,200);

        JPanel panelVacio = new JPanel();
        panelVacio.setBackground(new Color(0,0,0));
        panelVacio.setBounds(0,225, 100, 75);

        add(panelMonedas);
        add(panelVacio);
    }
}
