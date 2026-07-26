package com.lelyliliana.unidad2;

/*
 * TEMA: Creación de varios objetos
 *
 * Todos los objetos se crean utilizando la misma clase,
 * pero cada uno puede tener valores diferentes.
 */

// Clase que funciona como plantilla
class Estudiante {

    // Atributos
    String nombre;
    String programa;
    double nota;

    // Método para mostrar la información
    void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Programa: " + programa);
        System.out.println("Nota: " + nota);
        System.out.println("--------------------------");
    }
}

// Clase principal
public class VariosObjetos {

    public static void main(String[] args) {

        // Primer objeto
        Estudiante estudiante1 = new Estudiante();

        estudiante1.nombre = "Carlos";
        estudiante1.programa = "Ingeniería de Sistemas";
        estudiante1.nota = 4.5;

        // Segundo objeto
        Estudiante estudiante2 = new Estudiante();

        estudiante2.nombre = "María";
        estudiante2.programa = "Administración";
        estudiante2.nota = 4.2;

        // Tercer objeto
        Estudiante estudiante3 = new Estudiante();

        estudiante3.nombre = "Andrés";
        estudiante3.programa = "Contaduría";
        estudiante3.nota = 3.8;

        // Cada objeto utiliza el mismo método
        estudiante1.mostrarDatos();
        estudiante2.mostrarDatos();
        estudiante3.mostrarDatos();
    }
}