import java.util.LinkedList;

public class Biblioteca {
    // Biblioteca → onde você gerencia a lista (LinkedList)
    // Testeg
    public static void main(String[] args) {
        LinkedList<Livro> Livros = new LinkedList<>();

        Livros.add(new Livro("Abc","Alfabeto",2000));

        for(Livro l:Livros){
            System.out.println(l);
        }
    }

}
