package com.task_5_4_16;

public class Main {
    public static void main(String[] args) {
        NFA nfa = new NFA("(a|b|c)*");
        System.out.println(nfa.recognizes("abc")); 
        System.out.println(nfa.recognizes("aaa")); 
        System.out.println(nfa.recognizes("bbb")); 
        System.out.println(nfa.recognizes("ccc")); 
        System.out.println(nfa.recognizes("ddd")); 
    }
    
}