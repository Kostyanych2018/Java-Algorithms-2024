/*
задание 1.3.39 стр.162

API-интерфейс:

class RingBuffer<T>

RingBuffer(int cap) создание буфера

boolean is Empty() пуст ли буфер

boolean isFull() полон ли буфер

void enqueue(T item) добавляем в конец буфера, если полон - исключение

T dequeue() удаление элемента из начала буфера если пуст - исключение

int size() текущий размер буфера
*/
package com.task_1_3_39.datastructures;
import java.util.NoSuchElementException;

public class RingBuffer<T> {
  
    private T[] buffer;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    private RingBuffer(int n) {
        this.buffer = (T[]) new Object[n];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public static <T> RingBuffer<T> create(int size) {
        return new RingBuffer<>(size);
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == buffer.length;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalArgumentException("Переполенние буфера, ждем"
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

