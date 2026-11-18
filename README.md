# TaskFlow — Java + GitHub Releases

Gerenciador de tarefas de terminal criado para demonstrar CI/CD na disciplina de Abordagem DevOps e Entregas Contínuas.

## Funcionalidades
- Cadastrar tarefas com título, descrição e prioridade.
- Listar tarefas.
- Alterar o status para PENDENTE, EM_ANDAMENTO ou CONCLUIDA.
- Consultar resumo de tarefas por status.
- Validar título vazio e ID inexistente.
- Manter os dados em memória durante a execução (ao fechar, os dados são apagados).

## Tecnologias
- Java 21
- Maven
- JUnit 5
- Git e GitHub
- GitHub Actions
- GitHub Releases

## Executar localmente
Requisitos: JDK 21, Maven e Git.
```bash
mvn clean verify
java -jar target/taskflow.jar
```

## CI/CD
- Pull Request destinado a `main`: executa build e testes.
- Push em `main` (normalmente após merge aprovado): executa build e testes; se passarem, publica `target/taskflow.jar` no GitHub Releases.
- O workflow utiliza `contents: write` para criar Releases.

## Configuração no GitHub
1. Envie o projeto a um repositório público.
2. Espere o workflow executar pelo menos uma vez.
3. Em Settings, configure a regra da branch `main` para exigir Pull Request e o status check `Build e testes automatizados`.
4. Teste um PR com falha sem fazer merge dele.
5. Corrija a falha, espere a verificação passar e faça merge.
6. Confira a aba Releases.

## Observação
O projeto guarda dados apenas em memória; isso mantém o escopo simples para a demonstração. O GitHub Releases distribui o arquivo JAR e não hospeda uma aplicação web.
