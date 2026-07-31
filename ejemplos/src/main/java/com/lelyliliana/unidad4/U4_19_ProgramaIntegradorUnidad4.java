package com.lelyliliana.unidad4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
 * Programa integrador de la Unidad 4.
 *
 * Este ejemplo permite integrar:
 * - Clases y objetos.
 * - Herencia.
 * - Sobrescritura de métodos.
 * - Polimorfismo.
 * - Composición.
 * - ArrayList.
 * - Interfaces gráficas con Swing.
 * - Eventos.
 * - Validación de datos.
 * - JTable y DefaultTableModel.
 */
public class U4_19_ProgramaIntegradorUnidad4 {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Lista que almacenará diferentes tipos de productos.
            ArrayList<ProductoUnidad4> productos = new ArrayList<>();

            // Ventana principal.
            JFrame ventana = new JFrame(
                "Sistema de inventario - Programa integrador"
            );

            ventana.setSize(850, 500);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);
            ventana.setLayout(new BorderLayout(10, 10));

            // Panel del formulario.
            JPanel panelFormulario = new JPanel(
                new GridLayout(5, 2, 10, 10)
            );

            JLabel etiquetaCodigo = new JLabel("Código:");
            JTextField campoCodigo = new JTextField();

            JLabel etiquetaNombre = new JLabel("Nombre:");
            JTextField campoNombre = new JTextField();

            JLabel etiquetaPrecio = new JLabel("Precio:");
            JTextField campoPrecio = new JTextField();

            JLabel etiquetaCantidad = new JLabel("Cantidad:");
            JTextField campoCantidad = new JTextField();

            JLabel etiquetaTipo = new JLabel("Tipo de producto:");

            String[] tipos = {
                "Producto general",
                "Producto tecnológico"
            };

            JComboBox<String> listaTipos = new JComboBox<>(tipos);

            panelFormulario.add(etiquetaCodigo);
            panelFormulario.add(campoCodigo);

            panelFormulario.add(etiquetaNombre);
            panelFormulario.add(campoNombre);

            panelFormulario.add(etiquetaPrecio);
            panelFormulario.add(campoPrecio);

            panelFormulario.add(etiquetaCantidad);
            panelFormulario.add(campoCantidad);

            panelFormulario.add(etiquetaTipo);
            panelFormulario.add(listaTipos);

            // Columnas de la tabla.
            String[] columnas = {
                "Código",
                "Nombre",
                "Tipo",
                "Precio",
                "Cantidad",
                "Valor inventario"
            };

            DefaultTableModel modeloTabla = new DefaultTableModel(
                columnas,
                0
            );

            JTable tablaProductos = new JTable(modeloTabla);

            JScrollPane panelTabla = new JScrollPane(tablaProductos);

            // Panel para los botones.
            JPanel panelBotones = new JPanel();

            JButton botonAgregar = new JButton("Agregar");
            JButton botonEliminar = new JButton("Eliminar");
            JButton botonMostrarTotal = new JButton("Mostrar total");
            JButton botonLimpiar = new JButton("Limpiar");

            panelBotones.add(botonAgregar);
            panelBotones.add(botonEliminar);
            panelBotones.add(botonMostrarTotal);
            panelBotones.add(botonLimpiar);

            /*
             * Evento para agregar productos.
             */
            botonAgregar.addActionListener(evento -> {

                String codigo = campoCodigo.getText().trim();
                String nombre = campoNombre.getText().trim();
                String textoPrecio = campoPrecio.getText().trim();
                String textoCantidad = campoCantidad.getText().trim();

                if (
                    codigo.isEmpty()
                    || nombre.isEmpty()
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

                    ProductoUnidad4 producto;

                    /*
                     * Polimorfismo:
                     * la variable producto puede almacenar objetos
                     * de diferentes clases relacionadas por herencia.
                     */
                    if (listaTipos.getSelectedIndex() == 0) {

                        producto = new ProductoGeneralUnidad4(
                            codigo,
                            nombre,
                            precio,
                            cantidad
                        );

                    } else {

                        producto = new ProductoTecnologicoUnidad4(
                            codigo,
                            nombre,
                            precio,
                            cantidad,
                            12
                        );
                    }

                    productos.add(producto);

                    Object[] fila = {
                        producto.getCodigo(),
                        producto.getNombre(),
                        producto.obtenerTipo(),
                        producto.getPrecio(),
                        producto.getCantidad(),
                        producto.calcularValorInventario()
                    };

                    modeloTabla.addRow(fila);

                    limpiarCampos(
                        campoCodigo,
                        campoNombre,
                        campoPrecio,
                        campoCantidad,
                        listaTipos
                    );

                } catch (NumberFormatException excepcion) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "El precio y la cantidad deben ser valores numéricos.",
                        "Error de formato",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            });

            /*
             * Evento para eliminar el producto seleccionado.
             */
            botonEliminar.addActionListener(evento -> {

                int filaSeleccionada = tablaProductos.getSelectedRow();

                if (filaSeleccionada == -1) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "Seleccione un producto de la tabla.",
                        "Sin selección",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                productos.remove(filaSeleccionada);
                modeloTabla.removeRow(filaSeleccionada);
            });

            /*
             * Evento para calcular el valor total del inventario.
             */
            botonMostrarTotal.addActionListener(evento -> {

                double totalInventario = 0;

                for (ProductoUnidad4 producto : productos) {
                    totalInventario += producto.calcularValorInventario();
                }

                JOptionPane.showMessageDialog(
                    ventana,
                    "Valor total del inventario: $"
                    + String.format("%.2f", totalInventario),
                    "Total del inventario",
                    JOptionPane.INFORMATION_MESSAGE
                );
            });

            /*
             * Evento para limpiar el formulario.
             */
            botonLimpiar.addActionListener(evento -> {

                limpiarCampos(
                    campoCodigo,
                    campoNombre,
                    campoPrecio,
                    campoCantidad,
                    listaTipos
                );
            });

            ventana.add(panelFormulario, BorderLayout.NORTH);
            ventana.add(panelTabla, BorderLayout.CENTER);
            ventana.add(panelBotones, BorderLayout.SOUTH);

            ventana.setVisible(true);
        });
    }

    /**
     * Método estático para limpiar los campos del formulario.
     */
    private static void limpiarCampos(
        JTextField campoCodigo,
        JTextField campoNombre,
        JTextField campoPrecio,
        JTextField campoCantidad,
        JComboBox<String> listaTipos
    ) {

        campoCodigo.setText("");
        campoNombre.setText("");
        campoPrecio.setText("");
        campoCantidad.setText("");

        listaTipos.setSelectedIndex(0);

        campoCodigo.requestFocus();
    }
}

/**
 * Clase abstracta que representa un producto.
 */
abstract class ProductoUnidad4 {

    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    public ProductoUnidad4(
        String codigo,
        String nombre,
        double precio,
        int cantidad
    ) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularValorInventario() {
        return precio * cantidad;
    }

    public abstract String obtenerTipo();
}

/**
 * Clase que representa un producto general.
 */
class ProductoGeneralUnidad4 extends ProductoUnidad4 {

    public ProductoGeneralUnidad4(
        String codigo,
        String nombre,
        double precio,
        int cantidad
    ) {

        super(codigo, nombre, precio, cantidad);
    }

    @Override
    public String obtenerTipo() {
        return "Producto general";
    }
}

/**
 * Clase que representa un producto tecnológico.
 */
class ProductoTecnologicoUnidad4 extends ProductoUnidad4 {

    private int mesesGarantia;

    public ProductoTecnologicoUnidad4(
        String codigo,
        String nombre,
        double precio,
        int cantidad,
        int mesesGarantia
    ) {

        super(codigo, nombre, precio, cantidad);

        this.mesesGarantia = mesesGarantia;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    @Override
    public String obtenerTipo() {
        return "Tecnológico - garantía: " + mesesGarantia + " meses";
    }
}
