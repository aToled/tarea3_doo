package logica;
/**
 * Un Molde de bebida genérica que se almacena en un depósito y es comprada por un comprador.
 */
abstract class Bebida extends Producto {

    /**
     * Método utilizado para crear distintas Bebidas.
     * @see Producto
     */
    public Bebida(Productos producto) {
        super(producto);
    }
}