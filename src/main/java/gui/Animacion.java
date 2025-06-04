package gui;

import logica.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animacion {
    private PanelPrincipal panelPrincipal;
    private Producto p;
    private Timer timerAnimacion;
    private boolean condicionDeParadaAlcanzada = false;

    public Animacion(PanelPrincipal panelPrincipal, Producto p) {
        this.panelPrincipal = panelPrincipal;
        this.p = p;
    }

    public void iniciarOContinuarMovimiento() {
        if (condicionDeParadaAlcanzada) {
            System.out.println("La condición de parada ya fue alcanzada. Reinicia para mover de nuevo.");
            return;
        }

        Init.panelExpendedor.reagregarProductos(p.cualProducto, p.fila, p.columna);
        p.setBounds(p.x, p.y, ImagenProducto.SIZE, ImagenProducto.SIZE);
        if (p.getParent() == null) {
            panelPrincipal.add(p);
            panelPrincipal.setComponentZOrder(p, 0);
        }

        panelPrincipal.repaint();
        p.repaint();

        if (timerAnimacion == null) {
            timerAnimacion = new Timer(0,  new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    // Lógica de movimiento y condición de parada
                    p.y += 1;
                    p.setBounds(p.x, p.y, ImagenProducto.SIZE, ImagenProducto.SIZE);
                    panelPrincipal.invalidate();
                    if (p.y >= 775) {
                        p.setVisible(false);
                        detenerAnimacion();
                    }
                }
            });
            timerAnimacion.start();
            System.out.println("Animación iniciada.");
        } else if (!timerAnimacion.isRunning()) {
            timerAnimacion.start();
            System.out.println("Animación continuada.");
        } else {
            System.out.println("La animación ya está en curso.");
        }
    }

    private void detenerAnimacion() {
        if (timerAnimacion != null && timerAnimacion.isRunning()) {
            timerAnimacion.stop();
            condicionDeParadaAlcanzada = true; // Marcar que la condición se cumplió
            System.out.println("Animación detenida.");
        }
    }
}
