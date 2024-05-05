package com.task_5_2_14;

import com.task_5_2_14.trees.*;

public class Main {
    public static void main(String[] args) {
        TST<Void> tst=new TST<>();
        String input = "cgcgggcgcg";
        int L = 3;
       tst.countUniqueSubstrings(input, L); 
       
    }
}