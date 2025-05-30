package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        // Configuración de la ventana
        setTitle("Expendedor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(650, 750));
        // Centraliza la ventana
        setLocationRelativeTo(null);
        setResizable(false);

        PanelPrincipal panelPrincipal = new PanelPrincipal();

        add(panelPrincipal);
    }

    public void mostrar() {
        setVisible(true);
    }
}
