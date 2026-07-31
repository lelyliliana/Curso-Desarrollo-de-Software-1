package com.lelyliliana.unidad1;

/*
 * EJEMPLO 8 - UNIDAD 1
 *
 * Tema:
 * Entrada de datos desde la consola con Scanner.
 *
 * En este programa se capturan:
 *
 * - Textos con nextLine().
 * - Números enteros con nextInt().
 * - Números decimales con nextDouble().
 */

// Importamos Scanner desde el paquete java.util.
import java.util.Scanner;

public class U1_08_EntradaDatosScanner {

    public static void main(String[] args) {

        /*
         * Creamos un objeto de la clase Scanner.
         *
         * System.in representa la entrada de datos
         * desde el teclado.
         */
        Scanner teclado = new Scanner(System.in);

        System.out.println("REGISTRO DE ESTUDIANTE");
        System.out.println("--------------------------------");

        /*
         * ==================================================
         * CAPTURA DE TEXTO
         * ==================================================
         *
         * nextLine() permite leer una línea completa.
         *
         * Puede capturar textos que contengan espacios,
         * por ejemplo: "Laura Martínez".
         */

        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto = teclado.nextLine();

        System.out.print("Ingrese su programa académico: ");
        String programaAcademico = teclado.nextLine();

        /*
         * ==================================================
         * CAPTURA DE NÚMEROS ENTEROS
         * ==================================================
         *
         * nextInt() permite capturar valores de tipo int.
         */

        System.out.print("Ingrese su edad: ");
        int edad = teclado.nextInt();

        System.out.print("Ingrese el semestre que cursa: ");
        int semestre = teclado.nextInt();

        /*
         * ==================================================
         * CAPTURA DE NÚMEROS DECIMALES
         * ==================================================
         *
         * nextDouble() permite capturar valores decimales.
         *
         * Dependiendo de la configuración regional del
         * computador, puede ser necesario escribir el
         * decimal con coma o con punto.
         */

        System.out.print("Ingrese su promedio académico: ");
        double promedioAcademico = teclado.nextDouble();

        /*
         * ==================================================
         * PROBLEMA DEL SALTO DE LÍNEA PENDIENTE
         * ==================================================
         *
         * nextInt() y nextDouble() leen el número, pero dejan
         * pendiente el salto de línea producido al presionar
         * la tecla Enter.
         *
         * Antes de volver a usar nextLine(), debemos consumir
         * ese salto de línea con otro nextLine().
         */

        teclado.nextLine();

        System.out.print("Ingrese su ciudad de residencia: ");
        String ciudad = teclado.nextLine();

        System.out.print("Ingrese una frase que lo represente: ");
        String frasePersonal = teclado.nextLine();

        /*
         * ==================================================
         * PRESENTACIÓN DE LOS DATOS
         * ==================================================
         */

        System.out.println("\nINFORMACIÓN REGISTRADA");
        System.out.println("--------------------------------");

        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Programa: " + programaAcademico);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Semestre: " + semestre);
        System.out.println("Promedio: " + promedioAcademico);
        System.out.println("Ciudad: " + ciudad);

        System.out.println(
                "Frase personal: \"" + frasePersonal + "\""
        );

        /*
         * Ejemplo de una operación utilizando los datos
         * ingresados por el usuario.
         */

        int edadProximoAnio = edad + 1;

        System.out.println(
                nombreCompleto
                        + " tendrá "
                        + edadProximoAnio
                        + " años el próximo año."
        );

        /*
         * Cerramos Scanner cuando ya no necesitamos
         * capturar más información.
         */
        teclado.close();
    }
}