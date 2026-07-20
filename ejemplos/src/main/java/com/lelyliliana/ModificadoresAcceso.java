package com.lelyliliana;

/*
 * TEMA: Modificadores de acceso
 *
 * public:
 * Puede utilizarse desde cualquier clase.
 *
 * private:
 * Solo puede utilizarse dentro de la misma clase.
 *
 * protected:
 * Puede utilizarse dentro de la misma clase,
 * en clases del mismo paquete y en clases hijas.
 */

class CuentaBancaria {

    // Se puede consultar directamente desde otras clases
    public String titular;

    // Solo puede accederse directamente dentro de CuentaBancaria
    private double saldo;

    // Podría utilizarse desde una clase hija
    protected String tipoCuenta;

    // Constructor
    public CuentaBancaria(
            String titular,
            double saldoInicial,
            String tipoCuenta) {

        this.titular = titular;
        this.saldo = saldoInicial;
        this.tipoCuenta = tipoCuenta;
    }

    // Método público para consultar el saldo privado
    public double consultarSaldo() {
        return saldo;
    }

    // Método público para modificar el saldo privado
    public void depositar(double cantidad) {

        if (cantidad > 0) {
            saldo = saldo + cantidad;
            System.out.println("Depósito realizado correctamente.");
        } else {
            System.out.println("La cantidad debe ser mayor que cero.");
        }
    }

    // Método para mostrar los datos
    public void mostrarCuenta() {
        System.out.println("Titular: " + titular);
        System.out.println("Tipo de cuenta: " + tipoCuenta);
        System.out.println("Saldo: $" + saldo);
    }
}

public class ModificadoresAcceso {

    public static void main(String[] args) {

        CuentaBancaria cuenta = new CuentaBancaria(
                "Ana Torres",
                500000,
                "Ahorros"
        );

        // titular es público
        System.out.println("Titular: " + cuenta.titular);

        /*
         * Esto produciría un error porque saldo es privado:
         *
         * System.out.println(cuenta.saldo);
         */

        // Consultamos el saldo usando un método público
        System.out.println("Saldo inicial: $" + cuenta.consultarSaldo());

        // Modificamos el saldo mediante un método público
        cuenta.depositar(150000);

        // Mostramos el resultado final
        cuenta.mostrarCuenta();
    }
}
