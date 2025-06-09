package gui.Paneles;

import gui.utils.Init;
import logica.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * En este panel se depositan los productos comprados para que el usuario pueda retirarlos.
 * No se pueden comprar más productos hasta que este depósito esté vacio
 * @see JPanel
 */
public class Panel_Recoleccion_Productos extends JPanel {
    /**
     * Si hay producto en bandeja el hacer click en el panel hara que el comprador reciba el producto
     */
    public Panel_Recoleccion_Productos() {
        setBackground(new Color(100, 100, 100));
        setBorder(BorderFactory.createLineBorder(Color.BLACK,20));
        setPreferredSize(new Dimension(0, 100));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(Init.expendedor.Hay_producto_en_Bandeja()){
                    Producto p = Init.expendedor.getProducto();
                    if(p!=null){
                        Init.comprador.Recoger_Producto(p);
                        Init.panelComprador.repaint();
                        Init.panelDeCompras.getPanelBotones().setProductoRecogido(true);
                        Init.panelDeCompras.getDispensadorMonedas().repaint();
                        repaint();
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
    }

    /**
     * Se renderiza como un rectángulo el cual en caso de tener un producto lo señalará con un texto
     * en el medio
     * @param g Objeto utilizado para renderizar
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (Init.expendedor.Hay_producto_en_Bandeja()) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString("Hay un producto para recoger!!!", 20, getHeight() / 2);
        } else {
            g.setColor(Color.LIGHT_GRAY);
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString("Haz clic para recoger si hay un producto.", 30, getHeight() / 2);
        }
    }
}
