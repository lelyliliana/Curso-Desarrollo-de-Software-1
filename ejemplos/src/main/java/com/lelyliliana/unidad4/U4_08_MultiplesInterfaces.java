package com.lelyliliana.unidad4;

/*
 * EJEMPLO 8 - UNIDAD 4
 *
 * Tema:
 * Implementación de múltiples interfaces.
 *
 * Java no permite que una clase herede de varias clases:
 *
 * class Ejemplo extends Clase1, Clase2
 *
 * La instrucción anterior no es válida.
 *
 * Sin embargo, una clase sí puede implementar
 * varias interfaces al mismo tiempo.
 *
 * Ejemplo:
 *
 * class Robot implements Encendible, Programable, Conectable
 *
 * Cada interfaz representa una capacidad diferente:
 *
 * - Encendible: puede encenderse y apagarse.
 * - Programable: puede ejecutar una tarea programada.
 * - Conectable: puede conectarse y desconectarse de una red.
 */

public class U4_08_MultiplesInterfaces {

    public static void main(String[] args) {

        System.out.println("IMPLEMENTACIÓN DE MÚLTIPLES INTERFACES");
        System.out.println("========================================");

        /*
         * ==================================================
         * CREACIÓN DEL OBJETO
         * ==================================================
         */

        RobotInterfaces robot =
                new RobotInterfaces(
                        "BuscaBot",
                        "10.42.0.10"
                );

        System.out.println("\nDATOS DEL ROBOT");
        System.out.println("----------------------------------------");

        robot.mostrarInformacion();

        /*
         * El objeto puede utilizar los métodos
         * definidos por todas las interfaces.
         */

        System.out.println("\nOPERACIONES DEL ROBOT");
        System.out.println("----------------------------------------");

        robot.encender();

        robot.conectar();

        robot.programarTarea(
                "Explorar el laboratorio"
        );

        robot.ejecutarTarea();

        robot.desconectar();

        robot.apagar();

        /*
         * ==================================================
         * POLIMORFISMO CON LA INTERFAZ ENCENDIBLE
         * ==================================================
         *
         * Una referencia de tipo Encendible solo permite
         * utilizar los métodos definidos en Encendible.
         */

        System.out.println("\nREFERENCIA ENCENDIBLE");
        System.out.println("----------------------------------------");

        Encendible dispositivoEncendible =
                robot;

        dispositivoEncendible.encender();

        System.out.println(
                "¿Está encendido?: "
                        + dispositivoEncendible.estaEncendido()
        );

        dispositivoEncendible.apagar();

        /*
         * Esta instrucción no estaría permitida:
         *
         * dispositivoEncendible.conectar();
         *
         * Aunque el objeto real es un RobotInterfaces,
         * la referencia Encendible solo conoce los métodos
         * declarados en esa interfaz.
         */

        /*
         * ==================================================
         * POLIMORFISMO CON LA INTERFAZ CONECTABLE
         * ==================================================
         */

        System.out.println("\nREFERENCIA CONECTABLE");
        System.out.println("----------------------------------------");

        Conectable dispositivoConectable =
                robot;

        dispositivoConectable.conectar();

        System.out.println(
                "¿Está conectado?: "
                        + dispositivoConectable.estaConectado()
        );

        System.out.println(
                "Dirección de conexión: "
                        + dispositivoConectable
                        .obtenerDireccionConexion()
        );

        dispositivoConectable.desconectar();

        /*
         * ==================================================
         * POLIMORFISMO CON LA INTERFAZ PROGRAMABLE
         * ==================================================
         */

        System.out.println("\nREFERENCIA PROGRAMABLE");
        System.out.println("----------------------------------------");

        Programable dispositivoProgramable =
                robot;

        dispositivoProgramable.programarTarea(
                "Reconocer objetos"
        );

        dispositivoProgramable.ejecutarTarea();

        /*
         * ==================================================
         * OTRO OBJETO QUE IMPLEMENTA ALGUNAS INTERFACES
         * ==================================================
         *
         * Una cámara puede encenderse y conectarse,
         * pero en este ejemplo no es programable.
         */

        CamaraInterfaces camara =
                new CamaraInterfaces(
                        "Cámara principal",
                        "192.168.1.50"
                );

        System.out.println("\nCÁMARA");
        System.out.println("----------------------------------------");

        camara.encender();
        camara.conectar();
        camara.capturarImagen();
        camara.desconectar();
        camara.apagar();

        /*
         * ==================================================
         * MÉTODO QUE RECIBE UNA INTERFAZ
         * ==================================================
         */

        System.out.println("\nMÉTODO POLIMÓRFICO");
        System.out.println("----------------------------------------");

        activarDispositivo(robot);

        activarDispositivo(camara);

        /*
         * Ambos objetos pueden enviarse porque las dos
         * clases implementan Encendible.
         */

        conectarDispositivo(robot);

        conectarDispositivo(camara);

        /*
         * Solamente el robot puede enviarse a este método,
         * porque la cámara no implementa Programable.
         */

        programarDispositivo(
                robot,
                "Regresar a la estación"
        );

        /*
         * Esta instrucción no compilaría:
         *
         * programarDispositivo(
         *         camara,
         *         "Tomar fotografía"
         * );
         */

        /*
         * ==================================================
         * COMPROBACIÓN CON INSTANCEOF
         * ==================================================
         */

        System.out.println("\nCOMPROBACIÓN DE INTERFACES");
        System.out.println("----------------------------------------");

        System.out.println(
                "¿El robot es Encendible?: "
                        + (robot instanceof Encendible)
        );

        System.out.println(
                "¿El robot es Programable?: "
                        + (robot instanceof Programable)
        );

        System.out.println(
                "¿El robot es Conectable?: "
                        + (robot instanceof Conectable)
        );

        System.out.println(
                "¿La cámara es Programable?: "
                        + (camara instanceof Programable)
        );

        System.out.println("\nFin del programa.");
    }

