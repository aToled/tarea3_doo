package logica;
/**
 * Instancia de Bebida que representa una Coca Cola, puede ser comprada, almacenada y consumida.
 */
class CocaCola extends Bebida {

    /**
     * @see Bebida
     */
    public CocaCola() {
        super();
    }

    /**
     * El comprador almacena este valor cuando consume el producto.
     * @return String único que retorna este producto al consumirlo
     */
    public String consumir() {
        return "coca cola";
    }
}