package gui.Paneles;


import gui.Botones.BotonIngresarDinero;
import gui.utils.Init;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel{
    private BotonIngresarDinero botonIngresarDinero;
    public PanelComprador(){
        setLayout(null);
        setBackground(Color.GRAY);
        Init.panelComprador=this;
        botonIngresarDinero = new BotonIngresarDinero();
        add(botonIngresarDinero);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        // Fondo y Bordes
        g.setColor(Color.GRAY);
        g.fillRect(0,0,getWidth(),getWidth());
        g.setColor(Color.BLACK);
        g.drawRect(0,0,getWidth()-1,getHeight()-1);

        // Dinero total comprador
        int dinero_total = Init.comprador.CuantoDinero();
        g.setColor(Color.WHITE);
        g.drawString("Dinero total: $" + dinero_total,10,20);

        // Monedas en orden del comprador
        Init.Mostrar_monedas_en_orden(Init.comprador.getMonedero(), g, 0);

        // Monedas en orden del expendedor //TODO TEMPORAL; BORRAR!!!
        Init.Mostrar_monedas_en_orden(Init.expendedor.getMonedas_ingresadas(), g, 100);
    }
}
