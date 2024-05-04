package com.task_3_4_36.datastructures;

import java.util.LinkedList;

//последовательный поиск(в неупорядоченном связном списке)
public class SequentialSearchST<K, V> {

    private Node first;
    private int size;

    private class Node {
        K key;
        V val;
        Node next;

        public Node(K key, V val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public V get(K key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(K key, V val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
            size++;
    }

    public Iterable<K> keys() {
        LinkedList<K> queue = new LinkedList<>();
        for (Node x = first; x != null; x = x.next) {
            queue.add(x.key);
        }
        return queue;
    }

    public int size(){
        return size;
    }
}
