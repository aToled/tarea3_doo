package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private final Panel_de_Compras com;
    private final PanelExpendedor pExp;
    private final Panel_Recoleccion_Productos pro;

    public PanelPrincipal() {
        setBackground(new Color(66, 66, 66));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());

        com = new Panel_de_Compras(this);
        pExp = new PanelExpendedor(this);
        pro = new Panel_Recoleccion_Productos();

        add(pExp, BorderLayout.CENTER);
        add(pro, BorderLayout.SOUTH);
        add(com, BorderLayout.EAST);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        com.paintComponent(g);

        pExp.paintComponent(g);
    }
}
