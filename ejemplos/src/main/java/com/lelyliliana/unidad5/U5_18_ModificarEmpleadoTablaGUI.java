package com.lelyliliana.unidad5;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * EJEMPLO 18 - UNIDAD 5
 *
 * Tema:
 * Modificación de registros dentro de una JTable.
 *
 * Este programa permite explicar:
 * - Selección de filas.
 * - Carga de datos en un formulario.
 * - Actualización de valores con setValueAt().
 * - Validación de campos.
 */
public class U5_18_ModificarEmpleadoTablaGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame(
                "Modificar empleados"
            );

            ventana.setSize(800, 500);
            ventana.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
            );
            ventana.setLocationRelativeTo(null);
            ventana.setLayout(
                new BorderLayout(10, 10)
            );

            /*
             * Panel del formulario.
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
             * Modelo de la tabla.
             */
            String[] columnas = {
                "Documento",
                "Nombre",
                "Cargo",
                "Salario"
            };

            DefaultTableModel modeloTabla =
                new DefaultTableModel(columnas, 0) {

                    @Override
                    public boolean isCellEditable(
                        int fila,
                        int columna
                    ) {

                        return false;
                    }
                };

            JTable tablaEmpleados =
                new JTable(modeloTabla);

            JScrollPane panelTabla =
                new JScrollPane(tablaEmpleados);

            /*
             * Registros de ejemplo.
             */
            modeloTabla.addRow(
                new Object[]{
                    "4001",
                    "Andrea Pérez",
                    "Auxiliar",
                    2200000
                }
            );

            modeloTabla.addRow(
                new Object[]{
                    "4002",
                    "Miguel Gómez",
                    "Desarrollador",
                    3600000
                }
            );

            modeloTabla.addRow(
                new Object[]{
                    "4003",
                    "Camila Torres",
                    "Analista",
                    2900000
                }
            );

            /*
             * Panel de botones.
             */
            JPanel panelBotones = new JPanel();

            JButton botonModificar =
                new JButton("Modificar");

            JButton botonCancelar =
                new JButton("Cancelar");

            JButton botonSalir =
                new JButton("Salir");

            panelBotones.add(botonModificar);
            panelBotones.add(botonCancelar);
            panelBotones.add(botonSalir);

            /*
             * Al seleccionar una fila, sus datos
             * se cargan en el formulario.
             */
            tablaEmpleados.getSelectionModel()
                .addListSelectionListener(evento -> {

                    if (
                        !evento.getValueIsAdjusting()
                        && tablaEmpleados.getSelectedRow() != -1
                    ) {

                        int filaSeleccionada =
                            tablaEmpleados.getSelectedRow();

                        campoDocumento.setText(
                            modeloTabla.getValueAt(
                                filaSeleccionada,
                                0
                            ).toString()
                        );

                        campoNombre.setText(
                            modeloTabla.getValueAt(
                                filaSeleccionada,
                                1
                            ).toString()
                        );

                        campoCargo.setText(
                            modeloTabla.getValueAt(
                                filaSeleccionada,
                                2
                            ).toString()
                        );

                        campoSalario.setText(
                            modeloTabla.getValueAt(
                                filaSeleccionada,
                                3
                            ).toString()
                        );

                        /*
                         * El documento no se puede modificar
                         * porque identifica de manera única
                         * al empleado.
                         */
                        campoDocumento.setEnabled(false);
                    }
                });

            /*
             * Evento para modificar la fila seleccionada.
             */
            botonModificar.addActionListener(evento -> {

                int filaSeleccionada =
                    tablaEmpleados.getSelectedRow();

                if (filaSeleccionada == -1) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Seleccione un empleado de la tabla.",
                        "Sin selección",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                String nombre =
                    campoNombre.getText().trim();

                String cargo =
                    campoCargo.getText().trim();

                String textoSalario =
                    campoSalario.getText().trim();

                if (
                    nombre.isEmpty()
                    || cargo.isEmpty()
                    || textoSalario.isEmpty()
                ) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Nombre, cargo y salario son obligatorios.",
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

                    /*
                     * setValueAt() modifica el contenido
                     * de una celda específica.
                     */
                    modeloTabla.setValueAt(
                        nombre,
                        filaSeleccionada,
                        1
                    );

                    modeloTabla.setValueAt(
                        cargo,
                        filaSeleccionada,
                        2
                    );

                    modeloTabla.setValueAt(
                        salario,
                        filaSeleccionada,
                        3
                    );

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Empleado modificado correctamente.",
                        "Modificación exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                    limpiarFormulario(
                        campoDocumento,
                        campoNombre,
                        campoCargo,
                        campoSalario,
                        tablaEmpleados
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
             * Cancela la modificación.
             */
            botonCancelar.addActionListener(evento -> {

                limpiarFormulario(
                    campoDocumento,
                    campoNombre,
                    campoCargo,
                    campoSalario,
                    tablaEmpleados
                );
            });

            botonSalir.addActionListener(evento -> {
                ventana.dispose();
            });

            ventana.add(
                panelFormulario,
                BorderLayout.NORTH
            );

            ventana.add(
                panelTabla,
                BorderLayout.CENTER
            );

            ventana.add(
                panelBotones,
                BorderLayout.SOUTH
            );

            ventana.setVisible(true);
        });
    }

    /**
     * Limpia el formulario y elimina
     * la selección actual de la tabla.
     */
    private static void limpiarFormulario(
        JTextField campoDocumento,
        JTextField campoNombre,
        JTextField campoCargo,
        JTextField campoSalario,
        JTable tablaEmpleados
    ) {

        campoDocumento.setText("");
        campoNombre.setText("");
        campoCargo.setText("");
        campoSalario.setText("");

        campoDocumento.setEnabled(true);

        tablaEmpleados.clearSelection();

        campoDocumento.requestFocus();
    }
}
