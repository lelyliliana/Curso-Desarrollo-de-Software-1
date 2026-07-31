package com.lelyliliana.unidad4;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Ejemplo básico de creación de una ventana con Java Swing.
 *
 * Este programa permite explicar:
 * - La clase JFrame.
 * - El título de una ventana.
 * - El tamaño de la ventana.
 * - La ubicación en la pantalla.
 * - La operación de cierre.
 * - La visibilidad de la ventana.
 */
public class U4_10_VentanaBasica {

    public static void main(String[] args) {

        /*
         * SwingUtilities.invokeLater permite que la interfaz gráfica
         * se cree dentro del hilo encargado de administrar los eventos
         * de Swing.
         */
        SwingUtilities.invokeLater(() -> {

            // Se crea una ventana y se establece su título.
            JFrame ventana = new JFrame("Mi primera ventana en Java");

            // Se establece el ancho y el alto de la ventana.
            ventana.setSize(500, 300);

            /*
             * Se indica qué debe ocurrir cuando el usuario presione
             * el botón de cerrar.
             */
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            /*
             * Un valor null hace que la ventana aparezca centrada
             * en la pantalla.
             */
            ventana.setLocationRelativeTo(null);

            /*
             * La ventana inicialmente está oculta.
             * Con true se hace visible.
             */
            ventana.setVisible(true);
        });
    }
}
