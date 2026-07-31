# Unidad 4 - Herencia, polimorfismo e interfaces gráficas

En esta unidad se presentan ejemplos prácticos relacionados con programación orientada a objetos avanzada e interfaces gráficas en Java.

Los ejemplos están organizados de forma progresiva, comenzando con herencia y polimorfismo, y finalizando con aplicaciones gráficas desarrolladas con Java Swing.

## Temas principales

- Herencia.
- Uso de `super`.
- Sobrescritura de métodos.
- Polimorfismo.
- Clases abstractas.
- Interfaces.
- Composición de objetos.
- Interfaces gráficas con Java Swing.
- Paneles y administradores de diseño.
- Controles gráficos.
- Manejo de eventos.
- Formularios.
- Validación de datos.
- Expresiones regulares.
- Tablas con `JTable`.
- Programa integrador.

## Ejemplos

### Programación orientada a objetos

1. `U4_01_HerenciaBasica.java`  
   Introducción a la herencia entre clases.

2. `U4_02_ConstructorSuper.java`  
   Uso de constructores y de la palabra reservada `super`.

3. `U4_03_SobrescrituraMetodos.java`  
   Redefinición de métodos mediante `@Override`.

4. `U4_04_PolimorfismoBasico.java`  
   Uso básico del polimorfismo.

5. `U4_05_ListaPolimorfica.java`  
   Almacenamiento de objetos relacionados en una misma lista.

6. `U4_06_ClaseAbstractaUnidad4.java`  
   Creación y uso de clases y métodos abstractos.

7. `U4_07_InterfacesEjemplo.java`  
   Implementación de una interfaz.

8. `U4_08_MultiplesInterfaces.java`  
   Implementación de varias interfaces en una misma clase.

9. `U4_09_ComposicionObjetos.java`  
   Relación de composición entre objetos.

### Interfaces gráficas con Java Swing

10. `U4_10_VentanaBasica.java`  
    Creación de una ventana básica con `JFrame`.

11. `U4_11_PanelesYLayouts.java`  
    Uso de `JPanel`, `BorderLayout` y `FlowLayout`.

12. `U4_12_ControlesGraficos.java`  
    Uso de etiquetas, campos de texto, botones, listas y controles de selección.

13. `U4_13_EventosBotones.java`  
    Manejo de eventos mediante `ActionListener` y expresiones lambda.

14. `U4_14_JOptionPaneEjemplo.java`  
    Cuadros de diálogo para mostrar mensajes, solicitar datos y confirmar acciones.

15. `U4_15_FormularioEstudiante.java`  
    Formulario gráfico para registrar información de estudiantes.

16. `U4_16_ValidacionCamposGUI.java`  
    Validación de campos vacíos, números y rangos permitidos.

17. `U4_17_ExpresionesRegulares.java`  
    Validación de correos, teléfonos y contraseñas mediante expresiones regulares.

18. `U4_18_TablaProductosGUI.java`  
    Registro y eliminación de productos mediante `JTable`.

19. `U4_19_ProgramaIntegradorUnidad4.java`  
    Aplicación que integra herencia, polimorfismo, clases abstractas, colecciones, eventos, validaciones y tablas.

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

Desde la carpeta principal del proyecto, se puede ejecutar una clase utilizando Maven.

Ejemplo:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad4.U4_10_VentanaBasica"
```

Para ejecutar otro ejemplo, reemplaza el nombre de la clase por el correspondiente.

Ejemplo:

```bash
mvn exec:java -Dexec.mainClass="com.lelyliliana.unidad4.U4_19_ProgramaIntegradorUnidad4"
```

## Observación

Los ejemplos del 10 al 19 utilizan interfaces gráficas. Al ejecutarlos se abrirá una ventana independiente desarrollada con Java Swing.

Cada archivo contiene comentarios explicativos para facilitar su estudio, ejecución y presentación durante las clases.
