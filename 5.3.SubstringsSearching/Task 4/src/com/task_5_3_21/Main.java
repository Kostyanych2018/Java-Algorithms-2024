package com.task_5_3_21;

public class Main {
    public static void main(String[] args) {
        String txt = "abcabcabc";
        String pat = "abc?bca";
        RabinKarp rk = new RabinKarp(pat);
        int offset = rk.search(txt);
        if (offset == txt.length()) {
            System.out.println("Образец не найден");
        } else {
            System.out.println("Образец найден на позиции: " + offset);
        }
    }
}