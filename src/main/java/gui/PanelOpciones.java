package gui;

import logica.Producto;
import logica.Productos;

import javax.swing.*;
import java.awt.*;

public class PanelOpciones extends JPanel {
    Productos productoSeleccionado = null;

    private class ProductoSeleccionado extends JPanel {
        public ProductoSeleccionado() {
            setBackground(new Color(175, 175, 175));
            JLabel label = new JLabel("No producto seleccionado");

            add(label);
        }
    }

    private class BotonProducto extends JButton {
        private final Productos producto;

        public BotonProducto(Productos producto) {
            this.producto = producto;

            setText(producto.nombre + " $" + producto.precio);
        }
    }

    public PanelOpciones() {
        setBackground(new Color(150, 150, 150));

        setMinimumSize(new Dimension(200, 0));

        Box box = Box.createVerticalBox();
        box.setAlignmentX(CENTER_ALIGNMENT);

        box.add(new ProductoSeleccionado());
        box.add(Box.createRigidArea(new Dimension(0, 25)));

        box.add(new BotonProducto(Productos.COCA));
        box.add(Box.createRigidArea(new Dimension(0, 10)));
        box.add(new BotonProducto(Productos.SPRITE));
        box.add(Box.createRigidArea(new Dimension(0, 10)));
        box.add(new BotonProducto(Productos.FANTA));

        box.add(Box.createRigidArea(new Dimension(0, 10)));
        box.add(new BotonProducto(Productos.SNICKERS));
        box.add(Box.createRigidArea(new Dimension(0, 10)));
        box.add(new BotonProducto(Productos.SUPER8));

        add(box);
    }
}