    /*
     * ==================================================
     * MÉTODO PARA OBJETOS ENCENDIBLES
     * ==================================================
     */

    public static void activarDispositivo(
            Encendible dispositivo
    ) {

        System.out.println(
                "Activando: "
                        + dispositivo
                        .getClass()
                        .getSimpleName()
        );

        dispositivo.encender();

        System.out.println(
                "Estado: "
                        + dispositivo.estaEncendido()
        );

        dispositivo.apagar();

        System.out.println("----------------------------------------");
    }

    /*
     * ==================================================
     * MÉTODO PARA OBJETOS CONECTABLES
     * ==================================================
     */

    public static void conectarDispositivo(
            Conectable dispositivo
    ) {

        System.out.println(
                "Conectando: "
                        + dispositivo
                        .getClass()
                        .getSimpleName()
        );

        dispositivo.conectar();

        System.out.println(
                "Dirección: "
                        + dispositivo.obtenerDireccionConexion()
        );

        dispositivo.desconectar();

        System.out.println("----------------------------------------");
    }

    /*
     * ==================================================
     * MÉTODO PARA OBJETOS PROGRAMABLES
     * ==================================================
     */

    public static void programarDispositivo(
            Programable dispositivo,
            String tarea
    ) {

        dispositivo.programarTarea(tarea);

        dispositivo.ejecutarTarea();
    }
}

/*
 * ==================================================
 * PRIMERA INTERFAZ
 * ==================================================
 *
 * Define la capacidad de encenderse y apagarse.
 */

interface Encendible {

    void encender();

    void apagar();

    boolean estaEncendido();
}

/*
 * ==================================================
 * SEGUNDA INTERFAZ
 * ==================================================
 *
 * Define la capacidad de programar y ejecutar tareas.
 */

interface Programable {

    void programarTarea(String tarea);

    void ejecutarTarea();
}

/*
 * ==================================================
 * TERCERA INTERFAZ
 * ==================================================
 *
 * Define la capacidad de conectarse a una red.
 */

interface Conectable {

    void conectar();

    void desconectar();

    boolean estaConectado();

    String obtenerDireccionConexion();
}

/*
 * ==================================================
 * CLASE QUE IMPLEMENTA TRES INTERFACES
 * ==================================================
 *
 * Las interfaces se separan mediante comas.
 */

