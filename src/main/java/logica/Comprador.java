package logica;
/**
 * Representa virtualmente a una persona que compra un producto desde una máquina expendedora ingresando dinero,
 * seleccionando algún producto y posteriormente recibiéndolo en conjunto a su respectivo vuelto
 * desde los depósitos internos de tal expendedor.
 */
public class Comprador {
    private String sonido;
    private int vuelto;
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
     * En caso de que la compra sea exitosa consume el producto y retira todas las monedas
     * almacenadas como vuelto en el expendedor.
     * El string devuelto al consumir el producto y el valor total del vuelto son
     * almacenados como propiedades dentro de esta clase.
     * En caso de que la compra fracase el comprador mostrará un mensaje en pantalla
     * indicando cuál es el error retornado por el expendedor.
     * @param cualProducto: El tipo de producto que se desea comprar
     * @param exp: El expendedor utilizado para la compra y posible retiro del vuelto
     * @see Moneda
     * @see Expendedor
     * @see NoHayProductoException
     * @see PagoInsuficienteException
     * @see PagoIncorrectoException
     */
    public void Comprar(Productos cualProducto, Expendedor exp) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException{
        Producto p = null;

        try {
            exp.comprarProducto(cualProducto);
            p=exp.getProducto();
        } catch (NoHayProductoException | PagoInsuficienteException e) {
            Moneda monedaTemporal = exp.getVuelto();
            if (monedaTemporal != null) {
                vuelto = monedaTemporal.getValor();
                // throw e;
            }
            throw e;
        }

        if (p == null) {
            Moneda monedaTemporal = exp.getVuelto();
            if (monedaTemporal != null) {
                vuelto = monedaTemporal.getValor();
            }
            return;
        }
        sonido = p.consumir();
        productos_comprados.add(p);

        Moneda mVuelto = exp.getVuelto();

        vuelto = 0;
        while (mVuelto != null) {
            vuelto = vuelto + mVuelto.getValor();
            mVuelto = exp.getVuelto();
        }
    }

    /**
     * Realiza la acción de "recoger" el vuelto por parte del Comprador
     * @return El monto del vuelto retirado del expendedor.
     */
    public int cuantoVuelto() {
        utils.ingresar_total_monedas_en_orden(monedero,vuelto);
        return vuelto;
    }

    public void RecogerVuelto(Deposito<Moneda> depM){
          utils.cambiar_monedas_de_deposito(depM, monedero);
          monedero.sort();
    }

    /**
     * Ingresa monedas al monedero del comprador.
     * @param monto: monto ingresado.
     */
    public void IngresarDinero(int monto){
        utils.ingresar_total_monedas_en_orden(monedero, monto);
        monedero.sort();
    }

    public int CuantoDinero(){
        int total=0;
        Moneda[] monederoArray = monedero.toArray(Moneda[]::new);
        for (Moneda moneda : monederoArray) {
            total = total + moneda.getValor();
        }
        return total;
    }

    /**
     * @return El string devuelto por el producto consumido.
     */
    public String queConsumiste() {
        return sonido;
    }

    public Deposito<Producto> getProductos_comprados() {
        return productos_comprados;
    }

    public Deposito<Moneda> getMonedero() {
        return monedero;
    }
}
