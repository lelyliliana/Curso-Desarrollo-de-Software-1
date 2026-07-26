package com.lelyliliana.unidad1;

/*
 * EJEMPLO 17 - UNIDAD 1
 *
 * Tema:
 * Ciclo while.
 *
 * El ciclo while repite un bloque de instrucciones
 * mientras una condición sea verdadera.
 *
 * Su estructura básica es:
 *
 * while (condicion) {
 *     instrucciones;
 * }
 *
 * La condición se evalúa antes de ejecutar el bloque.
 */

import java.util.Scanner;

public class CicloWhile {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        /*
         * ==================================================
         * EJEMPLO 1: NÚMEROS DEL 1 AL 5
         * ==================================================
         */

        System.out.println("EJEMPLO 1: NÚMEROS DEL 1 AL 5");
        System.out.println("--------------------------------");

        /*
         * Inicializamos la variable antes del ciclo.
         */
        int numero = 1;

        /*
         * El ciclo se repite mientras numero sea
         * menor o igual que 5.
         */
        while (numero <= 5) {

            System.out.println(numero);

            /*
             * Es necesario actualizar la variable.
             *
             * Si se elimina numero++, la condición siempre
             * será verdadera y se producirá un ciclo infinito.
             */
            numero++;
        }

        /*
         * ==================================================
         * EJEMPLO 2: CUENTA REGRESIVA
         * ==================================================
         */

        System.out.println("\nEJEMPLO 2: CUENTA REGRESIVA");
        System.out.println("--------------------------------");

        int cuenta = 5;

        while (cuenta >= 1) {

            System.out.println(cuenta);

            cuenta--;
        }

        System.out.println("¡Inicio!");

        /*
         * ==================================================
         * EJEMPLO 3: ACUMULADOR
         * ==================================================
         *
         * Sumaremos los números del 1 al 5.
         */

        System.out.println("\nEJEMPLO 3: ACUMULADOR");
        System.out.println("--------------------------------");

        int valorActual = 1;
        int suma = 0;

        while (valorActual <= 5) {

            suma += valorActual;

            System.out.println(
                    "Valor actual: " + valorActual
                            + " | Suma acumulada: " + suma
            );

            valorActual++;
        }

        System.out.println(
                "Suma total: " + suma
        );

        /*
         * ==================================================
         * EJEMPLO 4: VALIDACIÓN DE UNA NOTA
         * ==================================================
         *
         * El ciclo se repite mientras la nota ingresada
         * esté fuera del rango permitido.
         */

        System.out.println("\nEJEMPLO 4: VALIDACIÓN DE NOTA");
        System.out.println("--------------------------------");

        System.out.print(
                "Ingrese una nota entre 0.0 y 5.0: "
        );

        double nota = teclado.nextDouble();

        /*
         * La condición utiliza OR:
         *
         * nota < 0.0
         * o
         * nota > 5.0
         *
         * Mientras una de esas condiciones sea verdadera,
         * la nota será inválida.
         */
        while (nota < 0.0 || nota > 5.0) {

            System.out.println(
                    "Error: la nota está fuera del rango."
            );

            System.out.print(
                    "Ingrese nuevamente una nota entre 0.0 y 5.0: "
            );

            nota = teclado.nextDouble();
        }

        System.out.println(
                "Nota válida registrada: " + nota
        );

        /*
         * ==================================================
         * EJEMPLO 5: CONTRASEÑA
         * ==================================================
         *
         * El ciclo continúa mientras la contraseña
         * ingresada sea incorrecta.
         */

        final int CLAVE_CORRECTA = 1234;

        System.out.println("\nEJEMPLO 5: VALIDACIÓN DE CONTRASEÑA");
        System.out.println("--------------------------------");

        System.out.print("Ingrese la contraseña numérica: ");
        int claveIngresada = teclado.nextInt();

        while (claveIngresada != CLAVE_CORRECTA) {

            System.out.println(
                    "Contraseña incorrecta."
            );

            System.out.print(
                    "Intente nuevamente: "
            );

            claveIngresada = teclado.nextInt();
        }

        System.out.println(
                "Acceso concedido."
        );

        /*
         * ==================================================
         * EJEMPLO 6: TABLA DE MULTIPLICAR
         * ==================================================
         */

        System.out.println("\nEJEMPLO 6: TABLA DE MULTIPLICAR");
        System.out.println("--------------------------------");

        System.out.print(
                "Ingrese un número para mostrar su tabla: "
        );

        int numeroTabla = teclado.nextInt();

        int multiplicador = 1;

        while (multiplicador <= 10) {

            int resultado =
                    numeroTabla * multiplicador;

            System.out.println(
                    numeroTabla
                            + " x "
                            + multiplicador
                            + " = "
                            + resultado
            );

            multiplicador++;
        }

        teclado.close();
    }
}