package com.task_5_2_9;

import com.task_5_2_9.trees.*;

public class Main {
    public static void main(String[] args) {
        TrieST<Integer> trieST = new TrieST<>();
        trieST.put("apple", 1);
        trieST.put("banana", 2);
        trieST.put("cherry", 3);
        trieST.put("app", 4);
        trieST.put("ban", 5);

        System.out.println("TrieST size: " + trieST.size());
        System.out.println("Value of 'apple': " + trieST.get("apple"));

        System.out.println("Keys in TrieST: ");
        for (String key : trieST.keys()) {
            System.out.println(key);
        }
        System.out.println("Keys with prefix 'ap' in TrieST: ");
        for (String key : trieST.keysWithPrefix("ap")) {
            System.out.println(key);
        }


        System.out.println("Keys that match 'a..' in TrieST: ");
        for (String key : trieST.keysThatMatch("a..")) {
            System.out.println(key);
        }
        System.out.println("Longest prefix of 'bananas' in TrieST: " + trieST.longetsPrefixOf("bananas"));

        TST<Integer> tst = new TST<>();
        tst.put("apple", 1);
        tst.put("banana", 2);
        tst.put("cherry", 3);
        tst.put("app", 4);
        tst.put("ban", 5);
        
        System.out.println("Value of 'apple': " + tst.get("apple"));
        System.out.println("Keys in TST: ");
        for (String key : tst.keys()) {
            System.out.println(key);
        }

        System.out.println("Keys with prefix 'ban' in TST: ");
        for(String key:tst.keysWithPrefix("ban")){
            System.out.println(key);
        }

        System.out.println("Keys that match 'a..' in TST: ");
        for (String key : tst.keysThatMatch("a..")) {
            System.out.println(key);
        }
        System.out.println("Longest prefix of 'bananas' in TST: " + tst.longestPrefixOf("bananas"));
    }
}