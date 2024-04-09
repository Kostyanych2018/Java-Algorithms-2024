package com.task_1_3_33;

import java.util.Scanner;
import com.task_1_3_33.datastructures.*;

public class Main {
    public static <T> void main(String[] args) {
        Deque<T> deque = new Deque<>();
        //можно через ResizingArrayDeque
        Scanner scanner = new Scanner(System.in);
        String continueProgram = "да";

        while (continueProgram.equalsIgnoreCase("да")) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Добавить элемент слева");
            System.out.println("2. Добавить элемент справа");
            System.out.println("3. Удалить элемент слева");
            System.out.println("4. Удалить элемент справа");
            System.out.println("5. Показать размер дека");
            System.out.println("6. Пуст ли дек?");
            System.out.println("7. Вывести все элементы дека");
            System.out.println("8. Выход");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    addElementLeft(deque, scanner);
                    break;
                case 2:
                    addElementRight(deque, scanner);
                    break;
                case 3:
                    removeElementLeft(deque);
                    break;
                case 4:
                    removeElementRight(deque);
                    break;
                case 5:
                    printDequeSize(deque);
                    break;
                case 6:
                    checkIfDequeIsEmpty(deque);
                    break;
                case 7:
                    printDequeElements(deque);
                    break;
                case 8:
                    continueProgram = "нет";
                    break;
                default:
                    System.out.println("Некорректный выбор операции.");
            }
        }
        scanner.close();
    }

    @SuppressWarnings("unchecked")
    private static <T> void addElementLeft(Deque<T> deque, Scanner scanner) {
        System.out.println("Введите значение:");
        T value = (T) scanner.next();
        deque.pushLeft(value);
    }

    @SuppressWarnings("unchecked")
    private static <T> void addElementRight(Deque<T> deque, Scanner scanner) {
        System.out.println("Введите значение:");
        T value = (T) scanner.next();
        deque.pushRight(value);
    }

    private static <T> void removeElementLeft(Deque<T> deque) {
        if (!deque.isEmpty()) {
            System.out.println("Удаленный элемент: " + deque.popLeft());
        } else {
            System.out.println("Дек пуст.");
        }
    }

    private static <T> void removeElementRight(Deque<T> deque) {
        if (!deque.isEmpty()) {
            System.out.println("Удаленный элемент: " + deque.popRight());
        } else {
            System.out.println("Дек пуст.");
        }
    }

    private static <T> void printDequeSize(Deque<T> deque) {
        System.out.println("Размер дека: " + deque.size());
    }

    private static <T> void checkIfDequeIsEmpty(Deque<T> deque) {
        System.out.println("Дек пуст? " + deque.isEmpty());
    }

    private static <T> void printDequeElements(Deque<T> deque) {
        System.out.println("Элементы дека:");
        if (!deque.isEmpty()) {
            for (T element : deque) {
                System.out.println(element);
            }
        } else {
            System.out.println("Дек пуст");
        }
    }
}
