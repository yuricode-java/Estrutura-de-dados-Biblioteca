public class Main {
    public static void main(String[] args) {

        Livro livro1 = new Livro("1984", "George Orwell", 1949);
        Livro livro2 = new Livro("Jojolion", "Hirohiko Araki", 2011);
        Livro livro3 = new Livro("O Hobbit", "J.R.R. Tolkien", 1937);
        Livro livro4 = new Livro("Dom Casmurro", "Machado de Assis", 1899);

        Livro manga1 = new Livro("One Piece", "Eiichiro Oda", 1997);
        Livro manga2 = new Livro("Naruto", "Masashi Kishimoto", 1999);
        Livro manga3 = new Livro("Attack on Titan", "Hajime Isayama", 2009);
        Livro manga4 = new Livro("Death Note", "Tsugumi Ohba", 2003);

        Usuario u1 = new Usuario("Ana");
        Usuario u2 = new Usuario("Bruno");
        Usuario u3 = new Usuario("Carlos");

        GrafoLivros g1 = new GrafoLivros();

        g1.recomendarLivro(livro1, livro3);
        g1.recomendarLivro(livro1, manga4);

        g1.recomendarLivro(livro2, manga1);
        g1.recomendarLivro(livro2, manga3);

        g1.recomendarLivro(manga1, manga2);
        g1.recomendarLivro(manga2, manga3);
        g1.recomendarLivro(manga3, manga4);
        g1.recomendarLivro(manga4, livro1);

        u1.visualizarLivro(livro1);
        u1.visualizarLivro(manga1);
        u1.visualizarLivro(livro2);

        u2.visualizarLivro(manga2);
        u2.visualizarLivro(manga3);

        u3.visualizarLivro(livro4);
        u3.visualizarLivro(manga4);

        System.out.println("-----------");
        g1.historicoRecomendar(u1);

        System.out.println("-----------");
        g1.historicoRecomendar(u2);

        System.out.println("-----------");
        g1.historicoRecomendar(u3);
    }
}