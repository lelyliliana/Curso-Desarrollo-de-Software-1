package com.lelyliliana.unidad1;

/*
 * EJEMPLO 14 - UNIDAD 1
 *
 * Tema:
 * Operador ternario.
 *
 * El operador ternario permite tomar una decisión
 * corta en una sola instrucción.
 *
 * Su estructura es:
 *
 * condicion ? valorSiEsVerdadero : valorSiEsFalso
 *
 * Es una alternativa breve al uso de if-else
 * cuando la decisión es sencilla.
 */

import java.util.Scanner;

public class U1_14_OperadorTernario {

    public static void main(String[] args) {

        // Creamos el objeto Scanner.
        Scanner teclado = new Scanner(System.in);

        /*
         * ==================================================
         * EJEMPLO 1: MAYOR O MENOR DE EDAD
         * ==================================================
         */

        System.out.println("OPERADOR TERNARIO");
        System.out.println("--------------------------------");

        System.out.print("Ingrese su edad: ");
        int edad = teclado.nextInt();

        /*
         * Se evalúa la condición:
         *
         * edad >= 18
         *
         * Si es verdadera, se asigna:
         * "Mayor de edad"
         *
         * Si es falsa, se asigna:
         * "Menor de edad"
         */
        String clasificacionEdad =
                edad >= 18
                        ? "Mayor de edad"
                        : "Menor de edad";

        System.out.println(
                "Clasificación: " + clasificacionEdad
        );

        /*
         * ==================================================
         * EQUIVALENCIA CON IF-ELSE
         * ==================================================
         *
         * El código anterior equivale a:
         *
         * String clasificacionEdad;
         *
         * if (edad >= 18) {
         *     clasificacionEdad = "Mayor de edad";
         * } else {
         *     clasificacionEdad = "Menor de edad";
         * }
         */

        /*
         * ==================================================
         * EJEMPLO 2: NÚMERO PAR O IMPAR
         * ==================================================
         */

        System.out.print("\nIngrese un número entero: ");
        int numero = teclado.nextInt();

        /*
         * Si el residuo de dividir entre 2 es cero,
         * el número es par.
         */
        String tipoNumero =
                numero % 2 == 0
                        ? "Par"
                        : "Impar";

        System.out.println(
                "El número " + numero + " es " + tipoNumero + "."
        );

        /*
         * ==================================================
         * EJEMPLO 3: APROBADO O REPROBADO
         * ==================================================
         */

        System.out.print(
                "\nIngrese una nota entre 0.0 y 5.0: "
        );

        double nota = teclado.nextDouble();

        String resultadoAcademico =
                nota >= 3.0
                        ? "Aprobado"
                        : "Reprobado";

        System.out.println(
                "Resultado: " + resultadoAcademico
        );

        /*
         * ==================================================
         * EJEMPLO 4: OBTENER EL NÚMERO MAYOR
         * ==================================================
         */

        System.out.print("\nIngrese el primer número: ");
        int numero1 = teclado.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int numero2 = teclado.nextInt();

        /*
         * El operador ternario también puede retornar
         * un valor numérico.
         */
        int numeroMayor =
                numero1 > numero2
                        ? numero1
                        : numero2;

        System.out.println(
                "El número mayor es: " + numeroMayor
        );

        /*
         * ==================================================
         * EJEMPLO 5: DESCUENTO EN UNA COMPRA
         * ==================================================
         *
         * Si la compra es igual o superior a $100.000,
         * se aplica un descuento del 10 %.
         *
         * De lo contrario, el descuento es cero.
         */

        System.out.print(
                "\nIngrese el valor de la compra: $"
        );

        double valorCompra = teclado.nextDouble();

        double porcentajeDescuento =
                valorCompra >= 100000
                        ? 0.10
                        : 0.0;

        double valorDescuento =
                valorCompra * porcentajeDescuento;

        double totalPagar =
                valorCompra - valorDescuento;

        System.out.println(
                "Valor de la compra: $" + valorCompra
        );

        System.out.println(
                "Descuento aplicado: $"
                        + valorDescuento
        );

        System.out.println(
                "Total por pagar: $" + totalPagar
        );

        /*
         * También podemos mostrar un mensaje utilizando
         * directamente el operador ternario.
         */

        System.out.println(
                valorDescuento > 0
                        ? "La compra recibió descuento."
                        : "La compra no recibió descuento."
        );

        /*
         * ==================================================
         * EJEMPLO 6: ESTADO BOOLEANO
         * ==================================================
         */

        System.out.print(
                "\n¿El estudiante está matriculado? "
                        + "(true/false): "
        );

        boolean estaMatriculado = teclado.nextBoolean();

        String estadoMatricula =
                estaMatriculado
                        ? "Matrícula activa"
                        : "Matrícula inactiva";

        System.out.println(
                "Estado: " + estadoMatricula
        );

        // Cerramos Scanner.
        teclado.close();
    }
}