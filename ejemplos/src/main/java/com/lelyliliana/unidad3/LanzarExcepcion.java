package com.lelyliliana.unidad3;

/*
 * EJEMPLO 5 - UNIDAD 3
 *
 * Tema:
 * Lanzamiento intencional de excepciones con throw.
 *
 * La palabra reservada throw permite generar
 * una excepción de forma manual.
 *
 * Esto es útil cuando el programa detecta una situación
 * que considera inválida, aunque Java no produzca
 * automáticamente una excepción.
 *
 * Ejemplo:
 *
 * Una edad negativa es un valor incorrecto, pero Java
 * permite almacenarla en una variable int.
 *
 * Por eso podemos detectar esa situación y lanzar
 * una excepción de manera intencional.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class LanzarExcepcion {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("LANZAMIENTO DE EXCEPCIONES CON THROW");
        System.out.println("----------------------------------------");

        /*
         * ==================================================
         * EJEMPLO 1: VALIDACIÓN DE EDAD
         * ==================================================
         */

        try {

            System.out.print("Ingrese la edad de la persona: ");
            int edad = teclado.nextInt();

            /*
             * Java no genera automáticamente una excepción
             * cuando la edad es negativa.
             *
             * Nosotros detectamos el valor inválido y
             * lanzamos una IllegalArgumentException.
             */
            if (edad < 0) {

                throw new IllegalArgumentException(
                        "La edad no puede ser negativa."
                );
            }

            /*
             * También podemos generar una excepción cuando
             * el valor supera un límite razonable.
             */
            if (edad > 120) {

                throw new IllegalArgumentException(
                        "La edad ingresada no es válida."
                );
            }

            System.out.println(
                    "Edad registrada correctamente: "
                            + edad
                            + " años."
            );

        } catch (InputMismatchException e) {

            /*
             * Este bloque controla el caso en que el usuario
             * escribe letras o un número decimal.
             */
            System.out.println(
                    "Error: debe ingresar un número entero."
            );

            teclado.nextLine();

        } catch (IllegalArgumentException e) {

            /*
             * Este bloque captura las excepciones que fueron
             * lanzadas manualmente mediante throw.
             */
            System.out.println(
                    "Error de validación: " + e.getMessage()
            );
        }

        /*
         * ==================================================
         * EJEMPLO 2: VALIDACIÓN DE NOTA
         * ==================================================
         */

        try {

            System.out.print(
                    "\nIngrese una nota entre 0.0 y 5.0: "
            );

            double nota = teclado.nextDouble();

            /*
             * Si la nota está fuera del rango permitido,
             * lanzamos una excepción.
             */
            if (nota < 0.0 || nota > 5.0) {

                throw new IllegalArgumentException(
                        "La nota debe estar entre 0.0 y 5.0."
                );
            }

            String resultado =
                    nota >= 3.0
                            ? "Aprobado"
                            : "Reprobado";

            System.out.println(
                    "Nota registrada: " + nota
            );

            System.out.println(
                    "Resultado: " + resultado
            );

        } catch (InputMismatchException e) {

            System.out.println(
                    "Error: debe ingresar un valor numérico."
            );

            teclado.nextLine();

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error de validación: " + e.getMessage()
            );
        }

        /*
         * ==================================================
         * EJEMPLO 3: MÉTODO QUE LANZA UNA EXCEPCIÓN
         * ==================================================
         */

        try {

            System.out.print(
                    "\nIngrese el valor de una compra: $"
            );

            double valorCompra = teclado.nextDouble();

            /*
             * Llamamos un método que valida el valor.
             *
             * El método puede lanzar una excepción si
             * recibe un dato incorrecto.
             */
            validarValorCompra(valorCompra);

            System.out.println(
                    "Valor registrado correctamente: $"
                            + valorCompra
            );

        } catch (InputMismatchException e) {

            System.out.println(
                    "Error: debe ingresar un valor numérico."
            );

            teclado.nextLine();

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error de validación: " + e.getMessage()
            );
        }

        System.out.println(
                "\nEl programa ha finalizado."
        );

        teclado.close();
    }

    /*
     * Método que valida el valor de una compra.
     *
     * Si el valor es igual o menor que cero,
     * genera una excepción intencional.
     */
    public static void validarValorCompra(double valorCompra) {

        if (valorCompra <= 0) {

            throw new IllegalArgumentException(
                    "El valor de la compra debe ser mayor que cero."
            );
        }
    }
}