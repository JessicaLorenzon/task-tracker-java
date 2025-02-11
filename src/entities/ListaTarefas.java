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

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public void adicionarTarefa(String conteudo) {
		if (conteudo.isBlank()) {
			System.out.println("Ação não reconhecida. Tente novamente!");
		} else {
			tarefas.add(new Tarefa(id, conteudo, TarefaStatus.PENDENTE));
			id++;
			System.out.println("Tarefa adicionada com sucesso!");
		}
	}

	public void removerTarefa(int id) {
		Tarefa tarefa = getTarefaPorId(id);
		if (tarefa != null) {
			tarefas.remove(tarefa);
			System.out.println("Tarefa com ID: " + id + " removida com sucesso!");
		}
	}

	public void modificarTarefa(int id, String novoConteudo) {
		Tarefa tarefa = getTarefaPorId(id);
		if (novoConteudo.isBlank()) {
			System.out.println("Tarefa vazia. Tente novamente!");
		} else {
			if (tarefa != null) {
				tarefa.setConteudo(novoConteudo);
				System.out.println("Tarefa com ID: " + id + " modificada com sucesso!");
			}
		}
	}

	public void mostrarTela() {
		if (tarefas.size() == 0) {
			System.out.println("Lista de tarefas vazia. Adicione uma tarefa!");
		} else {
			for (Tarefa tarefa : tarefas) {
				System.out.println(tarefa);
			}
		}
	}

	public void marcarConcluido(int id) {
		alterarStatus(id, TarefaStatus.CONCLUIDO);
	}

	public void marcarAndamento(int id) {
		alterarStatus(id, TarefaStatus.EM_ANDAMENTO);
	}

	public void listarConcluidas() {
		listarPorStatus(TarefaStatus.CONCLUIDO);
	}

	public void listarPendentes() {
		listarPorStatus(TarefaStatus.PENDENTE);
	}

	public void listarAndamento() {
		listarPorStatus(TarefaStatus.EM_ANDAMENTO);
	}

	private void alterarStatus(int id, TarefaStatus status) {
		Tarefa tarefa = getTarefaPorId(id);
		if (tarefa != null) {
			tarefa.setStatus(status);
			System.out.println("Status da tarefa com ID: " + id + " atualizado com sucesso!");
		}
	}

	private Tarefa getTarefaPorId(int id) {
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getId() == id) {
				return tarefa;
			} else {
				System.out.println("ID não encontrado. Tente novamente!");
			}
		}
		return null;
	}

	private void listarPorStatus(TarefaStatus status) {
		boolean possuiStatus = false;
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getStatus() == status) {
				System.out.println(tarefa);
				possuiStatus = true;
			}
		}
		if (possuiStatus == false) {
			System.out.println("Tarefas não encontradas!");
		}
	}
}
