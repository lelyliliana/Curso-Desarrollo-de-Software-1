package com.lelyliliana.unidad4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Ejemplo de formulario para registrar estudiantes.
 *
 * Este programa permite explicar:
 * - Creación de formularios.
 * - Captura de información con JTextField.
 * - Selección de opciones con JComboBox.
 * - Eventos en botones.
 * - Limpieza de campos.
 * - Presentación de datos con JOptionPane.
 */
public class U4_15_FormularioEstudiante {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Se crea la ventana principal.
            JFrame ventana = new JFrame("Registro de estudiantes");

            ventana.setSize(550, 350);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);
            ventana.setLayout(new BorderLayout(10, 10));

            // Panel que contiene los campos del formulario.
            JPanel panelFormulario = new JPanel(
                new GridLayout(5, 2, 10, 10)
            );

            // Campo para el documento.
            JLabel etiquetaDocumento = new JLabel("Documento:");
            JTextField campoDocumento = new JTextField();

            // Campo para el nombre.
            JLabel etiquetaNombre = new JLabel("Nombre completo:");
            JTextField campoNombre = new JTextField();

            // Campo para el correo.
            JLabel etiquetaCorreo = new JLabel("Correo electrónico:");
            JTextField campoCorreo = new JTextField();

            // Lista de programas académicos.
            JLabel etiquetaPrograma = new JLabel("Programa académico:");

            String[] programas = {
                "Ingeniería de Sistemas",
                "Ingeniería Industrial",
                "Administración de Empresas",
                "Contaduría Pública"
            };

            JComboBox<String> listaProgramas = new JComboBox<>(programas);

            // Campo para el semestre.
            JLabel etiquetaSemestre = new JLabel("Semestre:");
            JTextField campoSemestre = new JTextField();

            // Se agregan los componentes al panel.
            panelFormulario.add(etiquetaDocumento);
            panelFormulario.add(campoDocumento);

            panelFormulario.add(etiquetaNombre);
            panelFormulario.add(campoNombre);

            panelFormulario.add(etiquetaCorreo);
            panelFormulario.add(campoCorreo);

            panelFormulario.add(etiquetaPrograma);
            panelFormulario.add(listaProgramas);

            panelFormulario.add(etiquetaSemestre);
            panelFormulario.add(campoSemestre);

            // Panel para los botones.
            JPanel panelBotones = new JPanel();

            JButton botonGuardar = new JButton("Guardar");
            JButton botonLimpiar = new JButton("Limpiar");
            JButton botonSalir = new JButton("Salir");

            panelBotones.add(botonGuardar);
            panelBotones.add(botonLimpiar);
            panelBotones.add(botonSalir);

            /*
             * Evento del botón Guardar.
             * Se obtienen los datos escritos por el usuario.
             */
            botonGuardar.addActionListener(evento -> {

                String documento = campoDocumento.getText();
                String nombre = campoNombre.getText();
                String correo = campoCorreo.getText();

                String programa = (String) listaProgramas.getSelectedItem();

                String semestre = campoSemestre.getText();

                String datosEstudiante =
                    "Documento: " + documento
                    + "\nNombre: " + nombre
                    + "\nCorreo: " + correo
                    + "\nPrograma: " + programa
                    + "\nSemestre: " + semestre;

                JOptionPane.showMessageDialog(
                    ventana,
                    datosEstudiante,
                    "Estudiante registrado",
                    JOptionPane.INFORMATION_MESSAGE
                );
            });

            /*
             * Evento del botón Limpiar.
             * Se borran los campos y se selecciona la primera opción.
             */
            botonLimpiar.addActionListener(evento -> {

                campoDocumento.setText("");
                campoNombre.setText("");
                campoCorreo.setText("");
                campoSemestre.setText("");

                listaProgramas.setSelectedIndex(0);

                campoDocumento.requestFocus();
            });

            // Evento del botón Salir.
            botonSalir.addActionListener(evento -> {
                ventana.dispose();
            });

            // Se agregan los paneles a la ventana.
            ventana.add(panelFormulario, BorderLayout.CENTER);
            ventana.add(panelBotones, BorderLayout.SOUTH);

            // Se muestra la ventana.
            ventana.setVisible(true);
        });
    }
}
