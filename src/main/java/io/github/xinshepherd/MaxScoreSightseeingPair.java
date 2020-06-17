package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1014. 最佳观光组合
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 *
 * @author Fuxin
 * @since 2020/6/17
 */
public class MaxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        return dynamic(A);
    }

    private int dynamic(int[] A) {
        int len = A.length;
        int[] dp = new int[len];
        int max = Integer.MIN_VALUE;
        for (int j = len - 1; j >= 0; j--) {
            int cache = A[j] - j;
            if (cache > max) {
                max = cache;
            }
            dp[j] = max;
        }
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            int score = A[i] + i + dp[i + 1];
            maxScore = Math.max(score, maxScore);
        }
        return maxScore;
    }

    // O(n2)
    private int violate(int[] A) {
        int len = A.length;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = A[i] + A[j] + i - j;
                if (temp > sum) {
                    sum = temp;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxScoreSightseeingPair pair = new MaxScoreSightseeingPair();
        assertThat(pair.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6})).isEqualTo(11);

    }

}
