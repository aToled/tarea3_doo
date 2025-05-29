package logica;
/**
 * Instancia de Dulce que representa un Super8, puede ser comprado, almacenado y consumido.
 */
public class Super8 extends Dulce {

    /**
     * @see Dulce
     */
    public Super8() {
        super();
    }

    /**
     * El comprador almacena este valor cuando consume el producto
     * @return String único que retorna este producto al consumirlo
     */
    public String consumir() { return "super8"; }
}
