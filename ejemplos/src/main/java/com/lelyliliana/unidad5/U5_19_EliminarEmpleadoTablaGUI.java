package com.lelyliliana.unidad5;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * EJEMPLO 19 - UNIDAD 5
 *
 * Tema:
 * Eliminación de registros seleccionados en una JTable.
 *
 * Este programa permite explicar:
 * - Selección de filas.
 * - Confirmación antes de eliminar.
 * - Uso de removeRow().
 * - Validación de selección.
 */
public class U5_19_EliminarEmpleadoTablaGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame(
                "Eliminar empleados"
            );

            ventana.setSize(750, 420);
            ventana.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
            );
            ventana.setLocationRelativeTo(null);
            ventana.setLayout(
                new BorderLayout(10, 10)
            );

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
                    "5001",
                    "Mariana López",
                    "Auxiliar administrativa",
                    2300000
                }
            );

            modeloTabla.addRow(
                new Object[]{
                    "5002",
                    "Felipe Gómez",
                    "Desarrollador",
                    3700000
                }
            );

            modeloTabla.addRow(
                new Object[]{
                    "5003",
                    "Daniela Ruiz",
                    "Analista",
                    3000000
                }
            );

            JPanel panelBotones = new JPanel();

            JButton botonEliminar =
                new JButton("Eliminar");

            JButton botonCancelar =
                new JButton("Cancelar selección");

            JButton botonSalir =
                new JButton("Salir");

            panelBotones.add(botonEliminar);
            panelBotones.add(botonCancelar);
            panelBotones.add(botonSalir);

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

                String nombre =
                    modeloTabla.getValueAt(
                        filaSeleccionada,
                        1
                    ).toString();

                int respuesta =
                    JOptionPane.showConfirmDialog(
                        ventana,
                        "¿Confirma la eliminación de "
                        + nombre
                        + "?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                    );

                if (
                    respuesta
                    == JOptionPane.YES_OPTION
                ) {

                    modeloTabla.removeRow(
                        filaSeleccionada
                    );

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Empleado eliminado correctamente.",
                        "Eliminación exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            });

            /*
             * Quita la selección actual sin eliminar datos.
             */
            botonCancelar.addActionListener(evento -> {

                tablaEmpleados.clearSelection();
            });

            botonSalir.addActionListener(evento -> {

                ventana.dispose();
            });

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
}
