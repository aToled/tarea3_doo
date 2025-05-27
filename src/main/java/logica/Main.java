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

        System.out.println("\n-----Producto que no vende-----");
        Comprar(new Moneda1000(),Expendedor.Productos.NULO, exp1);

        System.out.println("\n-----Comprar Super8 sin moneda-----");
        for(int i=0;i<2;i++){
            Comprar(null,Expendedor.Productos.SUPER8, exp1);
        }

        System.out.println("\n-----Con dinero Justo para el precio Super8-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda500(),Expendedor.Productos.SUPER8, exp1);
        }

        System.out.println("\n-----Comprar CocaCola sin moneda-----");
        for(int i=0;i<2;i++){
            Comprar(null,Expendedor.Productos.COCA, exp1);
        }

        System.out.println("\n-----Con dinero Justo para el precio CocaCola-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.COCA, exp1);
        }

        System.out.println("\n-----Con menos dinero que el precio Sprite-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda500(),Expendedor.Productos.SPRITE, exp1);
        }

        System.out.println("\n-----Con más dinero que el precio Sprite-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.SPRITE, exp1);
        }

        System.out.println("\n-----Comprar Fanta sin moneda-----");
        for(int i=0;i<2;i++){
            Comprar(null,Expendedor.Productos.FANTA, exp1);
        }

        System.out.println("\n-----Con dinero Justo para el precio Fanta-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1000(),Expendedor.Productos.FANTA, exp1);
        }

        System.out.println("\n-----Con menos dinero que el precio Snickers-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda500(),Expendedor.Productos.SNICKERS, exp1);
        }

        System.out.println("\n-----Con más dinero que el precio Snickers-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.SNICKERS, exp1);
        }

        System.out.println("\n-----Depósito 1 Vacío CocaCola-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.COCA, exp1);
        }

        System.out.println("\n-----Depósito 1 Vacío Sprite-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.SPRITE, exp1);
        }

        System.out.println("\n-----Depósito 1 Vacío Fanta-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.FANTA, exp1);
        }

        System.out.println("\n-----Depósito 1 Vacío Snickers-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.SNICKERS, exp1);
        }

        System.out.println("\n-----Depósito 1 Vacío Super8-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.SUPER8, exp1);
        }

        System.out.println("\n-----Comprar Sprite sin moneda-----");
        for(int i=0;i<2;i++){
            Comprar(null,Expendedor.Productos.SPRITE, exp2);
        }

        System.out.println("\n-----Con dinero Justo para el precio Sprite-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1000(),Expendedor.Productos.SPRITE, exp2);
        }

        System.out.println("\n-----Con menos dinero que el precio CocaCola-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda500(),Expendedor.Productos.COCA, exp2);
        }

        System.out.println("\n-----Con dinero justo para el precio CocaCola-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.COCA, exp2);
        }

        System.out.println("\n-----Comprar Snickers sin moneda-----");
        for(int i=0;i<2;i++){
            Comprar(null,Expendedor.Productos.SNICKERS, exp2);
        }

        System.out.println("\n-----Con más dinero que el precio Snickers-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1000(),Expendedor.Productos.SNICKERS, exp2);
        }

        System.out.println("\n-----Con menos dinero que el precio Fanta-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda500(),Expendedor.Productos.FANTA, exp2);
        }

        System.out.println("\n-----Con más dinero que el precio Fanta-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.FANTA, exp2);
        }

        System.out.println("\n-----Con menos dinero que el precio Super8-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda100(),Expendedor.Productos.SUPER8, exp2);
        }

        System.out.println("\n-----Con más dinero que el precio Super8-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.SUPER8, exp2);
        }

        System.out.println("\n-----Depósito 2 Vacío CocaCola-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.COCA, exp2);
        }

        System.out.println("\n-----Depósito 2 Vacío Sprite-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.SPRITE, exp2);
        }

        System.out.println("\n-----Depósito 2 Vacío Fanta-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.FANTA, exp2);
        }

        System.out.println("\n-----Depósito 2 Vacío Snickers-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.SNICKERS, exp2);
        }

        System.out.println("\n-----Depósito 2 Vacío Super8-----");
        for(int i=0;i<2;i++){
            Comprar(new Moneda1500(),Expendedor.Productos.SUPER8, exp2);
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
     * Realiza la acción de comprar el producto con la moneda en el expendedor
     * e imprime en consola la información asociada
     * @param m: Valor de la moneda ingresada
     * @param cualProducto: Producto seleccionado
     * @param exp: Expendedor que del cual se quiere comprar
     */
    private static void Comprar(Moneda m, Expendedor.Productos cualProducto, Expendedor exp) {
        try {
            Comprador c = new Comprador(m, cualProducto, exp);
            if(cualProducto==Expendedor.Productos.NULO||m==null){
                System.out.println(m+"\n--> vuelto: $" + c.cuantoVuelto()+"\n");
            }else{
                System.out.println(m+"\n--> Producto comprado: " + c.queConsumiste() + ", vuelto: $" + c.cuantoVuelto());
            }
        } catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}