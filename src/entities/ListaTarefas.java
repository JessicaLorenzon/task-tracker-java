package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.TarefaStatus;

public class ListaTarefas {

	private List<Tarefa> tarefas = new ArrayList<>();
	private int id = 0;

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void adicionarTarefa(String conteudo) {
		tarefas.add(new Tarefa(id, conteudo, TarefaStatus.PENDENTE));
		id++;
	}

	public void removerTarefa(int id) {
		Tarefa tarefaRemovida = null;
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getId() == id) {
				tarefaRemovida = tarefa;
				break;
			}
		}
		tarefas.remove(tarefaRemovida);
	}

	public void modificarTarefa(int id, String novoConteudo) {
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getId() == id) {
				tarefa.setConteudo(novoConteudo);
				break;
			}
		}
	}

	public void marcarConcluido(int id) {
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getId() == id) {
				tarefa.setStatus(TarefaStatus.CONCLUIDO);
				break;
			}
		}
	}

	public void marcarAndamento(int id) {
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getId() == id) {
				tarefa.setStatus(TarefaStatus.EM_ANDAMENTO);
				break;
			}
		}
	}

	public void mostrarTela() {
		if (tarefas.size() == 0) {
			System.out.println("Lista de tarefas vazia. Adicione uma tarefa!");
		} else {
			for (Tarefa tarefa : tarefas) {
				System.out.printf("TAREFA %d: id = %d, \"%s\", status = %s \n", tarefa.getId() + 1, tarefa.getId(),
						tarefa.getConteudo(), tarefa.getStatus());
			}
		}
	}

	public void listarConcluidas() {
		boolean possuiConcluidas = false;

		for (Tarefa tarefa : tarefas) {
			if (tarefa.getStatus() == TarefaStatus.CONCLUIDO) {
				System.out.printf("TAREFA %d: id = %d, \"%s\", status = %s \n", tarefa.getId() + 1, tarefa.getId(),
						tarefa.getConteudo(), tarefa.getStatus());
				possuiConcluidas = true;
			}
		}
		if (possuiConcluidas == false) {
			System.out.println("Não existem tarefas concluidas!");
		}
	}

	public void listarPendentes() {
		boolean possuiPendentes = false;

		for (Tarefa tarefa : tarefas) {
			if (tarefa.getStatus() == TarefaStatus.PENDENTE) {
				System.out.printf("TAREFA %d: id = %d, \"%s\", status = %s \n", tarefa.getId() + 1, tarefa.getId(),
						tarefa.getConteudo(), tarefa.getStatus());
				possuiPendentes = true;
			}
		}
		if (possuiPendentes == false) {
			System.out.println("Não existem tarefas pendentes!");
		}
	}

	public void listarAndamento() {
		boolean possuiAndamento = false;

		for (Tarefa tarefa : tarefas) {
			if (tarefa.getStatus() == TarefaStatus.EM_ANDAMENTO) {
				System.out.printf("TAREFA %d: id = %d, \"%s\", status = %s \n", tarefa.getId() + 1, tarefa.getId(),
						tarefa.getConteudo(), tarefa.getStatus());
				possuiAndamento = true;
			}
		}
		if (possuiAndamento == false) {
			System.out.println("Não existem tarefas em andamento!");
		}
	}
}
