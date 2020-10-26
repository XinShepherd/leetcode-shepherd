package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1365. 有多少小于当前数字的数字
 *
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * @author Fuxin
 * @since 2020/10/26
 */
public class SmallerNumbersThanCurrent {

    // 暴力破解法 O(n2)
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            int count = 0;
            for (int k : nums) {
                if (k < num) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    // 改进 O(n)
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int len = nums.length;
        int[] ints = new int[101];
        for (int num : nums) {
            ints[num]++;
        }
        int temp = ints[0];
        ints[0] = 0;
        for (int i = 1; i < ints.length; i++) {
            int sum = ints[i - 1] + temp;
            temp = ints[i];
            ints[i] = sum;
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = ints[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        SmallerNumbersThanCurrent smallerNumbersThanCurrent = new SmallerNumbersThanCurrent();
        assertThat(smallerNumbersThanCurrent.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3}))
                .isEqualTo(new int[]{4, 0, 1, 1, 3});
        assertThat(smallerNumbersThanCurrent.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8}))
                .isEqualTo(new int[]{2, 1, 0, 3});
        assertThat(smallerNumbersThanCurrent.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7}))
                .isEqualTo(new int[]{0, 0, 0, 0});
        assertThat(smallerNumbersThanCurrent.smallerNumbersThanCurrent2(new int[]{8, 1, 2, 2, 3}))
                .isEqualTo(new int[]{4, 0, 1, 1, 3});
        assertThat(smallerNumbersThanCurrent.smallerNumbersThanCurrent2(new int[]{6, 5, 4, 8}))
                .isEqualTo(new int[]{2, 1, 0, 3});
        assertThat(smallerNumbersThanCurrent.smallerNumbersThanCurrent2(new int[]{7, 7, 7, 7}))
                .isEqualTo(new int[]{0, 0, 0, 0});
        assertThat(smallerNumbersThanCurrent.smallerNumbersThanCurrent2(new int[]{5, 0, 10, 0, 10, 6}))
                .isEqualTo(new int[]{2,0,4,0,4,3});
    }

}
