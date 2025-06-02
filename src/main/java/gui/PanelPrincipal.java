package gui;

import logica.Comprador;
import logica.Expendedor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private Expendedor expendedor;
    private Comprador comprador=new Comprador(1000);
    private Panel_de_Compras com;
    private PanelComprador pCom;
    private PanelExpendedor pExp;
    private Panel_Recoleccion_Productos pro;

    public PanelPrincipal(Expendedor expendedor) {
        this.expendedor = expendedor;

        setBackground(new Color(66, 66, 66));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());

        com = new Panel_de_Compras(this, expendedor);
        pCom = new PanelComprador(this, comprador);
        pExp = new PanelExpendedor(this, expendedor);
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
