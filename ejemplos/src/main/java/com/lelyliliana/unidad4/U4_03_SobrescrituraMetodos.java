package com.lelyliliana.unidad4;

/*
 * EJEMPLO 3 - UNIDAD 4
 *
 * Tema:
 * Sobrescritura de métodos con @Override.
 *
 * La sobrescritura ocurre cuando una clase hija
 * redefine un método que ya existe en la clase padre.
 *
 * Para sobrescribir correctamente, el método debe mantener:
 *
 * - El mismo nombre.
 * - La misma cantidad de parámetros.
 * - Los mismos tipos de parámetros.
 * - Un tipo de retorno compatible.
 *
 * La anotación @Override permite que Java verifique
 * que realmente estamos sobrescribiendo un método heredado.
 */

public class U4_03_SobrescrituraMetodos {

    public static void main(String[] args) {

        System.out.println("SOBRESCRITURA DE MÉTODOS");
        System.out.println("========================================");

        /*
         * Creamos un objeto de la clase padre.
         */
        AnimalSobrescritura animal =
                new AnimalSobrescritura(
                        "Animal desconocido"
                );

        /*
         * Creamos objetos de las clases hijas.
         */
        PerroSobrescritura perro =
                new PerroSobrescritura(
                        "Max",
                        "Labrador"
                );

        GatoSobrescritura gato =
                new GatoSobrescritura(
                        "Luna",
                        "Gris"
                );

        AveSobrescritura ave =
                new AveSobrescritura(
                        "Piolín",
                        true
                );

        /*
         * Cada clase tiene un método hacerSonido(),
         * pero su comportamiento es diferente.
         */

        System.out.println("\nCLASE PADRE");
        System.out.println("----------------------------------------");

        animal.mostrarInformacion();
        animal.hacerSonido();

        System.out.println("\nCLASE HIJA PERRO");
        System.out.println("----------------------------------------");

        perro.mostrarInformacion();
        perro.hacerSonido();

        System.out.println("\nCLASE HIJA GATO");
        System.out.println("----------------------------------------");

        gato.mostrarInformacion();
        gato.hacerSonido();

        System.out.println("\nCLASE HIJA AVE");
        System.out.println("----------------------------------------");

        ave.mostrarInformacion();
        ave.hacerSonido();

        /*
         * ==================================================
         * MÉTODO SOBRESCRITO CON RETORNO
         * ==================================================
         *
         * Cada clase calcula una descripción diferente.
         */

        System.out.println("\nDESCRIPCIONES");
        System.out.println("----------------------------------------");

        System.out.println(
                animal.obtenerDescripcion()
        );

        System.out.println(
                perro.obtenerDescripcion()
        );

        System.out.println(
                gato.obtenerDescripcion()
        );

        System.out.println(
                ave.obtenerDescripcion()
        );

        /*
         * ==================================================
         * LLAMADO AL MÉTODO DEL PADRE
         * ==================================================
         *
         * En algunos métodos sobrescritos se utiliza
         * super para conservar parte del comportamiento
         * definido en la clase padre.
         */

        System.out.println("\nALIMENTACIÓN");
        System.out.println("----------------------------------------");

        animal.alimentarse();
        perro.alimentarse();
        gato.alimentarse();
        ave.alimentarse();

        System.out.println("\nFin del programa.");
    }
}

/*
 * ==================================================
 * CLASE PADRE
 * ==================================================
 */

class AnimalSobrescritura {

    private String nombre;

    public AnimalSobrescritura(String nombre) {

        this.nombre = nombre;
    }

    public String getNombre() {

        return nombre;
    }

    /*
     * Este método puede ser sobrescrito
     * por las clases hijas.
     */

    public void hacerSonido() {

        System.out.println(
                nombre + " produce un sonido."
        );
    }

    /*
     * Método que muestra información general.
     */

