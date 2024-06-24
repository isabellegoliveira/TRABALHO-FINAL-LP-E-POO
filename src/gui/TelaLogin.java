package gui;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class TelaLogin extends JFrame {
    public TelaLogin() throws SQLException {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 2));

        add(new JLabel("E-mail:"));
        JTextField emailField = new JTextField(20);
        add(emailField);

        add(new JLabel("Senha:"));
        JPasswordField senhaField = new JPasswordField(20);
        add(senhaField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            // Lógica de autenticação
            // Se autenticado com sucesso, abrir a TelaPrincipal
            TelaPrincipal telaPrincipal = null;
			telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
            this.dispose();
        });
        add(loginButton);

        JButton registerButton = new JButton("Registrar-se");
        registerButton.addActionListener(e -> {
            TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
            telaCadastroCliente.setVisible(true);
        });
        add(registerButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLogin telaLogin = null;
			try {
				telaLogin = new TelaLogin();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            telaLogin.setVisible(true);
        });
    }
}