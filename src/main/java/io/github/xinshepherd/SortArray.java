package io.github.xinshepherd;

/**
 * 912. 排序数组
 *
 * @author Fuxin
 * @since 2020/3/31
 */
public class SortArray {

    public int[] sortArray(int[] nums) {
//        Arrays.sort(nums);
        quickSort(0, nums.length - 1, nums);
        return nums;
    }

    private void quickSort(int start, int end, int[] nums) {
        if (start >= end) {
            return;
        }
        int p = pivot(start, end, nums);
        quickSort(start, p - 1, nums);
        quickSort(p, end, nums);
    }

    private int pivot(int start, int end, int[] nums) {
        int value = nums[start];
        int left = start, right = end;
        while (left < right) {
            while (left < right && nums[left] <= value)
                left++;
            while (left < right && nums[right] > value)
                right--;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        if (nums[start] > nums[left]) {
            nums[start] = nums[left];
            nums[left] = value;
        }
        return left;
    }

    public static void main(String[] args) {
        SortArray sortArray = new SortArray();
        Util.printArray(sortArray.sortArray(new int[]{5, 2, 3, 1}));
        Util.printArray(sortArray.sortArray(new int[]{5, 1, 1, 2, 0, 0}));
        Util.printArray(sortArray.sortArray(new int[]{-7,-5,-4,4,-1,-1,7,0,0,9}));
    }
}
