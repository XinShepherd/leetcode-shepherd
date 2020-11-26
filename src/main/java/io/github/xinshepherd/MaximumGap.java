package io.github.xinshepherd;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 164. 最大间距
 *
 * https://leetcode-cn.com/problems/maximum-gap/
 *
 * 应该用桶排 间距法
 *
 * @author Fuxin
 * @since 2020/11/26
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int ans = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(nums[i] - pre, ans);
            pre = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        assertThat(maximumGap.maximumGap(new int[]{3, 6, 9, 1})).isEqualTo(3);
    }
}
