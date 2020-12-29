package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 330. 按要求补齐数组
 *
 * https://leetcode-cn.com/problems/patching-array/
 *
 * @author Fuxin
 * @since 2020/12/29
 */
public class MinPatches {

    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int len = nums.length, index = 0;
        while (x <= n) {
            if (index < len && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        MinPatches minPatches = new MinPatches();
        assertThat(minPatches.minPatches(new int[]{1, 3}, 6)).isEqualTo(1);
        assertThat(minPatches.minPatches(new int[]{1, 5, 10}, 20)).isEqualTo(2);
        assertThat(minPatches.minPatches(new int[]{1, 2, 2}, 5)).isEqualTo(0);
    }

}
