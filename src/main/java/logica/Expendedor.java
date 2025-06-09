package logica;

/**
 * Es una representation virtual del mecanismo expendedor dentro de una máquina expendedora de golosinas
 * que se encarga de dispensar el producto seleccionado por el comprador, asignarle precios a los productos,
 * calcular el vuelto correspondiente para devolverlo (intentando devolver la moneda más grande posible primero) y
 * almacena todas las monedas que se ingresaron tras una compra exitosa en un depósito separado.
 * También es el que maneja principalmente los casos donde el comprador no selecciono bien el producto (o está agotado),
 * no le alcanza para comprar o no ingreso bien su moneda.
 */
public class Expendedor {
    private final Deposito<Producto> coca;
    private final Deposito<Producto> sprite;
    private final Deposito<Producto> fanta;
    private final Deposito<Producto> snickers;
    private final Deposito<Producto> super8;
    private final Deposito<Producto> chocman;

    private final Deposito<Moneda> monedas_ingresadas;
    private final Deposito<Moneda> monedas_compras_exitosas;
    private final Producto[] producto = new Producto[1];
    private int Dinero_total_ingresado=0;
    private Producto productoComprado;

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

        monedas_compras_exitosas = new Deposito<>();
        monedas_ingresadas = new Deposito<>();
        producto[0]=null;

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
     * Ingresa el producto solicitado en el depósito donde "caen" al comprarlos,
     * e ingresa la moneda o monedas que se usó/usaron para la compra del producto
     * en el Depósito de compras exitosas
     * siempre y cuando no ocurra algunos de los siguientes casos:
     * 1. Si la moneda es null arroja PagoIncorrectoException.
     * 2. Si el saldo no es suficiente para comprar el producto devuelve la misma
     *    entregada y arroja PagoInsuficienteException.
     * 3. Si el producto solicitado es NULO devuelve la misma moneda entregada
     *    y arroja NoHayProductoException.
     * 4. Si no hay producto solicitado (el depósito está vacío) devuelve la
     *    misma moneda entregada y arroja NoHayProductoException.
     * @param cual: El producto que se desea comprar.
     * @throws NoHayProductoException:
     * @throws PagoInsuficienteException:
     * @see Moneda
     * @see Producto
     */
    public void comprarProducto(Productos cual) throws NoHayProductoException, PagoInsuficienteException{
        // No alcanza saldo
        if (Dinero_total_ingresado < cual.precio) {
            throw new PagoInsuficienteException("Pago insuficiente");
        }

       this.productoComprado = switch (cual) {
            case COCA -> coca.get();
            case SPRITE -> sprite.get();
            case FANTA -> fanta.get();
            case SNICKERS -> snickers.get();
            case SUPER8 -> super8.get();
            case CHOCMAN -> chocman.get();
            default -> throw new NoHayProductoException("No existe producto solicitado");
        };

        // No hay producto solicitado
        if (productoComprado == null) {
            throw new NoHayProductoException("No hay producto solicitado");
        }

        // Monedas utilizadas para el pago
        Deposito<Moneda> MonedasSeleccionadas = new Deposito<>();
        monedas_ingresadas.sort();
        int total = 0;

        // Los siguientes 2 bloques quitan las monedas ingresadas que se usaron para comprar el producto y las ingresan al de compras exitosas.
        while(!monedas_ingresadas.isEmpty() && total < cual.precio){
            Moneda m = monedas_ingresadas.get();
            total += m.getValor();
            MonedasSeleccionadas.add(m);
        }
        while (!MonedasSeleccionadas.isEmpty()){
            monedas_compras_exitosas.add(MonedasSeleccionadas.get());
            monedas_compras_exitosas.sort();
        }

        // Aquí se crean las monedas del vuelto.
        int vuelto = total - cual.precio;
        if(vuelto>0){
            utils.ingresar_total_monedas_en_orden(monedas_ingresadas, vuelto);
        }


        Dinero_total_ingresado -= cual.precio;
        producto[0]=productoComprado;
    }

    /**
     * Agrega 5 nuevos elementos al depósito que se encuentre vacío.
     */
    public void rellenarProducto(){
        if(coca.isEmpty()){
            for(int i = 0; i<6; i++) {
                coca.add(new CocaCola());
            }
        }else if(sprite.isEmpty()){
            for(int i = 0; i<6; i++) {
                sprite.add(new Sprite());
            }
        }else if(fanta.isEmpty()){
            for(int i = 0; i<6; i++) {
                fanta.add(new Fanta());
            }
        }else if(snickers.isEmpty()){
            for(int i = 0; i<6; i++) {
                snickers.add(new Snickers());
            }
        }else if(super8.isEmpty()){
            for(int i = 0; i<6; i++) {
                super8.add(new Super8());
            }
        }else if(chocman.isEmpty()){
            for(int i = 0; i<6; i++) {
                chocman.add(new Chocman());
            }
        }
    }

    public void Ingresar_Monedas(Moneda m) throws PagoIncorrectoException {
        if (m == null) {
            throw new PagoIncorrectoException("Debe ingresar una moneda");
        }
        monedas_ingresadas.add(m);
        Dinero_total_ingresado+=m.getValor();
    }

    public Deposito<Moneda> vaciarVuelto() {
        Deposito<Moneda> monedas = new Deposito<>();
        Moneda m2 = monedas_ingresadas.get();
        while(m2!=null){
            monedas.add(m2);
            m2=monedas_ingresadas.get();
        }
        Dinero_total_ingresado=0;
        return monedas;
    }

    /**
     * Devuelve el producto que el comprador compró. (es como meter la mano al depósito donde cae el producto comprado, para sacarlo)
     * @return aquel producto.
     */
    public Producto getProducto() {
        Producto producto_a_sacar = null;
        if (producto[0] != null){
            producto_a_sacar = producto[0];
            producto[0] = null;
        }
        return producto_a_sacar;
    }

    public boolean Hay_producto_en_Bandeja(){
        return producto[0]!=null;
    }

    public int getDinero_total_ingresado(){
        return Dinero_total_ingresado;
    }

    public Deposito<Moneda> getMonedas_ingresadas() {
        return monedas_ingresadas;
    }

    public Deposito<Moneda> getMonedas_compras_exitosas() {
        return monedas_compras_exitosas;
    }

    /**
     * Metodo el cual devuelve una referencia al producto comprado (solo se utiliza para animar correctamente su caida)
     * @return referencia a aquel producto.
     */
    public Producto getProductoComprado(){
        return productoComprado;
    }

    public Deposito<Producto> getCoca() {
        return coca;
    }

    public Deposito<Producto> getSprite() {
        return sprite;
    }

    public Deposito<Producto> getFanta() {
        return fanta;
    }

    public Deposito<Producto> getSnickers() {
        return snickers;
    }

    public Deposito<Producto> getSuper8() {
        return super8;
    }

    public Deposito<Producto> getChocman() {
        return chocman;
    }
}
