package gui;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class Panel_de_Compras extends JPanel {
    PanelPrincipal panelPrincipal;
    private JLabel texto2;

    public Panel_de_Compras(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        Expendedor expendedor = Init.expendedor;

        setBackground(new Color(66, 66, 66));
        setPreferredSize(new Dimension(175, 0));
        setLayout(null);

        //Monedas
        InsertaMonedas insertaMonedas = new InsertaMonedas(panelPrincipal);
        JLabel textoMonedas = new JLabel("Ingrese moneda");
        textoMonedas.setForeground(new Color(255, 255, 255));
        textoMonedas.setBounds(50, 330, 125, 15);
        DispensadorMonedas dispensadorMonedas = new DispensadorMonedas(panelPrincipal, expendedor);

        add(insertaMonedas);
        add(textoMonedas);
        add(dispensadorMonedas);

        //Pantalla
        JPanel pantalla = new JPanel();
        pantalla.setBackground(Color.BLACK);
        pantalla.setBounds(20, 20, 150, 80);
        pantalla.setBorder(BorderFactory.createLineBorder(Color.GRAY,5));
        pantalla.setLayout(null);

        JLabel texto1 = new JLabel("Dinero Ingresado");
        texto1.setForeground(Color.WHITE);
        texto1.setBounds(25, 10, 180, 20);

        texto2 = new JLabel(String.valueOf(Init.expendedor.getDinero_total_ingresado()));
        texto2.setForeground(Color.WHITE);
        texto2.setBounds(60, 40, 130, 20);
        pantalla.add(texto1);
        pantalla.add(texto2);
        add(pantalla);

        // Numeros
        PanelBotones panelBotones = new PanelBotones();
        add(panelBotones);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void actualizarTexto() {
        texto2.setText(String.valueOf(Init.expendedor.getDinero_total_ingresado()));
        repaint();
    }
}
