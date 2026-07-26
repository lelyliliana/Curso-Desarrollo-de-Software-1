package com.lelyliliana.unidad2;


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