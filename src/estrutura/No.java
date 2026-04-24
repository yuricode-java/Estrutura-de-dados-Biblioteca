package estrutura;

import modelo.Livro;

public class No {
    public Livro valor;
    public No esquerda;
    public No direita;

    public No(Livro valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}
