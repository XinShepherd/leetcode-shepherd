package io.github.xinshepherd;

/**
 * 75. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * @author Fuxin
 * @since 2020/5/8
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int[] colorNums = new int[3];
        for (int num : nums) {
            colorNums[num]++;
        }
        int j = 0;
        for (int i = 0; i < colorNums.length; i++) {
            for (int k = 0; k < colorNums[i]; k++) {
                nums[j++] = i;
            }
        }
    }

    public static void main(String[] args) {
        SortColors colors = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        colors.sortColors(nums);
        Util.printArray(nums);
    }
}
