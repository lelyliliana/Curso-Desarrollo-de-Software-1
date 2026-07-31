package com.lelyliliana.unidad3;

/*
 * EJEMPLO 9 - UNIDAD 3
 *
 * Tema:
 * Búsqueda de información dentro de cadenas.
 *
 * Métodos utilizados:
 *
 * contains()   -> verifica si una cadena contiene un texto.
 * indexOf()    -> obtiene la primera posición de un texto.
 * lastIndexOf()-> obtiene la última posición de un texto.
 * startsWith() -> verifica cómo comienza una cadena.
 * endsWith()   -> verifica cómo termina una cadena.
 */

import java.util.Scanner;

public class U3_09_BusquedaEnCadenas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("BÚSQUEDA EN CADENAS");
        System.out.println("----------------------------------------");

        /*
         * Cadena utilizada en los primeros ejemplos.
         */
        String frase =
                "Java permite desarrollar aplicaciones "
                        + "de escritorio, web y móviles con Java.";

        System.out.println("Frase analizada:");
        System.out.println(frase);

        /*
         * ==================================================
         * MÉTODO CONTAINS()
         * ==================================================
         *
         * contains() devuelve true cuando el texto buscado
         * se encuentra dentro de la cadena.
         *
         * Distingue entre mayúsculas y minúsculas.
         */

        boolean contieneJava =
                frase.contains("Java");

        boolean contienePython =
                frase.contains("Python");

        System.out.println("\nMÉTODO contains()");
        System.out.println("----------------------------------------");

        System.out.println(
                "¿La frase contiene \"Java\"?: "
                        + contieneJava
        );

        System.out.println(
                "¿La frase contiene \"Python\"?: "
                        + contienePython
        );

        /*
         * "Java" y "java" se consideran textos diferentes.
         */
        System.out.println(
                "¿La frase contiene \"java\"?: "
                        + frase.contains("java")
        );

        /*
         * ==================================================
         * MÉTODO INDEXOF()
         * ==================================================
         *
         * indexOf() devuelve la posición donde aparece
         * por primera vez un carácter o una cadena.
         *
         * Las posiciones comienzan en cero.
         *
         * Si el texto no existe, devuelve -1.
         */

        int primeraPosicionJava =
                frase.indexOf("Java");

        int posicionWeb =
                frase.indexOf("web");

        int posicionPython =
                frase.indexOf("Python");

        System.out.println("\nMÉTODO indexOf()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Primera posición de \"Java\": "
                        + primeraPosicionJava
        );

        System.out.println(
                "Posición de \"web\": "
                        + posicionWeb
        );

        System.out.println(
                "Posición de \"Python\": "
                        + posicionPython
        );

        /*
         * Validamos el resultado antes de utilizarlo.
         */

        if (posicionPython == -1) {

            System.out.println(
                    "La palabra Python no fue encontrada."
            );
        }

        /*
         * ==================================================
         * MÉTODO LASTINDEXOF()
         * ==================================================
         *
         * lastIndexOf() devuelve la posición de la última
         * aparición del texto buscado.
         */

        int ultimaPosicionJava =
                frase.lastIndexOf("Java");

        System.out.println("\nMÉTODO lastIndexOf()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Primera posición de \"Java\": "
                        + primeraPosicionJava
        );

        System.out.println(
                "Última posición de \"Java\": "
                        + ultimaPosicionJava
        );

        /*
         * ==================================================
         * MÉTODO STARTSWITH()
         * ==================================================
         *
         * startsWith() verifica si la cadena comienza
         * con un texto específico.
         */

        boolean comienzaConJava =
                frase.startsWith("Java");

        boolean comienzaConAplicaciones =
                frase.startsWith("Aplicaciones");

        System.out.println("\nMÉTODO startsWith()");
        System.out.println("----------------------------------------");

        System.out.println(
                "¿La frase comienza con \"Java\"?: "
                        + comienzaConJava
        );

        System.out.println(
                "¿La frase comienza con \"Aplicaciones\"?: "
                        + comienzaConAplicaciones
        );

        /*
         * ==================================================
         * MÉTODO ENDSWITH()
         * ==================================================
         *
         * endsWith() verifica si la cadena termina
         * con un texto específico.
         */

        boolean terminaConJava =
                frase.endsWith("Java.");

        boolean terminaConMoviles =
                frase.endsWith("móviles.");

        System.out.println("\nMÉTODO endsWith()");
        System.out.println("----------------------------------------");

        System.out.println(
                "¿La frase termina con \"Java.\"?: "
                        + terminaConJava
        );

        System.out.println(
                "¿La frase termina con \"móviles.\"?: "
                        + terminaConMoviles
        );

        /*
         * ==================================================
         * EJEMPLO CON CORREO ELECTRÓNICO
         * ==================================================
         */

        System.out.println("\nVALIDACIÓN DE CORREO");
        System.out.println("----------------------------------------");

        System.out.print(
                "Ingrese un correo electrónico: "
        );

        String correo =
                teclado.nextLine().trim();

        boolean contieneArroba =
                correo.contains("@");

        boolean terminaEnCom =
                correo.endsWith(".com");

        boolean comienzaCorrectamente =
                !correo.startsWith("@");

        boolean tieneTextoDespuesArroba =
                correo.indexOf("@")
                        < correo.length() - 1;

        System.out.println(
                "¿Contiene @?: " + contieneArroba
        );

        System.out.println(
                "¿Termina en .com?: " + terminaEnCom
        );

        /*
         * Esta es una validación básica y educativa.
         * No reemplaza una validación completa de correo.
         */
        boolean correoBasicoValido =
                contieneArroba
                        && terminaEnCom
                        && comienzaCorrectamente
                        && tieneTextoDespuesArroba;

        if (correoBasicoValido) {

            System.out.println(
                    "El correo cumple la validación básica."
            );

        } else {

            System.out.println(
                    "El correo no cumple la validación básica."
            );
        }

        /*
         * ==================================================
         * BÚSQUEDA INGRESADA POR EL USUARIO
         * ==================================================
         */

        System.out.println("\nBÚSQUEDA PERSONALIZADA");
        System.out.println("----------------------------------------");

        System.out.print(
                "Ingrese un texto para buscar en la frase: "
        );

        String textoBuscado =
                teclado.nextLine().trim();

        /*
         * Convertimos ambos textos a minúsculas para realizar
         * una búsqueda que no diferencie mayúsculas.
         */
        String fraseMinusculas =
                frase.toLowerCase();

        String busquedaMinusculas =
                textoBuscado.toLowerCase();

        int posicionEncontrada =
                fraseMinusculas.indexOf(busquedaMinusculas);

        if (posicionEncontrada != -1) {

            System.out.println(
                    "El texto fue encontrado en la posición: "
                            + posicionEncontrada
            );

        } else {

            System.out.println(
                    "El texto no fue encontrado."
            );
        }

        teclado.close();
    }
}