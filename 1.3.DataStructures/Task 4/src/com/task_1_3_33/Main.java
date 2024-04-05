package com.task_1_3_33;
import java.util.logging.Logger;

import com.task_1_3_33.datastructures.*;

public class Main {
    // 1.3.33 стр.161
    private static final Logger l = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        
        ResizingArrayDeque<Integer> deque1 = new ResizingArrayDeque<>();
        deque1.pushLeft(1);
        deque1.pushRight(2);
        deque1.pushLeft(3);
        deque1.pushRight(4);

        StringBuilder sb = new StringBuilder();
        for (int i : deque1) {
            sb.append(i).append(" ");
        }
        if(l.isLoggable(java.util.logging.Level.INFO)){
            l.info(sb.toString());
        }

        int left = deque1.popLeft();
        int right = deque1.popRight();

        if(l.isLoggable(java.util.logging.Level.INFO)){
            l.info(left + " " + right);
        }

        sb = new StringBuilder();
        for (int i : deque1) {
            sb.append(i).append(" ");
        }
        if(l.isLoggable(java.util.logging.Level.INFO)){
            l.info(sb.toString());
        }

        Deque<Integer> deque2 = new Deque<>();

        deque2.pushLeft(1);
        deque2.pushRight(2);
        deque2.pushLeft(3);
        deque2.pushRight(4);

        sb = new StringBuilder();
        for (int i : deque2) {
            sb.append(i).append(" ");
        }
        if(l.isLoggable(java.util.logging.Level.INFO)){
            l.info(sb.toString());
        }
    }
}
