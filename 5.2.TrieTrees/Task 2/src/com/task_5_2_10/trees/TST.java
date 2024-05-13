package com.task_5_2_10.trees;

public class TST<V> {
    private Node root;

    private class Node {
        char c;
        Node left;
        Node mid;
        Node right;
        V val;
        int size = 1;
    }

    public V get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null || key == null || key.trim().isEmpty() || d>=key.length()) {
            return null;
        }
        char c = key.charAt(d);
        if (c < x.c) {
            return get(x.left, key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        } else
            return x;
    }

    public void put(String key, V val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, V val, int d) {
        if (d >= key.length()) {
            return x;
        }
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c) {
            x.left = put(x.left, key, val, d);
        } else if (c > x.c) {
            x.right = put(x.right, key, val, d);
        } else if (d < key.length() - 1) {
            x.mid = put(x.mid, key, val, d + 1);
        } else {
            if (x.val == null)
                x.size++;// увеличиваем размер, если добавляем новый ключ
            x.val = val;
        }
        x.size = 1 + size(x.mid) + size(x.left) + size(x.right); // обновляем размер узла после рекурсивного вызова
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

    public Iterable<String> keys() {
        Queue<String> queue = new Queue<>();
        collect(root, "", queue);
        return queue;
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue = new Queue<>();
        Node x = get(root, prefix, 0);
        if (x == null)
            return queue;
        if (x.val != null)
            queue.enqueue(prefix);
        collect(x.mid, prefix, queue);
        return queue;
    }

    private void collect(Node x, String prefix, Queue<String> queue) {
        if (x == null) {
            return;
        }

        if (x.val != null) {
            queue.enqueue(prefix + x.c);
        }
        collect(x.left, prefix, queue);
        collect(x.mid, prefix + x.c, queue);
        collect(x.right, prefix, queue);
    }

    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> q = new Queue<>();
        collect(root, "", pattern, 0, q);
        return q;
    }

    public void collect(Node x, String prefix, String pattern, int i, Queue<String> q) {
        if (x == null) {
            return;
        }

        char c = pattern.charAt(i);

        if (c == '.' || c < x.c) {
            collect(x.left, prefix, pattern, i, q);
        }

        if (c == '.' || c == x.c) {
            if (i == pattern.length() - 1 && x.val != null) {
                q.enqueue(prefix + x.c);
            }
            if (i < pattern.length() - 1) {
                collect(x.mid, prefix + x.c, pattern, i + 1, q);
            }
        }

        if (c == '.' || c > x.c) {
            collect(x.right, prefix, pattern, i, q);
        }
    }

    public String longestPrefixOf(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        int length = 0;
        Node x = root;
        int i = 0;
        while (x != null && i < s.length()) {
            char c = s.charAt(i);
            if (c < x.c) {
                x = x.left;
            } else if (c > x.c) {
                x = x.right;
            } else {
                i++;
                if (x.val != null) {
                    length = i;
                }
                x = x.mid;
            }
        }
        return s.substring(0, length);
    }
}
