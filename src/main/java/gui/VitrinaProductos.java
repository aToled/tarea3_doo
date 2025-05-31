package gui;

import logica.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
/**
 * Clase principal que representa la vitrina de productos del expendedor,
 * la cual organiza visualmente los productos y controla la animación de salida de uno de ellos.
 */
public class VitrinaProductos extends JPanel {

    public VitrinaProductos() {
        //setBackground(new Color(150, 150, 150));
        //setBorder(new BordeRedondo(100));
        setOpaque(false);
        setLayout(null);

        //añade los numeros que identifican a los productos
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 2; col++) {
                int x = 35 + col * ImagenProducto.SIZE + col * 100;
                int y = 100 + fila * ImagenProducto.SIZE + fila * 100;
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
        for (int i = 0; i < 5; i++) {
            ImagenProducto p = new ImagenProducto(producto);
            p.establecerPosicion(fila, columna, i);
            add(p);

            if (animar&&i == 0) {
                Animacion a = new Animacion(p);
                a.iniciarOContinuarMovimiento();
            }
        }
    }

    // Se crea un borde redondo y se pinta de color gris claro el interior
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create(); // Objeto utilizado para pintar

        // Antialiasing hace los bordes más suaves
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth();
        int alto = getHeight();

        // Se crea el borde
        Shape formaRedondeada = new RoundRectangle2D.Double(0, 0, ancho, alto, 50, 50);

        // Color de fondo (dentro de los bordes)
        g2d.setColor(new Color(178, 178, 178));
        g2d.fill(formaRedondeada);

        g2d.dispose(); // Liberar los recursos del objeto Graphics2D
    }
}
