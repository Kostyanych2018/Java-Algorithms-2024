package com.task_5_1_9.sorts;

public class LSDSort {
    private LSDSort() {}

    public static void sort(String[] a) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        // Находим максимальную длину строки
        int W = 0;
        for (String s : a) {
            if (s.length() > W) {
                W = s.length();
            }
        }

        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            for (int i = 0; i < N; i++) {
                int charAtD = d < a[i].length() ? a[i].charAt(d) : 0;
                count[charAtD + 1]++;
            }

            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            for (int i = 0; i < N; i++) {
                int charAtD = d < a[i].length() ? a[i].charAt(d) : 0;
                aux[count[charAtD]++] = a[i];
            }

            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
