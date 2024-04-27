package com.task_3_3_31.datastructures;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

public class RedBlackBST<K extends Comparable<K>, V> {
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        K key;
        @SuppressWarnings("unused")
        V value;
        Node left;
        Node right;
        int n;
        boolean color;

        Node(K key, V value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.n = n;
            this.color = color;
        }
    }

    public void draw() {
        JFrame frame = new JFrame("Red Black Tree");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new TreePanel(root));
        frame.setVisible(true);
    }

    class TreePanel extends JPanel {
        Node root;

        TreePanel(Node root) {
            this.root = root;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawTree(g, getWidth() / 2, 40, root);
        }

        private void drawTree(Graphics g, int x, int y, Node node) {
            if (node == null) return;

            if (node.color == RED) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }

            g.fillOval(x, y, 30, 30);
            g.setColor(Color.WHITE);
            g.drawString(node.key.toString(), x + 10, y + 20);

            if (node.left != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x + 15, y + 30, x - 30, y + 60);
                drawTree(g, x - 50, y + 60, node.left);
            }

            if (node.right != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x + 15, y + 30, x + 70, y + 60);
                drawTree(g, x + 50, y + 60, node.right);
            }
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

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, K key, V val) {
        if (h == null) {
            return new Node(key, val, 1, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.value = val;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }
}