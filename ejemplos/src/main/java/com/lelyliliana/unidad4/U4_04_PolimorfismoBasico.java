package com.lelyliliana.unidad4;

/*
 * EJEMPLO 4 - UNIDAD 4
 *
 * Tema:
 * Polimorfismo básico.
 *
 * El polimorfismo permite utilizar una referencia
 * de la clase padre para almacenar objetos de
 * diferentes clases hijas.
 *
 * En este ejemplo:
 *
 * EmpleadoPolimorfico es la clase padre.
 *
 * DocentePolimorfico,
 * AdministrativoPolimorfico y
 * ContratistaPolimorfico son clases hijas.
 *
 * Todas sobrescriben el método:
 *
 * calcularPago()
 *
 * Aunque la referencia tenga tipo EmpleadoPolimorfico,
 * Java ejecuta el método correspondiente al objeto real.
 */

public class U4_04_PolimorfismoBasico {

    public static void main(String[] args) {

        System.out.println("POLIMORFISMO BÁSICO EN JAVA");
        System.out.println("========================================");

        /*
         * ==================================================
         * REFERENCIA PADRE CON OBJETO HIJO
         * ==================================================
         *
         * La variable empleado1 tiene tipo:
         *
         * EmpleadoPolimorfico
         *
         * Pero el objeto creado es:
         *
         * DocentePolimorfico
         */

        EmpleadoPolimorfico empleado1 =
                new DocentePolimorfico(
                        "Laura Martínez",
                        3_000_000.0,
                        20,
                        45_000.0
                );

        EmpleadoPolimorfico empleado2 =
                new AdministrativoPolimorfico(
                        "Carlos Gómez",
                        2_800_000.0,
                        350_000.0
                );

        EmpleadoPolimorfico empleado3 =
                new ContratistaPolimorfico(
                        "María Pérez",
                        160,
                        30_000.0
                );

        /*
         * Todas las variables tienen el mismo tipo
         * de referencia:
         *
         * EmpleadoPolimorfico
         *
         * Pero apuntan a objetos diferentes.
         */

        System.out.println("\nEMPLEADO 1");
        System.out.println("----------------------------------------");

        empleado1.mostrarInformacion();

        System.out.printf(
                "Pago calculado: $%,.2f%n",
                empleado1.calcularPago()
        );

        empleado1.describirTrabajo();

        System.out.println("\nEMPLEADO 2");
        System.out.println("----------------------------------------");

        empleado2.mostrarInformacion();

        System.out.printf(
                "Pago calculado: $%,.2f%n",
                empleado2.calcularPago()
        );

        empleado2.describirTrabajo();

        System.out.println("\nEMPLEADO 3");
        System.out.println("----------------------------------------");

        empleado3.mostrarInformacion();

        System.out.printf(
                "Pago calculado: $%,.2f%n",
                empleado3.calcularPago()
        );

        empleado3.describirTrabajo();

        /*
         * ==================================================
         * MISMA REFERENCIA, DIFERENTES OBJETOS
         * ==================================================
         *
         * La variable empleado puede apuntar primero
         * a un docente y después a un administrativo.
         */

        System.out.println("\nCAMBIO DEL OBJETO REFERENCIADO");
        System.out.println("----------------------------------------");

        EmpleadoPolimorfico empleado;

        empleado =
                new DocentePolimorfico(
                        "Andrés Ruiz",
                        2_900_000.0,
                        15,
                        40_000.0
                );

        System.out.println(
                "Objeto actual: DocentePolimorfico"
        );

        empleado.describirTrabajo();

        empleado =
                new AdministrativoPolimorfico(
                        "Sofía Torres",
                        3_100_000.0,
                        500_000.0
                );

        System.out.println(
                "\nObjeto actual: AdministrativoPolimorfico"
        );

        empleado.describirTrabajo();

        /*
         * ==================================================
         * MÉTODO POLIMÓRFICO
         * ==================================================
         *
         * El método procesarEmpleado() recibe una referencia
         * de tipo EmpleadoPolimorfico.
         *
         * Puede recibir cualquier objeto cuya clase
         * herede de EmpleadoPolimorfico.
         */

        System.out.println("\nMÉTODO POLIMÓRFICO");
        System.out.println("----------------------------------------");

        procesarEmpleado(empleado1);
        procesarEmpleado(empleado2);
        procesarEmpleado(empleado3);

        /*
         * ==================================================
         * TIPO DE REFERENCIA Y TIPO DE OBJETO
         * ==================================================
         */

        System.out.println("\nTIPO DE REFERENCIA Y OBJETO");
        System.out.println("----------------------------------------");

        System.out.println(
                "La referencia empleado1 es de tipo "
                        + "EmpleadoPolimorfico."
        );

        System.out.println(
                "El objeto real es de tipo: "
                        + empleado1
                                .getClass()
                                .getSimpleName()
        );

        /*
         * instanceof permite comprobar el tipo real
         * del objeto.
         */

        System.out.println(
                "¿empleado1 es EmpleadoPolimorfico?: "
                        + (
                        empleado1
                                instanceof EmpleadoPolimorfico
                )
        );

        System.out.println(
                "¿empleado1 es DocentePolimorfico?: "
                        + (
                        empleado1
                                instanceof DocentePolimorfico
                )
        );

        System.out.println(
                "¿empleado1 es AdministrativoPolimorfico?: "
                        + (
                        empleado1
                                instanceof AdministrativoPolimorfico
                )
        );

        /*
         * ==================================================
         * LIMITACIÓN DE LA REFERENCIA PADRE
         * ==================================================
         *
         * Aunque empleado1 contiene un objeto Docente,
         * solo puede llamar directamente los métodos
         * declarados en EmpleadoPolimorfico.
         *
         * Esta instrucción no compilaría:
         *
         * empleado1.mostrarHorasClase();
         *
         * porque mostrarHorasClase() no está declarado
         * en la clase padre.
         */

        /*
         * Para acceder a un método específico de la hija,
         * puede realizarse una conversión después de validar
         * el tipo del objeto.
         */

        if (
                empleado1
                        instanceof DocentePolimorfico docente
        ) {

            System.out.println(
                    "\nMÉTODO ESPECÍFICO DEL DOCENTE"
            );

            System.out.println(
                    "----------------------------------------"
            );

            docente.mostrarHorasClase();
        }

        System.out.println("\nFin del programa.");
    }

