package atividade_1;

import java.io.Serializable;

public class Pessoa implements Comparable<Pessoa>, Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private int idade;
	private float altura;
	
	public Pessoa(String nome, int idade, float altura) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public float getAltura() {
		return altura;
	}
	
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	@Override
	public String toString() {
		return String.format("Pessoa(Nome: %s, Idade: %d anos, Altura: %.2fm", nome, idade, altura);
	}
	
	@Override
	public int compareTo(Pessoa o) {
		return nome.compareTo(o.getNome());
	}
}
