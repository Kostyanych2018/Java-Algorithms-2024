package com.task_2_5_2;

//2.5.2 стр.326
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        //пример
        List<String> words = new ArrayList<>(Arrays.asList("ковка", "парковка", "пар", "электро", "воз", "электровоз"));

        // сортируем для бинарного поиска
        CompositeWords.insertionSort(words);

        for (String s : words) {
            if (CompositeWords.isComposite(s, words)) {
                System.out.println(s + " ");
            }
        }
        System.out.println();
        words = new ArrayList<>();

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Ввести слова");
            System.out.println("2. Выход");

            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                System.out.println("Введите слова, разделенные пробелами:");
                String input = scanner.nextLine();
                words.addAll(Arrays.asList(input.split(" ")));

                CompositeWords.insertionSort(words);

                for (String s : words) {
                    if (CompositeWords.isComposite(s, words)) {
                        System.out.println(s + " ");
                    }
                }
            } else if ("2".equals(choice)) {
                System.out.println("Выход из программы...");
                break;
            } else {
                System.out.println("Неверный выбор. Пожалуйста, введите 1 или 2.");
            }
        }
        scanner.close();
    }
}