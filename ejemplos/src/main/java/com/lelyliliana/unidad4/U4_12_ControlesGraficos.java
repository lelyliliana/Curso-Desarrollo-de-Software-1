package com.lelyliliana.unidad4;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Ejemplo de controles gráficos básicos en Java Swing.
 *
 * Este programa permite explicar:
 * - JLabel.
 * - JTextField.
 * - JPasswordField.
 * - JCheckBox.
 * - JRadioButton.
 * - ButtonGroup.
 * - JComboBox.
 * - JButton.
 */
public class U4_12_ControlesGraficos {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Se crea la ventana principal.
            JFrame ventana = new JFrame("Controles gráficos");

            ventana.setSize(500, 450);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);

            /*
             * GridLayout organiza los componentes en una cuadrícula.
             * En este caso se utilizarán 8 filas, 2 columnas
             * y una separación de 10 píxeles.
             */
            JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));

            // Campo de texto para el nombre.
            JLabel etiquetaNombre = new JLabel("Nombre:");
            JTextField campoNombre = new JTextField();

            // Campo especial para contraseñas.
            JLabel etiquetaClave = new JLabel("Contraseña:");
            JPasswordField campoClave = new JPasswordField();

            // Casilla de verificación.
            JLabel etiquetaTerminos = new JLabel("Acepta los términos:");
            JCheckBox casillaTerminos = new JCheckBox("Sí");

            // Botones de opción para seleccionar el género.
            JLabel etiquetaGenero = new JLabel("Género:");

            JPanel panelGenero = new JPanel();

            JRadioButton opcionFemenino = new JRadioButton("Femenino");
            JRadioButton opcionMasculino = new JRadioButton("Masculino");

            /*
             * ButtonGroup permite que solamente uno de los botones
             * de opción pueda estar seleccionado.
             */
            ButtonGroup grupoGenero = new ButtonGroup();

            grupoGenero.add(opcionFemenino);
            grupoGenero.add(opcionMasculino);

            panelGenero.add(opcionFemenino);
            panelGenero.add(opcionMasculino);

            // Lista desplegable.
            JLabel etiquetaPrograma = new JLabel("Programa:");

            String[] programas = {
                "Ingeniería de Sistemas",
                "Ingeniería Industrial",
                "Administración de Empresas"
            };

            JComboBox<String> listaProgramas = new JComboBox<>(programas);

            // Botones del formulario.
            JButton botonGuardar = new JButton("Guardar");
            JButton botonLimpiar = new JButton("Limpiar");

            // Se agregan los componentes al panel.
            panel.add(etiquetaNombre);
            panel.add(campoNombre);

            panel.add(etiquetaClave);
            panel.add(campoClave);

            panel.add(etiquetaTerminos);
            panel.add(casillaTerminos);

            panel.add(etiquetaGenero);
            panel.add(panelGenero);

            panel.add(etiquetaPrograma);
            panel.add(listaProgramas);

            panel.add(new JLabel());
            panel.add(new JLabel());

            panel.add(botonGuardar);
            panel.add(botonLimpiar);

            // Se agrega el panel a la ventana.
            ventana.add(panel);

            // Se muestra la ventana.
            ventana.setVisible(true);
        });
    }
}
