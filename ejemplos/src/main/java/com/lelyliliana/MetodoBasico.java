package com.lelyliliana;

/*
 * TEMA: Definición y llamada de métodos
 *
 * Un método contiene instrucciones para realizar
 * una tarea específica.
 */

public class MetodoBasico {

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
        MetodoBasico ejemplo = new MetodoBasico();

        // Llamamos el método
        ejemplo.mostrarMensaje();

        // Podemos reutilizarlo llamándolo nuevamente
        ejemplo.mostrarMensaje();
    }
}
