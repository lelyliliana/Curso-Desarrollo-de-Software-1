package com.lelyliliana.unidad2;

/*
 * TEMA: Constructor de una clase
 *
 * Un constructor es un método especial que se ejecuta
 * automáticamente cuando se crea un objeto.
 */

class Producto {

    // Atributos
    String nombre;
    double precio;
    int cantidad;

    /*
     * Constructor.
     *
     * Tiene el mismo nombre de la clase y no declara
     * ningún tipo de retorno, ni siquiera void.
     */
    Producto(String nombreProducto, double precioProducto, int cantidadProducto) {

        // Guardamos los valores recibidos en los atributos
        nombre = nombreProducto;
        precio = precioProducto;
        cantidad = cantidadProducto;
    }

    // Método que calcula el valor total
    double calcularTotal() {
        return precio * cantidad;
    }

    // Método para mostrar la información
    void mostrarProducto() {
        System.out.println("Producto: " + nombre);
        System.out.println("Precio unitario: $" + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total: $" + calcularTotal());
    }
}

public class U2_03_EjemploConstructor {

    public static void main(String[] args) {

        // Creamos el objeto enviando los datos al constructor
        Producto producto1 = new Producto("Teclado", 85000, 2);

        // Mostramos la información
        producto1.mostrarProducto();
    }
}
