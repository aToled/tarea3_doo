package gui;

import javax.swing.*;

public class VentanaComprador extends JFrame {
    public VentanaComprador(){

        // Configuración de la ventana:
        setTitle("Comprador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300,550);
        setLocation(200,200);
        setResizable(false);

        PanelComprador p = new PanelComprador();
        add(p);
    }

    public void mostrar(){
        setVisible(true);
    }
}
