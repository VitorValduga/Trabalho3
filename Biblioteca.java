import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    // BD em memória
    private List<Livro> acervo = new ArrayList<>();

    public void adicionar(Livro livro) throws Exception {
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty())
            throw new Exception("Não é permitido cadastrar livros sem título");
        for (Livro livroAcervo : acervo) {
            if (livroAcervo.getTitulo().equalsIgnoreCase(livro.getTitulo()))
                throw new Exception("Já existe um livro com este título");
        }
        if (livro.getAutor() == null || livro.getAutor().isEmpty())
            throw new Exception("Não é permitido cadastrar livros sem autor");

        if (livro.getAnoPublicacao() < 1400 || livro.getAnoPublicacao() > LocalDate.now().getYear())
            throw new Exception("Ano de publicação inválido. Deve ser entre 1400 e 2024");

        if (livro.getnPaginas() <= 0)
            throw new Exception(" Não é permitido o cadastro de livros com o número de páginas negativos ou zerados.");

        acervo.add(livro);
    }

    public List<Livro> pesquisarPorTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public void removerPorTitulo(String titulo) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                acervo.remove(livro);
                break;
            }
        }
    }

    public List<Livro> pesquisarTodos() {
        return this.acervo;
    }
}
