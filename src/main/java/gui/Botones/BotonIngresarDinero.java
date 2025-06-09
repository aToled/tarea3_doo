package gui.Botones;


import gui.utils.Init;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A travéz de este botón el comprador puede incrementar su cantidad de dinero
 * @see JButton
 */
public class BotonIngresarDinero extends JButton {
    /**
     * Al pulsar el botón se preguntará al usuario la cantidad de dinero que desea recibir
     * y si es una cantidad válida el comprador recibirá las monedas acorde al monto
     */
    public BotonIngresarDinero() {
        setBounds(90, 200, 100, 100);
        setBackground(Color.GRAY);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String input = JOptionPane.showInputDialog(BotonIngresarDinero.this, "Ingrese un monto positivo y múltiplo de 100: ", "Ingresar Dinero", JOptionPane.PLAIN_MESSAGE);

                if(input!=null){
                    try {
                        int monto = Integer.parseInt(input);
                        if(monto%100!=0 || monto<=0){
                            JOptionPane.showMessageDialog(BotonIngresarDinero.this,"Debe ingresar un monto positivo y múltiplo de 100", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        Init.comprador.IngresarDinero(monto);
                        Init.panelDeCompras.actualizarTexto();
                        Init.panelDeCompras.getDispensadorMonedas().repaint();
                        Init.panelComprador.repaint();
                    }catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(BotonIngresarDinero.this,"Ingrese un número", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
    }

    /**
     * Se renderiza como un círculo verde con texto el texto 'Ingresar Dinero'
     * @param g Objeto utilizado para renderizar
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.GREEN);
        g2.fillOval(0, 0, getWidth(), getWidth());
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("Ingresar Dinero", 8, getHeight() / 2);
    }
}
