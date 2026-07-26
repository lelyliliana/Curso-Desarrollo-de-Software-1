package com.lelyliliana.unidad3;

/*
 * EJEMPLO 21 - UNIDAD 3
 *
 * Tema:
 * Declaración y uso de tipos enumerados.
 *
 * Un enum representa un conjunto limitado
 * de valores constantes relacionados.
 *
 * Ejemplos:
 *
 * - Días de la semana.
 * - Estados de un pedido.
 * - Niveles de prioridad.
 * - Tipos de usuario.
 *
 * Ventajas:
 *
 * - Evita escribir valores diferentes por error.
 * - Facilita la lectura del código.
 * - Limita las opciones permitidas.
 * - Puede incluir atributos, constructor y métodos.
 */

public class Enumerados {

    public static void main(String[] args) {

        System.out.println("TIPOS ENUMERADOS EN JAVA");
        System.out.println("========================================");

        /*
         * ==================================================
         * EJEMPLO 1: VARIABLE DE TIPO ENUM
         * ==================================================
         *
         * La variable solamente puede recibir uno de los
         * valores definidos dentro del enum.
         */

        DiaSemana diaActual =
                DiaSemana.LUNES;

        System.out.println("1. DÍA DE LA SEMANA");
        System.out.println("----------------------------------------");

        System.out.println(
                "Día seleccionado: " + diaActual
        );

        /*
         * Esto produciría un error:
         *
         * diaActual = "LUNES";
         *
         * Porque diaActual es de tipo DiaSemana,
         * no de tipo String.
         */

        /*
         * ==================================================
         * COMPARACIÓN DE ENUM
         * ==================================================
         *
         * Los valores enum pueden compararse con ==.
         */

        if (diaActual == DiaSemana.LUNES) {

            System.out.println(
                    "Es el inicio de la semana laboral."
            );
        }

        /*
         * ==================================================
         * MÉTODO VALUES()
         * ==================================================
         *
         * values() devuelve un arreglo con todos
         * los valores declarados en el enum.
         */

        System.out.println("\n2. TODOS LOS DÍAS");
        System.out.println("----------------------------------------");

        for (DiaSemana dia : DiaSemana.values()) {

            System.out.println(dia);
        }

        /*
         * ==================================================
         * MÉTODOS NAME() Y ORDINAL()
         * ==================================================
         *
         * name() devuelve el nombre exacto de la constante.
         *
         * ordinal() devuelve su posición, comenzando en cero.
         */

        System.out.println("\n3. NOMBRE Y POSICIÓN");
        System.out.println("----------------------------------------");

        for (DiaSemana dia : DiaSemana.values()) {

            System.out.println(
                    "Nombre: "
                            + dia.name()
                            + " | Posición: "
                            + dia.ordinal()
            );
        }

        /*
         * No se recomienda guardar ordinal() en bases de
         * datos porque puede cambiar si se reorganiza el enum.
         */

        /*
         * ==================================================
         * EJEMPLO 2: ESTADO DE UN PEDIDO
         * ==================================================
         */

        EstadoPedido estado =
                EstadoPedido.EN_PREPARACION;

        System.out.println("\n4. ESTADO DEL PEDIDO");
        System.out.println("----------------------------------------");

        System.out.println(
                "Estado actual: " + estado
        );

        if (estado == EstadoPedido.EN_PREPARACION) {

            System.out.println(
                    "El pedido se está preparando."
            );
        }

        /*
         * Modificamos el estado.
         */

        estado = EstadoPedido.ENVIADO;

        System.out.println(
                "Nuevo estado: " + estado
        );

        /*
         * ==================================================
         * ENUM CON ATRIBUTOS Y MÉTODOS
         * ==================================================
         *
         * Un enum también puede tener:
         *
         * - Atributos.
         * - Constructor.
         * - Métodos.
         */

        System.out.println("\n5. NIVELES DE PRIORIDAD");
        System.out.println("----------------------------------------");

        Prioridad prioridad =
                Prioridad.ALTA;

        System.out.println(
                "Prioridad: " + prioridad
        );

        System.out.println(
                "Código: " + prioridad.getCodigo()
        );

        System.out.println(
                "Descripción: "
                        + prioridad.getDescripcion()
        );

        /*
         * Recorremos todos los niveles.
         */

        System.out.println("\nLISTA DE PRIORIDADES");
        System.out.println("----------------------------------------");

        for (Prioridad nivel : Prioridad.values()) {

            System.out.println(
                    nivel
                            + " | Código: "
                            + nivel.getCodigo()
                            + " | "
                            + nivel.getDescripcion()
            );
        }

        /*
         * ==================================================
         * ENUM DENTRO DE UN OBJETO
         * ==================================================
         */

        Tarea tarea1 =
                new Tarea(
                        "Preparar clase de Java",
                        Prioridad.ALTA,
                        EstadoTarea.PENDIENTE
                );

        Tarea tarea2 =
                new Tarea(
                        "Revisar actividad",
                        Prioridad.MEDIA,
                        EstadoTarea.EN_PROCESO
                );

        System.out.println("\n6. OBJETOS CON ENUM");
        System.out.println("----------------------------------------");

        tarea1.mostrarInformacion();

        System.out.println("----------------------------------------");

        tarea2.mostrarInformacion();

        /*
         * Cambiamos el estado de una tarea.
         */

        tarea1.setEstado(
                EstadoTarea.FINALIZADA
        );

        System.out.println("\nTAREA ACTUALIZADA");
        System.out.println("----------------------------------------");

        tarea1.mostrarInformacion();

        /*
         * ==================================================
         * CONTAR ELEMENTOS SEGÚN UN ENUM
         * ==================================================
         */

        Tarea[] tareas = {
                tarea1,
                tarea2,
                new Tarea(
                        "Actualizar repositorio",
                        Prioridad.BAJA,
                        EstadoTarea.PENDIENTE
                )
        };

        int tareasPendientes = 0;
        int tareasFinalizadas = 0;

        for (Tarea tarea : tareas) {

            if (
                    tarea.getEstado()
                            == EstadoTarea.PENDIENTE
            ) {

                tareasPendientes++;
            }

            if (
                    tarea.getEstado()
                            == EstadoTarea.FINALIZADA
            ) {

                tareasFinalizadas++;
            }
        }

        System.out.println("\nRESUMEN DE TAREAS");
        System.out.println("----------------------------------------");

        System.out.println(
                "Tareas pendientes: "
                        + tareasPendientes
        );

        System.out.println(
                "Tareas finalizadas: "
                        + tareasFinalizadas
        );
    }
}

