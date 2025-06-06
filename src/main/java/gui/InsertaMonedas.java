package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InsertaMonedas extends JPanel{
    PanelPrincipal panelPrincipal;
    public static boolean ventanaAbierta = false;

    public InsertaMonedas(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        setBackground(Color.BLACK);
        setBounds(20, 280, 25, 125);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                boolean productoRecogido = Init.panelDeCompras.panelBotones.productoRecogido;
                boolean vueltoRecogido = Init.panelDeCompras.panelBotones.vueltoRecogido;
                if (!productoRecogido || !vueltoRecogido) return;

                if (ventanaAbierta) return;
                ventanaAbierta = true;

                VentanaIngresarMoneda ventanaIngresarMoneda = new VentanaIngresarMoneda();
                ventanaIngresarMoneda.mostrar();
                Init.panelDeCompras.actualizarTexto();
                Init.panelDeCompras.dispensadorMonedas.repaint();
            }
        });
    }
}
