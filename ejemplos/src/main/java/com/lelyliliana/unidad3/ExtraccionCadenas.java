package com.lelyliliana.unidad3;

/*
 * EJEMPLO 10 - UNIDAD 3
 *
 * Tema:
 * Extracción, reemplazo y división de cadenas.
 *
 * Métodos utilizados:
 *
 * substring() -> extrae una parte de una cadena.
 * replace()   -> reemplaza caracteres o fragmentos de texto.
 * split()     -> divide una cadena en varias partes.
 */

import java.util.Scanner;

public class ExtraccionCadenas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("EXTRACCIÓN Y MODIFICACIÓN DE CADENAS");
        System.out.println("----------------------------------------");

        /*
         * Cadena base para los primeros ejemplos.
         */
        String texto = "Desarrollo de Software en Java";

        System.out.println("Texto original:");
        System.out.println(texto);

        /*
         * ==================================================
         * MÉTODO SUBSTRING()
         * ==================================================
         *
         * substring(inicio) extrae desde la posición indicada
         * hasta el final de la cadena.
         *
         * Las posiciones comienzan en cero.
         */

        String desdePosicion11 = texto.substring(11);

        System.out.println("\nMÉTODO substring(inicio)");
        System.out.println("----------------------------------------");

        System.out.println(
                "Texto desde la posición 11: "
                        + desdePosicion11
        );

        /*
         * substring(inicio, fin) extrae desde la posición
         * inicial hasta una posición anterior al valor final.
         *
         * La posición final no se incluye.
         */

        String primeraPalabra = texto.substring(0, 10);

        System.out.println("\nMÉTODO substring(inicio, fin)");
        System.out.println("----------------------------------------");

        System.out.println(
                "Texto entre las posiciones 0 y 10: "
                        + primeraPalabra
        );

        /*
         * En este caso se extraen las posiciones:
         *
         * 0, 1, 2, 3, 4, 5, 6, 7, 8 y 9.
         *
         * La posición 10 no se incluye.
         */

        /*
         * ==================================================
         * EXTRAER LA ÚLTIMA PALABRA
         * ==================================================
         *
         * Buscamos la posición del último espacio.
         */

        int posicionUltimoEspacio =
                texto.lastIndexOf(" ");

        /*
         * Sumamos 1 para comenzar después del espacio.
         */

        String ultimaPalabra =
                texto.substring(posicionUltimoEspacio + 1);

        System.out.println("\nEXTRACCIÓN DE LA ÚLTIMA PALABRA");
        System.out.println("----------------------------------------");

        System.out.println(
                "Posición del último espacio: "
                        + posicionUltimoEspacio
        );

        System.out.println(
                "Última palabra: " + ultimaPalabra
        );

        /*
         * ==================================================
         * MÉTODO REPLACE()
         * ==================================================
         *
         * replace() reemplaza todas las apariciones
         * del texto indicado.
         */

        String textoModificado =
                texto.replace("Java", "Python");

        System.out.println("\nMÉTODO replace()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Texto original: " + texto
        );

        System.out.println(
                "Texto modificado: " + textoModificado
        );

        /*
         * También puede reemplazar caracteres.
         */

        String textoConGuiones =
                texto.replace(' ', '-');

        System.out.println(
                "Espacios reemplazados por guiones: "
                        + textoConGuiones
        );

        /*
         * String es inmutable.
         *
         * replace() no modifica directamente la cadena
         * original, sino que genera una nueva.
         */

        System.out.println(
                "La cadena original sigue siendo: "
                        + texto
        );

        /*
         * ==================================================
         * MÉTODO SPLIT()
         * ==================================================
         *
         * split() divide una cadena utilizando un separador.
         *
         * El resultado se almacena en un arreglo de String.
         */

        String nombres =
                "Laura,Carlos,María,Andrés";

        String[] listaNombres =
                nombres.split(",");

        System.out.println("\nMÉTODO split()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Cadena original: " + nombres
        );

        System.out.println(
                "Cantidad de nombres: "
                        + listaNombres.length
        );

        /*
         * Recorremos el arreglo para mostrar cada nombre.
         */

        for (int i = 0; i < listaNombres.length; i++) {

            System.out.println(
                    "Nombre "
                            + (i + 1)
                            + ": "
                            + listaNombres[i]
            );
        }

        /*
         * ==================================================
         * SPLIT CON ESPACIOS
         * ==================================================
         */

        String frase =
                "Java permite crear aplicaciones";

        String[] palabras =
                frase.split(" ");

        System.out.println("\nDIVISIÓN POR ESPACIOS");
        System.out.println("----------------------------------------");

        for (String palabra : palabras) {

            System.out.println(palabra);
        }

        /*
         * ==================================================
         * EJEMPLO CON DATOS INGRESADOS
         * ==================================================
         */

        System.out.println("\nPROCESAMIENTO DE NOMBRE COMPLETO");
        System.out.println("----------------------------------------");

        System.out.print(
                "Ingrese su nombre completo: "
        );

        String nombreCompleto =
                teclado.nextLine().trim();

        /*
         * Dividimos el nombre usando uno o más espacios.
         *
         * La expresión "\\s+" significa:
         *
         * uno o más caracteres de espacio.
         */

        String[] partesNombre =
                nombreCompleto.split("\\s+");

        System.out.println(
                "Cantidad de palabras en el nombre: "
                        + partesNombre.length
        );

        if (partesNombre.length > 0) {

            System.out.println(
                    "Primer nombre o palabra: "
                            + partesNombre[0]
            );

            System.out.println(
                    "Última palabra del nombre: "
                            + partesNombre[
                                    partesNombre.length - 1
                            ]
            );
        }

        /*
         * ==================================================
         * EJEMPLO CON CORREO ELECTRÓNICO
         * ==================================================
         */

        System.out.println("\nEXTRACCIÓN DE DATOS DEL CORREO");
        System.out.println("----------------------------------------");

        System.out.print(
                "Ingrese un correo electrónico: "
        );

        String correo =
                teclado.nextLine().trim();

        int posicionArroba =
                correo.indexOf("@");

        /*
         * Validamos que exista el símbolo @ y que no esté
         * en la primera ni en la última posición.
         */

        if (
                posicionArroba > 0
                        && posicionArroba
                        < correo.length() - 1
        ) {

            String usuarioCorreo =
                    correo.substring(0, posicionArroba);

            String dominioCorreo =
                    correo.substring(posicionArroba + 1);

            System.out.println(
                    "Usuario: " + usuarioCorreo
            );

            System.out.println(
                    "Dominio: " + dominioCorreo
            );

        } else {

            System.out.println(
                    "El correo no tiene una estructura válida."
            );
        }

        /*
         * ==================================================
         * EJEMPLO CON FECHA
         * ==================================================
         */

        String fecha = "26/07/2026";

        String[] partesFecha =
                fecha.split("/");

        System.out.println("\nDIVISIÓN DE UNA FECHA");
        System.out.println("----------------------------------------");

        if (partesFecha.length == 3) {

            System.out.println(
                    "Día: " + partesFecha[0]
            );

            System.out.println(
                    "Mes: " + partesFecha[1]
            );

            System.out.println(
                    "Año: " + partesFecha[2]
            );
        }

        teclado.close();
    }
}