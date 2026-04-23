import Grafo.GrafoLivros;
import modelo.Livro;
import modelo.Usuario;
import modelo.arvore;

import java.util.Random;


class GeradorDeNomesDeLivros {
    private static final int TAMANHO_MAXIMO_DO_NOME = 20;
    private static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";

    public static String[] gerarNomes(int numeroDeLivros) {
        Random random = new Random();
        String[] nomesDeLivros = new String[numeroDeLivros];

        for (int i = 0; i < numeroDeLivros; i++) {
            nomesDeLivros[i] = gerarNomeAleatorio(random);
        }

        // Apenas para fins de teste mostraremos os 10 primeiros nomes
        for (int i = 0; i < 10; i++) {
            System.out.println(nomesDeLivros[i]);
        }

        return nomesDeLivros;
    }

    private static String gerarNomeAleatorio(Random random) {
        int tamanhoDoNome = random.nextInt(TAMANHO_MAXIMO_DO_NOME) + 1;
        StringBuilder sb = new StringBuilder(tamanhoDoNome);

        for (int i = 0; i < tamanhoDoNome; i++) {
            sb.append(ALFABETO.charAt(random.nextInt(ALFABETO.length())));
        }

        return sb.toString();
    }
}

class BubbleSort {

    public static String[] ordenar(String[] oldArr) {

        String[] arr = oldArr.clone();

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j].compareTo(arr[j + 1]) > 0) {

                    String temp = arr[j];

                    arr[j] = arr[j + 1];

                    arr[j + 1] = temp;

                }

            }

        }
        return arr;
    }
}

class MergeSort {

    public static String[] ordenar(String[] oldArr) {

        String[] arr = oldArr.clone();

        if (arr.length < 2) {

            return arr;

        }


        int meio = arr.length / 2;

        String[] esquerda = new String[meio];

        String[] direita = new String[arr.length - meio];


        System.arraycopy(arr, 0, esquerda, 0, meio);

        System.arraycopy(arr, meio, direita, 0, arr.length - meio);


        ordenar(esquerda);

        ordenar(direita);


        merge(arr, esquerda, direita);

        return arr;

    }


    private static void merge(String[] arr, String[] esquerda, String[] direita) {

        int i = 0, j = 0, k = 0;

        while (i < esquerda.length && j < direita.length) {

            if (esquerda[i].compareTo(direita[j]) <= 0) {

                arr[k++] = esquerda[i++];

            } else {

                arr[k++] = direita[j++];

            }

        }

        while (i < esquerda.length) {

            arr[k++] = esquerda[i++];

        }

        while (j < direita.length) {

            arr[k++] = direita[j++];

        }

    }

}

public class Main {
    public static void main(String[] args) {

        Livro livro1 = new Livro("1984", "George Orwell", 1949);
        Livro livro2 = new Livro("Jojolion", "Hirohiko Araki", 2011);
        Livro livro3 = new Livro("O Hobbit", "J.R.R. Tolkien", 1937);
        Livro livro4 = new Livro("Dom Casmurro", "Machado de Assis", 1899);

        Livro manga1 = new Livro("One Piece", "Eiichiro Oda", 1997);
        Livro manga2 = new Livro("Naruto", "Masashi Kishimoto", 1999);
        Livro manga3 = new Livro("Attack on Titan", "Hajime Isayama", 2009);
        Livro manga4 = new Livro("Death Note", "Tsugumi Ohba", 2003);

        Usuario u1 = new Usuario("Ana");
        Usuario u2 = new Usuario("Bruno");
        Usuario u3 = new Usuario("Carlos");

        GrafoLivros g1 = new GrafoLivros();

        g1.recomendarLivro(livro1, livro3);
        g1.recomendarLivro(livro1, manga4);

        g1.recomendarLivro(livro2, manga1);
        g1.recomendarLivro(livro2, manga3);

        g1.recomendarLivro(manga1, manga2);
        g1.recomendarLivro(manga2, manga3);
        g1.recomendarLivro(manga3, manga4);
        g1.recomendarLivro(manga4, livro1);

        u1.visualizarLivro(livro1);
        u1.visualizarLivro(manga1);
        u1.visualizarLivro(livro2);

        u2.visualizarLivro(manga2);
        u2.visualizarLivro(manga3);

        u3.visualizarLivro(livro4);
        u3.visualizarLivro(manga4);

        System.out.println("-----------");
        g1.historicoRecomendar(u1);

        System.out.println("-----------");
        g1.historicoRecomendar(u2);

        System.out.println("-----------");
        g1.historicoRecomendar(u3);

        arvore arv = new arvore();

        arv.inserir(livro1);
        arv.inserir(livro2);
        arv.inserir(livro3);
        arv.inserir(livro4);

        arv.inserir(manga1);
        arv.inserir(manga2);
        arv.inserir(manga3);
        arv.inserir(manga4);

        System.out.println("----------- ARVORE -----------");
        livro3.imprimir(arv.raiz);



    }
}