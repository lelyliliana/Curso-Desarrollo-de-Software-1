package com.lelyliliana.unidad4;

/*
 * EJEMPLO 9 - UNIDAD 4
 *
 * Tema:
 * Composición de objetos.
 *
 * La composición representa una relación:
 *
 * "tiene un"
 *
 * Ejemplos:
 *
 * - Un automóvil tiene un motor.
 * - Un computador tiene un procesador.
 * - Un estudiante tiene una dirección.
 * - Un pedido tiene un cliente.
 *
 * En este programa:
 *
 * AutomovilComposicion tiene un MotorComposicion.
 * AutomovilComposicion tiene un ConductorComposicion.
 *
 * Motor y Conductor no son tipos de automóvil.
 * Por eso no se utiliza herencia.
 */

public class U4_09_ComposicionObjetos {

    public static void main(String[] args) {

        System.out.println("COMPOSICIÓN DE OBJETOS");
        System.out.println("========================================");

        /*
         * ==================================================
         * CREACIÓN DE OBJETOS INDEPENDIENTES
         * ==================================================
         *
         * Primero creamos un motor.
         */

        MotorComposicion motor =
                new MotorComposicion(
                        "MTR-2026",
                        1600,
                        "Gasolina"
                );

        /*
         * Creamos un conductor.
         */

        ConductorComposicion conductor =
                new ConductorComposicion(
                        "Laura Martínez",
                        "LIC-458796",
                        8
                );

        /*
         * ==================================================
         * CREACIÓN DEL AUTOMÓVIL
         * ==================================================
         *
         * El automóvil recibe los objetos MotorComposicion
         * y ConductorComposicion.
         *
         * Esto establece la relación:
         *
         * Automóvil tiene un motor.
         * Automóvil tiene un conductor.
         */

        AutomovilComposicion automovil =
                new AutomovilComposicion(
                        "ABC123",
                        "Toyota",
                        "Corolla",
                        motor,
                        conductor
                );

        System.out.println("\nINFORMACIÓN DEL AUTOMÓVIL");
        System.out.println("----------------------------------------");

        automovil.mostrarInformacionCompleta();

        /*
         * ==================================================
         * DELEGACIÓN DE RESPONSABILIDADES
         * ==================================================
         *
         * El automóvil no conoce directamente cómo
         * funciona internamente el motor.
         *
         * Cuando se solicita encender el automóvil,
         * este delega la operación al objeto motor.
         */

        System.out.println("\nOPERACIONES DEL AUTOMÓVIL");
        System.out.println("----------------------------------------");

        automovil.encender();

        automovil.acelerar();

        automovil.apagar();

        /*
         * ==================================================
         * CONSULTA DE OBJETOS INTERNOS
         * ==================================================
         *
         * El automóvil puede proporcionar acceso
         * controlado a sus objetos relacionados.
         */

        System.out.println("\nCONSULTA DEL MOTOR");
        System.out.println("----------------------------------------");

        MotorComposicion motorDelAutomovil =
                automovil.getMotor();

        System.out.println(
                "Código del motor: "
                        + motorDelAutomovil.getCodigo()
        );

        System.out.println(
                "Cilindraje: "
                        + motorDelAutomovil.getCilindraje()
                        + " cc"
        );

        /*
         * ==================================================
         * CAMBIO DE CONDUCTOR
         * ==================================================
         *
         * El automóvil mantiene su motor, pero puede
         * asignársele otro conductor.
         */

        ConductorComposicion nuevoConductor =
                new ConductorComposicion(
                        "Carlos Gómez",
                        "LIC-889900",
                        12
                );

        automovil.setConductor(
                nuevoConductor
        );

        System.out.println("\nNUEVO CONDUCTOR");
        System.out.println("----------------------------------------");

        automovil.mostrarInformacionConductor();

        /*
         * ==================================================
         * SEGUNDO EJEMPLO: COMPUTADOR
         * ==================================================
         *
         * Un computador tiene:
         *
         * - Un procesador.
         * - Una memoria.
         */

        System.out.println("\nCOMPOSICIÓN EN UN COMPUTADOR");
        System.out.println("========================================");

        ProcesadorComposicion procesador =
                new ProcesadorComposicion(
                        "AMD",
                        "Ryzen 7",
                        8
                );

        MemoriaComposicion memoria =
                new MemoriaComposicion(
                        16,
                        "DDR5"
                );

        ComputadorComposicion computador =
                new ComputadorComposicion(
                        "Dell",
                        "G15",
                        procesador,
                        memoria
                );

        computador.mostrarInformacion();

        computador.encender();

        computador.ejecutarPrograma(
                "Visual Studio Code"
        );

        computador.apagar();

        System.out.println("\nFin del programa.");
    }
}

