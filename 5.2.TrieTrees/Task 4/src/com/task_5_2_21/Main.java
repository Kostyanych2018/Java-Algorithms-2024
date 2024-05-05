package com.task_5_2_21;

import com.task_5_2_21.trees.*;
import java.util.Scanner;
import java.util.ArrayList; // Импорт для использования ArrayList

public class Main {
    public static void main(String[] args) {
        TSTClient client = new TSTClient();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> wordList = new ArrayList<>(); // Список для хранения слов

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить слово");
            System.out.println("2. Найти строки, содержащие подстроку");
            System.out.println("3. Показать список всех слов");
            System.out.println("4. Выход");
            System.out.print("Ваш выбор: ");
            String command = scanner.nextLine();

            if (command.equals("1")) {
                System.out.print("Введите слово для добавления: ");
                String word = scanner.nextLine();
                client.addWord(word);
                wordList.add(word); // Добавление слова в список
                System.out.println("Слово '" + word + "' и его суффиксы были добавлены.");
            } else if (command.equals("2")) {
                System.out.print("Введите подстроку для поиска: ");
                String s = scanner.nextLine();
                Iterable<String> results = client.keysContains(s);
                System.out.println("Строки, содержащие '" + s + "':");
                for (String res : results) {
                    System.out.println(res);
                }
            } else if (command.equals("3")) {
                System.out.println("Список всех добавленных слов:");
                for (String word : wordList) {
                    System.out.println(word);
                }
            } else if (command.equals("4")) {
                break;
            } else {
                System.out.println("Неизвестная команда. Пожалуйста, выберите 1, 2, 3 или 4.");
            }
        }

        scanner.close();
    }
}
