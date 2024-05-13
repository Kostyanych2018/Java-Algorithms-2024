package com.task_5_1_16;

import com.task_5_1_16.LinkedlList.QuickSort3WayLinkedList;
import com.task_5_1_16.LinkedlList.Node;
public class Main {
   public static void main(String[] args) {
    QuickSort3WayLinkedList list = new QuickSort3WayLinkedList();
    list.addNode("C");
    list.addNode("A");
    list.addNode("E");
    list.addNode("B");
    list.addNode("D");

    Node n = list.getFirst();
    while (n.getNext() != null) {
        n = n.getNext();
    }

    System.out.println("Linked List before sorting");
    list.printList(list.getFirst());

    list.sort(list.getFirst(), n);

    System.out.println("\nLinked List after sorting");
    list.printList(list.getFirst());
}

}