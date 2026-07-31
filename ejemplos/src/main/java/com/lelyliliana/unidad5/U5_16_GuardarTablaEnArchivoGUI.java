package com.lelyliliana.unidad5;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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
 * EJEMPLO 16 - UNIDAD 5
 *
 * Tema:
 * Guardar los datos de una JTable en un archivo.
 *
 * Este programa permite:
 * - Agregar empleados a una tabla.
 * - Recorrer las filas de la JTable.
 * - Convertir cada fila en una línea de texto.
 * - Guardar todos los registros en un archivo.
 */
public class U5_16_GuardarTablaEnArchivoGUI {

    private static final Path RUTA_ARCHIVO =
        Path.of("empleados_tabla.txt");

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame(
                "Guardar tabla en archivo"
            );

            ventana.setSize(800, 500);
            ventana.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
            );
            ventana.setLocationRelativeTo(null);
            ventana.setLayout(
                new BorderLayout(10, 10)
            );

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

            JPanel panelBotones = new JPanel();

            JButton botonAgregar =
                new JButton("Agregar");

            JButton botonGuardar =
                new JButton("Guardar archivo");

            JButton botonEliminar =
                new JButton("Eliminar");

            JButton botonSalir =
                new JButton("Salir");

            panelBotones.add(botonAgregar);
            panelBotones.add(botonGuardar);
            panelBotones.add(botonEliminar);
            panelBotones.add(botonSalir);

            /*
             * Agrega los datos del formulario a la tabla.
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

                        return;
                    }

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
                                "El documento ya está registrado.",
                                "Registro duplicado",
                                JOptionPane.WARNING_MESSAGE
                            );

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

                } catch (NumberFormatException excepcion) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "El salario debe ser un valor numérico.",
                        "Error de formato",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            });

            /*
             * Recorre la tabla y guarda todas las filas
             * en el archivo empleados_tabla.txt.
             */
            botonGuardar.addActionListener(evento -> {

                if (modeloTabla.getRowCount() == 0) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "La tabla no contiene registros.",
                        "Sin datos",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                List<String> registros =
                    new ArrayList<>();

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

                    String nombre =
                        modeloTabla.getValueAt(
                            fila,
                            1
                        ).toString();

                    String cargo =
                        modeloTabla.getValueAt(
                            fila,
                            2
                        ).toString();

                    String salario =
                        modeloTabla.getValueAt(
                            fila,
                            3
                        ).toString();

                    String registro =
                        documento
                        + ";"
                        + nombre
                        + ";"
                        + cargo
                        + ";"
                        + salario;

                    registros.add(registro);
                }

                try {

                    Files.write(
                        RUTA_ARCHIVO,
                        registros
                    );

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Registros guardados: "
                        + registros.size()
                        + "\nArchivo: "
                        + RUTA_ARCHIVO.toAbsolutePath(),
                        "Guardado exitoso",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                } catch (IOException excepcion) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "No fue posible guardar el archivo.\n"
                        + excepcion.getMessage(),
                        "Error de escritura",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            });

            botonEliminar.addActionListener(evento -> {

                int filaSeleccionada =
                    tablaEmpleados.getSelectedRow();

                if (filaSeleccionada == -1) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Seleccione una fila.",
                        "Sin selección",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                modeloTabla.removeRow(
                    filaSeleccionada
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

        campoDocumento.requestFocus();
    }
}
