# Unidad 1: Fundamentos de programación en Java

Esta unidad introduce los conceptos básicos necesarios para comenzar a programar en Java.

Los ejemplos están organizados en un orden progresivo. Se recomienda ejecutarlos uno por uno y revisar los comentarios incluidos en cada archivo.

## Orden recomendado de estudio

### 1. `U1_01_HolaMundo.java`

**Tema:** estructura básica de un programa Java.

Incluye:

- Declaración del paquete.
- Declaración de una clase.
- Método `main`.
- Uso de `System.out.println()`.
- Comentarios en el código.

---

### 2. `U1_02_DatosPersonales.java`

**Tema:** impresión de información en consola.

Incluye:

- Diferencia entre `print` y `println`.
- Concatenación con `+`.
- Secuencias de escape.
- Organización de información en consola.

---

### 3. `U1_03_TiposDeDatos.java`

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

### 4. `U1_04_ConstantesYPalabrasReservadas.java`

**Tema:** constantes, nombres de variables y palabras reservadas.

Incluye:

- Uso de `final`.
- Diferencia entre variables y constantes.
- Convención `camelCase`.
- Convención `UPPER_SNAKE_CASE`.
- Palabras reservadas de Java.

---

### 5. `U1_05_OperadoresAritmeticos.java`

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

### 6. `U1_06_OperadoresRelacionalesLogicos.java`

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

### 7. `U1_07_AsignacionIncrementos.java`

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

### 8. `U1_08_EntradaDatosScanner.java`

**Tema:** entrada de datos desde la consola.

Incluye:

- Importación de `Scanner`.
- Uso de `nextLine()`.
- Uso de `nextInt()`.
- Uso de `nextDouble()`.
- Manejo del salto de línea pendiente.
- Cierre de `Scanner`.

---

### 9. `U1_09_ConversionTiempo.java`

**Tema:** aplicación de variables y operadores.

Convierte una cantidad total de segundos en:

- Horas.
- Minutos.
- Segundos.

Incluye división entera y operador módulo.

---

### 10. `U1_10_CondicionalSimple.java`

**Tema:** estructura `if`.

Permite ejecutar instrucciones solamente cuando una condición es verdadera.

---

### 11. `U1_11_CondicionalDoble.java`

**Tema:** estructura `if-else`.

Permite elegir entre dos caminos posibles.

Ejemplos incluidos:

- Mayor o menor de edad.
- Número par o impar.
- Aprobado o reprobado.

---

### 12. `U1_12_CondicionalMultiple.java`

**Tema:** estructura `if`, `else if` y `else`.

Permite evaluar varias condiciones.

Ejemplos incluidos:

- Clasificación de una nota.
- Clasificación por edad.
- Validación de rangos.

---

### 13. `U1_13_CondicionesCompuestas.java`

**Tema:** combinación de varias condiciones.

Incluye:

- Operador AND `&&`.
- Operador OR `||`.
- Operador NOT `!`.
- Uso de paréntesis en expresiones lógicas.
- Validación de varios requisitos.

---

### 14. `U1_14_OperadorTernario.java`

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

### 15. `U1_15_EstructuraSwitch.java`

**Tema:** selección entre varias opciones.

Incluye:

- `switch`.
- `case`.
- `break`.
- `default`.
- Menú de operaciones.

---

### 16. `U1_16_CicloFor.java`

**Tema:** repeticiones conocidas.

Incluye:

- Ciclo `for`.
- Variable de control.
- Contadores.
- Acumuladores.
- Registro de notas.
- Cálculo de promedio.

---

### 17. `U1_17_CicloWhile.java`

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

### 18. `U1_18_CicloWhileCentinela.java`

**Tema:** cantidad desconocida de datos.

Incluye:

- Uso de un valor centinela.
- Registro de notas.
- Contadores.
- Acumuladores.
- Cálculo de promedio.

---

### 19. `U1_19_CicloDoWhile.java`

**Tema:** ciclo que se ejecuta al menos una vez.

Incluye:

- Diferencia entre `while` y `do-while`.
- Validación de notas.
- Validación de contraseña.
- Menú repetitivo.

---

### 20. `U1_20_ProgramaIntegradorUnidad1.java`

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
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad1.U1_01_HolaMundo"
```

Para ejecutar otro archivo, cambia `U1_01_HolaMundo` por el nombre de la clase correspondiente.

## Recomendación para los estudiantes

Antes de avanzar al siguiente ejemplo:

1. Leer los comentarios del código.
2. Ejecutar el programa.
3. Revisar la salida en consola.
4. Modificar algunos valores.
5. Ejecutar nuevamente.
6. Explicar qué hace cada instrucción.