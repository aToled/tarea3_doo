package gui;

import logica.*;

import java.util.*;

public class MapProductos extends HashMap<Productos, Deposito> {
    public MapProductos() {
        System.out.println("Cocas: " + Init.expendedor.coca.size());
        put(Productos.COCA, Init.expendedor.coca);
        put(Productos.SPRITE, Init.expendedor.sprite);
        put(Productos.FANTA, Init.expendedor.fanta);
        put(Productos.SNICKERS, Init.expendedor.snickers);
        put(Productos.SUPER8, Init.expendedor.super8);
        put(Productos.CHOCMAN, Init.expendedor.chocman);
    }
}
