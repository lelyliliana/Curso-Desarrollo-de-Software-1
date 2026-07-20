package com.lelyliliana;

/*
 * TEMA: Varios métodos dentro de una clase
 *
 * Cada método realiza una operación diferente.
 */

public class CalculadoraCompleta {

    // Método para sumar
    public double sumar(double numero1, double numero2) {
        return numero1 + numero2;
    }

    // Método para restar
    public double restar(double numero1, double numero2) {
        return numero1 - numero2;
    }

    // Método para multiplicar
    public double multiplicar(double numero1, double numero2) {
        return numero1 * numero2;
    }

    // Método para dividir
    public double dividir(double numero1, double numero2) {

        // Validamos que el divisor no sea cero
        if (numero2 == 0) {
            System.out.println("No se puede dividir entre cero.");
            return 0;
        }

        return numero1 / numero2;
    }

    public static void main(String[] args) {

        // Creamos el objeto
        CalculadoraCompleta calculadora = new CalculadoraCompleta();

        // Declaramos los números
        double numero1 = 20;
        double numero2 = 5;

        // Llamamos cada método y mostramos el resultado
        System.out.println(
                "Suma: " + calculadora.sumar(numero1, numero2)
        );

        System.out.println(
                "Resta: " + calculadora.restar(numero1, numero2)
        );

        System.out.println(
                "Multiplicación: "
                        + calculadora.multiplicar(numero1, numero2)
        );

        System.out.println(
                "División: " + calculadora.dividir(numero1, numero2)
        );
    }
}
