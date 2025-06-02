package gui;
import logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JFrame{
    private PanelPrincipal panelPrincipal;
    private Comprador comprador;
    private JLabel dinero;
    private JPanel productos;
    public PanelComprador(PanelPrincipal panelPrincipal, Comprador comprador){
        this.panelPrincipal = panelPrincipal;
        this.comprador = comprador;

        // Configuración de la ventana:
        setTitle("Comprador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300,550);
        setLocation(200,200);
        setResizable(false);

        // Ventana principal:
        JPanel ventana = new JPanel();
        ventana.setBackground(new Color(255, 255, 255));
        ventana.setLayout(null);
        setContentPane(ventana);

        // dinero total:
        dinero = new JLabel("$" + comprador.CuantoDinero());
        dinero.setBackground(Color.WHITE);
        dinero.setBounds(20,20,200,30);
        ventana.add(dinero);

        // productos en el inventario del comprador:
        productos = new JPanel();
        productos.setLayout(null);
        productos.setOpaque(false);
        productos.setBounds(20,60,260,300);
        ventana.add(productos);

        JButton Consumir_Producto = new JButton("Consumir Producto");

        setVisible(true);

    }
}
