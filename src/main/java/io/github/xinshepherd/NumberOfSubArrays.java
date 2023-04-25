package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 1248. 统计「优美子数组」
 *
 * @author Fuxin
 * @since 2020/4/21
 */
public class NumberOfSubArrays {
    public int numberOfSubarrays(int[] nums, int k) {
        boolean[] flags = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flags[i] = nums[i] % 2 == 1;
        }
        int ans = 0;
        int num = 0;
        int left = 0, leftIndex = 0, right = 0, rightIndex = 0;
        for (int i = 0; i < flags.length;) {
            if (num < k && flags[i]) {
                if (num == 0)
                    left = i;
                num++;
                if (num == k) {
                    right = i;
                }
            }
            if (num == k) {
                rightIndex = right + 1;
                while (rightIndex < flags.length && !flags[rightIndex]) {
                    rightIndex++;
                }
                int leftCount = left - leftIndex + 1;
                int rightCount = rightIndex - right;
                ans += leftCount * rightCount;
                right = rightIndex;
                i = right;
                left++;
                leftIndex = left;
                while (left < flags.length && !flags[left]) {
                    left++;
                }
            } else {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfSubArrays subArrays = new NumberOfSubArrays();
        Assertions.assertThat(subArrays.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3)).isEqualTo(2);
        Assertions.assertThat(subArrays.numberOfSubarrays(new int[]{2, 4, 6}, 3)).isEqualTo(0);
        Assertions.assertThat(subArrays.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2)).isEqualTo(16);
    }
}
