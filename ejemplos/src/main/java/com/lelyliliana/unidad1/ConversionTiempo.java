package com.lelyliliana.unidad1;

/*
 * EJEMPLO 9 - UNIDAD 1
 *
 * Tema:
 * Conversión de una cantidad de segundos
 * a horas, minutos y segundos.
 *
 * En este programa se utilizan:
 *
 * - Variables enteras.
 * - Scanner.
 * - División entera.
 * - Operador módulo.
 */

import java.util.Scanner;

public class ConversionTiempo {

    public static void main(String[] args) {

        /*
         * Creamos el objeto Scanner para capturar
         * información desde el teclado.
         */
        Scanner teclado = new Scanner(System.in);

        /*
         * Constantes utilizadas en la conversión.
         *
         * Una hora tiene 3600 segundos.
         * Un minuto tiene 60 segundos.
         */
        final int SEGUNDOS_POR_HORA = 3600;
        final int SEGUNDOS_POR_MINUTO = 60;

        System.out.println("CONVERSIÓN DE TIEMPO");
        System.out.println("--------------------------------");

        /*
         * Solicitamos al usuario la cantidad total
         * de segundos que desea convertir.
         */
        System.out.print("Ingrese la cantidad total de segundos: ");
        int segundosTotales = teclado.nextInt();

        /*
         * ==================================================
         * CÁLCULO DE LAS HORAS
         * ==================================================
         *
         * Se utiliza división entera.
         *
         * Ejemplo:
         *
         * 7385 / 3600 = 2
         *
         * Esto significa que hay 2 horas completas.
         */
        int horas = segundosTotales / SEGUNDOS_POR_HORA;

        /*
         * ==================================================
         * SEGUNDOS RESTANTES DESPUÉS DE CALCULAR LAS HORAS
         * ==================================================
         *
         * El operador módulo devuelve el residuo.
         *
         * Ejemplo:
         *
         * 7385 % 3600 = 185
         *
         * Después de retirar las horas completas,
         * quedan 185 segundos.
         */
        int segundosRestantes =
                segundosTotales % SEGUNDOS_POR_HORA;

        /*
         * ==================================================
         * CÁLCULO DE LOS MINUTOS
         * ==================================================
         *
         * Dividimos los segundos restantes entre 60.
         *
         * Ejemplo:
         *
         * 185 / 60 = 3
         *
         * Esto significa que hay 3 minutos completos.
         */
        int minutos =
                segundosRestantes / SEGUNDOS_POR_MINUTO;

        /*
         * ==================================================
         * CÁLCULO DE LOS SEGUNDOS FINALES
         * ==================================================
         *
         * Obtenemos el residuo de dividir entre 60.
         *
         * Ejemplo:
         *
         * 185 % 60 = 5
         */
        int segundos =
                segundosRestantes % SEGUNDOS_POR_MINUTO;

        /*
         * ==================================================
         * PRESENTACIÓN DEL RESULTADO
         * ==================================================
         */

        System.out.println("\nRESULTADO DE LA CONVERSIÓN");
        System.out.println("--------------------------------");

        System.out.println(
                "Segundos ingresados: " + segundosTotales
        );

        System.out.println(
                "Horas: " + horas
        );

        System.out.println(
                "Minutos: " + minutos
        );

        System.out.println(
                "Segundos: " + segundos
        );

        /*
         * Mostramos todo el resultado en una sola línea.
         */
        System.out.println(
                "\n" + segundosTotales
                        + " segundos equivalen a "
                        + horas + " hora(s), "
                        + minutos + " minuto(s) y "
                        + segundos + " segundo(s)."
        );

        /*
         * Cerramos Scanner al finalizar.
         */
        teclado.close();
    }
}