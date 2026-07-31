package com.lelyliliana.unidad5;

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
 * EJEMPLO 13 - UNIDAD 5
 *
 * Tema:
 * Formulario gráfico para registrar empleados.
 *
 * Este programa permite explicar:
 * - Captura de datos con JTextField.
 * - Validación de campos vacíos.
 * - Conversión de texto a número.
 * - Manejo de eventos.
 * - Botones Nuevo, Agregar, Cancelar y Salir.
 */
public class U5_13_FormularioEmpleadoGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame(
                "Registro de empleados"
            );

            ventana.setSize(550, 350);
            ventana.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
            );
            ventana.setLocationRelativeTo(null);
            ventana.setLayout(
                new BorderLayout(10, 10)
            );

            /*
             * Panel principal del formulario.
             */
            JPanel panelFormulario = new JPanel(
                new GridLayout(4, 2, 10, 10)
            );

            JLabel etiquetaDocumento =
                new JLabel("Documento:");

            JTextField campoDocumento =
                new JTextField();

            JLabel etiquetaNombre =
                new JLabel("Nombre:");

            JTextField campoNombre =
                new JTextField();

            JLabel etiquetaCargo =
                new JLabel("Cargo:");

            JTextField campoCargo =
                new JTextField();

            JLabel etiquetaSalario =
                new JLabel("Salario:");

            JTextField campoSalario =
                new JTextField();

            panelFormulario.add(etiquetaDocumento);
            panelFormulario.add(campoDocumento);

            panelFormulario.add(etiquetaNombre);
            panelFormulario.add(campoNombre);

            panelFormulario.add(etiquetaCargo);
            panelFormulario.add(campoCargo);

            panelFormulario.add(etiquetaSalario);
            panelFormulario.add(campoSalario);

            /*
             * Panel de botones.
             */
            JPanel panelBotones = new JPanel();

            JButton botonNuevo =
                new JButton("Nuevo");

            JButton botonAgregar =
                new JButton("Agregar");

            JButton botonCancelar =
                new JButton("Cancelar");

            JButton botonSalir =
                new JButton("Salir");

            panelBotones.add(botonNuevo);
            panelBotones.add(botonAgregar);
            panelBotones.add(botonCancelar);
            panelBotones.add(botonSalir);

            /*
             * Evento del botón Nuevo.
             */
            botonNuevo.addActionListener(evento -> {

                limpiarCampos(
                    campoDocumento,
                    campoNombre,
                    campoCargo,
                    campoSalario
                );

                habilitarCampos(
                    campoDocumento,
                    campoNombre,
                    campoCargo,
                    campoSalario,
                    true
                );

                campoDocumento.requestFocus();
            });

            /*
             * Evento del botón Agregar.
             */
            botonAgregar.addActionListener(evento -> {

                String documento =
                    campoDocumento.getText().trim();

                String nombre =
                    campoNombre.getText().trim();

                String cargo =
                    campoCargo.getText().trim();

                String textoSalario =
                    campoSalario.getText().trim();

                if (
                    documento.isEmpty()
                    || nombre.isEmpty()
                    || cargo.isEmpty()
                    || textoSalario.isEmpty()
                ) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Todos los campos son obligatorios.",
                        "Datos incompletos",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                try {

                    double salario =
                        Double.parseDouble(textoSalario);

                    if (salario <= 0) {

                        JOptionPane.showMessageDialog(
                            ventana,
                            "El salario debe ser mayor que cero.",
                            "Salario inválido",
                            JOptionPane.WARNING_MESSAGE
                        );

                        campoSalario.requestFocus();
                        return;
                    }

                    String datosEmpleado =
                        "Documento: " + documento
                        + "\nNombre: " + nombre
                        + "\nCargo: " + cargo
                        + "\nSalario: $" + salario;

                    JOptionPane.showMessageDialog(
                        ventana,
                        datosEmpleado,
                        "Empleado registrado",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                    limpiarCampos(
                        campoDocumento,
                        campoNombre,
                        campoCargo,
                        campoSalario
                    );

                } catch (NumberFormatException excepcion) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "El salario debe ser un valor numérico.",
                        "Error de formato",
                        JOptionPane.ERROR_MESSAGE
                    );

                    campoSalario.requestFocus();
                }
            });

            /*
             * Evento del botón Cancelar.
             */
            botonCancelar.addActionListener(evento -> {

                limpiarCampos(
                    campoDocumento,
                    campoNombre,
                    campoCargo,
                    campoSalario
                );

                habilitarCampos(
                    campoDocumento,
                    campoNombre,
                    campoCargo,
                    campoSalario,
                    false
                );
            });

            /*
             * Evento del botón Salir.
             */
            botonSalir.addActionListener(evento -> {
                ventana.dispose();
            });

            ventana.add(
                panelFormulario,
                BorderLayout.CENTER
            );

            ventana.add(
                panelBotones,
                BorderLayout.SOUTH
            );

            /*
             * Los campos comienzan deshabilitados.
             * El usuario debe presionar Nuevo.
             */
            habilitarCampos(
                campoDocumento,
                campoNombre,
                campoCargo,
                campoSalario,
                false
            );

            ventana.setVisible(true);
        });
    }

    /**
     * Limpia todos los campos del formulario.
     */
    private static void limpiarCampos(
        JTextField campoDocumento,
        JTextField campoNombre,
        JTextField campoCargo,
        JTextField campoSalario
    ) {

        campoDocumento.setText("");
        campoNombre.setText("");
        campoCargo.setText("");
        campoSalario.setText("");
    }

    /**
     * Habilita o deshabilita los campos.
     */
    private static void habilitarCampos(
        JTextField campoDocumento,
        JTextField campoNombre,
        JTextField campoCargo,
        JTextField campoSalario,
        boolean habilitar
    ) {

        campoDocumento.setEnabled(habilitar);
        campoNombre.setEnabled(habilitar);
        campoCargo.setEnabled(habilitar);
        campoSalario.setEnabled(habilitar);
    }
}
