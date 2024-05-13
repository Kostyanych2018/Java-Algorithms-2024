package com.task_3_4_19;

import java.util.LinkedList;

public class LinearProbingHashST<K, V> {
    private int N;
    private int M = 16;
    private K[] keys;
    private V[] vals;

    @SuppressWarnings("unchecked")
    public LinearProbingHashST(int capacity) {
        keys = (K[]) new Object[capacity];
        vals = (V[]) new Object[capacity];
        M = capacity;
    }

    @SuppressWarnings("unchecked")
    public LinearProbingHashST() {
        keys = (K[]) new Object[M];
        vals = (V[]) new Object[M];
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capacity) {
        LinearProbingHashST<K, V> temp = new LinearProbingHashST<>(capacity);

        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        M = temp.M;
    }

    public void put(K key, V val) {
        if (N >= M / 2) {
            resize(2 * M);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public V get(K key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                return vals[i];
            }
        return null;
    }

    public Iterable<K> keys() {
        LinkedList<K> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                queue.add(keys[i]);
            }
        }
        return queue;
    }

}
