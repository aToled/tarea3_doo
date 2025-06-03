package gui;
import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel{
    public PanelComprador(){
        setLayout(null);
        setSize(300,550);
        setPreferredSize(new Dimension(200,0));
        setLocation(200,200);
        setBackground(Color.GRAY);

        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        // Fondo y Bordes
        g.setColor(Color.GRAY);
        g.fillRect(0,0,getWidth(),getWidth());
        g.setColor(Color.BLACK);
        g.drawRect(0,0,getWidth()-1,getHeight()-1);

        // Dinero total comprador
        int dinero_total = Init.comprador.CuantoDinero();
        g.setColor(Color.BLACK);
        g.drawString("Dinero total: $" + dinero_total,10,20);

        // Monedas en orden del comprador
        Init.Mostrar_monedas_en_orden(Init.comprador.getMonedero(), g, 0);

        // Monedas en orden del expendedor //TODO TEMPORAL; BORRAR!!!
        Init.Mostrar_monedas_en_orden(Init.expendedor.getMonedas_ingresadas(), g, 20);

    }
}
