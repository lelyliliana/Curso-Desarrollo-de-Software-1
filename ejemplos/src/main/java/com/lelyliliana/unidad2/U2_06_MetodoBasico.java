package com.lelyliliana.unidad2;

/*
 * TEMA: Definición y llamada de métodos
 *
 * Un método contiene instrucciones para realizar
 * una tarea específica.
 */

public class U2_06_MetodoBasico {

    /*
     * Método llamado mostrarMensaje.
     *
     * public: puede llamarse desde otras clases.
     * void: no retorna ningún resultado.
     */
    public void mostrarMensaje() {
        System.out.println("Estoy aprendiendo métodos en Java.");
    }

    public static void main(String[] args) {

        // Creamos un objeto de la clase
        U2_06_MetodoBasico ejemplo = new U2_06_MetodoBasico();

        // Llamamos el método
        ejemplo.mostrarMensaje();

        // Podemos reutilizarlo llamándolo nuevamente
        ejemplo.mostrarMensaje();
    }
}
