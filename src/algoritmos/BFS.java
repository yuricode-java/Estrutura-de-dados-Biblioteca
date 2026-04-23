package algoritmos;

import estrutura.no;
import modelo.Livro;

import java.util.LinkedList;
import java.util.Queue;

class BFS {
    public static Livro percorrerArvore(no node, Livro livro) {
        Queue<no> raizFila = new LinkedList<>();

        if (node == null) {
            return null;
        }

        raizFila.add(node);

        while (!raizFila.isEmpty()) {
            no atual = raizFila.poll();
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
