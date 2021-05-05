package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 740. 删除并获得点数
 *
 * https://leetcode-cn.com/problems/delete-and-earn/
 *
 * @author Fuxin
 * @since 2021/5/5
 */
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }
        int len = Math.max(maxNum + 1, 4);
        int[] sums = new int[len];
        for (int num : nums) {
            sums[num] += num;
        }
        sums[2] = sums[2] + sums[0];
        for (int i = 3; i < len; i++) {
            sums[i] = Math.max(sums[i] + sums[i - 2], sums[i] + sums[i - 3]);
        }
        return Math.max(sums[len - 1], sums[len - 2]);
    }

    public static void main(String[] args) {
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        Assertions.assertThat(deleteAndEarn.deleteAndEarn(new int[]{3, 4, 2})).isEqualTo(6);
        Assertions.assertThat(deleteAndEarn.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4})).isEqualTo(9);
    }
}
