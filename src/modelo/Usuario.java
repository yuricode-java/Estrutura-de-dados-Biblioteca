package modelo;

import java.util.Stack;

public class Usuario {
    private String nome;
    private Livro livroEmprestado;

    public Stack<Livro> getHistorico() {
        return historico;
    }

    private Stack<Livro> historico;

    public Usuario(String nome) {
        this.nome = nome;
        this.historico = new Stack<>();
    }

    public void visualizarLivro(Livro livro) {
        this.historico.push(livro);
        System.out.println(nome + " visualizou: " + livro.getTitulo());
    }

    public void verHistorico() {
        System.out.println("Histórico de " + nome + ":");
        if (historico.isEmpty()) {
            System.out.println("Vazio.");
            return;
        }
        for (int i = historico.size() - 1; i >= 0; i--) {
            System.out.println("- " + historico.get(i).getTitulo());
        }

    }

    public String getNome() { return nome; }
    public void setLivro(Livro livro) { this.livroEmprestado = livro; }
}