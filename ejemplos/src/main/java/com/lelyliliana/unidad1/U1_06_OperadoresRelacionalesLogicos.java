package com.lelyliliana.unidad1;

/*
 * EJEMPLO 6 - UNIDAD 1
 *
 * Tema:
 * Operadores relacionales y operadores lógicos.
 *
 * Los operadores relacionales comparan valores
 * y producen un resultado booleano:
 *
 * true  = verdadero
 * false = falso
 *
 * Operadores relacionales:
 *
 * >   Mayor que
 * <   Menor que
 * >=  Mayor o igual que
 * <=  Menor o igual que
 * ==  Igual que
 * !=  Diferente de
 *
 * Operadores lógicos:
 *
 * &&  AND: todas las condiciones deben ser verdaderas.
 * ||  OR: al menos una condición debe ser verdadera.
 * !   NOT: invierte un valor booleano.
 */

public class U1_06_OperadoresRelacionalesLogicos {

    public static void main(String[] args) {

        /*
         * ==================================================
         * DATOS PARA LAS COMPARACIONES
         * ==================================================
         */

        int numero1 = 15;
        int numero2 = 10;

        System.out.println("OPERADORES RELACIONALES");
        System.out.println("--------------------------------");

        System.out.println("Número 1: " + numero1);
        System.out.println("Número 2: " + numero2);

        /*
         * ==================================================
         * OPERADOR MAYOR QUE >
         * ==================================================
         */

        boolean esMayor = numero1 > numero2;

        System.out.println(
                numero1 + " > " + numero2 + " = " + esMayor
        );

        /*
         * ==================================================
         * OPERADOR MENOR QUE <
         * ==================================================
         */

        boolean esMenor = numero1 < numero2;

        System.out.println(
                numero1 + " < " + numero2 + " = " + esMenor
        );

        /*
         * ==================================================
         * OPERADOR MAYOR O IGUAL QUE >=
         * ==================================================
         */

        boolean esMayorOIgual = numero1 >= numero2;

        System.out.println(
                numero1 + " >= " + numero2 + " = " + esMayorOIgual
        );

        /*
         * ==================================================
         * OPERADOR MENOR O IGUAL QUE <=
         * ==================================================
         */

        boolean esMenorOIgual = numero1 <= numero2;

        System.out.println(
                numero1 + " <= " + numero2 + " = " + esMenorOIgual
        );

        /*
         * ==================================================
         * OPERADOR IGUAL QUE ==
         * ==================================================
         *
         * El operador == compara dos valores.
         *
         * No debe confundirse con el operador =
         * que se utiliza para asignar valores.
         */

        boolean sonIguales = numero1 == numero2;

        System.out.println(
                numero1 + " == " + numero2 + " = " + sonIguales
        );

        /*
         * ==================================================
         * OPERADOR DIFERENTE DE !=
         * ==================================================
         */

        boolean sonDiferentes = numero1 != numero2;

        System.out.println(
                numero1 + " != " + numero2 + " = " + sonDiferentes
        );

        /*
         * ==================================================
         * OPERADOR LÓGICO AND &&
         * ==================================================
         *
         * El resultado es true únicamente cuando
         * todas las condiciones son verdaderas.
         */

        int edad = 20;
        double promedio = 4.2;

        boolean esMayorDeEdad = edad >= 18;
        boolean tieneBuenPromedio = promedio >= 3.5;

        boolean cumpleAmbasCondiciones =
                esMayorDeEdad && tieneBuenPromedio;

        System.out.println("\nOPERADOR AND &&");
        System.out.println("--------------------------------");

        System.out.println("Edad: " + edad);
        System.out.println("Promedio: " + promedio);

        System.out.println(
                "¿Es mayor de edad?: " + esMayorDeEdad
        );

        System.out.println(
                "¿Tiene promedio de 3.5 o superior?: "
                        + tieneBuenPromedio
        );

        System.out.println(
                "¿Cumple las dos condiciones?: "
                        + cumpleAmbasCondiciones
        );

        /*
         * ==================================================
         * OPERADOR LÓGICO OR ||
         * ==================================================
         *
         * El resultado es true cuando al menos una
         * de las condiciones es verdadera.
         */

        boolean tieneBeca = false;
        boolean tieneDescuento = true;

        boolean recibeBeneficio =
                tieneBeca || tieneDescuento;

        System.out.println("\nOPERADOR OR ||");
        System.out.println("--------------------------------");

        System.out.println("¿Tiene beca?: " + tieneBeca);
        System.out.println("¿Tiene descuento?: " + tieneDescuento);

        System.out.println(
                "¿Recibe algún beneficio?: "
                        + recibeBeneficio
        );

        /*
         * ==================================================
         * OPERADOR LÓGICO NOT !
         * ==================================================
         *
         * El operador ! invierte el valor booleano.
         *
         * true se convierte en false.
         * false se convierte en true.
         */

        boolean cursoFinalizado = false;
        boolean cursoPendiente = !cursoFinalizado;

        System.out.println("\nOPERADOR NOT !");
        System.out.println("--------------------------------");

        System.out.println(
                "¿El curso está finalizado?: "
                        + cursoFinalizado
        );

        System.out.println(
                "¿El curso está pendiente?: "
                        + cursoPendiente
        );

        /*
         * ==================================================
         * EJEMPLO INTEGRADO
         * ==================================================
         *
         * Un estudiante puede presentar la evaluación si:
         *
         * - Está matriculado.
         * - Tiene una asistencia mínima del 70 %.
         * - No se encuentra bloqueado.
         */

        boolean estaMatriculado = true;
        double asistencia = 85.0;
        boolean estaBloqueado = false;

        boolean cumpleAsistencia = asistencia >= 70.0;

        /*
         * !estaBloqueado significa:
         *
         * "no está bloqueado".
         */

        boolean puedePresentarEvaluacion =
                estaMatriculado
                        && cumpleAsistencia
                        && !estaBloqueado;

        System.out.println("\nEJEMPLO INTEGRADO");
        System.out.println("--------------------------------");

        System.out.println(
                "¿Está matriculado?: "
                        + estaMatriculado
        );

        System.out.println(
                "Asistencia: "
                        + asistencia
                        + "%"
        );

        System.out.println(
                "¿Cumple la asistencia mínima?: "
                        + cumpleAsistencia
        );

        System.out.println(
                "¿Está bloqueado?: "
                        + estaBloqueado
        );

        System.out.println(
                "¿Puede presentar la evaluación?: "
                        + puedePresentarEvaluacion
        );
    }
}