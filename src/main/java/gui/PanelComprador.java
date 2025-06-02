package gui;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    PanelPrincipal panelPrincipal;
    Expendedor expendedor;

    public PanelComprador(PanelPrincipal panelPrincipal, Expendedor expendedor) {
        this.panelPrincipal = panelPrincipal;
        this.expendedor = expendedor;

        setBackground(new Color(66, 66, 66));
        setPreferredSize(new Dimension(175, 0));
        setLayout(null);

        InsertaMonedas insertaMonedas = new InsertaMonedas(panelPrincipal, expendedor);
        JLabel textoMonedas = new JLabel("Inserte monedas aquí");
        textoMonedas.setForeground(new Color(255, 255, 255));
        textoMonedas.setBounds(50, 300, 125, 15);
        DispensadorMonedas dispensadorMonedas = new DispensadorMonedas(panelPrincipal, expendedor);

        add(insertaMonedas);
        add(textoMonedas);
        add(dispensadorMonedas);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
