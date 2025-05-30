package logica;
/**
 * Es una representation virtual del mecanismo expendedor dentro de una máquina expendedora de golosinas
 * que se encarga de dispensar el producto seleccionado por el comprador, asignarle precios a los productos,
 * calcular el vuelto correspondiente para devolverlo (intentando devolver la moneda más grande posible primero) y
 * almacena todas las monedas que se ingresaron tras una compra exitosa en un depósito separado.
 * También es el que maneja principalmente los casos donde el comprador no selecciono bien el producto (o está agotado),
 * no le alcanza para comprar o no ingreso bien su moneda.
 */
class Expendedor {
    private final Deposito<Bebida> coca;
    private final Deposito<Bebida> sprite;
    private final Deposito<Bebida> fanta;
    private final Deposito<Dulce> snickers;
    private final Deposito<Dulce> super8;
    private final Deposito<Dulce> chocman;
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
        chocman = new Deposito<>();

        monVu = new Deposito<>();
        monedas_compras_exitosas = new Deposito<>();

        for (int i = 0; i < numProductos; i++) {
            coca.add(     new CocaCola());
            sprite.add(   new Sprite());
            fanta.add(    new Fanta());
            snickers.add( new Snickers());
            super8.add(   new Super8());
            chocman.add(   new Chocman());
        }
    }

    /**
     * Ingresa el producto solicitado en el depósito donde "caen" al comprarlos
     * y almacena el vuelto con las monedas más grandes primero en el depósito monVu
     * siempre y cuando no ocurra algunos de los siguientes casos:
     * 1. Si la moneda es null arroja PagoIncorrectoException.
     * 2. Si el saldo no es suficiente para comprar el producto devuelve la misma
     *    entregada y arroja PagoInsuficienteException.
     * 3. Si el producto solicitado es NULO devuelve la misma moneda entregada
     *    y arroja NoHayProductoException.
     * 4. Si no hay producto solicitado (el depósito está vacío) devuelve la
     *    misma moneda entregada y arroja NoHayProductoException.
     * @param monedero: Depósito de monedas utilizado para la compra.
     * @param cual: El producto que se desea comprar.
     * @throws NoHayProductoException:
     * @throws PagoInsuficienteException:
     * @throws PagoIncorrectoException:
     * @see Moneda
     * @see Producto
     */
    public void comprarProducto(Deposito<Moneda> monedero, Productos cual) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda m = monedero.get();
        int Dinero_total_ingresado = 0;

        if (m == null) {
            throw new PagoIncorrectoException("Debe ingresar una moneda");
        }

        Deposito<Moneda> monedas_ingresadas = new Deposito<>();
        monedas_ingresadas.add(m);
        while(m!=null){
            Dinero_total_ingresado+=m.getValor();
            m=monedero.get();
            monedas_ingresadas.add(m);
        }


        // No alcanza saldo
        if (Dinero_total_ingresado < cual.precio) {
            utils.cambiar_monedas_de_deposito(monedas_ingresadas,monVu);
            throw new PagoInsuficienteException("Pago insuficiente");
        }

        Producto temp = switch (cual) {
            case COCA -> coca.get();
            case SPRITE -> sprite.get();
            case FANTA -> fanta.get();
            case SNICKERS -> snickers.get();
            case SUPER8 -> super8.get();
            case CHOCMAN -> chocman.get();
            default -> {
                utils.cambiar_monedas_de_deposito(monedas_ingresadas,monVu);
                throw new NoHayProductoException("No existe producto solicitado");
            }
        };

        // No hay producto solicitado
        if (temp == null) {
            utils.cambiar_monedas_de_deposito(monedas_ingresadas,monVu);
            throw new NoHayProductoException("No hay producto solicitado");
        }

        utils.cambiar_monedas_de_deposito(monedas_ingresadas,monedas_compras_exitosas);
        int howManyCoins = (Dinero_total_ingresado - cual.precio);
        utils.ingresar_total_monedas_en_orden(monVu,howManyCoins);

        producto[0]=temp;
    }

    /**
     * Rellena el depósito correspondiente con un elemento del producto seleccionado.
     * @param cual:tal producto.
     */
    public void rellenarProducto(Productos cual){
        switch (cual) {
            case COCA -> coca.add(new CocaCola());
            case SPRITE -> sprite.add(new Sprite());
            case FANTA -> fanta.add(new Fanta());
            case SNICKERS -> snickers.add(new Snickers());
            case SUPER8 -> super8.add(new Super8());
            case CHOCMAN -> chocman.add(new Chocman());
            default -> {
            }
        }
    }

    /**
     * @return la última moneda dentro del depósito monVu. (puede ser null si no hay monedas)
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
