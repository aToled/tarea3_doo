package gui.Paneles;

import gui.Imagenes.ImagenNumero;
import gui.Imagenes.ImagenProducto;
import gui.utils.Init;
import logica.NoHayProductoException;
import logica.PagoIncorrectoException;
import logica.PagoInsuficienteException;
import logica.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * En este panel se muestran los botones del 1 al 6 para seleccionar el producto que se desea comprar
 */
public class PanelBotones extends JPanel {
    private PanelPrincipal panelPrincipal;
    private ArrayList<ImagenNumero> Botones = new ArrayList<>();
    private boolean productoRecogido = true;
    private boolean vueltoRecogido = true;

    /**
     * Se crean los 6 botones que al ser pulsados intentar realizar la compra de dicho producto
     * @param panelPrincipal
     */
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
                            if(!productoRecogido){
                                JOptionPane.showMessageDialog(Init.panelDeCompras.getPanelBotones(), "Recoja el producto antes de intentar comprar otro.", "Warning", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            productoRecogido = false;
                            vueltoRecogido = false;
                            Init.comprador.Comprar(productoABotar, Init.expendedor);
                            panelPrincipal.pExp.botarProducto();
                            panelPrincipal.invalidate();
                            panelPrincipal.repaint();
                            panelPrincipal.pdeCom.actualizarTexto();
                        } catch (NoHayProductoException ex) {
                            panelPrincipal.pdeCom.setTextoPantalla("No hay producto", "");
                            productoRecogido = true;
                            vueltoRecogido = true;
                        } catch (PagoIncorrectoException ex) {
                            panelPrincipal.pdeCom.setTextoPantalla("Pago Incorrecto", "");
                            productoRecogido = true;
                            vueltoRecogido = true;
                        } catch (PagoInsuficienteException ex) {
                            panelPrincipal.pdeCom.setTextoPantalla("Pago Insuficiente", "");
                            productoRecogido = true;
                            vueltoRecogido = true;
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
    public boolean isProductoRecogido() {
        return productoRecogido;
    }
    public boolean isVueltoRecogido() {
        return vueltoRecogido;
    }
    public void setProductoRecogido(boolean productoRecogido) {
        this.productoRecogido = productoRecogido;
    }
    public void setVueltoRecogido(boolean vueltoRecogido) {
        this.vueltoRecogido = vueltoRecogido;
    }
}
