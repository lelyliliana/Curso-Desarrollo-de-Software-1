# Ejemplos del curso Desarrollo de Software I

Este directorio contiene los ejemplos desarrollados durante las unidades del curso **Desarrollo de Software I**, utilizando Java.

Los archivos están organizados de forma progresiva, desde conceptos básicos hasta fundamentos de programación orientada a objetos.

## Ubicación de los archivos Java

```text
src/main/java/com/lelyliliana
```

# Unidad 2

## Orden recomendado de estudio

### 1. `U2_01_EjemploClaseObjeto.java`
**Tema:** clases, atributos, métodos y objetos.

Explica que una clase funciona como plantilla y que un objeto es una instancia creada a partir de ella.

### 2. `U2_02_VariosObjetos.java`
**Tema:** varios objetos de una misma clase.

Muestra cómo una misma clase puede crear diferentes objetos con valores propios.

### 3. `U2_03_EjemploConstructor.java`
**Tema:** constructores.

Permite inicializar los atributos de un objeto en el momento de crearlo.

### 4. `U2_04_ModificadoresAcceso.java`
**Tema:** modificadores `public`, `private` y `protected`.

Explica cómo controlar el acceso a atributos y métodos.

### 5. `U2_05_ClasePrincipal.java`
**Tema:** clase principal y método `main`.

**Clase auxiliar:** `U2_05_CalculadoraBasica.java`, utilizada por `U2_05_ClasePrincipal.java` para demostrar la separación entre la clase principal y una clase de apoyo.

Diferencia la clase donde inicia el programa de otras clases auxiliares.

### 6. `U2_06_MetodoBasico.java`
**Tema:** definición y llamado de métodos.

Introduce la estructura de un método y la reutilización de código.

### 7. `U2_07_CalculadoraVoid.java`
**Tema:** métodos con parámetros y sin retorno.

Muestra cómo recibir datos mediante parámetros usando un método `void`.

### 8. `U2_08_CalculadoraCompleta.java`
**Tema:** métodos con retorno.

Implementa suma, resta, multiplicación y división utilizando `return`.

### 9. `U2_09_MetodoConScanner.java`
**Tema:** entrada de datos y métodos.

Solicita datos con `Scanner` y los envía como argumentos a diferentes métodos.

### 10. `U2_10_SobrecargaMetodos.java`
**Tema:** sobrecarga de métodos.

Explica cómo crear varios métodos con el mismo nombre, pero con parámetros diferentes.

### 11. `U2_11_MetodosEstaticos.java`
**Tema:** métodos estáticos.

Muestra cómo llamar métodos directamente desde la clase sin crear objetos.

### 12. `U2_12_MetodoRecursivo.java`
**Tema:** recursividad.

Presenta un método que se llama a sí mismo para calcular el factorial de un número.

### 13. `U2_13_GettersSetters.java`
**Tema:** encapsulamiento.

Explica cómo proteger atributos privados y acceder a ellos mediante getters y setters.

### 14. `U2_14_ClasesAbstractas.java`
**Tema:** clases y métodos abstractos.

Introduce clases base, herencia, métodos abstractos y sobrescritura con `@Override`.

# Recomendación para los estudiantes

Se recomienda trabajar los ejemplos en el orden indicado:

1. Leer los comentarios.
2. Ejecutar el programa.
3. Observar la salida en consola.
4. Modificar algunos valores.
5. Ejecutar nuevamente.
6. Explicar con palabras propias qué hace el código.

# Ejecución con Maven

Desde la carpeta `ejemplos`:

```bash
mvn compile
```

Para ejecutar una clase específica:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad2.NombreDeLaClase"
```

Ejemplo:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad2.U2_01_EjemploClaseObjeto"
```

## Docente

**Leli Liliana Díaz Izquierdo**  
Curso: Desarrollo de Software I
