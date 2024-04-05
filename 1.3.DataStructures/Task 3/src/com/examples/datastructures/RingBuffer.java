/*
задание 1.3.39 стр.162

API-интерфейс:

class RingBuffer<T>

RingBuffer(int cap) создание буфера

boolaen is Empty() пуст ли буфер

boolean isFull() полон ли буфер

void enqueue(T item) добавляем в конец буфера, если полон - исключение

T dequeue() удаление элемента из начала буфера если пуст - исключение

int size() текущий размер буфера
*/
package com.examples.datastructures;
import java.util.NoSuchElementException;

public class RingBuffer<T> {
    private T[] buffer;

    private int head = 0;// первый элемент
    private int tail = 0;// последний элемент
    private int size = 0;

    @SuppressWarnings("unchecked")
    public RingBuffer(int n) {
       buffer = (T[]) new Object[n];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == buffer.length;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new RuntimeException("Переполенние буфера, ждем"
                                        +" когда можно будет поместить данные");
        }
        buffer[tail] = item;
        tail++;
        size++;
        if (tail == buffer.length) {
            tail = 0;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Буфер пуст, ждем поступления" +
                                            "в него данных");
        }
        T item = buffer[head];
        buffer[head] = null;
        head++;
        size--;
        if (head == buffer.length) {
            head = 0;
        }
        return item;
    }
    public int size(){
        return size;
    }

}

