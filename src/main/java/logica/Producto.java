package logica;
/**
 * Un Molde de producto genérico que se almacena en un depósito y es comprado por un comprador.
 */
public abstract class Producto {
    private final int serie;
    public Productos cualProducto;

    /**
     * Crea el Producto con un numero de serie al azar.
     */
    public Producto(Productos producto) {
        this.serie= (int) (Math.random()*1000000);
        this.cualProducto = producto;
    }

    /**
     * Comprador almacena el string retornado por esta clase cada vez que consume
     * el producto.
     * @return String único que cada producto debe especificar.
     */
    public abstract String consumir();

    /**
     * @return Número único para identificar cada producto.
     */
    public int getSerie() {
        return serie;
    }

    /**
     * @return el Tipo de Producto.
     */
    public Productos getCualProducto() {
        return cualProducto;
    }
}
