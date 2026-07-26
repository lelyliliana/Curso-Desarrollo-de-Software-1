# Unidad 3: IDE, excepciones, cadenas y colecciones

Esta unidad profundiza en el uso del entorno de desarrollo y en herramientas fundamentales de Java para construir programas más organizados y robustos.

Los ejemplos están organizados de forma progresiva. Se recomienda ejecutarlos en el orden indicado.

## Orden recomendado de estudio

### 1. `UsoIDE.java`

**Tema:** organización de un proyecto y uso del IDE.

Incluye:

- Paquetes.
- Método `main`.
- Autocompletado.
- Detección de errores.
- Navegación entre métodos.
- Ejecución desde Visual Studio Code.

---

### 2. `ExcepcionDivision.java`

**Tema:** manejo básico de excepciones.

Incluye:

- `try`.
- `catch`.
- `finally`.
- `ArithmeticException`.
- División entre cero.

---

### 3. `ExcepcionEntradaDatos.java`

**Tema:** control de datos incorrectos.

Incluye:

- `InputMismatchException`.
- Validación de enteros y decimales.
- Limpieza de datos inválidos con `nextLine()`.
- Repetición hasta obtener un dato correcto.

---

### 4. `ExcepcionesMultiples.java`

**Tema:** varios bloques `catch`.

Incluye:

- `InputMismatchException`.
- `ArithmeticException`.
- `ArrayIndexOutOfBoundsException`.
- `Exception`.
- Orden de los bloques `catch`.

---

### 5. `LanzarExcepcion.java`

**Tema:** generación intencional de excepciones.

Incluye:

- Uso de `throw`.
- `IllegalArgumentException`.
- Validación de edad, notas y valores.
- Captura de excepciones creadas manualmente.

---

### 6. `PropagarExcepcion.java`

**Tema:** propagación de excepciones.

Incluye:

- Uso de `throws`.
- Diferencia entre `throw` y `throws`.
- Excepciones verificadas.
- Propagación hacia el método que realiza el llamado.

---

### 7. `MetodosString.java`

**Tema:** métodos básicos de cadenas.

Incluye:

- `length()`.
- `charAt()`.
- `toUpperCase()`.
- `toLowerCase()`.
- `trim()`.
- Inmutabilidad de `String`.

---

### 8. `ComparacionCadenas.java`

**Tema:** comparación de cadenas.

Incluye:

- Diferencia entre `==` y `equals()`.
- `equalsIgnoreCase()`.
- Comparación de referencias.
- Comparación de contenido.
- Validación de usuario y contraseña.

---

### 9. `BusquedaEnCadenas.java`

**Tema:** búsqueda dentro de textos.

Incluye:

- `contains()`.
- `indexOf()`.
- `lastIndexOf()`.
- `startsWith()`.
- `endsWith()`.
- Uso de `-1` cuando no se encuentra un texto.

---

### 10. `ExtraccionCadenas.java`

**Tema:** extracción y modificación de cadenas.

Incluye:

- `substring()`.
- `replace()`.
- `split()`.
- Extracción de nombres, fechas y correos.
- Uso de índices.

---

### 11. `ValidacionCadenas.java`

**Tema:** validación de textos.

Incluye:

- `isEmpty()`.
- `isBlank()`.
- `trim()`.
- Validación de longitud.
- Validación de usuario.
- Validación de contraseña.
- Validación básica de correo.

---

### 12. `StringBuilderEjemplo.java`

**Tema:** construcción eficiente de cadenas.

Incluye:

- `StringBuilder`.
- `append()`.
- `insert()`.
- `replace()`.
- `delete()`.
- `reverse()`.
- `toString()`.

---

### 13. `PasoPorValor.java`

**Tema:** paso por valor con tipos primitivos.

Incluye:

- Copia de valores al enviar parámetros.
- Diferencia entre modificar una copia y retornar un nuevo valor.
- Ejemplos con `int`, `double`, `boolean` y `char`.

