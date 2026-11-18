package br.com.taskflow.service;

import br.com.taskflow.model.Prioridade;
import br.com.taskflow.model.StatusTarefa;
import br.com.taskflow.model.Tarefa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class GerenciadorTarefas {
    private final List<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1;

    public Tarefa criarTarefa(String titulo, String descricao, Prioridade prioridade) {
        Tarefa tarefa = new Tarefa(proximoId++, titulo, descricao, prioridade);
        tarefas.add(tarefa);
        return tarefa;
    }

    public List<Tarefa> listarTarefas() {
        return Collections.unmodifiableList(new ArrayList<>(tarefas));
    }

    public Tarefa buscarPorId(int id) {
        return tarefas.stream()
                .filter(tarefa -> tarefa.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Não existe tarefa com o ID " + id + "."));
    }

    public Tarefa atualizarStatus(int id, StatusTarefa novoStatus) {
        Tarefa tarefa = buscarPorId(id);
        tarefa.setStatus(novoStatus);
        return tarefa;
    }

    public long contarPorStatus(StatusTarefa status) {
        return tarefas.stream().filter(tarefa -> tarefa.getStatus() == status).count();
    }
}
