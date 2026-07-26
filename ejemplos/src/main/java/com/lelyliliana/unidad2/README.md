# Ejemplos del curso Desarrollo de Software I

Este directorio contiene los ejemplos desarrollados durante las unidades del curso **Desarrollo de Software I**, utilizando Java.

Los archivos están organizados de forma progresiva, desde conceptos básicos hasta fundamentos de programación orientada a objetos.

## Ubicación de los archivos Java

```text
src/main/java/com/lelyliliana
```

# Unidad 2

## Orden recomendado de estudio

### 1. `EjemploClaseObjeto.java`
**Tema:** clases, atributos, métodos y objetos.

Explica que una clase funciona como plantilla y que un objeto es una instancia creada a partir de ella.

### 2. `VariosObjetos.java`
**Tema:** varios objetos de una misma clase.

Muestra cómo una misma clase puede crear diferentes objetos con valores propios.

### 3. `EjemploConstructor.java`
**Tema:** constructores.

Permite inicializar los atributos de un objeto en el momento de crearlo.

### 4. `ModificadoresAcceso.java`
**Tema:** modificadores `public`, `private` y `protected`.

Explica cómo controlar el acceso a atributos y métodos.

### 5. `ClasePrincipal.java`
**Tema:** clase principal y método `main`.

Diferencia la clase donde inicia el programa de otras clases auxiliares.

### 6. `MetodoBasico.java`
**Tema:** definición y llamado de métodos.

Introduce la estructura de un método y la reutilización de código.

### 7. `CalculadoraVoid.java`
**Tema:** métodos con parámetros y sin retorno.

Muestra cómo recibir datos mediante parámetros usando un método `void`.

### 8. `CalculadoraCompleta.java`
**Tema:** métodos con retorno.

Implementa suma, resta, multiplicación y división utilizando `return`.

### 9. `MetodoConScanner.java`
**Tema:** entrada de datos y métodos.

Solicita datos con `Scanner` y los envía como argumentos a diferentes métodos.

### 10. `SobrecargaMetodos.java`
**Tema:** sobrecarga de métodos.

Explica cómo crear varios métodos con el mismo nombre, pero con parámetros diferentes.

### 11. `MetodosEstaticos.java`
**Tema:** métodos estáticos.

Muestra cómo llamar métodos directamente desde la clase sin crear objetos.

### 12. `MetodoRecursivo.java`
**Tema:** recursividad.

Presenta un método que se llama a sí mismo para calcular el factorial de un número.

### 13. `GettersSetters.java`
**Tema:** encapsulamiento.

Explica cómo proteger atributos privados y acceder a ellos mediante getters y setters.

### 14. `ClasesAbstractas.java`
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
mvn exec:java -Dexec.mainClass="com.lelyliliana.NombreDeLaClase"
```

Ejemplo:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.EjemploClaseObjeto"
```

## Docente

**Leli Liliana Díaz Izquierdo**  
Curso: Desarrollo de Software I
