package logica;
/**
 * Instancia de Bebida que representa una Fanta, puede ser comprada, almacenada y consumida.
 */
class Fanta extends Bebida {

    /**
     * @see Bebida
     */
    public Fanta() {
        super();
    }

    /**
     * El comprador almacena este valor cuando consume el producto
     * @return String único que retorna este producto al consumirlo
     */
    public String consumir() {
        return "fanta";
    }
}