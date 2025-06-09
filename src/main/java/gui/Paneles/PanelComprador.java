package gui.Paneles;


import gui.Botones.BotonIngresarDinero;
import gui.utils.Init;
import logica.Deposito;
import logica.Producto;
import logica.Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * En este panel se muestra al usuario las monedas que dispone el comprador al igual que un
 * botón que permite obtener más dinero si es requerido.
 * @see JPanel
 */
public class PanelComprador extends JPanel{
    private BotonIngresarDinero botonIngresarDinero;

    /**
     * Configura el panel del Comprador, agrega dos botones: uno para ingresar dinero y el otro para consumir productos,
     * el de consumir productos despliega un menu para seleccionar y consumir dicho producto.
     */
    public PanelComprador(){
        setLayout(null);
        setBackground(Color.GRAY);
        Init.panelComprador=this;

        JButton botonConsumir = new JButton("Consumir Producto");
        botonConsumir.setBounds(50, 315, 200, 30);
        botonConsumir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarMenuConsumo();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });

        botonIngresarDinero = new BotonIngresarDinero();
        add(botonIngresarDinero);
        add(botonConsumir);
    }

    /**
     * Muestra un menu desplegable que lista los tipos de productos que el comprador
     * posee, a la hora de seleccionar un producto llama al método Consumir del comprador
     * y si no hay productos disponibles muestra una ventana con un mensaje informativo.
     */
    private void mostrarMenuConsumo() {
        ArrayList<Productos> ListaOpciones = getListaOpciones();
        if (ListaOpciones.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No tienes productos para consumir.");
            return;
        }
        Productos[] opciones = ListaOpciones.toArray(new Productos[0]);

        JComboBox<Productos> comboBox = new JComboBox<>(opciones);

        int opcion = JOptionPane.showConfirmDialog(this, comboBox, "Elige producto a consumir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (opcion == JOptionPane.OK_OPTION) {
            Productos elegido = (Productos) comboBox.getSelectedItem();
            Init.comprador.Consumir(elegido);
        }
    }

    /**
     * Obtiene una lista con los tipos de productos comprados por el Comprador.
     * Recorre el Depósito de Productos_comprados para construir la lista sin elementos duplicados
     * @return tal lista
     */
    private static ArrayList<Productos> getListaOpciones() {
        ArrayList<Productos> ListaOpciones = new ArrayList<>();
        Deposito<Producto> pComprados = Init.comprador.getProductos_comprados();
        for (int i=0; i<pComprados.size(); i++) {
            Productos tipoProducto = pComprados.get(i).cualProducto;
            boolean pAgregado = false;
            for (Productos productoExistente : ListaOpciones) {
                if (productoExistente == tipoProducto) {
                    pAgregado = true;
                    break;
                }
            }
            if (!pAgregado) {
                ListaOpciones.add(tipoProducto);
            }
        }
        return ListaOpciones;
    }

    /**
     * Se renderiza la cantidad total de dinero, la cantidad de monedas de cada valor
     * y por último el botón para recibir más dinero
     * @param g Objeto utilizado para renderizar
     */
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
        g.setColor(Color.WHITE);
        g.drawString("Dinero total: $" + dinero_total,10,20);

        // Monedas en orden del comprador
        Init.Mostrar_monedas_en_orden(Init.comprador.getMonedero(), g, 0);
    }
}
