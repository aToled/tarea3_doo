import gui.PanelExpendedor;
import gui.VentanaPrincipal;
import logica.Expendedor;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Expendedor expendedor = new Expendedor(5);
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(expendedor);

        ventanaPrincipal.mostrar();
    }
}