package com.task_5_2_10.trees;

public class TrieST<V> {
    private static int R = 256;
    private Node root;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
        private int size;//добавляем поле сайз в узел
    }

    @SuppressWarnings("unchecked")
    public V get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return (V) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, V val) {
        root = put(root, key, val, 0);
    }

  private Node put(Node x, String key, V val, int d) {
    if (x == null) {
        x = new Node();
    }
    if (d == key.length()) {
        if(x.val == null) x.size++;  // увеличиваем размер, если добавляем новый ключ
        x.val = val;
        return x;
    }
    char c = key.charAt(d);
    x.next[c] = put(x.next[c], key, val, d + 1);
    x.size = 1;  //учитываем сам узел
    for (char ch = 0; ch < R; ch++) {
        x.size += size(x.next[ch]);  // добавляем размер каждого дочернего узла
    }
    return x;
}

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    // сбор ключей из trie-дерева
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new Queue<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) {
            return;
        }

        if (x.val != null) {
            q.enqueue(pre);
        }

        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, q);
        }
    }

    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new Queue<>();
        collect(root, "", pat, q);
        return q;
    }

    public void collect(Node x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) {
            return;
        }
        if (d == pat.length() && x.val != null) {
            q.enqueue(pre);
        }
        if (d == pat.length()) {
            return;
        }

        char next = pat.charAt(d);

        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c)
                collect(x.next[c], pre + c, pat, q);
        }
    }

    // самый длинный префикс
    public String longetsPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) {
            return length;
        }
        if (x.val != null) {
            length = d;
        }
        if (d == s.length()) {
            return length;
        }
        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }
        return x;
    }
}
