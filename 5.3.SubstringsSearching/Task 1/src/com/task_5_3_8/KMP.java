package com.task_5_3_8;

import java.util.ArrayList;
import java.util.List;

public class KMP {
    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X]; // копирования случаев несовпадения
            }
            dfa[pat.charAt(j)][j] = j + 1;// оформление случая совпадения
            X = dfa[pat.charAt(j)][X];// обновления состояния перезапуска
        }
    }

    public int search(String s, int start) {
        int i, j, N = s.length(), M = pat.length();
        for (i = start, j = 0; i < N && j < M; i++) {
            j = dfa[s.charAt(i)][j];
        }
        if (j == M) {
            return i - M;// найден
        } else {
            return N;// не найден
        }
    }

    public int count(String s){
        int count=0;
        int pos=search(s, 0);
        while(pos<s.length()){
            count++;
            pos=search(s,pos+pat.length());
        }
        return count;
    }

    public List<Integer> searchAll(String s){
        List<Integer> count=new ArrayList<>();
        int pos=search(s, 0);
        while(pos<s.length()){
            count.add(pos);
            pos=search(s, pos+pat.length());
        }
        return count;
    }
}