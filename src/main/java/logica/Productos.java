package logica;
/**
 * Se utiliza para especificar el tipo de producto que se va a comprar
 * y se almacena su precio de manera constante.
 */
public enum Productos {
    COCA("Coca cola", 1500), SPRITE("Sprite", 1000), FANTA("Fanta", 1000), SNICKERS("Snickers", 700), SUPER8("Super8", 500), CHOCMAN("Chocman", 500), NULO("Nulo", 0);

    public final String nombre;
    public final int precio;

    Productos(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}