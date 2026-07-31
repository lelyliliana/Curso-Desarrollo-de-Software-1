package com.lelyliliana.unidad3;

/*
 * EJEMPLO 4 - UNIDAD 3
 *
 * Tema:
 * Manejo de múltiples excepciones.
 *
 * Un mismo bloque try puede producir diferentes tipos
 * de excepciones.
 *
 * Para controlar cada situación de manera específica,
 * podemos utilizar varios bloques catch.
 *
 * En este programa se controlan:
 *
 * - InputMismatchException:
 *   ocurre cuando se ingresa un tipo de dato incorrecto.
 *
 * - ArithmeticException:
 *   ocurre al dividir un número entero entre cero.
 *
 * - ArrayIndexOutOfBoundsException:
 *   ocurre al intentar acceder a una posición inexistente
 *   de un arreglo.
 *
 * - Exception:
 *   captura cualquier otra excepción no controlada antes.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class U3_04_ExcepcionesMultiples {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        /*
         * Arreglo con cinco valores.
         *
         * Sus posiciones válidas son:
         *
         * 0, 1, 2, 3 y 4.
         */
        int[] numeros = {10, 20, 30, 40, 50};

        System.out.println("MANEJO DE MÚLTIPLES EXCEPCIONES");
        System.out.println("----------------------------------------");

        try {

            /*
             * ==================================================
             * PRIMER POSIBLE ERROR
             * ==================================================
             *
             * Si el usuario escribe letras o un decimal,
             * nextInt() produce InputMismatchException.
             */

            System.out.print("Ingrese el dividendo entero: ");
            int dividendo = teclado.nextInt();

            System.out.print("Ingrese el divisor entero: ");
            int divisor = teclado.nextInt();

            /*
             * ==================================================
             * SEGUNDO POSIBLE ERROR
             * ==================================================
             *
             * Si divisor es cero, se genera:
             *
             * ArithmeticException.
             */

            int resultadoDivision = dividendo / divisor;

            System.out.println(
                    "\nResultado de la división: "
                            + resultadoDivision
            );

            /*
             * ==================================================
             * TERCER POSIBLE ERROR
             * ==================================================
             *
             * Solicitamos una posición del arreglo.
             */

            System.out.print(
                    "\nIngrese una posición del arreglo entre 0 y 4: "
            );

            int posicion = teclado.nextInt();

            /*
             * Si la posición es menor que 0 o mayor que 4,
             * se genera ArrayIndexOutOfBoundsException.
             */

            int valorSeleccionado = numeros[posicion];

            System.out.println(
                    "Valor almacenado en la posición "
                            + posicion
                            + ": "
                            + valorSeleccionado
            );

            /*
             * Este mensaje solamente se muestra cuando
             * todas las instrucciones anteriores se
             * ejecutaron correctamente.
             */

            System.out.println(
                    "\nTodas las operaciones fueron exitosas."
            );

        /*
         * ==================================================
         * PRIMER CATCH
         * ==================================================
         *
         * Controla errores de entrada de datos.
         */
        } catch (InputMismatchException e) {

            System.out.println(
                    "\nError: debe ingresar números enteros."
            );

            System.out.println(
                    "Tipo de excepción: "
                            + e.getClass().getSimpleName()
            );

            /*
             * Eliminamos el dato incorrecto que quedó
             * pendiente en Scanner.
             */
            teclado.nextLine();

        /*
         * ==================================================
         * SEGUNDO CATCH
         * ==================================================
         *
         * Controla la división entre cero.
         */
        } catch (ArithmeticException e) {

            System.out.println(
                    "\nError: no se puede dividir entre cero."
            );

            System.out.println(
                    "Detalle técnico: " + e.getMessage()
            );

        /*
         * ==================================================
         * TERCER CATCH
         * ==================================================
         *
         * Controla posiciones inexistentes del arreglo.
         */
        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                    "\nError: la posición solicitada no existe."
            );

            System.out.println(
                    "Las posiciones válidas son de 0 a "
                            + (numeros.length - 1)
                            + "."
            );

            System.out.println(
                    "Detalle técnico: " + e.getMessage()
            );

        /*
         * ==================================================
         * CATCH GENERAL
         * ==================================================
         *
         * Exception es una clase general.
         *
         * Este bloque captura cualquier excepción que no
         * haya sido controlada por los catch anteriores.
         *
         * Debe ubicarse al final.
         */
        } catch (Exception e) {

            System.out.println(
                    "\nOcurrió un error inesperado."
            );

            System.out.println(
                    "Tipo de excepción: "
                            + e.getClass().getSimpleName()
            );

            System.out.println(
                    "Detalle: " + e.getMessage()
            );

        /*
         * ==================================================
         * BLOQUE FINALLY
         * ==================================================
         *
         * Se ejecuta siempre, haya ocurrido o no una excepción.
         */
        } finally {

            System.out.println(
                    "\nEl intento de realizar las operaciones "
                            + "ha finalizado."
            );
        }

        /*
         * Como las excepciones fueron controladas,
         * el programa puede continuar.
         */

        System.out.println(
                "El programa continúa después del manejo "
                        + "de excepciones."
        );

        teclado.close();
    }
}