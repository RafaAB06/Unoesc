package entidades;

public class Conta {
	private int numero;
	private String cliente;
	private double saldo;

	public Conta(int numero, String cliente, double saldo) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
	}
	
	public void depositar(double valor) {
		System.out.println("Depósito realizado com sucesso!");
		saldo += valor;
	}
	
	public void sacar(double valor) {
		if(valor > saldo) {
			System.out.println("Saldo insuficiente!");
		}else {
			System.out.println("Saque realizado com sucesso!");
			saldo -= valor;
		}
	}
	
	@Override
	public String toString() {
		return String.format("[Conta nº %d, Cliente %s, Saldo R$%.2f]", numero, cliente, saldo);
	}
}
