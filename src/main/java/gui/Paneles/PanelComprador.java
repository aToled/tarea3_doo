package gui.Paneles;


import gui.Botones.BotonIngresarDinero;
import gui.utils.Init;

import javax.swing.*;
import java.awt.*;

/**
 * En este panel se muestra al usuario las monedas que dispone el comprador al igual que un
 * botón que permite obtener más dinero si es requerido
 */
public class PanelComprador extends JPanel{
    private BotonIngresarDinero botonIngresarDinero;

    /**
     * Se crea el boton para ingresar dinero y se coloca dentro del panel
     */
    public PanelComprador(){
        setLayout(null);
        setBackground(Color.GRAY);
        Init.panelComprador=this;
        botonIngresarDinero = new BotonIngresarDinero();
        add(botonIngresarDinero);
    }

    /**
     * Se renderiza la cantidad total de dinero, la cantidad de monedas de cada valor
     * y por último el botón para recibir más dinero
     * @param g Objeto utilizado para renderizar
     */
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
