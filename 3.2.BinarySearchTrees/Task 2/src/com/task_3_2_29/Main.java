package com.task_3_2_29;

import com.task_3_2_29.datasructures.*;

public class Main {
    public static void main(String[] args) {

        BST<Integer, String> bst = new BST<>();
        bst.put(3, "three");
        bst.put(7, "seven");
        bst.put(2, "two");
        bst.put(4, "four");
        bst.put(6, "six");
        bst.put(5, "aaaaaaaaa");

        System.out.println("Is BST: " + bst.isBinaryTree(bst.getRoot()));

        /*BST:
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
          если в этом коде проинициализировать счетчик напрямую
          n = 10 (к примеру), то есть  если вручную изменить значение n для любого узла,
          не обновляя его при добавлении или удалении узлов,
          то дерево может стать “небинарным” в контексте метода isBinaryTree() и будет false.
          иначе будет true так как у нас счетчик всегда 
          поддерживается при добавлении, удалении узлов и тд в ДБП
         */
    }
}