package gui;

import logica.Expendedor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private Expendedor expendedor;
    private PanelComprador com;
    private PanelExpendedor exp;
    private PanelProductos pro;

    public PanelPrincipal(Expendedor expendedor) {
        this.expendedor = expendedor;

        setBackground(new Color(66, 66, 66));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());

        com = new PanelComprador();
        exp = new PanelExpendedor(this, expendedor);
        pro = new PanelProductos();
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        com.paintComponent(g);

        exp.paintComponent(g);
    }
}
