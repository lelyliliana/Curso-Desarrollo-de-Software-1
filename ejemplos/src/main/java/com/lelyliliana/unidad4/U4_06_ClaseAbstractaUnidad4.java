package com.lelyliliana.unidad4;

/*
 * EJEMPLO 6 - UNIDAD 4
 *
 * Tema:
 * Clases y métodos abstractos aplicados.
 *
 * Una clase abstracta:
 *
 * - Se declara con la palabra abstract.
 * - Puede contener atributos.
 * - Puede tener constructores.
 * - Puede contener métodos concretos.
 * - Puede declarar métodos abstractos.
 * - No puede utilizarse para crear objetos directamente.
 *
 * Un método abstracto:
 *
 * - No tiene cuerpo.
 * - Solo declara qué operación debe existir.
 * - Debe ser implementado por las clases hijas concretas.
 *
 * En este ejemplo:
 *
 * CuentaBancariaAbstracta es la clase abstracta.
 *
 * CuentaAhorrosAbstracta y CuentaCorrienteAbstracta
 * son clases concretas.
 */

public class U4_06_ClaseAbstractaUnidad4 {

    public static void main(String[] args) {

        System.out.println("CLASES ABSTRACTAS EN JAVA");
        System.out.println("========================================");

        /*
         * No se puede crear directamente un objeto
         * de una clase abstracta.
         *
         * Esta instrucción produciría un error:
         *
         * CuentaBancariaAbstracta cuenta =
         *         new CuentaBancariaAbstracta(...);
         */

        /*
         * Creamos objetos de las clases hijas concretas.
         */

        CuentaAhorrosAbstracta cuentaAhorros =
                new CuentaAhorrosAbstracta(
                        "AHO-001",
                        "Laura Martínez",
                        2_000_000.0,
                        0.05
                );

        CuentaCorrienteAbstracta cuentaCorriente =
                new CuentaCorrienteAbstracta(
                        "COR-001",
                        "Carlos Gómez",
                        1_500_000.0,
                        800_000.0
                );

        /*
         * ==================================================
         * CUENTA DE AHORROS
         * ==================================================
         */

        System.out.println("\nCUENTA DE AHORROS");
        System.out.println("----------------------------------------");

        cuentaAhorros.mostrarInformacion();

        cuentaAhorros.depositar(500_000.0);

        cuentaAhorros.retirar(300_000.0);

        cuentaAhorros.aplicarOperacionMensual();

        cuentaAhorros.mostrarInformacion();

        /*
         * ==================================================
         * CUENTA CORRIENTE
         * ==================================================
         */

        System.out.println("\nCUENTA CORRIENTE");
        System.out.println("----------------------------------------");

        cuentaCorriente.mostrarInformacion();

        cuentaCorriente.depositar(250_000.0);

        /*
         * La cuenta corriente puede utilizar
         * el cupo de sobregiro.
         */
        cuentaCorriente.retirar(2_000_000.0);

        cuentaCorriente.aplicarOperacionMensual();

        cuentaCorriente.mostrarInformacion();

        /*
         * ==================================================
         * POLIMORFISMO CON CLASE ABSTRACTA
         * ==================================================
         *
         * Una referencia de la clase abstracta puede apuntar
         * a un objeto de cualquier clase hija concreta.
         */

        System.out.println("\nPOLIMORFISMO");
        System.out.println("----------------------------------------");

        CuentaBancariaAbstracta cuenta;

        cuenta = cuentaAhorros;

        procesarCuenta(cuenta);

        cuenta = cuentaCorriente;

        procesarCuenta(cuenta);

        /*
         * ==================================================
         * ARREGLO POLIMÓRFICO
         * ==================================================
         */

        CuentaBancariaAbstracta[] cuentas = {
                cuentaAhorros,
                cuentaCorriente,
                new CuentaAhorrosAbstracta(
                        "AHO-002",
                        "María Pérez",
                        3_000_000.0,
                        0.04
                )
        };

        System.out.println("\nLISTA DE CUENTAS");
        System.out.println("----------------------------------------");

        double saldoTotal = 0.0;

        for (CuentaBancariaAbstracta cuentaActual : cuentas) {

            cuentaActual.mostrarInformacion();

            System.out.println(
                    "Tipo de cuenta: "
                            + cuentaActual.obtenerTipoCuenta()
            );

            System.out.println("----------------------------------------");

            saldoTotal += cuentaActual.getSaldo();
        }

        System.out.printf(
                "Saldo total de las cuentas: $%,.2f%n",
                saldoTotal
        );

        System.out.println("\nFin del programa.");
    }

    /*
     * Este método recibe una referencia de la clase abstracta.
     *
     * Puede procesar cualquier objeto de una clase hija
     * que extienda CuentaBancariaAbstracta.
     */

    public static void procesarCuenta(
            CuentaBancariaAbstracta cuenta
    ) {

        System.out.println(
                "Titular: " + cuenta.getTitular()
        );

        System.out.println(
                "Tipo real: "
                        + cuenta.getClass().getSimpleName()
        );

        System.out.println(
                "Tipo de cuenta: "
                        + cuenta.obtenerTipoCuenta()
        );

        cuenta.aplicarOperacionMensual();

        System.out.printf(
                "Saldo después de la operación mensual: $%,.2f%n",
                cuenta.getSaldo()
        );

        System.out.println("----------------------------------------");
    }
}

/*
 * ==================================================
 * CLASE ABSTRACTA
 * ==================================================
 */

abstract class CuentaBancariaAbstracta {

    private String numeroCuenta;
    private String titular;
    private double saldo;

    /*
     * Una clase abstracta puede tener constructor.
     *
     * Este constructor será llamado por las clases hijas
     * mediante super().
     */

