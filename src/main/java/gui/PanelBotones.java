package gui;

import logica.Producto;
import logica.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelBotones extends JPanel {
    private PanelPrincipal panelPrincipal;

    private class ImagenNumeroMouseListener extends MouseAdapter {
        private Productos productoABotar;

        public ImagenNumeroMouseListener(Productos productoABotar) {
            this.productoABotar = productoABotar;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            panelPrincipal.pExp.botarProducto(productoABotar);
        }
    }

    public PanelBotones(PanelPrincipal panelPrincipal){
        this.panelPrincipal = panelPrincipal;

        setBackground(new Color(66, 66, 66));
        setBounds(20, 135, 150, 105);

        Productos[] productos = {Productos.COCA, Productos.SPRITE, Productos.FANTA, Productos.SNICKERS, Productos.SUPER8, Productos.CHOCMAN};
        //añade los numeros que identifican a los productos
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 2; col++) {
                int x = 35 + col * ImagenProducto.SIZE + col * 100;
                int y = 50 + fila * ImagenProducto.SIZE + fila * 100;
                x += ImagenProducto.SIZE/2 - ImagenNumero.SIZE/2;
                y += ImagenProducto.SIZE + 7;
                ImagenNumero num = new ImagenNumero(x, y,fila*2+col+1, new Color(66, 66, 66) ,Color.WHITE, Color.BLACK);
                ImagenNumeroMouseListener numMouseListener = new ImagenNumeroMouseListener(productos[fila*2+col]);
                num.addMouseListener(numMouseListener);
                add(num);
            }
        }
    }
}
