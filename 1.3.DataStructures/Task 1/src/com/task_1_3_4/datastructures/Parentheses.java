package com.task_1_3_4.datastructures;

public class Parentheses {

    private Parentheses(){}

    public static boolean isBalanced(String s, Stack<Character> stack) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && (stack.isEmpty() || stack.pop() != '(')){
                    return false;
            } else if (c == ']' &&  (stack.isEmpty() || stack.pop() != '[')) {
                    return false;
            } else if (c == '}' &&  (stack.isEmpty() || stack.pop() != '{')) {
                    return false;
                
            }
        }
        return stack.isEmpty();
    }
}