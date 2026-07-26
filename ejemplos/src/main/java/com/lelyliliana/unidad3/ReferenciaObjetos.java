package com.lelyliliana.unidad3;

/*
 * EJEMPLO 14 - UNIDAD 3
 *
 * Tema:
 * Comportamiento de objetos al enviarlos a métodos.
 *
 * Java siempre trabaja con paso por valor.
 *
 * Cuando enviamos un objeto a un método, no se copia
 * el objeto completo. Se copia el valor de la referencia
 * que permite acceder al mismo objeto.
 *
 * Por eso:
 *
 * - El método puede modificar los atributos del objeto.
 * - Los cambios en los atributos se observan fuera del método.
 * - Si el método asigna la referencia a otro objeto,
 *   la variable original no cambia.
 */

public class ReferenciaObjetos {

    public static void main(String[] args) {

        System.out.println("REFERENCIAS DE OBJETOS");
        System.out.println("----------------------------------------");

        /*
         * ==================================================
         * CREACIÓN DEL OBJETO
         * ==================================================
         */

        Estudiante estudiante =
                new Estudiante(
                        "Laura Martínez",
                        20,
                        4.2
                );

        System.out.println("DATOS INICIALES");
        System.out.println("----------------------------------------");

        estudiante.mostrarInformacion();

        /*
         * ==================================================
         * MODIFICACIÓN DE ATRIBUTOS DESDE UN MÉTODO
         * ==================================================
         *
         * Se envía una copia de la referencia.
         *
         * Tanto la variable estudiante como el parámetro
         * recibido por el método permiten acceder
         * al mismo objeto.
         */

        modificarPromedio(estudiante);

        System.out.println("\nDESPUÉS DE MODIFICAR EL PROMEDIO");
        System.out.println("----------------------------------------");

        /*
         * El cambio se conserva porque se modificó
         * el mismo objeto.
         */
        estudiante.mostrarInformacion();

        /*
         * ==================================================
         * MODIFICACIÓN DE VARIOS ATRIBUTOS
         * ==================================================
         */

        actualizarDatos(
                estudiante,
                "Laura María Martínez",
                21
        );

        System.out.println("\nDESPUÉS DE ACTUALIZAR LOS DATOS");
        System.out.println("----------------------------------------");

        estudiante.mostrarInformacion();

        /*
         * ==================================================
         * REASIGNACIÓN DE LA REFERENCIA
         * ==================================================
         *
         * Este método intentará reemplazar el objeto
         * por uno nuevo.
         *
         * Sin embargo, la variable original no cambiará.
         */

        reemplazarEstudiante(estudiante);

        System.out.println("\nDESPUÉS DE INTENTAR REEMPLAZAR EL OBJETO");
        System.out.println("----------------------------------------");

        /*
         * La variable estudiante sigue apuntando
         * al objeto original.
         */
        estudiante.mostrarInformacion();

        /*
         * ==================================================
         * RETORNAR UN NUEVO OBJETO
         * ==================================================
         *
         * Para reemplazar realmente el objeto,
         * el método puede retornar uno nuevo.
         */

        estudiante = crearNuevoEstudiante();

        System.out.println("\nDESPUÉS DE ASIGNAR EL OBJETO RETORNADO");
        System.out.println("----------------------------------------");

        estudiante.mostrarInformacion();

        /*
         * ==================================================
         * DOS VARIABLES CON LA MISMA REFERENCIA
         * ==================================================
         */

        Estudiante estudiante2 = estudiante;

        System.out.println("\nDOS VARIABLES, UN MISMO OBJETO");
        System.out.println("----------------------------------------");

        /*
         * estudiante y estudiante2 contienen copias
         * del mismo valor de referencia.
         */
        estudiante2.setPromedio(5.0);

        System.out.println(
                "Datos consultados desde estudiante:"
        );

        estudiante.mostrarInformacion();

        System.out.println(
                "\nDatos consultados desde estudiante2:"
        );

        estudiante2.mostrarInformacion();

        System.out.println("\nFin del programa.");
    }

    /*
     * ==================================================
     * MÉTODO QUE MODIFICA UN ATRIBUTO
     * ==================================================
     */

    public static void modificarPromedio(
            Estudiante estudianteRecibido
    ) {

        System.out.println("\nDENTRO DE modificarPromedio()");
        System.out.println("----------------------------------------");

        estudianteRecibido.setPromedio(4.8);

        System.out.println(
                "El promedio fue modificado dentro del método."
        );
    }

    /*
     * ==================================================
     * MÉTODO QUE ACTUALIZA VARIOS ATRIBUTOS
     * ==================================================
     */

    public static void actualizarDatos(
            Estudiante estudianteRecibido,
            String nuevoNombre,
            int nuevaEdad
    ) {

        estudianteRecibido.setNombre(nuevoNombre);
        estudianteRecibido.setEdad(nuevaEdad);
    }

    /*
     * ==================================================
     * MÉTODO QUE REASIGNA LA REFERENCIA
     * ==================================================
     *
     * El parámetro recibe una copia de la referencia.
     *
     * Al asignarle un nuevo objeto, solo cambia
     * la referencia local del método.
     */

    public static void reemplazarEstudiante(
            Estudiante estudianteRecibido
    ) {

        estudianteRecibido =
                new Estudiante(
                        "Carlos Pérez",
                        25,
                        3.5
                );

        System.out.println(
                "Objeto dentro de reemplazarEstudiante():"
        );

        estudianteRecibido.mostrarInformacion();
    }

    /*
     * ==================================================
     * MÉTODO QUE RETORNA UN NUEVO OBJETO
     * ==================================================
     */

    public static Estudiante crearNuevoEstudiante() {

        return new Estudiante(
                "María Gómez",
                22,
                4.6
        );
    }
}

/*
 * Clase utilizada para representar un estudiante.
 */
class Estudiante {

    private String nombre;
    private int edad;
    private double promedio;

    /*
     * Constructor.
     */
    public Estudiante(
            String nombre,
            int edad,
            double promedio
    ) {

        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    /*
     * Getters y setters.
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    /*
     * Método para mostrar la información.
     */
    public void mostrarInformacion() {

        System.out.println(
                "Nombre: " + nombre
        );

        System.out.println(
                "Edad: " + edad
        );

        System.out.println(
                "Promedio: " + promedio
        );
    }
}