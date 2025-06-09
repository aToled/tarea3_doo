package logica;
/**
 * Instancia de Bebida que representa una Sprite, puede ser comprada, almacenada y consumida.
 */
public class Sprite extends Bebida {
    /**
     * @see Bebida
     */
    public Sprite() {
        super(Productos.SPRITE);
    }

    /**
     * El comprador almacena este valor cuando consume el producto.
     * @return String único que retorna este producto al consumirlo.
     */
    public String consumir() {
        return "sprite";
    }
}