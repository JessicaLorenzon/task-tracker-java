package application;

import java.util.Scanner;

import entities.ListaTarefas;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ListaTarefas tarefas = new ListaTarefas();

		while (true) {
			System.out.print("O que deseja fazer? ");
			String acao = sc.nextLine().trim().toLowerCase();

			if (acao.equals("sair")) {
				System.out.println("Task Traker encerrado!");
				break;
			}

			switch (acao) {
			case "adicionar":
				System.out.print("Digite a nova tarefa: ");
				String conteudo = sc.nextLine();
				tarefas.adicionarTarefa(conteudo);
				System.out.println("Tarefa adicionada com sucesso!");
				tarefas.mostrarTela();
				System.out.println();
				break;
			case "remover":
				System.out.print("Digite o ID da tarefa a ser removida: ");
				int idRemover = sc.nextInt();
				sc.nextLine();
				tarefas.removerTarefa(idRemover);
				System.out.println("Tarefa com ID: " + idRemover + " removida com sucesso!");
				tarefas.mostrarTela();
				System.out.println();
				break;
			case "modificar":
				System.out.print("Digite o ID da tarefa a ser modificada: ");
				int idModificar = sc.nextInt();
				sc.nextLine();
				System.out.print("Digite o novo conteudo da tarefa: ");
				String novoConteudo = sc.nextLine();
				tarefas.atualizarTarefa(idModificar, novoConteudo);
				System.out.println("Tarefa com ID: " + idModificar + " modificada com sucesso!");
				System.out.println();
				tarefas.mostrarTela();
				System.out.println();
				break;
			default:
				System.out.println("Ação não reconhecida. Tente novamente!");
			}
		}
		sc.close();
	}
}
