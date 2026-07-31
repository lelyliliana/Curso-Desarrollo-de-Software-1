package com.lelyliliana.unidad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * EJEMPLO 5 - UNIDAD 5
 *
 * Tema:
 * Búsqueda de registros almacenados en un archivo.
 *
 * Este programa permite buscar un estudiante
 * utilizando su número de documento.
 */
public class U5_05_BuscarRegistroArchivo {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Path rutaArchivo = Path.of("estudiantes.txt");

        System.out.println("BUSCAR REGISTRO EN UN ARCHIVO");
        System.out.println("----------------------------------");

        /*
         * Se verifica que el archivo exista
         * antes de intentar leerlo.
         */
        if (!Files.exists(rutaArchivo)) {

            System.out.println("El archivo estudiantes.txt no existe.");
            System.out.println(
                "Primero debe crear o agregar registros."
            );

            teclado.close();
            return;
        }

        System.out.print(
            "Ingrese el documento que desea buscar: "
        );

        String documentoBuscado = teclado.nextLine().trim();

        try {

            /*
             * Se recuperan todas las líneas del archivo.
             */
            List<String> registros =
                Files.readAllLines(rutaArchivo);

            boolean encontrado = false;

            /*
             * Cada registro tiene esta estructura:
             *
             * documento;nombre;programa
             */
            for (String registro : registros) {

                /*
                 * split(";") separa la línea cada vez
                 * que encuentra un punto y coma.
                 */
                String[] datos = registro.split(";");

                /*
                 * Se verifica que el registro tenga
                 * al menos tres datos.
                 */
                if (datos.length >= 3) {

                    String documento = datos[0];
                    String nombre = datos[1];
                    String programa = datos[2];

                    /*
                     * Se compara el documento almacenado
                     * con el documento ingresado.
                     */
                    if (documento.equals(documentoBuscado)) {

                        System.out.println();
                        System.out.println("Registro encontrado:");
                        System.out.println(
                            "Documento: " + documento
                        );
                        System.out.println(
                            "Nombre: " + nombre
                        );
                        System.out.println(
                            "Programa: " + programa
                        );

                        encontrado = true;

                        /*
                         * break finaliza el ciclo porque
                         * ya se encontró el registro.
                         */
                        break;
                    }
                }
            }

            if (!encontrado) {

                System.out.println();
                System.out.println(
                    "No se encontró un estudiante con el documento "
                    + documentoBuscado
                    + "."
                );
            }

        } catch (IOException excepcion) {

            System.out.println();
            System.out.println(
                "No fue posible consultar el archivo."
            );
            System.out.println(
                "Detalle del error: " + excepcion.getMessage()
            );
        }

        teclado.close();
    }
}
