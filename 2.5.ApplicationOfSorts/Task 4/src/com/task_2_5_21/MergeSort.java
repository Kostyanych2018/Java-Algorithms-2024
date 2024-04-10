package com.task_2_5_21;

public class MergeSort {

    private MergeSort() {
    }

    public static void sort(Vector[] arr) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        Vector[] left = new Vector[mid];
        Vector[] right = new Vector[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        sort(left);
        sort(right);

        merge(arr, left, right);
    }

    public static void merge(Vector[] arr, Vector[] left, Vector[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
