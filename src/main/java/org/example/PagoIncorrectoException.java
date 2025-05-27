package org.example;
/**
 * Excepción que surge cuando se utiliza una moneda null para intentar comprar un producto.
 */
public class PagoIncorrectoException extends Exception {
    /**
     * @param message: Mensaje personalizado para la excepción
     */
    public PagoIncorrectoException(String message) {
        super(message);
    }
}
