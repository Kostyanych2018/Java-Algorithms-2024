package com.task_5_3_8;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "abcabcabcabcabc";
        String pattern = "abc";

        KMP kmp = new KMP(pattern);

        int count = kmp.count(text);
        System.out.println("Count: " + count);

        List<Integer> positions = kmp.searchAll(text);
        System.out.println("Positions: " + positions);
    }
}