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

        DispensadorMonedas dispensadorMonedas = new DispensadorMonedas(panelPrincipal, expendedor);

        add(dispensadorMonedas);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
