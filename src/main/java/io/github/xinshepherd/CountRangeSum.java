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

    // 归并
    public int countRangeSum2(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            sum[i + 1] = s;
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = (int) sum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = (int) sum[p1++];
                } else {
                    if (sum[p1] < sum[p2]) {
                        sorted[p++] = (int) sum[p1++];
                    } else {
                        sorted[p++] = (int) sum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        CountRangeSum countRangeSum = new CountRangeSum();
        assertThat(countRangeSum.countRangeSum(new int[]{-2, 5, -1}, -2, 2)).isEqualTo(3);
        assertThat(countRangeSum.countRangeSum2(new int[]{-2, 5, -1}, -2, 2)).isEqualTo(3);
        assertThat(countRangeSum.countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864)).isEqualTo(3);
    }
}
