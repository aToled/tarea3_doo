package logica;

import java.util.ArrayList;
/**
 * Clase principal que se encarga de probar el correcto funcionamiento de las posibles interacciones
 * entre el comprador, expendedor, depósito, los productos y las monedas.
 */
public class Main {
    /**
     * Método principal de pruebas el cual comprueba el correcto funcionamiento de todas las clases del programa
     * @param args: Argumentos que recibe el programa al ejecutarse. El programa no requiere argumentos
     */
    public static void main(String[] args) {
        Expendedor exp1 = new Expendedor(2);
        Expendedor exp2 = new Expendedor(2);

        System.out.println("-----Producto que no vende-----\n");
        Comprar(new Moneda1000(),Productos.NULO, exp1);

        System.out.println("-----Comprar Super8 sin moneda-----\n");
        for(int i=0;i<2;i++){
            Comprar(null,Productos.SUPER8, exp1);
        }

        System.out.println("-----Con dinero Justo para el precio Super8-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda500(),Productos.SUPER8, exp1);
        }

        System.out.println("-----Comprar CocaCola sin moneda-----\n");
        for(int i=0;i<2;i++){
            Comprar(null,Productos.COCA, exp1);
        }

        System.out.println("-----Con dinero Justo para el precio CocaCola-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.COCA, exp1);
        }

        System.out.println("-----Con menos dinero que el precio Sprite-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda500(),Productos.SPRITE, exp1);
        }

        System.out.println("-----Con más dinero que el precio Sprite-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.SPRITE, exp1);
        }

        System.out.println("-----Comprar Fanta sin moneda-----\n");
        for(int i=0;i<2;i++){
            Comprar(null,Productos.FANTA, exp1);
        }
        System.out.println("-----Con dinero Justo para el precio Fanta-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1000(),Productos.FANTA, exp1);
        }

        System.out.println("-----Con menos dinero que el precio Snickers-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda500(),Productos.SNICKERS, exp1);
        }

        System.out.println("-----Con más dinero que el precio Snickers-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.SNICKERS, exp1);
        }

        System.out.println("-----Depósito 1 Vacío CocaCola-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.COCA, exp1);
        }

        System.out.println("-----Depósito 1 Vacío Sprite-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.SPRITE, exp1);
        }

        System.out.println("-----Depósito 1 Vacío Fanta-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.FANTA, exp1);
        }

        System.out.println("-----Depósito 1 Vacío Snickers-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.SNICKERS, exp1);
        }

        System.out.println("-----Depósito 1 Vacío Super8-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.SUPER8, exp1);
        }

        System.out.println("-----Comprar Sprite sin moneda-----\n");
        for(int i=0;i<2;i++){
            Comprar(null,Productos.SPRITE, exp2);
        }

        System.out.println("-----Con dinero Justo para el precio Sprite-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1000(),Productos.SPRITE, exp2);
        }

        System.out.println("-----Con menos dinero que el precio CocaCola-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda500(),Productos.COCA, exp2);
        }

        System.out.println("-----Con dinero justo para el precio CocaCola-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.COCA, exp2);
        }

        System.out.println("-----Comprar Snickers sin moneda-----\n");
        for(int i=0;i<2;i++){
            Comprar(null,Productos.SNICKERS, exp2);
        }

        System.out.println("-----Con más dinero que el precio Snickers-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1000(),Productos.SNICKERS, exp2);
        }

        System.out.println("-----Con menos dinero que el precio Fanta-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda500(),Productos.FANTA, exp2);
        }

        System.out.println("-----Con más dinero que el precio Fanta-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.FANTA, exp2);
        }

        System.out.println("-----Con menos dinero que el precio Super8-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda100(),Productos.SUPER8, exp2);
        }

        System.out.println("-----Con más dinero que el precio Super8-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.SUPER8, exp2);
        }

        System.out.println("-----Depósito 2 Vacío CocaCola-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.COCA, exp2);
        }

        System.out.println("-----Depósito 2 Vacío Sprite-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.SPRITE, exp2);
        }

        System.out.println("-----Depósito 2 Vacío Fanta-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.FANTA, exp2);
        }

        System.out.println("-----Depósito 2 Vacío Snickers-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.SNICKERS, exp2);
        }

        System.out.println("-----Depósito 2 Vacío Super8-----\n");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Productos.SUPER8, exp2);
        }

        // Se crea una lista de monedas para luego ser ordenadas de mayor a menor
        // utilizando el método sort
        ArrayList<Moneda> monedas = new ArrayList<>();

        // Se crean monedas de manera desordenada
        monedas.add(new Moneda100());
        monedas.add(new Moneda1500());
        monedas.add(new Moneda100());
        monedas.add(new Moneda1000());
        monedas.add(new Moneda500());

        System.out.println("\nDepósito de monedas desordenado:");
        for (Moneda moneda : monedas) {
            if (moneda == null) {
                System.out.println("null");
            } else {
                System.out.println(moneda.getValor());
            }
        }

        monedas.sort(null);

        System.out.println("\nDepósito de monedas ordenado:");
        for (Moneda moneda : monedas) {
            if (moneda == null) {
                System.out.println("null");
            } else {
                System.out.println(moneda.getValor());
            }
        }
    }
    /**
     * Realiza la acción de comprar el producto con la moneda en el expendedor,
     * e imprime en consola la información asociada.
     * @param m: Valor de la moneda ingresada
     * @param cualProducto: Producto seleccionado
     * @param exp: Expendedor que del cual se quiere comprar
     */
    private static void Comprar(Moneda m, Productos cualProducto, Expendedor exp) {
        Comprador c;
        if(m==null){
            System.out.println(null+"Error: Moneda nula\n--> vuelto $0");
            return;
        }
        c = new Comprador(m.getValor());
        try {
            c.Comprar(cualProducto, exp);

            if(cualProducto==Productos.NULO){
                System.out.println(m+"\n--> vuelto: $" + c.cuantoVuelto()+"\n");
            }else{
                System.out.println(m+"\n--> Producto comprado: " + c.queConsumiste() + "\n--> Costo $"+cualProducto.precio+", vuelto: $" + c.cuantoVuelto()+"\n");
            }
        } catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println(m+"\n--> vuelto: $" + c.cuantoVuelto()+"\n");
        }
    }
}