package logica;
/**
 * Instancia de Bebida que representa una Fanta, puede ser comprada, almacenada y consumida.
 */
class Fanta extends Bebida {
    /**
     * @param numSerie: Valor único para identificar cada producto
     * @see Bebida
     */
    public Fanta(int numSerie) {
        super(numSerie);
    }

    /**
     * El comprador almacena este valor cuando consume el producto
     * @return String único que retorna este producto al consumirlo
     */
    public String consumir() {
        return "fanta";
    }
}