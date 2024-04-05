
package com.task_1_3_4.datastructures;
import java.util.*;
//1.3.4 стр.157
public class Stack<T> implements Iterable<T> {
    private Node first;// верхушка стека(последний добавленный узел)
    private int n;

    private class Node {
        // вложенный класс для определения узлов
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
        // добавление элемента на верхушку стека
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public T pop() {
        // удаление элемента с верхушки стека
        if (isEmpty()) {
            throw new NoSuchElementException("Стек пуст");
        }
        T item = first.item;
        first = first.next;
        n--;
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
            current = curr.next;
            return item;
        }
    }
}
