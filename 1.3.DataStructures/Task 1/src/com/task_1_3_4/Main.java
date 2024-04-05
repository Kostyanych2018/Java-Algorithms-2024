package com.task_1_3_4;

import java.util.logging.Logger;

import com.task_1_3_4.datastructures.*;

public class Main {
    private static final Logger l = Logger.getLogger(Main.class.getName());

    // 1.3.4 стр.157
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        if (l.isLoggable(java.util.logging.Level.INFO)) {
            String input1 = "{[()]}";
            boolean isBalanced1 = Parentheses.isBalanced(input1, stack);
            l.info(String.format("%s is Balanced? %s", input1, isBalanced1));
            String input2 = "[(])";
            boolean isBalanced2 = Parentheses.isBalanced(input2, stack);
            l.info(String.format("%s is Balanced? %s", input2, isBalanced2));

        }
    }

}
