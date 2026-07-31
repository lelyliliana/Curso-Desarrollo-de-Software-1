# Ejemplos del curso Desarrollo de Software I

Este proyecto contiene ejemplos prácticos desarrollados en Java para apoyar el aprendizaje progresivo de los temas del curso **Desarrollo de Software I**.

Los programas están organizados por unidades para facilitar su estudio, ejecución y consulta.

## Estructura del proyecto

```text
ejemplos/
├── pom.xml
└── src/main/java/com/lelyliliana/
    ├── unidad1/
    ├── unidad2/
    ├── unidad3/
    └── unidad4/
```

Cada unidad contiene sus archivos Java y un `README.md` con la descripción de los contenidos y el orden recomendado de estudio.

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
ejemplos/src/main/java/com/lelyliliana/unidad1
```

Ejemplo inicial:

```text
U1_01_HolaMundo.java
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
ejemplos/src/main/java/com/lelyliliana/unidad2
```

Ejemplo inicial:

```text
U2_01_EjemploClaseObjeto.java
```

## Unidad 3

La Unidad 3 aborda el uso del entorno de desarrollo, el manejo de excepciones, las cadenas, las colecciones y los tipos enumerados en Java.

Temas incluidos:

- Organización del proyecto en el IDE.
- Manejo de excepciones.
- Uso de `try`, `catch` y `finally`.
- Uso de `throw` y `throws`.
- Métodos de la clase `String`.
- Comparación, búsqueda y extracción de cadenas.
- Validación de textos.
- Uso de `StringBuilder`.
- Paso por valor.
- Referencias de objetos.
- Clases utilitarias.
- Paquetes `java.lang`, `java.util` y `java.time`.
- Sobrecarga de métodos.
- Uso de `ArrayList`.
- Recorrido de listas.
- Tipos enumerados.
- Conversión con `valueOf()`.
- Programa integrador de inventario.

Ruta:

```text
ejemplos/src/main/java/com/lelyliliana/unidad3
```

Ejemplo inicial:

```text
U3_01_UsoIDE.java
```

## Unidad 4

La Unidad 4 aborda conceptos avanzados de programación orientada a objetos y el desarrollo de interfaces gráficas con Java Swing.

Temas incluidos:

- Herencia.
- Uso de `super`.
- Sobrescritura de métodos.
- Polimorfismo.
- Listas polimórficas.
- Clases abstractas.
- Interfaces.
- Implementación de múltiples interfaces.
- Composición de objetos.
- Ventanas con `JFrame`.
- Paneles y administradores de diseño.
- Controles gráficos.
- Manejo de eventos.
- Cuadros de diálogo con `JOptionPane`.
- Formularios.
- Validación de campos.
- Expresiones regulares.
- Tablas con `JTable`.
- Programa integrador.

Ruta:

```text
ejemplos/src/main/java/com/lelyliliana/unidad4
```

Ejemplo inicial:

```text
U4_01_HerenciaBasica.java
```

## Requisitos

- Java JDK 21.
- Maven.
- Un entorno de desarrollo como Visual Studio Code, IntelliJ IDEA, Eclipse o NetBeans.

## Compilación del proyecto

Desde la carpeta `ejemplos`, ejecuta:

```bash
mvn clean compile
```

## Ejecución de una clase

Los comandos deben ejecutarse desde la carpeta `ejemplos`, donde se encuentra el archivo `pom.xml`.

Ejemplo de la Unidad 1:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad1.U1_01_HolaMundo"
```

Ejemplo de la Unidad 2:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad2.U2_01_EjemploClaseObjeto"
```

Ejemplo de la Unidad 3:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad3.U3_01_UsoIDE"
```

Ejemplo de la Unidad 4:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad4.U4_10_VentanaBasica"
```

Para ejecutar otro programa, reemplaza el nombre completo de la clase por el correspondiente.

## Recomendación de estudio

Se recomienda:

1. Leer los comentarios incluidos en el código.
2. Ejecutar cada programa.
3. Observar la salida en consola o la interfaz gráfica.
4. Modificar algunos valores.
5. Ejecutar nuevamente.
6. Explicar con palabras propias qué hace cada parte.

## Docente

**Leli Liliana Díaz Izquierdo**  
Curso: Desarrollo de Software I