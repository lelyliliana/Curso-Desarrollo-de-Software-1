package com.lelyliliana.unidad4;

/*
 * EJEMPLO 5 - UNIDAD 4
 *
 * Tema:
 * Lista polimórfica con ArrayList.
 *
 * Una lista polimórfica almacena referencias
 * de una clase padre, pero puede contener objetos
 * de diferentes clases hijas.
 *
 * En este ejemplo:
 *
 * FiguraLista es la clase padre.
 *
 * RectanguloLista,
 * CirculoLista y
 * TrianguloLista son clases hijas.
 *
 * Todas sobrescriben:
 *
 * - calcularArea()
 * - calcularPerimetro()
 * - mostrarInformacion()
 */

import java.util.ArrayList;

public class U4_05_ListaPolimorfica {

    public static void main(String[] args) {

        System.out.println("LISTA POLIMÓRFICA");
        System.out.println("========================================");

        /*
         * ==================================================
         * CREACIÓN DE LA LISTA
         * ==================================================
         *
         * La lista se declara para almacenar referencias
         * de tipo FiguraLista.
         *
         * Como RectanguloLista, CirculoLista y TrianguloLista
         * heredan de FiguraLista, sus objetos pueden
         * almacenarse en esta colección.
         */

        ArrayList<FiguraLista> figuras =
                new ArrayList<>();

        /*
         * ==================================================
         * AGREGAR OBJETOS DE DIFERENTES CLASES
         * ==================================================
         */

        figuras.add(
                new RectanguloLista(
                        "Rectángulo principal",
                        8.0,
                        4.0
                )
        );

        figuras.add(
                new CirculoLista(
                        "Círculo central",
                        5.0
                )
        );

        figuras.add(
                new TrianguloLista(
                        "Triángulo lateral",
                        6.0,
                        4.0,
                        5.0,
                        5.0
                )
        );

        figuras.add(
                new RectanguloLista(
                        "Rectángulo secundario",
                        10.0,
                        3.0
                )
        );

        System.out.println(
                "Cantidad de figuras almacenadas: "
                        + figuras.size()
        );

        /*
         * ==================================================
         * RECORRIDO POLIMÓRFICO
         * ==================================================
         *
         * La variable figura tiene tipo FiguraLista.
         *
         * En cada repetición puede contener un objeto
         * de una clase hija diferente.
         */

        System.out.println("\nLISTA DE FIGURAS");
        System.out.println("----------------------------------------");

        for (FiguraLista figura : figuras) {

            /*
             * Java ejecuta el método sobrescrito
             * correspondiente al objeto real.
             */

            figura.mostrarInformacion();

            System.out.printf(
                    "Área: %.2f%n",
                    figura.calcularArea()
            );

            System.out.printf(
                    "Perímetro: %.2f%n",
                    figura.calcularPerimetro()
            );

            System.out.println(
                    "Tipo real: "
                            + figura
                            .getClass()
                            .getSimpleName()
            );

            System.out.println("----------------------------------------");
        }

        /*
         * ==================================================
         * ACUMULADORES POLIMÓRFICOS
         * ==================================================
         *
         * Sumamos las áreas y perímetros de todas las figuras.
         *
         * No necesitamos preguntar qué tipo de figura es.
         * Cada objeto sabe cómo realizar su propio cálculo.
         */

        double areaTotal = 0.0;
        double perimetroTotal = 0.0;

        for (FiguraLista figura : figuras) {

            areaTotal += figura.calcularArea();

            perimetroTotal +=
                    figura.calcularPerimetro();
        }

        System.out.println("\nRESULTADOS GENERALES");
        System.out.println("----------------------------------------");

        System.out.printf(
                "Área total: %.2f%n",
                areaTotal
        );

        System.out.printf(
                "Perímetro total: %.2f%n",
                perimetroTotal
        );

        /*
         * ==================================================
         * CONTAR OBJETOS POR TIPO
         * ==================================================
         */

        int cantidadRectangulos = 0;
        int cantidadCirculos = 0;
        int cantidadTriangulos = 0;

        for (FiguraLista figura : figuras) {

            if (figura instanceof RectanguloLista) {

                cantidadRectangulos++;

            } else if (figura instanceof CirculoLista) {

                cantidadCirculos++;

            } else if (figura instanceof TrianguloLista) {

                cantidadTriangulos++;
            }
        }

        System.out.println("\nCANTIDAD POR TIPO");
        System.out.println("----------------------------------------");

        System.out.println(
                "Rectángulos: " + cantidadRectangulos
        );

        System.out.println(
                "Círculos: " + cantidadCirculos
        );

        System.out.println(
                "Triángulos: " + cantidadTriangulos
        );

        /*
         * ==================================================
         * BÚSQUEDA DE LA FIGURA CON MAYOR ÁREA
         * ==================================================
         */

        FiguraLista figuraMayorArea = null;

        for (FiguraLista figura : figuras) {

            if (
                    figuraMayorArea == null
                            || figura.calcularArea()
                            > figuraMayorArea.calcularArea()
            ) {

                figuraMayorArea = figura;
            }
        }

        System.out.println("\nFIGURA CON MAYOR ÁREA");
        System.out.println("----------------------------------------");

        if (figuraMayorArea != null) {

            figuraMayorArea.mostrarInformacion();

            System.out.printf(
                    "Área: %.2f%n",
                    figuraMayorArea.calcularArea()
            );
        }

        /*
         * ==================================================
         * ACCESO A MÉTODOS ESPECÍFICOS
         * ==================================================
         *
         * Una referencia de tipo FiguraLista solo permite
         * llamar directamente los métodos declarados
         * en FiguraLista.
         *
         * Para llamar un método exclusivo de una clase hija,
         * debemos comprobar el tipo real con instanceof.
         */

        System.out.println("\nMÉTODOS ESPECÍFICOS");
        System.out.println("----------------------------------------");

        for (FiguraLista figura : figuras) {

            /*
             * Pattern matching con instanceof.
             *
             * Si figura es un RectanguloLista,
             * Java crea la variable rectangulo.
             */

            if (
                    figura
                            instanceof RectanguloLista rectangulo
            ) {

                rectangulo.mostrarDimensiones();

            } else if (
                    figura
                            instanceof CirculoLista circulo
            ) {

                circulo.mostrarDiametro();

            } else if (
                    figura
                            instanceof TrianguloLista triangulo
            ) {

                triangulo.mostrarTipoTriangulo();
            }

            System.out.println("----------------------------------------");
        }

        /*
         * ==================================================
         * MÉTODO POLIMÓRFICO QUE RECIBE LA LISTA
         * ==================================================
         */

        mostrarResumen(figuras);

        System.out.println("\nFin del programa.");
    }

