package org.example;
/**
 * Instancia de Moneda que representa una Moneda de 1000$, es utilizada por el comprador para realizar transacciones con el expendedor
 * el cual posee un depósito interno de monedas que representa el vuelto a devolver.
 */
class Moneda1000 extends Moneda {
    /**
     * Crea la instancia de moneda
     */
    public Moneda1000() {
        super();
    }

    /**
     * @return El valor monetario de la moneda
     */
    public int getValor() {
        return 1000;
    }
}