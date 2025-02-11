package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ListaTarefas;
import entities.Tarefa;
import entities.enums.TarefaStatus;

public class Program {

	private static final String nomeDoArquivo = "tarefas.csv";
	public static String AreaTrabalhoUsuario = System.getProperty("user.home") + "/OneDrive/Área de Trabalho";
	public static Path caminhoArquivo = Paths.get(AreaTrabalhoUsuario, nomeDoArquivo);

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ListaTarefas tarefas = new ListaTarefas();

		List<Tarefa> tarefasArquivo = new ArrayList<>();

		if (Files.exists(caminhoArquivo)) {
			try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo.toFile()))) {
				String linha = br.readLine();
				int ultimoId = 0;

				while (linha != null) {
					String[] valores = linha.split(",");
					int id = Integer.parseInt(valores[0]);
					String conteudo = valores[1];
					String statusStr = valores[2];
					TarefaStatus status = TarefaStatus.valueOf(statusStr);
					LocalDateTime dataCriacao = LocalDateTime.parse(valores[3]);
					LocalDateTime dataAtualizacao = LocalDateTime.parse(valores[4]);

					if (id > ultimoId) {
						ultimoId = id;
					}

					Tarefa novaTarefa = new Tarefa(id, conteudo, status);
					novaTarefa.setdataCriacao(dataCriacao);
					novaTarefa.setdataAtualizacao(dataAtualizacao);

					tarefasArquivo.add(novaTarefa);

					linha = br.readLine();
				}
				tarefas.setId(ultimoId + 1);
				tarefas.setTarefas(tarefasArquivo);

			} catch (IOException e) {
				System.err.println("Erro ao ler o arquivo: " + e.getMessage());
			}
		}
		System.out.println(menu());
		while (true) {
			System.out.print("O que deseja fazer? ");
			String acao = sc.nextLine().trim().toLowerCase();

			if (acao.equals("sair") || acao.equals("11")) {
				System.out.println("Task Traker encerrado!");
				geradorArquivo(tarefas);
				break;
			}

			switch (acao) {
			case "1":
			case "adicionar":
				System.out.print("Digite a nova tarefa: ");
				String conteudo = sc.nextLine();
				tarefas.adicionarTarefa(conteudo);
				System.out.println();
				break;
			case "2":
			case "remover":
				System.out.print("Digite o ID da tarefa a ser removida: ");
				int idRemover = sc.nextInt();
				sc.nextLine();
				tarefas.removerTarefa(idRemover);
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
				System.out.println();
				break;
			case "4":
			case "marcar concluida":
				System.out.print("Digite o ID da tarefa a ser marcada como concluida: ");
				int idConcluido = sc.nextInt();
				sc.nextLine();
				tarefas.marcarConcluido(idConcluido);
				System.out.println();
				break;
			case "5":
			case "marcar em andamento":
				System.out.print("Digite o ID da tarefa a ser marcada como em andamento: ");
				int idAndamento = sc.nextInt();
				sc.nextLine();
				tarefas.marcarAndamento(idAndamento);
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
				System.out.println();
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

	public static void geradorArquivo(ListaTarefas tarefas) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo.toFile()))) {
			for (Tarefa tarefa : tarefas.getTarefas()) {
				bw.write(tarefa.tarefaBancoDados());
				bw.newLine();
			}
		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
		}
	}
}
