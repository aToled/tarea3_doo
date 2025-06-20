package gui.Paneles;

import gui.utils.Init;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Este panel contiene a todos los componentes gráficos del expendedor.
 * @see JPanel
 */
public class PanelPrincipal extends JPanel {
    public Panel_de_Compras pdeCom;
    public PanelExpendedor pExp;
    public Panel_Recoleccion_Productos PRP;

    /**
     * Se agregan el panel de comprador, panel expendedor y el panel de recolección producto.
     */
    public PanelPrincipal() {
        setBackground(new Color(66, 66, 66));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());

        pdeCom = new Panel_de_Compras(this);
        pExp = new PanelExpendedor(this);
        PRP = new Panel_Recoleccion_Productos();

        add(new PanelExpendedorIzquierdo(this), BorderLayout.WEST);
        add(pExp, BorderLayout.CENTER);
        add(PRP, BorderLayout.SOUTH);
        add(pdeCom, BorderLayout.EAST);
        Init.panelDeCompras=pdeCom;
        Init.panelExpendedor=pExp;
    }

    /**
     * Se renderiza con el panel expendedor en el lado izquierdo, el panel
     * de compras en el lado derecho y el panel para recoger productos en
     * la parte de abajo, además asegura que este último este por encima de cualquier otra cosa
     * (util para que se vea mejor la animación).
     * @param g Objeto utilizado para renderizar.
     */
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        setComponentZOrder(PRP,0);
    }
}
