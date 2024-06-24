package dao;

import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends ConexaoBanco {

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idProduto = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                String categoria = rs.getString("categoria");
                String descricao = rs.getString("descricao");
                produtos.add(new Produto(idProduto, nome, preco, categoria, descricao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return produtos;
    }
}