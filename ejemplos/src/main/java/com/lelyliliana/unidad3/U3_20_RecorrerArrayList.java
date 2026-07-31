package com.lelyliliana.unidad3;

/*
 * EJEMPLO 20 - UNIDAD 3
 *
 * Tema:
 * Formas de recorrer un ArrayList.
 *
 * En este programa se utilizan:
 *
 * - for con índices.
 * - for-each.
 * - Recorrido inverso.
 * - get().
 * - size().
 * - Contadores y acumuladores.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class U3_20_RecorrerArrayList {

    public static void main(String[] args) {

        System.out.println("RECORRIDO DE ARRAYLIST");
        System.out.println("========================================");

        /*
         * Creamos una lista con varios nombres.
         *
         * Arrays.asList() permite proporcionar los valores
         * iniciales al constructor de ArrayList.
         */
        ArrayList<String> estudiantes =
                new ArrayList<>(
                        Arrays.asList(
                                "Laura",
                                "Carlos",
                                "María",
                                "Andrés",
                                "Sofía"
                        )
                );

        System.out.println(
                "Lista original: " + estudiantes
        );

        /*
         * ==================================================
         * RECORRIDO CON FOR E ÍNDICES
         * ==================================================
         *
         * Es útil cuando necesitamos:
         *
         * - Conocer la posición.
         * - Consultar con get().
         * - Modificar con set().
         * - Recorrer solo una parte de la lista.
         */

        System.out.println("\n1. FOR CON ÍNDICES");
        System.out.println("----------------------------------------");

        for (int i = 0; i < estudiantes.size(); i++) {

            String estudiante =
                    estudiantes.get(i);

            System.out.println(
                    "Posición "
                            + i
                            + ": "
                            + estudiante
            );
        }

        /*
         * size() devuelve la cantidad de elementos.
         *
         * Si hay 5 elementos, los índices válidos
         * son desde 0 hasta 4.
         */

        /*
         * ==================================================
         * RECORRIDO CON FOR-EACH
         * ==================================================
         *
         * Es útil cuando solamente necesitamos consultar
         * cada elemento y no importa su posición.
         */

        System.out.println("\n2. RECORRIDO CON FOR-EACH");
        System.out.println("----------------------------------------");

        for (String estudiante : estudiantes) {

            System.out.println(
                    "Estudiante: " + estudiante
            );
        }

        /*
         * En cada repetición, la variable estudiante
         * contiene uno de los elementos de la lista.
         */

        /*
         * ==================================================
         * RECORRIDO EN ORDEN INVERSO
         * ==================================================
         *
         * Para recorrer desde el último elemento
         * hasta el primero se utiliza un for con índices.
         */

        System.out.println("\n3. RECORRIDO INVERSO");
        System.out.println("----------------------------------------");

        for (
                int i = estudiantes.size() - 1;
                i >= 0;
                i--
        ) {

            System.out.println(
                    "Posición "
                            + i
                            + ": "
                            + estudiantes.get(i)
            );
        }

        /*
         * ==================================================
         * RECORRIDO PARA MODIFICAR ELEMENTOS
         * ==================================================
         *
         * Convertiremos todos los nombres a mayúsculas.
         *
         * Necesitamos el índice para usar set().
         */

        System.out.println("\n4. MODIFICACIÓN CON ÍNDICES");
        System.out.println("----------------------------------------");

        for (int i = 0; i < estudiantes.size(); i++) {

            String nombreActual =
                    estudiantes.get(i);

            String nombreMayusculas =
                    nombreActual.toUpperCase();

            estudiantes.set(
                    i,
                    nombreMayusculas
            );
        }

        System.out.println(
                "Lista modificada: " + estudiantes
        );

        /*
         * ==================================================
         * BÚSQUEDA DURANTE EL RECORRIDO
         * ==================================================
         */

        System.out.println("\n5. BÚSQUEDA DE UN ELEMENTO");
        System.out.println("----------------------------------------");

        String nombreBuscado = "MARÍA";
        int posicionEncontrada = -1;

        for (int i = 0; i < estudiantes.size(); i++) {

            if (
                    estudiantes
                            .get(i)
                            .equalsIgnoreCase(nombreBuscado)
            ) {

                posicionEncontrada = i;

                /*
                 * break finaliza el ciclo porque
                 * ya encontramos el elemento.
                 */
                break;
            }
        }

        if (posicionEncontrada != -1) {

            System.out.println(
                    nombreBuscado
                            + " se encuentra en la posición "
                            + posicionEncontrada
            );

        } else {

            System.out.println(
                    "El estudiante no fue encontrado."
            );
        }

        /*
         * ==================================================
         * EJEMPLO CON NÚMEROS
         * ==================================================
         */

        ArrayList<Double> notas =
                new ArrayList<>(
                        Arrays.asList(
                                4.5,
                                2.8,
                                3.7,
                                4.0,
                                2.5
                        )
                );

        System.out.println("\n6. RECORRIDO DE NOTAS");
        System.out.println("----------------------------------------");

        double sumaNotas = 0.0;
        int cantidadAprobadas = 0;
        int cantidadReprobadas = 0;

        /*
         * Utilizamos for-each porque no necesitamos
         * consultar las posiciones.
         */

        for (double nota : notas) {

            System.out.println(
                    "Nota registrada: " + nota
            );

            /*
             * Acumulamos todas las notas.
             */
            sumaNotas += nota;

            /*
             * Contamos notas aprobadas y reprobadas.
             */
            if (nota >= 3.0) {

                cantidadAprobadas++;

            } else {

                cantidadReprobadas++;
            }
        }

        double promedio =
                sumaNotas / notas.size();

        System.out.println("\nRESULTADOS DE LAS NOTAS");
        System.out.println("----------------------------------------");

        System.out.println(
                "Cantidad de notas: "
                        + notas.size()
        );

        System.out.println(
                "Suma de notas: " + sumaNotas
        );

        System.out.printf(
                "Promedio: %.2f%n",
                promedio
        );

        System.out.println(
                "Aprobadas: " + cantidadAprobadas
        );

        System.out.println(
                "Reprobadas: " + cantidadReprobadas
        );

        /*
         * ==================================================
         * LISTA DE OBJETOS
         * ==================================================
         */

        ArrayList<Curso> cursos =
                new ArrayList<>();

        cursos.add(
                new Curso(
                        "Desarrollo de Software I",
                        32
                )
        );

        cursos.add(
                new Curso(
                        "Bases de Datos",
                        28
                )
        );

        cursos.add(
                new Curso(
                        "Redes",
                        25
                )
        );

        System.out.println("\n7. RECORRIDO DE OBJETOS");
        System.out.println("----------------------------------------");

        /*
         * Con for-each recibimos cada objeto Curso.
         */

        for (Curso curso : cursos) {

            System.out.println(
                    "Curso: " + curso.getNombre()
            );

            System.out.println(
                    "Cantidad de estudiantes: "
                            + curso.getCantidadEstudiantes()
            );

            System.out.println("----------------------------------------");
        }

        /*
         * ==================================================
         * RECORRIDO PARCIAL
         * ==================================================
         *
         * Mostramos solamente los primeros tres elementos.
         */

        System.out.println("\n8. RECORRIDO PARCIAL");
        System.out.println("----------------------------------------");

        int limite =
                Math.min(3, estudiantes.size());

        for (int i = 0; i < limite; i++) {

            System.out.println(
                    estudiantes.get(i)
            );
        }
    }
}

/*
 * Clase utilizada en el ejemplo de lista de objetos.
 */
class Curso {

    private String nombre;
    private int cantidadEstudiantes;

    public Curso(
            String nombre,
            int cantidadEstudiantes
    ) {

        this.nombre = nombre;
        this.cantidadEstudiantes =
                cantidadEstudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }
}