package dao;

import model.Avaliacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO extends ConexaoBanco {
    private DatabaseMetaData DatabaseConnection;

    public void adicionarAvaliacao(Avaliacao avaliacao) throws SQLException {
        String sql = "INSERT INTO Avaliacao (id, idProduto, idCliente, nota, comentario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, avaliacao.getId());
            stmt.setInt(2, avaliacao.getIdProduto());
            stmt.setInt(3, avaliacao.getIdCliente());
            stmt.setInt(4, avaliacao.getNota());
            stmt.setString(5, avaliacao.getComentario());
            stmt.executeUpdate();
        }
    }

    public List<Avaliacao> listarAvaliacoes() throws SQLException {
        List<Avaliacao> avaliacoes = new ArrayList<>();
        String sql = "SELECT * FROM Avaliacao";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int idProduto = rs.getInt("idProduto");
                int idCliente = rs.getInt("idCliente");
                int nota = rs.getInt("nota");
                String comentario = rs.getString("comentario");
                avaliacoes.add(new Avaliacao(id, idProduto, idCliente, nota, comentario));
            }
        }
        return avaliacoes;
    }

    public List<Avaliacao> listarAvaliacoesPorProduto(int idProduto) {
        return null;
    }


    // Métodos para atualizar e deletar avaliações podem ser adicionados aqui
}