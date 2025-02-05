package entities;

import entities.enums.TarefaStatus;

public class Tarefa {

	private Integer id;
	private String conteudo;
	private TarefaStatus status;

	public Tarefa(Integer id, String conteudo, TarefaStatus status) {
		this.id = id;
		this.conteudo = conteudo;
		this.status = status;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public TarefaStatus getStatus() {
		return status;
	}

	public void setStatus(TarefaStatus status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", conteudo=" + conteudo + ", status=" + status + "]";
	}

	


}
