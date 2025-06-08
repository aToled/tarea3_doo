package gui.Botones;

import gui.Paneles.PanelPrincipal;
import gui.utils.Init;
import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Este botón se utiliza para indicar al dispensador que suelte las monedas destinadas
 * como vuelto para el comprador. Estas monedas luego podrán ser agarradas por el
 * comprador desde BotonRecogerVuelto
 * @see BotonRecogerVuelto
 */
public class Boton_Dispensador_Vuelto extends JButton {
    private static Deposito<Moneda> vuelto_a_recoger;
    private boolean VueltoDispensado = false;

    /**
     * AL pulsar este botón se traspasará el vuelto hacia 'vuelto_a_recoger'
     * @param panelPrincipal
     */
    public Boton_Dispensador_Vuelto(PanelPrincipal panelPrincipal){
        setBounds(50, 430, 30, 30);
        setToolTipText("dispensar vuelto");
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        ToolTipManager.sharedInstance().registerComponent(this);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Init.expendedor.getDinero_total_ingresado() != 0){
                    System.out.println("\n--> Dinero Dispensado <--\n");
                    VueltoDispensado = true;
                    vuelto_a_recoger = Init.expendedor.vaciarVuelto();
                    panelPrincipal.pdeCom.actualizarTexto();
                    Init.panelDeCompras.getDispensadorMonedas().repaint();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    /**
     * Se renderiza como un círculo negro
     * @param g Objeto utilizado para graficar
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillOval(0, 0, getWidth(), getHeight());
    }

    public static Deposito<Moneda> getVuelto_a_recoger() {
        return vuelto_a_recoger;
    }

    public boolean isVueltoDispensado() {
        return VueltoDispensado;
    }

    public void setVueltoDispensado(boolean vueltoDispensado) {
        VueltoDispensado = vueltoDispensado;
    }
}
