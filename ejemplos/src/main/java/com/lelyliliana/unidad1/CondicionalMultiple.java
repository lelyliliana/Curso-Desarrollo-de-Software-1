package com.lelyliliana.unidad1;

/*
 * EJEMPLO 12 - UNIDAD 1
 *
 * Tema:
 * Condicional múltiple con if, else if y else.
 *
 * Esta estructura permite evaluar varias condiciones.
 *
 * Java revisa las condiciones en orden:
 *
 * 1. Evalúa el if.
 * 2. Si es falso, evalúa el primer else if.
 * 3. Continúa hasta encontrar una condición verdadera.
 * 4. Si ninguna condición es verdadera, ejecuta el else.
 *
 * Solo se ejecuta uno de los bloques.
 */

import java.util.Scanner;

public class CondicionalMultiple {

    public static void main(String[] args) {

        // Creamos el objeto Scanner.
        Scanner teclado = new Scanner(System.in);

        /*
         * Constantes que representan los límites
         * permitidos para una nota.
         */
        final double NOTA_MINIMA = 0.0;
        final double NOTA_MAXIMA = 5.0;

        System.out.println("CLASIFICACIÓN DE UNA NOTA");
        System.out.println("--------------------------------");

        /*
         * Solicitamos la nota al usuario.
         */
        System.out.print("Ingrese una nota entre 0.0 y 5.0: ");
        double nota = teclado.nextDouble();

        /*
         * ==================================================
         * CONDICIONAL MÚLTIPLE
         * ==================================================
         *
         * Primero validamos que la nota esté dentro
         * del rango permitido.
         */

        if (nota < NOTA_MINIMA || nota > NOTA_MAXIMA) {

            /*
             * Este bloque se ejecuta cuando la nota
             * es menor que 0 o mayor que 5.
             */
            System.out.println(
                    "Error: la nota está fuera del rango permitido."
            );

        } else if (nota >= 4.5) {

            /*
             * Este bloque se ejecuta cuando la nota
             * está entre 4.5 y 5.0.
             */
            System.out.println("Clasificación: Excelente");
            System.out.println("Desempeño sobresaliente.");

        } else if (nota >= 4.0) {

            /*
             * Si el programa llegó a este punto,
             * sabemos que la nota es menor que 4.5.
             *
             * Por tanto, esta condición representa
             * notas desde 4.0 hasta menos de 4.5.
             */
            System.out.println("Clasificación: Muy bueno");
            System.out.println("Desempeño superior.");

        } else if (nota >= 3.5) {

            /*
             * Nota desde 3.5 hasta menos de 4.0.
             */
            System.out.println("Clasificación: Bueno");
            System.out.println("Desempeño satisfactorio.");

        } else if (nota >= 3.0) {

            /*
             * Nota desde 3.0 hasta menos de 3.5.
             */
            System.out.println("Clasificación: Aprobado");
            System.out.println("Alcanzó la nota mínima requerida.");

        } else {

            /*
             * Si ninguna condición anterior fue verdadera,
             * la nota está entre 0.0 y menos de 3.0.
             */
            System.out.println("Clasificación: Reprobado");
            System.out.println("No alcanzó la nota mínima requerida.");
        }

        /*
         * Este mensaje está fuera de la estructura.
         * Por eso se ejecuta siempre.
         */
        System.out.println(
                "Nota evaluada: " + nota
        );

        /*
         * ==================================================
         * SEGUNDO EJEMPLO: CLASIFICACIÓN POR EDAD
         * ==================================================
         */

        System.out.println("\nCLASIFICACIÓN POR EDAD");
        System.out.println("--------------------------------");

        System.out.print("Ingrese la edad de la persona: ");
        int edad = teclado.nextInt();

        if (edad < 0) {

            System.out.println(
                    "Error: la edad no puede ser negativa."
            );

        } else if (edad <= 11) {

            System.out.println(
                    "Clasificación: niñez."
            );

        } else if (edad <= 17) {

            System.out.println(
                    "Clasificación: adolescencia."
            );

        } else if (edad <= 59) {

            System.out.println(
                    "Clasificación: adultez."
            );

        } else {

            System.out.println(
                    "Clasificación: persona mayor."
            );
        }

        // Cerramos Scanner.
        teclado.close();
    }
}