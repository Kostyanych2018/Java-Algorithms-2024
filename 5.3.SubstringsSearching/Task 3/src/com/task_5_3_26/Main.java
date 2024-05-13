package com.task_5_3_26;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = " ", s2 = " ";

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Введите первую строку");
            System.out.println("2. Введите вторую строку");
            System.out.println("3. Проверить, является ли одна строка циклической перестановкой другой");
            System.out.println("4. Выход");
            System.out.print("Введите ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите первую строку: ");
                    s1 = scanner.nextLine();
                    System.out.println("Вы ввели: " + s1);
                    break;
                case 2:
                    System.out.print("Введите вторую строку: ");
                    s2 = scanner.nextLine();
                    System.out.println("Вы ввели: " + s2);
                    break;
                case 3:
                    if (s1.isEmpty() || s2.isEmpty()) {
                        System.out.println("Обе строки должны быть введены перед проверкой.");
                    } else {
                        System.out.println("Результат проверки: " + isCyclicPermutation(s1, s2));
                    }
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, введите число от 1 до 4.");
                    break;
            }
        }
    }

    public static boolean isCyclicPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return sortString(s1).equals(sortString(s2));
    }

    public static String sortString(String s) {
        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }
}
