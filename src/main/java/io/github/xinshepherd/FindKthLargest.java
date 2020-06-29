package io.github.xinshepherd;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author Fuxin
 * @since 2020/6/29
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
