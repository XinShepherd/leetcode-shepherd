package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author Fuxin
 * @since 2020/6/30
 */
class CQueue {

    private Deque<Integer> inStack = new LinkedList<>();
    private Deque<Integer> outStack = new LinkedList<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        return -1;
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        assertThat(cQueue.deleteHead()).isEqualTo(-1);
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        assertThat(cQueue.deleteHead()).isEqualTo(5);
        assertThat(cQueue.deleteHead()).isEqualTo(2);
    }
}