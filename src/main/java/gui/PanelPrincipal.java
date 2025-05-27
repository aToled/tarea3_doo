package gui;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    public PanelPrincipal() {
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        PanelProductos panelProductos = new PanelProductos();

        PanelOpciones panelOpciones = new PanelOpciones();

        add(panelProductos, BorderLayout.CENTER);
        add(panelOpciones, BorderLayout.EAST);
    }
}
