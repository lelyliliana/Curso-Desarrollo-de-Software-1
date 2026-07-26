package com.lelyliliana.unidad3;

/*
 * EJEMPLO 22 - UNIDAD 3
 *
 * Tema:
 * Conversión de texto a enum mediante valueOf()
 * y evaluación con switch.
 *
 * Conceptos incluidos:
 *
 * - Declaración de un enum.
 * - Método values().
 * - Método valueOf().
 * - Conversión de texto a mayúsculas.
 * - Estructura switch con valores enum.
 * - Manejo de IllegalArgumentException.
 */

import java.util.Scanner;

public class EnumConSwitch {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("ENUM CON VALUEOF Y SWITCH");
        System.out.println("========================================");

        /*
         * ==================================================
         * MOSTRAR LAS OPCIONES DISPONIBLES
         * ==================================================
         *
         * values() devuelve todos los valores definidos
         * dentro del enum.
         */

        System.out.println("TIPOS DE USUARIO DISPONIBLES");
        System.out.println("----------------------------------------");

        for (TipoUsuario tipo : TipoUsuario.values()) {

            System.out.println(
                    "- " + tipo
            );
        }

        /*
         * ==================================================
         * CAPTURA DEL TEXTO
         * ==================================================
         */

        System.out.print(
                "\nIngrese el tipo de usuario: "
        );

        String textoIngresado =
                teclado.nextLine();

        /*
         * trim() elimina espacios externos.
         *
         * toUpperCase() convierte el texto al mismo formato
         * utilizado por las constantes del enum.
         *
         * Ejemplos aceptados:
         *
         * administrador
         * ADMINISTRADOR
         * Administrador
         */

        String textoNormalizado =
                textoIngresado
                        .trim()
                        .toUpperCase();

        try {

            /*
             * ==================================================
             * MÉTODO VALUEOF()
             * ==================================================
             *
             * valueOf() convierte una cadena en un valor enum.
             *
             * El texto debe coincidir exactamente con
             * una de las constantes declaradas.
             */

            TipoUsuario tipoSeleccionado =
                    TipoUsuario.valueOf(
                            textoNormalizado
                    );

            System.out.println(
                    "\nTipo seleccionado: "
                            + tipoSeleccionado
            );

            /*
             * Evaluamos el valor mediante switch.
             */

            mostrarPermisos(tipoSeleccionado);

        } catch (IllegalArgumentException e) {

            /*
             * valueOf() genera IllegalArgumentException
             * cuando el texto no coincide con ningún
             * valor del enum.
             */

            System.out.println(
                    "\nError: el tipo de usuario no existe."
            );

            System.out.println(
                    "Opciones válidas: "
                            + obtenerOpcionesUsuario()
            );
        }

        /*
         * ==================================================
         * SEGUNDO EJEMPLO: ESTADO DE UNA SOLICITUD
         * ==================================================
         */

        System.out.println("\nESTADO DE UNA SOLICITUD");
        System.out.println("----------------------------------------");

        System.out.println(
                "Estados disponibles:"
        );

        for (
                EstadoSolicitud estado
                : EstadoSolicitud.values()
        ) {

            System.out.println(
                    "- " + estado
            );
        }

        System.out.print(
                "\nIngrese el estado: "
        );

        String estadoIngresado =
                teclado.nextLine()
                        .trim()
                        .toUpperCase();

