package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 *
 * @author Fuxin
 * @since 2020/5/12
 */
public class MinStack {

    Deque<Integer> stack = new LinkedList<>();

    Deque<Integer> minStack = new LinkedList<>();

    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (x <= min) {
            minStack.push(x);
            min = x;
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop == min) {
            minStack.pop();
            if (!minStack.isEmpty())
                min = minStack.peek();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertThat(minStack.getMin()).isEqualTo(-3);
        minStack.pop();
        assertThat(minStack.top()).isEqualTo(0);
        assertThat(minStack.getMin()).isEqualTo(-2);
    }

}
