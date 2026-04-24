package algoritmos;

import estrutura.No;
import modelo.Livro;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static Livro percorrerArvore(No node, Livro livro) {
        Queue<No> raizFila = new LinkedList<>();

        if (node == null) {
            return null;
        }

        raizFila.add(node);

        while (!raizFila.isEmpty()) {
            No atual = raizFila.poll();
            if (atual.valor.equals(livro)) {
                return atual.valor;
            }
            if (atual.esquerda != null) {
                raizFila.add(atual.esquerda);
            }
            if (atual.direita != null) {
                raizFila.add(atual.direita);
            }
        }
        return null;
    }
}
