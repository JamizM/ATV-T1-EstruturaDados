package src;

import java.util.Date;
import java.util.Random;

public class Ordenacao {
    public static void main(String[] args) {
        final Random random = new Random();

        final int[] tamanhos = {800_000, 1_000_000, 1_200_000, 1_400_000};
        final int numIteracoes = 20;

        for (final int tamanho : tamanhos) { //for Each
            System.out.println("\nTestando para tamanho: " + tamanho);

            long tempoTotalBubble = 0;
            long tempoTotalInsertion = 0;
            long tempoTotalSelection = 0;

            long comparacoesTotalBubble = 0;
            long comparacoesTotalInsertion = 0;
            long comparacoesTotalSelection = 0;

            for (int i = 0; i < numIteracoes; i++) {
                final MeuVetor vetor = new MeuVetor(tamanho);
                for (int j = 0; j < tamanho; j++) {
                    vetor.adiciona(random.nextDouble() * tamanho);
                }

                MeuVetor vetorBubble = copiarVetor(vetor);
                MeuVetor vetorInsertion = copiarVetor(vetor);
                MeuVetor vetorSelection = copiarVetor(vetor);

                // Bubble Sort
                long inicio = new Date().getTime();
                comparacoesTotalBubble += vetorBubble.bubbleSort();
                long fim = new Date().getTime();
                tempoTotalBubble += (fim - inicio);

                // Insertion Sort
                inicio = new Date().getTime();
                comparacoesTotalInsertion += vetorInsertion.insertionSort();
                fim = new Date().getTime();
                tempoTotalInsertion += (fim - inicio);

                // Selection Sort
                inicio = new Date().getTime();
                comparacoesTotalSelection += vetorSelection.selectionSort();
                fim = new Date().getTime();
                tempoTotalSelection += (fim - inicio);

                
                System.out.println("Iterações dos métodos " + (i + 1) + " de " + numIteracoes);
            }

            // tempo médio
            System.out.println("bubble, Tempo médio: " + (tempoTotalBubble / numIteracoes) + " ms");
            System.out.println("insertion, Tempo médio: " + (tempoTotalInsertion / numIteracoes)+ " ms");
            System.out.println("selection, Tempo médio: " + (tempoTotalSelection / numIteracoes)+ " ms");
            
            // comparações
            System.out.println("Comparações bubble " + (comparacoesTotalBubble / numIteracoes));
            System.out.println("Comparações insertion" + (comparacoesTotalInsertion / numIteracoes));
            System.out.println("Comparações selection" + (comparacoesTotalSelection / numIteracoes));
        }
    }

    private static MeuVetor copiarVetor(final MeuVetor original) {
        final MeuVetor novo = new MeuVetor(original.getUltimaPos() + 1);
        final double[] originalArray = original.getV();
        for (int i = 0; i <= original.getUltimaPos(); i++) {
            novo.adiciona(originalArray[i]);
        }
        return novo;
    }
}