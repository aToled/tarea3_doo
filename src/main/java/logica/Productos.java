package logica;
/**
 * Se utiliza para especificar el tipo de producto que se va a comprar
 * y se almacena su precio de manera constante.
 */
public enum Productos {
    COCA(1500), SPRITE(1000), FANTA(1000), SNICKERS(700), SUPER8(500), NULO(0);

    public final int precio;

    Productos(int precio) {
        this.precio = precio;
    }
}