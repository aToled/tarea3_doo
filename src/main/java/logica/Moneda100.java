package logica;
/**
 * Instancia de Moneda que representa una Moneda de 100 $, es utilizada por el comprador para realizar transacciones con el expendedor
 * el cual posee un depósito interno de monedas que representa el vuelto a devolver.
 */
public class Moneda100 extends Moneda {
    /**
     * Crea la instancia de moneda.
     */
    public Moneda100() {
        super();
    }

    /**
     * @return El valor monetario de la moneda.
     */
    public int getValor() {
        return 100;
    }
}
