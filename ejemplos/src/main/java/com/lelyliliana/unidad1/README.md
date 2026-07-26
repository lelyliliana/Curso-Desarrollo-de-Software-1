# Unidad 1: Fundamentos de programación en Java

Esta unidad introduce los conceptos básicos necesarios para comenzar a programar en Java.

Los ejemplos están organizados en un orden progresivo. Se recomienda ejecutarlos uno por uno y revisar los comentarios incluidos en cada archivo.

## Orden recomendado de estudio

### 1. `HolaMundo.java`

**Tema:** estructura básica de un programa Java.

Incluye:

- Declaración del paquete.
- Declaración de una clase.
- Método `main`.
- Uso de `System.out.println()`.
- Comentarios en el código.

---

### 2. `DatosPersonales.java`

**Tema:** impresión de información en consola.

Incluye:

- Diferencia entre `print` y `println`.
- Concatenación con `+`.
- Secuencias de escape.
- Organización de información en consola.

---

### 3. `TiposDeDatos.java`

**Tema:** tipos de datos en Java.

Incluye:

- `byte`.
- `short`.
- `int`.
- `long`.
- `float`.
- `double`.
- `char`.
- `boolean`.
- `String`.

---

### 4. `ConstantesYPalabrasReservadas.java`

**Tema:** constantes, nombres de variables y palabras reservadas.

Incluye:

- Uso de `final`.
- Diferencia entre variables y constantes.
- Convención `camelCase`.
- Convención `UPPER_SNAKE_CASE`.
- Palabras reservadas de Java.

---

### 5. `OperadoresAritmeticos.java`

**Tema:** operaciones matemáticas.

Incluye:

- Suma.
- Resta.
- Multiplicación.
- División.
- Módulo.
- Incremento.
- Decremento.
- División entera y decimal.

---

### 6. `OperadoresRelacionalesLogicos.java`

**Tema:** comparación de valores y operadores lógicos.

Incluye:

- `>`.
- `<`.
- `>=`.
- `<=`.
- `==`.
- `!=`.
- `&&`.
- `||`.
- `!`.

---

### 7. `AsignacionIncrementos.java`

**Tema:** operadores de asignación e incremento.

Incluye:

- `=`.
- `+=`.
- `-=`.
- `*=`.
- `/=`.
- Incremento en prefijo.
- Incremento en sufijo.
- Decremento.

---

### 8. `EntradaDatosScanner.java`

**Tema:** entrada de datos desde la consola.

Incluye:

- Importación de `Scanner`.
- Uso de `nextLine()`.
- Uso de `nextInt()`.
- Uso de `nextDouble()`.
- Manejo del salto de línea pendiente.
- Cierre de `Scanner`.

---

### 9. `ConversionTiempo.java`

**Tema:** aplicación de variables y operadores.

Convierte una cantidad total de segundos en:

- Horas.
- Minutos.
- Segundos.

Incluye división entera y operador módulo.

---

### 10. `CondicionalSimple.java`

**Tema:** estructura `if`.

Permite ejecutar instrucciones solamente cuando una condición es verdadera.

---

### 11. `CondicionalDoble.java`

**Tema:** estructura `if-else`.

Permite elegir entre dos caminos posibles.

Ejemplos incluidos:

- Mayor o menor de edad.
- Número par o impar.
- Aprobado o reprobado.

---

### 12. `CondicionalMultiple.java`

**Tema:** estructura `if`, `else if` y `else`.

Permite evaluar varias condiciones.

Ejemplos incluidos:

- Clasificación de una nota.
- Clasificación por edad.
- Validación de rangos.

---

### 13. `CondicionesCompuestas.java`

**Tema:** combinación de varias condiciones.

Incluye:

- Operador AND `&&`.
- Operador OR `||`.
- Operador NOT `!`.
- Uso de paréntesis en expresiones lógicas.
- Validación de varios requisitos.

---

### 14. `OperadorTernario.java`

**Tema:** decisiones cortas.

Utiliza la estructura:

```java
condicion ? valorVerdadero : valorFalso
```

Incluye ejemplos con:

- Edad.
- Notas.
- Números pares e impares.
- Descuentos.

---

### 15. `EstructuraSwitch.java`

**Tema:** selección entre varias opciones.

Incluye:

- `switch`.
- `case`.
- `break`.
- `default`.
- Menú de operaciones.

---

### 16. `CicloFor.java`

**Tema:** repeticiones conocidas.

Incluye:

- Ciclo `for`.
- Variable de control.
- Contadores.
- Acumuladores.
- Registro de notas.
- Cálculo de promedio.

---

### 17. `CicloWhile.java`

**Tema:** repeticiones controladas por una condición.

Incluye:

- Inicialización.
- Condición.
- Actualización.
- Validación de datos.
- Contraseña.
- Tabla de multiplicar.
- Riesgo de ciclos infinitos.

---

### 18. `CicloWhileCentinela.java`

**Tema:** cantidad desconocida de datos.

Incluye:

- Uso de un valor centinela.
- Registro de notas.
- Contadores.
- Acumuladores.
- Cálculo de promedio.

---

### 19. `CicloDoWhile.java`

**Tema:** ciclo que se ejecuta al menos una vez.

Incluye:

- Diferencia entre `while` y `do-while`.
- Validación de notas.
- Validación de contraseña.
- Menú repetitivo.

---

### 20. `ProgramaIntegradorUnidad1.java`

**Tema:** integración de los contenidos de la unidad.

Permite:

- Registrar estudiantes.
- Capturar tres notas.
- Validar datos.
- Calcular la nota definitiva.
- Clasificar estudiantes.
- Contar aprobados y reprobados.
- Calcular el promedio general.
- Identificar la nota más alta y la más baja.

## Ruta de los ejemplos

```text
src/main/java/com/lelyliliana/unidad1
```

## Compilación

Desde la carpeta `ejemplos`, ejecutar:

```bash
mvn clean compile
```

## Ejecución de un ejemplo

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad1.HolaMundo"
```

Para ejecutar otro archivo, cambia `HolaMundo` por el nombre de la clase correspondiente.

## Recomendación para los estudiantes

Antes de avanzar al siguiente ejemplo:

1. Leer los comentarios del código.
2. Ejecutar el programa.
3. Revisar la salida en consola.
4. Modificar algunos valores.
5. Ejecutar nuevamente.
6. Explicar qué hace cada instrucción.