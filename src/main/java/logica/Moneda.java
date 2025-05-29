package logica;
/**
 * Un Molde de moneda genérica la cual se utiliza en distintas transacciones entre el comprador y el expendedor
 * también implementa la interfaz Comparable para organizar un depósito de monedas de mayor a menor.
 */
abstract public class Moneda implements Comparable<Moneda> {
    public Moneda() {}

    /**
     * @return La referencia a al objeto moneda
     */
    public String getSerie() {
        return Integer.toHexString(System.identityHashCode(this));
    }

    /**
     * @return El valor monetario de la moneda
     */
    public abstract int getValor();

    /**
     * @return Un string que incluye el valor de la serie y el valor monetario de la moneda
     */
    @Override
    public String toString() {
        return "-> Moneda:\n-Serie: " + getSerie() + "\n-Valor: " + getValor();
    }

    /**
     * Compara el valor monetario entre la moneda actual y otra pasada como parámetro.
     * Esto permite ordenar de menor a mayor o mayor a menor una lista de monedas.
     * 1 si getValor() < c.getValor()
     * -1 si getValor() > c.getValor()
     * 0 si getValor() == c.getValor()
     * @param c Objeto al que será comparado
     * @return El valor comparativo respecto al valor monetario
     */
    @Override
    public int compareTo(Moneda c) {
        int valor = getValor();
        int valor2 = c.getValor();

        return Integer.compare(valor2, valor);
    }
}

