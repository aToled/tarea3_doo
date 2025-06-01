package gui;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Map;

/**
 * Clase principal que representa la vitrina de productos del expendedor,
 * la cual organiza visualmente los productos y controla la animación de salida de uno de ellos.
 */
public class PanelExpendedor extends JPanel {
    private PanelPrincipal panelPrincipal;
    private Expendedor expendedor;
    private MapProductos mapProductos = new MapProductos();

    public PanelExpendedor(PanelPrincipal panelPrincipal, Expendedor expendedor) {
        this.panelPrincipal = panelPrincipal;
        this.expendedor = expendedor;

        setOpaque(false);
        setLayout(null);

        //añade los numeros que identifican a los productos
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 2; col++) {
                int x = 35 + col * ImagenProducto.SIZE + col * 100;
                int y = 50 + fila * ImagenProducto.SIZE + fila * 100;
                x += ImagenProducto.SIZE/2 - ImagenNumero.SIZE/2;
                y += ImagenProducto.SIZE + 7;
                ImagenNumero num = new ImagenNumero(x, y, fila*2+col+1);
                add(num);
            }
        }

        agregarProductosFila(Productos.COCA,0,0,true);
        agregarProductosFila(Productos.SPRITE,0,1,false);
        agregarProductosFila(Productos.FANTA,1,0,false);
        agregarProductosFila(Productos.SNICKERS,1,1,false);
        agregarProductosFila(Productos.SUPER8,2,0,false);
        agregarProductosFila(Productos.CHOCMAN,2,1,false);

    }

    /**TODO poner mas info
     * Agrega una fila de productos diagonalmente a la vitrina y inicia o continua el movi
     * @param producto: Tipo de producto a agregar.
     * @param fila:
     * @param columna:
     * @param animar: Indica si deberia o no iniciar la animacion de caida del primer elemento.
     */

    public void botarProducto(Productos producto) {
        //setComponentZOrder(producto,0);
        System.out.println("Animacion");
        switch (producto) {
            case COCA -> {
                Producto p = mapProductos.get(Productos.COCA).remove(0);
                setComponentZOrder(p,0);
                Animacion a = new Animacion(panelPrincipal, p);
                a.iniciarOContinuarMovimiento();
            }
            case SPRITE -> {
            }
            case FANTA -> {
            }
            case SNICKERS -> {
            }
            case SUPER8 -> {
            }
            case CHOCMAN -> {
            }
            case NULO -> {
            }
        }
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

    private void agregarProductosFila(Productos producto, int fila, int columna, boolean animar){
        Producto producto_que_caera=null;
        switch (producto) {
            case COCA -> {
                Producto p = expendedor.coca.get();
                while (p != null) {
                    p.establecerPosicion(fila, columna, 4 - expendedor.coca.size());
                    add(p);
                    mapProductos.get(Productos.COCA).add(p);

                    p = expendedor.coca.get();
                }
            }
            case SPRITE -> {
                Producto p = expendedor.sprite.get();
                while (p != null) {
                    p.establecerPosicion(fila, columna, 4 - expendedor.sprite.size());
                    add(p);
                    mapProductos.get(Productos.SPRITE).add(p);

                    p = expendedor.sprite.get();
                }
            }
            case FANTA -> {
                Producto p = expendedor.fanta.get();
                while (p != null) {
                    p.establecerPosicion(fila, columna, 4 - expendedor.fanta.size());
                    add(p);
                    mapProductos.get(Productos.FANTA).add(p);

                    p = expendedor.fanta.get();
                }
            }
            case SNICKERS -> {
                Producto p = expendedor.snickers.get();
                while (p != null) {
                    p.establecerPosicion(fila, columna, 4 - expendedor.snickers.size());
                    add(p);
                    mapProductos.get(Productos.SNICKERS).add(p);

                    p = expendedor.snickers.get();
                }
            }
            case SUPER8 -> {
                Producto p = expendedor.super8.get();
                while (p != null) {
                    p.establecerPosicion(fila, columna, 4 - expendedor.super8.size());
                    add(p);
                    mapProductos.get(Productos.SUPER8).add(p);

                    p = expendedor.super8.get();
                }
            }
            case CHOCMAN -> {
                Producto p = expendedor.chocman.get();
                while (p != null) {
                    p.establecerPosicion(fila, columna, 4 - expendedor.chocman.size());
                    add(p);
                    mapProductos.get(Productos.CHOCMAN).add(p);

                    p = expendedor.chocman.get();
                }
            }
        }
//        for (int i = 0; i < 5; i++) {
//            Producto p = crearProducto(producto);
//            if (p == null) continue;
//            p.establecerPosicion(fila, columna, i);
//            add(p);
//
//            if (animar&&i == 0) {
//                producto_que_caera = p;
//            }
//        }
        //Mueve el producto que va a caer a la capa frontal.
//        if(producto_que_caera!=null){
//            setComponentZOrder(producto_que_caera,0);
//            System.out.println("Animacion");
//            Animacion a = new Animacion(producto_que_caera);
//            a.iniciarOContinuarMovimiento();
//        }
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

        // Franja cuyo proposito es hacer 'Desaparecer' el producto cuando cae.
        JPanel franja_invisible = new JPanel();
        franja_invisible.setBackground(new Color(66,66,66));
        franja_invisible.setBounds(borde_izquierdo, 760, borde_derecho, 900);
        add(franja_invisible);
        setComponentZOrder(franja_invisible, 0);

        g2d.dispose(); // Liberar los recursos del objeto Graphics2D
    }
}
