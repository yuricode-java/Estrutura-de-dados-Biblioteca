package Grafo;

import modelo.Livro;
import modelo.Usuario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GrafoLivros {
    private HashMap<Livro, Set<Livro>> livroRecomendacao;

    public GrafoLivros() {
        this.livroRecomendacao = new HashMap();
    }


    public void colocarLivro(Livro livro) {
        Set<Livro> livros = livroRecomendacao.get(livro);
        if (livros == null) {
            Set<Livro> livros1 = new HashSet<>();
            livroRecomendacao.put(livro, livros1);
        }
    }

    public void recomendarLivro(Livro livro, Livro livroRecomendar) {
        if (livroRecomendacao.containsKey(livro) == false) {
            Set<Livro> livros1 = new HashSet<>();
            livroRecomendacao.put(livro, livros1);
        }
        if (!livroRecomendacao.containsKey(livroRecomendar)) {
            Set<Livro> livros1 = new HashSet<>();
            livroRecomendacao.put(livroRecomendar, livros1);
        }
        if (livroRecomendacao.containsKey(livro)) {
            livroRecomendacao.get(livro).add(livroRecomendar);
        }
    }

    public void historicoRecomendar(Usuario usuario) {

        System.out.println("Recomendações para " + usuario.getNome());

        for (Livro livro : usuario.getHistorico()) {

            Set<Livro> recomendacoes = livroRecomendacao.get(livro);

            if (recomendacoes != null) {

                for (Livro l : recomendacoes) {
                    System.out.println(l.getTitulo());
                }
            }
        }
    }

    public void imprimir(Livro livro) {
        System.out.println("recomendação de " + livro.getTitulo());
        for (Livro l : livroRecomendacao.get(livro)) {
            System.out.println(l.titulo);
        }
    }
}
