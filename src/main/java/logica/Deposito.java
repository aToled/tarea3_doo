package logica;

import java.util.ArrayList;
import java.util.function.IntFunction;

/**
 * Representa un depósito que dentro del código lo usamos para representar los distintos lugares dentro
 * una máquina expendedora donde se almacenan sus productos y monedas. Y para representar el monedero del Comprador.
 * @param <T>: Deposito de tipo "genérico"
 */
public class Deposito<T> {
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

    public ArrayList<T> getRef() {
        return arrayList;
    }

    /**
     * Guarda el elemento al final del ArrayList.
     * @param elemento: El elemento que se desea almacenar dentro del ArrayList.
     */
    public void add(T elemento) {
        if (elemento == null) return;

        arrayList.add(elemento);
    }

    /**
     * Verifica si el depósito esa vacío o no.
     * @return un boolean true si está vacío, de lo contrario false
     */
    public boolean isEmpty(){
        return arrayList.isEmpty();
    }

    /**
     * Ordena el depósito en su orden natural. (solo lo usan depósitos de monedas que implementan la interfaz comparable)
     */
    public void sort(){
        arrayList.sort(null);
    }

    public int size() { return arrayList.size(); }

    public T[] toArray(IntFunction<T[]> generator){
        return arrayList.toArray(generator);
    }
}