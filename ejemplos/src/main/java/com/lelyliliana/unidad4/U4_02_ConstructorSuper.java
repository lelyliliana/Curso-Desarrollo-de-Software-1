package com.lelyliliana.unidad4;

/*
 * EJEMPLO 2 - UNIDAD 4
 *
 * Tema:
 * Herencia de constructores y uso de super.
 *
 * Los constructores no se heredan directamente.
 *
 * Sin embargo, una clase hija puede llamar el constructor
 * de su clase padre mediante:
 *
 * super();
 *
 * o:
 *
 * super(argumentos);
 *
 * En este ejemplo:
 *
 * PersonaSuper es la clase padre.
 * EstudianteSuper y DocenteSuper son clases hijas.
 */

public class U4_02_ConstructorSuper {

    public static void main(String[] args) {

        System.out.println("CONSTRUCTORES Y USO DE SUPER");
        System.out.println("========================================");

        /*
         * ==================================================
         * CREACIÓN DE UN ESTUDIANTE
         * ==================================================
         *
         * Al crear el objeto EstudianteSuper:
         *
         * 1. Se ejecuta primero el constructor de PersonaSuper.
         * 2. Después se ejecuta el constructor de EstudianteSuper.
         */

        EstudianteSuper estudiante =
                new EstudianteSuper(
                        "Laura Martínez",
                        20,
                        "Ingeniería de Sistemas",
                        3
                );

        System.out.println("\nDATOS DEL ESTUDIANTE");
        System.out.println("----------------------------------------");

        estudiante.mostrarInformacionCompleta();

        /*
         * ==================================================
         * CREACIÓN DE UN DOCENTE
         * ==================================================
         */

        DocenteSuper docente =
                new DocenteSuper(
                        "Carlos Gómez",
                        38,
                        "Desarrollo de Software I",
                        3_800_000.0
                );

        System.out.println("\nDATOS DEL DOCENTE");
        System.out.println("----------------------------------------");

        docente.mostrarInformacionCompleta();

        /*
         * ==================================================
         * USO DE UN CONSTRUCTOR SOBRECARGADO
         * ==================================================
         *
         * También podemos crear una persona enviando
         * únicamente el nombre.
         */

        PersonaSuper persona =
                new PersonaSuper("María Pérez");

        System.out.println("\nPERSONA CON DATOS PARCIALES");
        System.out.println("----------------------------------------");

        persona.mostrarDatosPersonales();

        System.out.println("\nFin del programa.");
    }
}

/*
 * ==================================================
 * CLASE PADRE
 * ==================================================
 */

class PersonaSuper {

    /*
     * Los atributos se declaran private para aplicar
     * encapsulamiento.
     *
     * Las clases hijas no acceden directamente a ellos,
     * sino mediante getters.
     */

    private String nombre;
    private int edad;

    /*
     * ==================================================
     * CONSTRUCTOR SIN PARÁMETROS
     * ==================================================
     *
     * Este constructor asigna valores iniciales.
     */

    public PersonaSuper() {

        nombre = "Sin nombre";
        edad = 0;

        System.out.println(
                "Se ejecutó el constructor sin parámetros "
                        + "de PersonaSuper."
        );
    }

    /*
     * ==================================================
     * CONSTRUCTOR CON UN PARÁMETRO
     * ==================================================
     *
     * this() llama otro constructor de la misma clase.
     *
     * En este caso llamamos:
     *
     * PersonaSuper(String nombre, int edad)
     */

    public PersonaSuper(String nombre) {

        this(nombre, 0);

        System.out.println(
                "Se ejecutó el constructor con nombre "
                        + "de PersonaSuper."
        );
    }

    /*
     * ==================================================
     * CONSTRUCTOR PRINCIPAL
     * ==================================================
     */

    public PersonaSuper(
            String nombre,
            int edad
    ) {

        /*
         * this.nombre hace referencia al atributo.
         *
         * nombre hace referencia al parámetro.
         */

        this.nombre = nombre;
        this.edad = edad;

        System.out.println(
                "Se ejecutó el constructor principal "
                        + "de PersonaSuper."
        );
    }

    /*
     * Getters.
     */

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    /*
     * Método que puede ser utilizado por las clases hijas.
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
     * Método común para las personas.
     */

    public void saludar() {

        System.out.println(
                "Hola, soy " + nombre + "."
        );
    }
}

/*
 * ==================================================
 * CLASE HIJA ESTUDIANTE
 * ==================================================
 */

class EstudianteSuper extends PersonaSuper {

    private String programaAcademico;
    private int semestre;

    /*
     * Constructor de la clase hija.
     */

    public EstudianteSuper(
            String nombre,
            int edad,
            String programaAcademico,
            int semestre
    ) {

        /*
         * super(nombre, edad) llama el constructor
         * de la clase padre PersonaSuper.
         *
         * Debe ser la primera instrucción
         * dentro del constructor.
         */

        super(nombre, edad);

        /*
         * Después de ejecutar el constructor del padre,
         * inicializamos los atributos propios de la hija.
         */

        this.programaAcademico =
                programaAcademico;

        this.semestre = semestre;

        System.out.println(
                "Se ejecutó el constructor "
                        + "de EstudianteSuper."
        );
    }

    /*
     * Método específico del estudiante.
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

    /*
     * Método que combina información heredada
     * con información propia.
     */

    public void mostrarInformacionCompleta() {

        /*
         * super.mostrarDatosPersonales() llama
         * explícitamente el método de la clase padre.
         */

        super.mostrarDatosPersonales();

        mostrarDatosAcademicos();

        /*
         * getNombre() también es un método heredado.
         */

        System.out.println(
                "Mensaje académico: "
                        + super.getNombre()
                        + " está matriculado en "
                        + programaAcademico
                        + "."
        );

        /*
         * También llamamos otro método heredado.
         */

        super.saludar();
    }
}

/*
 * ==================================================
 * CLASE HIJA DOCENTE
 * ==================================================
 */

class DocenteSuper extends PersonaSuper {

    private String asignatura;
    private double salario;

    public DocenteSuper(
            String nombre,
            int edad,
            String asignatura,
            double salario
    ) {

        /*
         * Llamamos el constructor de PersonaSuper.
         */

        super(nombre, edad);

        this.asignatura = asignatura;
        this.salario = salario;

        System.out.println(
                "Se ejecutó el constructor "
                        + "de DocenteSuper."
        );
    }

    public void mostrarDatosLaborales() {

        System.out.println(
                "Asignatura: " + asignatura
        );

        System.out.printf(
                "Salario: $%,.2f%n",
                salario
        );
    }

    public void mostrarInformacionCompleta() {

        /*
         * Llamada explícita al método de la clase padre.
         */

        super.mostrarDatosPersonales();

        mostrarDatosLaborales();

        System.out.println(
                "Mensaje laboral: "
                        + super.getNombre()
                        + " orienta la asignatura "
                        + asignatura
                        + "."
        );

        super.saludar();
    }
}