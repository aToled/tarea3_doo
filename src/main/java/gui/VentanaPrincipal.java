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

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(100, 100, 100));
        panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelPrincipal.setLayout(new BorderLayout());

        panelPrincipal.add(new VitrinaProductos(), BorderLayout.CENTER);
        panelPrincipal.add(new PanelProductos(), BorderLayout.SOUTH);
        panelPrincipal.add(new PanelLateral(), BorderLayout.EAST);

        add(panelPrincipal);
    }

    public void mostrar() {
        setVisible(true);
    }
}
