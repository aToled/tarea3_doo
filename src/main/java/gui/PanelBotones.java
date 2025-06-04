package gui;

import logica.NoHayProductoException;
import logica.PagoIncorrectoException;
import logica.PagoInsuficienteException;
import logica.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelBotones extends JPanel {
    private PanelPrincipal panelPrincipal;
    private ArrayList<ImagenNumero> Botones = new ArrayList<>();

    private class ImagenNumeroMouseListener extends MouseAdapter {
        private Productos productoABotar;

        public ImagenNumeroMouseListener(Productos productoABotar) {
            this.productoABotar = productoABotar;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                Init.comprador.Comprar(productoABotar, Init.expendedor);
                panelPrincipal.pExp.botarProducto(productoABotar);
                panelPrincipal.pdeCom.setTextoPantalla("Vuelto", String.valueOf(Init.comprador.cuantoVuelto()));
                panelPrincipal.invalidate();
                panelPrincipal.repaint();

                if(Init.expendedor.Hay_producto_en_Bandeja()){
                    Init.panelDeCompras.panelBotones.activar_desactivarBotones(false);
                }

            } catch (NoHayProductoException ex) {
                panelPrincipal.pdeCom.setTextoPantalla("No hay producto", "");
            } catch (PagoIncorrectoException ex) {
                panelPrincipal.pdeCom.setTextoPantalla("Pago Incorrecto", "");
            } catch (PagoInsuficienteException ex) {
                panelPrincipal.pdeCom.setTextoPantalla("Pago Insuficiente", "");
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
                int x = 35 + col * ImagenProducto.SIZE + col * 100;
                int y = 50 + fila * ImagenProducto.SIZE + fila * 100;
                x += ImagenProducto.SIZE/2 - ImagenNumero.SIZE/2;
                y += ImagenProducto.SIZE + 7;
                ImagenNumero num = new ImagenNumero(x, y,fila*2+col+1, new Color(66, 66, 66) ,Color.WHITE, Color.BLACK);
                ImagenNumeroMouseListener numMouseListener = new ImagenNumeroMouseListener(productos[fila*2+col]);
                num.addMouseListener(numMouseListener);
                Botones.add(num);
                add(num);
            }
        }
    }

    public void activar_desactivarBotones(boolean estado){
        for(ImagenNumero i : Botones){
            i.setEnabled(estado);
            i.repaint();
        }
    }
}
