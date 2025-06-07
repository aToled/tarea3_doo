package gui.Ventanas;

import gui.Paneles.PanelPrincipal;
import gui.utils.Init;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        Init.inicializar();  //Inicializa variables estáticas.

        // Configuración de la ventana
        setTitle("Expendedor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(700, 950));

        // Centraliza la ventana
        setLocationRelativeTo(null);
        setResizable(false);

        PanelPrincipal panelPrincipal = new PanelPrincipal();
        add(panelPrincipal);

        // Muestra ventana del comprador
        new VentanaComprador().mostrar();
    }

    public void mostrar() {
        setVisible(true);
    }
}
