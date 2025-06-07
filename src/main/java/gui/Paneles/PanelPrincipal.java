package gui.Paneles;

import gui.utils.Init;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    public Panel_de_Compras pdeCom;
    public PanelExpendedor pExp;
    public Panel_Recoleccion_Productos PRP;

    public PanelPrincipal() {
        setBackground(new Color(66, 66, 66));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());

        pdeCom = new Panel_de_Compras(this);
        pExp = new PanelExpendedor(this);
        PRP = new Panel_Recoleccion_Productos();

        add(pExp, BorderLayout.CENTER);
        add(PRP, BorderLayout.SOUTH);
        add(pdeCom, BorderLayout.EAST);
        Init.panelDeCompras=pdeCom;
        Init.panelExpendedor=pExp;
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        pdeCom.paintComponent(g);
        pExp.paintComponent(g);
        PRP.paintComponents(g);

        setComponentZOrder(PRP,0);
    }
}
