package gui;

import logica.*;

import javax.swing.*;
import java.awt.*;

public class DispensadorMonedas extends JPanel {
    PanelPrincipal panelPrincipal;

    /**
     * Se encarga de mostrar las monedas dadas de vuelto al comprador
     * @param panelPrincipal: Referencia a panel principal para poder re-pintar en caso de ser necesario
     */
    public DispensadorMonedas(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        setBackground(new Color(66, 66, 66));
        setLayout(null);
        setBounds(40, 480, 100, 300);

        // Área donde se muestra el depósito de monedas del expendedor MonVu.
        JPanel panelMonedas = new JPanel();
        panelMonedas.setBackground(new Color(50,50,50));
        panelMonedas.setBounds(12,0,75,200);
        panelMonedas.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));

        // Área donde se recoge el vuelto dispensado.
        JButton botonRecogerVuelto = getBotonRecogerVuelto(panelPrincipal);


        ///int size = expendedor.monedas_compras_exitosas.size();
        ///for (int i = 0; i < size; i++) {
        ///    Moneda m = expendedor.monedas_compras_exitosas.get();
        ///    ImagenMoneda imagenMoneda = new ImagenMoneda(m);
        ///    panelMonedas.add(imagenMoneda);
        ///    if (50*i <= 300) {
        ///        imagenMoneda.setBounds(12, 50 * i, 50, 50);
        ///    }
        ///}

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
                System.out.println("Vuelto Recogido");
                Init.comprador.RecogerVuelto(vuelto_a_recoger);
                Init.panelComprador.repaint();
            }
        });
        return botonRecogerVuelto;
    }
}
