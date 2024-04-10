package com.task_2_5_19;

/*O(n*logn)
по сути это количество инверсий в 
одной перестановке относительно другой, поэтому
можно применить сорт слиянием немного модифицировав
его под вычисление инверсий*/

public class KendallTau {
    
    private KendallTau() {
    }

    public static long kendallTau(int[] a, int[] b) {

        if (a.length != b.length) {
            throw new IllegalArgumentException("Перестановки должны быть одной длины!ш");
        }

        int[] aIndex = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            aIndex[a[i]] = i;// массив индексов элементов массивов а
        }

        Integer[] bIndex = new Integer[b.length];
        for (int i = 0; i < b.length; i++) {
            bIndex[i] = aIndex[b[i]];// массив с элементами, равными индексами соответсв элементов из b в a
        }
        return inversions(bIndex);
    }

    public static long inversions(Integer[] a) {
        return mergeSort(a, 0, a.length - 1);
    }

    public static long mergeSort(Integer[] a, int left, int right) {
        if (right <= left) {
            return 0;
        }

        int mid = (left + right) / 2;
        int swaps = 0;
        swaps += mergeSort(a, left, mid);
        swaps += mergeSort(a, mid + 1, right);
        swaps += merge(a, left, mid, right);
        return swaps;
    }

    public static long merge(Integer[] a, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int count = 0;

        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                i++;
            } else {
                j++;
                count += mid + 1 - i;
            }
        }
        return count;
    }
}
