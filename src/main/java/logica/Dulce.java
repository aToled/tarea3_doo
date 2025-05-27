package logica;
/**
 * Un Molde de dulce genérico que se almacena en un depósito y es comprado por un comprador.
 */
public abstract class Dulce extends Producto {
    /**
     * @param numSerie: Valor único para identificar cada producto.
     * @see Producto
     */
    public Dulce(int numSerie) {
        super(numSerie);
    }
}
