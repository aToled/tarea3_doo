package org.example;
/**
 * Instancia de Bebida que representa una Coca Cola, puede ser comprada, almacenada y consumida.
 */
class CocaCola extends Bebida {
    /**
     * @param numSerie: Valor único para identificar cada producto.
     * @see Bebida
     */
    public CocaCola(int numSerie) {
        super(numSerie);
    }

    /**
     * El comprador almacena este valor cuando consume el producto.
     * @return String único que retorna este producto al consumirlo
     */
    public String consumir() {
        return "coca cola";
    }
}