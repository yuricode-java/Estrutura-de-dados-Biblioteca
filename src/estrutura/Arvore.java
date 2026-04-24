package estrutura;

import modelo.Livro;

public class Arvore {
    public No raiz;

    public void inserir(Livro livro) {
        raiz = inserirRecursivo(raiz, livro);
    }

    public No inserirRecursivo(No nodeAtual, Livro livro) {
        if (nodeAtual == null) {
            return new No(livro);
        }

        if (livro.anoPublicado < nodeAtual.valor.anoPublicado) {
            nodeAtual.esquerda = inserirRecursivo(nodeAtual.esquerda, livro);
        } else {
            nodeAtual.direita = inserirRecursivo(nodeAtual.direita, livro);
        }

        return nodeAtual;
    }

    public Livro verificarLado(No nodeAtual) {
        return nodeAtual.direita == null ? nodeAtual.valor : verificarLado(nodeAtual.direita);
    }
}
