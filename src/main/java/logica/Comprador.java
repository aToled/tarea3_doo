package logica;
/**
 * Representa virtualmente a una persona que compra un producto desde una máquina expendedora ingresando monedas,
 * seleccionando algún producto y posteriormente recibiéndolo en conjunto a su respectivo vuelto
 * desde los depósitos internos de tal expendedor.
 */
class Comprador {
    private String sonido;
    private int vuelto;

    /**
     * Inicializa el vuelto en 0, y el sonido vació.
     */
    public Comprador(){
        vuelto=0;
        sonido="";
    }

    /**
     * Utilizando la moneda y expendedor especificado en el constructor intenta comprar
     * el producto especificado también en su constructor.
     * En caso de que la compra sea exitosa consume el producto y retira todas las monedas
     * almacenadas como vuelto en el expendedor.
     * El string devuelto al consumir el producto y el valor total del vuelto son
     * almacenados como propiedades dentro de esta clase.
     * En caso de que la compra fracase el comprador mostrará un mensaje en pantalla
     * indicando cuál es el error retornado por el expendedor.
     * @param m: Moneda utilizada para realizar la compra
     * @param cualProducto: El tipo de producto que se desea comprar
     * @param exp: El expendedor utilizado para la compra y posible retiro del vuelto
     * @see Moneda
     * @see Expendedor
     * @see NoHayProductoException
     * @see PagoInsuficienteException
     * @see PagoIncorrectoException
     */
    public void Comprar(Moneda m, Productos cualProducto, Expendedor exp) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException{
        Producto p = null;

        try {
            p = exp.comprarProducto(m, cualProducto);
        } catch (NoHayProductoException | PagoInsuficienteException e) {
            Moneda monedaTemporal = exp.getVuelto();
            if (monedaTemporal != null) {
                vuelto = monedaTemporal.getValor();
                throw e;
            }
        }

        if (p == null) {
            Moneda monedaTemporal = exp.getVuelto();
            if (monedaTemporal != null) {
                vuelto = monedaTemporal.getValor();
            }
            return;
        }
        sonido = p.consumir();

        Moneda mVuelto = exp.getVuelto();

        vuelto = 0;
        while (mVuelto != null) {
            vuelto = vuelto + mVuelto.getValor();
            mVuelto = exp.getVuelto();
        }
    }

    /**
     * @return El valor total del vuelto retirado del expendedor.
     */
    public int cuantoVuelto() {
        return vuelto;
    }

    /**
     * @return El string devuelto por el producto consumido.
     */
    public String queConsumiste() {
        return sonido;
    }
}
