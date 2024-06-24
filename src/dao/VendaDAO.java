package dao;

import model.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO extends ConexaoBanco {
    private DatabaseMetaData DatabaseConnection;

    public void adicionarVenda(Venda venda) throws SQLException {
        String sql = "INSERT INTO Venda (idVenda, idPedido, idVendedor, idCliente, dataVenda, valorTotal) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, venda.getIdVenda());
            stmt.setInt(2, venda.getIdPedido());
            stmt.setInt(3, venda.getIdVendedor());
            stmt.setInt(4, venda.getIdCliente());
            stmt.setDate(5, new Date(venda.getDataVenda().getTime()));
            stmt.setDouble(6, venda.getValorTotal());
            stmt.executeUpdate();
        }
    }

    public List<Venda> listarVendas() throws SQLException {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM Venda";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idVenda = rs.getInt("idVenda");
                int idPedido = rs.getInt("idPedido");
                int idVendedor = rs.getInt("idVendedor");
                int idCliente = rs.getInt("idCliente");
                Date dataVenda = rs.getDate("dataVenda");
                double valorTotal = rs.getDouble("valorTotal");
                vendas.add(new Venda(idVenda, idPedido, idVendedor, idCliente, dataVenda, valorTotal));
            }
        }
        return vendas;
    }
}