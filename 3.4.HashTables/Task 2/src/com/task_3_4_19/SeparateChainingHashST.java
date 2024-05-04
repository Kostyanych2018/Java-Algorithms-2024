package com.task_3_4_19;

import java.util.LinkedList;

//хеширование с раздельными цепочками
public class SeparateChainingHashST<K, V> {

    @SuppressWarnings("unused")
    private int N;// колво пар
    private int M;// размер таблицы
    private SequentialSearchST<K, V>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    @SuppressWarnings("unchecked")
    public SeparateChainingHashST(int M) {
        this.M = M;
        st = new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public V get(K key) {
        return st[hash(key)].get(key);
    }

    public void put(K key, V val) {
        st[hash(key)].put(key, val);
    }

    public Iterable<K> keys() {
        LinkedList<K> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (K key : st[i].keys())
                queue.add(key);
        }
        return queue;
    }
}
