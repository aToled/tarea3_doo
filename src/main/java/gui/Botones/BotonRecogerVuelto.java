package gui.Botones;

import gui.Paneles.PanelPrincipal;
import gui.utils.Init;
import logica.Deposito;
import logica.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A través de este botón el comprador recibe el vuelto de haber realizado una compra.
 * @see JButton
 */
public class BotonRecogerVuelto extends JButton {
    private final PanelPrincipal panelPrincipal;

    /**
     * Si hay vuelto en monedas el comprador las recibirá y serán quitadas del dispensador.
     * @param panelPrincipal:
     */
    public BotonRecogerVuelto(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        setBackground(Color.BLACK);
        setBounds(0, 225, 100, 75);
        setToolTipText("Recoger Vuelto");
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(true);
        ToolTipManager.sharedInstance().registerComponent(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Deposito<Moneda> vuelto_a_recoger = Boton_Dispensador_Vuelto.getVuelto_a_recoger();
                if (vuelto_a_recoger != null && !vuelto_a_recoger.isEmpty()) {
                    System.out.println("\n--> Vuelto Recogido <--\n");
                    Init.comprador.RecogerVuelto(vuelto_a_recoger);
                    Init.panelDeCompras.getPanelBotones().setVueltoRecogido(true);
                    Init.panelComprador.repaint();
                    Init.panelDeCompras.getDispensadorMonedas().repaint();
                    Init.panelDeCompras.actualizarTexto();
                    panelPrincipal.pdeCom.getBotonDispensadorVuelto().setVueltoDispensado(false);
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
     * Se renderiza como un cuadrado gris y si hay vuelto por recoger
     * se indicará con un texto en el centro.
     * @param g Objeto utilizado para renderizar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.GRAY);
        g2.fillRect(10, 60, getWidth()-20, getHeight()-65);

        if (panelPrincipal.pdeCom.getBotonDispensadorVuelto().isVueltoDispensado()) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 13));
            g.drawString("Hay vuelto", 10, getHeight() / 3);
            g.drawString("para recoger!", 10, (getHeight() / 3)+15);
        }
    }
}