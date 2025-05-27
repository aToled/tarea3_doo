package org.example;
/**
 * Excepción qe surge cuando se intenta comprar un producto con una moneda de valor inferior
 * al precio del producto.
 */
public class PagoInsuficienteException extends Exception {
    /**
     * @param message: Mensaje personalizado para la excepción
     */
    public PagoInsuficienteException(String message) {
        super(message);
    }
}
