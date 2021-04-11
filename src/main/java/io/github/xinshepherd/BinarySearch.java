package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 704. 二分查找
 *
 * @author Fuxin
 * @since 2020/3/5 10:54
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1); // 防止直接相加溢出
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid; // 因为只会有一次判断是否相等，大部分情况是不相等，放在最后
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        assertThat(binarySearch.search(nums, 3)).isEqualTo(2);
        assertThat(binarySearch.search(nums, 5)).isEqualTo(3);
        assertThat(binarySearch.search(nums, 6)).isEqualTo(-1);
        assertThat(binarySearch.search(nums, -1)).isEqualTo(0);
        assertThat(binarySearch.search2(nums, 5)).isEqualTo(3);
        assertThat(binarySearch.search2(nums, 6)).isEqualTo(-1);
        assertThat(binarySearch.search2(nums, -1)).isEqualTo(0);
    }
}
