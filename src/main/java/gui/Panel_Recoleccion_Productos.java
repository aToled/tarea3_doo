package gui;

import logica.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel_Recoleccion_Productos extends JPanel {
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
                        Init.panelDeCompras.panelBotones.productoRecogido = true;
                        Init.panelDeCompras.dispensadorMonedas.repaint();
                        repaint();
                    }
                }
            }
        });
    }
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
