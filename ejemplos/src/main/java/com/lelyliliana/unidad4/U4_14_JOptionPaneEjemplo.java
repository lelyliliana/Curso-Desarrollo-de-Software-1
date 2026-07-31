package com.lelyliliana.unidad4;

import javax.swing.JOptionPane;

/**
 * Ejemplo de cuadros de diálogo con JOptionPane.
 *
 * Este programa permite explicar:
 * - Mensajes informativos.
 * - Entrada de datos.
 * - Conversión de texto a número.
 * - Cuadros de confirmación.
 * - Mensajes de error.
 */
public class U4_14_JOptionPaneEjemplo {

    public static void main(String[] args) {

        // Se muestra un mensaje informativo.
        JOptionPane.showMessageDialog(
            null,
            "Bienvenido al sistema",
            "Información",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Se solicita el nombre del usuario.
        String nombre = JOptionPane.showInputDialog(
            null,
            "Ingrese su nombre:"
        );

        // Se solicita la edad.
        String textoEdad = JOptionPane.showInputDialog(
            null,
            "Ingrese su edad:"
        );

        try {

            // Se convierte el texto ingresado a un número entero.
            int edad = Integer.parseInt(textoEdad);

            // Se muestra la información ingresada.
            JOptionPane.showMessageDialog(
                null,
                "Nombre: " + nombre + "\nEdad: " + edad,
                "Datos registrados",
                JOptionPane.INFORMATION_MESSAGE
            );

            /*
             * Se presenta un cuadro de confirmación.
             * El resultado se guarda como un número entero.
             */
            int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Desea finalizar el programa?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION
            );

            // Se evalúa la respuesta seleccionada.
            if (respuesta == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(
                    null,
                    "Programa finalizado."
                );

            } else {

                JOptionPane.showMessageDialog(
                    null,
                    "El programa continuará."
                );
            }

        } catch (NumberFormatException excepcion) {

            // Se muestra un mensaje cuando la edad no es numérica.
            JOptionPane.showMessageDialog(
                null,
                "La edad debe ser un número entero.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
