package gui;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    public PanelPrincipal() {
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        PanelProductos panelProductos = new PanelProductos();

        PanelOpciones panelOpciones = new PanelOpciones();

        BotonCompra botonCompra = new BotonCompra();

        Box boxDerecha = Box.createVerticalBox();

        boxDerecha.add(panelOpciones);
        boxDerecha.add(botonCompra);

        add(panelProductos, BorderLayout.CENTER);
        add(boxDerecha, BorderLayout.EAST);
    }
}
