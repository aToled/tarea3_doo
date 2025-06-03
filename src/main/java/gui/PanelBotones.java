package gui;

import javax.swing.*;
import java.awt.*;

public class PanelBotones extends JPanel {
    public PanelBotones(){
        setBackground(new Color(66, 66, 66));
        setBounds(20, 135, 150, 105);
        //añade los numeros que identifican a los productos
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 2; col++) {
                int x = 35 + col * ImagenProducto.SIZE + col * 100;
                int y = 50 + fila * ImagenProducto.SIZE + fila * 100;
                x += ImagenProducto.SIZE/2 - ImagenNumero.SIZE/2;
                y += ImagenProducto.SIZE + 7;
                ImagenNumero num = new ImagenNumero(x, y,fila*2+col+1, new Color(66, 66, 66) ,Color.WHITE, Color.BLACK);
                add(num);
            }
        }
    }
}
