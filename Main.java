import java.util.Comparator;
import java.util.Scanner;

public class Main {
    
    static Biblioteca biblio = new Biblioteca();
    static Scanner input = new Scanner(System.in);

    // Função para limpar a tela
    public static void limpar(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    
    // Função para listar os livros ordenados por título
    private static void listar() {
        var livros = biblio.pesquisarTodos();
        livros.sort(Comparator.comparing(Livro::getTitulo));
        System.out.println("======== LISTA DE LIVROS =========");
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano: " + livro.getAnoPublicacao());
            System.out.println("N. Páginas: " + livro.getnPaginas());
            System.out.println("-----------------------------");
        }
        System.out.println("Pressione Enter para continuar...");
        input.nextLine();  // espera o usuário pressionar enter
    }

    // Função para ler entradas numéricas
    private static int inputNumerico(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.println(mensagem);
        do {
            String valorStr = input.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Erro. Por favor informe um número inteiro");
            }
        } while (!entradaValida);

        return valor;
    }

    // Função para adicionar um novo livro
    private static void adicionar() {
        Livro novoLivro = new Livro();
        System.out.println("======== ADICIONANDO NOVO LIVRO ========");
        System.out.print("Informe o título do livro: ");
        String titulo = input.nextLine();
        novoLivro.setTitulo(titulo);

        System.out.print("Informe o nome do autor: ");
        novoLivro.setAutor(input.nextLine());

        System.out.print("Informe o ano de publicação: ");
        novoLivro.setAnoPublicacao(inputNumerico("Ano de publicação: "));

        System.out.print("Informe o número de páginas: ");
        novoLivro.setnPaginas(inputNumerico("Número de páginas: "));

        try {
            biblio.adicionar(novoLivro);
            System.out.println("Livro adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("Pressione Enter para continuar...");
        input.nextLine();
    }

    // Função principal (menu)
    public static void main(String[] args) {
        String menu = """
                SISTEMA DE GERENCIAMENTO DE BIBLIOTECA
                Escolha uma das opções:
                1 - Adicionar novo livro;
                2 - Listar todos os livros;
                3 - Pesquisar livro;
                4 - Remover livro;
                0 - Sair;
                """;
        int opcao;
        do {
            opcao = inputNumerico(menu);
            switch (opcao) {
                case 0:
                    System.out.println("VOLTE SEMPRE!!!");
                    break;
                case 1:
                    adicionar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    // implementar função para pesquisar por título
                    break;
                case 4:
                    // implementar função para remover livro
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    break;
            }
        } while (opcao != 0);
    }
}