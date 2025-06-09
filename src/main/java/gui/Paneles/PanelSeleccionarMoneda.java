package gui.Paneles;

import gui.Ventanas.VentanaIngresarMoneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Se utiliza dentro del menú para seleccionar la moneda que el usuario desea
 * ingresar al depósito
 * @see JPanel
 */
public class PanelSeleccionarMoneda extends JPanel{
    JLabel valorLabel;

    /**
     * Si el usuario pulsa este JPanel se mandará una señal a la VentanaIngresarMoneda
     * sobre cual es el valor seleccionado
     * @param valor_moneda: Valor de la moneda mostrada
     * @param ventana: Instancia de la ventana de la cual este componente es parte
     * @see VentanaIngresarMoneda
     */
    public PanelSeleccionarMoneda(int valor_moneda, VentanaIngresarMoneda ventana) {
        setPreferredSize(new Dimension(50, 50));
        setLayout(null);

        valorLabel = new JLabel("$" + valor_moneda);
        valorLabel.setBounds(10, 0, 50, 50);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.monedaSeleccionada(valor_moneda);
            }
        });

        add(valorLabel);
    }

    /**
     * Se renderiza igual a el component ImagenMoneda
     * @param g Objeto utilizado para renderizar
     * @see gui.Imagenes.ImagenMoneda
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, 50, 50);
    }
}
