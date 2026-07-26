package com.lelyliliana.unidad3;

/*
 * EJEMPLO 23 - UNIDAD 3
 *
 * PROGRAMA INTEGRADOR
 *
 * Tema:
 * Sistema básico de inventario.
 *
 * El programa permite:
 *
 * 1. Registrar productos.
 * 2. Mostrar todos los productos.
 * 3. Buscar un producto por código.
 * 4. Buscar productos por nombre.
 * 5. Modificar el precio y la cantidad.
 * 6. Cambiar el estado de un producto.
 * 7. Eliminar un producto.
 * 8. Mostrar un resumen del inventario.
 * 9. Salir.
 *
 * Contenidos integrados:
 *
 * - Scanner.
 * - String y sus métodos.
 * - StringBuilder.
 * - Excepciones.
 * - throw.
 * - InputMismatchException.
 * - IllegalArgumentException.
 * - ArrayList.
 * - Clases y objetos.
 * - Enumerados.
 * - valueOf().
 * - switch.
 * - Métodos.
 * - Contadores y acumuladores.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramaIntegradorUnidad3 {

    /*
     * Scanner compartido por todos los métodos.
     *
     * Se declara static para poder utilizarlo desde
     * los métodos estáticos de la clase.
     */
    private static final Scanner TECLADO =
            new Scanner(System.in);

    /*
     * Lista dinámica que almacena objetos de tipo
     * ProductoInventarioU3.
     *
     * Se usa un nombre de clase específico para evitar
     * conflictos con otras clases Producto del paquete.
     */
    private static final ArrayList<ProductoInventarioU3>
            PRODUCTOS = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;

        /*
         * Agregamos algunos productos iniciales para que
         * el programa pueda probarse sin registrar todo
         * desde cero.
         */
        cargarProductosIniciales();

        System.out.println(
                "SISTEMA DE INVENTARIO - UNIDAD 3"
        );

        System.out.println(
                "============================================"
        );

        /*
         * El menú se ejecuta al menos una vez y continúa
         * hasta que el usuario selecciona la opción 9.
         */
        do {

            mostrarMenu();

            opcion = leerEntero(
                    "Seleccione una opción: "
            );

            System.out.println();

            /*
             * Switch moderno.
             *
             * No necesita break porque utiliza flechas.
             */
            switch (opcion) {

                case 1 -> registrarProducto();

                case 2 -> mostrarProductos();

                case 3 -> buscarProductoPorCodigo();

                case 4 -> buscarProductosPorNombre();

                case 5 -> modificarProducto();

                case 6 -> cambiarEstadoProducto();

                case 7 -> eliminarProducto();

                case 8 -> mostrarResumenInventario();

                case 9 -> System.out.println(
                        "Saliendo del sistema..."
                );

                default -> System.out.println(
                        "Error: la opción seleccionada "
                                + "no es válida."
                );
            }

        } while (opcion != 9);

        TECLADO.close();

        System.out.println(
                "El programa ha finalizado."
        );
    }

    /*
     * ==================================================
     * CARGA DE DATOS INICIALES
     * ==================================================
     */

    public static void cargarProductosIniciales() {

        PRODUCTOS.add(
                new ProductoInventarioU3(
                        101,
                        "Teclado mecánico",
                        185_000.0,
                        6,
                        CategoriaProductoU3.PERIFERICOS,
                        EstadoProductoU3.DISPONIBLE
                )
        );

        PRODUCTOS.add(
                new ProductoInventarioU3(
                        102,
                        "Monitor de 24 pulgadas",
                        780_000.0,
                        3,
                        CategoriaProductoU3.PANTALLAS,
                        EstadoProductoU3.DISPONIBLE
                )
        );

        PRODUCTOS.add(
                new ProductoInventarioU3(
                        103,
                        "Memoria USB de 64 GB",
                        42_000.0,
                        0,
                        CategoriaProductoU3.ALMACENAMIENTO,
                        EstadoProductoU3.AGOTADO
                )
        );
    }

    /*
     * ==================================================
     * MENÚ PRINCIPAL
     * ==================================================
     */

    public static void mostrarMenu() {

        System.out.println(
                "\nMENÚ PRINCIPAL"
        );

        System.out.println(
                "--------------------------------------------"
        );

        System.out.println(
                "1. Registrar producto"
        );

        System.out.println(
                "2. Mostrar todos los productos"
        );

        System.out.println(
                "3. Buscar producto por código"
        );

        System.out.println(
                "4. Buscar productos por nombre"
        );

        System.out.println(
                "5. Modificar producto"
        );

        System.out.println(
                "6. Cambiar estado del producto"
        );

        System.out.println(
                "7. Eliminar producto"
        );

        System.out.println(
                "8. Mostrar resumen del inventario"
        );

        System.out.println(
                "9. Salir"
        );

        System.out.println(
                "--------------------------------------------"
        );
    }

    /*
     * ==================================================
     * REGISTRAR PRODUCTO
     * ==================================================
     */

    public static void registrarProducto() {

        System.out.println(
                "REGISTRO DE PRODUCTO"
        );

        System.out.println(
                "--------------------------------------------"
        );

        try {

            int codigo = leerEntero(
                    "Ingrese el código: "
            );

            /*
             * No pueden existir dos productos con
             * el mismo código.
             */
            if (buscarPorCodigo(codigo) != null) {

                throw new IllegalArgumentException(
                        "Ya existe un producto con el código "
                                + codigo
                                + "."
                );
            }

            String nombre = leerTextoObligatorio(
                    "Ingrese el nombre: ",
                    3,
                    60
            );

            double precio = leerDecimal(
                    "Ingrese el precio: $"
            );

            if (precio <= 0) {

                throw new IllegalArgumentException(
                        "El precio debe ser mayor que cero."
                );
            }

            int cantidad = leerEntero(
                    "Ingrese la cantidad disponible: "
            );

            if (cantidad < 0) {

                throw new IllegalArgumentException(
                        "La cantidad no puede ser negativa."
                );
            }

            CategoriaProductoU3 categoria =
                    leerCategoria();

            /*
             * El estado inicial se determina según
             * la cantidad registrada.
             */
            EstadoProductoU3 estadoInicial =
                    cantidad > 0
                            ? EstadoProductoU3.DISPONIBLE
                            : EstadoProductoU3.AGOTADO;

            ProductoInventarioU3 nuevoProducto =
                    new ProductoInventarioU3(
                            codigo,
                            nombre,
                            precio,
                            cantidad,
                            categoria,
                            estadoInicial
                    );

            PRODUCTOS.add(nuevoProducto);

            System.out.println(
                    "\nProducto registrado correctamente."
            );

            nuevoProducto.mostrarInformacion();

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error de validación: "
                            + e.getMessage()
            );
        }
    }

    /*
     * ==================================================
     * MOSTRAR PRODUCTOS
     * ==================================================
     */

    public static void mostrarProductos() {

        System.out.println(
                "LISTA DE PRODUCTOS"
        );

        System.out.println(
                "============================================"
        );

        if (PRODUCTOS.isEmpty()) {

            System.out.println(
                    "No hay productos registrados."
            );

            return;
        }

        for (int i = 0; i < PRODUCTOS.size(); i++) {

            System.out.println(
                    "Producto "
                            + (i + 1)
                            + " de "
                            + PRODUCTOS.size()
            );

            PRODUCTOS
                    .get(i)
                    .mostrarInformacion();

            System.out.println(
                    "--------------------------------------------"
            );
        }
    }

    /*
     * ==================================================
     * BÚSQUEDA POR CÓDIGO
     * ==================================================
     */

    public static void buscarProductoPorCodigo() {

        System.out.println(
                "BÚSQUEDA POR CÓDIGO"
        );

        System.out.println(
                "--------------------------------------------"
        );

        int codigo = leerEntero(
                "Ingrese el código del producto: "
        );

        ProductoInventarioU3 producto =
                buscarPorCodigo(codigo);

        if (producto != null) {

            System.out.println(
                    "\nProducto encontrado:"
            );

            producto.mostrarInformacion();

        } else {

            System.out.println(
                    "No se encontró un producto con el código "
                            + codigo
                            + "."
            );
        }
    }

    /*
     * Método auxiliar que retorna el producto encontrado.
     *
     * Si no existe, retorna null.
     */

    public static ProductoInventarioU3 buscarPorCodigo(
            int codigo
    ) {

        for (
                ProductoInventarioU3 producto
                : PRODUCTOS
        ) {

            if (producto.getCodigo() == codigo) {

                return producto;
            }
        }

        return null;
    }

    /*
     * ==================================================
     * BÚSQUEDA POR NOMBRE
     * ==================================================
     */

    public static void buscarProductosPorNombre() {

        System.out.println(
                "BÚSQUEDA POR NOMBRE"
        );

        System.out.println(
                "--------------------------------------------"
        );

        String textoBuscado = leerTextoObligatorio(
                "Ingrese el nombre o una parte del nombre: ",
                1,
                60
        );

        /*
         * Convertimos ambos textos a minúsculas para
         * ignorar diferencias entre mayúsculas y minúsculas.
         */
        String busquedaNormalizada =
                textoBuscado.toLowerCase();

        int cantidadEncontrada = 0;

        for (
                ProductoInventarioU3 producto
                : PRODUCTOS
        ) {

            String nombreNormalizado =
                    producto
                            .getNombre()
                            .toLowerCase();

            if (
                    nombreNormalizado.contains(
                            busquedaNormalizada
                    )
            ) {

                producto.mostrarInformacion();

                System.out.println(
                        "--------------------------------------------"
                );

                cantidadEncontrada++;
            }
        }

        if (cantidadEncontrada == 0) {

            System.out.println(
                    "No se encontraron productos "
                            + "que contengan el texto indicado."
            );

        } else {

            System.out.println(
                    "Cantidad de coincidencias: "
                            + cantidadEncontrada
            );
        }
    }

    /*
     * ==================================================
     * MODIFICAR PRODUCTO
     * ==================================================
     */

    public static void modificarProducto() {

        System.out.println(
                "MODIFICACIÓN DE PRODUCTO"
        );

        System.out.println(
                "--------------------------------------------"
        );

        int codigo = leerEntero(
                "Ingrese el código del producto: "
        );

        ProductoInventarioU3 producto =
                buscarPorCodigo(codigo);

        if (producto == null) {

            System.out.println(
                    "No existe un producto con ese código."
            );

            return;
        }

        producto.mostrarInformacion();

        try {

            double nuevoPrecio = leerDecimal(
                    "\nIngrese el nuevo precio: $"
            );

            int nuevaCantidad = leerEntero(
                    "Ingrese la nueva cantidad: "
            );

            producto.setPrecio(nuevoPrecio);
            producto.setCantidad(nuevaCantidad);

            /*
             * Actualizamos automáticamente el estado
             * cuando la cantidad llega a cero.
             */
            if (
                    nuevaCantidad == 0
                            && producto.getEstado()
                            != EstadoProductoU3.DESCONTINUADO
            ) {

                producto.setEstado(
                        EstadoProductoU3.AGOTADO
                );

            } else if (
                    nuevaCantidad > 0
                            && producto.getEstado()
                            == EstadoProductoU3.AGOTADO
            ) {

                producto.setEstado(
                        EstadoProductoU3.DISPONIBLE
                );
            }

            System.out.println(
                    "\nProducto modificado correctamente."
            );

            producto.mostrarInformacion();

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error de validación: "
                            + e.getMessage()
            );
        }
    }

    /*
     * ==================================================
     * CAMBIAR ESTADO
     * ==================================================
     */

    public static void cambiarEstadoProducto() {

        System.out.println(
                "CAMBIO DE ESTADO"
        );

        System.out.println(
                "--------------------------------------------"
        );

        int codigo = leerEntero(
                "Ingrese el código del producto: "
        );

        ProductoInventarioU3 producto =
                buscarPorCodigo(codigo);

        if (producto == null) {

            System.out.println(
                    "No existe un producto con ese código."
            );

            return;
        }

        System.out.println(
                "Estado actual: "
                        + producto.getEstado()
        );

        System.out.println(
                "\nEstados disponibles:"
        );

        for (
                EstadoProductoU3 estado
                : EstadoProductoU3.values()
        ) {

            System.out.println(
                    "- " + estado
            );
        }

        System.out.print(
                "Ingrese el nuevo estado: "
        );

        String textoEstado =
                TECLADO.nextLine()
                        .trim()
                        .toUpperCase()
                        .replace(" ", "_");

        try {

            /*
             * valueOf() convierte el texto en un valor enum.
             */
            EstadoProductoU3 nuevoEstado =
                    EstadoProductoU3.valueOf(
                            textoEstado
                    );

            producto.setEstado(nuevoEstado);

            /*
             * Si el producto se marca como agotado,
             * ajustamos su cantidad a cero.
             */
            if (
                    nuevoEstado
                            == EstadoProductoU3.AGOTADO
            ) {

                producto.setCantidad(0);
            }

            System.out.println(
                    "Estado actualizado correctamente."
            );

            producto.mostrarInformacion();

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: el estado ingresado "
                            + "no es válido."
            );
        }
    }

    /*
     * ==================================================
     * ELIMINAR PRODUCTO
     * ==================================================
     */

    public static void eliminarProducto() {

        System.out.println(
                "ELIMINACIÓN DE PRODUCTO"
        );

        System.out.println(
                "--------------------------------------------"
        );

        int codigo = leerEntero(
                "Ingrese el código del producto: "
        );

        ProductoInventarioU3 producto =
                buscarPorCodigo(codigo);

        if (producto == null) {

            System.out.println(
                    "No existe un producto con ese código."
            );

            return;
        }

        producto.mostrarInformacion();

        System.out.print(
                "\nEscriba SI para confirmar la eliminación: "
        );

        String confirmacion =
                TECLADO.nextLine().trim();

        if (
                confirmacion.equalsIgnoreCase("SI")
                || confirmacion.equalsIgnoreCase("SÍ")
        ) {

            PRODUCTOS.remove(producto);

            System.out.println(
                    "Producto eliminado correctamente."
            );

        } else {

            System.out.println(
                    "La eliminación fue cancelada."
            );
        }
    }

    /*
     * ==================================================
     * RESUMEN DEL INVENTARIO
     * ==================================================
     */

    public static void mostrarResumenInventario() {

        System.out.println(
                "RESUMEN DEL INVENTARIO"
        );

        System.out.println(
                "============================================"
        );

        if (PRODUCTOS.isEmpty()) {

            System.out.println(
                    "No hay productos para analizar."
            );

            return;
        }

        int unidadesTotales = 0;
        int disponibles = 0;
        int agotados = 0;
        int descontinuados = 0;

        double valorTotalInventario = 0.0;

        ProductoInventarioU3 productoMayorValor =
                null;

        for (
                ProductoInventarioU3 producto
                : PRODUCTOS
        ) {

            unidadesTotales +=
                    producto.getCantidad();

            valorTotalInventario +=
                    producto.calcularValorInventario();

            switch (producto.getEstado()) {

                case DISPONIBLE -> disponibles++;

                case AGOTADO -> agotados++;

                case DESCONTINUADO -> descontinuados++;
            }

            if (
                    productoMayorValor == null
                            || producto
                            .calcularValorInventario()
                            > productoMayorValor
                            .calcularValorInventario()
            ) {

                productoMayorValor = producto;
            }
        }

        StringBuilder resumen =
                new StringBuilder();

        resumen
                .append("Productos registrados: ")
                .append(PRODUCTOS.size())
                .append("\nUnidades disponibles: ")
                .append(unidadesTotales)
                .append("\nProductos en estado DISPONIBLE: ")
                .append(disponibles)
                .append("\nProductos en estado AGOTADO: ")
                .append(agotados)
                .append("\nProductos DESCONTINUADOS: ")
                .append(descontinuados);

        System.out.println(resumen);

        System.out.printf(
                "Valor total del inventario: $%,.2f%n",
                valorTotalInventario
        );

        if (productoMayorValor != null) {

            System.out.println(
                    "\nProducto con mayor valor en inventario:"
            );

            productoMayorValor.mostrarInformacion();
        }
    }

    /*
     * ==================================================
     * LECTURA Y VALIDACIÓN DE ENTEROS
     * ==================================================
     */

    public static int leerEntero(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                int valor =
                        TECLADO.nextInt();

                /*
                 * Consumimos el salto de línea pendiente.
                 */
                TECLADO.nextLine();

                return valor;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: debe ingresar un número entero."
                );

                /*
                 * Eliminamos el dato incorrecto.
                 */
                TECLADO.nextLine();
            }
        }
    }

    /*
     * ==================================================
     * LECTURA Y VALIDACIÓN DE DECIMALES
     * ==================================================
     */

    public static double leerDecimal(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                double valor =
                        TECLADO.nextDouble();

                TECLADO.nextLine();

                return valor;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: debe ingresar un valor numérico."
                );

                TECLADO.nextLine();
            }
        }
    }

    /*
     * ==================================================
     * VALIDACIÓN DE TEXTO
     * ==================================================
     */

    public static String leerTextoObligatorio(
            String mensaje,
            int longitudMinima,
            int longitudMaxima
    ) {

        while (true) {

            System.out.print(mensaje);

            String texto =
                    TECLADO.nextLine().trim();

            if (texto.isBlank()) {

                System.out.println(
                        "Error: el texto no puede estar vacío."
                );

            } else if (
                    texto.length() < longitudMinima
            ) {

                System.out.println(
                        "Error: debe contener al menos "
                                + longitudMinima
                                + " caracteres."
                );

            } else if (
                    texto.length() > longitudMaxima
            ) {

                System.out.println(
                        "Error: no puede superar "
                                + longitudMaxima
                                + " caracteres."
                );

            } else {

                return texto;
            }
        }
    }

    /*
     * ==================================================
     * SELECCIÓN DE CATEGORÍA
     * ==================================================
     */

    public static CategoriaProductoU3 leerCategoria() {

        System.out.println(
                "\nCategorías disponibles:"
        );

        for (
                CategoriaProductoU3 categoria
                : CategoriaProductoU3.values()
        ) {

            System.out.println(
                    "- " + categoria
            );
        }

        while (true) {

            System.out.print(
                    "Ingrese la categoría: "
            );

            String textoCategoria =
                    TECLADO.nextLine()
                            .trim()
                            .toUpperCase()
                            .replace(" ", "_");

            try {

                return CategoriaProductoU3.valueOf(
                        textoCategoria
                );

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Error: la categoría no es válida."
                );
            }
        }
    }
}

