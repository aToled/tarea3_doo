package gui;

import logica.Expendedor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private Panel_de_Compras pCom;
    private PanelExpendedor pExp;
    private Panel_Recoleccion_Productos pro;

    public PanelPrincipal() {
        setBackground(new Color(66, 66, 66));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());

        pCom = new Panel_de_Compras(this);
        pExp = new PanelExpendedor(this);
        pro = new Panel_Recoleccion_Productos();

        add(pExp, BorderLayout.CENTER);
        add(pro, BorderLayout.SOUTH);
        add(pCom, BorderLayout.EAST);
        Init.panelDeCompras=pCom;

    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        pCom.paintComponent(g);
        pExp.paintComponent(g);
    }
}