---

### 14. `ReferenciaObjetos.java`

**Tema:** comportamiento de objetos al enviarlos a métodos.

Incluye:

- Copia del valor de la referencia.
- Modificación de atributos.
- Reasignación local de referencias.
- Retorno de objetos.
- Varias variables apuntando al mismo objeto.

---

### 15. `ClasesUtilitarias.java`

**Tema:** clases de apoyo del lenguaje.

Incluye:

- `Math`.
- `Random`.
- `Arrays`.
- `Collections`.
- Operaciones matemáticas.
- Valores aleatorios.
- Ordenamiento de arreglos y listas.

---

### 16. `PaquetesSistema.java`

**Tema:** paquetes comunes de Java.

Incluye:

- `java.lang`.
- `java.util`.
- `java.time`.
- Importación de clases.
- Fechas y horas.
- Formato de fechas.
- Uso de clases del sistema.

---

### 17. `SobrecargaUnidad3.java`

**Tema:** sobrecarga de métodos.

Incluye:

- Mismo nombre con distintos parámetros.
- Sobrecarga por cantidad.
- Sobrecarga por tipo.
- Sobrecarga por orden de parámetros.
- Selección automática del método.

---

### 18. `ArrayListBasico.java`

**Tema:** uso básico de listas dinámicas.

Incluye:

- Crear un `ArrayList`.
- `add()`.
- `get()`.
- `set()`.
- `remove()`.
- `size()`.
- `contains()`.
- `clear()`.

---

### 19. `ArrayListObjetos.java`

**Tema:** almacenamiento de objetos en un `ArrayList`.

Incluye:

- Clase propia.
- Lista de objetos.
- Búsqueda por atributos.
- Modificación.
- Eliminación.
- Cálculo del valor total del inventario.

---

### 20. `RecorrerArrayList.java`

**Tema:** recorrido de listas.

Incluye:

- `for` con índices.
- `for-each`.
- Recorrido inverso.
- Modificación con `set()`.
- Búsqueda.
- Acumuladores y contadores.

---

### 21. `Enumerados.java`

**Tema:** tipos enumerados.

Incluye:

- Declaración de `enum`.
- Variables de tipo enumerado.
- `values()`.
- `name()`.
- `ordinal()`.
- Comparación con `==`.
- Enumerados con atributos y métodos.

---

### 22. `EnumConSwitch.java`

**Tema:** conversión y evaluación de enumerados.

Incluye:

- `valueOf()`.
- Normalización con `trim()` y `toUpperCase()`.
- Manejo de `IllegalArgumentException`.
- `switch` tradicional.
- `switch` moderno con flechas.

---

### 23. `ProgramaIntegradorUnidad3.java`

**Tema:** sistema básico de inventario.

Integra:

- Cadenas.
- Validación de textos.
- Excepciones.
- `throw`.
- `InputMismatchException`.
- `IllegalArgumentException`.
- `ArrayList` de objetos.
- Enumerados.
- `valueOf()`.
- `switch`.
- `StringBuilder`.
- Búsqueda, modificación y eliminación.

## Ruta de los ejemplos

```text
src/main/java/com/lelyliliana/unidad3
```

## Compilación

Desde la carpeta `ejemplos`, ejecutar:

```bash
mvn clean compile
```

## Ejecución de un ejemplo

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad3.UsoIDE"
```

Para ejecutar otro programa, reemplaza `UsoIDE` por el nombre de la clase correspondiente.

Ejemplo:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad3.ProgramaIntegradorUnidad3"
```

## Recomendación para los estudiantes

Antes de avanzar al siguiente ejemplo:

1. Leer los comentarios del código.
2. Ejecutar el programa.
3. Observar la salida en consola.
4. Probar datos correctos e incorrectos.
5. Modificar algunos valores.
6. Ejecutar nuevamente.
7. Explicar con palabras propias qué hace cada parte.