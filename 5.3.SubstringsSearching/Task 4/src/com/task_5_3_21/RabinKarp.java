package com.task_5_3_21;

public class RabinKarp {
    private long patHash1;
    private long patHash2;
    private int M;
    private long Q = 997;
    private int R = 256;
    private long RM1;// R^(M-1)%Q;
    private long RM2;
    private int mid;

    public RabinKarp(String pat) {
        this.M = pat.length();
        mid = M / 2;
        RM1 = 1;
        for (int i = 1; i < M; i++) {
            RM1 = (R * RM1) % Q;
        }
        RM2 = 1;
        for (int i = mid + 1; i < M; i++) {
            RM2 = (R * RM2) % Q;
        }
        patHash1 = hash(pat, 0, mid);
        patHash2 = hash(pat, mid + 1, M);
    }

    private long hash(String key, int start, int end) {
        long h = 0;
        for (int j = start; j < end; j++) {
            h = (h * R + key.charAt(j)) % Q;
        }
        return h;
    }

    public int search(String txt) {
        int N = txt.length();
        long txtHash1 = hash(txt, 0, mid);
        long txtHash2 = hash(txt, mid + 1, M);
        if (patHash1 == txtHash1 && patHash2 == txtHash2) {
            return 0;
        }
        for (int i = M; i < N; i++) {
            txtHash1 = (txtHash1 + Q - RM1 * txt.charAt(i - M) % Q) % Q;
            txtHash1 = (txtHash1 * R + txt.charAt(i - mid)) % Q;
            txtHash2 = (txtHash2 + Q - RM2 * txt.charAt(i - mid) % Q) % Q;
            txtHash2 = (txtHash2 * R + txt.charAt(i)) % Q;
            if (patHash1 == txtHash1 && patHash2 == txtHash2)
                return i - M + 1;
        }
        return N;
    }
}
