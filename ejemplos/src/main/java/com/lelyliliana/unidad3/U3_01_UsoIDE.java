package com.lelyliliana.unidad3;

/*
 * EJEMPLO 1 - UNIDAD 3
 *
 * Tema:
 * Uso del IDE y organización de un proyecto Java.
 *
 * Este archivo permite explicar:
 *
 * - La declaración del paquete.
 * - La relación entre carpetas y paquetes.
 * - El método main.
 * - La creación y llamado de métodos.
 * - El autocompletado del IDE.
 * - La detección de errores.
 * - La ejecución del programa.
 */

/*
 * La clase pública debe tener el mismo nombre del archivo.
 *
 * Archivo:
 * UsoIDE.java
 *
 * Clase:
 * UsoIDE
 */
public class U3_01_UsoIDE {

    /*
     * El método main es el punto de inicio del programa.
     *
     * Desde el IDE se puede ejecutar utilizando:
     *
     * - El botón Run.
     * - La opción Run Java.
     * - El menú contextual.
     * - La terminal.
     */
    public static void main(String[] args) {

        System.out.println("USO DEL IDE");
        System.out.println("--------------------------------");

        /*
         * Llamamos diferentes métodos para mostrar
         * que el programa puede organizarse en secciones.
         */
        mostrarEstructuraProyecto();
        mostrarFuncionesIDE();
        mostrarDatosPrograma();

        /*
         * Creamos variables para utilizar otro método.
         */
        int numero1 = 15;
        int numero2 = 8;

        int resultado = sumar(numero1, numero2);

        System.out.println("\nOPERACIÓN");
        System.out.println("--------------------------------");

        System.out.println(
                numero1 + " + " + numero2 + " = " + resultado
        );

        System.out.println("\nFin del programa.");
    }

    /*
     * Método que explica la estructura del proyecto.
     */
    public static void mostrarEstructuraProyecto() {

        System.out.println("\nESTRUCTURA DEL PROYECTO");
        System.out.println("--------------------------------");

        System.out.println("Carpeta principal: ejemplos");
        System.out.println("Código fuente: src/main/java");

        System.out.println(
                "Paquete: com.lelyliliana.unidad3"
        );

        System.out.println(
                "Archivo: UsoIDE.java"
        );

        /*
         * La estructura de carpetas debe coincidir
         * con la declaración package.
         *
         * Carpeta:
         *
         * com/lelyliliana/unidad3
         *
         * Declaración:
         *
         * package com.lelyliliana.unidad3;
         */
    }

    /*
     * Método que presenta algunas funciones del IDE.
     */
    public static void mostrarFuncionesIDE() {

        System.out.println("\nFUNCIONES DEL IDE");
        System.out.println("--------------------------------");

        System.out.println(
                "1. Escribir y editar código."
        );

        System.out.println(
                "2. Resaltar la sintaxis."
        );

        System.out.println(
                "3. Detectar errores."
        );

        System.out.println(
                "4. Sugerir instrucciones con autocompletado."
        );

        System.out.println(
                "5. Organizar importaciones."
        );

        System.out.println(
                "6. Ejecutar y depurar programas."
        );

        System.out.println(
                "7. Navegar entre clases y métodos."
        );
    }

    /*
     * Método para mostrar información del programa.
     */
    public static void mostrarDatosPrograma() {

        String lenguaje = "Java";
        String ide = "Visual Studio Code";
        int versionJdk = 21;

        System.out.println("\nDATOS DEL ENTORNO");
        System.out.println("--------------------------------");

        System.out.println(
                "Lenguaje: " + lenguaje
        );

        System.out.println(
                "IDE utilizado: " + ide
        );

        System.out.println(
                "Versión del JDK: " + versionJdk
        );
    }

    /*
     * Método que recibe dos números y retorna la suma.
     *
     * El IDE puede ayudar a:
     *
     * - Autocompletar el nombre del método.
     * - Mostrar los parámetros esperados.
     * - Indicar el tipo de retorno.
     * - Detectar si falta un argumento.
     */
    public static int sumar(int numero1, int numero2) {

        return numero1 + numero2;
    }
}