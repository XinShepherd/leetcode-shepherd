package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 1122. 数组的相对排序
 *
 * https://leetcode-cn.com/problems/relative-sort-array/
 *
 * @author Fuxin
 * @since 2020/11/14
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] nums = new int[1001];
        for (int j : arr1) {
            nums[j]++;
        }
        int[] ans = new int[arr1.length];
        int i = 0;
        for (int num : arr2) {
            int count = nums[num];
            for (int k = 0; k < count; k++) {
                ans[i++] = num;
            }
            nums[num] = 0;
        }
        for (int j = 0; j < nums.length; j++) {
            int count = nums[j];
            while (count > 0) {
                ans[i++] = j;
                count--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RelativeSortArray sortArray = new RelativeSortArray();
        Assertions.assertThat(sortArray.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}))
                .isEqualTo(new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19});
    }

}
