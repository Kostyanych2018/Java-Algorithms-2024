
package com.task_1_3_29.datastructures;

import java.util.*;

//1.3.29 стр.160
public class Queue<T> implements Iterable<T> {
    private Node last;// ссылка на последний узел
    private int n;

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(T item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            last.next = last;
        } else {
            last.next = oldlast.next;
            oldlast.next = last;
        }
        n++;
    }

    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Очередь пуста");
        T item = last.item;
        if (last.next == last) {
            last = null;
        } else {
            last.next = last.next.next;
        }
        n--;
        return item;
    }

    public Iterator<T> iterator() {
        return new QueueListIterator();
    }

    private class QueueListIterator implements Iterator<T> {
        private Node current = last.next;
        private int count = 0;
    
        public boolean hasNext() {
            return count < n;
        }
    
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            count++;
            return item;
        }
    }    
}
