package br.com.taskflow;

import br.com.taskflow.model.Prioridade;
import br.com.taskflow.model.StatusTarefa;
import br.com.taskflow.model.Tarefa;
import br.com.taskflow.service.GerenciadorTarefas;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final GerenciadorTarefas GERENCIADOR = new GerenciadorTarefas();

    public static void main(String[] args) {
        boolean executando = true;
        System.out.println("================================");
        System.out.println("       TASKFLOW - TAREFAS");
        System.out.println("================================");

        while (executando) {
            mostrarMenu();
            String opcao = SCANNER.nextLine().trim();
            try {
                switch (opcao) {
                    case "1" -> cadastrarTarefa();
                    case "2" -> listarTarefas();
                    case "3" -> alterarStatus();
                    case "4" -> mostrarResumo();
                    case "0" -> {
                        executando = false;
                        System.out.println("Até logo! Obrigado por usar o TaskFlow.");
                    }
                    default -> System.out.println("Opção inválida. Escolha uma opção do menu.");
                }
            } catch (IllegalArgumentException | java.util.NoSuchElementException e) {
                System.out.println("Não foi possível concluir: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        System.out.println("1 - Cadastrar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Alterar status da tarefa");
        System.out.println("4 - Ver resumo");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarTarefa() {
        System.out.print("Título: ");
        String titulo = SCANNER.nextLine();
        System.out.print("Descrição (opcional): ");
        String descricao = SCANNER.nextLine();
        System.out.println("Prioridade: 1-Baixa | 2-Média | 3-Alta");
        System.out.print("Escolha a prioridade: ");
        Prioridade prioridade = switch (SCANNER.nextLine().trim()) {
            case "1" -> Prioridade.BAIXA;
            case "2" -> Prioridade.MEDIA;
            case "3" -> Prioridade.ALTA;
            default -> throw new IllegalArgumentException("Prioridade inválida.");
        };

        Tarefa tarefa = GERENCIADOR.criarTarefa(titulo, descricao, prioridade);
        System.out.println("Tarefa cadastrada com sucesso! ID: " + tarefa.getId());
    }

    private static void listarTarefas() {
        List<Tarefa> tarefas = GERENCIADOR.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        System.out.println("--- TAREFAS ---");
        for (Tarefa tarefa : tarefas) {
            System.out.printf("ID: %d | %s | Prioridade: %s | Status: %s%n",
                    tarefa.getId(), tarefa.getTitulo(), tarefa.getPrioridade(), tarefa.getStatus());
            if (!tarefa.getDescricao().isBlank()) {
                System.out.println("   Descrição: " + tarefa.getDescricao());
            }
        }
    }

    private static void alterarStatus() {
        System.out.print("ID da tarefa: ");
        int id;
        try {
            id = Integer.parseInt(SCANNER.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("O ID deve ser um número inteiro.");
        }
        System.out.println("Novo status: 1-Pendente | 2-Em andamento | 3-Concluída");
        System.out.print("Escolha o status: ");
        StatusTarefa status = switch (SCANNER.nextLine().trim()) {
            case "1" -> StatusTarefa.PENDENTE;
            case "2" -> StatusTarefa.EM_ANDAMENTO;
            case "3" -> StatusTarefa.CONCLUIDA;
            default -> throw new IllegalArgumentException("Status inválido.");
        };
        Tarefa tarefa = GERENCIADOR.atualizarStatus(id, status);
        System.out.println("Status da tarefa '" + tarefa.getTitulo() + "' atualizado para " + status + ".");
    }

    private static void mostrarResumo() {
        System.out.println("--- RESUMO ---");
        System.out.println("Total cadastradas: " + GERENCIADOR.listarTarefas().size());
        System.out.println("Pendentes: " + GERENCIADOR.contarPorStatus(StatusTarefa.PENDENTE));
        System.out.println("Em andamento: " + GERENCIADOR.contarPorStatus(StatusTarefa.EM_ANDAMENTO));
        System.out.println("Concluídas: " + GERENCIADOR.contarPorStatus(StatusTarefa.CONCLUIDA));
    }
}
