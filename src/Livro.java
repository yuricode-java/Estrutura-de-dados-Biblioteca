import java.util.LinkedList;
import java.util.Queue;

public class Livro {
    //Livro → representa os dados (título, autor, ano)
    String titulo;
    String autor;
    boolean Disponivel;
    int anoPublicado;
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

    public void DevolverLivro(Usuario usuario){
        if(!filaDeEspera.isEmpty()){
            Usuario proximo = filaDeEspera.poll();
            proximo.setLivro(this);
        }else {
            this.Disponivel = true;
        }
    }

    public void isDisponivel(Usuario usuario) {
        if (Disponivel == true) {
            System.out.println("Disponivel");
        } else System.out.println("Ja foi emprestado");
    }

    public void verFila(){
        if(!filaDeEspera.isEmpty()){
            for(Usuario f:filaDeEspera){
                System.out.println(f.getNome());
            }
        }else System.out.println("esta vazia");
    }


    public void setDisponivel(boolean disponivel) {
        Disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Título: " + this.titulo + "\n" +
                "Autor: " + this.autor + "\n" +
                "Ano Publicado: " + this.anoPublicado + "\n";
    }
}
