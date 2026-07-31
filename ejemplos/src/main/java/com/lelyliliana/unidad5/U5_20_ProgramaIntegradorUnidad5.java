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
 * PROGRAMA INTEGRADOR - UNIDAD 5
 *
 * Tema:
 * CRUD completo de empleados con interfaz gráfica
 * y almacenamiento permanente en archivo.
 *
 * Integra:
 * - Clases y objetos.
 * - ArrayList.
 * - Lectura y escritura de archivos.
 * - Operaciones CRUD.
 * - JTable.
 * - Formularios.
 * - Eventos.
 * - Validación de datos.
 */
public class U5_20_ProgramaIntegradorUnidad5 {

    private static final Path RUTA_ARCHIVO =
        Path.of("empleados_integrador.txt");

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            List<EmpleadoIntegrador> empleados =
                cargarEmpleados();

            JFrame ventana = new JFrame(
                "Sistema de gestión de empleados"
            );

            ventana.setSize(900, 550);
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

            cargarTabla(modeloTabla, empleados);

            JPanel panelBotones = new JPanel();

            JButton botonNuevo =
                new JButton("Nuevo");

            JButton botonAgregar =
                new JButton("Agregar");

            JButton botonConsultar =
                new JButton("Consultar");

            JButton botonModificar =
                new JButton("Modificar");

            JButton botonEliminar =
                new JButton("Eliminar");

            JButton botonCancelar =
                new JButton("Cancelar");

            JButton botonSalir =
                new JButton("Salir");

            panelBotones.add(botonNuevo);
            panelBotones.add(botonAgregar);
            panelBotones.add(botonConsultar);
            panelBotones.add(botonModificar);
            panelBotones.add(botonEliminar);
            panelBotones.add(botonCancelar);
            panelBotones.add(botonSalir);

            botonNuevo.addActionListener(evento -> {

                limpiarFormulario(
                    campoDocumento,
                    campoNombre,
                    campoCargo,
                    campoSalario,
                    tablaEmpleados
                );

                campoDocumento.setEnabled(true);
                campoDocumento.requestFocus();
            });

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

                    mostrarAdvertencia(
                        ventana,
                        "Todos los campos son obligatorios."
                    );

