public class Main {
    public static void main(String[] args) {

        // Criando livro
        Livro livro1 = new Livro("1984", "George Orwell", 1949);

        // Criando usuários
        Usuario u1 = new Usuario("Ana");
        Usuario u2 = new Usuario("Bruno");
        Usuario u3 = new Usuario("Carlos");

        u1.visualizarLivro(livro1);
        u1.visualizarLivro(new Livro("Senhor dos Anéis", "Tolkien", 1954));
        u1.visualizarLivro(new Livro("Dom Casmurro", "Machado de Assis", 1899));

        u1.verHistorico();

        // Ana pega o livro
        livro1.SolicitarLivro(u1);

        // Bruno tenta pegar (vai pra fila)
        livro1.SolicitarLivro(u2);

        // Carlos tenta pegar (vai pra fila)
        livro1.SolicitarLivro(u3);

        // Ver fila
        System.out.println("\nFila atual:");
        livro1.verFila();

        // Ana devolve → vai pro Bruno
        System.out.println("\nDevolvendo livro...");
        livro1.DevolverLivro(u1);

        // Ver fila depois
        System.out.println("\nFila depois da devolução:");
        livro1.verFila();

        // Bruno devolve → vai pro Carlos
        System.out.println("\nDevolvendo livro novamente...");
        livro1.DevolverLivro(u2);

        // Ver fila final
        System.out.println("\nFila final:");
        livro1.verFila();
    }
}