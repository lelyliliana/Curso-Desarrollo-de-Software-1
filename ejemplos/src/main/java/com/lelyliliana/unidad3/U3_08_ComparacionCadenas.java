package com.lelyliliana.unidad3;

/*
 * EJEMPLO 8 - UNIDAD 3
 *
 * Tema:
 * Comparación de cadenas en Java.
 *
 * En este programa se explica la diferencia entre:
 *
 * ==                  -> compara referencias.
 * equals()            -> compara contenido.
 * equalsIgnoreCase()  -> compara contenido sin distinguir
 *                        entre mayúsculas y minúsculas.
 */

import java.util.Scanner;

public class U3_08_ComparacionCadenas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("COMPARACIÓN DE CADENAS");
        System.out.println("----------------------------------------");

        /*
         * ==================================================
         * EJEMPLO 1: OPERADOR ==
         * ==================================================
         *
         * El operador == compara si dos variables apuntan
         * al mismo objeto en memoria.
         */

        String texto1 = "Java";
        String texto2 = "Java";

        boolean resultadoIgualIgual =
                texto1 == texto2;

        System.out.println("EJEMPLO CON ==");
        System.out.println("----------------------------------------");

        System.out.println("texto1: " + texto1);
        System.out.println("texto2: " + texto2);

        System.out.println(
                "texto1 == texto2: "
                        + resultadoIgualIgual
        );

        /*
         * En este caso puede aparecer true porque Java
         * reutiliza algunas cadenas literales en memoria.
         *
         * Sin embargo, no se recomienda utilizar == para
         * comparar el contenido de textos.
         */

        /*
         * ==================================================
         * EJEMPLO 2: OBJETOS STRING DIFERENTES
         * ==================================================
         */

        String texto3 = new String("Java");
        String texto4 = new String("Java");

        System.out.println("\nOBJETOS STRING DIFERENTES");
        System.out.println("----------------------------------------");

        System.out.println(
                "texto3 == texto4: "
                        + (texto3 == texto4)
        );

        /*
         * Aunque ambos contienen la palabra Java,
         * son objetos diferentes.
         *
         * Por eso == produce false.
         */

        /*
         * ==================================================
         * MÉTODO EQUALS()
         * ==================================================
         *
         * equals() compara el contenido de las cadenas.
         */

        boolean mismoContenido =
                texto3.equals(texto4);

        System.out.println(
                "texto3.equals(texto4): "
                        + mismoContenido
        );

        /*
         * ==================================================
         * DIFERENCIA ENTRE MAYÚSCULAS Y MINÚSCULAS
         * ==================================================
         */

        String lenguaje1 = "Java";
        String lenguaje2 = "JAVA";

        System.out.println("\nCOMPARACIÓN DE MAYÚSCULAS");
        System.out.println("----------------------------------------");

        System.out.println(
                "lenguaje1.equals(lenguaje2): "
                        + lenguaje1.equals(lenguaje2)
        );

        /*
         * equals() distingue entre mayúsculas
         * y minúsculas.
         *
         * "Java" y "JAVA" no son iguales para equals().
         */

        /*
         * ==================================================
         * MÉTODO EQUALSIGNORECASE()
         * ==================================================
         *
         * Compara el contenido sin distinguir
         * entre mayúsculas y minúsculas.
         */

        boolean igualesSinMayusculas =
                lenguaje1.equalsIgnoreCase(lenguaje2);

        System.out.println(
                "lenguaje1.equalsIgnoreCase(lenguaje2): "
                        + igualesSinMayusculas
        );

        /*
         * ==================================================
         * EJEMPLO CON DATOS INGRESADOS
         * ==================================================
         */

        System.out.println("\nVALIDACIÓN DE RESPUESTA");
        System.out.println("----------------------------------------");

        System.out.print(
                "Escriba la palabra continuar: "
        );

        String respuesta = teclado.nextLine();

        /*
         * trim() elimina espacios al inicio y al final.
         *
         * equalsIgnoreCase() permite aceptar:
         *
         * continuar
         * CONTINUAR
         * Continuar
         */
        if (
                respuesta
                        .trim()
                        .equalsIgnoreCase("continuar")
        ) {

            System.out.println(
                    "Respuesta correcta. El programa continúa."
            );

        } else {

            System.out.println(
                    "Respuesta incorrecta."
            );
        }

        /*
         * ==================================================
         * EJEMPLO DE INICIO DE SESIÓN
         * ==================================================
         */

        final String USUARIO_CORRECTO = "docente";
        final String CLAVE_CORRECTA = "Java2026";

        System.out.println("\nINICIO DE SESIÓN");
        System.out.println("----------------------------------------");

        System.out.print("Ingrese el usuario: ");
        String usuarioIngresado = teclado.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String claveIngresada = teclado.nextLine();

        /*
         * Para el usuario se permite ignorar mayúsculas.
         *
         * Para la contraseña sí se distinguen mayúsculas
         * y minúsculas.
         */
        boolean usuarioCorrecto =
                usuarioIngresado
                        .trim()
                        .equalsIgnoreCase(USUARIO_CORRECTO);

        boolean claveCorrecta =
                claveIngresada.equals(CLAVE_CORRECTA);

        if (usuarioCorrecto && claveCorrecta) {

            System.out.println(
                    "Acceso concedido."
            );

        } else {

            System.out.println(
                    "Usuario o contraseña incorrectos."
            );
        }

        /*
         * ==================================================
         * RESUMEN
         * ==================================================
         */

        System.out.println("\nRESUMEN");
        System.out.println("----------------------------------------");

        System.out.println(
                "== compara referencias."
        );

        System.out.println(
                "equals() compara contenido."
        );

        System.out.println(
                "equalsIgnoreCase() compara contenido "
                        + "sin distinguir mayúsculas."
        );

        teclado.close();
    }
}