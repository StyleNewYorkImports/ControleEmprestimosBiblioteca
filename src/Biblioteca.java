import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public boolean cadastrarLivro(int codigo, String titulo, String autor) {
        if (buscarLivro(codigo) != null) {
            return false;
        }
        livros.add(new Livro(codigo, titulo, autor));
        return true;
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Ainda não há livros cadastrados.");
            return;
        }
        for (Livro livro : livros) {
            livro.exibirDados();
        }
        System.out.println("----------------------------------------");
    }

    public Livro buscarLivro(int codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo() == codigo) {
                return livro;
            }
        }
        return null;
    }

    public boolean registrarEmprestimo(int codigo, String nomeAluno) {
        Livro livro = buscarLivro(codigo);
        if (livro == null || livro.isEmprestado()) {
            return false;
        }
        livro.emprestar(nomeAluno);
        return true;
    }

    public boolean registrarDevolucao(int codigo) {
        Livro livro = buscarLivro(codigo);
        if (livro == null || !livro.isEmprestado()) {
            return false;
        }
        livro.devolver();
        return true;
    }

    public void mostrarQuantidadePorSituacao() {
        int disponiveis = 0;
        int emprestados = 0;

        for (Livro livro : livros) {
            if (livro.isEmprestado()) {
                emprestados++;
            } else {
                disponiveis++;
            }
        }

        System.out.println("Livros disponíveis: " + disponiveis);
        System.out.println("Livros emprestados: " + emprestados);
        System.out.println("Total cadastrado: " + livros.size());
    }
}
