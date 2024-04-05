package com.task_1_3_33.datastructures;
import java.util.*;

public class ResizingArrayDeque<T> implements Iterable<T> {

    private int size;
    private int first;
    private int last;
    private T[] deque;

    @SuppressWarnings("unchecked")
    public ResizingArrayDeque() {
        deque = (T[]) new Object[1];
        size = 0;
        first = 0;
        last = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(int n) {
        T[] temp = (T[]) new Object[n];
        for (int i = 0; i < size; i++) {
            temp[i] = deque[(first + i)%deque.length];
        }
        deque = temp;
        first = 0;
        last = size;
    }

    public void pushLeft(T item) {
        if (size == deque.length) {
            resize(2 * deque.length);
        }
        first=(first+deque.length-1)%deque.length;
        deque[first] = item;
        size++;
    }

    public void pushRight(T item) {
        if (size == deque.length) {
            resize(2 * deque.length);
        }
        deque[last] = item;
        last++;
        size++;
    }

    public T popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Дек пуст.");
        }
        T item =deque[first];
        deque[first]=null;
        size--;
        first++;
        if(first==deque.length) first=0;
        if(size>0 && size==deque.length/4) resize(deque.length/2);   
        return item;
    }

    public T popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Дек пуст.");
        }
        last=(last+deque.length-1)%deque.length;
        T item = deque[last];
        deque[last]=null;
        size--;
        return item;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private int i = 0;

        public boolean hasNext() {
            return i < size;
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = deque[(first+i)%deque.length];
            i++;
            return item;
        }
    }
}
