package gui;

import logica.Expendedor;
import logica.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelBotones extends JPanel {
    PanelPrincipal panelPrincipal;
    Expendedor expendedor;

    public PanelBotones(PanelPrincipal panelPrincipal, Expendedor expendedor) {
        this.panelPrincipal = panelPrincipal;
        this.expendedor = expendedor;

        setBounds(0, 100, 175, 200);

        JButton btn1 = new JButton("1");
        btn1.addActionListener((ActionEvent e) -> {
            panelPrincipal.exp.botarProducto(Productos.COCA);
        });
        add(btn1);
    }
}
