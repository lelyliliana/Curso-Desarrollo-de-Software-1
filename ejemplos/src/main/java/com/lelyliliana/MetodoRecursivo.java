package com.lelyliliana;

/*
 * TEMA: Métodos recursivos
 *
 * Un método recursivo es aquel que se llama a sí mismo.
 *
 * En este ejemplo calcularemos el factorial.
 *
 * Factorial de 5:
 * 5 × 4 × 3 × 2 × 1 = 120
 */

public class MetodoRecursivo {

    // Método recursivo
    public static int calcularFactorial(int numero) {

        /*
         * Caso base.
         *
         * Permite detener las llamadas recursivas.
         */
        if (numero == 0 || numero == 1) {
            return 1;
        }

        /*
         * El método se llama a sí mismo usando
         * un número menor.
         */
        return numero * calcularFactorial(numero - 1);
    }

    public static void main(String[] args) {

        int numero = 5;

        int factorial = calcularFactorial(numero);

        System.out.println(
                "El factorial de " + numero + " es: " + factorial
        );
    }
}
