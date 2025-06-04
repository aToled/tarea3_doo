package gui;

import logica.Comprador;
import logica.Deposito;
import logica.Expendedor;
import logica.Moneda;

import java.awt.*;

public class Init {
    public static Expendedor expendedor;
    public static Comprador comprador;
    public static PanelComprador panelComprador;
    public static PanelExpendedor panelExpendedor;
    public static Panel_de_Compras panelDeCompras;

    public static void inicializar(){
        expendedor = new Expendedor(10);
        comprador = new Comprador(4400);
    }

    public static void Mostrar_monedas_en_orden(Deposito<Moneda> depMon, Graphics g, int Desfase){
        // Monedas en orden del comprador
        Moneda[] monedero = depMon.toArray(Moneda[]::new);
        int m1500 = 0;
        int m1000 = 0;
        int m500 = 0;
        int m100 = 0;
        for(Moneda m : monedero){
            int valor = m.getValor();
            if(valor==1500) m1500++;
            else if (valor==1000) m1000++;
            else if (valor==500) m500++;
            else if (valor==100) m100++;
        }
        int y = 40+Desfase;

        if (m1500 > 0) {
            g.drawString("Posee "+m1500+" monedas de $1500", 10, y);
            y += 20;
        }
        if (m1000 > 0) {
            g.drawString("Posee "+m1000+" monedas de $1000", 10, y);
            y += 20;
        }
        if (m500 > 0) {
            g.drawString("Posee "+m500+" monedas de $500", 10, y);
            y += 20;
        }
        if (m100 > 0) {
            g.drawString("Posee "+m100+" monedas de $100", 10, y);
        }
    }
}
