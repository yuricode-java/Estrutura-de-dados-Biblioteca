package algoritmos;

import estrutura.no;
import modelo.Livro;

class DFS {
    public static Livro percorrerArvore(no node, Livro livro) {
        if (node == null) {
            return null;
        }

        if (node.valor.equals(livro)) {
            return node.valor;
        }

        Livro resultadoE = percorrerArvore(node.esquerda, livro);
        if (resultadoE != null) {
            return resultadoE;
        }
        Livro resultadoD = percorrerArvore(node.direita, livro);
        if (resultadoD != null) {
            return resultadoD;
        }
        return null;
    }
}
