package gui.Paneles;

import gui.Botones.BotonRecogerVuelto;
import gui.Imagenes.ImagenMoneda;
import gui.utils.Init;
import logica.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelDispensadorMonedas extends JPanel {
    private PanelPrincipal panelPrincipal;
    private final JPanel panelMonedas;
    private BotonRecogerVuelto botonRecogerVuelto;

    /**
     * Se encarga de mostrar las monedas dadas de vuelto al comprador
     * @param panelPrincipal: Referencia a panel principal para poder re-pintar en caso de ser necesario
     */
    public PanelDispensadorMonedas(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        setBackground(new Color(66, 66, 66));
        setLayout(null);
        setBounds(40, 480, 100, 300);

        this.panelMonedas = new JPanel();
        this.panelMonedas.setBackground(new Color(50,50,50));
        this.panelMonedas.setBounds(12,0,75,200);
        this.panelMonedas.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));

        // Área donde se recoge el vuelto dispensado.
        this.botonRecogerVuelto = new BotonRecogerVuelto(panelPrincipal);

        add(panelMonedas);
        add(botonRecogerVuelto);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.panelMonedas.removeAll();
        ArrayList<Moneda> monedas = Init.expendedor.getMonedas_ingresadas().getRef();
        int maxMonedas = Math.min(12, monedas.size());
        for (int i=0; i<maxMonedas; i++) {
            Moneda m = monedas.get(i);
            ImagenMoneda imagenMoneda = new ImagenMoneda(m);
            panelMonedas.add(imagenMoneda);
            imagenMoneda.setBounds(6, 25*i, 50, 50);
        }
        this.panelMonedas.repaint();
        this.panelMonedas.revalidate();
    }
}
