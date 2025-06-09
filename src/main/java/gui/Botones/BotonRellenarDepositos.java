package gui.Botones;


import gui.utils.Init;
import logica.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Este botón se utiliza para rellenar los depósitos de productos que están vacíos.
 * @see JButton
 */
public class BotonRellenarDepositos extends JButton {
    /**
     * Inicializa el botón, además al ser pulsado actualiza el panelExpendedor para reflejar el rellenado.
     */
    public BotonRellenarDepositos() {
        setBounds(50, 100, 100, 100);
        setBackground(new Color(66, 66, 66));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Init.expendedor.rellenarProducto();
                Productos[] productos = Productos.values();
                for (Productos prod : productos) {
                    int[] pos = Init.panelExpendedor.obtenerFilaColumna(prod);
                    Init.panelExpendedor.reagregarProductos(prod, pos[0], pos[1]);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
    }

    /**
     * Se renderiza como un círculo azul con texto el texto 'Rellenar Depósitos'.
     * @param g Objeto utilizado para renderizar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLUE);
        g2.fillOval(0, 0, getWidth(), getWidth());
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("Rellenar", 22, 35);
        g.drawString("Depósitos", 22, 55);
        g.drawString("Vacíos", 22, 75);
    }
}
