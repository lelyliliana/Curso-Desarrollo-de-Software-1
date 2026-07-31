package com.lelyliliana.unidad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * EJEMPLO 3 - UNIDAD 5
 *
 * Tema:
 * Lectura de información desde un archivo de texto.
 *
 * Este programa muestra cómo recuperar varias líneas
 * almacenadas previamente en un archivo.
 */
public class U5_03_LeerArchivoTexto {

    public static void main(String[] args) {

        /*
         * Se define la ubicación del archivo que se desea leer.
         *
         * Este debe existir en la carpeta desde la cual
         * se ejecuta el programa.
         */
        Path rutaArchivo = Path.of("estudiantes.txt");

        System.out.println("LECTURA DE ARCHIVOS");
        System.out.println("----------------------------------");

        /*
         * Antes de intentar leer el archivo,
         * se verifica si realmente existe.
         */
        if (!Files.exists(rutaArchivo)) {

            System.out.println("El archivo no existe.");
            System.out.println("Primero ejecute el ejemplo:");
            System.out.println("U5_02_EscribirArchivoTexto");

            return;
        }

        try {

            /*
             * Files.readAllLines() lee todas las líneas
             * del archivo y las devuelve en una lista.
             */
            List<String> registros =
                Files.readAllLines(rutaArchivo);

            System.out.println("Archivo encontrado:");
            System.out.println(rutaArchivo.toAbsolutePath());

            System.out.println();
            System.out.println("Contenido almacenado:");

            /*
             * Se recorre la lista para mostrar
             * cada línea del archivo.
             */
            for (String registro : registros) {
                System.out.println(registro);
            }

            System.out.println();
            System.out.println(
                "Cantidad de registros: " + registros.size()
            );

        } catch (IOException excepcion) {

            System.out.println("No fue posible leer el archivo.");
            System.out.println(
                "Detalle del error: " + excepcion.getMessage()
            );
        }
    }
}
