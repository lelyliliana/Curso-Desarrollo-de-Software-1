package com.lelyliliana.unidad3;

/*
 * EJEMPLO 13 - UNIDAD 3
 *
 * Tema:
 * Paso por valor con tipos de datos primitivos.
 *
 * En Java, cuando se envía una variable primitiva
 * a un método, se envía una copia de su valor.
 *
 * Esto significa que:
 *
 * - El método trabaja con una copia.
 * - La variable original no cambia.
 * - Para conservar un cambio, el método puede retornar
 *   un nuevo valor y este debe asignarse.
 *
 * Tipos primitivos:
 *
 * byte
 * short
 * int
 * long
 * float
 * double
 * char
 * boolean
 */

public class U3_13_PasoPorValor {

    public static void main(String[] args) {

        System.out.println("PASO POR VALOR EN JAVA");
        System.out.println("----------------------------------------");

        /*
         * ==================================================
         * EJEMPLO 1: VARIABLE ENTERA
         * ==================================================
         */

        int numero = 10;

        System.out.println("EJEMPLO CON int");
        System.out.println("----------------------------------------");

        System.out.println(
                "Valor antes de llamar el método: "
                        + numero
        );

        /*
         * Enviamos el valor de numero al método.
         *
         * El método recibe una copia del valor 10.
         */
        modificarNumero(numero);

        /*
         * La variable original continúa con el mismo valor.
         */
        System.out.println(
                "Valor después de llamar el método: "
                        + numero
        );

        /*
         * ==================================================
         * EJEMPLO 2: RETORNAR EL NUEVO VALOR
         * ==================================================
         *
         * Para conservar el cambio, el método puede retornar
         * el resultado y este debe asignarse nuevamente.
         */

        numero = aumentarNumero(numero);

        System.out.println("\nMÉTODO CON RETORNO");
        System.out.println("----------------------------------------");

        System.out.println(
                "Valor después de asignar el retorno: "
                        + numero
        );

        /*
         * ==================================================
         * EJEMPLO 3: VARIABLE DOUBLE
         * ==================================================
         */

        double salario = 2_500_000.0;

        System.out.println("\nEJEMPLO CON double");
        System.out.println("----------------------------------------");

        System.out.println(
                "Salario antes del método: $"
                        + salario
        );

        aplicarAumentoSinRetorno(salario);

        System.out.println(
                "Salario después del método sin retorno: $"
                        + salario
        );

        /*
         * Asignamos el valor retornado para conservar
         * el aumento.
         */

        salario = aplicarAumentoConRetorno(salario);

        System.out.println(
                "Salario después del método con retorno: $"
                        + salario
        );

        /*
         * ==================================================
         * EJEMPLO 4: VARIABLE BOOLEAN
         * ==================================================
         */

        boolean estudianteActivo = true;

        System.out.println("\nEJEMPLO CON boolean");
        System.out.println("----------------------------------------");

        System.out.println(
                "Estado antes del método: "
                        + estudianteActivo
        );

        cambiarEstado(estudianteActivo);

        System.out.println(
                "Estado después del método: "
                        + estudianteActivo
        );

        /*
         * ==================================================
         * EJEMPLO 5: VARIABLE CHAR
         * ==================================================
         */

        char grupo = 'A';

        System.out.println("\nEJEMPLO CON char");
        System.out.println("----------------------------------------");

        System.out.println(
                "Grupo antes del método: "
                        + grupo
        );

        cambiarGrupo(grupo);

        System.out.println(
                "Grupo después del método: "
                        + grupo
        );

        /*
         * ==================================================
         * EJEMPLO 6: DOS VARIABLES
         * ==================================================
         *
         * Intentaremos intercambiar dos valores dentro
         * de un método.
         */

        int numero1 = 5;
        int numero2 = 8;

        System.out.println("\nINTERCAMBIO DE VALORES");
        System.out.println("----------------------------------------");

        System.out.println(
                "Antes del método:"
        );

        System.out.println(
                "numero1 = " + numero1
        );

        System.out.println(
                "numero2 = " + numero2
        );

        intercambiar(numero1, numero2);

        /*
         * Los valores originales no cambian.
         */
        System.out.println(
                "Después del método:"
        );

        System.out.println(
                "numero1 = " + numero1
        );

        System.out.println(
                "numero2 = " + numero2
        );

        System.out.println("\nFin del programa.");
    }

    /*
     * ==================================================
     * MÉTODO QUE MODIFICA UNA COPIA
     * ==================================================
     *
     * El parámetro valor recibe una copia del número
     * enviado desde main.
     */

    public static void modificarNumero(int valor) {

        System.out.println(
                "Valor recibido dentro del método: "
                        + valor
        );

        valor = valor + 20;

        System.out.println(
                "Valor modificado dentro del método: "
                        + valor
        );
    }

    /*
     * ==================================================
     * MÉTODO QUE RETORNA UN NUEVO VALOR
     * ==================================================
     */

    public static int aumentarNumero(int valor) {

        valor = valor + 20;

        return valor;
    }

    /*
     * ==================================================
     * MÉTODO CON DOUBLE SIN RETORNO
     * ==================================================
     */

    public static void aplicarAumentoSinRetorno(
            double salario
    ) {

        salario = salario * 1.10;

        System.out.println(
                "Salario calculado dentro del método: $"
                        + salario
        );
    }

    /*
     * ==================================================
     * MÉTODO CON DOUBLE Y RETORNO
     * ==================================================
     */

    public static double aplicarAumentoConRetorno(
            double salario
    ) {

        salario = salario * 1.10;

        return salario;
    }

    /*
     * ==================================================
     * MÉTODO CON BOOLEAN
     * ==================================================
     */

    public static void cambiarEstado(boolean estado) {

        estado = false;

        System.out.println(
                "Estado dentro del método: "
                        + estado
        );
    }

    /*
     * ==================================================
     * MÉTODO CON CHAR
     * ==================================================
     */

    public static void cambiarGrupo(char grupo) {

        grupo = 'B';

        System.out.println(
                "Grupo dentro del método: "
                        + grupo
        );
    }

    /*
     * ==================================================
     * MÉTODO QUE INTENTA INTERCAMBIAR DOS VALORES
     * ==================================================
     */

    public static void intercambiar(
            int valor1,
            int valor2
    ) {

        int temporal = valor1;

        valor1 = valor2;
        valor2 = temporal;

        System.out.println(
                "Dentro del método:"
        );

        System.out.println(
                "valor1 = " + valor1
        );

        System.out.println(
                "valor2 = " + valor2
        );
    }
}