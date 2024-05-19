package com.task_5_4_17;

public class Main {

    public static void main(String[] args) {
        String regexpr = "A.B";
        String txt = "AGB";
        NFA nfa = new NFA(regexpr);
        boolean matches = nfa.recognizes(txt);
        System.out.println(matches);
    }
}
