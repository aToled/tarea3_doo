package gui;

import logica.CocaCola;
import logica.Producto;
import logica.Productos;

import java.util.*;

public class MapProductos extends HashMap<Productos, ArrayList<Producto>> {
    public MapProductos() {
        put(Productos.COCA, new ArrayList<>());
        put(Productos.SPRITE, new ArrayList<>());
        put(Productos.FANTA, new ArrayList<>());
        put(Productos.SNICKERS, new ArrayList<>());
        put(Productos.SUPER8, new ArrayList<>());
        put(Productos.CHOCMAN, new ArrayList<>());
    }
}
