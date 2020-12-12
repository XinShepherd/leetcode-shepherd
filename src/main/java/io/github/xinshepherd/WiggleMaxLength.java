package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 376. 摆动序列
 *
 * https://leetcode-cn.com/problems/wiggle-subsequence/
 *
 * @author Fuxin
 * @since 2020/12/12
 */
public class WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        boolean up = true;
        int count = 0;
        int ans = 1;
        int current = nums[0];
        for (int num : nums) {
            int diff = num - current;
            diff = up ? diff : -diff;
            if (diff > 0) {
                if (count == 0) {
                    ans++;
                }
                count++;
            } else if (diff < 0) {
                count = 2;
                ans++;
                up = !up;
            }
            current = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        WiggleMaxLength wiggleMaxLength = new WiggleMaxLength();
        assertThat(wiggleMaxLength.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5})).isEqualTo(6);
        assertThat(wiggleMaxLength.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8})).isEqualTo(7);
        assertThat(wiggleMaxLength.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})).isEqualTo(2);
        assertThat(wiggleMaxLength.wiggleMaxLength(new int[]{1, 1, 1})).isEqualTo(1);
    }

}
