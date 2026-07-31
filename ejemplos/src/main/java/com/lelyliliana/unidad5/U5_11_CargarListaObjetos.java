package com.lelyliliana.unidad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * EJEMPLO 11 - UNIDAD 5
 *
 * Tema:
 * Recuperar objetos desde un archivo de texto.
 *
 * Este programa lee cada línea del archivo,
 * separa sus datos y crea objetos de tipo
 * EstudianteCargado.
 */
public class U5_11_CargarListaObjetos {

    public static void main(String[] args) {

        Path rutaArchivo = Path.of("estudiantes_objetos.txt");

        System.out.println("CARGAR LISTA DE OBJETOS");
        System.out.println("----------------------------------");

        if (!Files.exists(rutaArchivo)) {

            System.out.println(
                "El archivo estudiantes_objetos.txt no existe."
            );
            System.out.println(
                "Primero ejecute U5_10_GuardarListaObjetos."
            );

            return;
        }

        try {

            /*
             * Se leen todas las líneas almacenadas.
             */
            List<String> registros =
                Files.readAllLines(rutaArchivo);

            /*
             * Esta lista almacenará los objetos
             * construidos a partir de cada registro.
             */
            List<EstudianteCargado> estudiantes =
                new ArrayList<>();

            for (String registro : registros) {

                try {

                    EstudianteCargado estudiante =
                        EstudianteCargado.crearDesdeRegistro(
                            registro
                        );

                    estudiantes.add(estudiante);

                } catch (IllegalArgumentException excepcion) {

                    System.out.println(
                        "Registro ignorado por formato incorrecto:"
                    );
                    System.out.println(registro);
                }
            }

            System.out.println(
                "Cantidad de objetos recuperados: "
                + estudiantes.size()
            );

            System.out.println();
            System.out.println("Estudiantes cargados:");

            for (EstudianteCargado estudiante : estudiantes) {

                System.out.println();
                System.out.println(estudiante);
                System.out.println(
                    "----------------------------------"
                );
            }

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

/**
 * Clase auxiliar que representa un estudiante
 * recuperado desde un archivo.
 */
class EstudianteCargado {

    private String documento;
    private String nombre;
    private String programa;

    public EstudianteCargado(
        String documento,
        String nombre,
        String programa
    ) {

        this.documento = documento;
        this.nombre = nombre;
        this.programa = programa;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrograma() {
        return programa;
    }

    /**
     * Crea un objeto a partir de una línea
     * con formato documento;nombre;programa.
     */
    public static EstudianteCargado crearDesdeRegistro(
        String registro
    ) {

        String[] datos = registro.split(";");

        if (datos.length < 3) {

            throw new IllegalArgumentException(
                "El registro no tiene el formato correcto."
            );
        }

        return new EstudianteCargado(
            datos[0],
            datos[1],
            datos[2]
        );
    }

    @Override
    public String toString() {

        return "Documento: " + documento
            + "\nNombre: " + nombre
            + "\nPrograma: " + programa;
    }
}
