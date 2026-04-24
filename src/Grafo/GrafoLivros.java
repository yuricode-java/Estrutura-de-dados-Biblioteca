package Grafo;

import modelo.Livro;
import modelo.Usuario;

import java.util.*;

public class GrafoLivros {
    public HashMap<Livro, Set<Livro>> livroRecomendacao;

    public GrafoLivros() {
        this.livroRecomendacao = new HashMap<>();
    }

    public void recomendarPorDistancia(Livro origem) {
        Map<Livro, Integer> distancias = calcularDistancias(origem);


        List<Map.Entry<Livro, Integer>> listaRecomendacoes = new ArrayList<>(distancias.entrySet());


        Collections.sort(listaRecomendacoes, Map.Entry.comparingByValue());

        System.out.println("\n--- Recomendações para o livro: " + origem.getTitulo() + " ---");

        boolean encontrou = false;
        for (Map.Entry<Livro, Integer> entrada : listaRecomendacoes) {
            Livro livro = entrada.getKey();
            int distancia = entrada.getValue();

            if (distancia > 0) {
                System.out.println("Distância " + distancia + ": " + livro.getTitulo());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma recomendação encontrada para este livro.");
        }
    }


    private Map<Livro, Integer> calcularDistancias(Livro origem) {
        Map<Livro, Integer> distancias = new HashMap<>();
        Queue<Livro> fila = new LinkedList<>();

        if (origem == null || !livroRecomendacao.containsKey(origem)) {
            return distancias;
        }

        distancias.put(origem, 0);
        fila.add(origem);

        while (!fila.isEmpty()) {
            Livro atual = fila.poll();
            int distanciaAtual = distancias.get(atual);

            for (Livro vizinho : livroRecomendacao.getOrDefault(atual, new HashSet<>())) {
                if (!distancias.containsKey(vizinho)) {
                    distancias.put(vizinho, distanciaAtual + 1);
                    fila.add(vizinho);
                }
            }
        }
        return distancias;
    }


    public void colocarLivro(Livro livro) {
        livroRecomendacao.putIfAbsent(livro, new HashSet<>());
    }

    public void recomendarLivro(Livro livro, Livro livroRecomendar) {
        colocarLivro(livro);
        colocarLivro(livroRecomendar);
        livroRecomendacao.get(livro).add(livroRecomendar);
        livroRecomendacao.get(livroRecomendar).add(livro);
    }

    public void historicoRecomendar(Usuario usuario) {
        System.out.println("Recomendações baseadas no histórico de " + usuario.getNome());
        for (Livro livro : usuario.getHistorico()) {
            Set<Livro> recomendacoes = livroRecomendacao.get(livro);
            if (recomendacoes != null) {
                for (Livro l : recomendacoes) {
                    System.out.println("- " + l.getTitulo());
                }
            }
        }
    }
}