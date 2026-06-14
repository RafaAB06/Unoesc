package atividade;

public class Jogo {
	private int codigo;
	private String nome;
	private double preco;
	private Categoria categoria;
	
	public Jogo(int codigo, String nome, double preco, Categoria categoria) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	public void aplicarDesconto(double percentual) {
		double desconto = percentual/100.0;
		
		preco -= preco * desconto;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public String toString() {
		return String.format(
			"Código: %d, Nome: %s, Preço: R$%.2f, Categoria: [%s]",
			codigo,
			nome,
			preco,
			categoria.toString()
		);
	}
}
