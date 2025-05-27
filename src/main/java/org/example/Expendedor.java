package org.example;
/**
 * Es una representation virtual del mecanismo expendedor dentro de una máquina expendedora de golosinas
 * que se encarga de dispensar el producto seleccionado por el comprador, asignarle precios a los productos y
 * calcular el vuelto correspondiente para devolverlo.
 * También es el que maneja principalmente los casos donde el comprador no selecciono bien el producto (o está agotado),
 * no le alcanza para comprar o no ingreso bien su moneda.
 */
class Expendedor {
    private final Deposito<Bebida> coca;
    private final Deposito<Bebida> sprite;
    private final Deposito<Bebida> fanta;
    private final Deposito<Dulce> snickers;
    private final Deposito<Dulce> super8;
    private final Deposito<Moneda> monVu;

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

    /**
     * El Expendedor almacena los productos que especificados por el enum 'Productos'
     * Cada producto es almacenado en un depósito específico para dicho producto.
     * @param numProductos: La cantidad que se almacenará en cada depósito para cada tipo de producto
     * @see Productos
     * @see Deposito
     */
    public Expendedor(int numProductos) {
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();

        snickers = new Deposito<>();
        super8 = new Deposito<>();

        monVu = new Deposito<>();

        for (int i = 0; i < numProductos; i++) {
            coca.add(     new CocaCola((i*5)+0  ));
            sprite.add(   new Sprite( (i*5)+1   ));
            fanta.add(    new Fanta( (i*5)+2    ));
            snickers.add( new Snickers( (i*5)+3 ));
            super8.add(   new Super8( (i*5)+4   ));
        }
    }

    /**
     * Retorna el producto solicitado y almacena el vuelto en monedas de 100 en el depósito monVu
     * siempre y cuando no ocurra algunos de los siguientes casos:
     * 1. Si la moneda es null arroja PagoIncorrectoException.
     * 2. Si el saldo no es suficiente para comprar el producto devuelve la misma
     *    entregada y arroja PagoInsuficienteException.
     * 3. Si el producto solicitado es NULO devuelve la misma moneda entregada
     *    y arroja NoHayProductoException.
     * 4. Si no hay producto solicitado (el depósito está vacío) devuelve la
     *    misma moneda entregada y arroja NoHayProductoException.
     * @param m: Moneda utilizada para la compra
     * @param cual: El producto que se desea comprar
     * @return Producto si es que la compra es exitosa en caso contrario retorna null
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     * @see Moneda
     * @see Producto
     */
    public Producto comprarProducto(Moneda m, Productos cual) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        if (m == null) {
            throw new PagoIncorrectoException("Debe ingresar una moneda");
        }

        // No alcanza saldo
        if (m.getValor() < cual.precio) {
            monVu.add(m);
            throw new PagoInsuficienteException("Pago insuficiente");
        }

        Producto temp;

        switch (cual) {
            case COCA:
                temp = coca.get();
                break;
            case SPRITE:
                temp = sprite.get();
                break;
            case FANTA:
                temp = fanta.get();
                break;
            case SNICKERS:
                temp = snickers.get();
                break;
            case SUPER8:
                temp = super8.get();
                break;
            default:
                monVu.add(m);
                throw new NoHayProductoException("No existe producto solicitado");
        }

        // No hay producto solicitado
        if (temp == null) {
            monVu.add(m);
            throw new NoHayProductoException("No hay producto solicitado");
        }

        if (m.getValor() == cual.precio) {
            return temp;
        }

        int howManyCoins = (m.getValor() - cual.precio) / 100;
        for (int i = 0; i < howManyCoins; i++) {
            monVu.add(new Moneda100());
        }

        return temp;
    }

    /**
     * @return la última moneda dentro del depósito monVu (puede ser null si no hay monedas).
     */
    public Moneda getVuelto() {
        return monVu.get();
    }
}
