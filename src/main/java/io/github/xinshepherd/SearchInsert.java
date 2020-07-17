package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 35. 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author Fuxin
 * @since 2020/7/17
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;

        }
        return nums[left] >= target ? left : left + 1;
    }

    public static void main(String[] args) {
        SearchInsert insert = new SearchInsert();
        assertThat(insert.searchInsert(new int[]{1, 3, 5, 6}, 5)).isEqualTo(2);
        assertThat(insert.searchInsert(new int[]{1, 3, 5, 6}, 2)).isEqualTo(1);
        assertThat(insert.searchInsert(new int[]{1, 3, 5, 6}, 7)).isEqualTo(4);
        assertThat(insert.searchInsert(new int[]{1, 3, 5, 6}, 0)).isEqualTo(0);
        assertThat(insert.searchInsert(new int[]{1}, 1)).isEqualTo(0);
    }

}
