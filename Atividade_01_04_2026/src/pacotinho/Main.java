package pacotinho;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean res = false;
		do {
			System.out.println("Insira sua data de nascimento, formato dia/mes/ano");
			System.out.println("Qualquer formato além disso obrigará o program a ser encerrado abruptamente!");
			try {
				String data = scan.nextLine();
				String[] valores = data.split("/");
				int dia = Integer.parseInt(valores[0]);
				int mes = Integer.parseInt(valores[1]);
				int ano = Integer.parseInt(valores[2]);
								
				calcularIdade(dia, mes, ano);
			}catch(Exception e){
				System.out.println("Erro fatal! Fomato inválido!");
				System.out.println("E a culpa é do usuário!");
				break;
			}
			res = desejaContinuar();
			
		}while(res);
		
		System.out.println("Encerrando...");
	}
	
	private static boolean desejaContinuar() {
		System.out.println("Deseja continuar?");
		System.out.println("[1] - Sim;");
		System.out.println("[2] - Não.");
		String res = scan.nextLine();
		
		return res.equals("1");
	}

	public static void calcularIdade(int dia, int mes, int ano) {
		LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
		LocalDate dataAtual = LocalDate.now();
		
		Period period = Period.between(dataNascimento, dataAtual);
		
		System.out.printf(
			"Você tem %d anos, %d meses e %d dias de idade\n",
			period.getYears(),
			period.getMonths(),
			period.getDays()
		);
	}
}
