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
 * EJEMPLO 17 - UNIDAD 5
 *
 * Tema:
 * Consulta y selección de empleados en una JTable.
 *
 * Este programa permite explicar:
 * - Búsqueda por documento.
 * - Recorrido de las filas de una tabla.
 * - Selección automática de una fila.
 * - Carga de datos desde la tabla hacia el formulario.
 */
public class U5_17_ConsultarEmpleadoTablaGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame(
                "Consulta de empleados"
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
             * Datos iniciales de ejemplo.
             */
            modeloTabla.addRow(
                new Object[]{
                    "3001",
                    "Laura Gómez",
                    "Analista",
                    2800000
                }
            );

            modeloTabla.addRow(
                new Object[]{
                    "3002",
                    "Carlos Martínez",
                    "Desarrollador",
                    3500000
                }
            );

            modeloTabla.addRow(
                new Object[]{
                    "3003",
                    "Sofía Torres",
                    "Coordinadora",
                    4200000
                }
            );

            /*
             * Panel de botones.
             */
            JPanel panelBotones = new JPanel();

            JButton botonConsultar =
                new JButton("Consultar");

            JButton botonLimpiar =
                new JButton("Limpiar");

            JButton botonSalir =
                new JButton("Salir");

            panelBotones.add(botonConsultar);
            panelBotones.add(botonLimpiar);
            panelBotones.add(botonSalir);

            /*
             * Consulta un empleado por documento.
             */
            botonConsultar.addActionListener(evento -> {

                String documentoBuscado =
                    campoDocumento.getText().trim();

                if (documentoBuscado.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Ingrese el documento que desea consultar.",
                        "Documento obligatorio",
                        JOptionPane.WARNING_MESSAGE
                    );

                    campoDocumento.requestFocus();
                    return;
                }

                boolean encontrado = false;

                for (
                    int fila = 0;
                    fila < modeloTabla.getRowCount();
                    fila++
                ) {

                    String documento =
                        modeloTabla.getValueAt(
                            fila,
                            0
                        ).toString();

                    if (
                        documento.equals(
                            documentoBuscado
                        )
                    ) {

                        /*
                         * Se cargan los datos de la fila
                         * en los campos del formulario.
                         */
                        campoNombre.setText(
                            modeloTabla.getValueAt(
                                fila,
                                1
                            ).toString()
                        );

                        campoCargo.setText(
                            modeloTabla.getValueAt(
                                fila,
                                2
                            ).toString()
                        );

                        campoSalario.setText(
                            modeloTabla.getValueAt(
                                fila,
                                3
                            ).toString()
                        );

                        /*
                         * Se selecciona la fila encontrada
                         * y se desplaza la tabla hasta ella.
                         */
                        tablaEmpleados.setRowSelectionInterval(
                            fila,
                            fila
                        );

                        tablaEmpleados.scrollRectToVisible(
                            tablaEmpleados.getCellRect(
                                fila,
                                0,
                                true
                            )
                        );

                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "No se encontró un empleado con ese documento.",
                        "Empleado no encontrado",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                    campoNombre.setText("");
                    campoCargo.setText("");
                    campoSalario.setText("");

                    tablaEmpleados.clearSelection();
                }
            });

            /*
             * Al seleccionar una fila con el mouse,
             * sus datos se cargan en el formulario.
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
                    }
                });

            botonLimpiar.addActionListener(evento -> {

                campoDocumento.setText("");
                campoNombre.setText("");
                campoCargo.setText("");
                campoSalario.setText("");

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
}
