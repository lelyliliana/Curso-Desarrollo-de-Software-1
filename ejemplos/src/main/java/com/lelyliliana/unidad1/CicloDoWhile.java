package com.lelyliliana.unidad1;

/*
 * EJEMPLO 19 - UNIDAD 1
 *
 * Tema:
 * Ciclo do-while.
 *
 * El ciclo do-while ejecuta primero las instrucciones
 * y después evalúa la condición.
 *
 * Por esta razón, el bloque siempre se ejecuta
 * al menos una vez.
 *
 * Estructura:
 *
 * do {
 *     instrucciones;
 * } while (condicion);
 */

import java.util.Scanner;

public class CicloDoWhile {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        /*
         * ==================================================
         * EJEMPLO 1: EJECUCIÓN AL MENOS UNA VEZ
         * ==================================================
         */

        System.out.println("EJEMPLO 1: CICLO DO-WHILE");
        System.out.println("--------------------------------");

        int numero = 10;

        /*
         * Aunque numero <= 5 es falso desde el inicio,
         * el mensaje se muestra una vez porque la condición
         * se evalúa después de ejecutar el bloque.
         */
        do {

            System.out.println(
                    "Valor actual: " + numero
            );

            numero++;

        } while (numero <= 5);

        System.out.println(
                "El bloque se ejecutó una vez."
        );

        /*
         * ==================================================
         * EJEMPLO 2: NÚMEROS DEL 1 AL 5
         * ==================================================
         */

        System.out.println("\nEJEMPLO 2: NÚMEROS DEL 1 AL 5");
        System.out.println("--------------------------------");

        int contador = 1;

        do {

            System.out.println(contador);

            contador++;

        } while (contador <= 5);

        /*
         * ==================================================
         * EJEMPLO 3: VALIDACIÓN DE UNA NOTA
         * ==================================================
         *
         * El usuario debe ingresar una nota entre 0.0 y 5.0.
         *
         * El ciclo solicita el dato al menos una vez
         * y continúa mientras sea inválido.
         */

        System.out.println("\nEJEMPLO 3: VALIDACIÓN DE NOTA");
        System.out.println("--------------------------------");

        double nota;

        do {

            System.out.print(
                    "Ingrese una nota entre 0.0 y 5.0: "
            );

            nota = teclado.nextDouble();

            if (nota < 0.0 || nota > 5.0) {

                System.out.println(
                        "Error: la nota está fuera del rango."
                );
            }

        } while (nota < 0.0 || nota > 5.0);

        System.out.println(
                "Nota válida registrada: " + nota
        );

        /*
         * ==================================================
         * EJEMPLO 4: CONTRASEÑA
         * ==================================================
         */

        System.out.println("\nEJEMPLO 4: CONTRASEÑA");
        System.out.println("--------------------------------");

        final int CLAVE_CORRECTA = 1234;

        int claveIngresada;

        do {

            System.out.print(
                    "Ingrese la contraseña numérica: "
            );

            claveIngresada = teclado.nextInt();

            if (claveIngresada != CLAVE_CORRECTA) {

                System.out.println(
                        "Contraseña incorrecta."
                );
            }

        } while (claveIngresada != CLAVE_CORRECTA);

        System.out.println(
                "Acceso concedido."
        );

        /*
         * ==================================================
         * EJEMPLO 5: MENÚ REPETITIVO
         * ==================================================
         *
         * El menú debe mostrarse al menos una vez.
         *
         * Se repite mientras la opción sea diferente de 4.
         */

        System.out.println("\nEJEMPLO 5: MENÚ REPETITIVO");
        System.out.println("--------------------------------");

        int opcion;

        do {

            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Mostrar un saludo");
            System.out.println("2. Calcular el cuadrado de un número");
            System.out.println("3. Determinar si un número es par");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println(
                            "Hola. Bienvenido al programa."
                    );

                    break;

                case 2:

                    System.out.print(
                            "Ingrese un número: "
                    );

                    double numeroCuadrado =
                            teclado.nextDouble();

                    double cuadrado =
                            numeroCuadrado * numeroCuadrado;

                    System.out.println(
                            "El cuadrado de "
                                    + numeroCuadrado
                                    + " es "
                                    + cuadrado
                    );

                    break;

                case 3:

                    System.out.print(
                            "Ingrese un número entero: "
                    );

                    int numeroPar = teclado.nextInt();

                    if (numeroPar % 2 == 0) {

                        System.out.println(
                                numeroPar + " es par."
                        );

                    } else {

                        System.out.println(
                                numeroPar + " es impar."
                        );
                    }

                    break;

                case 4:

                    System.out.println(
                            "Saliendo del programa..."
                    );

                    break;

                default:

                    System.out.println(
                            "Error: opción no válida."
                    );
            }

        } while (opcion != 4);

        System.out.println(
                "El programa ha finalizado."
        );

        teclado.close();
    }
}