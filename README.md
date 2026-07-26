# Ejemplos del curso Desarrollo de Software I

Este proyecto contiene ejemplos prácticos desarrollados en Java para apoyar el aprendizaje progresivo de los temas del curso **Desarrollo de Software I**.

Los programas están organizados por unidades para facilitar su estudio, ejecución y consulta.

## Estructura del proyecto

```text
ejemplos/
├── README.md
├── pom.xml
└── src/main/java/com/lelyliliana/
    ├── unidad1/
    └── unidad2/
```

## Unidad 1

La Unidad 1 aborda los fundamentos de programación en Java.

Temas incluidos:

- Estructura básica de un programa.
- Impresión de información en consola.
- Variables y tipos de datos.
- Constantes.
- Operadores aritméticos.
- Operadores relacionales y lógicos.
- Operadores de asignación.
- Entrada de datos con `Scanner`.
- Condicionales.
- Operador ternario.
- Estructura `switch`.
- Ciclos `for`, `while` y `do-while`.
- Contadores y acumuladores.
- Valores centinela.
- Programa integrador.

Ruta:

```text
src/main/java/com/lelyliliana/unidad1
```

## Unidad 2

La Unidad 2 aborda los fundamentos de la programación orientada a objetos en Java.

Temas incluidos:

- Clases y objetos.
- Atributos y métodos.
- Constructores.
- Modificadores de acceso.
- Métodos con parámetros.
- Métodos con retorno.
- Sobrecarga de métodos.
- Métodos estáticos.
- Recursividad.
- Getters y setters.
- Encapsulamiento.
- Clases y métodos abstractos.

Ruta:

```text
src/main/java/com/lelyliliana/unidad2
```

## Compilación del proyecto

Desde la carpeta `ejemplos`, ejecutar:

```bash
mvn clean compile
```

## Ejecución de una clase

Para ejecutar una clase específica de la Unidad 1:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad1.HolaMundo"
```

Ejemplo de la Unidad 2:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad2.EjemploClaseObjeto"
```

## Recomendación de estudio

Se recomienda:

1. Leer los comentarios del código.
2. Ejecutar cada programa.
3. Observar la salida en consola.
4. Modificar algunos valores.
5. Volver a ejecutar.
6. Explicar con palabras propias qué hace cada parte.

## Docente

**Leli Liliana Díaz Izquierdo**  
Curso: Desarrollo de Software I