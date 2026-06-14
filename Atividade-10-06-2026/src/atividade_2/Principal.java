package atividade_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {
	private static final String path = "C:\\Users\\rafop\\Desktop\\unoesc\\3\\Programação_1\\saida.txt";
	
	public static void main(String[] args) {
	    ClasseTeste[] vetor = {
	        new ClasseTeste(1, 342450.1, "abc"),
	        new ClasseTeste(2, -230.2, "yo no lo conosco señor"),
	        new ClasseTeste(3, 30.3, "PV = nrT")
	    };

	    File file = new File(path);

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

	        for (ClasseTeste obj : vetor) {
	            writer.write(obj.toString());
	            writer.newLine();
	        }

	    } catch (IOException e) {
	    	System.out.println("Erro ao escrever no arquivo!");
	        e.printStackTrace();
	        return;
	    }

	    ClasseTeste[] vetorLido = new ClasseTeste[vetor.length];
	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

	        String linha;
	        int i = 0;

	        while ((linha = reader.readLine()) != null) {
	            String[] dados = linha.split(",");

	            vetorLido[i++] = new ClasseTeste(
	                Integer.parseInt(dados[0]),
	                Double.parseDouble(dados[1]),
	                dados[2]
	            );
	        }

	    } catch (IOException e) {
	    	System.out.println("Erro ao ler o arquivo!");
	        e.printStackTrace();
	        return;
	    }

	    System.out.println("Dados lidos:");

	    for (ClasseTeste obj : vetorLido) {
	        System.out.println(obj);
	    }
	}
	
}
