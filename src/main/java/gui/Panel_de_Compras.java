package gui;

import javax.swing.*;
import java.awt.*;

public class Panel_de_Compras extends JPanel {
    PanelPrincipal panelPrincipal;
    private JLabel texto1Label;
    private JLabel texto2Label;
    public PanelBotones panelBotones;

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
        InsertaMonedas insertaMonedas = new InsertaMonedas(panelPrincipal);
        JLabel textoMonedas = new JLabel("Ingrese moneda");
        textoMonedas.setForeground(new Color(255, 255, 255));
        textoMonedas.setBounds(50, 330, 125, 15);
        DispensadorMonedas dispensadorMonedas = new DispensadorMonedas(panelPrincipal);

        add(insertaMonedas);
        add(textoMonedas);
        add(dispensadorMonedas);
        add(new Boton_Dispensador_Vuelto(panelPrincipal));

        //Pantalla
        JPanel pantalla = new JPanel();
        pantalla.setBackground(Color.BLACK);
        pantalla.setBounds(20, 20, 150, 80);
        pantalla.setBorder(BorderFactory.createLineBorder(Color.GRAY,5));
        pantalla.setLayout(null);

        texto1Label = new JLabel("Dinero Ingresado");
        texto1Label.setForeground(Color.WHITE);
        texto1Label.setBounds(25, 10, 180, 20);

        texto2Label = new JLabel(String.valueOf(Init.expendedor.getDinero_total_ingresado()));
        texto2Label.setForeground(Color.WHITE);
        texto2Label.setBounds(60, 40, 130, 20);
        pantalla.add(texto1Label);
        pantalla.add(texto2Label);
        add(pantalla);

        // Numeros
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
}
