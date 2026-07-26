package com.lelyliliana.unidad1;

/*
 * EJEMPLO 18 - UNIDAD 1
 *
 * Tema:
 * Ciclo while controlado mediante un valor centinela.
 *
 * Un valor centinela es un dato especial que indica
 * cuándo debe finalizar el ingreso de información.
 *
 * En este ejemplo:
 *
 * - Las notas válidas están entre 0.0 y 5.0.
 * - El valor -1 se utiliza como centinela.
 * - La cantidad de notas no se conoce previamente.
 */

import java.util.Scanner;

public class CicloWhileCentinela {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        /*
         * Constantes del programa.
         */
        final double NOTA_MINIMA = 0.0;
        final double NOTA_MAXIMA = 5.0;
        final double NOTA_APROBACION = 3.0;
        final double CENTINELA = -1.0;

        /*
         * Acumulador:
         * Guarda la suma de todas las notas válidas.
         */
        double sumaNotas = 0.0;

        /*
         * Contadores:
         * Registran la cantidad total de notas,
         * aprobadas y reprobadas.
         */
        int cantidadNotas = 0;
        int cantidadAprobadas = 0;
        int cantidadReprobadas = 0;

        System.out.println("REGISTRO DE NOTAS CON CENTINELA");
        System.out.println("----------------------------------------");

        System.out.println(
                "Ingrese notas entre "
                        + NOTA_MINIMA
                        + " y "
                        + NOTA_MAXIMA
                        + "."
        );

        System.out.println(
                "Digite "
                        + CENTINELA
                        + " para finalizar el registro."
        );

        /*
         * ==================================================
         * LECTURA INICIAL
         * ==================================================
         *
         * Antes de iniciar el ciclo se solicita el primer
         * valor. Esta lectura permite evaluar la condición
         * del while.
         */

        System.out.print("\nIngrese una nota: ");
        double nota = teclado.nextDouble();

        /*
         * ==================================================
         * CICLO WHILE CON CENTINELA
         * ==================================================
         *
         * El ciclo continúa mientras la nota ingresada
         * sea diferente del valor centinela.
         */

        while (nota != CENTINELA) {

            /*
             * Validamos que la nota esté dentro
             * del rango permitido.
             */
            if (nota >= NOTA_MINIMA && nota <= NOTA_MAXIMA) {

                /*
                 * Acumulamos la nota válida.
                 */
                sumaNotas += nota;

                /*
                 * Aumentamos el contador total.
                 */
                cantidadNotas++;

                /*
                 * Clasificamos la nota como aprobada
                 * o reprobada.
                 */
                if (nota >= NOTA_APROBACION) {

                    cantidadAprobadas++;

                    System.out.println(
                            "Nota registrada: aprobada."
                    );

                } else {

                    cantidadReprobadas++;

                    System.out.println(
                            "Nota registrada: reprobada."
                    );
                }

            } else {

                /*
                 * Este bloque se ejecuta cuando el valor
                 * no es el centinela, pero tampoco es
                 * una nota válida.
                 */
                System.out.println(
                        "Error: la nota debe estar entre "
                                + NOTA_MINIMA
                                + " y "
                                + NOTA_MAXIMA
                                + "."
                );
            }

            /*
             * ==================================================
             * NUEVA LECTURA
             * ==================================================
             *
             * Esta instrucción es fundamental.
             *
             * Permite ingresar una nueva nota o el valor
             * centinela para finalizar.
             *
             * Si se elimina, el ciclo podría volverse infinito.
             */

            System.out.print("\nIngrese otra nota: ");
            nota = teclado.nextDouble();
        }

        /*
         * ==================================================
         * RESULTADOS
         * ==================================================
         *
         * Al salir del ciclo verificamos si se registró
         * por lo menos una nota válida.
         */

        System.out.println("\nRESULTADOS DEL REGISTRO");
        System.out.println("----------------------------------------");

        if (cantidadNotas > 0) {

            double promedio =
                    sumaNotas / cantidadNotas;

            System.out.println(
                    "Cantidad de notas: " + cantidadNotas
            );

            System.out.println(
                    "Suma de las notas: " + sumaNotas
            );

            System.out.println(
                    "Promedio: " + promedio
            );

            System.out.println(
                    "Notas aprobadas: " + cantidadAprobadas
            );

            System.out.println(
                    "Notas reprobadas: " + cantidadReprobadas
            );

        } else {

            System.out.println(
                    "No se registraron notas válidas."
            );
        }

        System.out.println(
                "El programa finalizó porque se ingresó "
                        + "el valor centinela "
                        + CENTINELA
                        + "."
        );

        teclado.close();
    }
}