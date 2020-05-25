package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * @author Fuxin
 * @since 2020/5/25
 */
class MyQueue {

    private Deque<Integer> stack = new LinkedList<>();
    private Deque<Integer> temp = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        ensureTempStack();
        return temp.pop();
    }

    /** Get the front element. */
    public Integer peek() {
        ensureTempStack();
        return temp.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && temp.isEmpty();
    }

    private void ensureTempStack() {
        if (temp.isEmpty()) {
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        assertThat(queue.peek()).isEqualTo(1);
        assertThat(queue.pop()).isEqualTo(1);
        assertThat(queue.empty()).isEqualTo(false);
    }
}
