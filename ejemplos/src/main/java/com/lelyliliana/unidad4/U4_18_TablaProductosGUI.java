package com.lelyliliana.unidad4;

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
 * Ejemplo de registro de productos usando JTable.
 *
 * Este programa permite explicar:
 * - Creación de tablas.
 * - Uso de DefaultTableModel.
 * - Adición de filas.
 * - Eliminación de registros.
 * - Validación de datos numéricos.
 */
public class U4_18_TablaProductosGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame("Registro de productos");

            ventana.setSize(700, 450);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);
            ventana.setLayout(new BorderLayout(10, 10));

            JPanel panelFormulario = new JPanel(
                new GridLayout(3, 2, 10, 10)
            );

            JLabel etiquetaNombre = new JLabel("Producto:");
            JTextField campoNombre = new JTextField();

            JLabel etiquetaPrecio = new JLabel("Precio:");
            JTextField campoPrecio = new JTextField();

            JLabel etiquetaCantidad = new JLabel("Cantidad:");
            JTextField campoCantidad = new JTextField();

            panelFormulario.add(etiquetaNombre);
            panelFormulario.add(campoNombre);

            panelFormulario.add(etiquetaPrecio);
            panelFormulario.add(campoPrecio);

            panelFormulario.add(etiquetaCantidad);
            panelFormulario.add(campoCantidad);

            /*
             * Se definen los nombres de las columnas.
             */
            String[] columnas = {
                "Producto",
                "Precio",
                "Cantidad",
                "Subtotal"
            };

            /*
             * DefaultTableModel permite administrar
             * los datos que se muestran en la tabla.
             */
            DefaultTableModel modelo = new DefaultTableModel(
                columnas,
                0
            );

            JTable tablaProductos = new JTable(modelo);

            /*
             * JScrollPane permite mostrar barras de desplazamiento
             * cuando la tabla contiene muchos registros.
             */
            JScrollPane panelDesplazamiento =
                new JScrollPane(tablaProductos);

            JPanel panelBotones = new JPanel();

            JButton botonAgregar = new JButton("Agregar");
            JButton botonEliminar = new JButton("Eliminar seleccionado");
            JButton botonLimpiar = new JButton("Limpiar campos");

            panelBotones.add(botonAgregar);
            panelBotones.add(botonEliminar);
            panelBotones.add(botonLimpiar);

            botonAgregar.addActionListener(evento -> {

                String nombre = campoNombre.getText().trim();
                String textoPrecio = campoPrecio.getText().trim();
                String textoCantidad = campoCantidad.getText().trim();

                if (
                    nombre.isEmpty()
                    || textoPrecio.isEmpty()
                    || textoCantidad.isEmpty()
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

                    double precio = Double.parseDouble(textoPrecio);
                    int cantidad = Integer.parseInt(textoCantidad);

                    if (precio <= 0 || cantidad <= 0) {

                        JOptionPane.showMessageDialog(
                            ventana,
                            "El precio y la cantidad deben ser mayores que cero.",
                            "Valores inválidos",
                            JOptionPane.WARNING_MESSAGE
                        );

                        return;
                    }

                    double subtotal = precio * cantidad;

                    Object[] fila = {
                        nombre,
                        precio,
                        cantidad,
                        subtotal
                    };

                    modelo.addRow(fila);

                    campoNombre.setText("");
                    campoPrecio.setText("");
                    campoCantidad.setText("");

                    campoNombre.requestFocus();

                } catch (NumberFormatException excepcion) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "El precio y la cantidad deben ser valores numéricos.",
                        "Error de formato",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            });

            botonEliminar.addActionListener(evento -> {

                int filaSeleccionada =
                    tablaProductos.getSelectedRow();

                if (filaSeleccionada == -1) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Seleccione una fila de la tabla.",
                        "Sin selección",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                modelo.removeRow(filaSeleccionada);
            });

            botonLimpiar.addActionListener(evento -> {

                campoNombre.setText("");
                campoPrecio.setText("");
                campoCantidad.setText("");

                campoNombre.requestFocus();
            });

            ventana.add(panelFormulario, BorderLayout.NORTH);
            ventana.add(panelDesplazamiento, BorderLayout.CENTER);
            ventana.add(panelBotones, BorderLayout.SOUTH);

            ventana.setVisible(true);
        });
    }
}
