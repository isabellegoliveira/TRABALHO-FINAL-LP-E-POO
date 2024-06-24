package model;

import java.util.Date;

public class Venda {
    private int idVenda;
    private int idPedido;
    private int idVendedor;
    private int idCliente;
    private Date dataVenda;
    private double valorTotal;

    public Venda(int idVenda, int idPedido, int idVendedor, int idCliente, Date dataVenda, double valorTotal) {
        this.idVenda = idVenda;
        this.idPedido = idPedido;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}