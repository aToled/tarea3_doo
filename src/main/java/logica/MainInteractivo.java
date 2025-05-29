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
        System.out.println("1. Coca Cola: $" + Productos.COCA.precio);
        System.out.println("2. Sprite: $" + Productos.SPRITE.precio);
        System.out.println("3. Fanta: $" + Productos.FANTA.precio);
        System.out.println("-----Dulces:-----");
        System.out.println("4. Snickers: $" + Productos.SNICKERS.precio);
        System.out.println("5. Super8: $" + Productos.SUPER8.precio);
        System.out.print("---->");
    }

    /**
     * Main interactivo el cual permite al usuario interactuar con un expendedor,
     * mediante un bucle que verifica que el usuario haya ingresado un valor para seguir comprando o la palabra clave "salir" para dejar de comprar.
     * @param args: Argumentos que recibe el programa al ejecutarse. El programa no requiere argumentos
     */
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(2);
        Scanner sc = new Scanner(System.in);
        Comprador c=new Comprador(0);
        ImprimirOpciones();
        while(sc.hasNext()) {
            if(sc.hasNextInt()){
                int seleccion=sc.nextInt();
                System.out.println("Ingrese una cantidad de dinero en incrementos de 100$ :   //(ej: 100, 200 , 500, 1000, 1500)");
                System.out.print("---->");
                int dinero=sc.nextInt();
                c.IngresarDinero(dinero);
                try {
                    if (seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4 || seleccion == 5) {
                        c.Comprar(Productos.values()[seleccion - 1], exp);
                        System.out.println("\n** Producto comprado: " + c.queConsumiste() + ", vuelto: " + c.cuantoVuelto() + " **\n");
                    } else {
                        c.Comprar(Productos.NULO, exp);
                        System.out.println("\n** vuelto: " + c.cuantoVuelto() + " **\n");
                    }
                } catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("\n** vuelto: " + c.cuantoVuelto() + " **\n");
                }
            }else{
                String s= sc.next();
                if(s.equalsIgnoreCase("salir")){
                    break;
                }else{
                    System.out.println("Entrada invalida!\n");
                }
            }
            System.out.println("///Para salir de la maquina escriba 'salir' \\\\\\\n");
            ImprimirOpciones();
        }
        System.out.println("Dinero retirado de la maquina: $"+c.cuantoVuelto());
    }
}
