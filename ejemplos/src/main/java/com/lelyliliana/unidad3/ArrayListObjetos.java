package com.lelyliliana.unidad3;

/*
 * EJEMPLO 19 - UNIDAD 3
 *
 * Tema:
 * Almacenamiento de objetos dentro de un ArrayList.
 *
 * En este programa se crea una clase Producto
 * y luego se almacenan varios objetos Producto
 * dentro de una lista dinámica.
 *
 * Conceptos incluidos:
 *
 * - Clases y objetos.
 * - Constructor.
 * - Getters y setters.
 * - ArrayList de objetos.
 * - Recorrido de colecciones.
 * - Búsqueda por atributos.
 * - Modificación y eliminación.
 */

import java.util.ArrayList;

public class ArrayListObjetos {

    public static void main(String[] args) {

        System.out.println("ARRAYLIST DE OBJETOS");
        System.out.println("----------------------------------------");

        /*
         * ==================================================
         * CREACIÓN DEL ARRAYLIST
         * ==================================================
         *
         * La lista almacenará objetos de tipo Producto.
         */
        ArrayList<Producto> productos =
                new ArrayList<>();

        /*
         * ==================================================
         * CREACIÓN DE OBJETOS
         * ==================================================
         */

        Producto producto1 =
                new Producto(
                        101,
                        "Teclado",
                        85000.0,
                        5
                );

        Producto producto2 =
                new Producto(
                        102,
                        "Mouse",
                        45000.0,
                        8
                );

        Producto producto3 =
                new Producto(
                        103,
                        "Monitor",
                        780000.0,
                        3
                );

        /*
         * ==================================================
         * AGREGAR OBJETOS A LA LISTA
         * ==================================================
         */

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        /*
         * También puede crearse y agregarse un objeto
         * directamente.
         */
        productos.add(
                new Producto(
                        104,
                        "Memoria USB",
                        35000.0,
                        10
                )
        );

        System.out.println(
                "Cantidad de productos registrados: "
                        + productos.size()
        );

        /*
         * ==================================================
         * RECORRIDO DE LA LISTA
         * ==================================================
         */

        System.out.println("\nLISTA DE PRODUCTOS");
        System.out.println("----------------------------------------");

        for (Producto producto : productos) {

            producto.mostrarInformacion();

            System.out.println("----------------------------------------");
        }

        /*
         * ==================================================
         * CONSULTAR UN OBJETO POR ÍNDICE
         * ==================================================
         */

        Producto productoConsultado =
                productos.get(1);

        System.out.println("\nPRODUCTO EN LA POSICIÓN 1");
        System.out.println("----------------------------------------");

        productoConsultado.mostrarInformacion();

        /*
         * ==================================================
         * MODIFICAR UN OBJETO
         * ==================================================
         *
         * Obtenemos el objeto y modificamos sus atributos
         * mediante setters.
         */

        Producto productoModificar =
                productos.get(0);

        productoModificar.setPrecio(90000.0);
        productoModificar.setCantidad(7);

        System.out.println("\nPRODUCTO MODIFICADO");
        System.out.println("----------------------------------------");

        productoModificar.mostrarInformacion();

        /*
         * ==================================================
         * BÚSQUEDA POR CÓDIGO
         * ==================================================
         */

        int codigoBuscado = 103;
        Producto productoEncontrado = null;

        for (Producto producto : productos) {

            if (producto.getCodigo() == codigoBuscado) {

                productoEncontrado = producto;

                break;
            }
        }

        System.out.println("\nBÚSQUEDA POR CÓDIGO");
        System.out.println("----------------------------------------");

        if (productoEncontrado != null) {

            System.out.println(
                    "Producto encontrado:"
            );

            productoEncontrado.mostrarInformacion();

        } else {

            System.out.println(
                    "No se encontró un producto con el código "
                            + codigoBuscado
            );
        }

        /*
         * ==================================================
         * BÚSQUEDA POR NOMBRE
         * ==================================================
         */

        String nombreBuscado = "mouse";
        boolean existeProducto = false;

        for (Producto producto : productos) {

            if (
                    producto
                            .getNombre()
                            .equalsIgnoreCase(nombreBuscado)
            ) {

                existeProducto = true;

                System.out.println(
                        "\nProducto encontrado por nombre:"
                );

                producto.mostrarInformacion();

                break;
            }
        }

        if (!existeProducto) {

            System.out.println(
                    "El producto no fue encontrado."
            );
        }

        /*
         * ==================================================
         * CÁLCULO DEL VALOR TOTAL DEL INVENTARIO
         * ==================================================
         */

        double valorTotalInventario = 0.0;

        for (Producto producto : productos) {

            valorTotalInventario +=
                    producto.calcularValorInventario();
        }

        System.out.println("\nVALOR TOTAL DEL INVENTARIO");
        System.out.println("----------------------------------------");

        System.out.printf(
                "Valor total: $%,.2f%n",
                valorTotalInventario
        );

        /*
         * ==================================================
         * ELIMINAR UN OBJETO
         * ==================================================
         *
         * Eliminamos el objeto ubicado en la posición 2.
         */

        Producto productoEliminado =
                productos.remove(2);

        System.out.println("\nPRODUCTO ELIMINADO");
        System.out.println("----------------------------------------");

        productoEliminado.mostrarInformacion();

        System.out.println(
                "\nCantidad actual de productos: "
                        + productos.size()
        );

        /*
         * ==================================================
         * MOSTRAR LA LISTA FINAL
         * ==================================================
         */

        System.out.println("\nLISTA FINAL");
        System.out.println("----------------------------------------");

        for (int i = 0; i < productos.size(); i++) {

            Producto producto =
                    productos.get(i);

            System.out.println(
                    "Posición: " + i
            );

            producto.mostrarInformacion();

            System.out.println("----------------------------------------");
        }
    }
}

/*
 * Clase que representa un producto.
 */
class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    /*
     * Constructor.
     */
    public Producto(
            int codigo,
            String nombre,
            double precio,
            int cantidad
    ) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /*
     * Getters y setters.
     */

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {

        if (precio >= 0) {
            this.precio = precio;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {

        if (cantidad >= 0) {
            this.cantidad = cantidad;
        }
    }

    /*
     * Calcula el valor total del producto
     * dentro del inventario.
     */
    public double calcularValorInventario() {

        return precio * cantidad;
    }

    /*
     * Muestra la información del producto.
     */
    public void mostrarInformacion() {

        System.out.println(
                "Código: " + codigo
        );

        System.out.println(
                "Nombre: " + nombre
        );

        System.out.printf(
                "Precio: $%,.2f%n",
                precio
        );

        System.out.println(
                "Cantidad: " + cantidad
        );

        System.out.printf(
                "Valor en inventario: $%,.2f%n",
                calcularValorInventario()
        );
    }
}