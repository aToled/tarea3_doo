package gui;

import logica.*;

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
            try{
                Init.comprador.Comprar(productoABotar, Init.expendedor);
                System.out.println("Producto comprado: " + productoABotar);
                panelPrincipal.pExp.botarProducto(productoABotar);
            }catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException ex){
                System.out.println("Error en la compra: " + ex.getMessage());
                System.out.println("Inserte otra moneda, o elija otro producto");
            }
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
                ImagenNumero num = getImagenNumero(col, fila, productos);
                add(num);
            }
        }
    }

    private ImagenNumero getImagenNumero(int col, int fila, Productos[] productos) {
        int x = 35 + col * ImagenProducto.SIZE + col * 100;
        int y = 50 + fila * ImagenProducto.SIZE + fila * 100;
        x += ImagenProducto.SIZE/2 - ImagenNumero.SIZE/2;
        y += ImagenProducto.SIZE + 7;

        ImagenNumero num = new ImagenNumero(x, y, fila *2+ col +1, new Color(66, 66, 66) ,Color.WHITE, Color.BLACK);
        ImagenNumeroMouseListener numMouseListener = new ImagenNumeroMouseListener(productos[fila *2+ col]);
        num.addMouseListener(numMouseListener);
        return num;
    }
}
