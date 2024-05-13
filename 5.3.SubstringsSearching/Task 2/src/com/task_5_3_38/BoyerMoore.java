package com.task_5_3_38;

import java.util.*;

public class BoyerMoore {
    private int[] right;
    private String pat;
    private int comparisons;

    BoyerMoore(String pat) {
        // вычисляем таблицу сдвигов
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < M; j++) {
            right[pat.charAt(j)] = j;// самая правая позиция для символов
        }
    }

    public int search(String txt) {
        comparisons = 0;
        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                comparisons++;
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1)
                        skip = 1;
                    break;
                }
            }
            if (skip == 0)
                return i;// нашли
        }
        return N;// не нашли
    }

    public int getComparisons() {
        return comparisons;
    }

    public static void main(String[] args) {
        System.out.println("Введите три целых числа: M, N и T.");
        System.out.println("M - длина образца, который будет сгенерирован случайным образом.");
        int M = Integer.parseInt(args[0]);
        System.out.println("N - длина текста, который будет сгенерирован случайным образом.");
        int N = Integer.parseInt(args[1]);
        System.out.println("T - количество раз, которое будет выполнеен эксперимент.");
        int T = Integer.parseInt(args[2]);
        Random random = new Random();
        long totalComparisons = 0;

        for (int i = 0; i < T; i++) {
            StringBuilder patBuilder = new StringBuilder(M);
            StringBuilder txtBuilder = new StringBuilder(N);
            for (int j = 0; j < M; j++) {
                patBuilder.append((char) ('a' + random.nextInt(26)));
            }
            for (int j = 0; j < N; j++) {
                txtBuilder.append((char) ('a' + random.nextInt(26)));
            }

            String pat = patBuilder.toString();
            String txt = txtBuilder.toString();

            BoyerMoore bm = new BoyerMoore(pat);
            bm.search(txt);
            totalComparisons += bm.getComparisons();
            System.out.println("Образец: " + pat);
            System.out.println("Текст:" + txt);
            System.out.println("Количество сравнений: " + bm.getComparisons());
        }
        System.out.println("Среднее количество сравнений: " + (double) totalComparisons / T);
    }
}