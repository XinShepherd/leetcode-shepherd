package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 面试题 08.03. 魔术索引
 * https://leetcode-cn.com/problems/magic-index-lcci/
 *
 * @author Fuxin
 * @since 2020/7/31
 */
public class FindMagicIndex {

    // 二分剪枝
    public int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    private int getAnswer(int[] nums, int left, int right) {
        if (left > right)
            return -1;
        int mid = (left + right) >> 1;
        int leftAns = getAnswer(nums, left, mid - 1);
        if (leftAns != -1) {
            return leftAns;
        }
        if (nums[mid] == mid){
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }

    // O(N)
    public int findMagicIndex2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMagicIndex findMagicIndex = new FindMagicIndex();
        assertThat(findMagicIndex.findMagicIndex(new int[]{0, 2, 3, 4, 5})).isEqualTo(0);
        assertThat(findMagicIndex.findMagicIndex(new int[]{1, 1, 1})).isEqualTo(1);
        assertThat(findMagicIndex.findMagicIndex(new int[]{2, 3, 4, 9})).isEqualTo(-1);
        assertThat(findMagicIndex.findMagicIndex2(new int[]{0, 2, 3, 4, 5})).isEqualTo(0);
        assertThat(findMagicIndex.findMagicIndex2(new int[]{1, 1, 1})).isEqualTo(1);
        assertThat(findMagicIndex.findMagicIndex2(new int[]{2, 3, 4, 9})).isEqualTo(-1);

    }

}