    public void mostrarInformacion() {

        System.out.println(
                "Nombre: " + nombre
        );

        System.out.println(
                "Tipo: animal"
        );
    }

    /*
     * Método con retorno que también puede
     * ser sobrescrito.
     */

    public String obtenerDescripcion() {

        return nombre
                + " es un animal.";
    }

    /*
     * Método que será sobrescrito parcialmente.
     */

    public void alimentarse() {

        System.out.println(
                nombre + " está comiendo."
        );
    }
}

/*
 * ==================================================
 * CLASE HIJA PERRO
 * ==================================================
 */

class PerroSobrescritura
        extends AnimalSobrescritura {

    private String raza;

    public PerroSobrescritura(
            String nombre,
            String raza
    ) {

        super(nombre);

        this.raza = raza;
    }

    /*
     * @Override indica que este método reemplaza
     * el comportamiento heredado de hacerSonido().
     */

    @Override
    public void hacerSonido() {

        System.out.println(
                getNombre() + " dice: ¡Guau, guau!"
        );
    }

    /*
     * También sobrescribimos mostrarInformacion().
     */

    @Override
    public void mostrarInformacion() {

        System.out.println(
                "Nombre: " + getNombre()
        );

        System.out.println(
                "Tipo: perro"
        );

        System.out.println(
                "Raza: " + raza
        );
    }

    /*
     * Método sobrescrito con retorno.
     */

    @Override
    public String obtenerDescripcion() {

        return getNombre()
                + " es un perro de raza "
                + raza
                + ".";
    }

    /*
     * Utilizamos super.alimentarse() para ejecutar
     * primero el comportamiento de la clase padre.
     *
     * Después agregamos una instrucción específica.
     */

    @Override
    public void alimentarse() {

        super.alimentarse();

        System.out.println(
                getNombre()
                        + " prefiere alimento para perros."
        );
    }
}

/*
 * ==================================================
 * CLASE HIJA GATO
 * ==================================================
 */

class GatoSobrescritura
        extends AnimalSobrescritura {

    private String color;

    public GatoSobrescritura(
            String nombre,
            String color
    ) {

        super(nombre);

        this.color = color;
    }

    @Override
    public void hacerSonido() {

        System.out.println(
                getNombre() + " dice: ¡Miau!"
        );
    }

    @Override
    public void mostrarInformacion() {

        System.out.println(
                "Nombre: " + getNombre()
        );

        System.out.println(
                "Tipo: gato"
        );

        System.out.println(
                "Color: " + color
        );
    }

    @Override
    public String obtenerDescripcion() {

        return getNombre()
                + " es un gato de color "
                + color
                + ".";
    }

    @Override
    public void alimentarse() {

        super.alimentarse();

        System.out.println(
                getNombre()
                        + " prefiere alimento para gatos."
        );
    }
}

/*
 * ==================================================
 * CLASE HIJA AVE
 * ==================================================
 */

class AveSobrescritura
        extends AnimalSobrescritura {

    private boolean puedeVolar;

    public AveSobrescritura(
            String nombre,
            boolean puedeVolar
    ) {

        super(nombre);

        this.puedeVolar = puedeVolar;
    }

    @Override
    public void hacerSonido() {

        System.out.println(
                getNombre() + " dice: ¡Pío, pío!"
        );
    }

    @Override
    public void mostrarInformacion() {

        System.out.println(
                "Nombre: " + getNombre()
        );

        System.out.println(
                "Tipo: ave"
        );

        System.out.println(
                "¿Puede volar?: "
                        + puedeVolar
        );
    }

    @Override
    public String obtenerDescripcion() {

        String capacidadVuelo =
                puedeVolar
                        ? "puede volar"
                        : "no puede volar";

        return getNombre()
                + " es un ave que "
                + capacidadVuelo
                + ".";
    }

    @Override
    public void alimentarse() {

        super.alimentarse();

        System.out.println(
                getNombre()
                        + " se alimenta de semillas."
        );
    }
}