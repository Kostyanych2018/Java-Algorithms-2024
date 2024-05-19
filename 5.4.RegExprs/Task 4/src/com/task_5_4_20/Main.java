package com.task_5_4_20;

public class Main {
    public static void main(String[] args) {
        String regexp = "[a-e]*";
        NFA nfa = new NFA(regexp);

        String txt1 = "acdbacbdabcbae";

        System.out.println("Recognizes " + txt1 + ": " + nfa.recognizes(txt1));
    }
}