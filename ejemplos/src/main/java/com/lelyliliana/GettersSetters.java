package com.lelyliliana;

/*
 * TEMA: Getters y setters
 *
 * Los atributos se declaran privados para protegerlos.
 *
 * Getter:
 * Permite consultar el valor de un atributo.
 *
 * Setter:
 * Permite modificar el valor de un atributo.
 */

class Empleado {

    // Atributos privados
    private String nombre;
    private double salario;

    // Constructor
    public Empleado(String nombre, double salario) {
        this.nombre = nombre;

        // Utilizamos el setter para validar el salario
        setSalario(salario);
    }

    // Getter para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para modificar el nombre
    public void setNombre(String nombre) {

        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
        }
    }

    // Getter para obtener el salario
    public double getSalario() {
        return salario;
    }

    // Setter para modificar el salario
    public void setSalario(double salario) {

        if (salario >= 0) {
            this.salario = salario;
        } else {
            System.out.println("El salario no puede ser negativo.");
            this.salario = 0;
        }
    }
}

public class GettersSetters {

    public static void main(String[] args) {

        // Creamos un empleado
        Empleado empleado = new Empleado("Pedro Gómez", 2500000);

        // Utilizamos los getters
        System.out.println("Nombre: " + empleado.getNombre());
        System.out.println("Salario inicial: $" + empleado.getSalario());

        // Utilizamos los setters
        empleado.setNombre("Pedro José Gómez");
        empleado.setSalario(2800000);

        // Mostramos los datos modificados
        System.out.println("\nInformación actualizada:");
        System.out.println("Nombre: " + empleado.getNombre());
        System.out.println("Salario: $" + empleado.getSalario());

        // Intentamos asignar un salario incorrecto
        empleado.setSalario(-500000);
    }
}