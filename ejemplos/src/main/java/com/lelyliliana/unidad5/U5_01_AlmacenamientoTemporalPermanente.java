package com.lelyliliana.unidad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * EJEMPLO 1 - UNIDAD 5
 *
 * Tema:
 * Diferencia entre almacenamiento temporal y permanente.
 *
 * El almacenamiento temporal conserva los datos solamente
 * mientras el programa está en ejecución.
 *
 * El almacenamiento permanente permite guardar los datos
 * en un archivo para consultarlos posteriormente, incluso
 * después de cerrar el programa.
 */
public class U5_01_AlmacenamientoTemporalPermanente {

    public static void main(String[] args) {

        /*
         * ==================================================
         * ALMACENAMIENTO TEMPORAL
         * ==================================================
         */

        /*
         * Este dato se almacena en una variable.
         *
         * La variable existe mientras el programa está
         * ejecutándose. Cuando el programa termina,
         * su contenido desaparece de la memoria.
         */
        String nombreEstudiante = "Laura Martínez";

        System.out.println("ALMACENAMIENTO TEMPORAL");
        System.out.println("------------------------------");
        System.out.println("Dato guardado en memoria:");
        System.out.println(nombreEstudiante);

        /*
         * ==================================================
         * ALMACENAMIENTO PERMANENTE
         * ==================================================
         */

        /*
         * Path representa la ubicación del archivo.
         *
         * En este caso, el archivo se creará en la carpeta
         * desde la cual se ejecute el programa.
         */
        Path rutaArchivo = Path.of("estudiante.txt");

        try {

            /*
             * Files.writeString() escribe texto en un archivo.
             *
             * Si el archivo no existe, Java lo crea.
             * Si ya existe, reemplaza su contenido.
             */
            Files.writeString(
                rutaArchivo,
                "Nombre del estudiante: " + nombreEstudiante
            );

            System.out.println();
            System.out.println("ALMACENAMIENTO PERMANENTE");
            System.out.println("------------------------------");
            System.out.println("El dato fue guardado en:");
            System.out.println(rutaArchivo.toAbsolutePath());

            /*
             * Files.readString() permite leer el contenido
             * almacenado en el archivo.
             */
            String contenidoArchivo =
                Files.readString(rutaArchivo);

            System.out.println();
            System.out.println("Contenido recuperado del archivo:");
            System.out.println(contenidoArchivo);

        } catch (IOException excepcion) {

            /*
             * IOException representa errores relacionados
             * con la lectura o escritura de archivos.
             */
            System.out.println();
            System.out.println("No fue posible trabajar con el archivo.");
            System.out.println(
                "Detalle del error: " + excepcion.getMessage()
            );
        }

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
