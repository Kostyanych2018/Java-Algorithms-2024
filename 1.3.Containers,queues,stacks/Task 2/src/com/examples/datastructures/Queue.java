
package com.examples.datastructures;
import java.util.*;
//1.3.29 стр.160
public class Queue<Item> implements Iterable<Item> {
    private Node last;// ссылка на последний узел
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            last.next = last;
        } else {
            last.next = oldlast.next;
            oldlast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Очередь пуста");
        Item item = last.item;
        if (last.next == last) {
            last = null;
        } else {
            last.next = last.next.next;
        }
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = last.next;

        public boolean hasNext() {
            return current != null;
        };

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() 
		{
			throw new UnsupportedOperationException();
		}
    }
}
