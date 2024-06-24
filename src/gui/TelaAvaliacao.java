package gui;

import model.Avaliacao;
import dao.AvaliacaoDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class TelaAvaliacao extends JFrame {
    private int idProduto;

    public TelaAvaliacao(int idProduto) {
        this.idProduto = idProduto;
        setTitle("Avaliação de Produtos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2));

        add(new JLabel("ID Cliente:"));
        JTextField idClienteField = new JTextField(20);
        add(idClienteField);

        add(new JLabel("Nota:"));
        JTextField notaField = new JTextField(20);
        add(notaField);

        add(new JLabel("Comentário:"));
        JTextField comentarioField = new JTextField(20);
        add(comentarioField);

        JButton saveButton = new JButton("Salvar Avaliação");
        saveButton.addActionListener(e -> {
            try {
                int idCliente = Integer.parseInt(idClienteField.getText());
                int nota = Integer.parseInt(notaField.getText());
                String comentario = comentarioField.getText();

                Avaliacao avaliacao = new Avaliacao(0, idProduto, idCliente, nota, comentario);
                AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                avaliacaoDAO.adicionarAvaliacao(avaliacao);
                JOptionPane.showMessageDialog(this, "Avaliação salva com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar avaliação: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(saveButton);
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
}