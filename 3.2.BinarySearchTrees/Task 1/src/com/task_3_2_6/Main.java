package com.task_3_2_6;

import com.task_3_2_6.datastructures.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/*возможно не все учтено но общая суть реализована)) просто стараться везде вводить числа
 в этом случае целочиесленное дерево*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BST<Integer, Integer> bst = new BST<>();
        while (true) {
            System.out.println("-------------------------------------------------");
            System.out.println("1. Вставить ключ-значение");
            System.out.println("2. Получить значение по ключу");
            System.out.println("3. Найти минимальный ключ");
            System.out.println("4. Найти максимальный ключ");
            System.out.println("5. Найти нижнюю опору для заданного ключа");
            System.out.println("6. Найти верхнюю опору для заданного ключа");
            System.out.println("7. Выбрать ключ по порядковому номеру");
            System.out.println("8. Найти порядковый номер ключа");
            System.out.println("9. Удалить минимальный ключ");
            System.out.println("10. Удалить максимальный ключ");
            System.out.println("11. Удалить ключ");
            System.out.println("12. Вывести все ключи в древовидном представлении");
            System.out.println("13. Найти все ключи в заданном диапазоне");
            System.out.println("14. Определить высоту дерева рекурсивно");
            System.out.println("15. Определить высоту дерева нерекурсивно");
            System.out.println("16. Выйти");
            System.out.println("-------------------------------------------------");
            System.out.print("Введите номер операции: ");

            int operationNum;
            
            try {
                operationNum = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат ввода. Пожалуйста, введите целое число.");
                scan.nextLine();
                continue;
            }

            switch (operationNum) {
                case 1:
                    System.out.print("Введите ключ (целое число): ");
                    if (scan.hasNextInt()) {
                    int key = scan.nextInt();
                    System.out.print("Введите значение (целое число): ");
                    int value = scan.nextInt();
                    scan.nextLine();
                    bst.put(key, value);
                    System.out.println("Ключ-значение вставлено.");}else{
                        System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                        scan.next();
                    }
                    break;
                case 2:
                    System.out.print("Введите ключ (целое число): ");
                    if (scan.hasNextInt()) {
                    int key = scan.nextInt();
                    Integer val = bst.get(key);
                    if (val != null) {
                        System.out.println("Значение для ключа: " + val);
                    } else {
                        System.out.println("Ключ не найден.");
                    }}else{
                        System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                        scan.next();
                    }
                    break;
                case 3:
                    if (!bst.isEmpty()) {
                        System.out.println("Минимальный ключ: " + bst.min());
                    } else {
                        System.out.println("Дерево пустое.");
                    }
                    break;
                case 4:
                    if (!bst.isEmpty()) {
                        System.out.println("Максимальный ключ: " + bst.max());
                    } else {
                        System.out.println("Дерево пустое.");
                    }
                    break;
                case 5:
                    System.out.print("Введите ключ (целое число): ");
                    if (scan.hasNextInt()) {
                        int key = scan.nextInt();
                        int floorKey = bst.floor(key);
                        if (floorKey != Integer.MIN_VALUE) {
                            System.out.println("Нижняя опора: " + floorKey);
                        } else {
                            System.out.println("Нижняя опора не найдена.");
                        }
                    } else {
                        System.out.println("Верхняя опора не найдена.");
                    }
                    break;
                case 6:
                    System.out.print("Введите ключ (целое число): ");
                    if (scan.hasNextInt()) {
                        int key = scan.nextInt();
                        int ceilingKey = bst.ceiling(key);
                        if (ceilingKey != Integer.MAX_VALUE) {
                            System.out.println("Верхняя опора: " + ceilingKey);
                        } else {
                            System.out.println("Верхняя опора не найдена.");
                        }
                    } else {
                        System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                        scan.next();
                    }
                    break;
                case 7:
                    System.out.print("Введите порядковый номер: ");
                    if (scan.hasNextInt()) {
                        int order = scan.nextInt();
                        int selectedKey = bst.select(order);
                        if (selectedKey != Integer.MIN_VALUE) {
                            System.out.println("Ключ по порядковому номеру: " + selectedKey);
                        } else {
                            System.out.println("Ключ не найден.");
                        }
                    } else {
                        System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                        scan.next();
                    }
                    break;
                case 8:
                    System.out.print("Введите ключ (целое число): ");
                    int key = scan.nextInt();
                    int rankKey = bst.rank(key);
                    System.out.println("Порядковый номер ключа: " + rankKey);
                    break;
                case 9:
                    if (bst.isEmpty()) {
                        System.out.println("Дерево пустое. Невозможно удалить минимальный ключ.");
                    } else {
                        bst.deleteMin();
                        System.out.println("Минимальный ключ удален.");
                    }
                    break;
                case 10:
                    if (bst.isEmpty()) {
                        System.out.println("Дерево пустое. Невозможно удалить максимальный ключ.");
                    } else {
                        bst.deleteMax();
                        System.out.println("Максимальный ключ удален.");
                    }
                    break;
                case 11:
                    System.out.print("Введите ключ (целое число): ");
                    if (scan.hasNextInt()) {
                         key = scan.nextInt();
                        if (bst.contains(key)) {
                            bst.delete(key);
                            System.out.println("Ключ удален.");
                        } else {
                            System.out.println("Ключ не найден.");
                        }
                    } else {
                        System.out.println("Некорректный формат ввода. Пожалуйста, введите целое число.");
                        scan.next();
                    }
                    break;
                case 12:
                    if (!bst.isEmpty()) {
                        System.out.println("Ключи в порядке:");
                        for (int nodeKey : bst.keys()) {
                            System.out.println(nodeKey);
                        }
                    } else {
                        System.out.println("Дерево пустое.");
                    }
                    break;
                case 13:
                    System.out.print("Введите нижнюю границу диапазона (целое число): ");
                    int lowerBound = scan.nextInt();
                    System.out.print("Введите верхнюю границу диапазона (целое число): ");
                    int upperBound = scan.nextInt();
                    System.out.println(" ключи в диапазоне:");
                    for (int nodeKey : bst.keys(lowerBound, upperBound)) {
                        System.out.println(nodeKey);
                    }
                    break;
                case 14:
                    int recursiveHeight = bst.recursiveHeight();
                    System.out.println("Высота (recursive): " + recursiveHeight);
                    break;
                case 15:
                    int nonrecursiveHeight = bst.nonrecursiveHeight();
                    System.out.println("Высота (nonrecursive): " + nonrecursiveHeight);
                    break;
                case 16:
                    System.out.println("Выход из программы. До свидания!");
                    scan.close();
                    return;
                default:
                    System.out.println("Неверный номер операции. Пожалуйста, введите число от 1 до 16.");
            }
        }
    }
}