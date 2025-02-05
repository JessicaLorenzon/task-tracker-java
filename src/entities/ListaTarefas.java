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

	public void atualizarTarefa(int id, String novoConteudo) {
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getId() == id) {
				tarefa.setConteudo(novoConteudo);
			}
		}
	}

	public void mostrarTela() {
		for (Tarefa tarefa : tarefas) {
			System.out.println("TAREFA: id= " + tarefa.getId() + ", conteudo= " + tarefa.getConteudo() + ", status= "
					+ tarefa.getStatus());
		}
		;
	}

}
