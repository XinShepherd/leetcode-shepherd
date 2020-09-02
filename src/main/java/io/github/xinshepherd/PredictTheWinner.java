package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 486. 预测赢家
 * https://leetcode-cn.com/problems/predict-the-winner/
 *
 * @author Fuxin
 * @since 2020/9/1
 */
public class PredictTheWinner {

    public boolean predictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int startTotal = nums[start] * turn + total(nums, start + 1, end, -turn);
        int endTotal = nums[end] * turn + total(nums, start, end - 1, -turn);
        return Math.max(startTotal * turn, endTotal * turn) * turn;
    }

    public boolean predictTheWinner2(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len - 1; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }

    public static void main(String[] args) {
        PredictTheWinner predictTheWinner = new PredictTheWinner();
        assertThat(predictTheWinner.predictTheWinner(new int[]{1, 5, 2})).isFalse();
        assertThat(predictTheWinner.predictTheWinner(new int[]{1, 5, 233, 7})).isTrue();

        assertThat(predictTheWinner.predictTheWinner2(new int[]{1, 5, 2})).isFalse();
        assertThat(predictTheWinner.predictTheWinner2(new int[]{1, 5, 233, 7})).isTrue();
    }

}
