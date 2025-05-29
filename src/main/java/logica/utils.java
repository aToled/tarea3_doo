package logica;
/**
 * Clase cuyo propósito es ofrecer métodos públicos y estáticos útiles para la implementación.
 */
public class utils {
    /**
     * Dados un depósito de monedas y la cantidad total que se quiere ingresar
     * este ingresa monedas al depósito partiendo con la más grande posible.
     * @param deposito: tal depósito.
     * @param total: el monto total de las monedas.
     */
    public static void ingresar_total_monedas_en_orden(Deposito<Moneda> deposito, int total){
        while(total!=0){
            if((total)>=1500){
                deposito.add(new Moneda1500());
                total=total-1500;
            }else if((total)>=1000){
                deposito.add(new Moneda1000());
                total=total-1000;
            }else if((total)>=500){
                deposito.add(new Moneda500());
                total=total-500;
            }else if((total)>=100){
                deposito.add(new Moneda100());
                total=total-100;
            }
        }
    }

    /**
     * Cambia las monedas del primer depósito al segundo.
     * @param deposito1: deposito que da monedas
     * @param deposito2: deposito que recibe monedas
     */
    public static void cambiar_monedas_de_deposito(Deposito<Moneda> deposito1, Deposito<Moneda> deposito2){
        while (!deposito1.isEmpty())
            deposito2.add(deposito1.get());
    }
}
