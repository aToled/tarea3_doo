package gui;

import logica.Producto;

import javax.swing.*;
import java.awt.*;

public class PanelOpciones extends JPanel {
    private class BotonProducto extends JButton {
        public BotonProducto(Producto producto ) {}
    }

    public PanelOpciones() {
        setBackground(new Color(0, 200, 0));
    }
}
