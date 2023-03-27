package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题13. 机器人的运动范围
 *
 * @author Fuxin
 * @since 2020/4/8
 */
public class MovingCount {

    int[] nr = {0, -1, 0, 1};
    int[] nc = {-1, 0, 1, 0};

    public int movingCount(int m, int n, int k) {
        Deque<Integer> stack = new LinkedList<>();
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        stack.push(0);
        int divisor = Math.max(m, n);
        int count = 1;
        while (!stack.isEmpty()) {
            int code = stack.pop();
            int dr = code / divisor;
            int dc = code % divisor;
            for (int i = 0; i < 4; i++) {
                int x = dr + nr[i];
                int y = dc + nc[i];
                if (x >= 0 && x < m && y >= 0 && y < n && !dp[x][y]) {
                    int sum = sumDigits(x) + sumDigits(y);
                    if (sum <= k) {
                        dp[x][y] = true;
                        int c = x * divisor + y;
                        stack.push(c);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MovingCount count = new MovingCount();
        Assertions.assertThat(count.movingCount(2, 3, 1)).isEqualTo(3);
        Assertions.assertThat(count.movingCount(3, 1, 0)).isEqualTo(1);
        Assertions.assertThat(count.movingCount(1, 2, 1)).isEqualTo(2);
    }

}
