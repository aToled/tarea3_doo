package org.example;
/**
 * Un Molde de producto genérico que se almacena en un depósito y es comprado por un comprador.
 */
public abstract class Producto {
    private final int serie;

    /**
     * @param numSerie: Valor único para identificar cada producto
     */
    public Producto(int numSerie) {
        this.serie = numSerie;
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
