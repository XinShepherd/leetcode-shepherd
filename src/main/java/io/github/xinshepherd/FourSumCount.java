package io.github.xinshepherd;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 454. 四数相加 II
 *
 * https://leetcode-cn.com/problems/4sum-ii/
 *
 * @author Fuxin
 * @since 2020/11/27
 */
public class FourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0 || B.length == 0 || C.length == 0|| D.length == 0)
            return 0;
        Map<Integer, Integer> sumAB = new HashMap<>(A.length + B.length);
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                Integer count = sumAB.getOrDefault(sum, 0);
                count++;
                sumAB.put(sum, count);
            }
        }
        Map<Integer, Integer> sumCD = new HashMap<>(C.length + D.length);
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                Integer count = sumCD.getOrDefault(sum, 0);
                count++;
                sumCD.put(sum, count);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : sumAB.entrySet()) {
            Integer count = sumCD.getOrDefault(-entry.getKey(), 0);
            ans += count * entry.getValue();
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSumCount fourSumCount = new FourSumCount();
        assertThat(fourSumCount.fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2}
        )).isEqualTo(2);

    }

}