        try {

            EstadoSolicitud estado =
                    EstadoSolicitud.valueOf(
                            estadoIngresado
                    );

            /*
             * Switch moderno con flechas.
             *
             * No necesita break.
             */

            switch (estado) {

                case RECIBIDA -> System.out.println(
                        "La solicitud fue recibida "
                                + "y está pendiente de revisión."
                );

                case EN_REVISION -> System.out.println(
                        "La solicitud está siendo evaluada."
                );

                case APROBADA -> System.out.println(
                        "La solicitud fue aprobada."
                );

                case RECHAZADA -> System.out.println(
                        "La solicitud fue rechazada."
                );

                case FINALIZADA -> System.out.println(
                        "El proceso de la solicitud finalizó."
                );
            }

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: el estado ingresado no es válido."
            );
        }

        /*
         * ==================================================
         * TERCER EJEMPLO: MENÚ MEDIANTE ENUM
         * ==================================================
         */

        System.out.println("\nMENÚ DE OPERACIONES");
        System.out.println("----------------------------------------");

        for (Operacion operacion : Operacion.values()) {

            System.out.println(
                    "- " + operacion
            );
        }

        System.out.print(
                "\nSeleccione una operación: "
        );

        String operacionIngresada =
                teclado.nextLine()
                        .trim()
                        .toUpperCase();

        try {

            Operacion operacion =
                    Operacion.valueOf(
                            operacionIngresada
                    );

            ejecutarOperacion(
                    operacion,
                    teclado
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: la operación no está disponible."
            );
        }

        System.out.println(
                "\nEl programa ha finalizado."
        );

        teclado.close();
    }

    /*
     * ==================================================
     * MÉTODO CON SWITCH TRADICIONAL
     * ==================================================
     */

    public static void mostrarPermisos(
            TipoUsuario tipoUsuario
    ) {

        System.out.println("\nPERMISOS DEL USUARIO");
        System.out.println("----------------------------------------");

        switch (tipoUsuario) {

            case ADMINISTRADOR:

                System.out.println(
                        "Puede crear, consultar, modificar "
                                + "y eliminar registros."
                );

                break;

            case DOCENTE:

                System.out.println(
                        "Puede gestionar cursos, actividades "
                                + "y calificaciones."
                );

                break;

            case ESTUDIANTE:

                System.out.println(
                        "Puede consultar contenidos, "
                                + "entregar actividades "
                                + "y revisar calificaciones."
                );

                break;

            case INVITADO:

                System.out.println(
                        "Solo puede consultar información pública."
                );

                break;

            default:

                /*
                 * En este caso no es estrictamente necesario,
                 * porque se evaluaron todos los valores del enum.
                 */
                System.out.println(
                        "Tipo de usuario sin permisos definidos."
                );
        }
    }

    /*
     * Genera un texto con las opciones del enum.
     */

    public static String obtenerOpcionesUsuario() {

        StringBuilder opciones =
                new StringBuilder();

        TipoUsuario[] tipos =
                TipoUsuario.values();

        for (int i = 0; i < tipos.length; i++) {

            opciones.append(
                    tipos[i]
            );

            if (i < tipos.length - 1) {

                opciones.append(", ");
            }
        }

        return opciones.toString();
    }

    /*
     * ==================================================
     * MÉTODO PARA EJECUTAR OPERACIONES
     * ==================================================
     */

    public static void ejecutarOperacion(
            Operacion operacion,
            Scanner teclado
    ) {

        if (operacion == Operacion.SALIR) {

            System.out.println(
                    "No se realizará ninguna operación."
            );

            return;
        }

        System.out.print(
                "Ingrese el primer número: "
        );

        double numero1 =
                teclado.nextDouble();

        System.out.print(
                "Ingrese el segundo número: "
        );

        double numero2 =
                teclado.nextDouble();

        /*
         * Consumimos el salto de línea pendiente.
         */
        teclado.nextLine();

        switch (operacion) {

            case SUMAR -> {

                double resultado =
                        numero1 + numero2;

                System.out.println(
                        "Resultado de la suma: "
                                + resultado
                );
            }

            case RESTAR -> {

                double resultado =
                        numero1 - numero2;

                System.out.println(
                        "Resultado de la resta: "
                                + resultado
                );
            }

            case MULTIPLICAR -> {

                double resultado =
                        numero1 * numero2;

                System.out.println(
                        "Resultado de la multiplicación: "
                                + resultado
                );
            }

            case DIVIDIR -> {

                if (numero2 != 0) {

                    double resultado =
                            numero1 / numero2;

                    System.out.println(
                            "Resultado de la división: "
                                    + resultado
                    );

                } else {

                    System.out.println(
                            "Error: no se puede dividir entre cero."
                    );
                }
            }

            case SALIR -> System.out.println(
                    "Saliendo..."
            );
        }
    }
}

/*
 * Enum para representar tipos de usuario.
 */

enum TipoUsuario {

    ADMINISTRADOR,
    DOCENTE,
    ESTUDIANTE,
    INVITADO
}

/*
 * Enum para representar estados.
 *
 * EN_REVISION usa guion bajo porque las constantes
 * no pueden contener espacios.
 */

enum EstadoSolicitud {

    RECIBIDA,
    EN_REVISION,
    APROBADA,
    RECHAZADA,
    FINALIZADA
}

/*
 * Enum para el menú de operaciones.
 */

enum Operacion {

    SUMAR,
    RESTAR,
    MULTIPLICAR,
    DIVIDIR,
    SALIR
}