package algoritmos;

import estrutura.No;
import modelo.Livro;

public class DFS {
    public static Livro percorrerArvore(No node, Livro livro) {
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
