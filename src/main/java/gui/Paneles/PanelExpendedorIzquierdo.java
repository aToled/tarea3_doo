package gui.Paneles;

import gui.Botones.BotonRellenarDepositos;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedorIzquierdo extends JPanel {
    private  PanelPrincipal panelPrincipal;
    public PanelExpendedorIzquierdo(PanelPrincipal panelPrincipal){
        this.panelPrincipal = panelPrincipal;

        setBackground(new Color(66, 66, 66));
        setPreferredSize(new Dimension(200, 0));
        setLayout(new BorderLayout());
        add(new BotonRellenarDepositos());
        add(new PanelDepositoComprasExitosas(panelPrincipal));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
