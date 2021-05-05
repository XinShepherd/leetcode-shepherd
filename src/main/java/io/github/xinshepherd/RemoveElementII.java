package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 27. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author Fuxin
 * @since 2021/4/19
 */
public class RemoveElementII {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int currentIndex = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[currentIndex++] = nums[i];
            }
        }
        return currentIndex;
    }

    public static void main(String[] args) {
        RemoveElementII removeElementII = new RemoveElementII();
        int[] nums = {3, 2, 2, 3};
        int len = removeElementII.removeElement(nums, 3);
        Assertions.assertThat(nums).isEqualTo(new int[]{2, 2, 2, 3});
        Assertions.assertThat(len).isEqualTo(2);
        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        len = removeElementII.removeElement(nums, 2);
    }

}
