package com.task_3_3_29;


//заменяем биты цветов на сравнение ключей и изменение ссылок
public class optimalRBST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        K key;
        @SuppressWarnings("unused")
        V value;
        Node left;
        Node right;
        int n;

        Node(K key, V value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.n;
        }

    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    void flipsColors(Node h) {
        Node temp = h.left;
        h.left = h.right;
        h.right = temp;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }
    
    private Node put(Node h, K key, V val) {
        if (h == null) {
            return new Node(key, val, 1);
        }
    
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.value = val;
        }
    
        if (h.right != null && h.right.key.compareTo(h.key) > 0) {
            h = rotateLeft(h);
        }
        if (h.left != null && h.left.key.compareTo(h.key) > 0 && h.left.left != null && h.left.left.key.compareTo(h.left.key) > 0) {
            h = rotateRight(h);
        }
        if (h.left != null && h.left.key.compareTo(h.key) > 0 && h.right != null && h.right.key.compareTo(h.key) > 0) {
            flipsColors(h);
        }
        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }
    
}