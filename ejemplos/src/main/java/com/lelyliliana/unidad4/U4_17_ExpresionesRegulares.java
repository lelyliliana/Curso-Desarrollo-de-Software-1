package com.lelyliliana.unidad4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Ejemplo de validación de datos mediante expresiones regulares.
 *
 * Este programa permite explicar:
 * - Qué es una expresión regular.
 * - Validación de correos electrónicos.
 * - Validación de números de teléfono.
 * - Validación de contraseñas.
 * - Uso de Pattern.matches().
 */
public class U4_17_ExpresionesRegulares {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame("Validación con expresiones regulares");

            ventana.setSize(550, 320);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);
            ventana.setLayout(new BorderLayout(10, 10));

            JPanel panelFormulario = new JPanel(
                new GridLayout(3, 2, 10, 10)
            );

            JLabel etiquetaCorreo = new JLabel("Correo electrónico:");
            JTextField campoCorreo = new JTextField();

            JLabel etiquetaTelefono = new JLabel("Teléfono:");
            JTextField campoTelefono = new JTextField();

            JLabel etiquetaClave = new JLabel("Contraseña:");
            JTextField campoClave = new JTextField();

            panelFormulario.add(etiquetaCorreo);
            panelFormulario.add(campoCorreo);

            panelFormulario.add(etiquetaTelefono);
            panelFormulario.add(campoTelefono);

            panelFormulario.add(etiquetaClave);
            panelFormulario.add(campoClave);

            JPanel panelBotones = new JPanel();

            JButton botonValidar = new JButton("Validar");
            JButton botonLimpiar = new JButton("Limpiar");

            panelBotones.add(botonValidar);
            panelBotones.add(botonLimpiar);

            botonValidar.addActionListener(evento -> {

                String correo = campoCorreo.getText().trim();
                String telefono = campoTelefono.getText().trim();
                String clave = campoClave.getText();

                /*
                 * Expresión regular para correo electrónico.
                 * Verifica texto antes y después del símbolo @
                 * y una extensión de al menos dos caracteres.
                 */
                String regexCorreo =
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

                /*
                 * Expresión regular para un teléfono de 10 dígitos.
                 */
                String regexTelefono = "^\\d{10}$";

                /*
                 * La contraseña debe tener:
                 * - Al menos 8 caracteres.
                 * - Una letra mayúscula.
                 * - Una letra minúscula.
                 * - Un número.
                 */
                String regexClave =
                    "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

                boolean correoValido =
                    Pattern.matches(regexCorreo, correo);

                boolean telefonoValido =
                    Pattern.matches(regexTelefono, telefono);

                boolean claveValida =
                    Pattern.matches(regexClave, clave);

                if (!correoValido) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "El correo electrónico no tiene un formato válido.",
                        "Correo inválido",
                        JOptionPane.WARNING_MESSAGE
                    );

                    campoCorreo.requestFocus();
                    return;
                }

                if (!telefonoValido) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "El teléfono debe contener exactamente 10 dígitos.",
                        "Teléfono inválido",
                        JOptionPane.WARNING_MESSAGE
                    );

                    campoTelefono.requestFocus();
                    return;
                }

                if (!claveValida) {

                    JOptionPane.showMessageDialog(
                        ventana,
                        "La contraseña debe tener al menos 8 caracteres,\n"
                        + "una mayúscula, una minúscula y un número.",
                        "Contraseña inválida",
                        JOptionPane.WARNING_MESSAGE
                    );

                    campoClave.requestFocus();
                    return;
                }

                JOptionPane.showMessageDialog(
                    ventana,
                    "Todos los datos tienen un formato válido.",
                    "Validación exitosa",
                    JOptionPane.INFORMATION_MESSAGE
                );
            });

            botonLimpiar.addActionListener(evento -> {

                campoCorreo.setText("");
                campoTelefono.setText("");
                campoClave.setText("");

                campoCorreo.requestFocus();
            });

            ventana.add(panelFormulario, BorderLayout.CENTER);
            ventana.add(panelBotones, BorderLayout.SOUTH);

            ventana.setVisible(true);
        });
    }
}
