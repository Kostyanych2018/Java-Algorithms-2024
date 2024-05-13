package com.task_5_1_20;

import java.util.*;

public class Main {

    private static Random random = new Random();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        int W;
        do {
            System.out.println("Введите количество слов (положительное целое число): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число. Попробуйте еще раз.");
                scanner.next();
            }
            N = scanner.nextInt();
        } while (N <= 0);

        do {
            System.out.println("Введите количество букв в каждом слове (целое положительное число):");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число. Попробуйте еще раз:");
                scanner.next();
            }
            W = scanner.nextInt();
        } while (W <= 0);

        scanner.close();
        
        String[] words = randomFixedLengthWords(N, W);
        for(String word:words){
            System.out.println(word);
        }
    }

    public static String[] randomFixedLengthWords(int N, int W) {
        String[] words = new String[N];
       
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < N; i++) {
            StringBuilder word = new StringBuilder(W);
            for (int j = 0; j < W; j++) {
                word.append(alphabet.charAt(random.nextInt(alphabet.length())));
            }
            words[i] = word.toString();
        }
        return words;
    }
}