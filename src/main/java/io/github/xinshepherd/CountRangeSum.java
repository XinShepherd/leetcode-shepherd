package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 327. 区间和的个数.
 *
 * https://leetcode-cn.com/problems/count-of-range-sum/
 */
public class CountRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            long sum = nums[i];
            if (sum >= lower && sum <= upper) {
                count++;
            }
            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountRangeSum countRangeSum = new CountRangeSum();
        assertThat(countRangeSum.countRangeSum(new int[]{-2, 5, -1}, -2, 2)).isEqualTo(3);
        assertThat(countRangeSum.countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864)).isEqualTo(3);
    }
}
