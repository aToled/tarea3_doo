package logica;
/**
 * Instancia de Dulce que representa un Snickers, puede ser comprado, almacenado y consumido.
 */
public class Snickers extends Dulce {

    /**
     * @see Dulce
     */
    public Snickers() {
        super(Productos.SNICKERS);
    }

    /**
     * El comprador almacena este valor cuando consume el producto
     * @return String único que retorna este producto al consumirlo
     */
    public String consumir() { return "snickers"; }
}
