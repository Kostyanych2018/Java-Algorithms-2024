package com.task_1_3_29;

import com.task_1_3_29.datastructures.Queue;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("unchecked")
    public static <T> void main(String[] args) {
        Queue<T> q = new Queue<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Size");
            System.out.println("4. Exit");
            System.out.println("5. Print all elements");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    System.out.print("Enter a number to enqueue: ");
                    T num = (T) scanner.next();
                    q.enqueue(num);
                    break;
                case 2:
                    if (!q.isEmpty()) {
                        System.out.println("Dequeued element: " + q.dequeue());
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 3:
                    System.out.println("Current size: " + q.size());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                case 5:
                    System.out.println("All elements in the queue:");
                    if (!q.isEmpty()) {
                        for (T i : q) {
                            System.out.print(i + " ");
                        }
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
