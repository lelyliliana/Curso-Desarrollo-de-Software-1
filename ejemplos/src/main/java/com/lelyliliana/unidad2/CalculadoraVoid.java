package com.lelyliliana.unidad2;

/*
 * TEMA: Método con parámetros y sin retorno
 *
 * El método recibe dos números, realiza la suma
 * y muestra el resultado directamente.
 */

public class CalculadoraVoid {

    /*
     * El método recibe dos parámetros enteros.
     *
     * Como es void, muestra el resultado, pero no lo retorna.
     */
    public void sumar(int numero1, int numero2) {

        int resultado = numero1 + numero2;

        System.out.println(
                numero1 + " + " + numero2 + " = " + resultado
        );
    }

    public static void main(String[] args) {

        // Creamos una instancia de la clase
        CalculadoraVoid calculadora = new CalculadoraVoid();

        // Enviamos dos argumentos al método
        calculadora.sumar(5, 7);

        // Reutilizamos el método con otros valores
        calculadora.sumar(20, 15);
        calculadora.sumar(50, 96);
    }
}
