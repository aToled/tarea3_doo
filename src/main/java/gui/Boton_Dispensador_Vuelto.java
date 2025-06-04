package gui;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Boton_Dispensador_Vuelto extends JButton {
    public static Deposito<Moneda> vuelto_a_recoger;
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
                    System.out.println("Dinero Dispensado.");
                    vuelto_a_recoger = Init.expendedor.vaciarVuelto();
                    panelPrincipal.pdeCom.actualizarTexto();
                    Init.panelDeCompras.dispensadorMonedas.repaint();
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

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillOval(0, 0, getWidth(), getHeight());
    }
}
