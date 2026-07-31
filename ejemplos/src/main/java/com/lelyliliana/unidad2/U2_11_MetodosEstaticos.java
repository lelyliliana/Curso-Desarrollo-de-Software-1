package com.lelyliliana.unidad2;

/*
 * TEMA: Métodos estáticos
 *
 * Un método estático pertenece a la clase.
 * Se puede llamar sin crear un objeto.
 */

public class U2_11_MetodosEstaticos {

    // Método estático que calcula el cuadrado
    public static double calcularCuadrado(double numero) {
        return numero * numero;
    }

    // Método estático que determina si un número es par
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    public static void main(String[] args) {

        /*
         * No necesitamos crear un objeto.
         * Llamamos los métodos usando el nombre de la clase.
         */

        double cuadrado = U2_11_MetodosEstaticos.calcularCuadrado(6);

        System.out.println("El cuadrado de 6 es: " + cuadrado);

        int numero = 8;

        if (U2_11_MetodosEstaticos.esPar(numero)) {
            System.out.println(numero + " es un número par.");
        } else {
            System.out.println(numero + " es un número impar.");
        }

        /*
         * Math.sqrt también es un método estático.
         */
        double raiz = Math.sqrt(81);

        System.out.println("La raíz cuadrada de 81 es: " + raiz);
    }
}
