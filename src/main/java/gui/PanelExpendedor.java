package gui;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/**
 * Clase principal que representa la vitrina de productos del expendedor,
 * la cual organiza visualmente los productos y controla la animación de salida de uno de ellos.
 */
public class PanelExpendedor extends JPanel {
    private PanelPrincipal panelPrincipal;
    private MapProductos mapProductos = new MapProductos();

    public PanelExpendedor(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        setOpaque(false);
        setLayout(null);

        //añade los numeros que identifican a los productos
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 2; col++) {
                int x = 35 + col * ImagenProducto.SIZE + col * 100;
                int y = 50 + fila * ImagenProducto.SIZE + fila * 100;
                x += ImagenProducto.SIZE/2 - ImagenNumero.SIZE/2;
                y += ImagenProducto.SIZE + 7;
                ImagenNumero num = new ImagenNumero(x, y, fila*2+col+1, new Color(178, 178, 178), Color.BLACK, Color.WHITE);
                add(num);
            }
        }

        agregarProductos(Productos.COCA    , 0, 0);
        agregarProductos(Productos.SPRITE  , 0, 1);
        agregarProductos(Productos.FANTA   , 1, 0);
        agregarProductos(Productos.SNICKERS, 1, 1);
        agregarProductos(Productos.SUPER8  , 2, 0);
        agregarProductos(Productos.CHOCMAN , 2, 1);

    }

    /**TODO poner mas info
     * Agrega una fila de productos diagonalmente a la vitrina y inicia o continua el movi
     * @param producto: Tipo de producto a agregar.
     */
    public void botarProducto(Productos producto) {
        //setComponentZOrder(producto,0);
        Producto p = null;

        switch (producto) {
            case COCA -> p = (Producto)mapProductos.get(Productos.COCA).get();
            case SPRITE -> p = (Producto)mapProductos.get(Productos.SPRITE).get();
            case FANTA -> p = (Producto)mapProductos.get(Productos.FANTA).get();
            case SNICKERS -> p = (Producto)mapProductos.get(Productos.SNICKERS).get();
            case SUPER8 -> p = (Producto)mapProductos.get(Productos.SUPER8).get();
            case CHOCMAN -> p = (Producto)mapProductos.get(Productos.CHOCMAN).get();
            case NULO -> {}
        }

        if (p == null) return;
        setComponentZOrder(p,0);
        Animacion a = new Animacion(panelPrincipal, p);
        a.iniciarOContinuarMovimiento();
    }

    private Producto crearProducto(Productos producto) {
        switch (producto) {
            case COCA -> { return new CocaCola(); }
            case SPRITE -> { return new Sprite(); }
            case FANTA -> { return new Fanta(); }
            case SNICKERS -> { return new Snickers(); }
            case SUPER8 -> { return new Super8(); }
            case CHOCMAN -> { return new Chocman(); }
            case NULO -> { return null; }
        }
        return null;
    }

    private void agregarProductos(Productos producto, int fila, int columna){
        ArrayList<Producto> productos = null;

        switch (producto) {
            case COCA -> productos = Init.expendedor.coca.getRef();
            case SPRITE -> productos = Init.expendedor.sprite.getRef();
            case FANTA -> productos = Init.expendedor.fanta.getRef();
            case SNICKERS -> productos = Init.expendedor.snickers.getRef();
            case SUPER8 -> productos = Init.expendedor.super8.getRef();
            case CHOCMAN -> productos = Init.expendedor.chocman.getRef();
        }

        if (productos == null) return;

        int size = productos.size();
        for (Producto p : productos) {
            p.establecerPosicion(fila, columna, Init.MAX_PRODUCTOS_POR_DEPOSITO - size);
            add(p);
        }
    }

    // Se crea un borde redondo y se pinta de color gris claro el interior
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create(); // Objeto utilizado para pintar

        // Antialiasing hace los bordes más suaves
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int borde_derecho = getWidth()-20;
        int borde_izquierdo = 10;
        int borde_inferior = getHeight()-55;
        int borde_superior = 25;

        // Se crea el borde
        Shape formaRedondeada = new RoundRectangle2D.Double(borde_izquierdo, borde_superior, borde_derecho, borde_inferior, 50, 50);

        // Color de fondo (dentro de los bordes)
        g2d.setColor(new Color(178, 178, 178));
        g2d.fill(formaRedondeada);

        // Franja cuyo propósito es hacer 'Desaparecer' el producto cuando cae.
        JPanel franja_invisible = new JPanel();
        franja_invisible.setBackground(new Color(66,66,66));
        franja_invisible.setBounds(borde_izquierdo, 760, borde_derecho, 900);
        add(franja_invisible);
        setComponentZOrder(franja_invisible, 0);

        g2d.dispose(); // Liberar los recursos del objeto Graphics2D
    }
}
