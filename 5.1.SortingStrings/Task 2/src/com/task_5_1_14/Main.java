package com.task_5_1_14;

import com.task_5_1_14.sorts.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[][] arrays={
            {1,2,3},
            {3,2,1},
            {2,1,3},
            {2,3,1},
            {1,3,2},
            {3,1,2}
        };
        
        ThreeWaySort.sort(arrays);
        System.out.println("Отсортированный думерный массив: ");
        System.out.println(Arrays.deepToString(arrays));
}
}