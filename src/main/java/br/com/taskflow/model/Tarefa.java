package br.com.taskflow.model;

public class Tarefa {
    private final int id;
    private final String titulo;
    private final String descricao;
    private final Prioridade prioridade;
    private StatusTarefa status;

    public Tarefa(int id, String titulo, String descricao, Prioridade prioridade) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título não pode ficar vazio.");
        }
        if (prioridade == null) {
            throw new IllegalArgumentException("A prioridade é obrigatória.");
        }
        this.id = id;
        this.titulo = titulo.trim();
        this.descricao = descricao == null ? "" : descricao.trim();
        this.prioridade = prioridade;
        this.status = StatusTarefa.PENDENTE;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public Prioridade getPrioridade() { return prioridade; }
    public StatusTarefa getStatus() { return status; }

    public void setStatus(StatusTarefa status) {
        if (status == null) {
            throw new IllegalArgumentException("O status é obrigatório.");
        }
        this.status = status;
    }
}
