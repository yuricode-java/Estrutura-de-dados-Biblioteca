public class Biblioteca {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Jojolion", "Hirohiko Araki", 2011);
        Livro livro2 = new Livro("Estruturas de Dados", "Autor X", 2023);

        Usuario u1 = new Usuario("Yuri");
        Usuario u2 = new Usuario("Cacaio");

        u1.visualizarLivro(livro1);
        u1.visualizarLivro(livro2);
        u1.verHistorico();

        System.out.println("---");

        livro1.SolicitarLivro(u1);
        livro1.SolicitarLivro(u2);

        livro1.verFila();

    }
}