package com.task_2_5_19;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // пример как в книге
        int[] a1 = { 0, 3, 1, 6, 2, 5, 4 };
        int[] a2 = { 1, 0, 3, 6, 4, 2, 5 };

        long kendallTauDist1 = KendallTau.kendallTau(a1, a2);

        String s = String.format("Расстояние Кенделла: %d", kendallTauDist1);
        System.out.println(s);
        Scanner scanner = new Scanner(System.in);

        int[] a3 = getPermutation(scanner, "Перестановка A1:");
        int[] a4 = getPermutation(scanner, "Перестановка A2:");

        long kendallTauDist2 = KendallTau.kendallTau(a3, a4);
        System.out.println(String.format("Расстояние Кенделла: %d", kendallTauDist2));
    }

    private static int[] getPermutation(Scanner scanner, String name) {

        System.out.println(name);
        System.out.println("Введите элементы через пробел(перестановки должны быть одинаковой длины): ");
        String input = scanner.nextLine();
        String[] elements = input.split(" ");
        int[] permutation = new int[elements.length];
        
        for (int i = 0; i < elements.length; i++) {
            permutation[i] = Integer.parseInt(elements[i]);
        }

        return permutation;
    }
}