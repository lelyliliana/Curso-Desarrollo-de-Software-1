package com.lelyliliana.unidad1;

/*
 * EJEMPLO 16 - UNIDAD 1
 *
 * Tema:
 * Ciclo for, contadores y acumuladores.
 *
 * El ciclo for se utiliza principalmente cuando
 * conocemos cuántas veces debe repetirse una tarea.
 *
 * Estructura:
 *
 * for (inicio; condición; actualización) {
 *     instrucciones;
 * }
 */

import java.util.Scanner;

public class CicloFor {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        /*
         * ==================================================
         * EJEMPLO 1: REPETIR UN MENSAJE
         * ==================================================
         */

        System.out.println("EJEMPLO 1: REPETICIÓN CON FOR");
        System.out.println("--------------------------------");

        /*
         * int i = 1
         * Inicializa la variable de control.
         *
         * i <= 5
         * El ciclo continúa mientras la condición
         * sea verdadera.
         *
         * i++
         * Incrementa la variable en una unidad
         * después de cada repetición.
         */

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                    "Repetición número: " + i
            );
        }

        /*
         * ==================================================
         * EJEMPLO 2: MOSTRAR NÚMEROS DEL 1 AL 10
         * ==================================================
         */

        System.out.println("\nEJEMPLO 2: NÚMEROS DEL 1 AL 10");
        System.out.println("--------------------------------");

        for (int numero = 1; numero <= 10; numero++) {

            System.out.println(numero);
        }

        /*
         * ==================================================
         * EJEMPLO 3: MOSTRAR NÚMEROS PARES
         * ==================================================
         */

        System.out.println("\nEJEMPLO 3: NÚMEROS PARES");
        System.out.println("--------------------------------");

        /*
         * La variable aumenta de dos en dos.
         */

        for (int numero = 2; numero <= 20; numero += 2) {

            System.out.println(numero);
        }

        /*
         * ==================================================
         * EJEMPLO 4: CUENTA REGRESIVA
         * ==================================================
         */

        System.out.println("\nEJEMPLO 4: CUENTA REGRESIVA");
        System.out.println("--------------------------------");

        /*
         * En este caso la variable disminuye
         * en cada repetición.
         */

        for (int numero = 10; numero >= 1; numero--) {

            System.out.println(numero);
        }

        System.out.println("¡Inicio!");

        /*
         * ==================================================
         * EJEMPLO 5: CONTADOR
         * ==================================================
         *
         * Un contador es una variable que aumenta o
         * disminuye para registrar cuántas veces ocurre algo.
         *
         * Contaremos cuántos números pares hay entre 1 y 10.
         */

        int cantidadPares = 0;

        System.out.println("\nEJEMPLO 5: CONTADOR DE PARES");
        System.out.println("--------------------------------");

        for (int numero = 1; numero <= 10; numero++) {

            if (numero % 2 == 0) {

                System.out.println(
                        numero + " es par."
                );

                /*
                 * Cada vez que encontramos un número par,
                 * el contador aumenta en una unidad.
                 */
                cantidadPares++;
            }
        }

        System.out.println(
                "Cantidad total de números pares: "
                        + cantidadPares
        );

        /*
         * ==================================================
         * EJEMPLO 6: ACUMULADOR
         * ==================================================
         *
         * Un acumulador guarda una suma progresiva.
         *
         * Sumaremos los números del 1 al 5.
         */

        int sumaNumeros = 0;

        System.out.println("\nEJEMPLO 6: ACUMULADOR");
        System.out.println("--------------------------------");

        for (int numero = 1; numero <= 5; numero++) {

            sumaNumeros += numero;

            System.out.println(
                    "Número actual: " + numero
                            + " | Suma acumulada: "
                            + sumaNumeros
            );
        }

        System.out.println(
                "Suma total: " + sumaNumeros
        );

        /*
         * ==================================================
         * EJEMPLO 7: REGISTRO DE NOTAS
         * ==================================================
         *
         * El usuario indica cuántas notas desea registrar.
         *
         * En este ejemplo utilizaremos:
         *
         * - Un ciclo for.
         * - Un acumulador de notas.
         * - Un contador de notas aprobadas.
         * - Un contador de notas reprobadas.
         */

        System.out.println("\nEJEMPLO 7: REGISTRO DE NOTAS");
        System.out.println("--------------------------------");

        System.out.print(
                "¿Cuántas notas desea registrar?: "
        );

        int cantidadNotas = teclado.nextInt();

        /*
         * Acumulador:
         * Guarda la suma de todas las notas.
         */
        double sumaNotas = 0.0;

        /*
         * Contadores:
         * Registran cuántas notas son aprobadas
         * y cuántas son reprobadas.
         */
        int notasAprobadas = 0;
        int notasReprobadas = 0;

        for (int i = 1; i <= cantidadNotas; i++) {

            System.out.print(
                    "Ingrese la nota " + i + ": "
            );

            double nota = teclado.nextDouble();

            /*
             * Acumulamos la nota ingresada.
             */
            sumaNotas += nota;

            /*
             * Clasificamos la nota.
             */
            if (nota >= 3.0) {

                notasAprobadas++;

            } else {

                notasReprobadas++;
            }
        }

        /*
         * Calculamos el promedio.
         *
         * Se valida que cantidadNotas sea mayor que cero
         * para evitar una división entre cero.
         */
        if (cantidadNotas > 0) {

            double promedio =
                    sumaNotas / cantidadNotas;

            System.out.println("\nRESULTADOS");
            System.out.println("--------------------------------");

            System.out.println(
                    "Suma de las notas: " + sumaNotas
            );

            System.out.println(
                    "Promedio: " + promedio
            );

            System.out.println(
                    "Notas aprobadas: " + notasAprobadas
            );

            System.out.println(
                    "Notas reprobadas: " + notasReprobadas
            );

        } else {

            System.out.println(
                    "No se registraron notas."
            );
        }

        teclado.close();
    }
}