package com.lelyliliana.unidad2;

/*
 * TEMA: Métodos, parámetros y Scanner
 *
 * El programa solicita datos al usuario y los envía
 * como argumentos a diferentes métodos.
 */

import java.util.Scanner;

public class U2_09_MetodoConScanner {

    // Método que calcula y retorna la suma
    public int sumar(int numero1, int numero2) {
        return numero1 + numero2;
    }

    // Método que indica cuál número es mayor
    public void mostrarMayor(int numero1, int numero2) {

        if (numero1 > numero2) {
            System.out.println("El número mayor es: " + numero1);
        } else if (numero2 > numero1) {
            System.out.println("El número mayor es: " + numero2);
        } else {
            System.out.println("Los dos números son iguales.");
        }
    }

    public static void main(String[] args) {

        // Creamos el objeto Scanner
        Scanner teclado = new Scanner(System.in);

        // Creamos el objeto de la clase
        U2_09_MetodoConScanner programa = new U2_09_MetodoConScanner();

        // Solicitamos los números
        System.out.print("Ingrese el primer número: ");
        int numero1 = teclado.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int numero2 = teclado.nextInt();

        // Llamamos el método sumar
        int resultado = programa.sumar(numero1, numero2);

        // Mostramos el resultado retornado
        System.out.println("La suma es: " + resultado);

        // Llamamos otro método
        programa.mostrarMayor(numero1, numero2);

        // Cerramos el Scanner
        teclado.close();
    }
}
