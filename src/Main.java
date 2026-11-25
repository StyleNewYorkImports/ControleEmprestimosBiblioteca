import java.util.Scanner;

public class Main {
    private static Scanner entrada = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        int opcao;

        do {
            mostrarMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    buscarLivro();
                    break;
                case 4:
                    emprestarLivro();
                    break;
                case 5:
                    devolverLivro();
                    break;
                case 6:
                    biblioteca.mostrarQuantidadePorSituacao();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção do menu.");
            }
        } while (opcao != 0);

        entrada.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("========== BIBLIOTECA ESCOLAR ==========");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Buscar livro pelo código");
        System.out.println("4 - Registrar empréstimo");
        System.out.println("5 - Registrar devolução");
        System.out.println("6 - Quantidade de livros por situação");
        System.out.println("0 - Sair");
        System.out.println("========================================");
    }

    private static void cadastrarLivro() {
        System.out.println("\n--- Cadastro de livro ---");
        int codigo = lerInteiroPositivo("Código: ");

        if (biblioteca.buscarLivro(codigo) != null) {
            System.out.println("Já existe um livro cadastrado com esse código.");
            return;
        }

        String titulo = lerTextoObrigatorio("Título: ");
        String autor = lerTextoObrigatorio("Autor: ");

        if (biblioteca.cadastrarLivro(codigo, titulo, autor)) {
            System.out.println("Livro cadastrado. Situação inicial: disponível.");
        } else {
            System.out.println("Não foi possível cadastrar o livro.");
        }
    }

    private static void buscarLivro() {
        System.out.println("\n--- Busca de livro ---");
        int codigo = lerInteiro("Digite o código: ");
        Livro livro = biblioteca.buscarLivro(codigo);

        if (livro == null) {
            System.out.println("Não foi encontrado um livro com esse código.");
        } else {
            livro.exibirDados();
            System.out.println("----------------------------------------");
        }
    }

    private static void emprestarLivro() {
        System.out.println("\n--- Empréstimo de livro ---");
        int codigo = lerInteiro("Código do livro: ");
        Livro livro = biblioteca.buscarLivro(codigo);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }
        if (livro.isEmprestado()) {
            System.out.println("Esse livro já está emprestado para " + livro.getNomeAluno() + ".");
            return;
        }

        String aluno = lerTextoObrigatorio("Nome do aluno: ");
        biblioteca.registrarEmprestimo(codigo, aluno);
        System.out.println("Empréstimo registrado para " + aluno + ".");
    }

    private static void devolverLivro() {
        System.out.println("\n--- Devolução de livro ---");
        int codigo = lerInteiro("Código do livro: ");
        Livro livro = biblioteca.buscarLivro(codigo);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }
        if (!livro.isEmprestado()) {
            System.out.println("Esse livro já está disponível. Não há empréstimo para devolver.");
            return;
        }

        biblioteca.registrarDevolucao(codigo);
        System.out.println("Devolução registrada. O livro está disponível novamente.");
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String valor = entrada.nextLine();
            try {
                return Integer.parseInt(valor.trim());
            } catch (NumberFormatException erro) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static int lerInteiroPositivo(String mensagem) {
        while (true) {
            int valor = lerInteiro(mensagem);
            if (valor > 0) {
                return valor;
            }
            System.out.println("O código deve ser maior que zero.");
        }
    }

    private static String lerTextoObrigatorio(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String valor = entrada.nextLine().trim();
            if (!valor.isEmpty()) {
                return valor;
            }
            System.out.println("Esse campo não pode ficar vazio.");
        }
    }
}
