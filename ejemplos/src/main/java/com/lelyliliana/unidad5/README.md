# Unidad 5 - Almacenamiento permanente y operaciones CRUD

Esta unidad presenta conceptos y ejemplos relacionados con el almacenamiento permanente de información en Java.

Los ejemplos comienzan con la escritura y lectura de archivos de texto, avanzan hacia el manejo de objetos y listas, y finalizan con aplicaciones gráficas que implementan operaciones CRUD utilizando Java Swing y archivos como mecanismo de persistencia.

## Temas principales

- Almacenamiento temporal y permanente.
- Creación de archivos.
- Escritura de información.
- Lectura de archivos.
- Adición de registros.
- Búsqueda de información.
- Modificación de registros.
- Eliminación de registros.
- Conversión entre objetos y texto.
- Almacenamiento de listas de objetos.
- Recuperación de objetos desde archivos.
- Operaciones CRUD.
- Formularios gráficos.
- Uso de `JTable`.
- Uso de `DefaultTableModel`.
- Validación de datos.
- Persistencia desde interfaces gráficas.
- Programa integrador.

## Operaciones CRUD

CRUD representa las cuatro operaciones fundamentales para administrar información:

- **Create:** crear o agregar registros.
- **Read:** consultar o listar información.
- **Update:** modificar registros existentes.
- **Delete:** eliminar registros.

## Ejemplos

### Fundamentos de almacenamiento en archivos

1. `U5_01_AlmacenamientoTemporalPermanente.java`  
   Explica la diferencia entre datos almacenados temporalmente en memoria y datos guardados permanentemente en un archivo.

2. `U5_02_EscribirArchivoTexto.java`  
   Crea un archivo de texto y almacena varias líneas utilizando `Files.write()`.

3. `U5_03_LeerArchivoTexto.java`  
   Recupera y muestra las líneas guardadas en un archivo mediante `Files.readAllLines()`.

4. `U5_04_AgregarRegistroArchivo.java`  
   Añade nuevos registros al final de un archivo sin eliminar su contenido anterior.

5. `U5_05_BuscarRegistroArchivo.java`  
   Busca un estudiante dentro de un archivo utilizando su número de documento.

6. `U5_06_ModificarRegistroArchivo.java`  
   Localiza un registro, modifica sus datos y vuelve a escribir el archivo.

7. `U5_07_EliminarRegistroArchivo.java`  
   Elimina un registro y conserva los demás datos almacenados.

8. `U5_08_ListarRegistrosArchivo.java`  
   Muestra los registros del archivo con un formato organizado y legible.

### Objetos y persistencia

9. `U5_09_ObjetoEstudianteArchivo.java`  
   Convierte un objeto en una línea de texto y crea nuevamente el objeto a partir del registro.

10. `U5_10_GuardarListaObjetos.java`  
    Convierte una lista de objetos en registros de texto y los guarda en un archivo.

11. `U5_11_CargarListaObjetos.java`  
    Lee un archivo y construye una lista de objetos a partir de sus registros.

12. `U5_12_CRUDConsolaArchivo.java`  
    Implementa las operaciones crear, listar, consultar, modificar y eliminar mediante consola y archivo de texto.

### Interfaces gráficas y tablas

13. `U5_13_FormularioEmpleadoGUI.java`  
    Formulario gráfico con los botones Nuevo, Agregar, Cancelar y Salir.

14. `U5_14_TablaEmpleadosGUI.java`  
    Registra empleados en una `JTable` y permite eliminar filas seleccionadas. Los datos permanecen solamente en memoria.

15. `U5_15_CargarTablaDesdeArchivoGUI.java`  
    Lee registros desde un archivo y los muestra en una tabla.

16. `U5_16_GuardarTablaEnArchivoGUI.java`  
    Convierte las filas de una tabla en registros y las guarda permanentemente en un archivo.

17. `U5_17_ConsultarEmpleadoTablaGUI.java`  
    Busca empleados por documento, selecciona la fila correspondiente y muestra sus datos en un formulario.

18. `U5_18_ModificarEmpleadoTablaGUI.java`  
    Permite seleccionar un empleado, modificar sus datos y actualizar la fila correspondiente.

19. `U5_19_EliminarEmpleadoTablaGUI.java`  
    Elimina una fila seleccionada después de solicitar confirmación.

20. `U5_20_ProgramaIntegradorUnidad5.java`  
    Integra clases, objetos, listas, archivos, formularios, tablas, validaciones y las cuatro operaciones CRUD.

## Archivos generados durante la ejecución

Algunos ejemplos crean archivos de texto en la carpeta desde la cual se ejecuta Maven.

Entre ellos se encuentran:

```text
estudiante.txt
estudiantes.txt
estudiantes_objetos.txt
empleados_crud.txt
empleados_tabla.txt
empleados_integrador.txt
```

Estos archivos se utilizan como mecanismo de almacenamiento permanente para los ejemplos de la unidad.

## Requisitos

- Java JDK 21.
- Maven.
- Un entorno de desarrollo como Visual Studio Code, IntelliJ IDEA, Eclipse o NetBeans.

## Compilación del proyecto

Desde la carpeta principal del proyecto `ejemplos`, ejecuta:

```bash
mvn clean compile
```

## Ejecución de un ejemplo

Los comandos deben ejecutarse desde la carpeta `ejemplos`, donde se encuentra el archivo `pom.xml`.

Ejemplo de escritura de archivos:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad5.U5_02_EscribirArchivoTexto"
```

Ejemplo de CRUD por consola:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad5.U5_12_CRUDConsolaArchivo"
```

Ejemplo de programa integrador:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad5.U5_20_ProgramaIntegradorUnidad5"
```

Para ejecutar otro programa, reemplaza el nombre completo de la clase por el correspondiente.

## Orden recomendado de estudio

Se recomienda trabajar los ejemplos en el orden numérico establecido.

Antes de avanzar al siguiente ejemplo:

1. Lee los comentarios incluidos en el código.
2. Ejecuta el programa.
3. Observa la información en consola o en la interfaz gráfica.
4. Revisa los archivos generados.
5. Modifica algunos datos.
6. Ejecuta nuevamente.
7. Explica con palabras propias cómo se almacenan y recuperan los registros.

## Observación

Los ejemplos utilizan archivos de texto como mecanismo de persistencia con fines educativos.

En aplicaciones empresariales, las operaciones CRUD suelen implementarse mediante sistemas gestores de bases de datos. Sin embargo, el uso de archivos permite comprender primero los principios fundamentales del almacenamiento permanente.

## Docente

**Leli Liliana Díaz Izquierdo**  
Curso: Desarrollo de Software I