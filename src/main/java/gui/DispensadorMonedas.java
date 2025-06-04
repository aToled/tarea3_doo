package gui;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DispensadorMonedas extends JPanel {
    PanelPrincipal panelPrincipal;
    JPanel panelMonedas;

    /**
     * Se encarga de mostrar las monedas dadas de vuelto al comprador
     * @param panelPrincipal: Referencia a panel principal para poder re-pintar en caso de ser necesario
     */
    public DispensadorMonedas(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        setBackground(new Color(66, 66, 66));
        setLayout(null);
        setBounds(40, 450, 100, 300);

        this.panelMonedas = new JPanel();
        this.panelMonedas.setBackground(new Color(50,50,50));
        this.panelMonedas.setBounds(12,0,75,200);
        this.panelMonedas.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));

        JPanel panelVacio = new JPanel();
        panelVacio.setBackground(new Color(0,0,0));
        panelVacio.setBounds(0,225, 100, 75);

        add(panelMonedas);
        add(panelVacio);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.panelMonedas.removeAll();
        ArrayList<Moneda> monedas = Init.expendedor.monedasDentro.getRef();
        int i = 0;
        for (Moneda m : monedas) {
            ImagenMoneda imagenMoneda = new ImagenMoneda(m);
            this.panelMonedas.add(imagenMoneda);
            if (50*i <= 300) {
                imagenMoneda.setBounds(12, 50 * i+10, 50, 50);
            }
            i++;
        }
    }
}
