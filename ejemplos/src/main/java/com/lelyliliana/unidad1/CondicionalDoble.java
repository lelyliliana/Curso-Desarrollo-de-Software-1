package com.lelyliliana.unidad1;

/*
 * EJEMPLO 11 - UNIDAD 1
 *
 * Tema:
 * Condicional doble con if y else.
 *
 * La estructura if-else permite elegir entre
 * dos caminos posibles:
 *
 * - Si la condición es verdadera, se ejecuta el bloque if.
 * - Si la condición es falsa, se ejecuta el bloque else.
 */

import java.util.Scanner;

public class CondicionalDoble {

    public static void main(String[] args) {

        // Creamos el objeto Scanner para leer datos.
        Scanner teclado = new Scanner(System.in);

        /*
         * Constante que representa la edad desde la cual
         * una persona se considera mayor de edad.
         */
        final int EDAD_MINIMA = 18;

        System.out.println("CONDICIONAL DOBLE");
        System.out.println("--------------------------------");

        /*
         * Solicitamos la edad al usuario.
         */
        System.out.print("Ingrese su edad: ");
        int edad = teclado.nextInt();

        /*
         * ==================================================
         * ESTRUCTURA IF-ELSE
         * ==================================================
         *
         * Se evalúa la condición:
         *
         * edad >= EDAD_MINIMA
         *
         * Solo uno de los dos bloques se ejecutará.
         */

        if (edad >= EDAD_MINIMA) {

            /*
             * Este bloque se ejecuta cuando la condición
             * es verdadera.
             */
            System.out.println(
                    "La persona es mayor de edad."
            );

            System.out.println(
                    "Puede realizar trámites para adultos."
            );

        } else {

            /*
             * Este bloque se ejecuta cuando la condición
             * es falsa.
             */
            System.out.println(
                    "La persona es menor de edad."
            );

            /*
             * Calculamos cuántos años faltan para alcanzar
             * la mayoría de edad.
             */
            int aniosFaltantes = EDAD_MINIMA - edad;

            System.out.println(
                    "Le faltan "
                            + aniosFaltantes
                            + " año(s) para cumplir "
                            + EDAD_MINIMA
                            + " años."
            );
        }

        /*
         * Esta instrucción está fuera del if-else.
         *
         * Por eso se ejecuta siempre, independientemente
         * del resultado de la condición.
         */
        System.out.println(
                "La validación de la edad ha finalizado."
        );

        /*
         * ==================================================
         * SEGUNDO EJEMPLO: NÚMERO PAR O IMPAR
         * ==================================================
         */

        System.out.print("\nIngrese un número entero: ");
        int numero = teclado.nextInt();

        /*
         * Si el residuo de dividir un número entre 2 es 0,
         * el número es par.
         *
         * En caso contrario, es impar.
         */
        if (numero % 2 == 0) {

            System.out.println(
                    "El número " + numero + " es par."
            );

        } else {

            System.out.println(
                    "El número " + numero + " es impar."
            );
        }

        /*
         * ==================================================
         * TERCER EJEMPLO: APROBADO O REPROBADO
         * ==================================================
         */

        System.out.print(
                "\nIngrese una nota entre 0.0 y 5.0: "
        );

        double nota = teclado.nextDouble();

        final double NOTA_MINIMA_APROBACION = 3.0;

        if (nota >= NOTA_MINIMA_APROBACION) {

            System.out.println(
                    "Resultado: asignatura aprobada."
            );

        } else {

            System.out.println(
                    "Resultado: asignatura reprobada."
            );
        }

        /*
         * Mostramos la nota evaluada.
         */
        System.out.println(
                "Nota registrada: " + nota
        );

        // Cerramos Scanner.
        teclado.close();
    }
}