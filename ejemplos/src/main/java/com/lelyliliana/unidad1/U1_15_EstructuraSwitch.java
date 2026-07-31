package com.lelyliliana.unidad1;

/*
 * EJEMPLO 15 - UNIDAD 1
 *
 * Tema:
 * Estructura switch.
 *
 * switch permite seleccionar una opción entre
 * varios casos posibles.
 *
 * Elementos principales:
 *
 * switch   -> evalúa una expresión.
 * case     -> representa una opción posible.
 * break    -> detiene la ejecución del switch.
 * default  -> se ejecuta cuando ningún case coincide.
 */

import java.util.Scanner;

public class U1_15_EstructuraSwitch {

    public static void main(String[] args) {

        // Creamos el objeto Scanner.
        Scanner teclado = new Scanner(System.in);

        System.out.println("MENÚ DE OPERACIONES");
        System.out.println("--------------------------------");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Salir");

        System.out.print("\nSeleccione una opción: ");
        int opcion = teclado.nextInt();

        /*
         * ==================================================
         * ESTRUCTURA SWITCH
         * ==================================================
         *
         * switch evalúa el valor almacenado en opcion.
         *
         * Luego compara ese valor con cada case.
         */

        switch (opcion) {

            case 1:

                /*
                 * Este bloque se ejecuta cuando
                 * opcion es igual a 1.
                 */
                System.out.println("\nOPERACIÓN: SUMA");

                System.out.print("Ingrese el primer número: ");
                double numero1Suma = teclado.nextDouble();

                System.out.print("Ingrese el segundo número: ");
                double numero2Suma = teclado.nextDouble();

                double suma = numero1Suma + numero2Suma;

                System.out.println(
                        "Resultado: " + suma
                );

                /*
                 * break detiene la ejecución del switch.
                 *
                 * Sin break, Java continuaría ejecutando
                 * los casos siguientes.
                 */
                break;

            case 2:

                System.out.println("\nOPERACIÓN: RESTA");

                System.out.print("Ingrese el primer número: ");
                double numero1Resta = teclado.nextDouble();

                System.out.print("Ingrese el segundo número: ");
                double numero2Resta = teclado.nextDouble();

                double resta = numero1Resta - numero2Resta;

                System.out.println(
                        "Resultado: " + resta
                );

                break;

            case 3:

                System.out.println("\nOPERACIÓN: MULTIPLICACIÓN");

                System.out.print("Ingrese el primer número: ");
                double numero1Multiplicacion = teclado.nextDouble();

                System.out.print("Ingrese el segundo número: ");
                double numero2Multiplicacion = teclado.nextDouble();

                double multiplicacion =
                        numero1Multiplicacion
                                * numero2Multiplicacion;

                System.out.println(
                        "Resultado: " + multiplicacion
                );

                break;

            case 4:

                System.out.println("\nOPERACIÓN: DIVISIÓN");

                System.out.print("Ingrese el dividendo: ");
                double dividendo = teclado.nextDouble();

                System.out.print("Ingrese el divisor: ");
                double divisor = teclado.nextDouble();

                /*
                 * Antes de dividir, verificamos que
                 * el divisor no sea cero.
                 */
                if (divisor != 0) {

                    double division = dividendo / divisor;

                    System.out.println(
                            "Resultado: " + division
                    );

                } else {

                    System.out.println(
                            "Error: no se puede dividir entre cero."
                    );
                }

                break;

            case 5:

                System.out.println(
                        "\nEl programa ha finalizado."
                );

                break;

            default:

                /*
                 * default se ejecuta cuando el valor
                 * no coincide con ningún case.
                 */
                System.out.println(
                        "\nError: la opción seleccionada no es válida."
                );
        }

        /*
         * Esta instrucción está fuera del switch.
         * Por eso se ejecuta al finalizar cualquiera
         * de los casos.
         */
        System.out.println(
                "Fin de la ejecución del menú."
        );

        // Cerramos Scanner.
        teclado.close();
    }
}