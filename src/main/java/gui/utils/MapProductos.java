package gui.utils;

import logica.*;

import java.util.*;

public class MapProductos extends HashMap<Productos, Deposito> {
    public MapProductos() {
        put(Productos.COCA, Init.expendedor.getCoca());
        put(Productos.SPRITE, Init.expendedor.getSprite());
        put(Productos.FANTA, Init.expendedor.getFanta());
        put(Productos.SNICKERS, Init.expendedor.getSnickers());
        put(Productos.SUPER8, Init.expendedor.getSuper8());
        put(Productos.CHOCMAN, Init.expendedor.getChocman());
    }
}
