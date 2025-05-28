package logica;

import java.util.ArrayList;
/**
 * Representa un depósito que dentro del código lo usamos para representar los distintos lugares dentro
 * una máquina expendedora donde se almacenan sus productos y monedas.
 * @param <T>: Deposito de tipo "genérico"
 */
class Deposito<T> {
    private final ArrayList<T> arrayList;

    /**
     * Se almacenará dentro de un ArrayList elementos de tipo genérico
     * en un orden FIFO.
     * @see ArrayList
     */
    public Deposito() {
        arrayList = new ArrayList<>();
    }

    /**
     * @return El primero valor almacenado en el ArrayList.
     * Retorna null si el ArrayList está vacío.
     */
    public T get() {
        if (arrayList.isEmpty()) {
            return null;
        }

        T temp = arrayList.getFirst();
        arrayList.removeFirst();
        return temp;
    }

    /**
     * Guarda el elemento al final del ArrayList.
     * @param elemento: El elemento que se desea almacenar dentro del ArrayList.
     */
    public void add(T elemento) {
        if (elemento == null) return;

        arrayList.add(elemento);
    }
}