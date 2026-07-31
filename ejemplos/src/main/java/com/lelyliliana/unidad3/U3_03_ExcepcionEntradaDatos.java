package com.lelyliliana.unidad3;

/*
 * EJEMPLO 3 - UNIDAD 3
 *
 * Tema:
 * Control de datos incorrectos con InputMismatchException.
 *
 * InputMismatchException ocurre cuando Scanner espera
 * un tipo de dato, pero el usuario ingresa otro.
 *
 * Ejemplo:
 *
 * Scanner espera un número entero:
 *
 * int edad = teclado.nextInt();
 *
 * Pero el usuario escribe:
 *
 * veinte
 *
 * En ese caso se genera una InputMismatchException.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class U3_03_ExcepcionEntradaDatos {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("CONTROL DE ENTRADA DE DATOS");
        System.out.println("----------------------------------------");

        /*
         * ==================================================
         * EJEMPLO 1: CAPTURA DE EDAD
         * ==================================================
         */

        int edad = 0;

        /*
         * Esta variable indica si el usuario ingresó
         * correctamente el dato.
         */
        boolean edadValida = false;

        /*
         * El ciclo continúa mientras la edad no sea válida.
         */
        while (!edadValida) {

            try {

                System.out.print(
                        "Ingrese su edad en números enteros: "
                );

                /*
                 * Esta instrucción puede producir una
                 * InputMismatchException si el usuario
                 * escribe letras o un número decimal.
                 */
                edad = teclado.nextInt();

                /*
                 * Validamos que la edad no sea negativa.
                 *
                 * Esta validación no produce una excepción
                 * automática, por eso se controla con if.
                 */
                if (edad >= 0) {

                    edadValida = true;

                } else {

                    System.out.println(
                            "Error: la edad no puede ser negativa."
                    );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: debe ingresar un número entero."
                );

                /*
                 * Cuando Scanner encuentra un dato incorrecto,
                 * ese dato permanece en el flujo de entrada.
                 *
                 * nextLine() permite descartarlo para evitar
                 * que el ciclo vuelva a leer el mismo valor.
                 */
                teclado.nextLine();
            }
        }

        System.out.println(
                "Edad registrada correctamente: "
                        + edad
                        + " años."
        );

        /*
         * ==================================================
         * EJEMPLO 2: CAPTURA DE UNA NOTA DECIMAL
         * ==================================================
         */

        double nota = 0.0;
        boolean notaValida = false;

        while (!notaValida) {

            try {

                System.out.print(
                        "\nIngrese una nota entre 0.0 y 5.0: "
                );

                /*
                 * nextDouble() genera InputMismatchException
                 * cuando el dato no puede interpretarse como
                 * un número decimal.
                 */
                nota = teclado.nextDouble();

                if (nota >= 0.0 && nota <= 5.0) {

                    notaValida = true;

                } else {

                    System.out.println(
                            "Error: la nota debe estar "
                                    + "entre 0.0 y 5.0."
                    );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: debe ingresar un valor numérico."
                );

                /*
                 * Eliminamos el dato incorrecto.
                 */
                teclado.nextLine();
            }
        }

        /*
         * Clasificamos la nota una vez validada.
         */
        String resultado =
                nota >= 3.0
                        ? "Aprobado"
                        : "Reprobado";

        System.out.println(
                "Nota registrada: " + nota
        );

        System.out.println(
                "Resultado académico: " + resultado
        );

        /*
         * ==================================================
         * EJEMPLO 3: TRY-CATCH-FINALLY
         * ==================================================
         */

        System.out.println("\nREGISTRO DE CANTIDAD");
        System.out.println("----------------------------------------");

        try {

            System.out.print(
                    "Ingrese la cantidad de estudiantes: "
            );

            int cantidadEstudiantes = teclado.nextInt();

            System.out.println(
                    "Cantidad registrada: "
                            + cantidadEstudiantes
            );

        } catch (InputMismatchException e) {

            System.out.println(
                    "Error: la cantidad debe ser un número entero."
            );

            teclado.nextLine();

        } finally {

            /*
             * finally se ejecuta tanto si el dato fue correcto
             * como si se produjo una excepción.
             */
            System.out.println(
                    "El intento de registro ha finalizado."
            );
        }

        System.out.println(
                "\nEl programa finalizó correctamente."
        );

        teclado.close();
    }
}