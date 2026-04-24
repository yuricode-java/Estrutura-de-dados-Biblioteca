package modelo;

import estrutura.No;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;


public class Livro {
    String titulo;
    String autor;
    boolean Disponivel;
    public int anoPublicado;
    Queue<Usuario> filaDeEspera;


    public String getTitulo() {
        return titulo;
    }

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicado = ano;
        this.Disponivel = true;
        filaDeEspera = new LinkedList<>();
    }

    public void SolicitarLivro(Usuario usuario) {
        if (this.Disponivel == true) {
            usuario.setLivro(this);
            this.Disponivel = false;
        } else {
            System.out.println("não esta disponivel");
            filaDeEspera.add(usuario);
        }
    }

    public void DevolverLivro(Usuario usuario) {
        if (!filaDeEspera.isEmpty()) {
            Usuario proximo = filaDeEspera.poll();
            proximo.setLivro(this);
        } else {
            this.Disponivel = true;
        }
    }

    public void isDisponivel(Usuario usuario) {
        if (this.Disponivel) {
            System.out.println("Disponivel");
        } else System.out.println("Ja foi emprestado");
    }

    public void verFila() {
        if (!filaDeEspera.isEmpty()) {
            for (Usuario f : filaDeEspera) {
                System.out.println(f.getNome());
            }
        } else System.out.println("esta vazia");
    }


    public void setDisponivel(boolean disponivel) {
        Disponivel = disponivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;

        return anoPublicado == livro.anoPublicado &&
                Objects.equals(titulo, livro.titulo) &&
                Objects.equals(autor, livro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, anoPublicado);
    }

    @Override
    public String toString() {
        return "Título: " + this.titulo + "\n" +
                "Autor: " + this.autor + "\n" +
                "Ano Publicado: " + this.anoPublicado + "\n";
    }

    public void imprimir(No nodeAtual) {
        if (nodeAtual != null) {
            imprimir(nodeAtual.esquerda);
            System.out.println(nodeAtual.valor);
            imprimir(nodeAtual.direita);
        }
    }
}
