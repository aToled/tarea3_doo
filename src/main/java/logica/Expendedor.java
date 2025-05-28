package logica;
/**
 * Es una representation virtual del mecanismo expendedor dentro de una máquina expendedora de golosinas
 * que se encarga de dispensar el producto seleccionado por el comprador, asignarle precios a los productos,
 * calcular el vuelto correspondiente para devolverlo (intentando devolver la moneda mas grande posible primero) y
 * almacena todas las monedas que se ingresaron tras una compra exitosa en un deposito separado.
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
    private final Deposito<Moneda> monedas_compras_exitosas;
    private final Producto[] producto = new Producto[1];

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
        monedas_compras_exitosas = new Deposito<>();

        for (int i = 0; i < numProductos; i++) {
            coca.add(     new CocaCola((i*5)  ));
            sprite.add(   new Sprite( (i*5)+1   ));
            fanta.add(    new Fanta( (i*5)+2    ));
            snickers.add( new Snickers( (i*5)+3 ));
            super8.add(   new Super8( (i*5)+4   ));
        }
    }

    /**
     * Ingresa el producto solicitado en el desposito donde "caen" al comprarlos
     * y almacena el vuelto con las monedas mas grandes primero en el depósito monVu
     * siempre y cuando no ocurra algunos de los siguientes casos:
     * 1. Si la moneda es null arroja PagoIncorrectoException.
     * 2. Si el saldo no es suficiente para comprar el producto devuelve la misma
     *    entregada y arroja PagoInsuficienteException.
     * 3. Si el producto solicitado es NULO devuelve la misma moneda entregada
     *    y arroja NoHayProductoException.
     * 4. Si no hay producto solicitado (el depósito está vacío) devuelve la
     *    misma moneda entregada y arroja NoHayProductoException.
     * @param m: Moneda utilizada para la compra.
     * @param cual: El producto que se desea comprar.
     * @throws NoHayProductoException:
     * @throws PagoInsuficienteException:
     * @throws PagoIncorrectoException:
     * @see Moneda
     * @see Producto
     */
    public void comprarProducto(Moneda m, Productos cual) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        if (m == null) {
            throw new PagoIncorrectoException("Debe ingresar una moneda");
        }

        // No alcanza saldo
        if (m.getValor() < cual.precio) {
            monVu.add(m);
            throw new PagoInsuficienteException("Pago insuficiente");
        }

        Producto temp = switch (cual) {
            case COCA -> coca.get();
            case SPRITE -> sprite.get();
            case FANTA -> fanta.get();
            case SNICKERS -> snickers.get();
            case SUPER8 -> super8.get();
            default -> {
                monVu.add(m);
                throw new NoHayProductoException("No existe producto solicitado");
            }
        };

        // No hay producto solicitado
        if (temp == null) {
            monVu.add(m);
            throw new NoHayProductoException("No hay producto solicitado");
        }

        if (m.getValor() == cual.precio) {
            producto[0]=temp;
            monedas_compras_exitosas.add(m);
        }

        int howManyCoins = (m.getValor() - cual.precio);
        while(howManyCoins!=0){
            if((howManyCoins)>=1500){
                monVu.add(new Moneda1500());
                howManyCoins=howManyCoins-1500;
            }else if((howManyCoins)>=1000){
                monVu.add(new Moneda1000());
                howManyCoins=howManyCoins-1000;
            }else if((howManyCoins)>=500){
                monVu.add(new Moneda500());
                howManyCoins=howManyCoins-500;
            }else if((howManyCoins)>=100){
                monVu.add(new Moneda100());
                howManyCoins=howManyCoins-100;
            }
        }

        producto[0]=temp;
    }

    /**
     * @return la última moneda dentro del depósito monVu (puede ser null si no hay monedas).
     */
    public Moneda getVuelto() {
        return monVu.get();
    }

    /**
     * Devuelve el producto que el comprador compró. (es como meter la mano al depósito donde cae el producto comprado, para sacarlo)
     * @return aquel producto.
     */
    public Producto getProducto(){
        return producto[0];
    }
}
