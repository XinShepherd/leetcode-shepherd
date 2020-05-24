package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author Fuxin
 * @since 2020/5/24
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if (len == 0)
            return 0;
        int[] nums = new int[len];
        int i = 0, j = 0;
        int k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < len1) {
            nums[k++] = nums1[i++];
        }
        while (j < len2) {
            nums[k++] = nums2[j++];
        }
        int mid = len / 2;
        if (nums.length % 2 == 0) {
            return (nums[mid] + nums[mid - 1]) / 2d;
        } else {
            return nums[mid];
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays sortedArrays = new FindMedianSortedArrays();
        assertThat(sortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2})).isEqualTo(2);
        assertThat(sortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})).isEqualTo(2.5);
        assertThat(sortedArrays.findMedianSortedArrays(new int[]{1}, new int[]{})).isEqualTo(1);

    }
}