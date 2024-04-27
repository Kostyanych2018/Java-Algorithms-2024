package com.task_3_3_42;

import java.util.*;
import com.task_3_3_42.datastructures.*;

public class Main {
    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> bst = new RedBlackBST<>();

        Random random = new Random();

        //вставка N случ ключей
        int n=100;
        for(int i=0;i<n;i++){
            int key=random.nextInt(n);
            bst.put(key, key);
        }

        double percentage = bst.percentageOfRedNodes();
        System.out.println("Процент красных узлов: "+percentage+"%");
    }

    //при увеличении до 10 в 4 в 5 и в 6 увеличение красных узлов не происходит
}
