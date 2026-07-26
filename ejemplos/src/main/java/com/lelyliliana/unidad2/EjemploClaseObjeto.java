package com.lelyliliana.unidad2;

/*
 * TEMA: Clases y objetos
 *
 * Una clase es una plantilla que define:
 * - Los atributos o características.
 * - Los métodos o comportamientos.
 *
 * Un objeto es una instancia creada a partir de una clase.
 */

// Clase que representa una persona
class Persona {

    // Atributos de la clase
    String nombre;
    int edad;
    String ciudad;

    // Método que muestra los datos de la persona
    void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Ciudad: " + ciudad);
    }

    // Método que representa una acción de la persona
    void saludar() {
        System.out.println("Hola, mi nombre es " + nombre + ".");
    }
}

// Clase principal
public class EjemploClaseObjeto {

    // Punto de entrada del programa
    public static void main(String[] args) {

        // Creamos un objeto de la clase Persona
        Persona persona1 = new Persona();

        // Asignamos valores a sus atributos
        persona1.nombre = "Leli";
        persona1.edad = 42;
        persona1.ciudad = "Sahagún - Córdoba";

        // Llamamos los métodos del objeto
        persona1.mostrarInformacion();
        persona1.saludar();
    }
}
