package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @author Fuxin
 * @since 2020/5/29
 */
public class Rob {

    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (i >= 3) {
                int temp = Math.max(dp[i - 2], dp[i - 3]);
                dp[i] = temp + num;

            } else if (i == 2) {
                dp[i] = dp[i - 2] + num;
            } else {
                dp[i] = num;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        assertThat(rob.rob(new int[]{1, 2, 3, 1})).isEqualTo(4);
        assertThat(rob.rob(new int[]{2, 7, 9, 3, 1})).isEqualTo(12);
    }

}
