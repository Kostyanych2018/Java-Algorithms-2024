
package com.task_3_2_36.datastructures;
import java.util.*;

public class Stack<T> implements Iterable<T> {
    private Node first;
    private int n;

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null; 
    }

    public int size() {
        return n;
    }

    public void push(T item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Стек пуст");
        }
        T item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Iterator<T> iterator() {
        return new StackListIterator();
    }

    private class StackListIterator implements Iterator<T> {

        private Node curr = first;

        public boolean hasNext() {
            return curr != null;
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = curr.item;
            curr = curr.next;
            return item;
        }
    }
}