    /*
     * ==================================================
     * MÉTODO POLIMÓRFICO
     * ==================================================
     *
     * Recibe cualquier objeto que sea un empleado.
     */

    public static void procesarEmpleado(
            EmpleadoPolimorfico empleado
    ) {

        System.out.println(
                "Empleado: " + empleado.getNombre()
        );

        System.out.println(
                "Tipo real: "
                        + empleado
                                .getClass()
                                .getSimpleName()
        );

        empleado.describirTrabajo();

        System.out.printf(
                "Pago: $%,.2f%n",
                empleado.calcularPago()
        );

        System.out.println(
                "----------------------------------------"
        );
    }
}

/*
 * ==================================================
 * CLASE PADRE
 * ==================================================
 */

class EmpleadoPolimorfico {

    private String nombre;
    private double salarioBase;

    public EmpleadoPolimorfico(
            String nombre,
            double salarioBase
    ) {

        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {

        return nombre;
    }

    public double getSalarioBase() {

        return salarioBase;
    }

    /*
     * Este método será sobrescrito por las clases hijas.
     */

    public double calcularPago() {

        return salarioBase;
    }

    /*
     * Cada clase hija podrá describir un trabajo distinto.
     */

    public void describirTrabajo() {

        System.out.println(
                nombre + " realiza labores generales."
        );
    }

    public void mostrarInformacion() {

        System.out.println(
                "Nombre: " + nombre
        );

        System.out.println(
                "Tipo real: "
                        + getClass().getSimpleName()
        );
    }
}

/*
 * ==================================================
 * CLASE HIJA DOCENTE
 * ==================================================
 */

class DocentePolimorfico
        extends EmpleadoPolimorfico {

    private int horasClase;
    private double valorHoraAdicional;

    public DocentePolimorfico(
            String nombre,
            double salarioBase,
            int horasClase,
            double valorHoraAdicional
    ) {

        super(nombre, salarioBase);

        this.horasClase = horasClase;
        this.valorHoraAdicional =
                valorHoraAdicional;
    }

    /*
     * El docente recibe el salario base más
     * un pago adicional por las horas de clase.
     */

    @Override
    public double calcularPago() {

        return getSalarioBase()
                + horasClase * valorHoraAdicional;
    }

    @Override
    public void describirTrabajo() {

        System.out.println(
                getNombre()
                        + " orienta clases y acompaña "
                        + "procesos académicos."
        );
    }

    public void mostrarHorasClase() {

        System.out.println(
                "Horas de clase: " + horasClase
        );

        System.out.printf(
                "Valor por hora adicional: $%,.2f%n",
                valorHoraAdicional
        );
    }
}

/*
 * ==================================================
 * CLASE HIJA ADMINISTRATIVO
 * ==================================================
 */

class AdministrativoPolimorfico
        extends EmpleadoPolimorfico {

    private double bonificacion;

    public AdministrativoPolimorfico(
            String nombre,
            double salarioBase,
            double bonificacion
    ) {

        super(nombre, salarioBase);

        this.bonificacion = bonificacion;
    }

    @Override
    public double calcularPago() {

        return getSalarioBase()
                + bonificacion;
    }

    @Override
    public void describirTrabajo() {

        System.out.println(
                getNombre()
                        + " gestiona procesos administrativos."
        );
    }
}

/*
 * ==================================================
 * CLASE HIJA CONTRATISTA
 * ==================================================
 *
 * Para este ejemplo, el contratista no utiliza
 * un salario base mensual.
 */

class ContratistaPolimorfico
        extends EmpleadoPolimorfico {

    private int horasTrabajadas;
    private double valorHora;

    public ContratistaPolimorfico(
            String nombre,
            int horasTrabajadas,
            double valorHora
    ) {

        /*
         * Se envía 0 como salario base porque el pago
         * se calcula completamente por horas.
         */

        super(nombre, 0.0);

        this.horasTrabajadas =
                horasTrabajadas;

        this.valorHora = valorHora;
    }

    @Override
    public double calcularPago() {

        return horasTrabajadas * valorHora;
    }

    @Override
    public void describirTrabajo() {

        System.out.println(
                getNombre()
                        + " desarrolla actividades "
                        + "según un contrato por horas."
        );
    }
}