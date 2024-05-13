package com.task_5_2_10;

import com.task_5_2_10.trees.*;

public class Main {
    public static void main(String[] args) {
        TrieST<Integer> trie = new TrieST<>();
        TST<Integer> tst = new TST<>();

        String[] keys = { "she", "sells", "sea", "shells", "by", "the", "sea", "shore" };
        for (int i = 0; i < keys.length; i++) {
            trie.put(keys[i], i);
            tst.put(keys[i], i);
        }

        System.out.println("TrieST size: " + trie.size()); 
        System.out.println("TST size: " + tst.size());

        trie.put("bye", 8); 
        tst.put("bye", 8); 

        System.out.println("TrieSt size after update: " + trie.size());
        System.out.println("TST size after update: " + tst.size());

    }
}