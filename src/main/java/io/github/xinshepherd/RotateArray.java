package io.github.xinshepherd;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 189. 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @author Fuxin
 * @since 2021/1/8
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int[] temp = Arrays.copyOfRange(nums, len - k, len);
        for (int i = len - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, k);
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(array, 3);
        assertThat(array).isEqualTo(new int[]{5, 6, 7, 1, 2, 3, 4});
        array = new int[]{-1, -100, 3, 99};
        rotateArray.rotate(array, 2);
        assertThat(array).isEqualTo(new int[]{3, 99, -1, -100});
        array = new int[]{-1, -100, 3, 99};
        rotateArray.rotate(array, 6);
        assertThat(array).isEqualTo(new int[]{3, 99, -1, -100});
        array = new int[]{-1, -100, 3, 99};
        rotateArray.rotate2(array, 2);
        assertThat(array).isEqualTo(new int[]{3, 99, -1, -100});
        array = new int[]{-1, -100, 3, 99};
        rotateArray.rotate2(array, 6);
        assertThat(array).isEqualTo(new int[]{3, 99, -1, -100});

    }

}
