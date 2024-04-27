package com.task_3_3_31;

import com.task_3_3_31.datastructures.RedBlackBST;
public class Main {
    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> bst = new RedBlackBST<>();
       
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(5, 5);
        bst.put(4, 5);
        bst.draw();
    }
}
