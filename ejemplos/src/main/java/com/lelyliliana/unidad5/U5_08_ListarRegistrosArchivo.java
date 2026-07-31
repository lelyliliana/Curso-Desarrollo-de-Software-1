package com.lelyliliana.unidad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * EJEMPLO 8 - UNIDAD 5
 *
 * Tema:
 * Listado organizado de registros almacenados.
 *
 * Este programa lee el archivo estudiantes.txt
 * y muestra cada registro con etiquetas descriptivas.
 */
public class U5_08_ListarRegistrosArchivo {

    public static void main(String[] args) {

        Path rutaArchivo = Path.of("estudiantes.txt");

        System.out.println("LISTADO DE ESTUDIANTES");
        System.out.println("----------------------------------");

        if (!Files.exists(rutaArchivo)) {

            System.out.println("El archivo estudiantes.txt no existe.");
            return;
        }

        try {

            List<String> registros =
                Files.readAllLines(rutaArchivo);

            if (registros.isEmpty()) {

                System.out.println(
                    "El archivo no contiene registros."
                );

                return;
            }

            int numeroRegistro = 1;

            for (String registro : registros) {

                String[] datos = registro.split(";");

                if (datos.length >= 3) {

                    System.out.println();
                    System.out.println(
                        "ESTUDIANTE " + numeroRegistro
                    );
                    System.out.println(
                        "Documento: " + datos[0]
                    );
                    System.out.println(
                        "Nombre: " + datos[1]
                    );
                    System.out.println(
                        "Programa: " + datos[2]
                    );
                    System.out.println(
                        "----------------------------------"
                    );

                    numeroRegistro++;

                } else {

                    System.out.println();
                    System.out.println(
                        "Registro con formato incorrecto:"
                    );
                    System.out.println(registro);
                }
            }

            System.out.println();
            System.out.println(
                "Total de registros válidos: "
                + (numeroRegistro - 1)
            );

        } catch (IOException excepcion) {

            System.out.println(
                "No fue posible leer el archivo."
            );
            System.out.println(
                "Detalle del error: "
                + excepcion.getMessage()
            );
        }
    }
}
