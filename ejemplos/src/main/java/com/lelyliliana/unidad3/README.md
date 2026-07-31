# Unidad 3: IDE, excepciones, cadenas y colecciones

Esta unidad profundiza en el uso del entorno de desarrollo y en herramientas fundamentales de Java para construir programas más organizados y robustos.

Los ejemplos están organizados de forma progresiva. Se recomienda ejecutarlos en el orden indicado.

## Orden recomendado de estudio

### 1. `U3_01_UsoIDE.java`

**Tema:** organización de un proyecto y uso del IDE.

Incluye:

- Paquetes.
- Método `main`.
- Autocompletado.
- Detección de errores.
- Navegación entre métodos.
- Ejecución desde Visual Studio Code.

---

### 2. `U3_02_ExcepcionDivision.java`

**Tema:** manejo básico de excepciones.

Incluye:

- `try`.
- `catch`.
- `finally`.
- `ArithmeticException`.
- División entre cero.

---

### 3. `U3_03_ExcepcionEntradaDatos.java`

**Tema:** control de datos incorrectos.

Incluye:

- `InputMismatchException`.
- Validación de enteros y decimales.
- Limpieza de datos inválidos con `nextLine()`.
- Repetición hasta obtener un dato correcto.

---

### 4. `U3_04_ExcepcionesMultiples.java`

**Tema:** varios bloques `catch`.

Incluye:

- `InputMismatchException`.
- `ArithmeticException`.
- `ArrayIndexOutOfBoundsException`.
- `Exception`.
- Orden de los bloques `catch`.

---

### 5. `U3_05_LanzarExcepcion.java`

**Tema:** generación intencional de excepciones.

Incluye:

- Uso de `throw`.
- `IllegalArgumentException`.
- Validación de edad, notas y valores.
- Captura de excepciones creadas manualmente.

---

### 6. `U3_06_PropagarExcepcion.java`

**Tema:** propagación de excepciones.

Incluye:

- Uso de `throws`.
- Diferencia entre `throw` y `throws`.
- Excepciones verificadas.
- Propagación hacia el método que realiza el llamado.

---

### 7. `U3_07_MetodosString.java`

**Tema:** métodos básicos de cadenas.

Incluye:

- `length()`.
- `charAt()`.
- `toUpperCase()`.
- `toLowerCase()`.
- `trim()`.
- Inmutabilidad de `String`.

---

### 8. `U3_08_ComparacionCadenas.java`

**Tema:** comparación de cadenas.

Incluye:

- Diferencia entre `==` y `equals()`.
- `equalsIgnoreCase()`.
- Comparación de referencias.
- Comparación de contenido.
- Validación de usuario y contraseña.

---

### 9. `U3_09_BusquedaEnCadenas.java`

**Tema:** búsqueda dentro de textos.

Incluye:

- `contains()`.
- `indexOf()`.
- `lastIndexOf()`.
- `startsWith()`.
- `endsWith()`.
- Uso de `-1` cuando no se encuentra un texto.

---

### 10. `U3_10_ExtraccionCadenas.java`

**Tema:** extracción y modificación de cadenas.

Incluye:

- `substring()`.
- `replace()`.
- `split()`.
- Extracción de nombres, fechas y correos.
- Uso de índices.

---

### 11. `U3_11_ValidacionCadenas.java`

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

### 12. `U3_12_StringBuilderEjemplo.java`

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

### 13. `U3_13_PasoPorValor.java`

**Tema:** paso por valor con tipos primitivos.

Incluye:

- Copia de valores al enviar parámetros.
- Diferencia entre modificar una copia y retornar un nuevo valor.
- Ejemplos con `int`, `double`, `boolean` y `char`.

---

### 14. `U3_14_ReferenciaObjetos.java`

**Tema:** comportamiento de objetos al enviarlos a métodos.

Incluye:

- Copia del valor de la referencia.
- Modificación de atributos.
- Reasignación local de referencias.
- Retorno de objetos.
- Varias variables apuntando al mismo objeto.

---

### 15. `U3_15_ClasesUtilitarias.java`

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

### 16. `U3_16_PaquetesSistema.java`

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

### 17. `U3_17_SobrecargaUnidad3.java`

**Tema:** sobrecarga de métodos.

Incluye:

- Mismo nombre con distintos parámetros.
- Sobrecarga por cantidad.
- Sobrecarga por tipo.
- Sobrecarga por orden de parámetros.
- Selección automática del método.

---

### 18. `U3_18_ArrayListBasico.java`

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

### 19. `U3_19_ArrayListObjetos.java`

**Tema:** almacenamiento de objetos en un `ArrayList`.

Incluye:

- Clase propia.
- Lista de objetos.
- Búsqueda por atributos.
- Modificación.
- Eliminación.
- Cálculo del valor total del inventario.

---

### 20. `U3_20_RecorrerArrayList.java`

**Tema:** recorrido de listas.

Incluye:

- `for` con índices.
- `for-each`.
- Recorrido inverso.
- Modificación con `set()`.
- Búsqueda.
- Acumuladores y contadores.

---

### 21. `U3_21_Enumerados.java`

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

### 22. `U3_22_EnumConSwitch.java`

**Tema:** conversión y evaluación de enumerados.

Incluye:

- `valueOf()`.
- Normalización con `trim()` y `toUpperCase()`.
- Manejo de `IllegalArgumentException`.
- `switch` tradicional.
- `switch` moderno con flechas.

---

### 23. `U3_23_ProgramaIntegradorUnidad3.java`

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
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad3.U3_01_UsoIDE"
```

Para ejecutar otro programa, reemplaza `U3_01_UsoIDE` por el nombre de la clase correspondiente.

Ejemplo:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad3.U3_23_ProgramaIntegradorUnidad3"
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