package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 45. 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 *
 * @author Fuxin
 * @since 2020/5/4
 */
public class CanJumpII {

    public int jump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int lastIndex = length - 1;
        out:
        for (int i = 0; i < length; i++) {
            int count = nums[i];
            int current = dp[i] + 1;
            for (int j = 0; j < count; j++) {
                int index = i + j + 1;
                if (index < length) {
                    int min = dp[index];
                    if (min == 0) {
                        dp[index] = current;
                    }
                }
                if (index == lastIndex) {
                    break out;
                }
            }
        }
        return dp[length - 1];
    }

    public int jump2(int[] nums) {
        if (nums.length == 1)
            return 0;
        int len = nums.length;
        int maxLen = len - 1;
        int ans = 0;
        for (int i = 0; i < len; ) {
            int maxIndex = i + 1;
            int maxNum = 0;
            ans++;
            if (nums[i] + i >= maxLen) {
                break;
            }
            for (int k = 0, j = maxIndex; k < nums[i] && j < len; j++, k++) {
                int sum = j + nums[j];
                if (sum >= maxNum) {
                    maxNum = sum;
                    maxIndex = j;
                }
                if (sum >= maxLen) {
                    break;
                }
            }
            i = maxIndex;
        }
        return ans;
    }

    public static void main(String[] args) {
        CanJumpII canJumpII = new CanJumpII();
        assertThat(canJumpII.jump(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
        assertThat(canJumpII.jump2(new int[]{2, 3})).isEqualTo(1);
        assertThat(canJumpII.jump2(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
        assertThat(canJumpII.jump2(new int[]{2, 3, 1, 1, 1, 4})).isEqualTo(3);
        assertThat(canJumpII.jump2(new int[]{2, 3, 1, 1, 2, 4, 3})).isEqualTo(3);
        assertThat(canJumpII.jump2(new int[]{4, 1, 1, 3, 1, 1, 1})).isEqualTo(2);
    }
}
