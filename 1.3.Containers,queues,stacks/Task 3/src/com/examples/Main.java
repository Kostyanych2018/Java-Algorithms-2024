package com.examples;
import com.examples.datastructures.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger l= Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        RingBuffer<Integer> buffer = new RingBuffer<>(5);
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.enqueue(4);
        buffer.enqueue(5);
        l.info("Буфер полон: " + buffer.isFull());
        //buffer.enqueue(6);

        int item = buffer.dequeue();
        int item1 = buffer.dequeue();
        int item2 = buffer.dequeue();

        l.info("Буфер пуст: " + buffer.isEmpty());
        
        l.info(String.format("Удаленные элементы: %d,%d,%d", item, item1, item2));
        l.info("Текущий размер буфера: " + buffer.size());
    }
}
