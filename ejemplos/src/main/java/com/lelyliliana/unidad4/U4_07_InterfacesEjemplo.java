package com.lelyliliana.unidad4;

/*
 * EJEMPLO 7 - UNIDAD 4
 *
 * Tema:
 * Declaración e implementación de interfaces.
 *
 * Una interfaz define un contrato.
 *
 * Esto significa que establece qué métodos debe
 * implementar una clase, pero no necesariamente
 * cómo debe hacerlo.
 *
 * En este ejemplo:
 *
 * Pagable es una interfaz.
 *
 * FacturaInterfaz y NominaInterfaz implementan Pagable.
 *
 * Ambas clases deben implementar:
 *
 * calcularPago()
 * mostrarDetallePago()
 */

public class U4_07_InterfacesEjemplo {

    public static void main(String[] args) {

        System.out.println("INTERFACES EN JAVA");
        System.out.println("========================================");

        /*
         * ==================================================
         * OBJETO FACTURA
         * ==================================================
         */

        FacturaInterfaz factura =
                new FacturaInterfaz(
                        "FAC-001",
                        "Computador portátil",
                        2,
                        2_500_000.0
                );

        System.out.println("\nFACTURA");
        System.out.println("----------------------------------------");

        factura.mostrarDetallePago();

        System.out.printf(
                "Valor total: $%,.2f%n",
                factura.calcularPago()
        );

        /*
         * ==================================================
         * OBJETO NÓMINA
         * ==================================================
         */

        NominaInterfaz nomina =
                new NominaInterfaz(
                        "Laura Martínez",
                        3_200_000.0,
                        450_000.0,
                        180_000.0
                );

        System.out.println("\nNÓMINA");
        System.out.println("----------------------------------------");

        nomina.mostrarDetallePago();

        System.out.printf(
                "Pago neto: $%,.2f%n",
                nomina.calcularPago()
        );

        /*
         * ==================================================
         * POLIMORFISMO CON INTERFACES
         * ==================================================
         *
         * Una referencia de tipo Pagable puede apuntar
         * a cualquier objeto cuya clase implemente
         * la interfaz.
         */

        System.out.println("\nPOLIMORFISMO CON INTERFAZ");
        System.out.println("----------------------------------------");

        Pagable pago;

        pago = factura;

        procesarPago(pago);

        pago = nomina;

        procesarPago(pago);

        /*
         * ==================================================
         * ARREGLO DE TIPO INTERFAZ
         * ==================================================
         */

        Pagable[] pagos = {
                factura,
                nomina,
                new FacturaInterfaz(
                        "FAC-002",
                        "Teclado mecánico",
                        3,
                        180_000.0
                ),
                new NominaInterfaz(
                        "Carlos Gómez",
                        2_900_000.0,
                        300_000.0,
                        150_000.0
                )
        };

        System.out.println("\nLISTA DE PAGOS");
        System.out.println("----------------------------------------");

        double totalPagos = 0.0;

        for (Pagable pagoActual : pagos) {

            pagoActual.mostrarDetallePago();

            double valorPago =
                    pagoActual.calcularPago();

            System.out.printf(
                    "Pago calculado: $%,.2f%n",
                    valorPago
            );

            System.out.println(
                    "Tipo real: "
                            + pagoActual
                            .getClass()
                            .getSimpleName()
            );

            System.out.println("----------------------------------------");

            totalPagos += valorPago;
        }

        System.out.printf(
                "Total general de pagos: $%,.2f%n",
                totalPagos
        );

        /*
         * ==================================================
         * CONSTANTE DE LA INTERFAZ
         * ==================================================
         */

        System.out.println("\nCONSTANTE DE LA INTERFAZ");
        System.out.println("----------------------------------------");

        System.out.println(
                "Moneda utilizada: "
                        + Pagable.MONEDA
        );

        System.out.println("\nFin del programa.");
    }

    /*
     * Método que recibe una referencia de tipo interfaz.
     *
     * Puede procesar cualquier objeto que implemente Pagable.
     */

    public static void procesarPago(
            Pagable elementoPagable
    ) {

        elementoPagable.mostrarDetallePago();

        System.out.printf(
                "Valor procesado: $%,.2f%n",
                elementoPagable.calcularPago()
        );

        System.out.println(
                "----------------------------------------"
        );
    }
}

/*
 * ==================================================
 * INTERFAZ
 * ==================================================
 *
 * Una interfaz se declara con la palabra interface.
 */

interface Pagable {

    /*
     * Las variables declaradas en una interfaz son
     * automáticamente:
     *
     * public static final
     *
     * Por eso funcionan como constantes.
     */

    String MONEDA = "COP";

    /*
     * Los métodos sin cuerpo son automáticamente:
     *
     * public abstract
     *
     * Las clases que implementen la interfaz deben
     * proporcionar su implementación.
     */

    double calcularPago();

    void mostrarDetallePago();
}

/*
 * ==================================================
 * CLASE FACTURA
 * ==================================================
 *
 * implements indica que la clase acepta
 * el contrato definido por Pagable.
 */

class FacturaInterfaz implements Pagable {

    private String numeroFactura;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public FacturaInterfaz(
            String numeroFactura,
            String descripcion,
            int cantidad,
            double precioUnitario
    ) {

        this.numeroFactura = numeroFactura;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    /*
     * Implementación obligatoria de calcularPago().
     */

    @Override
    public double calcularPago() {

        return cantidad * precioUnitario;
    }

    /*
     * Implementación obligatoria de mostrarDetallePago().
     */

    @Override
    public void mostrarDetallePago() {

        System.out.println(
                "Tipo: factura"
        );

        System.out.println(
                "Número: " + numeroFactura
        );

        System.out.println(
                "Descripción: " + descripcion
        );

        System.out.println(
                "Cantidad: " + cantidad
        );

        System.out.printf(
                "Precio unitario: $%,.2f%n",
                precioUnitario
        );
    }
}

/*
 * ==================================================
 * CLASE NÓMINA
 * ==================================================
 */

class NominaInterfaz implements Pagable {

    private String empleado;
    private double salarioBase;
    private double bonificacion;
    private double descuentos;

    public NominaInterfaz(
            String empleado,
            double salarioBase,
            double bonificacion,
            double descuentos
    ) {

        this.empleado = empleado;
        this.salarioBase = salarioBase;
        this.bonificacion = bonificacion;
        this.descuentos = descuentos;
    }

    @Override
    public double calcularPago() {

        return salarioBase
                + bonificacion
                - descuentos;
    }

    @Override
    public void mostrarDetallePago() {

        System.out.println(
                "Tipo: nómina"
        );

        System.out.println(
                "Empleado: " + empleado
        );

        System.out.printf(
                "Salario base: $%,.2f%n",
                salarioBase
        );

        System.out.printf(
                "Bonificación: $%,.2f%n",
                bonificacion
        );

        System.out.printf(
                "Descuentos: $%,.2f%n",
                descuentos
        );
    }
}