
# TaskFlow — Gerenciador de Tarefas Java

Projeto desenvolvido para a disciplina de **Abordagem DevOps e Entregas Contínuas**, com o objetivo de demonstrar desenvolvimento Java, testes automatizados, integração contínua (CI) e publicação de artefatos utilizando GitHub Actions e GitHub Releases.

## Objetivo

Desenvolver uma aplicação simples de gerenciamento de tarefas executada via terminal, aplicando práticas de desenvolvimento de software, testes automatizados e automação de processos de build e publicação.

## Funcionalidades

- Cadastrar tarefas com título, descrição e prioridade.
- Listar tarefas cadastradas.
- Alterar o status de uma tarefa.
- Consultar resumo das tarefas por status.
- Validar título vazio.
- Validar ID inexistente.
- Gerenciar tarefas em memória durante a execução.

## Status das tarefas

- PENDENTE
- EM_ANDAMENTO
- CONCLUIDA

## Tecnologias utilizadas

- Java 21
- Maven
- JUnit 5
- Git
- GitHub
- GitHub Actions
- GitHub Releases

## Estrutura do projeto

```text
taskflow/
├── .github/
│   └── workflows/
│       └── ci-cd.yml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── br/com/taskflow/
│   └── test/
│       └── java/
├── pom.xml
├── .gitignore
└── README.md
```

## Requisitos

Para executar o projeto, é necessário ter instalado:

- Java JDK 21 ou superior.
- Apache Maven 3.9 ou superior.
- Git.

## Como obter o projeto

Clone o repositório:

```bash
git clone https://github.com/raphaellassilva/taskflow-java-github-releases.git
```

Entre na pasta do projeto:

```bash
cd taskflow-java-github-releases
```

## Como compilar e executar

Para compilar o projeto e executar os testes automatizados:

```bash
mvn clean verify
```

Para iniciar a aplicação:

```bash
java -jar target/taskflow.jar
```

## Como utilizar a aplicação

Ao executar o programa, será apresentado um menu com as seguintes opções:

1. Cadastrar tarefa.
2. Listar tarefas.
3. Alterar status da tarefa.
4. Ver resumo.
0. Sair.

As tarefas podem ser cadastradas com título, descrição e prioridade.

As prioridades disponíveis são:

- BAIXA
- MEDIA
- ALTA

Os status disponíveis são:

- PENDENTE
- EM_ANDAMENTO
- CONCLUIDA

## Testes automatizados

O projeto utiliza JUnit 5 para verificar o funcionamento das principais funcionalidades.

Os testes automatizados contemplam:

- Criação de tarefa com status inicial pendente.
- Validação de título vazio.
- Alteração do status de uma tarefa.
- Tratamento de ID inexistente.
- Contagem de tarefas por status.

Para executar os testes separadamente:

```bash
mvn test
```

## Integração contínua e entrega contínua (CI/CD)

O projeto utiliza GitHub Actions para automatizar o processo de integração e entrega contínua.

O workflow está localizado em:

`.github/workflows/ci-cd.yml`

O pipeline foi configurado para:

1. Executar o processo de build com Maven.
2. Executar os testes automatizados.
3. Verificar se a compilação e os testes foram concluídos com sucesso.
4. Publicar uma GitHub Release quando as condições configuradas no workflow forem atendidas.

A automação permite verificar a qualidade do código antes da disponibilização de novas versões.

## GitHub Releases

O projeto utiliza GitHub Releases para disponibilizar versões da aplicação e seus respectivos artefatos.

As versões publicadas podem ser consultadas na seção Releases do repositório:

https://github.com/raphaellassilva/taskflow-java-github-releases/releases

## Controle de versão e colaboração

O desenvolvimento utiliza Git e GitHub para controle de versão e colaboração entre os integrantes.

O fluxo de trabalho contempla:

- Branch principal `main`.
- Branches de funcionalidades.
- Pull Requests para revisão das alterações.
- Proteção da branch principal.
- Verificação automatizada por GitHub Actions.

## Limitações do projeto

- Aplicação executada exclusivamente pelo terminal.
- As tarefas são armazenadas em memória.
- Os dados não são mantidos após o encerramento da aplicação.
- O projeto possui finalidade acadêmica e demonstrativa.

## Integrantes

- Raphaella de Souza Silva
- Charlene Costa

## Disciplina

**Abordagem DevOps e Entregas Contínuas**

Projeto acadêmico desenvolvido com foco em Java, testes automatizados, Git, GitHub Actions e práticas de CI/CD.
