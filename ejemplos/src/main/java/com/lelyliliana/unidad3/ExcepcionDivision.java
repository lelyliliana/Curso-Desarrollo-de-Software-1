package com.lelyliliana.unidad3;

/*
 * EJEMPLO 2 - UNIDAD 3
 *
 * Tema:
 * Manejo básico de excepciones con:
 *
 * - try
 * - catch
 * - finally
 * - ArithmeticException
 *
 * Una excepción es una situación inesperada que ocurre
 * durante la ejecución de un programa.
 *
 * En este ejemplo se intenta dividir dos números enteros.
 * Si el divisor es cero, Java genera una ArithmeticException.
 */

import java.util.Scanner;

public class ExcepcionDivision {

    public static void main(String[] args) {

        // Creamos el objeto Scanner.
        Scanner teclado = new Scanner(System.in);

        System.out.println("DIVISIÓN CON MANEJO DE EXCEPCIONES");
        System.out.println("----------------------------------------");

        /*
         * Solicitamos los valores al usuario.
         */
        System.out.print("Ingrese el dividendo: ");
        int dividendo = teclado.nextInt();

        System.out.print("Ingrese el divisor: ");
        int divisor = teclado.nextInt();

        /*
         * ==================================================
         * BLOQUE TRY
         * ==================================================
         *
         * Dentro del bloque try colocamos las instrucciones
         * que podrían producir una excepción.
         */
        try {

            /*
             * Si divisor es cero, esta operación genera:
             *
             * ArithmeticException: / by zero
             */
            int resultado = dividendo / divisor;

            /*
             * Esta instrucción solo se ejecuta cuando
             * la división se realiza correctamente.
             */
            System.out.println(
                    "\nResultado: "
                            + dividendo
                            + " / "
                            + divisor
                            + " = "
                            + resultado
            );

        /*
         * ==================================================
         * BLOQUE CATCH
         * ==================================================
         *
         * catch captura la excepción generada dentro del try.
         *
         * ArithmeticException es el tipo de excepción
         * producida al dividir un número entero entre cero.
         *
         * La variable e contiene información sobre el error.
         */
        } catch (ArithmeticException e) {

            System.out.println(
                    "\nError: no se puede dividir entre cero."
            );

            /*
             * getMessage() muestra el mensaje interno
             * asociado con la excepción.
             */
            System.out.println(
                    "Detalle técnico: " + e.getMessage()
            );

        /*
         * ==================================================
         * BLOQUE FINALLY
         * ==================================================
         *
         * finally se ejecuta siempre:
         *
         * - Si no ocurrió ninguna excepción.
         * - Si ocurrió una excepción.
         */
        } finally {

            System.out.println(
                    "\nEl intento de división ha finalizado."
            );
        }

        /*
         * Esta instrucción está fuera del try-catch-finally.
         *
         * Se ejecuta porque la excepción fue controlada
         * y el programa pudo continuar normalmente.
         */
        System.out.println(
                "El programa continúa después de controlar el error."
        );

        // Cerramos Scanner.
        teclado.close();
    }
}