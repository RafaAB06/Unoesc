package pacotinho;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bem vindo ao validador de senhas!");
		
		boolean res = false;
		do {
			System.out.println("Insira uma senha: ");
			String senha = scan.next();
			
			boolean valida = senhaValida(senha);
			String resultado;
			if(valida) {
				resultado = "válida";
			}else {
				resultado = "inválida";
			}
			System.out.printf("A senha %s é %s!\n", senha, resultado);
			
			System.out.println("Deseja continuar?");
			System.out.println("[1] - Sim,");
			System.out.println("[2] - Não");
			
			res = scan.nextInt() == 1;
			
		}while(res);
		System.out.println("Saindo...");
		
		scan.close();
	}

	private static boolean senhaValida(String senha) {
		int len = senha.length();
		if(len < 8) return false;
		
		boolean num = false, maiuscula = false, minuscula = false;
		for(int i = 0; i<len; i++) {
			char ch = senha.charAt(i);
			
			if(Character.isDigit(ch)) num = true;
			if(Character.isUpperCase(ch)) maiuscula = true;
			if(Character.isLowerCase(ch)) minuscula = true;
		}
		
		return num && maiuscula && minuscula;
	}

}
