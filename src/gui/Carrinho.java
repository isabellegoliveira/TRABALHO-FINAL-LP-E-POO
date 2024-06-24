package gui;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private static List<Produto> produtos = new ArrayList<>();

    public static void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public static List<Produto> getProdutos() {
        return produtos;
    }

    public static double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    public static void limparCarrinho() {
        produtos.clear();
    }
}