package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.enums.TarefaStatus;

public class Tarefa {

	private Integer id;
	private String conteudo;
	private TarefaStatus status;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public Tarefa(Integer id, String conteudo, TarefaStatus status) {
		this.id = id;
		this.conteudo = conteudo;
		this.status = status;
		this.dataCriacao = LocalDateTime.now();
		this.dataAtualizacao = this.dataCriacao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
		this.dataAtualizacao = LocalDateTime.now();
	}

	public TarefaStatus getStatus() {
		return status;
	}

	public void setStatus(TarefaStatus status) {
		this.status = status;
		this.dataAtualizacao = LocalDateTime.now();
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getdataCriacao() {
		return dataCriacao;
	}

	public void setdataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getdataAtualizacao() {
		return dataAtualizacao;
	}

	public void setdataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String tarefaBancoDados() {
		return getId() + "," + getConteudo() + "," + getStatus() + "," + getdataCriacao() + "," + getdataAtualizacao();
	}

	@Override
	public String toString() {
		return "TAREFA " + (getId() + 1) + ": id = " + getId() + ", \"" + getConteudo() + "\", status = " + getStatus()
				+ ", criada em = " + getdataCriacao().format(fmt) + ", atualizada em = "
				+ getdataAtualizacao().format(fmt);
	}
}
