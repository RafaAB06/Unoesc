package atividade;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
	static List<Jogo> jogos = new ArrayList<Jogo>();
	static List<Categoria> categorias = new ArrayList<Categoria>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Categoria sandbox = new Categoria(0, "sandbox");
		Categoria tiro = new Categoria(1, "tiro");
		Categoria terror = new Categoria(2, "terror");

		categorias.add(sandbox);
		categorias.add(tiro);
		categorias.add(terror);

		jogos.add(new Jogo(0, "Minecraft", 89.99, sandbox));
		jogos.add(new Jogo(6, "Outlast", 59.99, terror));
		jogos.add(new Jogo(1, "Terraria", 19.99, sandbox));
		jogos.add(new Jogo(4, "Left4Dead2", 29.99, tiro));
		jogos.add(new Jogo(7, "RE7 Biohazard", 79.99, terror));
		jogos.add(new Jogo(10, "Fnaf", 5.99, terror));
		jogos.add(new Jogo(2, "COD Ghosts", 329.99, tiro));
		jogos.add(new Jogo(25, "BF1", 129.99, tiro));

		System.out.println("Bem vindo ao banco de dados!");

		boolean res = true;

		do {

			System.out.println("O que deseja fazer?");
			System.out.println("1.Inserir jogo na lista;");
			System.out.println("2.Exibir todos os jogos cadastrados;");
			System.out.println("3.Aplicar desconto percentual a um jogo;");
			System.out.println("4.Remover jogo da lista informando o código;");
			System.out.println("5.Alterar a categoria de um jogo;");
			System.out.println("6.Listar jogos organizados por categoria;");
			System.out.println("7.Modificar o valor de um jogo cadastrado;");
			System.out.println("8.Listar jogos com preço acima de um valor informado;");
			System.out.println("9.Sair.");

			int escolha = scan.nextInt();

			switch (escolha) {
			case 1:
				inserir();
				break;
			case 2:
				exibir();
				break;
			case 3:
				aplicarDesconto();
				break;
			case 4:
				remover();
				break;
			case 5:
				alterarCategoria();
				break;
			case 6:
				listarPorCategoria();
				break;
			case 7:
				modificarValor();
				break;
			case 8:
				listarPorPreco();
				break;
			default:
				res = false;
				break;
			}
			if (res) {
				scan.nextLine();// limpar o buffer né
				System.out.println("Deseja continuar? S/N");
				res = scan.nextLine().toLowerCase().equals("s");
			}
		} while (res);

		System.out.println("Saindo!");

		scan.close();
	}

	private static void inserir() {
		System.out.println("Digite os dados do jogo");
		System.out.print("Código: ");
		int codigo = scan.nextInt();
		if (jogoPeloCodigo(codigo) != null) {
			System.out.printf("Já existe um jogo com código %d!\n", codigo);

			return;
		}
		scan.nextLine();// limpar o buffer né
		System.out.print("Nome: ");
		String nome = scan.nextLine();

		System.out.print("Preço: ");
		double preco = scan.nextDouble();

		System.out.print("Categoria: ");
		int codigoCategoria = scan.nextInt();
		Categoria categoria = categorias.stream().filter(x -> x.getCodigo() == codigoCategoria).findAny().orElse(null);

		if (categoria == null) {
			System.out.printf("Categoria %d não existe!\n", codigoCategoria);
			return;
		}
		Jogo jogo = new Jogo(codigo, nome, preco, categoria);
		jogos.add(jogo);

		System.out.printf("Adicionado jogo:\n %s\n", jogo.toString());
	}

	private static void exibir() {
		System.out.println("Jogos: ");
		for (Jogo jogo : jogos) {
			System.out.println(jogo);
		}
	}

	private static void aplicarDesconto() {
		Jogo jogo = solicitarJogo();

		if (jogo != null) {
			System.out.print("Insira o valor do desconto:");
			double desconto = scan.nextDouble();
			double precoAnterior = jogo.getPreco();

			jogo.aplicarDesconto(desconto);

			double precoAtual = jogo.getPreco();
			System.out.printf("Desconto de %.2f%% aplicado! R$%.2f -> R$%.2f\n", desconto, precoAnterior, precoAtual);
		}
	}

	private static void remover() {
		Jogo jogo = solicitarJogo();
		if (jogo != null) {
			jogos.remove(jogo);
			System.out.println("Jogo removido!");
		}
	}

	private static void alterarCategoria() {
		Jogo jogo = solicitarJogo();

		if (jogo != null) {
			System.out.print("Insira o código da categoria: ");
			int codigo = scan.nextInt();
			Categoria categoriaNova = categoriaPeloCodigo(codigo);
			if (categoriaNova == null) {
				System.out.printf("Não existem categora com código %d!\n", codigo);
			} else {
				Categoria categoriaVelha = jogo.getCategoria();
				jogo.setCategoria(categoriaNova);

				System.out.printf("Categoria alterada! [%s] -> [%s]\n", categoriaVelha.toString(), categoriaNova.toString());
			}
		}
	}

	private static void listarPorCategoria() {
		jogos.sort(Comparator.comparingInt(x -> x.getCategoria().getCodigo()));
		Categoria ultimaCategoria = null;
		
		for (Jogo jogo : jogos) {
			Categoria categoria = jogo.getCategoria();

			if (categoria != ultimaCategoria) {
				ultimaCategoria = categoria;
				System.out.printf("Categoria: [%s]\n", categoria.toString());
			}
			System.out.println(jogo);
		}
	}

	private static void modificarValor() {
		Jogo jogo = solicitarJogo();
		
		if(jogo != null) {
			System.out.print("Insira o valor novo: ");
			double novoValor = scan.nextDouble();
			double valorAntigo = jogo.getPreco();
			
			jogo.setPreco(novoValor);
			
			System.out.printf("Valor alterado! R$%.2f -> R$%.2f\n", valorAntigo, novoValor);
		}
	}

	private static void listarPorPreco() {
		System.out.print("Insira um preço: ");
		double preco = scan.nextDouble();
		
		jogos.stream().filter(x -> x.getPreco() >= preco).forEach(x -> System.out.println(x));
	}

	private static Jogo solicitarJogo() {
		System.out.print("Insira o código do jogo: ");
		int codigo = scan.nextInt();

		Jogo jogo = jogoPeloCodigo(codigo);
		if (jogo == null) {
			System.out.printf("Não existem jogo com código %d!\n", codigo);
		} else {
			System.out.println(jogo);
		}
		return jogo;
	}

	private static Categoria categoriaPeloCodigo(int codigo) {
		return categorias.stream().filter(x -> x.getCodigo() == codigo).findAny().orElse(null);
	}

	private static Jogo jogoPeloCodigo(int codigo) {
		return jogos.stream().filter(x -> x.getCodigo() == codigo).findAny().orElse(null);
	}
}