/*
 * ==================================================
 * CLASE MOTOR
 * ==================================================
 *
 * Representa una parte del automóvil.
 */

class MotorComposicion {

    private String codigo;
    private int cilindraje;
    private String tipoCombustible;
    private boolean encendido;

    public MotorComposicion(
            String codigo,
            int cilindraje,
            String tipoCombustible
    ) {

        if (
                codigo == null
                        || codigo.isBlank()
        ) {

            throw new IllegalArgumentException(
                    "El código del motor es obligatorio."
            );
        }

        if (cilindraje <= 0) {

            throw new IllegalArgumentException(
                    "El cilindraje debe ser mayor que cero."
            );
        }

        this.codigo = codigo;
        this.cilindraje = cilindraje;
        this.tipoCombustible = tipoCombustible;
        this.encendido = false;
    }

    public void encender() {

        if (encendido) {

            System.out.println(
                    "El motor ya se encuentra encendido."
            );

            return;
        }

        encendido = true;

        System.out.println(
                "El motor fue encendido."
        );
    }

    public void apagar() {

        if (!encendido) {

            System.out.println(
                    "El motor ya se encuentra apagado."
            );

            return;
        }

        encendido = false;

        System.out.println(
                "El motor fue apagado."
        );
    }

    public void aumentarRevoluciones() {

        if (!encendido) {

            System.out.println(
                    "No se puede acelerar porque "
                            + "el motor está apagado."
            );

            return;
        }

        System.out.println(
                "El motor aumentó sus revoluciones."
        );
    }

    public void mostrarInformacion() {

        System.out.println(
                "Código del motor: " + codigo
        );

        System.out.println(
                "Cilindraje: " + cilindraje + " cc"
        );

        System.out.println(
                "Combustible: " + tipoCombustible
        );

        System.out.println(
                "Encendido: " + encendido
        );
    }

    public String getCodigo() {

        return codigo;
    }

    public int getCilindraje() {

        return cilindraje;
    }

    public boolean estaEncendido() {

        return encendido;
    }
}

/*
 * ==================================================
 * CLASE CONDUCTOR
 * ==================================================
 */

class ConductorComposicion {

    private String nombre;
    private String numeroLicencia;
    private int aniosExperiencia;

    public ConductorComposicion(
            String nombre,
            String numeroLicencia,
            int aniosExperiencia
    ) {

        if (
                nombre == null
                        || nombre.isBlank()
        ) {

            throw new IllegalArgumentException(
                    "El nombre del conductor es obligatorio."
            );
        }

        if (
                numeroLicencia == null
                        || numeroLicencia.isBlank()
        ) {

            throw new IllegalArgumentException(
                    "La licencia es obligatoria."
            );
        }

        if (aniosExperiencia < 0) {

            throw new IllegalArgumentException(
                    "Los años de experiencia "
                            + "no pueden ser negativos."
            );
        }

        this.nombre = nombre;
        this.numeroLicencia = numeroLicencia;
        this.aniosExperiencia = aniosExperiencia;
    }

    public void mostrarInformacion() {

        System.out.println(
                "Nombre: " + nombre
        );

        System.out.println(
                "Licencia: " + numeroLicencia
        );

        System.out.println(
                "Años de experiencia: "
                        + aniosExperiencia
        );
    }

    public String getNombre() {

        return nombre;
    }
}

/*
 * ==================================================
 * CLASE AUTOMÓVIL
 * ==================================================
 *
 * AutomovilComposicion contiene referencias a:
 *
 * - MotorComposicion.
 * - ConductorComposicion.
 */

class AutomovilComposicion {

    private String placa;
    private String marca;
    private String modelo;

    /*
     * Objetos que forman parte de la composición.
     */

    private MotorComposicion motor;
    private ConductorComposicion conductor;

