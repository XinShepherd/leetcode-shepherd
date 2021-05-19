package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/
 *
 * @author Fuxin
 * @since 2021/5/19
 */
public class JumpII2 {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dynamic(nums, dp, 0, nums[0], 0);
        return dp[nums.length - 1];
    }

    private void dynamic(int[] nums, int[] dp, int start, int num, int count) {
        for (int i = 0, index = start + 1; i < num && index < nums.length; i++, index++) {
            int current = count + 1;
            if (current < dp[index]) {
                dp[index] = current;
                dynamic(nums, dp, index, nums[index], current);
            }
        }
    }

    public static void main(String[] args) {
        JumpII2 jumpII2 = new JumpII2();
        Assertions.assertThat(jumpII2.jump(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
    }

}
