package gui;

import logica.Expendedor;
import logica.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
/**
 * Clase principal que representa la vitrina de productos del expendedor,
 * la cual organiza visualmente los productos y controla la animación de salida de uno de ellos.
 */
public class PanelExpendedor extends JPanel {
    private PanelPrincipal panelPrincipal;

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
    private void agregarProductosFila(Productos producto, int fila, int columna, boolean animar){
        ImagenProducto producto_que_caera=null;
        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(producto);
            p.establecerPosicion(fila, columna, i);
            add(p);

            if (animar&&i == 0) {
                producto_que_caera = p;
            }
        }
        //Mueve el producto que va a caer a la capa frontal.
        if(producto_que_caera!=null){
            setComponentZOrder(producto_que_caera,0);
            System.out.println("Animacion");
            Animacion a = new Animacion(producto_que_caera);
            a.iniciarOContinuarMovimiento();
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

        // Franja cuyo proposito es hacer 'Desaparecer' el producto cuando cae.
        JPanel franja_invisible = new JPanel();
        franja_invisible.setBackground(new Color(66,66,66));
        franja_invisible.setBounds(borde_izquierdo, 760, borde_derecho, 900);
        add(franja_invisible);
        setComponentZOrder(franja_invisible, 0);

        g2d.dispose(); // Liberar los recursos del objeto Graphics2D
    }
}
