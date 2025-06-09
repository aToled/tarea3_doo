package logica;
/**
 * Representa virtualmente a una persona que compra un producto desde una máquina expendedora ingresando dinero,
 * seleccionando algún producto y posteriormente recibiéndolo en conjunto a su respectivo vuelto
 * desde los depósitos internos de tal expendedor.
 */
public class Comprador {
    private final String sonido;
    private final int vuelto;
    private final Deposito<Moneda> monedero = new Deposito<>();
    private final Deposito<Producto> productos_comprados = new Deposito<>();

    /**
     * Inicializa el vuelto en 0, el sonido vació e ingresa el dinero como monedas en su monedero.
     * @param dinero: dinero a ser ingresado.
     */
    public Comprador(int dinero){
        this.vuelto=0;
        this.sonido="";
        utils.ingresar_total_monedas_en_orden(monedero,dinero);
    }

    /**
     * Utilizando las monedas que posee el comprador y el expendedor especificado intenta comprar
     * el producto especificado en su constructor.
     * En caso de que la compra fracase el comprador mostrará un mensaje en pantalla
     * indicando cuál es el error retornado por el expendedor.
     * @param cualProducto: El tipo de producto que se desea comprar.
     * @param exp: El expendedor utilizado para la compra y posible retiro del vuelto.
     * @see Moneda
     * @see Expendedor
     * @see NoHayProductoException
     * @see PagoInsuficienteException
     * @see PagoIncorrectoException
     */
    public void Comprar(Productos cualProducto, Expendedor exp) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException{
        exp.comprarProducto(cualProducto);
    }

    /**
     * Realiza la acción de "recoger" el vuelto por parte del Comprador. (LEGACY)
     * @return El monto del vuelto retirado del expendedor.
     */
    public int cuantoVuelto() {
        utils.ingresar_total_monedas_en_orden(monedero,vuelto);
        return vuelto;
    }

    /**
     * Realiza la acción de "recoger" el vuelto por parte del Comprador.
     */
    public void RecogerVuelto(Deposito<Moneda> depM){
        for(int i = 0; i < depM.size(); i++){
            Moneda aux = depM.get(i);
            System.out.println(aux.toString2());
        }
        utils.cambiar_monedas_de_deposito(depM, monedero);
        monedero.sort();
    }

    /**
     * Recoge el producto del expendedor (meter la mano adentro) y lo guarda en su depósito personal de productos.
     * @param producto_a_sacar:
     */
    public void Recoger_Producto(Producto producto_a_sacar){
        productos_comprados.add(producto_a_sacar);
    }

    /**
     * Ingresa monedas al monedero del comprador.
     * @param monto: monto ingresado.
     */
    public void IngresarDinero(int monto){
        utils.ingresar_total_monedas_en_orden(monedero, monto);
        monedero.sort();
    }

    /**
     * Calcula cuanto dinero posee el comprador con base en la suma del valor monetario de todas sus monedas.
     * @return el total.
     */
    public int CuantoDinero(){
        int total=0;
        Moneda[] monederoArray = monedero.toArray(Moneda[]::new);
        for (Moneda moneda : monederoArray) {
            total = total + moneda.getValor();
        }
        return total;
    }

    /**
     * Chequea si el comprador posee alguna moneda con el valor dado.
     * @param valor: valor de la moneda.
     * @return la Moneda en cuestión en caso de que el comprador posea una.
     */
    public Moneda Ingresar_Moneda(int valor){
        for(int i=0; i< monedero.size(); i++){
            Moneda m = monedero.get(i);
            if(m!=null && m.getValor()==valor){
                monedero.remove(i);
                return m;
            }
        }
        return null;
    }

    /**
     * @return El string devuelto por el producto consumido.
     */
    public String queConsumiste() {
        return sonido;
    }

    /**
     * Consume la primera instancia del producto elegido que el Comprador posea en su depósito de productos_comprados.
     * @param cual: el producto que fue elegido.
     */
    public void Consumir(Productos cual){
        for (int i=0; i< productos_comprados.size(); i++){
            if(productos_comprados.get(i).getCualProducto()==cual){
                System.out.println("Consumiste: "+productos_comprados.get(i).consumir());
                productos_comprados.remove(i);;
                return;
            }
        }
    }

    public Deposito<Producto> getProductos_comprados() {
        return productos_comprados;
    }

    public Deposito<Moneda> getMonedero() {
        return monedero;
    }
}
