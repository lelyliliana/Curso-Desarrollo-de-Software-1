package com.lelyliliana.unidad1;

/*
 * EJEMPLO 7 - UNIDAD 1
 *
 * Tema:
 * Operadores de asignación, incremento y decremento.
 *
 * En este programa se utilizan:
 *
 * =   Asignación simple
 * +=  Suma y asignación
 * -=  Resta y asignación
 * *=  Multiplicación y asignación
 * /=  División y asignación
 * ++  Incremento
 * --  Decremento
 *
 * También se compara:
 *
 * ++numero  Incremento en prefijo
 * numero++  Incremento en sufijo
 */

public class AsignacionIncrementos {

    public static void main(String[] args) {

        /*
         * ==================================================
         * ASIGNACIÓN SIMPLE
         * ==================================================
         *
         * El operador = permite asignar un valor
         * a una variable.
         */

        int numero = 10;

        System.out.println("OPERADORES DE ASIGNACIÓN");
        System.out.println("--------------------------------");

        System.out.println("Valor inicial: " + numero);

        /*
         * ==================================================
         * SUMA Y ASIGNACIÓN +=
         * ==================================================
         *
         * numero += 5;
         *
         * Es equivalente a:
         *
         * numero = numero + 5;
         */

        numero += 5;

        System.out.println(
                "Después de numero += 5: " + numero
        );

        /*
         * ==================================================
         * RESTA Y ASIGNACIÓN -=
         * ==================================================
         *
         * numero -= 3;
         *
         * Es equivalente a:
         *
         * numero = numero - 3;
         */

        numero -= 3;

        System.out.println(
                "Después de numero -= 3: " + numero
        );

        /*
         * ==================================================
         * MULTIPLICACIÓN Y ASIGNACIÓN *=
         * ==================================================
         *
         * numero *= 2;
         *
         * Es equivalente a:
         *
         * numero = numero * 2;
         */

        numero *= 2;

        System.out.println(
                "Después de numero *= 2: " + numero
        );

        /*
         * ==================================================
         * DIVISIÓN Y ASIGNACIÓN /=
         * ==================================================
         *
         * numero /= 4;
         *
         * Es equivalente a:
         *
         * numero = numero / 4;
         */

        numero /= 4;

        System.out.println(
                "Después de numero /= 4: " + numero
        );

        /*
         * ==================================================
         * EJEMPLO CON UNA CUENTA
         * ==================================================
         */

        double saldo = 100000.0;

        System.out.println("\nEJEMPLO CON SALDO");
        System.out.println("--------------------------------");

        System.out.println("Saldo inicial: $" + saldo);

        /*
         * Se realiza un depósito.
         */

        saldo += 50000.0;

        System.out.println(
                "Después del depósito: $" + saldo
        );

        /*
         * Se realiza un retiro.
         */

        saldo -= 30000.0;

        System.out.println(
                "Después del retiro: $" + saldo
        );

        /*
         * Se aplica un aumento del 10 %.
         *
         * Multiplicar por 1.10 equivale a aumentar 10 %.
         */

        saldo *= 1.10;

        System.out.println(
                "Después de aumentar 10 %: $" + saldo
        );

        /*
         * Se divide el saldo entre dos personas.
         */

        saldo /= 2;

        System.out.println(
                "Saldo dividido entre dos: $" + saldo
        );

        /*
         * ==================================================
         * INCREMENTO EN PREFIJO
         * ==================================================
         *
         * En ++numero:
         *
         * 1. Primero se incrementa la variable.
         * 2. Después se utiliza su nuevo valor.
         */

        int valorPrefijo = 5;

        System.out.println("\nINCREMENTO EN PREFIJO");
        System.out.println("--------------------------------");

        System.out.println(
                "Valor inicial: " + valorPrefijo
        );

        int resultadoPrefijo = ++valorPrefijo;

        System.out.println(
                "Resultado de ++valorPrefijo: "
                        + resultadoPrefijo
        );

        System.out.println(
                "Valor final de valorPrefijo: "
                        + valorPrefijo
        );

        /*
         * ==================================================
         * INCREMENTO EN SUFIJO
         * ==================================================
         *
         * En numero++:
         *
         * 1. Primero se utiliza el valor actual.
         * 2. Después se incrementa la variable.
         */

        int valorSufijo = 5;

        System.out.println("\nINCREMENTO EN SUFIJO");
        System.out.println("--------------------------------");

        System.out.println(
                "Valor inicial: " + valorSufijo
        );

        int resultadoSufijo = valorSufijo++;

        System.out.println(
                "Resultado de valorSufijo++: "
                        + resultadoSufijo
        );

        System.out.println(
                "Valor final de valorSufijo: "
                        + valorSufijo
        );

        /*
         * ==================================================
         * COMPARACIÓN ENTRE PREFIJO Y SUFIJO
         * ==================================================
         */

        int numeroA = 10;
        int numeroB = 10;

        int resultadoA = ++numeroA;
        int resultadoB = numeroB++;

        System.out.println("\nCOMPARACIÓN");
        System.out.println("--------------------------------");

        System.out.println(
                "Con prefijo, resultadoA = " + resultadoA
        );

        System.out.println(
                "Con prefijo, numeroA = " + numeroA
        );

        System.out.println(
                "Con sufijo, resultadoB = " + resultadoB
        );

        System.out.println(
                "Con sufijo, numeroB = " + numeroB
        );

        /*
         * ==================================================
         * DECREMENTO EN PREFIJO Y SUFIJO
         * ==================================================
         */

        int contador1 = 8;
        int contador2 = 8;

        int resultadoDecrementoPrefijo = --contador1;
        int resultadoDecrementoSufijo = contador2--;

        System.out.println("\nDECREMENTO");
        System.out.println("--------------------------------");

        System.out.println(
                "Resultado de --contador1: "
                        + resultadoDecrementoPrefijo
        );

        System.out.println(
                "Valor final de contador1: "
                        + contador1
        );

        System.out.println(
                "Resultado de contador2--: "
                        + resultadoDecrementoSufijo
        );

        System.out.println(
                "Valor final de contador2: "
                        + contador2
        );
    }
}