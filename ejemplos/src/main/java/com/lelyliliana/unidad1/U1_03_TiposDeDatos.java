package com.lelyliliana.unidad1;

/*
 * EJEMPLO 3 - UNIDAD 1
 *
 * Tema:
 * Tipos de datos en Java.
 *
 * En este programa se utilizan:
 *
 * Tipos enteros:
 * - byte
 * - short
 * - int
 * - long
 *
 * Tipos decimales:
 * - float
 * - double
 *
 * Otros tipos:
 * - char
 * - boolean
 * - String
 */

public class U1_03_TiposDeDatos {

    public static void main(String[] args) {

        /*
         * ==================================================
         * TIPO BYTE
         * ==================================================
         *
         * Almacena números enteros pequeños.
         *
         * Su rango aproximado es:
         * -128 hasta 127.
         */
        byte edad = 25;

        /*
         * ==================================================
         * TIPO SHORT
         * ==================================================
         *
         * Almacena números enteros más grandes que byte,
         * pero más pequeños que int.
         */
        short cantidadEstudiantes = 1200;

        /*
         * ==================================================
         * TIPO INT
         * ==================================================
         *
         * Es el tipo más utilizado para almacenar
         * números enteros.
         */
        int poblacionMunicipio = 110000;

        /*
         * ==================================================
         * TIPO LONG
         * ==================================================
         *
         * Se utiliza para almacenar números enteros
         * muy grandes.
         *
         * La letra L al final indica que el número
         * debe tratarse como un valor de tipo long.
         */
        long poblacionMundial = 8_100_000_000L;

        /*
         * Los guiones bajos pueden usarse para facilitar
         * la lectura de números grandes.
         *
         * No afectan el valor almacenado.
         */

        /*
         * ==================================================
         * TIPO FLOAT
         * ==================================================
         *
         * Almacena números decimales con precisión simple.
         *
         * La letra f al final es obligatoria para indicar
         * que el valor es de tipo float.
         */
        float estatura = 1.65f;

        /*
         * ==================================================
         * TIPO DOUBLE
         * ==================================================
         *
         * Almacena números decimales con mayor precisión.
         *
         * Es el tipo decimal más utilizado en Java.
         */
        double promedio = 4.75;

        /*
         * ==================================================
         * TIPO CHAR
         * ==================================================
         *
         * Almacena un único carácter.
         *
         * El valor debe escribirse entre comillas simples.
         */
        char grupo = 'A';

        /*
         * ==================================================
         * TIPO BOOLEAN
         * ==================================================
         *
         * Solo puede almacenar uno de estos dos valores:
         *
         * true  = verdadero
         * false = falso
         */
        boolean estudianteActivo = true;

        /*
         * ==================================================
         * TIPO STRING
         * ==================================================
         *
         * Almacena cadenas de texto.
         *
         * String no es un tipo primitivo: es una clase.
         * Los textos se escriben entre comillas dobles.
         */
        String nombreCompleto = "Laura Martínez";
        String programaAcademico = "Ingeniería de Sistemas";

        /*
         * ==================================================
         * IMPRESIÓN DE LOS DATOS
         * ==================================================
         */

        System.out.println("TIPOS DE DATOS EN JAVA");
        System.out.println("--------------------------------");

        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Programa: " + programaAcademico);
        System.out.println("Grupo: " + grupo);

        System.out.println(
                "Cantidad de estudiantes: "
                        + cantidadEstudiantes
        );

        System.out.println(
                "Población del municipio: "
                        + poblacionMunicipio
        );

        System.out.println(
                "Población mundial aproximada: "
                        + poblacionMundial
        );

        System.out.println(
                "Estatura: "
                        + estatura
                        + " metros"
        );

        System.out.println(
                "Promedio académico: "
                        + promedio
        );

        System.out.println(
                "¿El estudiante está activo?: "
                        + estudianteActivo
        );

        /*
         * También podemos utilizar los datos
         * dentro de una operación.
         */

        int edadProximoAnio = edad + 1;

        System.out.println("--------------------------------");

        System.out.println(
                nombreCompleto
                        + " tendrá "
                        + edadProximoAnio
                        + " años el próximo año."
        );
    }
}