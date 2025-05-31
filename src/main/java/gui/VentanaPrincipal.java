package gui;

import logica.Expendedor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private Expendedor expendedor;

    public VentanaPrincipal(Expendedor expendedor) {
        this.expendedor = expendedor;

        // Configuración de la ventana
        setTitle("Expendedor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(700, 950));
        // Centraliza la ventana
        setLocationRelativeTo(null);
        setResizable(false);

        PanelPrincipal panelPrincipal = new PanelPrincipal(expendedor);

        add(panelPrincipal);
    }

    public void mostrar() {
        setVisible(true);
    }
}
