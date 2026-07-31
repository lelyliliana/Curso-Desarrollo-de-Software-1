package com.lelyliliana.unidad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * EJEMPLO 10 - UNIDAD 5
 *
 * Tema:
 * Guardar una lista de objetos en un archivo de texto.
 *
 * Este programa crea varios objetos de tipo EstudianteRegistro,
 * los convierte en líneas de texto y los almacena en un archivo.
 */
public class U5_10_GuardarListaObjetos {

    public static void main(String[] args) {

        Path rutaArchivo = Path.of("estudiantes_objetos.txt");

        /*
         * Se crea una lista de objetos.
         */
        List<EstudianteRegistro> estudiantes = List.of(
            new EstudianteRegistro(
                "2001",
                "María Torres",
                "Ingeniería de Sistemas"
            ),
            new EstudianteRegistro(
                "2002",
                "Juan Pérez",
                "Ingeniería Industrial"
            ),
            new EstudianteRegistro(
                "2003",
                "Sofía Gómez",
                "Contaduría Pública"
            )
        );

        /*
         * Esta lista almacenará los objetos convertidos
         * en registros de texto.
         */
        List<String> registros = new ArrayList<>();

        for (EstudianteRegistro estudiante : estudiantes) {
            registros.add(estudiante.convertirARegistro());
        }

        try {

            /*
             * Se escriben todos los registros en el archivo.
             * Cada elemento se almacena en una línea diferente.
             */
            Files.write(rutaArchivo, registros);

            System.out.println("GUARDAR LISTA DE OBJETOS");
            System.out.println("----------------------------------");
            System.out.println("Los estudiantes fueron guardados.");
            System.out.println();
            System.out.println("Archivo:");
            System.out.println(rutaArchivo.toAbsolutePath());

            System.out.println();
            System.out.println("Registros almacenados:");

            for (String registro : registros) {
                System.out.println(registro);
            }

        } catch (IOException excepcion) {

            System.out.println(
                "No fue posible guardar la lista de estudiantes."
            );
            System.out.println(
                "Detalle del error: " + excepcion.getMessage()
            );
        }
    }
}

/**
 * Clase auxiliar que representa un estudiante.
 */
class EstudianteRegistro {

    private String documento;
    private String nombre;
    private String programa;

    public EstudianteRegistro(
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
     * Convierte el objeto en una línea de texto.
     */
    public String convertirARegistro() {

        return documento
            + ";"
            + nombre
            + ";"
            + programa;
    }

    @Override
    public String toString() {

        return "Documento: " + documento
            + ", Nombre: " + nombre
            + ", Programa: " + programa;
    }
}
