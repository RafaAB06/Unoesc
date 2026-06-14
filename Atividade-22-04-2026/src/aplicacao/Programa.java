package aplicacao;

import java.util.Scanner;
import entidades.Conta;

public class Programa {	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe o número da conta:");
		int num = scan.nextInt();
		
		System.out.println("Informe seu nome: ");
		String nome = scan.next();
		System.out.println("Gostaria fazer um depósito inicial?");
		double saldoInicial = 0;
		String res = scan.next().toLowerCase();
		if(res.equals("sim") || res.equals("s")) {
			System.out.println("Informe o depósito inicial: ");
			saldoInicial = scan.nextDouble();
		}		
		Conta conta = new Conta(num, nome, saldoInicial);
		
		System.out.println("Conta criada! " + conta);
		
		System.out.println("Informe o valor a ser depositado: ");
		double deposito = scan.nextDouble();
		conta.depositar(deposito);
		System.out.println(conta);
		
		System.out.println("Informe o valor a ser sacado: ");
		double saque = scan.nextDouble();
		conta.sacar(saque);
		System.out.println(conta);
		
		scan.close();
	}
}
