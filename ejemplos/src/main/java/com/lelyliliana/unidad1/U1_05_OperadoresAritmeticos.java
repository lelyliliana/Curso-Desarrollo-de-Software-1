package com.lelyliliana.unidad1;

/*
 * EJEMPLO 5 - UNIDAD 1
 *
 * Tema:
 * Operadores aritméticos en Java.
 *
 * En este programa se utilizan:
 *
 * +  Suma
 * -  Resta
 * *  Multiplicación
 * /  División
 * %  Módulo o residuo
 * ++ Incremento
 * -- Decremento
 */

public class U1_05_OperadoresAritmeticos {

    public static void main(String[] args) {

        /*
         * ==================================================
         * DECLARACIÓN DE VARIABLES
         * ==================================================
         */

        int numero1 = 20;
        int numero2 = 6;

        System.out.println("OPERADORES ARITMÉTICOS");
        System.out.println("--------------------------------");

        System.out.println("Primer número: " + numero1);
        System.out.println("Segundo número: " + numero2);

        /*
         * ==================================================
         * SUMA
         * ==================================================
         *
         * El operador + permite sumar valores numéricos.
         */

        int suma = numero1 + numero2;

        System.out.println("\nSUMA");
        System.out.println(numero1 + " + " + numero2 + " = " + suma);

        /*
         * ==================================================
         * RESTA
         * ==================================================
         */

        int resta = numero1 - numero2;

        System.out.println("\nRESTA");
        System.out.println(numero1 + " - " + numero2 + " = " + resta);

        /*
         * ==================================================
         * MULTIPLICACIÓN
         * ==================================================
         */

        int multiplicacion = numero1 * numero2;

        System.out.println("\nMULTIPLICACIÓN");
        System.out.println(
                numero1 + " * " + numero2 + " = " + multiplicacion
        );

        /*
         * ==================================================
         * DIVISIÓN ENTERA
         * ==================================================
         *
         * Como numero1 y numero2 son de tipo int,
         * Java realiza una división entera.
         *
         * El resultado no conserva la parte decimal.
         *
         * 20 / 6 produce 3, no 3.333...
         */

        int divisionEntera = numero1 / numero2;

        System.out.println("\nDIVISIÓN ENTERA");
        System.out.println(
                numero1 + " / " + numero2 + " = " + divisionEntera
        );

        /*
         * ==================================================
         * DIVISIÓN DECIMAL
         * ==================================================
         *
         * Para conservar la parte decimal, al menos uno de
         * los valores debe convertirse a double.
         */

        double divisionDecimal = (double) numero1 / numero2;

        System.out.println("\nDIVISIÓN DECIMAL");
        System.out.println(
                numero1 + " / " + numero2 + " = " + divisionDecimal
        );

        /*
         * ==================================================
         * MÓDULO O RESIDUO
         * ==================================================
         *
         * El operador % devuelve el residuo de una división.
         *
         * 20 dividido entre 6 es 3 y sobran 2.
         */

        int residuo = numero1 % numero2;

        System.out.println("\nMÓDULO");
        System.out.println(
                numero1 + " % " + numero2 + " = " + residuo
        );

        /*
         * El módulo es útil para determinar si un número
         * es par o impar.
         */

        int numeroEvaluado = 8;
        int residuoParidad = numeroEvaluado % 2;

        System.out.println("\nEJEMPLO DE PARIDAD");
        System.out.println(
                numeroEvaluado + " % 2 = " + residuoParidad
        );

        System.out.println(
                "Si el residuo es 0, el número es par."
        );

        /*
         * ==================================================
         * INCREMENTO
         * ==================================================
         *
         * El operador ++ aumenta el valor en una unidad.
         */

        int contador = 5;

        System.out.println("\nINCREMENTO");
        System.out.println("Valor inicial: " + contador);

        contador++;

        System.out.println(
                "Después de contador++: " + contador
        );

        /*
         * ==================================================
         * DECREMENTO
         * ==================================================
         *
         * El operador -- disminuye el valor en una unidad.
         */

        contador--;

        System.out.println("\nDECREMENTO");
        System.out.println(
                "Después de contador--: " + contador
        );

        /*
         * ==================================================
         * EJEMPLO INTEGRADO
         * ==================================================
         *
         * Calcularemos el valor total de una compra.
         */

        double precioProducto = 12500.0;
        int cantidadProductos = 4;

        double valorCompra =
                precioProducto * cantidadProductos;

        System.out.println("\nEJEMPLO DE COMPRA");
        System.out.println("--------------------------------");

        System.out.println(
                "Precio unitario: $" + precioProducto
        );

        System.out.println(
                "Cantidad: " + cantidadProductos
        );

        System.out.println(
                "Valor total: $" + valorCompra
        );
    }
}