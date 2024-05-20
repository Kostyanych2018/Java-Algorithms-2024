package com.task_5_4_20.Graphs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {

    private class Node {
         T item;
         Node next;
    }

    private Node first;
    private int size;

    @SuppressWarnings("unused")
    private int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        ++size;
    }

    public Iterator<T> iterator() {
        return new BagItr(first);
    }

    private class BagItr implements Iterator<T> {
        private Node current;

        public BagItr(Node first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