/*
 * ==================================================
 * CLASE PRODUCTO
 * ==================================================
 *
 * Representa cada elemento del inventario.
 */

class ProductoInventarioU3 {

    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProductoU3 categoria;
    private EstadoProductoU3 estado;

    public ProductoInventarioU3(
            int codigo,
            String nombre,
            double precio,
            int cantidad,
            CategoriaProductoU3 categoria,
            EstadoProductoU3 estado
    ) {

        if (codigo <= 0) {

            throw new IllegalArgumentException(
                    "El código debe ser mayor que cero."
            );
        }

        if (nombre == null || nombre.isBlank()) {

            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        if (precio <= 0) {

            throw new IllegalArgumentException(
                    "El precio debe ser mayor que cero."
            );
        }

        if (cantidad < 0) {

            throw new IllegalArgumentException(
                    "La cantidad no puede ser negativa."
            );
        }

        this.codigo = codigo;
        this.nombre = nombre.trim();
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.estado = estado;
    }

    public int getCodigo() {
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

    public CategoriaProductoU3 getCategoria() {
        return categoria;
    }

    public EstadoProductoU3 getEstado() {
        return estado;
    }

    public void setPrecio(double precio) {

        if (precio <= 0) {

            throw new IllegalArgumentException(
                    "El precio debe ser mayor que cero."
            );
        }

        this.precio = precio;
    }

    public void setCantidad(int cantidad) {

        if (cantidad < 0) {

            throw new IllegalArgumentException(
                    "La cantidad no puede ser negativa."
            );
        }

        this.cantidad = cantidad;
    }

    public void setEstado(
            EstadoProductoU3 estado
    ) {

        if (estado == null) {

            throw new IllegalArgumentException(
                    "El estado no puede ser nulo."
            );
        }

        this.estado = estado;
    }

    /*
     * Calcula el valor total de las unidades disponibles
     * de este producto.
     */

    public double calcularValorInventario() {

        return precio * cantidad;
    }

    /*
     * Construye la información con StringBuilder.
     */

    public String generarDescripcion() {

        StringBuilder descripcion =
                new StringBuilder();

        descripcion
                .append("Código: ")
                .append(codigo)
                .append("\nNombre: ")
                .append(nombre)
                .append("\nCategoría: ")
                .append(categoria)
                .append("\nEstado: ")
                .append(estado)
                .append("\nCantidad: ")
                .append(cantidad);

        return descripcion.toString();
    }

    public void mostrarInformacion() {

        System.out.println(
                generarDescripcion()
        );

        System.out.printf(
                "Precio unitario: $%,.2f%n",
                precio
        );

        System.out.printf(
                "Valor en inventario: $%,.2f%n",
                calcularValorInventario()
        );
    }
}

/*
 * ==================================================
 * ENUM DE CATEGORÍAS
 * ==================================================
 */

enum CategoriaProductoU3 {

    COMPUTADORES,
    PERIFERICOS,
    PANTALLAS,
    ALMACENAMIENTO,
    REDES,
    ACCESORIOS
}

/*
 * ==================================================
 * ENUM DE ESTADOS
 * ==================================================
 */

enum EstadoProductoU3 {

    DISPONIBLE,
    AGOTADO,
    DESCONTINUADO
}