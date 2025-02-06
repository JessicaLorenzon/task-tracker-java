package application;

import java.util.Scanner;

import entities.ListaTarefas;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ListaTarefas tarefas = new ListaTarefas();

		System.out.println(menu());
		while (true) {
			System.out.print("O que deseja fazer? ");
			String acao = sc.nextLine().trim().toLowerCase();

			if (acao.equals("sair") || acao.equals("11")) {
				System.out.println("Task Traker encerrado!");
				break;
			}

			switch (acao) {
			case "1":
			case "adicionar":
				System.out.print("Digite a nova tarefa: ");
				String conteudo = sc.nextLine();
				tarefas.adicionarTarefa(conteudo);
				System.out.println("Tarefa adicionada com sucesso!");
				System.out.println();
				break;
			case "2":
			case "remover":
				System.out.print("Digite o ID da tarefa a ser removida: ");
				int idRemover = sc.nextInt();
				sc.nextLine();
				tarefas.removerTarefa(idRemover);
				System.out.println("Tarefa com ID: " + idRemover + " removida com sucesso!");
				System.out.println();
				break;
			case "3":
			case "modificar":
				System.out.print("Digite o ID da tarefa a ser modificada: ");
				int idModificar = sc.nextInt();
				sc.nextLine();
				System.out.print("Digite o novo conteudo da tarefa: ");
				String novoConteudo = sc.nextLine();
				tarefas.modificarTarefa(idModificar, novoConteudo);
				System.out.println("Tarefa com ID: " + idModificar + " modificada com sucesso!");
				System.out.println();
				break;
			case "4":
			case "marcar concluida":
				System.out.print("Digite o ID da tarefa a ser modificada: ");
				int idConcluido = sc.nextInt();
				sc.nextLine();
				tarefas.marcarConcluido(idConcluido);
				System.out.println("Tarefa com ID: " + idConcluido + " marcada como concluida!");
				System.out.println();
				break;
			case "5":
			case "marcar em andamento":
				System.out.print("Digite o ID da tarefa a ser modificada: ");
				int idAndamento = sc.nextInt();
				sc.nextLine();
				tarefas.marcarAndamento(idAndamento);
				System.out.println("Tarefa com ID: " + idAndamento + " marcada como em andamento!");
				System.out.println();
				break;
			case "6":
			case "listar todas":
				tarefas.mostrarTela();
				System.out.println();
				break;
			case "7":
			case "listar concluidas":
				tarefas.listarConcluidas();
				System.out.println();
				break;
			case "8":
			case "listar pendentes":
				tarefas.listarPendentes();
				System.out.println();
				break;
			case "9":
			case "listar em andamento":
				tarefas.listarAndamento();
				System.out.println();
				break;
			case "10":
			case "ajuda":
				System.out.println();
				System.out.println(menu());
				break;
			default:
				System.out.println("Ação não reconhecida. Tente novamente!");
			}
		}
		sc.close();
	}

	public static String menu() {
		StringBuilder sb = new StringBuilder();
		sb.append("MENU DE AÇÕES\n");
		sb.append("1 - Adicionar;\n");
		sb.append("2 - Remover;\n");
		sb.append("3 - Modificar;\n");
		sb.append("4 - Marcar concluida;\n");
		sb.append("5 - Marcar em andamento;\n");
		sb.append("6 - Listar todas;\n");
		sb.append("7 - Listar concluidas;\n");
		sb.append("8 - Listar pendentes;\n");
		sb.append("9 - Listar em andamento;\n");
		sb.append("10 - Ajuda;\n");
		sb.append("11 - Sair;\n");
		return sb.toString();
	}
}
