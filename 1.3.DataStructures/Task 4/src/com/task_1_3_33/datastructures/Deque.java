package com.task_1_3_33.datastructures;
import java.util.*;

public class Deque<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        T item;
        Node next;
        Node prev;

    }

    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void pushLeft(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;
        if (isEmpty()) {
            last = first;
        } else {
            oldFirst.prev = first;
        }
        size++;
    }

    public void pushRight(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public T popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Дек пуст.");
        }
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        } else {
            first.prev = null;
        }
        return item;
    }

    public T popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Дек пуст.");
        }
        T item = last.item;
        last = last.prev;
        size--;
        if (isEmpty()) {
            first = null;
        } else {
            last.next = null;
        }
        return item;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
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

        
        @Override
        public void remove() 
		{
			throw new UnsupportedOperationException();
		}
    }
}