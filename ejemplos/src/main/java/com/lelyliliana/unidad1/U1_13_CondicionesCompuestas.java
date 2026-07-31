package com.lelyliliana.unidad1;

/*
 * EJEMPLO 13 - UNIDAD 1
 *
 * Tema:
 * Condiciones compuestas con operadores lógicos.
 *
 * Operadores utilizados:
 *
 * &&  AND: todas las condiciones deben ser verdaderas.
 * ||  OR: al menos una condición debe ser verdadera.
 * !   NOT: invierte el resultado de una condición.
 *
 * También se utilizan operadores relacionales como:
 *
 * >=  Mayor o igual que.
 * <=  Menor o igual que.
 * ==  Igual que.
 */

import java.util.Scanner;

public class U1_13_CondicionesCompuestas {

    public static void main(String[] args) {

        // Creamos el objeto Scanner.
        Scanner teclado = new Scanner(System.in);

        System.out.println("VALIDACIÓN DE ACCESO A UNA EVALUACIÓN");
        System.out.println("----------------------------------------");

        /*
         * Solicitamos la información del estudiante.
         */

        System.out.print("Ingrese la edad del estudiante: ");
        int edad = teclado.nextInt();

        System.out.print("Ingrese el porcentaje de asistencia: ");
        double asistencia = teclado.nextDouble();

        System.out.print("Ingrese el promedio académico: ");
        double promedio = teclado.nextDouble();

        System.out.print(
                "¿El estudiante está matriculado? "
                        + "(true/false): "
        );
        boolean estaMatriculado = teclado.nextBoolean();

        System.out.print(
                "¿El estudiante está bloqueado? "
                        + "(true/false): "
        );
        boolean estaBloqueado = teclado.nextBoolean();

        /*
         * ==================================================
         * CONDICIONES INDIVIDUALES
         * ==================================================
         *
         * Primero evaluamos cada condición por separado.
         */

        boolean esMayorDeEdad = edad >= 18;
        boolean cumpleAsistencia = asistencia >= 70.0;
        boolean cumplePromedio = promedio >= 3.0;
        boolean noEstaBloqueado = !estaBloqueado;

        System.out.println("\nRESULTADO DE CADA CONDICIÓN");
        System.out.println("----------------------------------------");

        System.out.println(
                "¿Es mayor de edad?: " + esMayorDeEdad
        );

        System.out.println(
                "¿Cumple con el 70 % de asistencia?: "
                        + cumpleAsistencia
        );

        System.out.println(
                "¿Tiene promedio mínimo de 3.0?: "
                        + cumplePromedio
        );

        System.out.println(
                "¿Está matriculado?: " + estaMatriculado
        );

        System.out.println(
                "¿No está bloqueado?: " + noEstaBloqueado
        );

        /*
         * ==================================================
         * OPERADOR AND &&
         * ==================================================
         *
         * Para presentar la evaluación, todas las
         * condiciones deben ser verdaderas.
         */

        boolean puedePresentarEvaluacion =
                esMayorDeEdad
                        && cumpleAsistencia
                        && cumplePromedio
                        && estaMatriculado
                        && noEstaBloqueado;

        System.out.println("\nVALIDACIÓN CON AND &&");
        System.out.println("----------------------------------------");

        if (puedePresentarEvaluacion) {

            System.out.println(
                    "El estudiante puede presentar "
                            + "la evaluación."
            );

        } else {

            System.out.println(
                    "El estudiante no puede presentar "
                            + "la evaluación."
            );
        }

        /*
         * ==================================================
         * OPERADOR OR ||
         * ==================================================
         *
         * El estudiante recibe un beneficio si tiene
         * un promedio de 4.5 o superior, o si su
         * asistencia es igual o superior al 95 %.
         *
         * Basta con cumplir una de las dos condiciones.
         */

        boolean tienePromedioExcelente = promedio >= 4.5;
        boolean tieneAsistenciaExcelente = asistencia >= 95.0;

        boolean recibeReconocimiento =
                tienePromedioExcelente
                        || tieneAsistenciaExcelente;

        System.out.println("\nVALIDACIÓN CON OR ||");
        System.out.println("----------------------------------------");

        System.out.println(
                "¿Tiene promedio excelente?: "
                        + tienePromedioExcelente
        );

        System.out.println(
                "¿Tiene asistencia excelente?: "
                        + tieneAsistenciaExcelente
        );

        if (recibeReconocimiento) {

            System.out.println(
                    "El estudiante recibe un reconocimiento."
            );

        } else {

            System.out.println(
                    "El estudiante no cumple las condiciones "
                            + "para recibir el reconocimiento."
            );
        }

        /*
         * ==================================================
         * OPERADOR NOT !
         * ==================================================
         *
         * El operador ! invierte un valor booleano.
         *
         * Si estaBloqueado es false:
         *
         * !estaBloqueado será true.
         */

        System.out.println("\nVALIDACIÓN CON NOT !");
        System.out.println("----------------------------------------");

        if (!estaBloqueado) {

            System.out.println(
                    "La cuenta del estudiante está habilitada."
            );

        } else {

            System.out.println(
                    "La cuenta del estudiante está bloqueada."
            );
        }

        /*
         * ==================================================
         * CONDICIÓN COMPUESTA CON PARÉNTESIS
         * ==================================================
         *
         * Un estudiante puede participar en una actividad
         * especial cuando:
         *
         * - Está matriculado.
         * - No está bloqueado.
         * - Además, cumple una de estas dos opciones:
         *
         *   a) Tiene promedio de 4.0 o superior.
         *   b) Tiene asistencia de 90 % o superior.
         *
         * Los paréntesis agrupan las dos alternativas
         * relacionadas mediante OR.
         */

        boolean puedeParticiparActividad =
                estaMatriculado
                        && !estaBloqueado
                        && (
                                promedio >= 4.0
                                        || asistencia >= 90.0
                        );

        System.out.println("\nCONDICIÓN COMPUESTA");
        System.out.println("----------------------------------------");

        if (puedeParticiparActividad) {

            System.out.println(
                    "El estudiante puede participar "
                            + "en la actividad especial."
            );

        } else {

            System.out.println(
                    "El estudiante no cumple todos los "
                            + "requisitos de participación."
            );
        }

        /*
         * ==================================================
         * VALIDACIÓN DE UN RANGO
         * ==================================================
         *
         * Para comprobar que una nota está entre 0 y 5,
         * se necesitan dos condiciones:
         *
         * nota >= 0
         * nota <= 5
         *
         * Las dos deben cumplirse al mismo tiempo.
         */

        System.out.print(
                "\nIngrese una nota para validar su rango: "
        );

        double nota = teclado.nextDouble();

        boolean notaValida =
                nota >= 0.0 && nota <= 5.0;

        if (notaValida) {

            System.out.println(
                    "La nota está dentro del rango permitido."
            );

        } else {

            System.out.println(
                    "La nota está fuera del rango permitido."
            );
        }

        // Cerramos Scanner.
        teclado.close();
    }
}