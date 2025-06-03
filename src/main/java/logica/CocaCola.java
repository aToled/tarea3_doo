package logica;
/**
 * Instancia de Bebida que representa una Coca Cola, puede ser comprada, almacenada y consumida.
 */
public class CocaCola extends Bebida {

    /**
     * @see Bebida
     */
    public CocaCola() {
        super(Productos.COCA);
    }

    /**
     * El comprador almacena este valor cuando consume el producto.
     * @return String único que retorna este producto al consumirlo
     */
    public String consumir() {
        return "coca cola";
    }
}