//2.5.16 стр.328
package com.task_2_5_16;

import java.util.*;

public class California {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClaiforniaComparator comparator = new ClaiforniaComparator();
        // пример
        String[] test = { "MIKE", "QUINCY", "OLIVER", "ROBERT", "WILLIAM" };

        Arrays.sort(test, comparator::compare);

        for (String name : test) {
            System.out.println(name);
        }

        List<String> names = new ArrayList<>();

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Ввести имя");
            System.out.println("2. Отсортировать и показать имена");
            System.out.println("3. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("1. Введите имя(все прописные): ");
                String name = scanner.nextLine();
                names.add(name);
            } else if (choice == 2) {
                String[] namesArr = names.toArray(new String[0]);
                Arrays.sort(namesArr, comparator::compare);
                System.out.println("Отсортированные имена: ");
                for (String name : namesArr) {
                    System.out.println(name + " ");
                }
            } else if (choice == 3) {
                System.out.println("Выход из программы...");
                break;
            } else {
                System.out.println("Неверный ввод");
            }
        }
        scanner.close();
    }
}