    public CuentaBancariaAbstracta(
            String numeroCuenta,
            String titular,
            double saldoInicial
    ) {

        if (
                numeroCuenta == null
                        || numeroCuenta.isBlank()
        ) {

            throw new IllegalArgumentException(
                    "El número de cuenta es obligatorio."
            );
        }

        if (
                titular == null
                        || titular.isBlank()
        ) {

            throw new IllegalArgumentException(
                    "El titular es obligatorio."
            );
        }

        if (saldoInicial < 0) {

            throw new IllegalArgumentException(
                    "El saldo inicial no puede ser negativo."
            );
        }

        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    /*
     * ==================================================
     * MÉTODOS CONCRETOS
     * ==================================================
     *
     * Estos métodos tienen implementación y pueden
     * utilizarse directamente por las clases hijas.
     */

    public void depositar(double valor) {

        if (valor <= 0) {

            System.out.println(
                    "El valor del depósito debe ser mayor que cero."
            );

            return;
        }

        saldo += valor;

        System.out.printf(
                "Depósito realizado: $%,.2f%n",
                valor
        );
    }

    /*
     * El método retirar se declara concreto,
     * pero utiliza otro método abstracto para decidir
     * cuánto dinero puede retirarse.
     */

    public void retirar(double valor) {

        if (valor <= 0) {

            System.out.println(
                    "El valor del retiro debe ser mayor que cero."
            );

            return;
        }

        if (valor <= obtenerSaldoDisponible()) {

            saldo -= valor;

            System.out.printf(
                    "Retiro realizado: $%,.2f%n",
                    valor
            );

        } else {

            System.out.println(
                    "Fondos insuficientes para realizar el retiro."
            );
        }
    }

    public void mostrarInformacion() {

        System.out.println(
                "Número de cuenta: " + numeroCuenta
        );

        System.out.println(
                "Titular: " + titular
        );

        System.out.println(
                "Tipo: " + obtenerTipoCuenta()
        );

        System.out.printf(
                "Saldo: $%,.2f%n",
                saldo
        );

        System.out.printf(
                "Saldo disponible: $%,.2f%n",
                obtenerSaldoDisponible()
        );
    }

    /*
     * Método protegido para modificar el saldo
     * desde las clases hijas.
     */

    protected void modificarSaldo(double nuevoSaldo) {

        saldo = nuevoSaldo;
    }

    public String getNumeroCuenta() {

        return numeroCuenta;
    }

    public String getTitular() {

        return titular;
    }

    public double getSaldo() {

        return saldo;
    }

    /*
     * ==================================================
     * MÉTODOS ABSTRACTOS
     * ==================================================
     *
     * No tienen cuerpo.
     *
     * Cada clase hija debe proporcionar
     * su propia implementación.
     */

    public abstract String obtenerTipoCuenta();

    public abstract double obtenerSaldoDisponible();

    public abstract void aplicarOperacionMensual();
}

/*
 * ==================================================
 * CLASE CONCRETA: CUENTA DE AHORROS
 * ==================================================
 */

class CuentaAhorrosAbstracta
        extends CuentaBancariaAbstracta {

    private double tasaInteres;

    public CuentaAhorrosAbstracta(
            String numeroCuenta,
            String titular,
            double saldoInicial,
            double tasaInteres
    ) {

        super(
                numeroCuenta,
                titular,
                saldoInicial
        );

        if (tasaInteres < 0) {

            throw new IllegalArgumentException(
                    "La tasa de interés no puede ser negativa."
            );
        }

        this.tasaInteres = tasaInteres;
    }

    /*
     * Implementación obligatoria del método abstracto.
     */

    @Override
    public String obtenerTipoCuenta() {

        return "Cuenta de ahorros";
    }

    /*
     * En una cuenta de ahorros, el saldo disponible
     * corresponde al saldo actual.
     */

    @Override
    public double obtenerSaldoDisponible() {

        return getSaldo();
    }

    /*
     * La operación mensual aplica intereses.
     */

    @Override
    public void aplicarOperacionMensual() {

        double interes =
                getSaldo() * tasaInteres / 12;

        modificarSaldo(
                getSaldo() + interes
        );

        System.out.printf(
                "Interés mensual aplicado: $%,.2f%n",
                interes
        );
    }
}

/*
 * ==================================================
 * CLASE CONCRETA: CUENTA CORRIENTE
 * ==================================================
 */

class CuentaCorrienteAbstracta
        extends CuentaBancariaAbstracta {

    private double cupoSobregiro;

    private static final double CUOTA_MANEJO =
            25_000.0;

    public CuentaCorrienteAbstracta(
            String numeroCuenta,
            String titular,
            double saldoInicial,
            double cupoSobregiro
    ) {

        super(
                numeroCuenta,
                titular,
                saldoInicial
        );

        if (cupoSobregiro < 0) {

            throw new IllegalArgumentException(
                    "El cupo de sobregiro no puede ser negativo."
            );
        }

        this.cupoSobregiro = cupoSobregiro;
    }

    @Override
    public String obtenerTipoCuenta() {

        return "Cuenta corriente";
    }

    /*
     * El saldo disponible incluye el cupo de sobregiro.
     */

    @Override
    public double obtenerSaldoDisponible() {

        return getSaldo() + cupoSobregiro;
    }

    /*
     * La operación mensual descuenta una cuota de manejo.
     */

    @Override
    public void aplicarOperacionMensual() {

        modificarSaldo(
                getSaldo() - CUOTA_MANEJO
        );

        System.out.printf(
                "Cuota de manejo descontada: $%,.2f%n",
                CUOTA_MANEJO
        );
    }
}