package gui;

import java.sql.SQLException;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] options = {"Login", "Cadastro de Cliente"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção:",
                "Sistema de Gestão",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);

        javax.swing.SwingUtilities.invokeLater(() -> {
            if (choice == 0) {
                try {
					new TelaLogin().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } else if (choice == 1) {
                new TelaCadastroCliente().setVisible(true);
            }
        });
    }
}