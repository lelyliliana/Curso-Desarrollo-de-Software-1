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
 * EJEMPLO 14 - UNIDAD 5
 *
 * Tema:
 * Registro de empleados en una JTable.
 *
 * Este programa permite explicar:
 * - Formularios gráficos.
 * - Uso de JTable.
 * - Uso de DefaultTableModel.
 * - Adición de filas.
 * - Eliminación de registros seleccionados.
 * - Validación de campos.
 *
 * En este ejemplo, los datos se almacenan únicamente
 * en memoria mientras el programa está abierto.
 */
public class U5_14_TablaEmpleadosGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame(
                "Tabla de empleados"
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
             * Se definen las columnas de la tabla.
             */
            String[] columnas = {
                "Documento",
                "Nombre",
                "Cargo",
                "Salario"
            };

            /*
             * El modelo administra los datos
             * que se muestran en la JTable.
             */
            DefaultTableModel modeloTabla =
                new DefaultTableModel(columnas, 0);

            JTable tablaEmpleados =
                new JTable(modeloTabla);

            JScrollPane panelTabla =
                new JScrollPane(tablaEmpleados);

            /*
             * Panel de botones.
             */
            JPanel panelBotones = new JPanel();

            JButton botonAgregar =
                new JButton("Agregar");

            JButton botonEliminar =
                new JButton("Eliminar");

            JButton botonLimpiar =
                new JButton("Limpiar");

            JButton botonSalir =
                new JButton("Salir");

            panelBotones.add(botonAgregar);
            panelBotones.add(botonEliminar);
            panelBotones.add(botonLimpiar);
            panelBotones.add(botonSalir);

            /*
             * Evento para agregar una fila.
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

                    /*
                     * Se verifica que el documento
                     * no esté repetido en la tabla.
                     */
                    for (
                        int fila = 0;
                        fila < modeloTabla.getRowCount();
                        fila++
                    ) {

                        String documentoExistente =
                            modeloTabla.getValueAt(
                                fila,
                                0
                            ).toString();

                        if (
                            documentoExistente.equals(
                                documento
                            )
                        ) {

                            JOptionPane.showMessageDialog(
                                ventana,
                                "Ya existe un empleado con ese documento.",
                                "Registro duplicado",
                                JOptionPane.WARNING_MESSAGE
                            );

                            campoDocumento.requestFocus();
                            return;
                        }
                    }

                    Object[] fila = {
                        documento,
                        nombre,
                        cargo,
                        salario
                    };

                    modeloTabla.addRow(fila);

                    limpiarCampos(
                        campoDocumento,
                        campoNombre,
                        campoCargo,
                        campoSalario
                    );

                    campoDocumento.requestFocus();

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
             * Evento para eliminar la fila seleccionada.
             */
            botonEliminar.addActionListener(evento -> {

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

                int respuesta =
                    JOptionPane.showConfirmDialog(
                        ventana,
                        "¿Desea eliminar el registro seleccionado?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION
                    );

                if (
                    respuesta
                    == JOptionPane.YES_OPTION
                ) {

                    modeloTabla.removeRow(
                        filaSeleccionada
                    );
                }
            });

            botonLimpiar.addActionListener(evento -> {

                limpiarCampos(
                    campoDocumento,
                    campoNombre,
                    campoCargo,
                    campoSalario
                );

                tablaEmpleados.clearSelection();
                campoDocumento.requestFocus();
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
     * Limpia los campos del formulario.
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
}
