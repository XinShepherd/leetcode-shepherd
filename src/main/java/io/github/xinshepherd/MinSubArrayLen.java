package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @author Fuxin
 * @since 2020/6/28
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int i = 0, j = 1;
        int sum = nums[i];
        // 滑动窗口
        for (; i < len;) {
            // 移动左边界
            while (j < len && sum < s) {
                sum += nums[j++];
            }
            if (sum >= s) {
                min = Math.min(min, j - i);
                // 移动右边界
                sum -= nums[i++];
            } else {
                break;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        MinSubArrayLen len = new MinSubArrayLen();
        assertThat(len.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})).isEqualTo(2);
        assertThat(len.minSubArrayLen(8, new int[]{2, 3, 1, 2, 4, 3})).isEqualTo(3);
    }

}
