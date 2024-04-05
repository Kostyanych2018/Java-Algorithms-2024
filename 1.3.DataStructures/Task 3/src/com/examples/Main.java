package com.examples;
import com.examples.datastructures.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger l = Logger.getLogger(Main.class.getName());

    public static void main(String[]args) {
        RingBuffer<Integer> buffer = RingBuffer.create(5);
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.enqueue(4);
        buffer.enqueue(5);
        l.info("Буфер полон: " + buffer.isFull());

        l.info("Буфер пуст: " + buffer.isEmpty());

        l.info(String.format("Удаленные элементы: %d,%d,%d", buffer.dequeue(),buffer.dequeue(),buffer.dequeue()));
        l.info("Текущий размер буфера: " + buffer.size());
    }
}
