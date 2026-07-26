package com.lelyliliana.unidad3;

/*
 * EJEMPLO 15 - UNIDAD 3
 *
 * Tema:
 * Uso de clases utilitarias de Java.
 *
 * En este programa se utilizan:
 *
 * Math        -> operaciones matemáticas.
 * Random      -> generación de valores aleatorios.
 * Arrays      -> operaciones con arreglos.
 * Collections -> operaciones con colecciones.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ClasesUtilitarias {

    public static void main(String[] args) {

        System.out.println("CLASES UTILITARIAS DE JAVA");
        System.out.println("========================================");

        /*
         * Llamamos un método independiente para cada clase.
         */
        ejemploMath();
        ejemploRandom();
        ejemploArrays();
        ejemploCollections();

        System.out.println("\nFin del programa.");
    }

    /*
     * ==================================================
     * CLASE MATH
     * ==================================================
     *
     * Math contiene métodos y constantes relacionados
     * con operaciones matemáticas.
     *
     * Sus métodos son estáticos, por lo que no necesitamos
     * crear un objeto con new.
     */

    public static void ejemploMath() {

        System.out.println("\n1. CLASE Math");
        System.out.println("----------------------------------------");

        double numero = 25.0;
        double decimal = 8.7;

        /*
         * sqrt() calcula la raíz cuadrada.
         */
        double raizCuadrada = Math.sqrt(numero);

        /*
         * pow(base, exponente) calcula una potencia.
         */
        double potencia = Math.pow(5, 3);

        /*
         * abs() obtiene el valor absoluto.
         */
        int valorAbsoluto = Math.abs(-15);

        /*
         * max() obtiene el mayor de dos valores.
         */
        int numeroMayor = Math.max(20, 35);

        /*
         * min() obtiene el menor de dos valores.
         */
        int numeroMenor = Math.min(20, 35);

        /*
         * round() redondea al entero más cercano.
         */
        long numeroRedondeado = Math.round(decimal);

        /*
         * floor() redondea hacia abajo.
         */
        double redondeoInferior = Math.floor(decimal);

        /*
         * ceil() redondea hacia arriba.
         */
        double redondeoSuperior = Math.ceil(decimal);

        /*
         * Math.PI representa el valor aproximado de pi.
         */
        double radio = 5.0;
        double areaCirculo =
                Math.PI * Math.pow(radio, 2);

        System.out.println(
                "Raíz cuadrada de " + numero
                        + ": " + raizCuadrada
        );

        System.out.println(
                "5 elevado a 3: " + potencia
        );

        System.out.println(
                "Valor absoluto de -15: "
                        + valorAbsoluto
        );

        System.out.println(
                "Mayor entre 20 y 35: "
                        + numeroMayor
        );

        System.out.println(
                "Menor entre 20 y 35: "
                        + numeroMenor
        );

        System.out.println(
                "Math.round(8.7): "
                        + numeroRedondeado
        );

        System.out.println(
                "Math.floor(8.7): "
                        + redondeoInferior
        );

        System.out.println(
                "Math.ceil(8.7): "
                        + redondeoSuperior
        );

        System.out.printf(
                "Área de un círculo con radio %.1f: %.2f%n",
                radio,
                areaCirculo
        );
    }

    /*
     * ==================================================
     * CLASE RANDOM
     * ==================================================
     *
     * Random permite generar valores pseudoaleatorios.
     *
     * En este caso sí creamos un objeto.
     */

    public static void ejemploRandom() {

        System.out.println("\n2. CLASE Random");
        System.out.println("----------------------------------------");

        Random generador = new Random();

        /*
         * nextInt(10) genera números desde 0 hasta 9.
         */
        int numeroDeCeroANueve =
                generador.nextInt(10);

        /*
         * Para generar números entre 1 y 10:
         *
         * nextInt(10) produce 0 a 9.
         * Sumamos 1 para obtener 1 a 10.
         */
        int numeroDeUnoADiez =
                generador.nextInt(10) + 1;

        /*
         * En Java 17 o superior puede utilizarse:
         *
         * nextInt(origen, limite)
         *
         * El límite final no se incluye.
         *
         * En este caso se generan valores desde 18 hasta 60.
         */
        int edadAleatoria =
                generador.nextInt(18, 61);

        /*
         * nextDouble() produce un valor entre 0.0
         * y un número menor que 1.0.
         */
        double decimalAleatorio =
                generador.nextDouble();

        /*
         * nextBoolean() produce true o false.
         */
        boolean estadoAleatorio =
                generador.nextBoolean();

        System.out.println(
                "Número entre 0 y 9: "
                        + numeroDeCeroANueve
        );

        System.out.println(
                "Número entre 1 y 10: "
                        + numeroDeUnoADiez
        );

        System.out.println(
                "Edad aleatoria entre 18 y 60: "
                        + edadAleatoria
        );

        System.out.println(
                "Decimal aleatorio: "
                        + decimalAleatorio
        );

        System.out.println(
                "Booleano aleatorio: "
                        + estadoAleatorio
        );

        /*
         * Simulación del lanzamiento de un dado.
         */
        int resultadoDado =
                generador.nextInt(6) + 1;

        System.out.println(
                "Resultado del dado: "
                        + resultadoDado
        );

        /*
         * Generación de una nota aleatoria entre 0 y 5.
         *
         * Se multiplica el número decimal por 5.
         */
        double notaAleatoria =
                generador.nextDouble() * 5;

        System.out.printf(
                "Nota aleatoria: %.2f%n",
                notaAleatoria
        );
    }

    /*
     * ==================================================
     * CLASE ARRAYS
     * ==================================================
     *
     * Arrays contiene métodos estáticos para trabajar
     * con arreglos.
     */

    public static void ejemploArrays() {

        System.out.println("\n3. CLASE Arrays");
        System.out.println("----------------------------------------");

        int[] numeros = {
                45,
                12,
                8,
                30,
                21
        };

        /*
         * toString() muestra el contenido del arreglo
         * de manera legible.
         */
        System.out.println(
                "Arreglo original: "
                        + Arrays.toString(numeros)
        );

        /*
         * sort() organiza el arreglo de menor a mayor.
         *
         * El arreglo original se modifica.
         */
        Arrays.sort(numeros);

        System.out.println(
                "Arreglo ordenado: "
                        + Arrays.toString(numeros)
        );

        /*
         * binarySearch() busca un valor en un arreglo
         * previamente ordenado.
         *
         * Retorna la posición del valor encontrado.
         */
        int posicion =
                Arrays.binarySearch(numeros, 30);

        System.out.println(
                "Posición del número 30: "
                        + posicion
        );

        /*
         * copyOf() crea una copia con la longitud indicada.
         */
        int[] copia =
                Arrays.copyOf(
                        numeros,
                        numeros.length
                );

        System.out.println(
                "Copia del arreglo: "
                        + Arrays.toString(copia)
        );

        /*
         * equals() compara el contenido de dos arreglos.
         */
        boolean arreglosIguales =
                Arrays.equals(numeros, copia);

        System.out.println(
                "¿Los arreglos tienen el mismo contenido?: "
                        + arreglosIguales
        );

        /*
         * fill() asigna el mismo valor a todas
         * las posiciones del arreglo.
         */
        int[] valoresIniciales =
                new int[5];

        Arrays.fill(valoresIniciales, 100);

        System.out.println(
                "Arreglo llenado con 100: "
                        + Arrays.toString(valoresIniciales)
        );

        /*
         * Ejemplo con un arreglo de cadenas.
         */
        String[] estudiantes = {
                "María",
                "Carlos",
                "Ana",
                "Pedro"
        };

        Arrays.sort(estudiantes);

        System.out.println(
                "Nombres ordenados: "
                        + Arrays.toString(estudiantes)
        );
    }

    /*
     * ==================================================
     * CLASE COLLECTIONS
     * ==================================================
     *
     * Collections contiene métodos estáticos para trabajar
     * con colecciones, como ArrayList.
     *
     * No debe confundirse con Collection, que es
     * una interfaz.
     */

    public static void ejemploCollections() {

        System.out.println("\n4. CLASE Collections");
        System.out.println("----------------------------------------");

        ArrayList<String> lenguajes =
                new ArrayList<>();

        lenguajes.add("Java");
        lenguajes.add("Python");
        lenguajes.add("C#");
        lenguajes.add("JavaScript");
        lenguajes.add("Kotlin");

        System.out.println(
                "Lista original: " + lenguajes
        );

        /*
         * sort() organiza los elementos.
         */
        Collections.sort(lenguajes);

        System.out.println(
                "Lista ordenada: " + lenguajes
        );

        /*
         * reverse() invierte el orden actual.
         */
        Collections.reverse(lenguajes);

        System.out.println(
                "Lista invertida: " + lenguajes
        );

        /*
         * shuffle() mezcla los elementos aleatoriamente.
         */
        Collections.shuffle(lenguajes);

        System.out.println(
                "Lista mezclada: " + lenguajes
        );

        /*
         * min() y max() obtienen el menor y mayor
         * elemento según el orden natural.
         */
        String primerElementoAlfabetico =
                Collections.min(lenguajes);

        String ultimoElementoAlfabetico =
                Collections.max(lenguajes);

        System.out.println(
                "Primero alfabéticamente: "
                        + primerElementoAlfabetico
        );

        System.out.println(
                "Último alfabéticamente: "
                        + ultimoElementoAlfabetico
        );

        /*
         * frequency() cuenta cuántas veces aparece
         * un elemento.
         */
        lenguajes.add("Java");

        int cantidadJava =
                Collections.frequency(
                        lenguajes,
                        "Java"
                );

        System.out.println(
                "Lista con Java repetido: "
                        + lenguajes
        );

        System.out.println(
                "Cantidad de veces que aparece Java: "
                        + cantidadJava
        );

        /*
         * Ejemplo con números.
         */
        ArrayList<Integer> notas =
                new ArrayList<>(
                        Arrays.asList(
                                4,
                                2,
                                5,
                                3,
                                4
                        )
                );

        System.out.println(
                "Notas: " + notas
        );

        System.out.println(
                "Nota mínima: "
                        + Collections.min(notas)
        );

        System.out.println(
                "Nota máxima: "
                        + Collections.max(notas)
        );
    }
}