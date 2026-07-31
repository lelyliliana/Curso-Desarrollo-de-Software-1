package com.lelyliliana.unidad2;

/*
 * TEMA: Sobrecarga de métodos
 *
 * La sobrecarga permite crear varios métodos con el
 * mismo nombre, pero con diferentes parámetros.
 */

public class U2_10_SobrecargaMetodos {

    // Suma de dos números enteros
    public int sumar(int numero1, int numero2) {
        return numero1 + numero2;
    }

    // Suma de tres números enteros
    public int sumar(int numero1, int numero2, int numero3) {
        return numero1 + numero2 + numero3;
    }

    // Suma de dos números decimales
    public double sumar(double numero1, double numero2) {
        return numero1 + numero2;
    }

    public static void main(String[] args) {

        U2_10_SobrecargaMetodos calculadora = new U2_10_SobrecargaMetodos();

        /*
         * Java selecciona automáticamente el método adecuado
         * según la cantidad y el tipo de argumentos.
         */

        System.out.println(
                "Suma de dos enteros: "
                        + calculadora.sumar(10, 5)
        );

        System.out.println(
                "Suma de tres enteros: "
                        + calculadora.sumar(10, 5, 3)
        );

        System.out.println(
                "Suma de dos decimales: "
                        + calculadora.sumar(4.5, 2.3)
        );
    }
}