class RobotInterfaces implements
        Encendible,
        Programable,
        Conectable {

    private String nombre;
    private String direccionIp;

    private boolean encendido;
    private boolean conectado;

    private String tareaProgramada;

    public RobotInterfaces(
            String nombre,
            String direccionIp
    ) {

        this.nombre = nombre;
        this.direccionIp = direccionIp;

        encendido = false;
        conectado = false;

        tareaProgramada = "";
    }

    /*
     * ==================================================
     * MÉTODOS DE ENCENDIBLE
     * ==================================================
     */

    @Override
    public void encender() {

        if (encendido) {

            System.out.println(
                    nombre + " ya se encuentra encendido."
            );

            return;
        }

        encendido = true;

        System.out.println(
                nombre + " fue encendido."
        );
    }

    @Override
    public void apagar() {

        if (!encendido) {

            System.out.println(
                    nombre + " ya se encuentra apagado."
            );

            return;
        }

        /*
         * Antes de apagar el robot, desconectamos la red.
         */

        if (conectado) {

            desconectar();
        }

        encendido = false;

        System.out.println(
                nombre + " fue apagado."
        );
    }

    @Override
    public boolean estaEncendido() {

        return encendido;
    }

    /*
     * ==================================================
     * MÉTODOS DE PROGRAMABLE
     * ==================================================
     */

    @Override
    public void programarTarea(String tarea) {

        if (
                tarea == null
                        || tarea.isBlank()
        ) {

            System.out.println(
                    "No se puede programar una tarea vacía."
            );

            return;
        }

        tareaProgramada = tarea.trim();

        System.out.println(
                "Tarea programada: "
                        + tareaProgramada
        );
    }

    @Override
    public void ejecutarTarea() {

        if (!encendido) {

            System.out.println(
                    "El robot debe estar encendido "
                            + "para ejecutar una tarea."
            );

            return;
        }

        if (tareaProgramada.isBlank()) {

            System.out.println(
                    "No existe una tarea programada."
            );

            return;
        }

        System.out.println(
                nombre
                        + " está ejecutando: "
                        + tareaProgramada
        );
    }

    /*
     * ==================================================
     * MÉTODOS DE CONECTABLE
     * ==================================================
     */

    @Override
    public void conectar() {

        if (!encendido) {

            System.out.println(
                    "El robot debe estar encendido "
                            + "antes de conectarse."
            );

            return;
        }

        if (conectado) {

            System.out.println(
                    nombre + " ya está conectado."
            );

            return;
        }

        conectado = true;

        System.out.println(
                nombre
                        + " se conectó a la dirección "
                        + direccionIp
                        + "."
        );
    }

    @Override
    public void desconectar() {

        if (!conectado) {

            System.out.println(
                    nombre + " no está conectado."
            );

            return;
        }

        conectado = false;

        System.out.println(
                nombre + " fue desconectado."
        );
    }

    @Override
    public boolean estaConectado() {

        return conectado;
    }

    @Override
    public String obtenerDireccionConexion() {

        return direccionIp;
    }

    /*
     * Método propio de la clase RobotInterfaces.
     */

    public void mostrarInformacion() {

        System.out.println(
                "Nombre: " + nombre
        );

        System.out.println(
                "Dirección IP: " + direccionIp
        );

        System.out.println(
                "Encendido: " + encendido
        );

        System.out.println(
                "Conectado: " + conectado
        );
    }
}

/*
 * ==================================================
 * OTRA CLASE QUE IMPLEMENTA DOS INTERFACES
 * ==================================================
 */

class CamaraInterfaces implements
        Encendible,
        Conectable {

    private String nombre;
    private String direccionIp;

    private boolean encendida;
    private boolean conectada;

    public CamaraInterfaces(
            String nombre,
            String direccionIp
    ) {

        this.nombre = nombre;
        this.direccionIp = direccionIp;

        encendida = false;
        conectada = false;
    }

    @Override
    public void encender() {

        encendida = true;

        System.out.println(
                nombre + " fue encendida."
        );
    }

    @Override
    public void apagar() {

        if (conectada) {

            desconectar();
        }

        encendida = false;

        System.out.println(
                nombre + " fue apagada."
        );
    }

    @Override
    public boolean estaEncendido() {

        return encendida;
    }

    @Override
    public void conectar() {

        if (!encendida) {

            System.out.println(
                    "La cámara debe estar encendida "
                            + "antes de conectarse."
            );

            return;
        }

        conectada = true;

        System.out.println(
                nombre
                        + " se conectó a "
                        + direccionIp
                        + "."
        );
    }

    @Override
    public void desconectar() {

        conectada = false;

        System.out.println(
                nombre + " fue desconectada."
        );
    }

    @Override
    public boolean estaConectado() {

        return conectada;
    }

    @Override
    public String obtenerDireccionConexion() {

        return direccionIp;
    }

    /*
     * Método específico de la cámara.
     */

    public void capturarImagen() {

        if (!encendida) {

            System.out.println(
                    "La cámara debe estar encendida."
            );

            return;
        }

        System.out.println(
                nombre + " capturó una imagen."
        );
    }
}