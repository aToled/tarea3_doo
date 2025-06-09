package gui.Paneles;

import gui.Botones.BotonRecogerVuelto;
import gui.Imagenes.ImagenMoneda;
import gui.utils.Init;
import logica.Moneda;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Este panel muestra las monedas que se quedan en el expendedor después de una compra exitosa.
 * @see JPanel
 */
public class PanelDepositoComprasExitosas extends JPanel {
    private PanelPrincipal panelPrincipal;
    private final JPanel panelMonedas;
    private BotonRecogerVuelto botonRecogerVuelto;

    /**
     * Se encarga de mostrar las monedas de las compras exitosas.
     * @param panelPrincipal: Referencia a panel principal para poder re-pintar en caso de ser necesario.
     */
    public PanelDepositoComprasExitosas(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        setBackground(new Color(66, 66, 66));
        setLayout(null);
        setBounds(25, 325, 150, 425);

        JLabel textoDeposito = new JLabel("Monedas Compras Exitosas");
        textoDeposito.setForeground(Color.WHITE);
        textoDeposito.setBounds(20, 290, 175, 15);
        this.panelMonedas = new JPanel();
        this.panelMonedas.setBackground(new Color(50,50,50));
        this.panelMonedas.setBounds(25,325,150,425);
        this.panelMonedas.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));

        add(textoDeposito);
        add(panelMonedas);
    }

    /**
     * Se renderiza como un rectángulo que contiene elementos de ImagenMoneda en su interior.
     * @param g Objeto utilizado para renderizar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.panelMonedas.removeAll();
        ArrayList<Moneda> monedas = Init.expendedor.getMonedas_compras_exitosas().getRef();
        int maxMonedas = Math.min(27, monedas.size());
        for (int i=0; i<maxMonedas; i++) {
            Moneda m = monedas.get(i);
            ImagenMoneda imagenMoneda = new ImagenMoneda(m,40);
            panelMonedas.add(imagenMoneda);
            imagenMoneda.setBounds(6, 25*i, 40, 40);
        }
        this.panelMonedas.repaint();
        this.panelMonedas.revalidate();
    }
}