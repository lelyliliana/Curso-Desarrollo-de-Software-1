package com.lelyliliana.unidad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * EJEMPLO 12 - UNIDAD 5
 *
 * Tema:
 * Operaciones CRUD mediante consola y archivo de texto.
 *
 * CRUD significa:
 * - Create: crear.
 * - Read: consultar.
 * - Update: modificar.
 * - Delete: eliminar.
 */
public class U5_12_CRUDConsolaArchivo {

    private static final Path RUTA_ARCHIVO =
        Path.of("empleados_crud.txt");

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int opcion;

        do {

            mostrarMenu();

            System.out.print("Seleccione una opción: ");

            while (!teclado.hasNextInt()) {

                System.out.println(
                    "Debe ingresar un número entero."
                );

                teclado.nextLine();

                System.out.print(
                    "Seleccione una opción válida: "
                );
            }

            opcion = teclado.nextInt();
            teclado.nextLine();

            System.out.println();

            switch (opcion) {

                case 1 -> agregarEmpleado(teclado);
                case 2 -> listarEmpleados();
                case 3 -> consultarEmpleado(teclado);
                case 4 -> modificarEmpleado(teclado);
                case 5 -> eliminarEmpleado(teclado);
                case 0 -> System.out.println(
                    "Programa finalizado."
                );
                default -> System.out.println(
                    "La opción seleccionada no es válida."
                );
            }

            System.out.println();

        } while (opcion != 0);

