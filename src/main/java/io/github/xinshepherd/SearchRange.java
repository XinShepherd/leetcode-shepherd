package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author Fuxin
 * @since 2020/12/1
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (start == -1)
                    start = i;
                end = i;
            }
        }
        return new int[]{start, end};
    }

    public int[] searchRange2(int[] nums, int target) {
        int left = 0, right = nums.length;
        int index = -1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int start = index, end = index;
        while (start > 0 && nums[start] == nums[start - 1])  {
            start--;
        }
        while (end >= 0 && end < nums.length - 1 && nums[end] == nums[end + 1]) {
            end++;
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        assertThat(searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).isEqualTo(new int[]{3, 4});
        assertThat(searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)).isEqualTo(new int[]{-1, -1});
        assertThat(searchRange.searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 8)).isEqualTo(new int[]{3, 4});
        assertThat(searchRange.searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 6)).isEqualTo(new int[]{-1, -1});
    }
}
