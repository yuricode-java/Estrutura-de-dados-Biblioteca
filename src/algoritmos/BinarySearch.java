package algoritmos;

import estrutura.no;
import modelo.Livro;

class BinarySearch {
    public static void percorrerArvore(no node, Livro valor) {
        if (node == null) {
            return;
        }
        if (node.valor.anoPublicado == valor.anoPublicado) {
            System.out.print("Achou");
            return;
        }
        if (node.valor.anoPublicado < valor.anoPublicado) {
            percorrerArvore(node.direita, valor);
        } else percorrerArvore(node.esquerda, valor);
    }
}
