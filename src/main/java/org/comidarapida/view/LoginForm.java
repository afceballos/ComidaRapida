package org.comidarapida.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class LoginForm {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public static void main(String[] args) {
        LoginForm window = new LoginForm();
        window.frame.setVisible(true);
    }

    public LoginForm() {
        initialize();
    }

    private void initialize() {


        frame = new JFrame();
        frame.setBounds(100, 100, 400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Inicio de sesión");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel.setBounds(127, 23, 150, 25);
        frame.getContentPane().add(titleLabel);

        JLabel usernameLabel = new JLabel("Usuario:");
        usernameLabel.setBounds(50, 80, 100, 14);
        frame.getContentPane().add(usernameLabel);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(50, 120, 100, 14);
        frame.getContentPane().add(passwordLabel);

        usernameField = new JTextField();
        usernameField.setBounds(160, 77, 150, 20);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(160, 117, 150, 20);
        frame.getContentPane().add(passwordField);

        loginButton = new JButton("Iniciar sesión");
        loginButton.setBounds(160, 160, 150, 23);
        frame.getContentPane().add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                try {
                    Connection connection = loginController.conectar();
                    String query = "SELECT * FROM Usuarios";
                    PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet result = statement.executeQuery();
                    while (result.next()) {
                        String user = result.getString("email");
                        String pass = result.getString("password");
                        if (user.equals(username) && pass.equals(password)) {
                            ComidaRapida comidaRapida = new ComidaRapida();
                            comidaRapida.Program();
                        } else {
                            JOptionPane.showMessageDialog(null, "Datos Incorrectos");
                        }
                    }

                    loginController.desconectar();
                    System.out.println("Inventario cargado desde la base de datos.");
                } catch (SQLException error) {
                    System.out.println("Error al cargar los usuarios desde la base de datos: " + error.getMessage());
                }

            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}