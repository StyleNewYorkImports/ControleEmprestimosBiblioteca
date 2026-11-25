# Controle de Empréstimos de Livros

**Aluno:** Matheus Nicolas da Silva Soto  
**Turma:** 2 D.S

## Tema escolhido

Opção B — Controle de Empréstimos de Livros.

## Descrição

Programa de console para organizar os exemplares de uma biblioteca escolar. Cada livro possui código, título, autor e situação. Quando um exemplar é emprestado, o sistema registra o nome do aluno. Na devolução, o exemplar volta a ficar disponível e o nome do aluno é apagado.

Os dados ficam armazenados em memória durante a execução. Ao fechar o programa, os registros são perdidos, conforme permitido no enunciado.

## Funcionalidades

1. Cadastrar um livro.
2. Listar todos os livros e suas situações.
3. Buscar um livro pelo código.
4. Registrar um empréstimo com o nome do aluno.
5. Registrar uma devolução.
6. Mostrar a quantidade de livros disponíveis e emprestados.
7. Sair do programa.

## Validações

- O código deve ser maior que zero e não pode se repetir.
- Título, autor e nome do aluno não podem ficar vazios.
- Todo livro começa como disponível.
- Não é permitido emprestar um livro que já esteja emprestado.
- Não é permitido devolver um livro que já esteja disponível.
- Na devolução, a situação muda para disponível e o nome do aluno é apagado.
- O sistema informa quando o código não existe.
- Entradas numéricas inválidas são solicitadas novamente.

## Arquivos do projeto

- `src/Livro.java`: classe que representa um exemplar.
- `src/Biblioteca.java`: lista de livros e operações de controle.
- `src/Main.java`: menu e entrada de dados.

## Como executar

É necessário ter o JDK instalado.

No terminal, dentro da pasta do projeto:

```bash
javac -d out src/*.java
java -cp out Main
```

Na IntelliJ IDEA, abra a pasta do projeto, configure um JDK se necessário e execute `src/Main.java`.

## Testes

Consulte o arquivo `TESTES.md`, que contém os cenários de teste e o roteiro para conferência.

## Uso de ferramentas de apoio

Foi utilizada uma ferramenta de inteligência artificial como apoio à organização da estrutura inicial, revisão das validações e preparação da documentação. O aluno deve executar o programa, conferir os resultados e compreender o código para realizar a demonstração individual.

## Limitações

- Os dados não são salvos após o encerramento.
- A aplicação funciona pelo console.
- Não utiliza banco de dados nem interface gráfica.
