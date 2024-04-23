package com.task_3_2_36;

import com.task_3_2_36.datastructures.*;

public class Main {
    public static void main(String[] args) {

        BST<Integer, String> bst = new BST<>();
        
        bst.put(7, "seven");
        bst.put(3, "three");
        bst.put(9, "nine");
        bst.put(1, "one");
        bst.put(4, "four");
        bst.put(8, "eight");
        bst.put(10, "ten");
        

        Iterable<Integer> keys =bst.keys();
        System.out.println("Non-recursive keys of BST: ");
        for(Integer key:keys){
            System.out.print(key+" ");
        }
    }
}