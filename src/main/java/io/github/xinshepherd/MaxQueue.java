package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

// 面试题59 - II. 队列的最大值
public class MaxQueue {

    private final Deque<Integer> queue = new LinkedList<>();
    private final Deque<Integer> maxDeque = new LinkedList<>();

    public MaxQueue() {
    }

    public int max_value() {
        if (queue.isEmpty())
            return -1;
        return maxDeque.getFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);
        while (!maxDeque.isEmpty() && maxDeque.getLast() < value) {
            maxDeque.removeLast();
        }
        maxDeque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        Integer integer = queue.removeFirst();
        if (integer.equals(maxDeque.getFirst())) {
            maxDeque.removeFirst();
        }
        return integer;
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }

}
