
public class Livro {
    //Livro → representa os dados (título, autor, ano)
    String titulo;
    String autor;
    int anoPublicado;

    public Livro(String titulo,String autor,int ano){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicado = ano;
    }
    @Override
    public String toString(){
        return "Título: " + this.titulo + "\n" +
                "Autor: " + this.autor + "\n" +
                "Ano Publicado: " + this.anoPublicado + "\n";
    }
}
