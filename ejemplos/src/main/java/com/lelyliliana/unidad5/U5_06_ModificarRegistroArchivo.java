package com.lelyliliana.unidad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * EJEMPLO 6 - UNIDAD 5
 *
 * Tema:
 * Modificación de registros almacenados en un archivo.
 *
 * Este programa busca un estudiante por su documento,
 * permite cambiar sus datos y vuelve a escribir
 * todo el contenido del archivo.
 */
public class U5_06_ModificarRegistroArchivo {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Path rutaArchivo = Path.of("estudiantes.txt");

        System.out.println("MODIFICAR REGISTRO DE UN ARCHIVO");
        System.out.println("----------------------------------");

        if (!Files.exists(rutaArchivo)) {

            System.out.println("El archivo estudiantes.txt no existe.");

            teclado.close();
            return;
        }

        System.out.print(
            "Ingrese el documento del estudiante: "
        );

        String documentoBuscado = teclado.nextLine().trim();

        try {

            List<String> registros =
                Files.readAllLines(rutaArchivo);

            /*
             * Esta nueva lista almacenará los registros
             * actualizados.
             */
            List<String> registrosActualizados =
                new ArrayList<>();

            boolean encontrado = false;

            for (String registro : registros) {

                String[] datos = registro.split(";");

                if (
                    datos.length >= 3
                    && datos[0].equals(documentoBuscado)
                ) {

                    System.out.println();
                    System.out.println("Registro encontrado:");
                    System.out.println("Documento: " + datos[0]);
                    System.out.println("Nombre: " + datos[1]);
                    System.out.println("Programa: " + datos[2]);

                    System.out.println();
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre =
                        teclado.nextLine().trim();

                    System.out.print(
                        "Ingrese el nuevo programa académico: "
                    );

                    String nuevoPrograma =
                        teclado.nextLine().trim();

                    /*
                     * Se conserva el documento y se reemplazan
                     * el nombre y el programa.
                     */
                    String registroModificado =
                        documentoBuscado
                        + ";"
                        + nuevoNombre
                        + ";"
                        + nuevoPrograma;

                    registrosActualizados.add(
                        registroModificado
                    );

                    encontrado = true;

                } else {

                    /*
                     * Los registros que no coinciden
                     * se conservan sin cambios.
                     */
                    registrosActualizados.add(registro);
                }
            }

            if (encontrado) {

                /*
                 * Files.write() reemplaza el contenido
                 * completo del archivo con la lista actualizada.
                 */
                Files.write(
                    rutaArchivo,
                    registrosActualizados
                );

                System.out.println();
                System.out.println(
                    "Registro modificado correctamente."
                );

            } else {

                System.out.println();
                System.out.println(
                    "No se encontró un estudiante con ese documento."
                );
            }

        } catch (IOException excepcion) {

            System.out.println();
            System.out.println(
                "No fue posible modificar el archivo."
            );
            System.out.println(
                "Detalle del error: " + excepcion.getMessage()
            );
        }

        teclado.close();
    }
}