/*
 * ==================================================
 * ENUM BÁSICO
 * ==================================================
 */

enum DiaSemana {

    LUNES,
    MARTES,
    MIERCOLES,
    JUEVES,
    VIERNES,
    SABADO,
    DOMINGO
}

/*
 * ==================================================
 * ENUM PARA ESTADOS
 * ==================================================
 */

enum EstadoPedido {

    RECIBIDO,
    EN_PREPARACION,
    ENVIADO,
    ENTREGADO,
    CANCELADO
}

/*
 * ==================================================
 * ENUM CON ATRIBUTOS
 * ==================================================
 */

enum Prioridad {

    /*
     * Cada constante envía valores al constructor.
     */

    BAJA(
            1,
            "Puede atenderse con calma."
    ),

    MEDIA(
            2,
            "Debe atenderse oportunamente."
    ),

    ALTA(
            3,
            "Requiere atención prioritaria."
    );

    /*
     * Atributos del enum.
     */

    private final int codigo;
    private final String descripcion;

    /*
     * El constructor de un enum no se declara public.
     *
     * Java lo trata como privado.
     */

    Prioridad(
            int codigo,
            String descripcion
    ) {

        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

/*
 * Enum utilizado para representar el estado de una tarea.
 */

enum EstadoTarea {

    PENDIENTE,
    EN_PROCESO,
    FINALIZADA,
    CANCELADA
}

/*
 * Clase que utiliza dos tipos enum.
 */

class Tarea {

    private String nombre;
    private Prioridad prioridad;
    private EstadoTarea estado;

    public Tarea(
            String nombre,
            Prioridad prioridad,
            EstadoTarea estado
    ) {

        this.nombre = nombre;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(
            EstadoTarea estado
    ) {

        this.estado = estado;
    }

    public void mostrarInformacion() {

        System.out.println(
                "Tarea: " + nombre
        );

        System.out.println(
                "Prioridad: " + prioridad
        );

        System.out.println(
                "Descripción: "
                        + prioridad.getDescripcion()
        );

        System.out.println(
                "Estado: " + estado
        );
    }
}