package io.github.xinshepherd;

/**
 * 704. 二分查找
 *
 * @author Fuxin
 * @since 2020/3/5 10:54
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch.search(nums, 3));
        System.out.println(binarySearch.search(nums, 5));
        System.out.println(binarySearch.search(nums, 6));
        System.out.println(binarySearch.search(nums, -1));
    }
}
