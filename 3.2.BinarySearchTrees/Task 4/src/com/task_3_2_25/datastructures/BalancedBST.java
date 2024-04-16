package com.task_3_2_25.datastructures;

import java.util.Arrays;
import java.util.NoSuchElementException;

//метод в конце
public class BalancedBST<K extends Comparable<K>, V> {

    private Node root;

    public Node getRoot() {
        return root;
    }

    private class Node {
        private K key;
        private V val;
        private Node left;
        private Node right;
        private int n;

        public Node(K key, V val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
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

    // поиск
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    // вставка
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.n = size(x.right) + size(x.left) + 1;
        return x;
    }

    // минимальный ключ
    public K min() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    // нижняя опора
    public K floor(K key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, K key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    // маскимальный ключ
    public K max() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    // верхняя опора
    public K ceiling(K key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node ceiling(Node x, K key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }

    // выбор ключа
    public K select(int k) {
        Node node = select(root, k);
        return (node != null) ? node.key : null;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }

        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    // ранг ключа
    public int rank(K key) {
        return rank(key, root);
    }

    private int rank(K key, Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }

    // удаление мин ключа
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    // удаление макс ключа
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    // удаление узла
    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                Node t = x;
                x = min(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }

        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    // вывод ключей из дбп в упорядоченном виде
    public void print(Node x) {
        if (x == null) {
            return;
        }
        print(x.left);
        System.out.println(x.key);
        print(x.right);
    }

    // поиск диапазона в дбп
    public Iterable<K> keys() {
        return keys(min(), max());
    }

    public Iterable<K> keys(K lo, K hi) {
        Queue<K> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    public void keys(Node x, Queue<K> queue, K lo, K hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }

    // в порядке возрастания вставляем сначала
    public void insertInOrder(K[] keys) {
        Arrays.sort(keys);
        buildBalancedBST(keys, 0, keys.length - 1);
    }

    // строим наше дбп
    private void buildBalancedBST(K[] keys, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        put(keys[mid], null);
        buildBalancedBST(keys, lo, mid - 1);
        buildBalancedBST(keys, mid + 1, hi);
    }
}
