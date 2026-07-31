package com.lelyliliana.unidad4;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * Ejemplo de manejo de eventos en botones con Java Swing.
 *
 * Este programa permite explicar:
 * - El evento de clic.
 * - El uso de ActionListener.
 * - Las expresiones lambda.
 * - La modificación de componentes desde un evento.
 */
public class U4_13_EventosBotones {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Se crea la ventana principal.
            JFrame ventana = new JFrame("Eventos en botones");

            ventana.setSize(500, 250);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);

            // Se utiliza FlowLayout para organizar los componentes.
            ventana.setLayout(new FlowLayout());

            // Componentes de la interfaz.
            JLabel mensaje = new JLabel("Presione uno de los botones");

            JButton botonSaludar = new JButton("Saludar");
            JButton botonContar = new JButton("Contar clics");
            JButton botonSalir = new JButton("Salir");

            /*
             * Se utiliza un arreglo de una posición para almacenar
             * el número de clics.
             *
             * Esto permite modificar el valor dentro de la expresión lambda.
             */
            int[] cantidadClics = {0};

            /*
             * Cuando el usuario presiona este botón,
             * se cambia el texto de la etiqueta.
             */
            botonSaludar.addActionListener(evento -> {
                mensaje.setText("¡Hola! Bienvenido al programa.");
            });

            /*
             * Cada vez que se presiona el botón,
             * se incrementa el contador.
             */
            botonContar.addActionListener(evento -> {

                cantidadClics[0]++;

                mensaje.setText(
                    "Cantidad de clics: " + cantidadClics[0]
                );
            });

            /*
             * Este botón cierra únicamente la ventana actual.
             */
            botonSalir.addActionListener(evento -> {
                ventana.dispose();
            });

            // Se agregan los componentes a la ventana.
            ventana.add(mensaje);
            ventana.add(botonSaludar);
            ventana.add(botonContar);
            ventana.add(botonSalir);

            // Se muestra la ventana.
            ventana.setVisible(true);
        });
    }
}
