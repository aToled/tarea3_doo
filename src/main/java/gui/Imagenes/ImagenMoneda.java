package gui.Imagenes;

import logica.Moneda;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase se utiliza para renderizar una moneda en base a su valor monetario
 * @see JPanel
 */
public class ImagenMoneda extends JPanel {
    private final Moneda moneda;
    private int size;

    /**
     * Guarda una referencia de moneda para poder renderizar su valor en paintComponent
     * @param moneda
     */
    public ImagenMoneda(Moneda moneda, int size) {
        this.moneda = moneda;
        this.size = size;
        setBackground(new Color(50, 50, 50));
        setPreferredSize(new Dimension(size, size));
        setLayout(null);
    }

    /**
     * Se renderiza como un círculo amarillo con un texto en el centro indicando su valor
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.YELLOW);
        g2.fillOval(0, 0, size, size);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Bold", Font.BOLD, (size/3)+1));
        String valor = "$" + moneda.getValor();
        String serie = Integer.toString(moneda.getSerie());

        FontMetrics fm = g2.getFontMetrics();
        int valWidth = fm.stringWidth(valor);
        int serWidth = fm.stringWidth(serie);

        if(size >= 50){
            g2.setFont(new Font("Bold", Font.BOLD, 13));
            g2.drawString(valor, 7, (size / 3) + 6);
            g2.drawString(serie, 4, (size / 2) + 10);
        }else {
            g2.drawString(valor, (size - valWidth) / 2, (size / 2) + 3);
        }
    }
}
