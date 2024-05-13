package com.task_5_2_21.trees;

import java.util.ArrayList;
import java.util.List;

public class TSTClient {
    private TST<Integer> tst;

    public TSTClient(){
        tst=new TST<>();
    }

    public void addWord(String word){
        for(int i=0;i<word.length();i++){
            tst.put(word.substring(i), 1);
        }
    }

    public Iterable<String> keysContains(String s){
        List<String> result = new ArrayList<>();
        for(String key: tst.keys()){
            if(key.contains(s)){
                result.add(key);
            }
        }
        return result;
    }
}
