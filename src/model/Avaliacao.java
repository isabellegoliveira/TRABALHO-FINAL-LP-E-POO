package model;

public class Avaliacao {
    private int id;
    private int idProduto;
    private int idCliente;
    private int nota;
    private String comentario;

    public Avaliacao(int id, int idProduto, int idCliente, int nota, String comentario) {
        this.id = id;
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}