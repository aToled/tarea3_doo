package gui;

import logica.*;

import javax.swing.*;
import java.awt.*;

public class DispensadorMonedas extends JPanel {
    PanelPrincipal panelPrincipal;
    Expendedor expendedor;

    /**
     * Se encarga de mostrar las monedas dadas de vuelto al comprador
     * @param panelPrincipal: Referencia a panel principal para poder re-pintar en caso de ser necesario
     * @param expendedor: Referenia a expendedor para poder interactuar con la lógica del programa
     */
    public DispensadorMonedas(PanelPrincipal panelPrincipal, Expendedor expendedor) {
        this.panelPrincipal = panelPrincipal;
        this.expendedor = expendedor;

        setBackground(new Color(66, 66, 66));
        setLayout(null);
        setBounds(40, 400, 100, 300);

        JPanel panelMonedas = new JPanel();
        panelMonedas.setBackground(new Color(50,50,50));
        panelMonedas.setBounds(12,0,75,200);

        JPanel panelVacio = new JPanel();
        panelVacio.setBackground(new Color(0,0,0));
        panelVacio.setBounds(0,225, 100, 75);

        int size = expendedor.monedas_compras_exitosas.size();
        for (int i = 0; i < size; i++) {
            Moneda m = expendedor.monedas_compras_exitosas.get();
            ImagenMoneda imagenMoneda = new ImagenMoneda(m);
            panelMonedas.add(imagenMoneda);
            if (50*i <= 300) {
                imagenMoneda.setBounds(12, 50 * i, 50, 50);
            }
        }

        add(panelMonedas);
        add(panelVacio);
    }
}
