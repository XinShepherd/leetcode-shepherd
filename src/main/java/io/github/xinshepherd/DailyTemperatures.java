package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 739 每日温度
 *
 * @author Fuxin
 * @since 2020/6/11
 */
public class DailyTemperatures {

    // 暴力
    // O(n2)
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int t = T[i];
            for (int j = i + 1; j < len; j++) {
                if (t < T[j]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    // O(n)
    public int[] dailyTemperatures2(int[] T) {
        int len = T.length;
        if (len == 0)
            return T;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            int t = T[i];
            while (!stack.isEmpty() && T[stack.peek()] < t) {
                Integer index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures temperatures = new DailyTemperatures();
        assertThat(temperatures.dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))
                .isEqualTo(new int[]{1, 1, 4, 2, 1, 1, 0, 0});

    }

}
