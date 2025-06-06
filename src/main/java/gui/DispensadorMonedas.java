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
        setBounds(40, 480, 100, 300);

        this.panelMonedas = new JPanel();
        this.panelMonedas.setBackground(new Color(50,50,50));
        this.panelMonedas.setBounds(12,0,75,200);
        this.panelMonedas.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));

        // Área donde se recoge el vuelto dispensado.
        JButton botonRecogerVuelto = getBotonRecogerVuelto(panelPrincipal);

        add(panelMonedas);
        add(botonRecogerVuelto);
    }

    private JButton getBotonRecogerVuelto(PanelPrincipal panelPrincipal) {
        JButton botonRecogerVuelto = new JButton();
        botonRecogerVuelto.setBackground(Color.BLACK);
        botonRecogerVuelto.setBounds(0,225, 100, 75);
        botonRecogerVuelto.setToolTipText("Recoger Vuelto");
        botonRecogerVuelto.setBorderPainted(false);
        botonRecogerVuelto.setFocusPainted(false);
        botonRecogerVuelto.setContentAreaFilled(true);
        ToolTipManager.sharedInstance().registerComponent(botonRecogerVuelto);

        botonRecogerVuelto.addActionListener(e -> {
            Deposito<Moneda> vuelto_a_recoger = Boton_Dispensador_Vuelto.vuelto_a_recoger;
            if (vuelto_a_recoger!=null && !vuelto_a_recoger.isEmpty()) {
                System.out.println("\n--> Vuelto Recogido <--\n");
                Init.comprador.RecogerVuelto(vuelto_a_recoger);
                Init.panelDeCompras.panelBotones.vueltoRecogido = true;
                Init.panelComprador.repaint();
                Init.panelDeCompras.dispensadorMonedas.repaint();
            }
        });
        return botonRecogerVuelto;
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
