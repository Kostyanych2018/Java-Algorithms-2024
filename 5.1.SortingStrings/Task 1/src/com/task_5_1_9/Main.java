package com.task_5_1_9;

import com.task_5_1_9.sorts.*;

public class Main {
    public static void main(String[] args) {

        String[] a = { "abc", "abcd", "ab", "a", "abcde" };

        System.out.println("Массив до сортировки: ");
        for (String s : a) {
            System.out.print(s + " ");
        }
        System.out.println();
        
        LSDSort.sort(a);

        System.out.println("Массив после сортировки: ");
        for (String s : a) {
            System.out.print(s + " ");
        }
    }
}