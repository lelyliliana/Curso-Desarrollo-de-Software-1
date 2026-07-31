package com.lelyliliana.unidad5;

/**
 * EJEMPLO 9 - UNIDAD 5
 *
 * Tema:
 * Conversión entre objetos y registros de texto.
 *
 * Este programa muestra cómo representar un estudiante
 * mediante una clase y cómo convertir sus datos:
 *
 * - De objeto a una línea de texto.
 * - De una línea de texto a un objeto.
 */
public class U5_09_ObjetoEstudianteArchivo {

    public static void main(String[] args) {

        /*
         * Se crea un objeto de tipo EstudianteUnidad5.
         */
        EstudianteUnidad5 estudiante = new EstudianteUnidad5(
            "1001",
            "Laura Martínez",
            "Ingeniería de Sistemas"
        );

        System.out.println("OBJETO Y REGISTRO DE TEXTO");
        System.out.println("----------------------------------");

        System.out.println("Datos del objeto:");
        System.out.println(estudiante);

        /*
         * El objeto se convierte en una línea de texto
         * separada por punto y coma.
         */
        String registroTexto = estudiante.convertirARegistro();

        System.out.println();
        System.out.println("Objeto convertido a texto:");
        System.out.println(registroTexto);

        /*
         * Ahora se construye un nuevo objeto
         * a partir del registro de texto.
         */
        EstudianteUnidad5 estudianteRecuperado =
            EstudianteUnidad5.crearDesdeRegistro(registroTexto);

        System.out.println();
        System.out.println("Objeto recuperado desde el texto:");
        System.out.println(estudianteRecuperado);
    }
}

/**
 * Clase que representa un estudiante.
 */
class EstudianteUnidad5 {

    private String documento;
    private String nombre;
    private String programa;

    public EstudianteUnidad5(
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

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
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

    /**
     * Crea un objeto a partir de una línea de texto.
     */
    public static EstudianteUnidad5 crearDesdeRegistro(
        String registro
    ) {

        String[] datos = registro.split(";");

        if (datos.length < 3) {

            throw new IllegalArgumentException(
                "El registro no tiene el formato correcto."
            );
        }

        return new EstudianteUnidad5(
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
