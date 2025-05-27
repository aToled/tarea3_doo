package logica;
import java.util.Scanner;
/**
 * Una simulación simple de interfaz interactiva para una máquina expendedora de dulces y bebidas.
 */
public class MainInteractivo {
    /**
     * Imprime en consola el menú con las opciones de compra para el usuario.
     */
    private static void ImprimirOpciones(){
        System.out.println("Elija el producto que desea comprar");
        System.out.println("-----Bebidas:------");
        System.out.println("1. Coca Cola: $" + Expendedor.Productos.COCA.precio);
        System.out.println("2. Sprite: $" + Expendedor.Productos.SPRITE.precio);
        System.out.println("3. Fanta: $" + Expendedor.Productos.FANTA.precio);
        System.out.println("-----Dulces:-----");
        System.out.println("4. Snickers: $" + Expendedor.Productos.SNICKERS.precio);
        System.out.println("5. Super8: $" + Expendedor.Productos.SUPER8.precio);
        System.out.print("---->");
    }

    /**
     * Devuelve la moneda con el valor especificado en el argumento.
     * Los valores válidos son 100, 500, 1000 y 1500
     * @return una instancia de la moneda ingresada
     * @param m: Valor de la moneda que se quiere obtener
     */
    private static Moneda ElegirMoneda(int m){
        switch(m){
            case 100:
                return new Moneda100();
            case 500:
                return new Moneda500();
            case 1000:
                return new Moneda1000();
            case 1500:
                return new Moneda1500();
            default:
                System.out.println("Moneda no valida");
                return null;
        }
    }

    /**
     * Main interactivo el cual permite al usuario interactuar con un expendedor,
     * mediante un bucle que verifica que el usuario haya ingresado un valor para seguir comprando o la palabra clave "salir" para dejar de comprar.
     * @param args: Argumentos que recibe el programa al ejecutarse. El programa no requiere argumentos
     */
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(2);
        Scanner sc = new Scanner(System.in);
        Comprador c;
        ImprimirOpciones();
        while(sc.hasNext()) {
            if(sc.hasNextInt()){
                int seleccion=sc.nextInt();
                System.out.println("Ingrese su Moneda:   //(100, 500, 1000, 1500)");
                System.out.print("---->");
                int moneda=sc.nextInt();
                try {
                    if (seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5) {
                        c = new Comprador(ElegirMoneda(moneda), Expendedor.Productos.values()[seleccion - 1], exp);
                        System.out.println("\n** Producto comprado: " + c.queConsumiste() + ", vuelto: " + c.cuantoVuelto() + " **\n");
                    } else {
                        c = new Comprador(ElegirMoneda(moneda), Expendedor.Productos.NULO, exp);
                        System.out.println("\n** vuelto: " + c.cuantoVuelto() + " **\n");
                    }
                } catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }else{
                String s= sc.next();
                if(s.equalsIgnoreCase("salir")){
                    break;
                }else{
                    System.out.println("Entrada invalida!\n");
                }
            }
            System.out.println("///Para salir de la maquina escriba 'salir'\\\\\\\n");
            ImprimirOpciones();
        }
    }
}
