package com.task_3_4_36;

import java.util.*;
import com.task_3_4_36.datastructures.*;
import com.task_3_4_36.datastructures.SeparateChainingHashST;

public class Main {
    public static void main(String[] args) {
        int[] N_values = new int[] { (int) Math.pow(10, 3), (int) Math.pow(10, 4), (int) Math.pow(10, 5),
                (int) Math.pow(10, 6) };
        for (int N : N_values) {
            SeparateChainingHashST<Integer, Integer> st = new SeparateChainingHashST<>(N / 100);
            Random rand = new Random();
            for (int i = 0; i < N; i++) {
                st.put(rand.nextInt(), i);
            }

            int minListLength = Integer.MAX_VALUE;
            int maxListLength = Integer.MIN_VALUE;
            for (SequentialSearchST<Integer, Integer> list : st.getSt()) {
                int listSize = list.size();
                if (listSize < minListLength) {
                    minListLength = listSize;
                }

                if (listSize > maxListLength) {
                    maxListLength = listSize;
                }
            }
            System.out.println("Для N = " + N + "; ");
            System.out.println("Длина самого короткого списка: " + minListLength);
            System.out.println("Длина самого длинного списка: " + maxListLength);
        }
    }
}