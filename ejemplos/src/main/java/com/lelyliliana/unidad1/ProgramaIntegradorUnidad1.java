package com.lelyliliana.unidad1;

/*
 * EJEMPLO 20 - UNIDAD 1
 *
 * PROGRAMA INTEGRADOR
 *
 * Tema:
 * Registro de estudiantes y cálculo de notas definitivas.
 *
 * Este programa permite:
 *
 * - Indicar cuántos estudiantes se registrarán.
 * - Capturar el nombre de cada estudiante.
 * - Capturar tres notas.
 * - Validar que las notas estén entre 0.0 y 5.0.
 * - Calcular la nota definitiva.
 * - Determinar si el estudiante aprobó o reprobó.
 * - Clasificar el desempeño académico.
 * - Contar estudiantes aprobados y reprobados.
 * - Calcular el promedio general del grupo.
 */

import java.util.Scanner;

public class ProgramaIntegradorUnidad1 {

    public static void main(String[] args) {

        /*
         * Creamos el objeto Scanner para capturar
         * información desde la consola.
         */
        Scanner teclado = new Scanner(System.in);

        /*
         * ==================================================
         * CONSTANTES DEL PROGRAMA
         * ==================================================
         *
         * Las constantes contienen valores que no deben
         * cambiar durante la ejecución.
         */

        final double NOTA_MINIMA = 0.0;
        final double NOTA_MAXIMA = 5.0;
        final double NOTA_APROBACION = 3.0;

        /*
         * Porcentajes de cada nota.
         *
         * La suma de los porcentajes debe ser igual a 1.0:
         *
         * 30 % + 30 % + 40 % = 100 %
         */
        final double PORCENTAJE_NOTA_1 = 0.30;
        final double PORCENTAJE_NOTA_2 = 0.30;
        final double PORCENTAJE_NOTA_3 = 0.40;

        /*
         * ==================================================
         * CONTADORES
         * ==================================================
         *
         * Registran cuántos estudiantes cumplen
         * determinadas condiciones.
         */

        int cantidadAprobados = 0;
        int cantidadReprobados = 0;

        int cantidadExcelente = 0;
        int cantidadMuyBueno = 0;
        int cantidadBueno = 0;
        int cantidadAceptable = 0;
        int cantidadBajo = 0;

        /*
         * ==================================================
         * ACUMULADOR
         * ==================================================
         *
         * Guarda la suma de todas las notas definitivas.
         *
         * Posteriormente permitirá calcular el promedio
         * general del grupo.
         */

        double sumaDefinitivas = 0.0;

        /*
         * Variables para guardar información del estudiante
         * con la nota más alta y la nota más baja.
         */

        String nombreMejorEstudiante = "";
        String nombreEstudianteMenorNota = "";

        double notaMasAlta = -1.0;
        double notaMasBaja = 6.0;

        System.out.println("SISTEMA DE REGISTRO ACADÉMICO");
        System.out.println("========================================");

        /*
         * ==================================================
         * CANTIDAD DE ESTUDIANTES
         * ==================================================
         */

        System.out.print(
                "Ingrese la cantidad de estudiantes: "
        );

        int cantidadEstudiantes = teclado.nextInt();

        /*
         * Consumimos el salto de línea pendiente
         * después de nextInt().
         */
        teclado.nextLine();

        /*
         * Validamos que la cantidad sea mayor que cero.
         */

        while (cantidadEstudiantes <= 0) {

            System.out.println(
                    "Error: la cantidad debe ser mayor que cero."
            );

            System.out.print(
                    "Ingrese nuevamente la cantidad de estudiantes: "
            );

            cantidadEstudiantes = teclado.nextInt();

            teclado.nextLine();
        }

        /*
         * ==================================================
         * CICLO PRINCIPAL
         * ==================================================
         *
         * El ciclo se repite una vez por cada estudiante.
         */

        for (
                int numeroEstudiante = 1;
                numeroEstudiante <= cantidadEstudiantes;
                numeroEstudiante++
        ) {

            System.out.println(
                    "\nESTUDIANTE "
                            + numeroEstudiante
                            + " DE "
                            + cantidadEstudiantes
            );

            System.out.println("----------------------------------------");

            /*
             * Capturamos el nombre completo.
             */

            System.out.print(
                    "Ingrese el nombre completo: "
            );

            String nombre = teclado.nextLine();

            /*
             * Validamos que el nombre no esté vacío.
             */

            while (nombre.isBlank()) {

                System.out.println(
                        "Error: el nombre no puede estar vacío."
                );

                System.out.print(
                        "Ingrese nuevamente el nombre: "
                );

                nombre = teclado.nextLine();
            }

            /*
             * ==================================================
             * CAPTURA Y VALIDACIÓN DE LA PRIMERA NOTA
             * ==================================================
             */

            System.out.print(
                    "Ingrese la primera nota: "
            );

            double nota1 = teclado.nextDouble();

            while (
                    nota1 < NOTA_MINIMA
                            || nota1 > NOTA_MAXIMA
            ) {

                System.out.println(
                        "Error: la nota debe estar entre "
                                + NOTA_MINIMA
                                + " y "
                                + NOTA_MAXIMA
                                + "."
                );

                System.out.print(
                        "Ingrese nuevamente la primera nota: "
                );

                nota1 = teclado.nextDouble();
            }

            /*
             * ==================================================
             * CAPTURA Y VALIDACIÓN DE LA SEGUNDA NOTA
             * ==================================================
             */

            System.out.print(
                    "Ingrese la segunda nota: "
            );

            double nota2 = teclado.nextDouble();

            while (
                    nota2 < NOTA_MINIMA
                            || nota2 > NOTA_MAXIMA
            ) {

                System.out.println(
                        "Error: la nota debe estar entre "
                                + NOTA_MINIMA
                                + " y "
                                + NOTA_MAXIMA
                                + "."
                );

                System.out.print(
                        "Ingrese nuevamente la segunda nota: "
                );

                nota2 = teclado.nextDouble();
            }

            /*
             * ==================================================
             * CAPTURA Y VALIDACIÓN DE LA TERCERA NOTA
             * ==================================================
             */

            System.out.print(
                    "Ingrese la tercera nota: "
            );

            double nota3 = teclado.nextDouble();

            while (
                    nota3 < NOTA_MINIMA
                            || nota3 > NOTA_MAXIMA
            ) {

                System.out.println(
                        "Error: la nota debe estar entre "
                                + NOTA_MINIMA
                                + " y "
                                + NOTA_MAXIMA
                                + "."
                );

                System.out.print(
                        "Ingrese nuevamente la tercera nota: "
                );

                nota3 = teclado.nextDouble();
            }

            /*
             * Consumimos el salto de línea pendiente
             * antes de capturar el nombre del siguiente
             * estudiante.
             */
            teclado.nextLine();

            /*
             * ==================================================
             * CÁLCULO DE LA NOTA DEFINITIVA
             * ==================================================
             *
             * Primera nota: 30 %
             * Segunda nota: 30 %
             * Tercera nota: 40 %
             */

            double definitiva =
                    nota1 * PORCENTAJE_NOTA_1
                            + nota2 * PORCENTAJE_NOTA_2
                            + nota3 * PORCENTAJE_NOTA_3;

            /*
             * Acumulamos la definitiva para calcular
             * posteriormente el promedio del grupo.
             */

            sumaDefinitivas += definitiva;

            /*
             * ==================================================
             * APROBADO O REPROBADO
             * ==================================================
             */

            String estado;

            if (definitiva >= NOTA_APROBACION) {

                estado = "APROBADO";
                cantidadAprobados++;

            } else {

                estado = "REPROBADO";
                cantidadReprobados++;
            }

            /*
             * ==================================================
             * CLASIFICACIÓN DEL DESEMPEÑO
             * ==================================================
             */

            String clasificacion;

            if (definitiva >= 4.5) {

                clasificacion = "Excelente";
                cantidadExcelente++;

            } else if (definitiva >= 4.0) {

                clasificacion = "Muy bueno";
                cantidadMuyBueno++;

            } else if (definitiva >= 3.5) {

                clasificacion = "Bueno";
                cantidadBueno++;

            } else if (definitiva >= 3.0) {

                clasificacion = "Aceptable";
                cantidadAceptable++;

            } else {

                clasificacion = "Bajo";
                cantidadBajo++;
            }

            /*
             * ==================================================
             * BÚSQUEDA DE LA NOTA MÁS ALTA
             * ==================================================
             *
             * Si la definitiva actual es mayor que la nota
             * más alta registrada, actualizamos los datos.
             */

            if (definitiva > notaMasAlta) {

                notaMasAlta = definitiva;
                nombreMejorEstudiante = nombre;
            }

            /*
             * ==================================================
             * BÚSQUEDA DE LA NOTA MÁS BAJA
             * ==================================================
             */

            if (definitiva < notaMasBaja) {

                notaMasBaja = definitiva;
                nombreEstudianteMenorNota = nombre;
            }

            /*
             * ==================================================
             * RESULTADO INDIVIDUAL
             * ==================================================
             *
             * %.2f permite mostrar el número con
             * dos posiciones decimales.
             */

            System.out.println("\nRESULTADO DEL ESTUDIANTE");
            System.out.println("----------------------------------------");

            System.out.println(
                    "Nombre: " + nombre
            );

            System.out.println(
                    "Primera nota: " + nota1
            );

            System.out.println(
                    "Segunda nota: " + nota2
            );

            System.out.println(
                    "Tercera nota: " + nota3
            );

            System.out.printf(
                    "Nota definitiva: %.2f%n",
                    definitiva
            );

            System.out.println(
                    "Estado: " + estado
            );

            System.out.println(
                    "Clasificación: " + clasificacion
            );
        }

        /*
         * ==================================================
         * RESULTADOS GENERALES
         * ==================================================
         */

        double promedioGeneral =
                sumaDefinitivas / cantidadEstudiantes;

        double porcentajeAprobados =
                (
                        (double) cantidadAprobados
                                / cantidadEstudiantes
                ) * 100;

        double porcentajeReprobados =
                (
                        (double) cantidadReprobados
                                / cantidadEstudiantes
                ) * 100;

        System.out.println("\n========================================");
        System.out.println("RESUMEN GENERAL DEL GRUPO");
        System.out.println("========================================");

        System.out.println(
                "Cantidad de estudiantes: "
                        + cantidadEstudiantes
        );

        System.out.println(
                "Estudiantes aprobados: "
                        + cantidadAprobados
        );

        System.out.println(
                "Estudiantes reprobados: "
                        + cantidadReprobados
        );

        System.out.printf(
                "Promedio general del grupo: %.2f%n",
                promedioGeneral
        );

        System.out.printf(
                "Porcentaje de aprobación: %.2f%%%n",
                porcentajeAprobados
        );

        System.out.printf(
                "Porcentaje de reprobación: %.2f%%%n",
                porcentajeReprobados
        );

        /*
         * ==================================================
         * RESUMEN POR CLASIFICACIÓN
         * ==================================================
         */

        System.out.println("\nCLASIFICACIÓN DE DESEMPEÑO");
        System.out.println("----------------------------------------");

        System.out.println(
                "Excelente: " + cantidadExcelente
        );

        System.out.println(
                "Muy bueno: " + cantidadMuyBueno
        );

        System.out.println(
                "Bueno: " + cantidadBueno
        );

        System.out.println(
                "Aceptable: " + cantidadAceptable
        );

        System.out.println(
                "Bajo: " + cantidadBajo
        );

        /*
         * ==================================================
         * MEJOR Y MENOR RESULTADO
         * ==================================================
         */

        System.out.println("\nRESULTADOS DESTACADOS");
        System.out.println("----------------------------------------");

        System.out.println(
                "Mejor estudiante: "
                        + nombreMejorEstudiante
        );

        System.out.printf(
                "Nota más alta: %.2f%n",
                notaMasAlta
        );

        System.out.println(
                "Estudiante con menor nota: "
                        + nombreEstudianteMenorNota
        );

        System.out.printf(
                "Nota más baja: %.2f%n",
                notaMasBaja
        );

        System.out.println("\nFin del programa.");

        // Cerramos Scanner.
        teclado.close();
    }
}