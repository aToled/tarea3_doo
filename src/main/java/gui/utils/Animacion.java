package gui.utils;

import gui.Imagenes.ImagenProducto;
import gui.Paneles.PanelPrincipal;
import logica.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase se utiliza para realizar la animación del producto que cae al ser comprado
 */
public class Animacion {
    private PanelPrincipal panelPrincipal;
    private Producto p;
    private Timer timerAnimacion;
    private boolean condicionDeParadaAlcanzada = false;

    /**
     * Recibe una instancia del panel principal y de un producto para que cuando el producto
     * cambie de posición se vuelva a renderizar el panel principal
     * @param panelPrincipal: Instancia del panel principal
     * @param p: Producto que se desea animar
     * @see PanelPrincipal
     * @see Producto
     */
    public Animacion(PanelPrincipal panelPrincipal, Producto p) {
        this.panelPrincipal = panelPrincipal;
        this.p = p;
    }

    /**
     * Si la animación aun no comienza y no ha terminado se ejecuta un thread cada 15 milisegundos
     * el cual hace que el producto se desplaze hacia abajo
     */
    public void iniciarOContinuarMovimiento() {
        if (condicionDeParadaAlcanzada) {
            System.out.println("La condición de parada ya fue alcanzada. Reinicia para mover de nuevo.");
            return;
        }

        p.setBounds(p.x, p.y, ImagenProducto.SIZE, ImagenProducto.SIZE);
        if (p.getParent() == null) {
            panelPrincipal.add(p);
            panelPrincipal.setComponentZOrder(p, 0);
        }

        panelPrincipal.repaint();
        p.repaint();

        if (timerAnimacion == null) {
            timerAnimacion = new Timer(15,  new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    // Lógica de movimiento y condición de parada
                    p.y += 5;
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

    /**
     * Se detiene la animación en caso de que esta aun no finaliza y no ha comenzado
     */
    private void detenerAnimacion() {
        if (timerAnimacion != null && timerAnimacion.isRunning()) {
            timerAnimacion.stop();
            condicionDeParadaAlcanzada = true; // Marcar que la condición se cumplió
            System.out.println("Animación detenida.");
        }
    }
}
