package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 面试题 17.16. 按摩师
 *
 * @author Fuxin
 * @since 2020/3/24 9:02
 */
public class Massage {
    public int massage(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        if (nums.length < 3) {
            for (int num : nums) {
                max = Math.max(num, max);
            }
            return max;
        }
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + dp[0];
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], nums[i] + dp[i - 3]);
            max = Math.max(dp[i], max);
        }
        for (int num : dp) {
            max = Math.max(num, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Massage massage = new Massage();
        Assertions.assertThat(massage.massage(new int[]{1, 2, 3, 1})).isEqualTo(4);
        Assertions.assertThat(massage.massage(new int[]{2, 7, 9, 3, 1})).isEqualTo(12);
        Assertions.assertThat(massage.massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3})).isEqualTo(12);
    }


}
