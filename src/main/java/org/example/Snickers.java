package org.example;
/**
 * Instancia de Dulce que representa un Snickers, puede ser comprado, almacenado y consumido.
 */
public class Snickers extends Dulce {
    /**
     * @param numSerie: Valor único para identificar cada producto
     * @see Dulce
     */
    public Snickers(int numSerie) { super(numSerie); }

    /**
     * El comprador almacena este valor cuando consume el producto
     * @return String único que retorna este producto al consumirlo
     */
    public String consumir() { return "snickers"; }
}
