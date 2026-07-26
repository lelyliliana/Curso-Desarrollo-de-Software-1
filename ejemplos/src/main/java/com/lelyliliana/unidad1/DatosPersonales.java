package com.lelyliliana.unidad1;

/*
 * EJEMPLO 2 - UNIDAD 1
 *
 * Tema:
 * Impresión de información en consola.
 *
 * En este ejemplo se trabaja:
 * - System.out.print()
 * - System.out.println()
 * - Concatenación con el operador +
 * - Secuencias de escape
 */

public class DatosPersonales {

    public static void main(String[] args) {

        /*
         * println imprime el texto y luego realiza
         * un salto de línea.
         */
        System.out.println("DATOS PERSONALES");
        System.out.println("-------------------------");

        /*
         * print imprime el texto, pero no realiza
         * un salto de línea al finalizar.
         */
        System.out.print("Nombre: ");
        System.out.println("Laura Martínez");

        System.out.print("Edad: ");
        System.out.println(25);

        System.out.print("Ciudad: ");
        System.out.println("Sahagún");

        /*
         * Concatenación:
         *
         * El operador + permite unir textos con valores.
         */
        String programa = "Ingeniería de Sistemas";
        int semestre = 2;

        System.out.println(
                "Programa académico: " + programa
        );

        System.out.println(
                "Semestre actual: " + semestre
        );

        /*
         * Secuencia de escape \n
         *
         * Produce un salto de línea.
         */
        System.out.println(
                "\nINFORMACIÓN DE CONTACTO"
        );

        /*
         * Secuencia de escape \t
         *
         * Produce una tabulación.
         */
        System.out.println(
                "Correo:\tlaura@email.com"
        );

        System.out.println(
                "Teléfono:\t3001234567"
        );

        /*
         * Secuencia de escape \"
         *
         * Permite mostrar comillas dobles dentro
         * de un texto.
         */
        System.out.println(
                "Frase favorita: \"Nunca dejes de aprender\""
        );

        /*
         * Secuencia de escape \\
         *
         * Permite mostrar una barra invertida.
         */
        System.out.println(
                "Ruta del archivo: C:\\Documentos\\Java"
        );

        /*
         * También podemos imprimir varios datos
         * en una sola línea.
         */
        System.out.println(
                "\nResumen: "
                        + "Laura tiene "
                        + 25
                        + " años y estudia "
                        + programa
                        + "."
        );

        System.out.println("-------------------------");
        System.out.println("Fin del programa.");
    }
}