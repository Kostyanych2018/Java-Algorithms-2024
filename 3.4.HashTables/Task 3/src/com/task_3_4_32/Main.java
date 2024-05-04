package com.task_3_4_32;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        do {
            System.out.println("Введите степень N(до 15): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число. Пожалуйста, введите целое число.");
                scanner.next();
            }
            N = scanner.nextInt();
            if (N > 15) {
                System.out.println("Введенное значение больше 15. Пожалуйста, введите число до 15.");
            } else if (N < 0) {
                System.out.println("Введенное значение должно быть положительным. Пожалуйста, введите положительное число.");
            } else {
                generateStrings(N);
            }
        } while (N > 15 || N < 0);
        scanner.close();
    }

    private static void generateStrings(int N) {
        String[] stringSet = new String[] { "Aa","BB"};
        generateStrings(stringSet, "", N);
    }

    public static void generateStrings(String[] stringSet, String prefix, int N) {
        if (N == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < stringSet.length; i++) {
            String newPrefix = prefix + stringSet[i];
            generateStrings(stringSet, newPrefix, N - 1);
        }
    }
}
