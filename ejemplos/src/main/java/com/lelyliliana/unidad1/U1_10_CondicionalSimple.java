package com.lelyliliana.unidad1;

/*
 * EJEMPLO 10 - UNIDAD 1
 *
 * Tema:
 * Condicional simple con la estructura if.
 *
 * Una estructura condicional permite tomar decisiones.
 *
 * El bloque de instrucciones dentro del if solamente
 * se ejecuta cuando la condición es verdadera.
 */

import java.util.Scanner;

public class U1_10_CondicionalSimple {

    public static void main(String[] args) {

        // Creamos el objeto Scanner.
        Scanner teclado = new Scanner(System.in);

        /*
         * Constante que representa la edad mínima
         * para ser mayor de edad.
         */
        final int EDAD_MINIMA = 18;

        System.out.println("CONDICIONAL SIMPLE");
        System.out.println("--------------------------------");

        /*
         * Solicitamos la edad al usuario.
         */
        System.out.print("Ingrese su edad: ");
        int edad = teclado.nextInt();

        /*
         * ==================================================
         * ESTRUCTURA IF
         * ==================================================
         *
         * La condición que se evaluará es:
         *
         * edad >= EDAD_MINIMA
         *
         * Si el resultado es true, Java ejecuta las
         * instrucciones que están dentro de las llaves.
         *
         * Si el resultado es false, Java omite ese bloque.
         */

        if (edad >= EDAD_MINIMA) {

            System.out.println(
                    "La persona es mayor de edad."
            );

            System.out.println(
                    "Puede realizar trámites para adultos."
            );
        }

        /*
         * Esta instrucción no pertenece al if.
         *
         * Por esa razón se ejecuta siempre, sin importar
         * si la condición fue verdadera o falsa.
         */
        System.out.println(
                "La validación de la edad ha finalizado."
        );

        /*
         * ==================================================
         * SEGUNDO EJEMPLO
         * ==================================================
         *
         * Solicitamos una nota académica.
         */

        System.out.print("\nIngrese una nota entre 0.0 y 5.0: ");
        double nota = teclado.nextDouble();

        /*
         * Este mensaje solamente se mostrará cuando
         * la nota sea mayor o igual que 3.0.
         */
        if (nota >= 3.0) {

            System.out.println(
                    "La nota es aprobatoria."
            );
        }

        /*
         * La estructura condicional simple no incluye else.
         *
         * Por eso, si la nota es menor que 3.0,
         * simplemente no se muestra el mensaje anterior.
         */
        System.out.println(
                "Nota registrada: " + nota
        );

        /*
         * ==================================================
         * TERCER EJEMPLO
         * ==================================================
         *
         * Validación de un número positivo.
         */

        System.out.print("\nIngrese un número entero: ");
        int numero = teclado.nextInt();

        if (numero > 0) {

            System.out.println(
                    "El número ingresado es positivo."
            );
        }

        System.out.println(
                "Número evaluado: " + numero
        );

        // Cerramos Scanner.
        teclado.close();
    }
}