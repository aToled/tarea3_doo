package logica;
/**
 * Instancia de Dulce que representa un Chocman, puede ser comprado, almacenado y consumido.
 */
public class Chocman extends Dulce {

    /**
     * @see Dulce
     */
    public Chocman() {
        super(Productos.CHOCMAN);
    }

    /**
     * El comprador almacena este valor cuando consume el producto.
     * @return String único que retorna este producto al consumirlo.
     */
    public String consumir() { return "chocman"; }
}
