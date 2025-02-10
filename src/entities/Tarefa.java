package entities;

import entities.enums.TarefaStatus;

public class Tarefa {

	private Integer id;
	private String conteudo;
	private TarefaStatus status;
	private String dataCriacao;
	private String dataAtualizacao;

	public Tarefa(Integer id, String conteudo, TarefaStatus status, String dataCriacao) {
		this.id = id;
		this.conteudo = conteudo;
		this.status = status;
		this.dataCriacao = dataCriacao;
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

	public String getdataCriacao() {
		return dataCriacao;
	}

	public void setdataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getdataAtualizacao() {
		return dataAtualizacao;
	}

	public void setdataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		if (getdataAtualizacao() == null) {
			return "TAREFA " + (getId() + 1) + ": id = " + getId() + ", \"" + getConteudo() + "\", status = "
					+ getStatus() + ", criada em = " + getdataCriacao();
		} else {
			return "TAREFA " + (getId() + 1) + ": id = " + getId() + ", \"" + getConteudo() + "\", status = "
					+ getStatus() + ", criada em = " + getdataCriacao() + ", atualizada em = " + getdataAtualizacao();
		}
	}
}
