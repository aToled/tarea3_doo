package gui.utils;

import gui.Imagenes.ImagenProducto;
import gui.Paneles.PanelPrincipal;
import logica.Producto;

import javax.swing.*;

/**
 * Esta clase se utiliza para realizar la animación del producto que cae al ser comprado
 * @see Timer
 */
public class Animacion {
    private PanelPrincipal panelPrincipal;
    private ImagenProducto p;
    private Timer timerAnimacion;

    /**
     * Recibe una instancia del panel principal y de un producto para que cuando el producto
     * cambie de posición se vuelva a renderizar el panel principal
     * @param panelPrincipal: Instancia del panel principal
     * @param p: Producto que se desea animar
     * @see PanelPrincipal
     * @see Producto
     */
    public Animacion(PanelPrincipal panelPrincipal, ImagenProducto p) {
        this.panelPrincipal = panelPrincipal;
        this.p = p;
    }

    /**
     * Si la animación aún no comienza y no ha terminado se ejecuta un thread cada 15 milisegundos
     * el cual hace que el producto se desplaze hacia abajo
     */
    public void iniciarOContinuarMovimiento() {
        p.setBounds(p.getX(), p.getY(), ImagenProducto.SIZE, ImagenProducto.SIZE);
        if (p.getParent() == null) {
            panelPrincipal.add(p);
            panelPrincipal.setComponentZOrder(p, 0);
        }

        panelPrincipal.repaint();
        p.repaint();

        if (timerAnimacion == null) {
            timerAnimacion = new Timer(2, _ -> {
                // Lógica de movimiento y condición de parada
                int Ycaida = p.getY() + 5;
                p.setBounds(p.getX(), Ycaida, ImagenProducto.SIZE, ImagenProducto.SIZE);
                panelPrincipal.invalidate();
                if (p.getY() >= 775) {
                    p.setVisible(false);
                    detenerAnimacion();
                }
            });
            timerAnimacion.start();
        }
    }

    /**
     * Se detiene la animación en caso de que esta aún no finaliza y no ha comenzado
     */
    private void detenerAnimacion() {
        if (timerAnimacion != null && timerAnimacion.isRunning()) {
            timerAnimacion.stop();
        }
    }
}
