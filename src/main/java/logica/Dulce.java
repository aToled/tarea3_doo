package logica;
/**
 * Un Molde de dulce genérico que se almacena en un depósito y es comprado por un comprador.
 */
public abstract class Dulce extends Producto {

    /**
     * Método utilizado para crear distintos Dulces.
     * @see Producto
     */
    public Dulce(Productos producto) {
        super(producto);
    }
}
