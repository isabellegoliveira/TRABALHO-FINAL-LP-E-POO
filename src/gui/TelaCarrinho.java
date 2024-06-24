package gui;

import model.Produto;

import javax.swing.*;
import java.awt.*;

public class TelaCarrinho extends JFrame {
	private JTextArea carrinhoArea;
	private JLabel totalLabel;

	public TelaCarrinho() {
		setTitle("Carrinho de Compras");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Layout e implementação do carrinho de compras
		setLayout(new BorderLayout());

		carrinhoArea = new JTextArea();
		carrinhoArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(carrinhoArea);
		add(scrollPane, BorderLayout.CENTER);

		totalLabel = new JLabel("Total: R$ 0.00");
		add(totalLabel, BorderLayout.NORTH);

		atualizarCarrinho();

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(e -> {
			new TelaPrincipal().setVisible(true);
			this.dispose();
		});
		buttonPanel.add(voltarButton);

		JButton finalizarCompraButton = new JButton("Finalizar Compra");
		finalizarCompraButton.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Compra finalizada com sucesso!");
			Carrinho.limparCarrinho(); // Limpa o carrinho após a compra
			atualizarCarrinho();
		});
		buttonPanel.add(finalizarCompraButton);

		add(buttonPanel, BorderLayout.SOUTH);
	}

	private void atualizarCarrinho() {
		StringBuilder carrinhoTexto = new StringBuilder();
		for (Produto produto : Carrinho.getProdutos()) {
			carrinhoTexto.append(produto.getNome())
					.append(" - R$ ")
					.append(String.format("%.2f", produto.getPreco()))
					.append("\n");
		}
		carrinhoArea.setText(carrinhoTexto.toString());
		totalLabel.setText("Total: R$ " + String.format("%.2f", Carrinho.calcularTotal()));
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new TelaCarrinho().setVisible(true));
	}
}