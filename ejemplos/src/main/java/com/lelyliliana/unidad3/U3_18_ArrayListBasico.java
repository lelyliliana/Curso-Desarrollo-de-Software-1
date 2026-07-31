package com.lelyliliana.unidad3;

/*
 * EJEMPLO 18 - UNIDAD 3
 *
 * Tema:
 * Uso básico de ArrayList.
 *
 * ArrayList es una colección dinámica.
 *
 * A diferencia de un arreglo tradicional:
 *
 * - Puede aumentar o disminuir su tamaño.
 * - Permite agregar y eliminar elementos.
 * - Incluye métodos para consultar y modificar datos.
 *
 * Métodos utilizados:
 *
 * add()      -> agrega elementos.
 * get()      -> consulta un elemento.
 * set()      -> modifica un elemento.
 * remove()   -> elimina un elemento.
 * size()     -> obtiene la cantidad de elementos.
 * contains() -> verifica si existe un elemento.
 * isEmpty()  -> verifica si la lista está vacía.
 * clear()    -> elimina todos los elementos.
 */

import java.util.ArrayList;

public class U3_18_ArrayListBasico {

    public static void main(String[] args) {

        System.out.println("USO BÁSICO DE ARRAYLIST");
        System.out.println("----------------------------------------");

        /*
         * ==================================================
         * CREACIÓN DEL ARRAYLIST
         * ==================================================
         *
         * Se declara el tipo de dato que almacenará.
         *
         * En este caso almacenará objetos String.
         */
        ArrayList<String> lenguajes =
                new ArrayList<>();

        System.out.println(
                "Lista recién creada: " + lenguajes
        );

        System.out.println(
                "¿La lista está vacía?: "
                        + lenguajes.isEmpty()
        );

        /*
         * ==================================================
         * MÉTODO ADD()
         * ==================================================
         *
         * add() agrega elementos al final de la lista.
         */
        lenguajes.add("Java");
        lenguajes.add("Python");
        lenguajes.add("JavaScript");
        lenguajes.add("C#");

        System.out.println("\nDESPUÉS DE AGREGAR ELEMENTOS");
        System.out.println("----------------------------------------");

        System.out.println(
                "Lista completa: " + lenguajes
        );

        System.out.println(
                "Cantidad de elementos: "
                        + lenguajes.size()
        );

        /*
         * También se puede agregar un elemento
         * en una posición específica.
         *
         * Los índices comienzan en cero.
         */
        lenguajes.add(1, "Kotlin");

        System.out.println(
                "Después de agregar Kotlin en la posición 1: "
                        + lenguajes
        );

        /*
         * ==================================================
         * MÉTODO GET()
         * ==================================================
         *
         * get(indice) permite consultar un elemento.
         */
        String primerLenguaje =
                lenguajes.get(0);

        String tercerLenguaje =
                lenguajes.get(2);

        System.out.println("\nCONSULTA DE ELEMENTOS");
        System.out.println("----------------------------------------");

        System.out.println(
                "Elemento en la posición 0: "
                        + primerLenguaje
        );

        System.out.println(
                "Elemento en la posición 2: "
                        + tercerLenguaje
        );

        /*
         * ==================================================
         * MÉTODO SET()
         * ==================================================
         *
         * set(indice, nuevoValor) reemplaza un elemento.
         */
        String elementoAnterior =
                lenguajes.set(3, "TypeScript");

        System.out.println("\nMODIFICACIÓN DE ELEMENTOS");
        System.out.println("----------------------------------------");

        System.out.println(
                "Elemento reemplazado: "
                        + elementoAnterior
        );

        System.out.println(
                "Lista modificada: "
                        + lenguajes
        );

        /*
         * ==================================================
         * MÉTODO CONTAINS()
         * ==================================================
         *
         * contains() verifica si un valor existe.
         */
        boolean contieneJava =
                lenguajes.contains("Java");

        boolean contienePHP =
                lenguajes.contains("PHP");

        System.out.println("\nBÚSQUEDA DE ELEMENTOS");
        System.out.println("----------------------------------------");

        System.out.println(
                "¿La lista contiene Java?: "
                        + contieneJava
        );

        System.out.println(
                "¿La lista contiene PHP?: "
                        + contienePHP
        );

        /*
         * ==================================================
         * MÉTODO REMOVE()
         * ==================================================
         *
         * remove() puede eliminar:
         *
         * - Un elemento por índice.
         * - Un elemento por contenido.
         */

        /*
         * Eliminación por índice.
         *
         * Devuelve el elemento eliminado.
         */
        String eliminadoPorIndice =
                lenguajes.remove(1);

        System.out.println("\nELIMINACIÓN POR ÍNDICE");
        System.out.println("----------------------------------------");

        System.out.println(
                "Elemento eliminado: "
                        + eliminadoPorIndice
        );

        System.out.println(
                "Lista actual: "
                        + lenguajes
        );

        /*
         * Eliminación por contenido.
         *
         * Devuelve true si encontró y eliminó el elemento.
         */
        boolean elementoEliminado =
                lenguajes.remove("C#");

        System.out.println("\nELIMINACIÓN POR CONTENIDO");
        System.out.println("----------------------------------------");

        System.out.println(
                "¿Se eliminó C#?: "
                        + elementoEliminado
        );

        System.out.println(
                "Lista actual: "
                        + lenguajes
        );

        /*
         * ==================================================
         * RECORRIDO CON FOR
         * ==================================================
         */
        System.out.println("\nRECORRIDO CON ÍNDICES");
        System.out.println("----------------------------------------");

        for (int i = 0; i < lenguajes.size(); i++) {

            System.out.println(
                    "Posición "
                            + i
                            + ": "
                            + lenguajes.get(i)
            );
        }

        /*
         * ==================================================
         * RECORRIDO CON FOR-EACH
         * ==================================================
         */
        System.out.println("\nRECORRIDO CON FOR-EACH");
        System.out.println("----------------------------------------");

        for (String lenguaje : lenguajes) {

            System.out.println(lenguaje);
        }

        /*
         * ==================================================
         * VALIDACIÓN DE ÍNDICE
         * ==================================================
         *
         * Antes de utilizar get(), set() o remove(),
         * conviene verificar que el índice exista.
         */
        int posicionConsultada = 10;

        if (
                posicionConsultada >= 0
                        && posicionConsultada < lenguajes.size()
        ) {

            System.out.println(
                    lenguajes.get(posicionConsultada)
            );

        } else {

            System.out.println(
                    "\nLa posición "
                            + posicionConsultada
                            + " no existe en la lista."
            );
        }

        /*
         * ==================================================
         * MÉTODO CLEAR()
         * ==================================================
         *
         * clear() elimina todos los elementos.
         */
        System.out.println("\nLIMPIEZA DE LA LISTA");
        System.out.println("----------------------------------------");

        System.out.println(
                "Lista antes de clear(): "
                        + lenguajes
        );

        lenguajes.clear();

        System.out.println(
                "Lista después de clear(): "
                        + lenguajes
        );

        System.out.println(
                "Cantidad de elementos: "
                        + lenguajes.size()
        );

        System.out.println(
                "¿La lista está vacía?: "
                        + lenguajes.isEmpty()
        );
    }
}