package com.lelyliliana.unidad4;

/*
 * EJEMPLO 1 - UNIDAD 4
 *
 * Tema:
 * Herencia básica en Java.
 *
 * La herencia permite crear una clase nueva
 * a partir de otra clase existente.
 *
 * La clase existente se conoce como:
 *
 * - Clase padre.
 * - Superclase.
 * - Clase base.
 *
 * La clase nueva se conoce como:
 *
 * - Clase hija.
 * - Subclase.
 * - Clase derivada.
 *
 * En este ejemplo:
 *
 * Persona es la clase padre.
 * Estudiante y Docente son clases hijas.
 */

public class U4_01_HerenciaBasica {

    public static void main(String[] args) {

        System.out.println("HERENCIA BÁSICA EN JAVA");
        System.out.println("========================================");

        /*
         * Creamos un objeto de la clase Estudiante.
         *
         * Estudiante hereda los atributos y métodos
         * definidos en Persona.
         */
        Estudiante estudiante =
                new Estudiante();

        /*
         * Estos atributos fueron heredados
         * desde la clase Persona.
         */
        estudiante.nombre = "Laura Martínez";
        estudiante.edad = 20;

        /*
         * Este atributo pertenece únicamente
         * a la clase Estudiante.
         */
        estudiante.programaAcademico =
                "Ingeniería de Sistemas";

        estudiante.semestre = 3;

        System.out.println("\nDATOS DEL ESTUDIANTE");
        System.out.println("----------------------------------------");

        /*
         * Este método fue heredado de Persona.
         */
        estudiante.mostrarDatosPersonales();

        /*
         * Este método pertenece a Estudiante.
         */
        estudiante.mostrarDatosAcademicos();

        /*
         * Estudiante también puede utilizar otros
         * métodos heredados de Persona.
         */
        estudiante.saludar();

        /*
         * ==================================================
         * OBJETO DE LA CLASE DOCENTE
         * ==================================================
         */

        Docente docente =
                new Docente();

        /*
         * Atributos heredados de Persona.
         */
        docente.nombre = "Carlos Gómez";
        docente.edad = 35;

        /*
         * Atributos propios de Docente.
         */
        docente.asignatura =
                "Desarrollo de Software I";

        docente.salario = 3_500_000.0;

        System.out.println("\nDATOS DEL DOCENTE");
        System.out.println("----------------------------------------");

        docente.mostrarDatosPersonales();
        docente.mostrarDatosLaborales();
        docente.saludar();

        /*
         * ==================================================
         * RELACIÓN "ES UN"
         * ==================================================
         *
         * Un Estudiante es una Persona.
         *
         * Un Docente es una Persona.
         *
         * Por eso ambos pueden utilizar los elementos
         * heredados de Persona.
         */

        System.out.println("\nRELACIÓN DE HERENCIA");
        System.out.println("----------------------------------------");

        System.out.println(
                "Un estudiante es una persona."
        );

        System.out.println(
                "Un docente es una persona."
        );

        /*
         * Podemos comprobar la relación con instanceof.
         */

        System.out.println(
                "¿estudiante es una Persona?: "
                        + (estudiante instanceof Persona)
        );

        System.out.println(
                "¿docente es una Persona?: "
                        + (docente instanceof Persona)
        );

        System.out.println(
                "¿estudiante es un Estudiante?: "
                        + (estudiante instanceof Estudiante)
        );

        System.out.println("\nFin del programa.");
    }
}

/*
 * ==================================================
 * CLASE PADRE
 * ==================================================
 *
 * Contiene atributos y métodos comunes para
 * estudiantes y docentes.
 */

class Persona {

    /*
     * Se utilizan atributos protected para que puedan
     * ser accedidos desde las clases hijas.
     *
     * Más adelante se recomienda reforzar
     * el encapsulamiento con atributos private
     * y métodos getters y setters.
     */

    protected String nombre;
    protected int edad;

    /*
     * Método común para todas las personas.
     */

    public void mostrarDatosPersonales() {

        System.out.println(
                "Nombre: " + nombre
        );

        System.out.println(
                "Edad: " + edad + " años"
        );
    }

    /*
     * Otro método heredable.
     */

    public void saludar() {

        System.out.println(
                "Hola, mi nombre es " + nombre + "."
        );
    }
}

/*
 * ==================================================
 * CLASE HIJA ESTUDIANTE
 * ==================================================
 *
 * extends indica que Estudiante hereda de Persona.
 */

class Estudiante extends Persona {

    /*
     * Atributos específicos de un estudiante.
     */

    String programaAcademico;
    int semestre;

    /*
     * Método específico de Estudiante.
     */

    public void mostrarDatosAcademicos() {

        System.out.println(
                "Programa académico: "
                        + programaAcademico
        );

        System.out.println(
                "Semestre: " + semestre
        );
    }
}

/*
 * ==================================================
 * CLASE HIJA DOCENTE
 * ==================================================
 */

class Docente extends Persona {

    /*
     * Atributos específicos de un docente.
     */

    String asignatura;
    double salario;

    /*
     * Método específico de Docente.
     */

    public void mostrarDatosLaborales() {

        System.out.println(
                "Asignatura: " + asignatura
        );

        System.out.printf(
                "Salario: $%,.2f%n",
                salario
        );
    }
}