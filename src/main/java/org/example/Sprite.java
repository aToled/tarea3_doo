package org.example;
/**
 * Instancia de Bebida que representa una Sprite, puede ser comprada, almacenada y consumida.
 */
class Sprite extends Bebida {
    /**
     * @param numSerie: Valor único para identificar cada producto
     * @see Bebida
     */
    public Sprite(int numSerie) {
        super(numSerie);
    }

    /**
     * El comprador almacena este valor cuando consume el producto
     * @return String único que retorna este producto al consumirlo
     */
    public String consumir() {
        return "sprite";
    }
}