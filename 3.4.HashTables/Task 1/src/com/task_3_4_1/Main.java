package com.task_3_4_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String keys = "EASYQUTION";
        int M = 5;

        @SuppressWarnings("unchecked")
        LinkedList<Character>[] table = new LinkedList[M];

        for (int i = 0; i < M; i++) {
            table[i] = new LinkedList<>();
        }

        for (char c : keys.toCharArray()) {
            int index = hash(c, M);
            table[index].add(c);
        }

        for (int i = 0; i < M; i++) {
            System.out.println("Список " + i + ": ");
            for (char key : table[i]) {
                System.out.print(key + " ");
            }
            System.out.println();
        }
    }

    public static int hash(char key, int M) {
        return (11 * (key - 'A' + 1)) % M;
    }
}