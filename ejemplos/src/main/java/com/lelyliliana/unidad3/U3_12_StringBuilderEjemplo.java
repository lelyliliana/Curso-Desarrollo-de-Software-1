package com.lelyliliana.unidad3;

/*
 * EJEMPLO 12 - UNIDAD 3
 *
 * Tema:
 * Construcción y modificación eficiente de cadenas
 * utilizando StringBuilder.
 *
 * String es inmutable:
 * cada modificación genera un nuevo objeto.
 *
 * StringBuilder es mutable:
 * permite modificar el mismo objeto varias veces.
 *
 * Métodos utilizados:
 *
 * append()   -> agrega contenido al final.
 * insert()   -> inserta contenido en una posición.
 * replace()  -> reemplaza una parte del texto.
 * delete()   -> elimina una parte del texto.
 * reverse()  -> invierte el contenido.
 * length()   -> obtiene la longitud.
 * toString() -> convierte el resultado en String.
 */

public class U3_12_StringBuilderEjemplo {

    public static void main(String[] args) {

        System.out.println("USO DE STRINGBUILDER");
        System.out.println("----------------------------------------");

        /*
         * ==================================================
         * CREACIÓN DEL OBJETO STRINGBUILDER
         * ==================================================
         */

        StringBuilder mensaje =
                new StringBuilder();

        /*
         * Al principio, el objeto está vacío.
         */
        System.out.println(
                "Contenido inicial: [" + mensaje + "]"
        );

        System.out.println(
                "Longitud inicial: " + mensaje.length()
        );

        /*
         * ==================================================
         * MÉTODO APPEND()
         * ==================================================
         *
         * append() agrega contenido al final.
         */

        mensaje.append("Hola");
        mensaje.append(", ");
        mensaje.append("bienvenidos");
        mensaje.append(" al curso de Java.");

        System.out.println("\nMÉTODO append()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Mensaje construido: " + mensaje
        );

        /*
         * append() también acepta otros tipos de datos.
         */

        StringBuilder datos =
                new StringBuilder();

        String nombre = "Laura";
        int edad = 25;
        double promedio = 4.5;
        boolean activa = true;

        datos.append("Nombre: ");
        datos.append(nombre);
        datos.append("\nEdad: ");
        datos.append(edad);
        datos.append("\nPromedio: ");
        datos.append(promedio);
        datos.append("\nActiva: ");
        datos.append(activa);

        System.out.println("\nCONSTRUCCIÓN DE DATOS");
        System.out.println("----------------------------------------");

        System.out.println(datos);

        /*
         * ==================================================
         * ENCADENAMIENTO DE MÉTODOS
         * ==================================================
         *
         * append() retorna el mismo objeto, por eso
         * puede encadenarse.
         */

        StringBuilder resumen =
                new StringBuilder();

        resumen
                .append("Estudiante: ")
                .append(nombre)
                .append(" | Edad: ")
                .append(edad)
                .append(" | Promedio: ")
                .append(promedio);

        System.out.println("\nMÉTODOS ENCADENADOS");
        System.out.println("----------------------------------------");

        System.out.println(resumen);

        /*
         * ==================================================
         * MÉTODO INSERT()
         * ==================================================
         *
         * insert(posicion, texto) agrega contenido
         * en una posición específica.
         */

        StringBuilder frase =
                new StringBuilder("Java es divertido.");

        frase.insert(8, "muy ");

        System.out.println("\nMÉTODO insert()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Resultado: " + frase
        );

        /*
         * Resultado:
         *
         * Java es muy divertido.
         */

        /*
         * ==================================================
         * MÉTODO REPLACE()
         * ==================================================
         *
         * replace(inicio, fin, textoNuevo)
         * reemplaza una parte del contenido.
         *
         * La posición final no se incluye.
         */

        StringBuilder lenguaje =
                new StringBuilder("Programación en Python");

        int inicioPython =
                lenguaje.indexOf("Python");

        int finPython =
                inicioPython + "Python".length();

        lenguaje.replace(
                inicioPython,
                finPython,
                "Java"
        );

        System.out.println("\nMÉTODO replace()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Resultado: " + lenguaje
        );

        /*
         * ==================================================
         * MÉTODO DELETE()
         * ==================================================
         *
         * delete(inicio, fin) elimina un fragmento.
         *
         * La posición final no se incluye.
         */

        StringBuilder texto =
                new StringBuilder(
                        "Desarrollo de Software avanzado"
                );

        int inicioAvanzado =
                texto.indexOf(" avanzado");

        if (inicioAvanzado != -1) {

            texto.delete(
                    inicioAvanzado,
                    texto.length()
            );
        }

        System.out.println("\nMÉTODO delete()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Resultado: " + texto
        );

        /*
         * ==================================================
         * MÉTODO REVERSE()
         * ==================================================
         *
         * reverse() invierte el orden de los caracteres.
         */

        StringBuilder palabra =
                new StringBuilder("Java");

        palabra.reverse();

        System.out.println("\nMÉTODO reverse()");
        System.out.println("----------------------------------------");

        System.out.println(
                "Java invertido: " + palabra
        );

        /*
         * ==================================================
         * CONVERSIÓN A STRING
         * ==================================================
         *
         * toString() convierte el StringBuilder
         * en un objeto String.
         */

        String resultadoFinal =
                resumen.toString();

        System.out.println("\nCONVERSIÓN A STRING");
        System.out.println("----------------------------------------");

        System.out.println(
                "Resultado final: " + resultadoFinal
        );

        System.out.println(
                "Tipo lógico del dato: String"
        );

        /*
         * ==================================================
         * EJEMPLO CON CICLO
         * ==================================================
         *
         * StringBuilder es especialmente útil cuando
         * se construyen textos dentro de ciclos.
         */

        StringBuilder tabla =
                new StringBuilder();

        int numeroTabla = 5;

        for (int i = 1; i <= 10; i++) {

            tabla
                    .append(numeroTabla)
                    .append(" x ")
                    .append(i)
                    .append(" = ")
                    .append(numeroTabla * i)
                    .append("\n");
        }

        System.out.println("\nTABLA DE MULTIPLICAR");
        System.out.println("----------------------------------------");

        System.out.print(tabla);

        /*
         * ==================================================
         * DIFERENCIA CON STRING
         * ==================================================
         */

        String textoString = "";

        for (int i = 1; i <= 5; i++) {

            /*
             * En cada repetición se genera una nueva cadena.
             */
            textoString =
                    textoString + i + " ";
        }

        StringBuilder textoBuilder =
                new StringBuilder();

        for (int i = 1; i <= 5; i++) {

            /*
             * Se modifica el mismo objeto.
             */
            textoBuilder
                    .append(i)
                    .append(" ");
        }

        System.out.println("\nCOMPARACIÓN");
        System.out.println("----------------------------------------");

        System.out.println(
                "Resultado con String: "
                        + textoString
        );

        System.out.println(
                "Resultado con StringBuilder: "
                        + textoBuilder
        );
    }
}