package com.lelyliliana.unidad1;

/*
 * EJEMPLO 4 - UNIDAD 1
 *
 * Tema:
 * Constantes, convenciones de nombres y palabras reservadas.
 *
 * En este ejemplo se trabaja:
 *
 * - Declaración de variables.
 * - Declaración de constantes con final.
 * - Convención camelCase.
 * - Convención UPPER_SNAKE_CASE.
 * - Palabras reservadas de Java.
 */

public class U1_04_ConstantesYPalabrasReservadas {

    public static void main(String[] args) {

        /*
         * ==================================================
         * VARIABLES
         * ==================================================
         *
         * Una variable almacena un valor que puede cambiar
         * durante la ejecución del programa.
         *
         * En Java se recomienda utilizar camelCase para
         * nombrar variables.
         *
         * En camelCase:
         * - La primera palabra comienza en minúscula.
         * - Las siguientes palabras comienzan en mayúscula.
         */

        String nombreEstudiante = "Laura Martínez";
        int edadEstudiante = 20;
        double promedioAcademico = 4.3;
        boolean estudianteActivo = true;

        System.out.println("DATOS INICIALES");
        System.out.println("------------------------------");
        System.out.println("Nombre: " + nombreEstudiante);
        System.out.println("Edad: " + edadEstudiante);
        System.out.println("Promedio: " + promedioAcademico);
        System.out.println("Activo: " + estudianteActivo);

        /*
         * Como edadEstudiante es una variable,
         * su valor puede cambiar.
         */

        edadEstudiante = 21;

        System.out.println("\nEdad actualizada: " + edadEstudiante);

        /*
         * ==================================================
         * CONSTANTES
         * ==================================================
         *
         * Una constante almacena un valor que no puede
         * modificarse después de su asignación.
         *
         * Para declarar una constante se utiliza final.
         *
         * Por convención, sus nombres se escriben:
         *
         * - Completamente en mayúsculas.
         * - Separando las palabras con guion bajo.
         *
         * Esta convención se conoce como UPPER_SNAKE_CASE.
         */

        final double NOTA_MAXIMA = 5.0;
        final double NOTA_MINIMA_APROBACION = 3.0;
        final int EDAD_MINIMA_INGRESO = 16;
        final String NOMBRE_INSTITUCION = "Uniremington";

        System.out.println("\nCONSTANTES DEL PROGRAMA");
        System.out.println("------------------------------");

        System.out.println(
                "Institución: " + NOMBRE_INSTITUCION
        );

        System.out.println(
                "Nota máxima: " + NOTA_MAXIMA
        );

        System.out.println(
                "Nota mínima de aprobación: "
                        + NOTA_MINIMA_APROBACION
        );

        System.out.println(
                "Edad mínima de ingreso: "
                        + EDAD_MINIMA_INGRESO
        );

        /*
         * No se puede modificar una constante.
         *
         * La siguiente instrucción produciría un error:
         *
         * NOTA_MAXIMA = 4.0;
         *
         * El error ocurre porque NOTA_MAXIMA fue declarada
         * utilizando la palabra reservada final.
         */

        /*
         * ==================================================
         * USO DE LAS CONSTANTES
         * ==================================================
         */

        boolean aproboAsignatura =
                promedioAcademico >= NOTA_MINIMA_APROBACION;

        boolean cumpleEdad =
                edadEstudiante >= EDAD_MINIMA_INGRESO;

        System.out.println("\nVALIDACIÓN DEL ESTUDIANTE");
        System.out.println("------------------------------");

        System.out.println(
                "¿Aprobó la asignatura?: "
                        + aproboAsignatura
        );

        System.out.println(
                "¿Cumple la edad mínima?: "
                        + cumpleEdad
        );

        /*
         * ==================================================
         * CONVENCIONES PARA NOMBRAR ELEMENTOS
         * ==================================================
         *
         * Las convenciones no son reglas obligatorias del
         * compilador, pero facilitan la lectura del código.
         *
         * Variables y métodos:
         * camelCase
         *
         * Ejemplos:
         * nombreCompleto
         * calcularPromedio
         *
         * Clases:
         * PascalCase
         *
         * Ejemplos:
         * DatosPersonales
         * ConstantesYPalabrasReservadas
         *
         * Constantes:
         * UPPER_SNAKE_CASE
         *
         * Ejemplos:
         * NOTA_MAXIMA
         * EDAD_MINIMA_INGRESO
         */

        /*
         * ==================================================
         * PALABRAS RESERVADAS
         * ==================================================
         *
         * Las palabras reservadas tienen un significado
         * especial dentro del lenguaje Java.
         *
         * No pueden utilizarse como nombres de:
         *
         * - Variables.
         * - Métodos.
         * - Clases.
         *
         * Algunas palabras reservadas utilizadas en este
         * programa son:
         *
         * public  -> define el nivel de acceso.
         * class   -> permite declarar una clase.
         * static  -> indica que un elemento pertenece
         *            directamente a la clase.
         * void    -> indica que un método no retorna valor.
         * int     -> declara un número entero.
         * double  -> declara un número decimal.
         * boolean -> declara un valor verdadero o falso.
         * final   -> permite declarar una constante.
         *
         * También existen otras como:
         *
         * if, else, for, while, switch, case, break,
         * return, new, private, protected, abstract
         * y extends.
         */

        /*
         * Estos ejemplos producirían error porque intentan
         * utilizar palabras reservadas como variables:
         *
         * int class = 10;
         * double public = 4.5;
         * String final = "Texto";
         *
         * Se dejan comentados para que el programa compile.
         */

        System.out.println("\nPALABRAS RESERVADAS");
        System.out.println("------------------------------");

        System.out.println(
                "Las palabras reservadas tienen un "
                        + "significado especial en Java."
        );

        System.out.println(
                "No pueden utilizarse como nombres "
                        + "de variables, métodos o clases."
        );
    }
}