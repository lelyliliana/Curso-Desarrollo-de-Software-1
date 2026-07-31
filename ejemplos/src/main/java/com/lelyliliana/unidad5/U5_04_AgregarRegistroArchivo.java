package com.lelyliliana.unidad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * EJEMPLO 4 - UNIDAD 5
 *
 * Tema:
 * Agregar nuevos registros a un archivo de texto.
 *
 * Este programa utiliza StandardOpenOption.APPEND
 * para añadir información sin eliminar los datos
 * que ya se encuentran almacenados.
 */
public class U5_04_AgregarRegistroArchivo {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Archivo donde se almacenarán los registros.
        Path rutaArchivo = Path.of("estudiantes.txt");

        System.out.println("AGREGAR REGISTRO A UN ARCHIVO");
        System.out.println("----------------------------------");

        // Se solicitan los datos del estudiante.
        System.out.print("Ingrese el documento: ");
        String documento = teclado.nextLine().trim();

        System.out.print("Ingrese el nombre: ");
        String nombre = teclado.nextLine().trim();

        System.out.print("Ingrese el programa académico: ");
        String programa = teclado.nextLine().trim();

        /*
         * Se construye el registro utilizando punto y coma
         * como separador de datos.
         */
        String nuevoRegistro =
            documento + ";" + nombre + ";" + programa;

        try {

            /*
             * CREATE:
             * crea el archivo si todavía no existe.
             *
             * APPEND:
             * agrega el nuevo contenido al final
             * sin eliminar los registros anteriores.
             */
            Files.writeString(
                rutaArchivo,
                nuevoRegistro + System.lineSeparator(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );

            System.out.println();
            System.out.println("Registro agregado correctamente.");
            System.out.println("Dato almacenado:");
            System.out.println(nuevoRegistro);

            System.out.println();
            System.out.println("Archivo:");
            System.out.println(rutaArchivo.toAbsolutePath());

        } catch (IOException excepcion) {

            System.out.println();
            System.out.println("No fue posible guardar el registro.");
            System.out.println(
                "Detalle del error: " + excepcion.getMessage()
            );
        }

        teclado.close();
    }
}