        teclado.close();
    }

    private static void mostrarMenu() {

        System.out.println("CRUD DE EMPLEADOS");
        System.out.println("----------------------------------");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Listar empleados");
        System.out.println("3. Consultar empleado");
        System.out.println("4. Modificar empleado");
        System.out.println("5. Eliminar empleado");
        System.out.println("0. Salir");
        System.out.println("----------------------------------");
    }

    /**
     * CREATE: agrega un nuevo empleado.
     */
    private static void agregarEmpleado(Scanner teclado) {

        System.out.print("Documento: ");
        String documento = teclado.nextLine().trim();

        List<EmpleadoCRUD> empleados = cargarEmpleados();

        if (buscarPorDocumento(empleados, documento) != null) {

            System.out.println(
                "Ya existe un empleado con ese documento."
            );

            return;
        }

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine().trim();

        System.out.print("Cargo: ");
        String cargo = teclado.nextLine().trim();

        System.out.print("Salario: ");

        double salario;

        try {

            salario = Double.parseDouble(
                teclado.nextLine().trim()
            );

        } catch (NumberFormatException excepcion) {

            System.out.println(
                "El salario debe ser un valor numérico."
            );

            return;
        }

        EmpleadoCRUD empleado = new EmpleadoCRUD(
            documento,
            nombre,
            cargo,
            salario
        );

        empleados.add(empleado);
        guardarEmpleados(empleados);

        System.out.println(
            "Empleado agregado correctamente."
        );
    }

    /**
     * READ: muestra todos los empleados.
     */
    private static void listarEmpleados() {

        List<EmpleadoCRUD> empleados = cargarEmpleados();

        if (empleados.isEmpty()) {

            System.out.println(
                "No hay empleados registrados."
            );

            return;
        }

        for (EmpleadoCRUD empleado : empleados) {

            System.out.println(empleado);
            System.out.println(
                "----------------------------------"
            );
        }
    }

    /**
     * READ: consulta un empleado por documento.
     */
    private static void consultarEmpleado(
        Scanner teclado
    ) {

        System.out.print(
            "Documento del empleado: "
        );

        String documento = teclado.nextLine().trim();

        List<EmpleadoCRUD> empleados = cargarEmpleados();

        EmpleadoCRUD empleado =
            buscarPorDocumento(empleados, documento);

        if (empleado == null) {

            System.out.println(
                "No se encontró el empleado."
            );

            return;
        }

        System.out.println();
        System.out.println(empleado);
    }

    /**
     * UPDATE: modifica los datos de un empleado.
     */
    private static void modificarEmpleado(
        Scanner teclado
    ) {

        System.out.print(
            "Documento del empleado: "
        );

        String documento = teclado.nextLine().trim();

        List<EmpleadoCRUD> empleados = cargarEmpleados();

        EmpleadoCRUD empleado =
            buscarPorDocumento(empleados, documento);

        if (empleado == null) {

            System.out.println(
                "No se encontró el empleado."
            );

            return;
        }

        System.out.print("Nuevo nombre: ");
        empleado.setNombre(
            teclado.nextLine().trim()
        );

        System.out.print("Nuevo cargo: ");
        empleado.setCargo(
            teclado.nextLine().trim()
        );

        System.out.print("Nuevo salario: ");

        try {

            empleado.setSalario(
                Double.parseDouble(
                    teclado.nextLine().trim()
                )
            );

        } catch (NumberFormatException excepcion) {

            System.out.println(
                "El salario debe ser un valor numérico."
            );

            return;
        }

        guardarEmpleados(empleados);

        System.out.println(
            "Empleado modificado correctamente."
        );
    }

    /**
     * DELETE: elimina un empleado.
     */
    private static void eliminarEmpleado(
        Scanner teclado
    ) {

        System.out.print(
            "Documento del empleado: "
        );

        String documento = teclado.nextLine().trim();

        List<EmpleadoCRUD> empleados = cargarEmpleados();

        EmpleadoCRUD empleado =
            buscarPorDocumento(empleados, documento);

        if (empleado == null) {

            System.out.println(
                "No se encontró el empleado."
            );

            return;
        }

        empleados.remove(empleado);
        guardarEmpleados(empleados);

        System.out.println(
            "Empleado eliminado correctamente."
        );
    }

    /**
     * Busca un empleado por documento.
     */
    private static EmpleadoCRUD buscarPorDocumento(
        List<EmpleadoCRUD> empleados,
        String documento
    ) {

        for (EmpleadoCRUD empleado : empleados) {

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

    /**
     * Lee el archivo y construye la lista de objetos.
     */
    private static List<EmpleadoCRUD> cargarEmpleados() {

        List<EmpleadoCRUD> empleados =
            new ArrayList<>();

        if (!Files.exists(RUTA_ARCHIVO)) {
            return empleados;
        }

        try {

            List<String> registros =
                Files.readAllLines(RUTA_ARCHIVO);

            for (String registro : registros) {

                try {

                    empleados.add(
                        EmpleadoCRUD.crearDesdeRegistro(
                            registro
                        )
                    );

                } catch (
                    IllegalArgumentException excepcion
                ) {

                    System.out.println(
                        "Registro ignorado: " + registro
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

    /**
     * Guarda la lista completa en el archivo.
     */
    private static void guardarEmpleados(
        List<EmpleadoCRUD> empleados
    ) {

        List<String> registros =
            new ArrayList<>();

        for (EmpleadoCRUD empleado : empleados) {

            registros.add(
                empleado.convertirARegistro()
            );
        }

        try {

            Files.write(RUTA_ARCHIVO, registros);

        } catch (IOException excepcion) {

            System.out.println(
                "No fue posible guardar los cambios."
            );
        }
    }
}

/**
 * Clase auxiliar que representa un empleado.
 */
class EmpleadoCRUD {

    private String documento;
    private String nombre;
    private String cargo;
    private double salario;

    public EmpleadoCRUD(
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

    public static EmpleadoCRUD crearDesdeRegistro(
        String registro
    ) {

        String[] datos = registro.split(";");

        if (datos.length < 4) {

            throw new IllegalArgumentException(
                "Formato incorrecto."
            );
        }

        return new EmpleadoCRUD(
            datos[0],
            datos[1],
            datos[2],
            Double.parseDouble(datos[3])
        );
    }

    @Override
    public String toString() {

        return "Documento: " + documento
            + "\nNombre: " + nombre
            + "\nCargo: " + cargo
            + "\nSalario: $" + salario;
    }
}