    public AutomovilComposicion(
            String placa,
            String marca,
            String modelo,
            MotorComposicion motor,
            ConductorComposicion conductor
    ) {

        if (motor == null) {

            throw new IllegalArgumentException(
                    "El automóvil debe tener un motor."
            );
        }

        if (conductor == null) {

            throw new IllegalArgumentException(
                    "El automóvil debe tener un conductor."
            );
        }

        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.conductor = conductor;
    }

    /*
     * El automóvil delega el encendido al motor.
     */

    public void encender() {

        System.out.println(
                "Intentando encender el automóvil..."
        );

        motor.encender();
    }

    public void apagar() {

        System.out.println(
                "Intentando apagar el automóvil..."
        );

        motor.apagar();
    }

    public void acelerar() {

        System.out.println(
                "El conductor "
                        + conductor.getNombre()
                        + " intenta acelerar."
        );

        motor.aumentarRevoluciones();
    }

    public void mostrarInformacionCompleta() {

        System.out.println(
                "Placa: " + placa
        );

        System.out.println(
                "Marca: " + marca
        );

        System.out.println(
                "Modelo: " + modelo
        );

        System.out.println("\nMotor:");

        motor.mostrarInformacion();

        System.out.println("\nConductor:");

        conductor.mostrarInformacion();
    }

    public void mostrarInformacionConductor() {

        conductor.mostrarInformacion();
    }

    public MotorComposicion getMotor() {

        return motor;
    }

    public ConductorComposicion getConductor() {

        return conductor;
    }

    public void setConductor(
            ConductorComposicion conductor
    ) {

        if (conductor == null) {

            throw new IllegalArgumentException(
                    "El conductor no puede ser nulo."
            );
        }

        this.conductor = conductor;
    }
}

/*
 * ==================================================
 * SEGUNDO EJEMPLO: PROCESADOR
 * ==================================================
 */

class ProcesadorComposicion {

    private String fabricante;
    private String modelo;
    private int nucleos;

    public ProcesadorComposicion(
            String fabricante,
            String modelo,
            int nucleos
    ) {

        this.fabricante = fabricante;
        this.modelo = modelo;
        this.nucleos = nucleos;
    }

    public void procesar() {

        System.out.println(
                "El procesador "
                        + fabricante
                        + " "
                        + modelo
                        + " está procesando información."
        );
    }

    public void mostrarInformacion() {

        System.out.println(
                "Procesador: "
                        + fabricante
                        + " "
                        + modelo
        );

        System.out.println(
                "Núcleos: " + nucleos
        );
    }
}

/*
 * ==================================================
 * SEGUNDO EJEMPLO: MEMORIA
 * ==================================================
 */

class MemoriaComposicion {

    private int capacidadGb;
    private String tipo;

    public MemoriaComposicion(
            int capacidadGb,
            String tipo
    ) {

        this.capacidadGb = capacidadGb;
        this.tipo = tipo;
    }

    public void mostrarInformacion() {

        System.out.println(
                "Memoria: "
                        + capacidadGb
                        + " GB "
                        + tipo
        );
    }
}

/*
 * ==================================================
 * SEGUNDO EJEMPLO: COMPUTADOR
 * ==================================================
 */

class ComputadorComposicion {

    private String marca;
    private String modelo;

    private ProcesadorComposicion procesador;
    private MemoriaComposicion memoria;

    private boolean encendido;

    public ComputadorComposicion(
            String marca,
            String modelo,
            ProcesadorComposicion procesador,
            MemoriaComposicion memoria
    ) {

        this.marca = marca;
        this.modelo = modelo;
        this.procesador = procesador;
        this.memoria = memoria;
        this.encendido = false;
    }

    public void encender() {

        encendido = true;

        System.out.println(
                marca
                        + " "
                        + modelo
                        + " fue encendido."
        );
    }

    public void apagar() {

        encendido = false;

        System.out.println(
                marca
                        + " "
                        + modelo
                        + " fue apagado."
        );
    }

    public void ejecutarPrograma(
            String nombrePrograma
    ) {

        if (!encendido) {

            System.out.println(
                    "El computador debe estar encendido."
            );

            return;
        }

        System.out.println(
                "Ejecutando: " + nombrePrograma
        );

        /*
         * Delegamos el procesamiento al objeto procesador.
         */

        procesador.procesar();
    }

    public void mostrarInformacion() {

        System.out.println(
                "Computador: "
                        + marca
                        + " "
                        + modelo
        );

        procesador.mostrarInformacion();

        memoria.mostrarInformacion();
    }
}