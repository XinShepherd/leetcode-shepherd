package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author Fuxin
 * @since 2020/7/20
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target)
                return new int[]{i + 1, j + 1};
            if (sum < target)
                i++;
            else
                j--;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        assertThat(twoSumII.twoSum(new int[]{2, 7, 11, 15}, 9)).isEqualTo(new int[]{1, 2});
        assertThat(twoSumII.twoSum(new int[]{2, 7, 11, 15}, 18)).isEqualTo(new int[]{2, 3});
        assertThat(twoSumII.twoSum(new int[]{2, 7, 11, 15}, 19)).isEqualTo(new int[]{});
        assertThat(twoSumII.twoSum(new int[]{2}, 19)).isEqualTo(new int[]{});
    }

}
