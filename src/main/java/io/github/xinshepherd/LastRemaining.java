package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题62. 圆圈中最后剩下的数字
 *
 * @author Fuxin
 * @since 2020/3/30
 */
public class LastRemaining {

    // 参考官方答案
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    int f(int n, int m) {
        if (n == 1)
            return 0;
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public int lastRemaining2(int n, int m) {

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.addLast(i);
        }
        while (deque.size() > 1) {
            for (int i = 0; i < m; i++) {
                deque.addLast(deque.poll());
            }
            deque.removeLast();
        }
        return deque.isEmpty() ? 0 : deque.poll();
    }

    public static void main(String[] args) {
        LastRemaining remaining = new LastRemaining();
        System.out.println(remaining.lastRemaining(5, 3));
        System.out.println(remaining.lastRemaining(10, 17));
    }
}
