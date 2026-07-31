package com.lelyliliana.unidad4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Ejemplo de paneles y administradores de diseño en Java Swing.
 *
 * Este programa permite explicar:
 * - El uso de JPanel.
 * - El administrador BorderLayout.
 * - El administrador FlowLayout.
 * - La organización de componentes dentro de una ventana.
 */
public class U4_11_PanelesYLayouts {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Se crea la ventana principal.
            JFrame ventana = new JFrame("Paneles y administradores de diseño");

            // Se establece el tamaño de la ventana.
            ventana.setSize(600, 350);

            // Se configura la operación de cierre.
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Se centra la ventana en la pantalla.
            ventana.setLocationRelativeTo(null);

            /*
             * BorderLayout divide la ventana en cinco regiones:
             * NORTH, SOUTH, EAST, WEST y CENTER.
             */
            ventana.setLayout(new BorderLayout());

            // Panel superior.
            JPanel panelSuperior = new JPanel();

            // FlowLayout organiza los componentes de izquierda a derecha.
            panelSuperior.setLayout(new FlowLayout());

            JLabel titulo = new JLabel("Sistema de gestión académica");

            panelSuperior.add(titulo);

            // Panel central.
            JPanel panelCentral = new JPanel(new FlowLayout());

            JButton botonEstudiantes = new JButton("Estudiantes");
            JButton botonCursos = new JButton("Cursos");
            JButton botonCalificaciones = new JButton("Calificaciones");

            panelCentral.add(botonEstudiantes);
            panelCentral.add(botonCursos);
            panelCentral.add(botonCalificaciones);

            // Panel inferior.
            JPanel panelInferior = new JPanel(new FlowLayout());

            JLabel mensaje = new JLabel("Seleccione una opción");

            panelInferior.add(mensaje);

            /*
             * Se agregan los paneles a las diferentes regiones
             * de la ventana.
             */
            ventana.add(panelSuperior, BorderLayout.NORTH);
            ventana.add(panelCentral, BorderLayout.CENTER);
            ventana.add(panelInferior, BorderLayout.SOUTH);

            // Se hace visible la ventana.
            ventana.setVisible(true);
        });
    }
}
