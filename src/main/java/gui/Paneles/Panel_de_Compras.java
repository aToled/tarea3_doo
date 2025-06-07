package gui.Paneles;

import gui.Botones.Boton_Dispensador_Vuelto;
import gui.utils.Init;
import javax.swing.*;
import java.awt.*;

public class Panel_de_Compras extends JPanel {
    PanelPrincipal panelPrincipal;
    private final JLabel texto1Label;
    private final JLabel texto2Label;
    private final PanelBotones panelBotones;
    private final PanelDispensadorMonedas dispensadorMonedas;
    private final Boton_Dispensador_Vuelto botonDispensadorVuelto;

    public void setTextoPantalla(String texto1, String texto2) {
        texto1Label.setText(texto1);
        texto2Label.setText(texto2);
    }

    public Panel_de_Compras(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        setBackground(new Color(66, 66, 66));
        setPreferredSize(new Dimension(175, 0));
        setLayout(null);

        //Monedas
        PanelInsertaMonedas insertaMonedas = new PanelInsertaMonedas(panelPrincipal);
        JLabel textoMonedas = new JLabel("Ingrese moneda");
        textoMonedas.setForeground(new Color(255, 255, 255));
        textoMonedas.setBounds(50, 330, 125, 15);
        dispensadorMonedas = new PanelDispensadorMonedas(panelPrincipal);
        botonDispensadorVuelto = new Boton_Dispensador_Vuelto(panelPrincipal);

        add(insertaMonedas);
        add(textoMonedas);
        add(dispensadorMonedas);
        add(botonDispensadorVuelto);

        //Pantalla
        JPanel pantalla = new JPanel();
        pantalla.setBackground(Color.BLACK);
        pantalla.setBounds(20, 20, 150, 80);
        pantalla.setBorder(BorderFactory.createLineBorder(Color.GRAY,5));
        pantalla.setLayout(null);

        texto1Label = new JLabel("Dinero Disponible");
        texto1Label.setForeground(Color.WHITE);
        texto1Label.setBounds(23, 10, 180, 20);

        texto2Label = new JLabel(String.valueOf(Init.expendedor.getDinero_total_ingresado()));
        texto2Label.setForeground(Color.WHITE);
        texto2Label.setBounds(60, 40, 130, 20);
        pantalla.add(texto1Label);
        pantalla.add(texto2Label);
        add(pantalla);

        // Números
        panelBotones = new PanelBotones(panelPrincipal);
        add(panelBotones);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void actualizarTexto() {
        setTextoPantalla("Dinero Ingresado", String.valueOf(Init.expendedor.getDinero_total_ingresado()));
        texto2Label.setText(String.valueOf(Init.expendedor.getDinero_total_ingresado()));
        repaint();
    }
    public PanelDispensadorMonedas getDispensadorMonedas() {
        return dispensadorMonedas;
    }

    public PanelBotones getPanelBotones() {
        return panelBotones;
    }

    public Boton_Dispensador_Vuelto getBotonDispensadorVuelto() {
        return botonDispensadorVuelto;
    }
}
