package com.task_1_3_39;

import java.util.logging.Logger;

import com.task_1_3_39.datastructures.*;

public class Main {
    private static final Logger l = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        RingBuffer<Integer> buffer = new RingBuffer<>(5);
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.enqueue(4);
        buffer.enqueue(5);
        if (l.isLoggable(java.util.logging.Level.INFO)) {

            l.info("Буфер полон: " + buffer.isFull());

            int item = buffer.dequeue();
            int item1 = buffer.dequeue();
            int item2 = buffer.dequeue();

            l.info("Буфер пуст: " + buffer.isEmpty());

            l.info(String.format("Удаленные элементы: %d,%d,%d", item, item1, item2));
            
            l.info("Текущий размер буфера: " + buffer.size());
        }
    }
}