    /*
     * Método que recibe una lista de la clase padre.
     *
     * Puede procesar cualquier objeto cuya clase
     * herede de FiguraLista.
     */

    public static void mostrarResumen(
            ArrayList<FiguraLista> figuras
    ) {

        System.out.println("\nRESUMEN POLIMÓRFICO");
        System.out.println("----------------------------------------");

        for (FiguraLista figura : figuras) {

            System.out.printf(
                    "%s | Área: %.2f | Perímetro: %.2f%n",
                    figura.getNombre(),
                    figura.calcularArea(),
                    figura.calcularPerimetro()
            );
        }
    }
}

/*
 * ==================================================
 * CLASE PADRE
 * ==================================================
 */

class FiguraLista {

    private String nombre;

    public FiguraLista(String nombre) {

        this.nombre = nombre;
    }

    public String getNombre() {

        return nombre;
    }

    /*
     * En este ejemplo la clase padre proporciona
     * implementaciones generales.
     *
     * Las clases hijas las sobrescriben.
     */

    public double calcularArea() {

        return 0.0;
    }

    public double calcularPerimetro() {

        return 0.0;
    }

    public void mostrarInformacion() {

        System.out.println(
                "Figura: " + nombre
        );
    }
}

/*
 * ==================================================
 * CLASE HIJA RECTÁNGULO
 * ==================================================
 */

class RectanguloLista extends FiguraLista {

    private double base;
    private double altura;

    public RectanguloLista(
            String nombre,
            double base,
            double altura
    ) {

        super(nombre);

        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {

        return base * altura;
    }

    @Override
    public double calcularPerimetro() {

        return 2 * (base + altura);
    }

    @Override
    public void mostrarInformacion() {

        System.out.println(
                "Figura: " + getNombre()
        );

        System.out.println(
                "Tipo: rectángulo"
        );

        System.out.println(
                "Base: " + base
        );

        System.out.println(
                "Altura: " + altura
        );
    }

    /*
     * Método exclusivo de RectanguloLista.
     */

    public void mostrarDimensiones() {

        System.out.println(
                getNombre()
                        + " tiene una base de "
                        + base
                        + " y una altura de "
                        + altura
                        + "."
        );
    }
}

/*
 * ==================================================
 * CLASE HIJA CÍRCULO
 * ==================================================
 */

class CirculoLista extends FiguraLista {

    private double radio;

    public CirculoLista(
            String nombre,
            double radio
    ) {

        super(nombre);

        this.radio = radio;
    }

    @Override
    public double calcularArea() {

        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro() {

        return 2 * Math.PI * radio;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println(
                "Figura: " + getNombre()
        );

        System.out.println(
                "Tipo: círculo"
        );

        System.out.println(
                "Radio: " + radio
        );
    }

    /*
     * Método exclusivo de CirculoLista.
     */

    public void mostrarDiametro() {

        double diametro = radio * 2;

        System.out.println(
                getNombre()
                        + " tiene un diámetro de "
                        + diametro
                        + "."
        );
    }
}

/*
 * ==================================================
 * CLASE HIJA TRIÁNGULO
 * ==================================================
 */

class TrianguloLista extends FiguraLista {

    private double base;
    private double altura;
    private double lado1;
    private double lado2;

    public TrianguloLista(
            String nombre,
            double base,
            double altura,
            double lado1,
            double lado2
    ) {

        super(nombre);

        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public double calcularArea() {

        return base * altura / 2;
    }

    @Override
    public double calcularPerimetro() {

        return base + lado1 + lado2;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println(
                "Figura: " + getNombre()
        );

        System.out.println(
                "Tipo: triángulo"
        );

        System.out.println(
                "Base: " + base
        );

        System.out.println(
                "Altura: " + altura
        );

        System.out.println(
                "Lados: "
                        + base
                        + ", "
                        + lado1
                        + ", "
                        + lado2
        );
    }

    /*
     * Método exclusivo de TrianguloLista.
     */

    public void mostrarTipoTriangulo() {

        String tipo;

        if (
                base == lado1
                        && lado1 == lado2
        ) {

            tipo = "equilátero";

        } else if (
                base == lado1
                        || base == lado2
                        || lado1 == lado2
        ) {

            tipo = "isósceles";

        } else {

            tipo = "escaleno";
        }

        System.out.println(
                getNombre()
                        + " es un triángulo "
                        + tipo
                        + "."
        );
    }
}