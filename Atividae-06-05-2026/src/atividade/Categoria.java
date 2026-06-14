package atividade;

public class Categoria {
	private int codigo;
	private String nome;
	
	public Categoria(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return String.format("Código: %d, Nome: %s", codigo, nome);
	}
}
