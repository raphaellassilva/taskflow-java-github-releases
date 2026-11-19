package br.com.taskflow.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.taskflow.model.Prioridade;
import br.com.taskflow.model.StatusTarefa;
import br.com.taskflow.model.Tarefa;

class GerenciadorTarefasTest {
    private GerenciadorTarefas gerenciador;

    @BeforeEach
    void configurar() {
        gerenciador = new GerenciadorTarefas();
    }

    @Test
    void deveCadastrarTarefaComStatusPendente() {
        Tarefa tarefa = gerenciador.criarTarefa("Preparar apresentação", "Revisar slides", Prioridade.ALTA);

        assertEquals(1, tarefa.getId());
        assertEquals("Preparar apresentação", tarefa.getTitulo());
        assertEquals(StatusTarefa.PENDENTE, tarefa.getStatus());
    }

    @Test
    void deveRejeitarTituloVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> gerenciador.criarTarefa("   ", "Descrição", Prioridade.MEDIA));
        assertTrue(gerenciador.listarTarefas().isEmpty());
    }

    @Test
    void deveAtualizarStatusDaTarefa() {
        Tarefa tarefa = gerenciador.criarTarefa("Estudar Java", "", Prioridade.MEDIA);

        gerenciador.atualizarStatus(tarefa.getId(), StatusTarefa.CONCLUIDA);

        assertEquals(StatusTarefa.CONCLUIDA, tarefa.getStatus());
    }

    @Test
    void deveInformarErroAoBuscarIdInexistente() {
        assertThrows(java.util.NoSuchElementException.class,
                () -> gerenciador.buscarPorId(99));
    }

    @Test
    void deveContarTarefasPorStatus() {
        Tarefa primeira = gerenciador.criarTarefa("Tarefa A", "", Prioridade.BAIXA);
        Tarefa segunda = gerenciador.criarTarefa("Tarefa B", "", Prioridade.ALTA);
        gerenciador.atualizarStatus(segunda.getId(), StatusTarefa.EM_ANDAMENTO);

        assertEquals(1, gerenciador.contarPorStatus(StatusTarefa.PENDENTE));
        assertEquals(1, gerenciador.contarPorStatus(StatusTarefa.EM_ANDAMENTO));
        assertEquals(0, gerenciador.contarPorStatus(StatusTarefa.CONCLUIDA));
    }

    @Test
    void deveImpedirAlteracaoDiretaDaListaDeTarefas() {
        gerenciador.criarTarefa("Estudar Git", "Praticar comandos", Prioridade.MEDIA);

        var tarefas = gerenciador.listarTarefas();

        assertThrows(UnsupportedOperationException.class, tarefas::clear);
}
}
