package com.lelyliliana.unidad3;

/*
 * EJEMPLO 11 - UNIDAD 3
 *
 * Tema:
 * Validación de cadenas de texto.
 *
 * En este programa se valida:
 *
 * - Que un texto no esté vacío.
 * - Que no contenga solamente espacios.
 * - Que cumpla una longitud mínima y máxima.
 * - Que contenga determinados caracteres.
 * - Que comience o termine con un texto específico.
 *
 * Métodos utilizados:
 *
 * isEmpty()   -> verifica si la longitud es cero.
 * isBlank()   -> verifica si está vacía o solo tiene espacios.
 * trim()      -> elimina espacios al inicio y al final.
 * length()    -> obtiene la cantidad de caracteres.
 * contains()  -> verifica si contiene un texto.
 * startsWith()-> verifica cómo comienza.
 * endsWith()  -> verifica cómo termina.
 */

import java.util.Scanner;

public class U3_11_ValidacionCadenas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("VALIDACIÓN DE CADENAS");
        System.out.println("----------------------------------------");

        /*
         * ==================================================
         * EJEMPLO 1: ISEMPTY() E ISBLANK()
         * ==================================================
         */

        String textoVacio = "";
        String textoConEspacios = "   ";
        String textoConContenido = "Java";

        System.out.println("COMPARACIÓN ENTRE isEmpty() E isBlank()");
        System.out.println("----------------------------------------");

        System.out.println(
                "\"\".isEmpty(): "
                        + textoVacio.isEmpty()
        );

        System.out.println(
                "\"\".isBlank(): "
                        + textoVacio.isBlank()
        );

        System.out.println(
                "\"   \".isEmpty(): "
                        + textoConEspacios.isEmpty()
        );

        System.out.println(
                "\"   \".isBlank(): "
                        + textoConEspacios.isBlank()
        );

        System.out.println(
                "\"Java\".isBlank(): "
                        + textoConContenido.isBlank()
        );

        /*
         * isEmpty() solo devuelve true cuando la cadena
         * no contiene ningún carácter.
         *
         * Una cadena formada por espacios no está vacía
         * para isEmpty(), porque los espacios son caracteres.
         *
         * isBlank() también identifica cadenas que contienen
         * únicamente espacios.
         */

        /*
         * ==================================================
         * EJEMPLO 2: VALIDACIÓN DEL NOMBRE
         * ==================================================
         */

        System.out.println("\nVALIDACIÓN DEL NOMBRE");
        System.out.println("----------------------------------------");

        String nombre;

        do {

            System.out.print(
                    "Ingrese su nombre completo: "
            );

            nombre = teclado.nextLine().trim();

            /*
             * isBlank() comprueba que el usuario no haya
             * enviado una cadena vacía.
             */
            if (nombre.isBlank()) {

                System.out.println(
                        "Error: el nombre no puede estar vacío."
                );

            } else if (nombre.length() < 3) {

                System.out.println(
                        "Error: el nombre debe tener "
                                + "al menos 3 caracteres."
                );

            } else if (nombre.length() > 50) {

                System.out.println(
                        "Error: el nombre no puede superar "
                                + "los 50 caracteres."
                );
            }

        } while (
                nombre.isBlank()
                        || nombre.length() < 3
                        || nombre.length() > 50
        );

        System.out.println(
                "Nombre registrado correctamente: "
                        + nombre
        );

        /*
         * ==================================================
         * EJEMPLO 3: VALIDACIÓN DE USUARIO
         * ==================================================
         *
         * Requisitos:
         *
         * - Debe tener entre 5 y 15 caracteres.
         * - No puede contener espacios.
         * - Debe comenzar con una letra.
         *
         * La validación de la primera letra se realiza
         * mediante Character.isLetter().
         */

        System.out.println("\nVALIDACIÓN DEL USUARIO");
        System.out.println("----------------------------------------");

        String usuario;
        boolean usuarioValido;

        do {

            System.out.print(
                    "Ingrese un nombre de usuario: "
            );

            usuario = teclado.nextLine().trim();

            boolean longitudValida =
                    usuario.length() >= 5
                            && usuario.length() <= 15;

            boolean contieneEspacios =
                    usuario.contains(" ");

            boolean comienzaConLetra =
                    !usuario.isEmpty()
                            && Character.isLetter(
                                    usuario.charAt(0)
                            );

            usuarioValido =
                    longitudValida
                            && !contieneEspacios
                            && comienzaConLetra;

            if (!longitudValida) {

                System.out.println(
                        "Error: el usuario debe tener entre "
                                + "5 y 15 caracteres."
                );
            }

            if (contieneEspacios) {

                System.out.println(
                        "Error: el usuario no puede contener espacios."
                );
            }

            if (!comienzaConLetra) {

                System.out.println(
                        "Error: el usuario debe comenzar "
                                + "con una letra."
                );
            }

        } while (!usuarioValido);

        System.out.println(
                "Usuario válido: " + usuario
        );

        /*
         * ==================================================
         * EJEMPLO 4: VALIDACIÓN DE CONTRASEÑA
         * ==================================================
         *
         * Requisitos:
         *
         * - Mínimo 8 caracteres.
         * - Debe contener al menos una mayúscula.
         * - Debe contener al menos una minúscula.
         * - Debe contener al menos un número.
         * - No debe contener espacios.
         */

        System.out.println("\nVALIDACIÓN DE CONTRASEÑA");
        System.out.println("----------------------------------------");

        String contrasena;
        boolean contrasenaValida;

        do {

            System.out.print(
                    "Ingrese una contraseña: "
            );

            contrasena = teclado.nextLine();

            boolean longitudContrasenaValida =
                    contrasena.length() >= 8;

            boolean tieneMayuscula = false;
            boolean tieneMinuscula = false;
            boolean tieneNumero = false;
            boolean tieneEspacios = false;

            /*
             * Recorremos cada carácter de la contraseña.
             */
            for (int i = 0; i < contrasena.length(); i++) {

                char caracter = contrasena.charAt(i);

                if (Character.isUpperCase(caracter)) {
                    tieneMayuscula = true;
                }

                if (Character.isLowerCase(caracter)) {
                    tieneMinuscula = true;
                }

                if (Character.isDigit(caracter)) {
                    tieneNumero = true;
                }

                if (Character.isWhitespace(caracter)) {
                    tieneEspacios = true;
                }
            }

            contrasenaValida =
                    longitudContrasenaValida
                            && tieneMayuscula
                            && tieneMinuscula
                            && tieneNumero
                            && !tieneEspacios;

            if (!longitudContrasenaValida) {

                System.out.println(
                        "Error: la contraseña debe tener "
                                + "al menos 8 caracteres."
                );
            }

            if (!tieneMayuscula) {

                System.out.println(
                        "Error: debe contener "
                                + "al menos una mayúscula."
                );
            }

            if (!tieneMinuscula) {

                System.out.println(
                        "Error: debe contener "
                                + "al menos una minúscula."
                );
            }

            if (!tieneNumero) {

                System.out.println(
                        "Error: debe contener "
                                + "al menos un número."
                );
            }

            if (tieneEspacios) {

                System.out.println(
                        "Error: no debe contener espacios."
                );
            }

        } while (!contrasenaValida);

        System.out.println(
                "Contraseña registrada correctamente."
        );

        /*
         * ==================================================
         * EJEMPLO 5: VALIDACIÓN BÁSICA DE CORREO
         * ==================================================
         *
         * Esta es una validación sencilla para fines
         * educativos.
         *
         * No reemplaza una validación completa de correo.
         */

        System.out.println("\nVALIDACIÓN BÁSICA DE CORREO");
        System.out.println("----------------------------------------");

        String correo;
        boolean correoValido;

        do {

            System.out.print(
                    "Ingrese su correo electrónico: "
            );

            correo = teclado.nextLine().trim();

            boolean contieneArroba =
                    correo.contains("@");

            boolean contienePunto =
                    correo.contains(".");

            boolean noComienzaConArroba =
                    !correo.startsWith("@");

            boolean noTerminaConArroba =
                    !correo.endsWith("@");

            boolean noContieneEspacios =
                    !correo.contains(" ");

            int posicionArroba =
                    correo.indexOf("@");

            int ultimaPosicionArroba =
                    correo.lastIndexOf("@");

            /*
             * Si ambas posiciones son iguales, existe
             * solamente un símbolo @.
             */
            boolean tieneUnSoloArroba =
                    posicionArroba
                            == ultimaPosicionArroba;

            correoValido =
                    !correo.isBlank()
                            && contieneArroba
                            && contienePunto
                            && noComienzaConArroba
                            && noTerminaConArroba
                            && noContieneEspacios
                            && tieneUnSoloArroba;

            if (!correoValido) {

                System.out.println(
                        "Error: el correo no cumple "
                                + "la validación básica."
                );
            }

        } while (!correoValido);

        System.out.println(
                "Correo registrado correctamente: "
                        + correo
        );

        /*
         * ==================================================
         * RESUMEN DE LA INFORMACIÓN
         * ==================================================
         */

        System.out.println("\nDATOS VALIDADOS");
        System.out.println("----------------------------------------");

        System.out.println(
                "Nombre: " + nombre
        );

        System.out.println(
                "Usuario: " + usuario
        );

        System.out.println(
                "Correo: " + correo
        );

        System.out.println(
                "Contraseña: registrada y validada."
        );

        teclado.close();
    }
}