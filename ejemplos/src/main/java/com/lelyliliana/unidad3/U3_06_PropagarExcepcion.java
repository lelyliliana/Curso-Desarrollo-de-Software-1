package com.lelyliliana.unidad3;

/*
 * EJEMPLO 6 - UNIDAD 3
 *
 * Tema:
 * Propagación de excepciones con throws.
 *
 * La palabra reservada throws se escribe en la
 * declaración de un método.
 *
 * Indica que el método puede producir una excepción
 * y que no la controlará directamente.
 *
 * La responsabilidad de controlar la excepción pasa
 * al método que realiza el llamado.
 *
 * En este ejemplo se utiliza IOException, que es una
 * excepción verificada.
 */

import java.io.IOException;
import java.util.Scanner;

public class U3_06_PropagarExcepcion {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("PROPAGACIÓN DE EXCEPCIONES");
        System.out.println("----------------------------------------");

        System.out.print(
                "Ingrese el nombre del archivo que desea buscar: "
        );

        String nombreArchivo = teclado.nextLine();

        /*
         * El método buscarArchivo declara:
         *
         * throws IOException
         *
         * Esto obliga al método main a controlar
         * la posible excepción.
         */
        try {

            String resultado = buscarArchivo(nombreArchivo);

            System.out.println(
                    "\nResultado: " + resultado
            );

        } catch (IOException e) {

            /*
             * La excepción no fue controlada dentro de
             * buscarArchivo.
             *
             * Fue propagada hasta este bloque catch.
             */
            System.out.println(
                    "\nError al buscar el archivo."
            );

            System.out.println(
                    "Detalle: " + e.getMessage()
            );

        } finally {

            System.out.println(
                    "\nLa búsqueda del archivo ha finalizado."
            );
        }

        /*
         * ==================================================
         * SEGUNDO EJEMPLO
         * ==================================================
         */

        System.out.print(
                "\nIngrese una edad para validar: "
        );

        int edad = teclado.nextInt();

        try {

            validarEdad(edad);

            System.out.println(
                    "Edad registrada correctamente: "
                            + edad
                            + " años."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error de validación: " + e.getMessage()
            );
        }

        System.out.println(
                "\nEl programa ha finalizado."
        );

        teclado.close();
    }

    /*
     * ==================================================
     * MÉTODO QUE PROPAGA IOException
     * ==================================================
     *
     * La declaración:
     *
     * throws IOException
     *
     * indica que este método puede generar esa excepción,
     * pero no la controla con try-catch.
     */
    public static String buscarArchivo(String nombreArchivo)
            throws IOException {

        /*
         * Para este ejemplo, solamente consideramos
         * existente un archivo llamado:
         *
         * datos.txt
         */
        if (!nombreArchivo.equalsIgnoreCase("datos.txt")) {

            /*
             * throw genera la excepción.
             *
             * throws informa que el método puede propagarla.
             */
            throw new IOException(
                    "No se encontró el archivo: "
                            + nombreArchivo
            );
        }

        return "El archivo datos.txt fue encontrado.";
    }

    /*
     * ==================================================
     * MÉTODO QUE PROPAGA IllegalArgumentException
     * ==================================================
     *
     * IllegalArgumentException es una excepción no
     * verificada.
     *
     * No es obligatorio declarar throws, pero se incluye
     * para mostrar que también puede documentarse.
     */
    public static void validarEdad(int edad)
            throws IllegalArgumentException {

        if (edad < 0) {

            throw new IllegalArgumentException(
                    "La edad no puede ser negativa."
            );
        }

        if (edad > 120) {

            throw new IllegalArgumentException(
                    "La edad ingresada no es válida."
            );
        }
    }
}