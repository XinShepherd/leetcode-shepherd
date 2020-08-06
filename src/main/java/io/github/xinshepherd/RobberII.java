package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 *
 * @author Fuxin
 * @since 2020/8/6
 */
public class RobberII {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        // 打劫第一家和不打劫第一家的最大值
        int ans = getSum(0, len - 1, nums);
        return Math.max(ans, getSum(1, len, nums));
    }

    private int getSum(int start, int end, int[] nums) {
        // 滚动数组
        int first = 0, second = 0, third = 0;
        for (int i = start; i < end; i++) {
            int sum = Math.max(nums[i] + first, nums[i] + second);
            first = second;
            second = third;
            third = sum;
        }
        return Math.max(second, third);
    }

    public static void main(String[] args) {
        RobberII robberII = new RobberII();
        assertThat(robberII.rob(new int[]{2, 3, 2})).isEqualTo(3);
        assertThat(robberII.rob(new int[]{1, 2, 3, 1})).isEqualTo(4);
        assertThat(robberII.rob(new int[]{1, 2})).isEqualTo(2);
        assertThat(robberII.rob(new int[]{1})).isEqualTo(1);
        assertThat(robberII.rob(new int[]{2, 7, 9, 3, 1})).isEqualTo(11);
    }

}
