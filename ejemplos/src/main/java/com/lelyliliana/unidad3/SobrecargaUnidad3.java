package com.lelyliliana.unidad3;

/*
 * EJEMPLO 17 - UNIDAD 3
 *
 * Tema:
 * Sobrecarga de métodos aplicada a diferentes
 * tipos de datos.
 *
 * La sobrecarga permite declarar varios métodos
 * con el mismo nombre, siempre que cambie:
 *
 * - La cantidad de parámetros.
 * - El tipo de los parámetros.
 * - El orden de los tipos de parámetros.
 *
 * No es suficiente cambiar únicamente
 * el tipo de retorno.
 */

public class SobrecargaUnidad3 {

    public static void main(String[] args) {

        System.out.println("SOBRECARGA DE MÉTODOS");
        System.out.println("----------------------------------------");

        /*
         * Java identifica automáticamente cuál versión
         * del método debe ejecutar.
         */

        int sumaEnteros = sumar(10, 5);

        int sumaTresEnteros =
                sumar(10, 5, 3);

        double sumaDecimales =
                sumar(4.5, 2.3);

        String sumaTextos =
                sumar("Desarrollo", " de Software");

        System.out.println(
                "Suma de dos enteros: "
                        + sumaEnteros
        );

        System.out.println(
                "Suma de tres enteros: "
                        + sumaTresEnteros
        );

        System.out.println(
                "Suma de dos decimales: "
                        + sumaDecimales
        );

        System.out.println(
                "Unión de dos textos: "
                        + sumaTextos
        );

        /*
         * ==================================================
         * EJEMPLO CON MÉTODO MOSTRAR()
         * ==================================================
         */

        System.out.println("\nMÉTODO mostrar()");
        System.out.println("----------------------------------------");

        mostrar("Java");
        mostrar(21);
        mostrar(4.8);
        mostrar(true);

        /*
         * ==================================================
         * SOBRECARGA POR CANTIDAD DE PARÁMETROS
         * ==================================================
         */

        System.out.println("\nCÁLCULO DE PROMEDIOS");
        System.out.println("----------------------------------------");

        double promedioDosNotas =
                calcularPromedio(4.0, 3.5);

        double promedioTresNotas =
                calcularPromedio(4.0, 3.5, 4.8);

        System.out.println(
                "Promedio de dos notas: "
                        + promedioDosNotas
        );

        System.out.println(
                "Promedio de tres notas: "
                        + promedioTresNotas
        );

        /*
         * ==================================================
         * SOBRECARGA POR TIPO DE DATOS
         * ==================================================
         */

        System.out.println("\nDESCUENTOS");
        System.out.println("----------------------------------------");

        double total1 =
                calcularDescuento(100000.0);

        double total2 =
                calcularDescuento(
                        100000.0,
                        10.0
                );

        double total3 =
                calcularDescuento(
                        100000,
                        15000
                );

        System.out.println(
                "Total con descuento automático: $"
                        + total1
        );

        System.out.println(
                "Total con descuento del 10 %: $"
                        + total2
        );

        System.out.println(
                "Total con descuento fijo: $"
                        + total3
        );

        /*
         * ==================================================
         * SOBRECARGA CON DIFERENTE ORDEN
         * ==================================================
         */

        System.out.println("\nREGISTRO DE DATOS");
        System.out.println("----------------------------------------");

        registrarDato(
                "Laura",
                25
        );

        registrarDato(
                25,
                "Laura"
        );

        System.out.println("\nFin del programa.");
    }

    /*
     * ==================================================
     * MÉTODOS SUMAR SOBRECARGADOS
     * ==================================================
     */

    public static int sumar(
            int numero1,
            int numero2
    ) {

        return numero1 + numero2;
    }

    public static int sumar(
            int numero1,
            int numero2,
            int numero3
    ) {

        return numero1 + numero2 + numero3;
    }

    public static double sumar(
            double numero1,
            double numero2
    ) {

        return numero1 + numero2;
    }

    public static String sumar(
            String texto1,
            String texto2
    ) {

        return texto1 + texto2;
    }

    /*
     * ==================================================
     * MÉTODOS MOSTRAR SOBRECARGADOS
     * ==================================================
     */

    public static void mostrar(String valor) {

        System.out.println(
                "Texto recibido: " + valor
        );
    }

    public static void mostrar(int valor) {

        System.out.println(
                "Entero recibido: " + valor
        );
    }

    public static void mostrar(double valor) {

        System.out.println(
                "Decimal recibido: " + valor
        );
    }

    public static void mostrar(boolean valor) {

        System.out.println(
                "Booleano recibido: " + valor
        );
    }

    /*
     * ==================================================
     * PROMEDIOS SOBRECARGADOS
     * ==================================================
     */

    public static double calcularPromedio(
            double nota1,
            double nota2
    ) {

        return (nota1 + nota2) / 2;
    }

    public static double calcularPromedio(
            double nota1,
            double nota2,
            double nota3
    ) {

        return (nota1 + nota2 + nota3) / 3;
    }

    /*
     * ==================================================
     * DESCUENTOS SOBRECARGADOS
     * ==================================================
     */

    /*
     * Aplica un descuento automático del 5 %.
     */
    public static double calcularDescuento(
            double valorCompra
    ) {

        return valorCompra * 0.95;
    }

    /*
     * Recibe el porcentaje como double.
     */
    public static double calcularDescuento(
            double valorCompra,
            double porcentaje
    ) {

        double descuento =
                valorCompra * porcentaje / 100;

        return valorCompra - descuento;
    }

    /*
     * Recibe ambos valores como int.
     *
     * En este caso, el segundo parámetro representa
     * un valor fijo de descuento.
     */
    public static double calcularDescuento(
            int valorCompra,
            int descuentoFijo
    ) {

        return valorCompra - descuentoFijo;
    }

    /*
     * ==================================================
     * SOBRECARGA POR ORDEN DE PARÁMETROS
     * ==================================================
     */

    public static void registrarDato(
            String nombre,
            int edad
    ) {

        System.out.println(
                "Método 1: nombre = "
                        + nombre
                        + ", edad = "
                        + edad
        );
    }

    public static void registrarDato(
            int edad,
            String nombre
    ) {

        System.out.println(
                "Método 2: edad = "
                        + edad
                        + ", nombre = "
                        + nombre
        );
    }
}