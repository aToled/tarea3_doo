package gui;

import logica.Expendedor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private Expendedor expendedor;
    private PanelComprador com;
    public PanelExpendedor exp;
    private Panel_Recoleccion_Productos pro;

    public PanelPrincipal(Expendedor expendedor) {
        this.expendedor = expendedor;

        setBackground(new Color(66, 66, 66));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());

        com = new PanelComprador(this, expendedor);
        exp = new PanelExpendedor(this, expendedor);
        pro = new Panel_Recoleccion_Productos();

        add(exp, BorderLayout.CENTER);
        add(pro, BorderLayout.SOUTH);
        add(com, BorderLayout.EAST);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        com.paintComponent(g);

        exp.paintComponent(g);
    }
}
