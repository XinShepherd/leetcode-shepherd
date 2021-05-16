package io.github.xinshepherd;

/**
 * 4. 寻找两个正序数组的中位数
 * <p>
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArraysII {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 方便我们后续编码，防止脚标越界
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;

        int totalLeft = (n + m + 1) / 2;

        int left = 0;
        int right = m;

        // 分割线需要满足num1[i - 1] <= num2[j] && num[j - 1] <= num[i]
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - i;


        // 处理边界
        int num1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int num2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int num2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
        if ((n + m) % 2 == 1) {
            return Math.max(num1LeftMax, num2LeftMax);
        } else {
            return (Math.max(num1LeftMax, num2LeftMax) + (double) Math.min(num1RightMin, num2RightMin)) / 2;
        }
    }

}
