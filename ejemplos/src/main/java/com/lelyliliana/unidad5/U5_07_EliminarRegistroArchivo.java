package com.lelyliliana.unidad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * EJEMPLO 7 - UNIDAD 5
 *
 * Tema:
 * Eliminación de registros almacenados en un archivo.
 *
 * Este programa busca un estudiante por su documento,
 * elimina el registro correspondiente y vuelve a escribir
 * el archivo con los registros restantes.
 */
public class U5_07_EliminarRegistroArchivo {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Path rutaArchivo = Path.of("estudiantes.txt");

        System.out.println("ELIMINAR REGISTRO DE UN ARCHIVO");
        System.out.println("----------------------------------");

        if (!Files.exists(rutaArchivo)) {

            System.out.println("El archivo estudiantes.txt no existe.");

            teclado.close();
            return;
        }

        System.out.print(
            "Ingrese el documento del estudiante que desea eliminar: "
        );

        String documentoBuscado = teclado.nextLine().trim();

        try {

            List<String> registros =
                Files.readAllLines(rutaArchivo);

            /*
             * Esta lista almacenará solamente
             * los registros que deben conservarse.
             */
            List<String> registrosRestantes =
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

                    /*
                     * El registro no se agrega a la nueva lista.
                     * De esta manera queda eliminado.
                     */
                    encontrado = true;

                } else {

                    registrosRestantes.add(registro);
                }
            }

            if (encontrado) {

                System.out.println();
                System.out.print(
                    "¿Confirma la eliminación? (S/N): "
                );

                String respuesta =
                    teclado.nextLine().trim();

                if (respuesta.equalsIgnoreCase("S")) {

                    /*
                     * Se reemplaza el contenido del archivo
                     * con los registros que deben conservarse.
                     */
                    Files.write(
                        rutaArchivo,
                        registrosRestantes
                    );

                    System.out.println();
                    System.out.println(
                        "Registro eliminado correctamente."
                    );

                } else {

                    System.out.println();
                    System.out.println(
                        "La eliminación fue cancelada."
                    );
                }

            } else {

                System.out.println();
                System.out.println(
                    "No se encontró un estudiante con ese documento."
                );
            }

        } catch (IOException excepcion) {

            System.out.println();
            System.out.println(
                "No fue posible eliminar el registro."
            );
            System.out.println(
                "Detalle del error: " + excepcion.getMessage()
            );
        }

        teclado.close();
    }
}
