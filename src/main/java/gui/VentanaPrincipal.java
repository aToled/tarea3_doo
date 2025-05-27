package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        // Configuración de la ventana
        setTitle("Expendedor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(750, 700));
        // Centraliza la ventana
        setLocationRelativeTo(null);
        setResizable(false);

        // Componentes de la ventana
        PanelPrincipal panelPrincipal = new PanelPrincipal();

        add(panelPrincipal);
    }

    public void mostrar() {
        setVisible(true);
    }
}
