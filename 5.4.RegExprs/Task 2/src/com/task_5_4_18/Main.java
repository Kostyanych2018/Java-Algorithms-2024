package com.task_5_4_18;

public class Main {
    public static void main(String[] args) {
        String regexp = "(AB)+";
        NFA nfa = new NFA(regexp);
        String txt1 = "AB";
        String txt2 = "";
        boolean matches1 = nfa.recognizes(txt1);
        boolean matches2=nfa.recognizes(txt2);
        System.out.println("Does the text '" + txt1 + "' match the reg expr " + regexp + "? : " + matches1);
        System.out.println("Does the text '" + txt2 + "' match the reg expr " + regexp + "? : " + matches2);
    }
}