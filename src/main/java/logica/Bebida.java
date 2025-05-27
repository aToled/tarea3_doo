package logica;
/**
 * Un Molde de bebida genérica que se almacena en un depósito y es comprada por un comprador.
 */
abstract class Bebida extends Producto {
    /**
     * Método utilizado para diferenciar distintas Bebidas.
     * @param numSerie: Valor único para identificar cada producto
     * @see Producto
     * @see Dulce
     */
    public Bebida(int numSerie) {
        super(numSerie);
    }
}