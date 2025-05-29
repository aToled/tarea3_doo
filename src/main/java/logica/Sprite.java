package logica;
/**
 * Instancia de Bebida que representa una Sprite, puede ser comprada, almacenada y consumida.
 */
class Sprite extends Bebida {
    /**
     * @see Bebida
     */
    public Sprite() {
        super();
    }

    /**
     * El comprador almacena este valor cuando consume el producto
     * @return String único que retorna este producto al consumirlo
     */
    public String consumir() {
        return "sprite";
    }
}