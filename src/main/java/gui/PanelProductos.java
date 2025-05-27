package gui;

import logica.Productos;

import javax.swing.*;
import java.awt.*;

public class PanelProductos extends JPanel {
    private class PanelProducto extends JPanel {
        private int x;
        private int y;
        static final int ANCHO = 150;
        static final int ALTO = 200;
        private int startY;
        private final Productos producto;

        public PanelProducto(int x, int y, Productos producto) {
            this.x = x;
            this.y = y;
            this.startY = y;
            this.producto = producto;

            setSize(new Dimension(ANCHO, ALTO));
            setBackground(new Color(0, 155, 150));

            setBounds(x, y, ANCHO, ALTO);
        }
    }

    public PanelProducto crearPanelProducto(int fila, int columna, Productos producto) {
        int x = 30 + PanelProducto.ANCHO * (columna) + 15 * columna;
        int y = 30 + PanelProducto.ALTO * (fila) + 15 * fila;

        return new PanelProducto(x, y, producto);
    }

    public PanelProductos() {
        setBackground(new Color(215, 215, 215));
        setLayout(null);

        add(crearPanelProducto(0, 0, Productos.COCA));
        add(crearPanelProducto(0, 1, Productos.SPRITE));
        add(crearPanelProducto(0, 2, Productos.FANTA));
        add(crearPanelProducto(1, 0, Productos.SNICKERS));
        add(crearPanelProducto(1, 1, Productos.SUPER8));
    }
}
