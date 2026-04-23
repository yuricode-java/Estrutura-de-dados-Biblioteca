package estrutura;

import modelo.Livro;

class No {
    Livro valor;
    No esquerda;
    No direita;

    public No(Livro valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}
