package gui;

import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal() {
        setTitle("Vitrine de Produtos - E-commerce de Skin Care");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout de Flow para ajustar os elementos de forma mais flexível
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        // Exemplo de produtos de skin care
        Produto[] produtos = {
                new Produto("Hidratante Facial", "Hidrata e suaviza a pele", 29.90, "hidratante_facial.png"),
                new Produto("Serum Vitamina C", "Ilumina e uniformiza o tom da pele", 99.90, "serum_vitaminac.png"),
                new Produto("Protetor Solar", "Protege contra os raios UV", 49.90, "protetor_solar.png"),
                new Produto("Gel de Limpeza", "Limpa profundamente a pele", 19.90, "gelde_limpeza.png"),
                new Produto("Mascara Facial", "Revitaliza e purifica a pele", 39.90, "mascara_facial.png"),
                new Produto("Tonico Facial", "Equilibra o pH da pele", 24.90, "tonico_facial.png")
        };

        for (Produto produto : produtos) {
            JPanel produtoPanel = new JPanel();
            produtoPanel.setBorder(BorderFactory.createTitledBorder(produto.getNome()));
            produtoPanel.setLayout(new BorderLayout());

            // Carregar a imagem do arquivo
            ImageIcon imagemProduto = carregarImagem(produto.getCaminhoImagem());
            if (imagemProduto != null) {
                JLabel imagemLabel = new JLabel(imagemProduto);
                produtoPanel.add(imagemLabel, BorderLayout.CENTER);
            } else {
                JLabel imagemLabel = new JLabel("Imagem não disponível");
                produtoPanel.add(imagemLabel, BorderLayout.CENTER);
            }

            JTextArea descricaoArea = new JTextArea(produto.getDescricao());
            descricaoArea.setLineWrap(true);
            descricaoArea.setWrapStyleWord(true);
            descricaoArea.setEditable(false);
            produtoPanel.add(descricaoArea, BorderLayout.SOUTH);

            JLabel precoLabel = new JLabel("Preço: R$" + produto.getPreco());
            produtoPanel.add(precoLabel, BorderLayout.NORTH);

            JButton addButton = new JButton("Adicionar ao Carrinho");
            addButton.addActionListener(e -> {
                Carrinho.adicionarProduto(produto);
                JOptionPane.showMessageDialog(this, produto.getNome() + " adicionado ao carrinho.");
            });

            produtoPanel.add(addButton, BorderLayout.EAST);
            add(produtoPanel);
        }

        // Botão para ir ao carrinho
        JButton carrinhoButton = new JButton("Ir para o Carrinho");
        carrinhoButton.addActionListener(e -> {
            TelaCarrinho telaCarrinho = new TelaCarrinho();
            telaCarrinho.setVisible(true);
            dispose(); // Fecha a janela atual
        });

        add(carrinhoButton);
    }

    private ImageIcon carregarImagem(String caminho) {
        try {
            if (caminho == null || caminho.isEmpty()) {
                System.err.println("Caminho da imagem é nulo ou vazio.");
                return null;
            }
            BufferedImage imagem = ImageIO.read(new File(caminho));
            return new ImageIcon(imagem);
        } catch (IOException ex) {
            System.err.println("Erro ao carregar imagem: " + ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
