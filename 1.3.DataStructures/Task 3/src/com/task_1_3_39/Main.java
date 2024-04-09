package com.task_1_3_39;

import java.util.Scanner;
import com.task_1_3_39.datastructures.*;

public class Main {
    @SuppressWarnings("unchecked")
    public static <T> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер буфера:");
        int bufferSize = scanner.nextInt();
        RingBuffer<T> buffer = RingBuffer.create(bufferSize);

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1 - Добавить элемент");
            System.out.println("2 - Удалить элемент");
            System.out.println("3 - Проверить, пуст ли буфер");
            System.out.println("4 - Проверить, полон ли буфер");
            System.out.println("5 - Показать размер буфера");
            System.out.println("6 - Выход");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    if (buffer.isFull()) {
                        System.out.println("Буфер полон. Невозможно добавить элемент.");
                    } else {
                        System.out.println("Введите элемент для добавления:");
                        T element = (T) scanner.next();
                        buffer.enqueue(element);
                        System.out.println("Элемент добавлен.");
                    }
                    break;
                case 2:
                    if (buffer.isEmpty()) {
                        System.out.println("Буфер пуст. Невозможно удалить элемент.");
                    } else {
                        T removedElement = buffer.dequeue();
                        System.out.println("Удаленный элемент: " + removedElement);
                    }
                    break;
                case 3:
                    System.out.println("Буфер пуст? " + buffer.isEmpty());
                    break;
                case 4:
                    System.out.println("Буфер полон? " + buffer.isFull());
                    break;
                case 5:
                    System.out.println("Размер буфера: " + buffer.size());
                    break;
                case 6:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}

