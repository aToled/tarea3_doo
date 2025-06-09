package gui.Paneles;

import gui.Imagenes.ImagenNumero;
import gui.Imagenes.ImagenProducto;
import gui.utils.*;
import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
/**
 * Clase principal que representa la vitrina de productos del expendedor,
 * la cual organiza visualmente los productos y controla la animación de salida de uno de ellos.
 */
public class PanelExpendedor extends JPanel {
    private PanelPrincipal panelPrincipal;

    /**
     * Se renderizan los productos con el número que los identifica ademas del precio
     * @param panelPrincipal
     */
    public PanelExpendedor(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;

        setOpaque(false);
        setLayout(null);

        Productos[] productos = {Productos.COCA, Productos.FANTA, Productos.SPRITE, Productos.SNICKERS, Productos.SUPER8, Productos.CHOCMAN};
        //añade los numeros que identifican a los productos
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 2; col++) {
                int x = 35 + col * ImagenProducto.SIZE + col * 100;
                int y = 50 + fila * ImagenProducto.SIZE + fila * 100;
                x += ImagenProducto.SIZE/2 - ImagenNumero.SIZE/2;
                y += ImagenProducto.SIZE + 7;
                ImagenNumero num = new ImagenNumero(x, y, fila*2+col+1, new Color(178, 178, 178), Color.BLACK, Color.WHITE);
                JLabel label = new JLabel("$" + productos[fila*2+col].precio);
                label.setFont(new Font("Serif", Font.BOLD, 14));
                label.setFont(label.getFont());
                label.setBounds(x+50, y+10, 50, 25);
                add(num);
                add(label);
            }
        }

        agregarProductos(Productos.COCA    , 0, 0);
        agregarProductos(Productos.SPRITE  , 0, 1);
        agregarProductos(Productos.FANTA   , 1, 0);
        agregarProductos(Productos.SNICKERS, 1, 1);
        agregarProductos(Productos.SUPER8  , 2, 0);
        agregarProductos(Productos.CHOCMAN , 2, 1);

    }

    /**
     * Si existe el producto solicitado se iniciará una animación para botarlo.
     */
    public void botarProducto() {
        Producto p = Init.expendedor.getProductoComprado();
        if(p==null) return;

        this.reagregarProductos(p.cualProducto, p.fila, p.columna);

        p.establecerPosicion(p.fila, p.columna, 0);
        p.setBounds(p.x, p.y, ImagenProducto.SIZE, ImagenProducto.SIZE);

        add(p);
        setComponentZOrder(p, 0);
        revalidate();
        repaint();

        Animacion a = new Animacion(panelPrincipal, p);
        a.iniciarOContinuarMovimiento();
    }

    /**
     * Se renderizan los productos indicados por el tipo y posición (fila, columna)
     * @param producto: Tipo de producto que se desea renderizar
     * @param fila: Fila en la que se va a renderizar el producto
     * @param columna: Columna en la que se va a renderizar el producto
     */
    private void agregarProductos(Productos producto, int fila, int columna){
        ArrayList<Producto> productos = getProductos(producto);

        if (productos == null) return;

        int X = 35 + columna * ImagenProducto.SIZE + columna * 100;
        int Y = 50 + fila * ImagenProducto.SIZE + fila * 100;

        // Cuantos productos del Depósito son visibles.
        int P_vissibles = Math.min(productos.size(), 6);

        // Dibuja los productos de atras a adelante.
        for(int i=0; i<P_vissibles; i++){
            Producto p = productos.get(i);
            p.setBounds(X,Y,ImagenProducto.SIZE,ImagenProducto.SIZE);
            p.establecerPosicion(fila,columna,i);
            p.setName("producto_"+producto+"_"+fila+"_"+columna);
            add(p);
        }
    }

    /**
     * Se eliminan los productos señalados (si es que hay) y se vuelven a agregar productos nuevamente
     * @param producto: Tipo de producto a reagregar
     * @param fila: Fila en la que se encuentra el producto
     * @param columna: Columna en la que se encuentra el producto
     */
    public void reagregarProductos(Productos producto, int fila, int columna){
        String nombre = "producto_"+producto+"_"+fila+"_"+columna;

        // Elimina todos los productos en esa posición
        Component[] components = getComponents();
        for (int i=components.length-1;i>=0;i--) {
            if (components[i].getName()!=null&&components[i].getName().startsWith(nombre)) {
                remove(components[i]);
            }
        }
        // Vuelve a agregarlos
        agregarProductos(producto, fila, columna);
        repaint();
    }

    /**
     * Retorna los productos disponibles del tipo señalado
     * @param producto: Tipo de producto al que se quiere obtener
     * @return Un arrayList de los productos indicados
     */
    private static ArrayList<Producto> getProductos(Productos producto) {
        ArrayList<Producto> productos = null;

        switch (producto) {
            case COCA -> productos = Init.expendedor.getCoca().getRef();
            case SPRITE -> productos = Init.expendedor.getSprite().getRef();
            case FANTA -> productos = Init.expendedor.getFanta().getRef();
            case SNICKERS -> productos = Init.expendedor.getSnickers().getRef();
            case SUPER8 -> productos = Init.expendedor.getSuper8().getRef();
            case CHOCMAN -> productos = Init.expendedor.getChocman().getRef();
        }
        return productos;
    }

    /**
     * Se renderiza con un borde redondo y se pinta de color gris claro el interior.
     * Dentro se muestran los productos con su número identificador ademas del precio
     * @param g Objeto utilizado para renderizar
     */
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

        g2d.dispose(); // Liberar los recursos del objeto Graphics2D
    }
}
