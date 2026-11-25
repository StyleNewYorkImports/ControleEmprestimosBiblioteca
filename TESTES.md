# Registro de testes

Execute os cenários abaixo no terminal ou na IDE. Marque o resultado como aprovado somente depois de executar cada cenário na sua máquina.

| Nº | Ação e dados utilizados | Resultado esperado | Resultado observado |
|---|---|---|---|
| 1 | Cadastrar código 101, título `Dom Casmurro`, autor `Machado de Assis` | Cadastro realizado e livro disponível | A preencher após executar |
| 2 | Cadastrar novamente o código 101 | Cadastro duplicado recusado | A preencher após executar |
| 3 | Informar título vazio e, em outro cadastro, autor vazio | Campo vazio recusado e solicitado novamente | A preencher após executar |
| 4 | Buscar o código 101 | Dados do livro exibidos | A preencher após executar |
| 5 | Buscar o código 999 | Mensagem de livro não encontrado | A preencher após executar |
| 6 | Emprestar o código 101 para `Ana` | Situação passa para emprestado e nome Ana aparece | A preencher após executar |
| 7 | Tentar emprestar novamente o código 101 | Nova tentativa recusada; empréstimo original mantido | A preencher após executar |
| 8 | Devolver o código 101 | Situação volta para disponível e nome Ana é apagado | A preencher após executar |
| 9 | Listar livros antes de cadastrar qualquer exemplar | Mensagem informando que não há livros cadastrados | A preencher após executar |
| 10 | Digitar uma opção inexistente, como 9 | Mensagem de opção inválida e menu reapresentado | A preencher após executar |

## Roteiro para a demonstração

1. Cadastre um livro com código `101`.
2. Tente cadastrar outro livro com o mesmo código.
3. Busque o livro `101`.
4. Faça o empréstimo para `Ana`.
5. Tente emprestar o mesmo exemplar novamente.
6. Mostre a quantidade de livros disponíveis e emprestados.
7. Faça a devolução e consulte o livro para confirmar que está disponível e sem nome de aluno.

**Importante:** preencha a coluna “Resultado observado” somente com o que você verificar ao executar os testes.
