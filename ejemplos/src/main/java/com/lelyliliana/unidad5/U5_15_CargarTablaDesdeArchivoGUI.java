package com.lelyliliana.unidad5;

import java.awt.BorderLayout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * EJEMPLO 15 - UNIDAD 5
 *
 * Tema:
 * Carga de registros desde un archivo hacia una JTable.
 *
 * Este programa permite explicar:
 * - Lectura de archivos.
 * - Separación de datos con split().
 * - Uso de JTable.
 * - Uso de DefaultTableModel.
 * - Actualización visual de una tabla.
 */
public class U5_15_CargarTablaDesdeArchivoGUI {

    private static final Path RUTA_ARCHIVO =
        Path.of("empleados_crud.txt");

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame(
                "Empleados almacenados"
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

            /*
             * Se impide que el usuario edite directamente
             * las celdas de la tabla.
             */
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

            JPanel panelBotones = new JPanel();

            JButton botonCargar =
                new JButton("Cargar archivo");

            JButton botonLimpiar =
                new JButton("Limpiar tabla");

            JButton botonSalir =
                new JButton("Salir");

            panelBotones.add(botonCargar);
            panelBotones.add(botonLimpiar);
            panelBotones.add(botonSalir);

            /*
             * Evento para leer el archivo
             * y cargar los registros en la tabla.
             */
            botonCargar.addActionListener(evento -> {

                /*
                 * Se eliminan primero las filas existentes
                 * para evitar que se dupliquen los registros.
                 */
                modeloTabla.setRowCount(0);

                if (!Files.exists(RUTA_ARCHIVO)) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "El archivo empleados_crud.txt no existe.\n"
                        + "Primero ejecute U5_12_CRUDConsolaArchivo.",
                        "Archivo no encontrado",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                try {

                    List<String> registros =
                        Files.readAllLines(RUTA_ARCHIVO);

                    int registrosValidos = 0;

                    for (String registro : registros) {

                        String[] datos =
                            registro.split(";");

                        if (datos.length >= 4) {

                            try {

                                double salario =
                                    Double.parseDouble(
                                        datos[3]
                                    );

                                Object[] fila = {
                                    datos[0],
                                    datos[1],
                                    datos[2],
                                    salario
                                };

                                modeloTabla.addRow(fila);
                                registrosValidos++;

                            } catch (
                                NumberFormatException excepcion
                            ) {

                                System.out.println(
                                    "Salario inválido en el registro: "
                                    + registro
                                );
                            }

                        } else {

                            System.out.println(
                                "Registro con formato incorrecto: "
                                + registro
                            );
                        }
                    }

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Registros cargados: "
                        + registrosValidos,
                        "Carga completada",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                } catch (IOException excepcion) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "No fue posible leer el archivo.\n"
                        + excepcion.getMessage(),
                        "Error de lectura",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            });

            /*
             * Limpia únicamente la tabla visual.
             * No elimina los datos almacenados en el archivo.
             */
            botonLimpiar.addActionListener(evento -> {

                modeloTabla.setRowCount(0);
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
