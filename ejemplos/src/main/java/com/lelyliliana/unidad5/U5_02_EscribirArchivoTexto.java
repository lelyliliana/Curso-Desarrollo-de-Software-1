package com.lelyliliana.unidad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * EJEMPLO 2 - UNIDAD 5
 *
 * Tema:
 * Escritura de información en un archivo de texto.
 *
 * Este programa muestra cómo guardar varias líneas
 * dentro de un archivo utilizando Files.write().
 */
public class U5_02_EscribirArchivoTexto {

    public static void main(String[] args) {

        /*
         * Se define la ruta y el nombre del archivo.
         *
         * El archivo se creará en la carpeta desde la cual
         * se ejecute el programa.
         */
        Path rutaArchivo = Path.of("estudiantes.txt");

        /*
         * Se crea una lista con la información
         * que será almacenada en el archivo.
         */
        List<String> estudiantes = List.of(
            "1001;Laura Martínez;Ingeniería de Sistemas",
            "1002;Carlos Pérez;Ingeniería Industrial",
            "1003;Ana Gómez;Administración de Empresas"
        );

        try {

            /*
             * Files.write() permite guardar una colección
             * de cadenas en un archivo.
             *
             * Cada elemento de la lista se almacena
             * en una línea diferente.
             */
            Files.write(rutaArchivo, estudiantes);

            System.out.println("ESCRITURA DE ARCHIVOS");
            System.out.println("----------------------------------");
            System.out.println("El archivo fue creado correctamente.");
            System.out.println("Ubicación:");
            System.out.println(rutaArchivo.toAbsolutePath());

            System.out.println();
            System.out.println("Registros almacenados:");

            for (String estudiante : estudiantes) {
                System.out.println(estudiante);
            }

        } catch (IOException excepcion) {

            System.out.println("No fue posible escribir el archivo.");
            System.out.println(
                "Detalle del error: " + excepcion.getMessage()
            );
        }
    }
}
