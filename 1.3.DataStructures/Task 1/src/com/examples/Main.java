package com.examples;
import com.examples.datastructures.*;

import java.util.logging.Logger;
public class Main {
    private static final Logger l = Logger.getLogger(Main.class.getName());
    //1.3.4 стр.157
    public static void main(String[] args) {
            Stack<Character> stack = new Stack<Character>();
            String input1 = "{[()]}";
            l.info(input1 +" is Balanced? "+ Parentheses.isBalanaced(input1, stack));
            String input2 = "[(])";
            l.info(input2+" is Balanced? "+Parentheses.isBalanaced(input2, stack));
    }
}