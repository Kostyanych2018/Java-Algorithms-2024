package com.task_1_3_29;

import java.util.logging.Logger;

import com.task_1_3_29.datastructures.Queue;

//1.3.29 стр.160
public class Main {
    private static final Logger l = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        
        Queue<Integer> q = new Queue<>();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        
        if (l.isLoggable(java.util.logging.Level.INFO)) {
            l.info("Текущий размер очереди: " + q.size());

            l.info("Удаленный элемент: " + q.dequeue());

            l.info("Текущий размер: " + q.size());
        }
    }
}
