package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 283. 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroesII {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                temp[i++] = num;
            }
        }
        for (int j = 0; j < len; j++) {
            nums[j] = temp[j];
        }
    }

    public void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        MoveZeroesII moveZeroesII = new MoveZeroesII();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroesII.moveZeroes(nums);
        Assertions.assertThat(nums).isEqualTo(new int[]{1, 3, 12, 0, 0});
        int[] nums2 = {0, 1, 0, 3, 12};
        moveZeroesII.moveZeroes2(nums2);
        Assertions.assertThat(nums2).isEqualTo(new int[]{1, 3, 12, 0, 0});
        int[] num3 = {1, 0};
        moveZeroesII.moveZeroes2(num3);
        Assertions.assertThat(num3).isEqualTo(new int[]{1, 0});
    }

}
