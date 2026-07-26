package com.lelyliliana.unidad3;

/*
 * EJEMPLO 7 - UNIDAD 3
 *
 * Tema:
 * Métodos básicos de la clase String.
 *
 * En este programa se utilizan:
 *
 * length()      -> obtiene la cantidad de caracteres.
 * charAt()      -> obtiene un carácter según su posición.
 * toUpperCase() -> convierte el texto a mayúsculas.
 * toLowerCase() -> convierte el texto a minúsculas.
 * trim()        -> elimina espacios al inicio y al final.
 *
 * String representa cadenas de texto.
 */

import java.util.Scanner;

public class MetodosString {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("MÉTODOS BÁSICOS DE STRING");
        System.out.println("----------------------------------------");

        /*
         * Solicitamos una frase.
         *
         * Se recomienda escribir espacios al inicio
         * o al final para observar el funcionamiento
         * del método trim().
         */
        System.out.print("Ingrese una frase: ");
        String textoOriginal = teclado.nextLine();

        /*
         * ==================================================
         * MÉTODO LENGTH()
         * ==================================================
         *
         * length() retorna la cantidad total de caracteres.
         *
         * Los espacios también cuentan como caracteres.
         */
        int longitudOriginal = textoOriginal.length();

        System.out.println("\nMÉTODO length()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Texto original: [" + textoOriginal + "]"
        );

        System.out.println(
                "Cantidad de caracteres: " + longitudOriginal
        );

        /*
         * ==================================================
         * MÉTODO TRIM()
         * ==================================================
         *
         * trim() elimina los espacios ubicados al inicio
         * y al final de la cadena.
         *
         * No elimina los espacios que están entre palabras.
         */
        String textoSinEspaciosExternos =
                textoOriginal.trim();

        System.out.println("\nMÉTODO trim()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Antes de trim(): [" + textoOriginal + "]"
        );

        System.out.println(
                "Después de trim(): ["
                        + textoSinEspaciosExternos
                        + "]"
        );

        System.out.println(
                "Longitud antes de trim(): "
                        + textoOriginal.length()
        );

        System.out.println(
                "Longitud después de trim(): "
                        + textoSinEspaciosExternos.length()
        );

        /*
         * ==================================================
         * MÉTODO TOUPPERCASE()
         * ==================================================
         *
         * Convierte todas las letras a mayúsculas.
         */
        String textoMayusculas =
                textoSinEspaciosExternos.toUpperCase();

        System.out.println("\nMÉTODO toUpperCase()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Texto en mayúsculas: " + textoMayusculas
        );

        /*
         * ==================================================
         * MÉTODO TOLOWERCASE()
         * ==================================================
         *
         * Convierte todas las letras a minúsculas.
         */
        String textoMinusculas =
                textoSinEspaciosExternos.toLowerCase();

        System.out.println("\nMÉTODO toLowerCase()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Texto en minúsculas: " + textoMinusculas
        );

        /*
         * ==================================================
         * MÉTODO CHARAT()
         * ==================================================
         *
         * charAt(posicion) permite obtener un carácter.
         *
         * Las posiciones comienzan en cero.
         *
         * Ejemplo:
         *
         * JAVA
         *
         * J -> posición 0
         * A -> posición 1
         * V -> posición 2
         * A -> posición 3
         */
        System.out.println("\nMÉTODO charAt()");
        System.out.println("----------------------------------------");

        /*
         * Antes de usar charAt(), verificamos que la cadena
         * no esté vacía.
         */
        if (!textoSinEspaciosExternos.isEmpty()) {

            char primerCaracter =
                    textoSinEspaciosExternos.charAt(0);

            int ultimaPosicion =
                    textoSinEspaciosExternos.length() - 1;

            char ultimoCaracter =
                    textoSinEspaciosExternos.charAt(
                            ultimaPosicion
                    );

            System.out.println(
                    "Primer carácter: " + primerCaracter
            );

            System.out.println(
                    "Última posición: " + ultimaPosicion
            );

            System.out.println(
                    "Último carácter: " + ultimoCaracter
            );

        } else {

            System.out.println(
                    "No se pueden consultar caracteres "
                            + "porque el texto está vacío."
            );
        }

        /*
         * ==================================================
         * CONSULTA DE UNA POSICIÓN INGRESADA
         * ==================================================
         */

        if (!textoSinEspaciosExternos.isEmpty()) {

            System.out.print(
                    "\nIngrese una posición entre 0 y "
                            + (textoSinEspaciosExternos.length() - 1)
                            + ": "
            );

            int posicion = teclado.nextInt();

            /*
             * Validamos que la posición exista.
             */
            if (
                    posicion >= 0
                            && posicion
                            < textoSinEspaciosExternos.length()
            ) {

                char caracterSeleccionado =
                        textoSinEspaciosExternos.charAt(posicion);

                System.out.println(
                        "El carácter ubicado en la posición "
                                + posicion
                                + " es: "
                                + caracterSeleccionado
                );

            } else {

                System.out.println(
                        "Error: la posición está fuera del rango."
                );
            }
        }

        /*
         * ==================================================
         * COMBINACIÓN DE MÉTODOS
         * ==================================================
         *
         * Los métodos pueden encadenarse.
         *
         * Primero se aplica trim() y después toUpperCase().
         */
        String textoProcesado =
                textoOriginal
                        .trim()
                        .toUpperCase();

        System.out.println("\nMÉTODOS ENCADENADOS");
        System.out.println("----------------------------------------");

        System.out.println(
                "Resultado de trim().toUpperCase(): "
                        + textoProcesado
        );

        /*
         * Los objetos String son inmutables.
         *
         * Esto significa que sus métodos no modifican
         * directamente la cadena original.
         *
         * En su lugar, generan una nueva cadena.
         */
        System.out.println("\nINMUTABILIDAD DE STRING");
        System.out.println("----------------------------------------");

        System.out.println(
                "Texto original: [" + textoOriginal + "]"
        );

        System.out.println(
                "Texto procesado: [" + textoProcesado + "]"
        );

        teclado.close();
    }
}