package com.lelyliliana.unidad2;

/*
 * TEMA: Clases y métodos abstractos
 *
 * Una clase abstracta funciona como una clase base.
 *
 * Un método abstracto se declara sin instrucciones.
 * Las clases hijas están obligadas a implementarlo.
 */

// Clase abstracta
abstract class Figura {

    // Atributo protegido
    protected String nombre;

    // Constructor
    public Figura(String nombre) {
        this.nombre = nombre;
    }

    /*
     * Método abstracto.
     *
     * No contiene cuerpo.
     * Cada clase hija debe indicar cómo calcular su área.
     */
    public abstract double calcularArea();

    // Método normal
    public void mostrarNombre() {
        System.out.println("Figura: " + nombre);
    }
}

// Clase hija
class Rectangulo extends Figura {

    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        super("Rectángulo");
        this.base = base;
        this.altura = altura;
    }

    // Implementación obligatoria del método abstracto
    @Override
    public double calcularArea() {
        return base * altura;
    }
}

// Otra clase hija
class Circulo extends Figura {

    private double radio;

    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }

    // Implementación específica para el círculo
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

public class ClasesAbstractas {

    public static void main(String[] args) {

        // Creamos un objeto Rectangulo
        Rectangulo rectangulo = new Rectangulo(8, 4);

        rectangulo.mostrarNombre();

        System.out.println(
                "Área: " + rectangulo.calcularArea()
        );

        System.out.println("--------------------------");

        // Creamos un objeto Circulo
        Circulo circulo = new Circulo(5);

        circulo.mostrarNombre();

        System.out.printf(
                "Área: %.2f%n",
                circulo.calcularArea()
        );

        /*
         * No se puede crear directamente un objeto de Figura:
         *
         * Figura figura = new Figura("Figura");
         *
         * Esto genera error porque Figura es abstracta.
         */
    }
}
