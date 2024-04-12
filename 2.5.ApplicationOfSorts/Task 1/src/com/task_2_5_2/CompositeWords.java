package com.task_2_5_2;

import java.util.*;

public class CompositeWords {
    
    private CompositeWords() {
    }

    public static boolean isComposite(String word, List<String> words) {
        for (int i = 0; i < word.length(); i++) {
            String first = word.substring(0, i);
            String second = word.substring(i);
            if (Collections.binarySearch(words, first) >= 0 && Collections.binarySearch(words, second) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void insertionSort(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String key = words.get(i);
            int j = i - 1;
            while (j >= 0 && words.get(j).compareTo(key) > 0) {
                words.set(j + 1, words.get(j));
                j -= 1;
            }
            words.set(j + 1, key);
        }
    }
}