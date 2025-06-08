package gui.Imagenes;

import logica.Moneda;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase se utiliza para renderizar una moneda en base a su valor monetario
 */
public class ImagenMoneda extends JPanel {
    Moneda moneda;

    /**
     * Guarda una referencia de moneda para poder renderizar su valor en paintComponent
     * @param moneda
     */
    public ImagenMoneda(Moneda moneda) {
        this.moneda = moneda;
        setBackground(new Color(50, 50, 50));
        setPreferredSize(new Dimension(25, 25));
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
        g2.fillOval(0, 0, 25, 25);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Bold", Font.BOLD, 9));
        String valor = "$" + moneda.getValor();

        FontMetrics fm = g2.getFontMetrics();
        int valWidth = fm.stringWidth(valor);
        g2.drawString(valor, (25 - valWidth) / 2, 15);
    }
}
