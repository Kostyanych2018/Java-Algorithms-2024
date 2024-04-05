package com.examples;
import com.examples.datastructures.Queue;
import java.util.logging.Logger;
//1.3.29 стр.160
class Main {
    private static final Logger l = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        
        l.info("Текущий размер очереди: " + q.size());

        l.info("Удаленный элемент: " + q.dequeue());

        l.info("Текущий размер: " + q.size());
    }
}
