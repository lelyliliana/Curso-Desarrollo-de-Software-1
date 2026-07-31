package com.lelyliliana.unidad4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Ejemplo de validación de campos en una interfaz gráfica.
 *
 * Este programa permite explicar:
 * - Validación de campos vacíos.
 * - Conversión de texto a número.
 * - Uso de try-catch.
 * - Mensajes de advertencia y error.
 * - Uso de requestFocus().
 */
public class U4_16_ValidacionCamposGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Se crea la ventana principal.
            JFrame ventana = new JFrame("Validación de datos");

            ventana.setSize(500, 300);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);
            ventana.setLayout(new BorderLayout(10, 10));

            // Panel que contiene los campos.
            JPanel panelFormulario = new JPanel(
                new GridLayout(3, 2, 10, 10)
            );

            JLabel etiquetaNombre = new JLabel("Nombre:");
            JTextField campoNombre = new JTextField();

            JLabel etiquetaEdad = new JLabel("Edad:");
            JTextField campoEdad = new JTextField();

            JLabel etiquetaPromedio = new JLabel("Promedio:");
            JTextField campoPromedio = new JTextField();

            panelFormulario.add(etiquetaNombre);
            panelFormulario.add(campoNombre);

            panelFormulario.add(etiquetaEdad);
            panelFormulario.add(campoEdad);

            panelFormulario.add(etiquetaPromedio);
            panelFormulario.add(campoPromedio);

            // Panel para los botones.
            JPanel panelBotones = new JPanel();

            JButton botonValidar = new JButton("Validar");
            JButton botonLimpiar = new JButton("Limpiar");

            panelBotones.add(botonValidar);
            panelBotones.add(botonLimpiar);

            /*
             * Evento del botón Validar.
             */
            botonValidar.addActionListener(evento -> {

                String nombre = campoNombre.getText().trim();
                String textoEdad = campoEdad.getText().trim();
                String textoPromedio = campoPromedio.getText().trim();

                // Validación del nombre.
                if (nombre.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Debe ingresar el nombre.",
                        "Campo obligatorio",
                        JOptionPane.WARNING_MESSAGE
                    );

                    campoNombre.requestFocus();
                    return;
                }

                // Validación de la edad.
                if (textoEdad.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Debe ingresar la edad.",
                        "Campo obligatorio",
                        JOptionPane.WARNING_MESSAGE
                    );

                    campoEdad.requestFocus();
                    return;
                }

                // Validación del promedio.
                if (textoPromedio.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Debe ingresar el promedio.",
                        "Campo obligatorio",
                        JOptionPane.WARNING_MESSAGE
                    );

                    campoPromedio.requestFocus();
                    return;
                }

                try {

                    int edad = Integer.parseInt(textoEdad);
                    double promedio = Double.parseDouble(textoPromedio);

                    if (edad < 0 || edad > 120) {

                        JOptionPane.showMessageDialog(
                            ventana,
                            "La edad debe estar entre 0 y 120 años.",
                            "Edad inválida",
                            JOptionPane.WARNING_MESSAGE
                        );

                        campoEdad.requestFocus();
                        return;
                    }

                    if (promedio < 0.0 || promedio > 5.0) {

                        JOptionPane.showMessageDialog(
                            ventana,
                            "El promedio debe estar entre 0.0 y 5.0.",
                            "Promedio inválido",
                            JOptionPane.WARNING_MESSAGE
                        );

                        campoPromedio.requestFocus();
                        return;
                    }

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Datos válidos."
                        + "\nNombre: " + nombre
                        + "\nEdad: " + edad
                        + "\nPromedio: " + promedio,
                        "Validación exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                } catch (NumberFormatException excepcion) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "La edad y el promedio deben ser valores numéricos.",
                        "Error de formato",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            });

            /*
             * Evento del botón Limpiar.
             */
            botonLimpiar.addActionListener(evento -> {

                campoNombre.setText("");
                campoEdad.setText("");
                campoPromedio.setText("");

                campoNombre.requestFocus();
            });

            // Se agregan los paneles a la ventana.
            ventana.add(panelFormulario, BorderLayout.CENTER);
            ventana.add(panelBotones, BorderLayout.SOUTH);

            // Se muestra la ventana.
            ventana.setVisible(true);
        });
    }
}
