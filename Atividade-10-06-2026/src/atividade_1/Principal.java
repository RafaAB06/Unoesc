package atividade_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Principal {
	private static final String path = "C:\\Users\\rafop\\Desktop\\unoesc\\3\\Programação_1\\Atividade-10-06-2026.txt";

	public static void main(String[] args) {		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(new Pessoa("Thor", 3000, 1.9f));
		pessoas.add(new Pessoa("Ana", 12, 1.5f));
		pessoas.add(new Pessoa("João", 29, 1.36f));//anão
		
		Collections.sort(pessoas);
		
		System.out.println("Lista original:");
		System.out.println(pessoas.toString());
		
		File file = new File(path);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			for(Pessoa p : pessoas) {
				writer.write(String.format(
					"%s-%d-%.2f\n",
					p.getNome(),
					p.getIdade(),
					p.getAltura()
				));
			}
			
			writer.close();
		} catch (IOException e) {
			System.out.println("Erro ao tentar escrever no arquivo!\n");
			e.printStackTrace();
			return;
		}
		
		pessoas.clear();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String linha;
			while((linha = reader.readLine()) != null) {
				String[] dados = linha.split("-");
				
				Pessoa pessoa = new Pessoa(
					dados[0],
					Integer.parseInt(dados[1]),
					Float.parseFloat(dados[2].replace(',', '.'))
					//ele escreve 1,9, mas parse espera 1.9, solução preguiçosa
				);
				pessoas.add(pessoa);
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não existe!\n");
			e.printStackTrace();
			return;
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo!\n");
			e.printStackTrace();
			return;
		}
		
		System.out.println("Lista lida do arquivo:");
		System.out.println(pessoas.toString());
	}
}
