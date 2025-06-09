package gui.Ventanas;

import gui.Paneles.PanelPrincipal;
import gui.utils.Init;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal la cual muestra el expendedor con sus depósitos y productos
 */
public class VentanaPrincipal extends JFrame {
    /**
     * Se instancia el panel principal el cual muestra y posiciona los componentes
     */
    public VentanaPrincipal() {
        Init.inicializar();  //Inicializa variables estáticas.

        // Configuración de la ventana
        setTitle("Expendedor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(900, 950));

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
