package com.lelyliliana;

/*
 * TEMA: Método main
 *
 * No todas las clases necesitan tener un método main.
 * Solamente se necesita en la clase desde la cual
 * comienza la ejecución del programa.
 */

// Esta clase no tiene método main
class CalculadoraBasica {

    // Método que retorna la suma
    int sumar(int numero1, int numero2) {
        return numero1 + numero2;
    }

    // Método que retorna la resta
    int restar(int numero1, int numero2) {
        return numero1 - numero2;
    }
}

// Esta es la clase principal
public class ClasePrincipal {

    // El programa comienza aquí
    public static void main(String[] args) {

        // Creamos un objeto de la otra clase
        CalculadoraBasica calculadora = new CalculadoraBasica();

        // Utilizamos sus métodos
        int suma = calculadora.sumar(20, 10);
        int resta = calculadora.restar(20, 10);

        // Mostramos los resultados
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
    }
}