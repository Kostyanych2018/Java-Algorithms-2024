
package com.examples.datastructures;
import java.util.*;
//1.3.4 стр.157
public class Stack<Item> implements Iterable<Item> {
    private Node first;// верхушка стека(последний добавленный узел)
    private int N;

    private class Node {
        // вложенный класс для определения узлов
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null; // или N==0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        // добавление элемента на верхушку стека
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        // удаление элемента с верхушки стека
        if (isEmpty()) {
            throw new NoSuchElementException("Стек пуст");
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

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
