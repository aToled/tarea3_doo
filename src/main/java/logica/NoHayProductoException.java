package logica;
/**
 * Excepción que surge cuando el producto solicitado se acabó o no existe.
 */
public class NoHayProductoException extends Exception {
    /**
     * @param message: Mensaje personalizado para la excepción.
     */
    public NoHayProductoException(String message) {
        super(message);
    }
}
