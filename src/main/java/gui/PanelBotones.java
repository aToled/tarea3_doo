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

                int finalFila = fila;
                int finalCol = col;
                num.addMouseListener(new MouseAdapter() {
                    private final Productos productoABotar = productos[finalFila *2+ finalCol];
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Init.comprador.Comprar(productoABotar, Init.expendedor);
                            panelPrincipal.pExp.botarProducto(productoABotar);
                            panelPrincipal.invalidate();
                            panelPrincipal.repaint();
                            panelPrincipal.pdeCom.actualizarTexto();

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
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }
                });

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
