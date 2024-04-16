package com.task_3_2_25;

import com.task_3_2_25.datastructures.BalancedBST;

public class Main {
    public static void main(String[] args) {
        BalancedBST<Integer, Integer> bst = new BalancedBST<>();
        Integer[] keys = { 3, 2, 5, 6, 4, 2, 3, 10 };
        bst.insertInOrder(keys);
        for (Integer key : bst.keys()) {
            bst.put(key, key + 2);
            System.out.println(key + ": " + bst.get(key));
        }
    }
}