                    return;
                }

                if (
                    buscarPorDocumento(
                        empleados,
                        documento
                    ) != null
                ) {

                    mostrarAdvertencia(
                        ventana,
                        "Ya existe un empleado con ese documento."
                    );

                    return;
                }

                try {

                    double salario =
                        Double.parseDouble(textoSalario);

                    if (salario <= 0) {

                        mostrarAdvertencia(
                            ventana,
                            "El salario debe ser mayor que cero."
                        );

                        return;
                    }

                    EmpleadoIntegrador empleado =
                        new EmpleadoIntegrador(
                            documento,
                            nombre,
                            cargo,
                            salario
                        );

                    empleados.add(empleado);

                    guardarEmpleados(empleados);
                    cargarTabla(modeloTabla, empleados);

                    limpiarFormulario(
                        campoDocumento,
                        campoNombre,
                        campoCargo,
                        campoSalario,
                        tablaEmpleados
                    );

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Empleado agregado correctamente."
                    );

                } catch (NumberFormatException excepcion) {

                    mostrarAdvertencia(
                        ventana,
                        "El salario debe ser numérico."
                    );
                }
            });

            botonConsultar.addActionListener(evento -> {

                String documento =
                    campoDocumento.getText().trim();

                EmpleadoIntegrador empleado =
                    buscarPorDocumento(
                        empleados,
                        documento
                    );

                if (empleado == null) {

                    mostrarAdvertencia(
                        ventana,
                        "No se encontró el empleado."
                    );

                    return;
                }

                campoNombre.setText(
                    empleado.getNombre()
                );

                campoCargo.setText(
                    empleado.getCargo()
                );

                campoSalario.setText(
                    String.valueOf(
                        empleado.getSalario()
                    )
                );

                seleccionarFila(
                    tablaEmpleados,
                    modeloTabla,
                    documento
                );

                campoDocumento.setEnabled(false);
            });

            botonModificar.addActionListener(evento -> {

                String documento =
                    campoDocumento.getText().trim();

                EmpleadoIntegrador empleado =
                    buscarPorDocumento(
                        empleados,
                        documento
                    );

                if (empleado == null) {

                    mostrarAdvertencia(
                        ventana,
                        "Primero consulte o seleccione un empleado."
                    );

                    return;
                }

                try {

                    String nombre =
                        campoNombre.getText().trim();

                    String cargo =
                        campoCargo.getText().trim();

                    double salario =
                        Double.parseDouble(
                            campoSalario.getText().trim()
                        );

                    if (
                        nombre.isEmpty()
                        || cargo.isEmpty()
                        || salario <= 0
                    ) {

                        mostrarAdvertencia(
                            ventana,
                            "Verifique los datos ingresados."
                        );

                        return;
                    }

                    empleado.setNombre(nombre);
                    empleado.setCargo(cargo);
                    empleado.setSalario(salario);

                    guardarEmpleados(empleados);
                    cargarTabla(modeloTabla, empleados);

                    limpiarFormulario(
                        campoDocumento,
                        campoNombre,
                        campoCargo,
                        campoSalario,
                        tablaEmpleados
                    );

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Empleado modificado correctamente."
                    );

                } catch (NumberFormatException excepcion) {

                    mostrarAdvertencia(
                        ventana,
                        "El salario debe ser numérico."
                    );
                }
            });

            botonEliminar.addActionListener(evento -> {

                String documento =
                    campoDocumento.getText().trim();

                EmpleadoIntegrador empleado =
                    buscarPorDocumento(
                        empleados,
                        documento
                    );

                if (empleado == null) {

                    mostrarAdvertencia(
                        ventana,
                        "Seleccione o consulte un empleado."
                    );

                    return;
                }

                int respuesta =
                    JOptionPane.showConfirmDialog(
                        ventana,
                        "¿Desea eliminar a "
                        + empleado.getNombre()
                        + "?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION
                    );

                if (
                    respuesta
                    == JOptionPane.YES_OPTION
                ) {

                    empleados.remove(empleado);

                    guardarEmpleados(empleados);
                    cargarTabla(modeloTabla, empleados);

                    limpiarFormulario(
                        campoDocumento,
                        campoNombre,
                        campoCargo,
                        campoSalario,
                        tablaEmpleados
                    );

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Empleado eliminado correctamente."
                    );
                }
            });

            tablaEmpleados.getSelectionModel()
                .addListSelectionListener(evento -> {

                    if (
                        !evento.getValueIsAdjusting()
                        && tablaEmpleados.getSelectedRow() != -1
                    ) {

                        int fila =
                            tablaEmpleados.getSelectedRow();

                        campoDocumento.setText(
                            modeloTabla.getValueAt(
                                fila,
                                0
                            ).toString()
                        );

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

                        campoDocumento.setEnabled(false);
                    }
                });

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

    private static EmpleadoIntegrador buscarPorDocumento(
        List<EmpleadoIntegrador> empleados,
        String documento
    ) {

        for (EmpleadoIntegrador empleado : empleados) {

            if (
                empleado.getDocumento().equals(
                    documento
                )
            ) {

                return empleado;
            }
        }

        return null;
    }

    private static List<EmpleadoIntegrador> cargarEmpleados() {

        List<EmpleadoIntegrador> empleados =
            new ArrayList<>();

        if (!Files.exists(RUTA_ARCHIVO)) {
            return empleados;
        }

        try {

            for (
                String registro
                : Files.readAllLines(RUTA_ARCHIVO)
            ) {

                try {

                    empleados.add(
                        EmpleadoIntegrador
                            .crearDesdeRegistro(
                                registro
                            )
                    );

                } catch (
                    IllegalArgumentException excepcion
                ) {

                    System.out.println(
                        "Registro inválido: "
                        + registro
                    );
                }
            }

        } catch (IOException excepcion) {

            System.out.println(
                "No fue posible leer el archivo."
            );
        }

        return empleados;
    }

    private static void guardarEmpleados(
        List<EmpleadoIntegrador> empleados
    ) {

        List<String> registros =
            new ArrayList<>();

        for (EmpleadoIntegrador empleado : empleados) {

            registros.add(
                empleado.convertirARegistro()
            );
        }

        try {

            Files.write(
                RUTA_ARCHIVO,
                registros
            );

        } catch (IOException excepcion) {

            JOptionPane.showMessageDialog(
                null,
                "No fue posible guardar el archivo.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private static void cargarTabla(
        DefaultTableModel modeloTabla,
        List<EmpleadoIntegrador> empleados
    ) {

        modeloTabla.setRowCount(0);

        for (EmpleadoIntegrador empleado : empleados) {

            modeloTabla.addRow(
                new Object[]{
                    empleado.getDocumento(),
                    empleado.getNombre(),
                    empleado.getCargo(),
                    empleado.getSalario()
                }
            );
        }
    }

    private static void seleccionarFila(
        JTable tabla,
        DefaultTableModel modelo,
        String documento
    ) {

        for (
            int fila = 0;
            fila < modelo.getRowCount();
            fila++
        ) {

            if (
                modelo.getValueAt(
                    fila,
                    0
                ).toString().equals(documento)
            ) {

                tabla.setRowSelectionInterval(
                    fila,
                    fila
                );

                break;
            }
        }
    }

    private static void limpiarFormulario(
        JTextField campoDocumento,
        JTextField campoNombre,
        JTextField campoCargo,
        JTextField campoSalario,
        JTable tabla
    ) {

        campoDocumento.setText("");
        campoNombre.setText("");
        campoCargo.setText("");
        campoSalario.setText("");

        campoDocumento.setEnabled(true);

        tabla.clearSelection();
        campoDocumento.requestFocus();
    }

    private static void mostrarAdvertencia(
        JFrame ventana,
        String mensaje
    ) {

        JOptionPane.showMessageDialog(
            ventana,
            mensaje,
            "Validación",
            JOptionPane.WARNING_MESSAGE
        );
    }
}

/**
 * Clase que representa un empleado.
 */
class EmpleadoIntegrador {

    private String documento;
    private String nombre;
    private String cargo;
    private double salario;

    public EmpleadoIntegrador(
        String documento,
        String nombre,
        String cargo,
        double salario
    ) {

        this.documento = documento;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String convertirARegistro() {

        return documento
            + ";"
            + nombre
            + ";"
            + cargo
            + ";"
            + salario;
    }

    public static EmpleadoIntegrador crearDesdeRegistro(
        String registro
    ) {

        String[] datos = registro.split(";");

        if (datos.length < 4) {

            throw new IllegalArgumentException(
                "Formato incorrecto."
            );
        }

        try {

            return new EmpleadoIntegrador(
                datos[0],
                datos[1],
                datos[2],
                Double.parseDouble(datos[3])
            );

        } catch (NumberFormatException excepcion) {

            throw new IllegalArgumentException(
                "El salario no es válido."
            );
        }
    }
}
