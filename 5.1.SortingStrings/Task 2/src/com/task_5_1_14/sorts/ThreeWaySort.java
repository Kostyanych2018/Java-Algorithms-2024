package com.task_5_1_14.sorts;

public class ThreeWaySort {
    private ThreeWaySort(){}
    
    public static void sort(int[][] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private static void sort(int[][] a, int lo, int hi, int d) {
        if (hi <= lo) {
            return;
        }

        int lt = lo;
        int gt = hi;

        int v = a[lo][d];
        int i = lo + 1;

        while (i <= gt) {
            int t = a[i][d];
            if (t < v)
                swap(a, lt++, i++);
            else if (t > v)
                swap(a, i, gt--);
            else
                i++;
        }

        sort(a, lo, lt - 1, d);
        if (d < a[0].length - 1) {
            sort(a, lt, gt, d + 1);
        }
        sort(a, gt + 1, hi, d);
    }

    private static void swap(int[][] a, int i, int j) {
        int[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}