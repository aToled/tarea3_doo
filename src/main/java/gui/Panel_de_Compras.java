package gui;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class Panel_de_Compras extends JPanel {
    PanelPrincipal panelPrincipal;

    public Panel_de_Compras(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        Expendedor expendedor = Init.expendedor;

        setBackground(new Color(66, 66, 66));
        setPreferredSize(new Dimension(175, 0));
        setLayout(null);

        InsertaMonedas insertaMonedas = new InsertaMonedas(panelPrincipal);
        JLabel textoMonedas = new JLabel("Ingrese moneda");
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
