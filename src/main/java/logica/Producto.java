package logica;
/**
 * Un Molde de producto genérico que se almacena en un depósito y es comprado por un comprador.
 */
public abstract class Producto {
    private final int serie;

    /**
     * Crea el Producto con un numero de serie al azar.
     */
    public Producto() {
        this.serie= (int) (Math.random()*1000000);;
    }

    /**
     * Comprador almacena el string retornado por esta clase cada vez que consume
     * el producto
     * @return String único que cada producto debe especificar
     */
    public abstract String consumir();

    /**
     * @return Número único para identificar cada producto
     */
    public int getSerie() {
        return serie;
    }
}
