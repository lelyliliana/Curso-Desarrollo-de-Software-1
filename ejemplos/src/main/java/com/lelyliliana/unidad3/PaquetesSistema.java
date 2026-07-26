package com.lelyliliana.unidad3;

/*
 * EJEMPLO 16 - UNIDAD 3
 *
 * Tema:
 * Uso de paquetes comunes del sistema en Java.
 *
 * Un paquete permite organizar clases relacionadas.
 *
 * En este programa se utilizan:
 *
 * java.lang -> clases fundamentales del lenguaje.
 * java.util -> utilidades, colecciones y entrada de datos.
 * java.time -> manejo moderno de fechas y horas.
 */

/*
 * Importaciones del paquete java.util.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Importaciones del paquete java.time.
 */
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class PaquetesSistema {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("PAQUETES DEL SISTEMA EN JAVA");
        System.out.println("========================================");

        /*
         * Ejecutamos un ejemplo para cada paquete.
         */
        ejemploJavaLang();
        ejemploJavaUtil();
        ejemploJavaTime();

        /*
         * ==================================================
         * EJEMPLO INTEGRADO
         * ==================================================
         */

        System.out.println("\n4. EJEMPLO INTEGRADO");
        System.out.println("----------------------------------------");

        System.out.print("Ingrese su nombre: ");
        String nombre = teclado.nextLine().trim();

        System.out.print("Ingrese su año de nacimiento: ");
        int anioNacimiento = teclado.nextInt();

        /*
         * LocalDate.now() obtiene la fecha actual
         * del sistema.
         */
        LocalDate fechaActual = LocalDate.now();

        int edadAproximada =
                fechaActual.getYear() - anioNacimiento;

        /*
         * Random pertenece a java.util.
         */
        Random generador = new Random();

        int numeroRegistro =
                generador.nextInt(1000, 10000);

        /*
         * StringBuilder pertenece a java.lang.
         *
         * No necesita importación explícita.
         */
        StringBuilder resumen = new StringBuilder();

        resumen
                .append("\nREGISTRO GENERADO")
                .append("\nNombre: ")
                .append(nombre)
                .append("\nEdad aproximada: ")
                .append(edadAproximada)
                .append(" años")
                .append("\nNúmero de registro: ")
                .append(numeroRegistro)
                .append("\nFecha del registro: ")
                .append(fechaActual);

        System.out.println(resumen);

        teclado.close();
    }

    /*
     * ==================================================
     * PAQUETE JAVA.LANG
     * ==================================================
     *
     * java.lang contiene clases fundamentales.
     *
     * Se importa automáticamente en todos
     * los programas Java.
     *
     * No necesitamos escribir:
     *
     * import java.lang.String;
     * import java.lang.Math;
     * import java.lang.System;
     */

    public static void ejemploJavaLang() {

        System.out.println("\n1. PAQUETE java.lang");
        System.out.println("----------------------------------------");

        /*
         * String pertenece a java.lang.
         */
        String lenguaje = "Java";

        /*
         * Math pertenece a java.lang.
         */
        double raiz = Math.sqrt(81);
        double potencia = Math.pow(2, 5);

        /*
         * Integer pertenece a java.lang.
         */
        String numeroTexto = "150";
        int numeroConvertido =
                Integer.parseInt(numeroTexto);

        /*
         * Character pertenece a java.lang.
         */
        char letra = 'J';

        boolean esMayuscula =
                Character.isUpperCase(letra);

        /*
         * System también pertenece a java.lang.
         */
        System.out.println(
                "Lenguaje: " + lenguaje
        );

        System.out.println(
                "Longitud del texto: "
                        + lenguaje.length()
        );

        System.out.println(
                "Raíz cuadrada de 81: " + raiz
        );

        System.out.println(
                "2 elevado a 5: " + potencia
        );

        System.out.println(
                "Texto convertido a entero: "
                        + numeroConvertido
        );

        System.out.println(
                "¿La letra J es mayúscula?: "
                        + esMayuscula
        );

        /*
         * Otras clases de java.lang:
         *
         * Object
         * Boolean
         * Double
         * Exception
         * StringBuilder
         * Thread
         */
    }

    /*
     * ==================================================
     * PAQUETE JAVA.UTIL
     * ==================================================
     *
     * java.util contiene clases para:
     *
     * - Entrada de datos.
     * - Colecciones.
     * - Números aleatorios.
     * - Trabajo con arreglos.
     *
     * Sus clases sí deben importarse.
     */

    public static void ejemploJavaUtil() {

        System.out.println("\n2. PAQUETE java.util");
        System.out.println("----------------------------------------");

        /*
         * Random genera valores pseudoaleatorios.
         */
        Random generador = new Random();

        int numeroAleatorio =
                generador.nextInt(1, 101);

        System.out.println(
                "Número aleatorio entre 1 y 100: "
                        + numeroAleatorio
        );

        /*
         * ArrayList representa una lista dinámica.
         */
        ArrayList<String> lenguajes =
                new ArrayList<>();

        lenguajes.add("Java");
        lenguajes.add("Python");
        lenguajes.add("JavaScript");

        System.out.println(
                "Lista de lenguajes: " + lenguajes
        );

        System.out.println(
                "Cantidad de elementos: "
                        + lenguajes.size()
        );

        /*
         * Arrays contiene métodos para arreglos.
         */
        int[] numeros = {
                40,
                10,
                30,
                20
        };

        Arrays.sort(numeros);

        System.out.println(
                "Arreglo ordenado: "
                        + Arrays.toString(numeros)
        );

        /*
         * Scanner también pertenece a java.util.
         *
         * En este método no se crea otro Scanner
         * para evitar cerrar System.in accidentalmente.
         */
        System.out.println(
                "Scanner permite leer datos desde teclado."
        );
    }

    /*
     * ==================================================
     * PAQUETE JAVA.TIME
     * ==================================================
     *
     * java.time permite trabajar con fechas y horas.
     *
     * Fue incorporado en Java 8 y reemplaza muchos
     * usos de clases antiguas como Date y Calendar.
     */

    public static void ejemploJavaTime() {

        System.out.println("\n3. PAQUETE java.time");
        System.out.println("----------------------------------------");

        /*
         * LocalDate representa una fecha sin hora.
         */
        LocalDate fechaActual =
                LocalDate.now();

        /*
         * LocalTime representa una hora sin fecha.
         */
        LocalTime horaActual =
                LocalTime.now();

        /*
         * LocalDateTime representa fecha y hora.
         */
        LocalDateTime fechaHoraActual =
                LocalDateTime.now();

        System.out.println(
                "Fecha actual: " + fechaActual
        );

        System.out.println(
                "Hora actual: " + horaActual
        );

        System.out.println(
                "Fecha y hora actual: "
                        + fechaHoraActual
        );

        /*
         * Podemos crear una fecha específica.
         */
        LocalDate inicioCurso =
                LocalDate.of(2026, 7, 15);

        System.out.println(
                "Fecha de inicio del curso: "
                        + inicioCurso
        );

        /*
         * Consultamos partes de la fecha.
         */
        int anio = inicioCurso.getYear();
        Month mes = inicioCurso.getMonth();
        int dia = inicioCurso.getDayOfMonth();
        DayOfWeek diaSemana =
                inicioCurso.getDayOfWeek();

        System.out.println(
                "Año: " + anio
        );

        System.out.println(
                "Mes: " + mes
        );

        System.out.println(
                "Día del mes: " + dia
        );

        System.out.println(
                "Día de la semana: " + diaSemana
        );

        /*
         * Las clases de java.time son inmutables.
         *
         * plusDays() genera una nueva fecha.
         */
        LocalDate unaSemanaDespues =
                inicioCurso.plusDays(7);

        LocalDate unMesDespues =
                inicioCurso.plusMonths(1);

        System.out.println(
                "Una semana después: "
                        + unaSemanaDespues
        );

        System.out.println(
                "Un mes después: "
                        + unMesDespues
        );

        /*
         * Formateamos la fecha para mostrarla
         * con el patrón día/mes/año.
         */
        DateTimeFormatter formatoFecha =
                DateTimeFormatter.ofPattern(
                        "dd/MM/yyyy"
                );

        String fechaFormateada =
                inicioCurso.format(formatoFecha);

        System.out.println(
                "Fecha formateada: "
                        + fechaFormateada
        );

        /*
         * Formateamos la fecha y hora.
         */
        DateTimeFormatter formatoCompleto =
                DateTimeFormatter.ofPattern(
                        "dd/MM/yyyy HH:mm:ss"
                );

        String fechaHoraFormateada =
                fechaHoraActual.format(
                        formatoCompleto
                );

        System.out.println(
                "Fecha y hora formateadas: "
                        + fechaHoraFormateada
        );
    }
}