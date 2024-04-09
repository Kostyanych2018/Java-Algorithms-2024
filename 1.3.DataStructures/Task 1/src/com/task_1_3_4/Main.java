package com.task_1_3_4;

import com.task_1_3_4.datastructures.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 3) {
            System.out.println("1. Check balanced parentheses");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter a string to check balanced parentheses: ");

                        String input = scanner.nextLine();
                        if (input.isEmpty()) {
                            System.out.println("Input is empty!");
                        } else {
                            boolean isBalanced = Parentheses.isBalanced(input, stack);
                            System.out.println("Input: " + input);
                            System.out.println("Is Balanced? " + isBalanced);
                        }
                        break;
                    case 2:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid choice.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

}