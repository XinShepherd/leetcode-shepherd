package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 70. 爬楼梯
 *
 * @author Fuxin
 * @since 2020/4/13
 */
public class ClimbStairs {

    int count = 0;

    public int climbStairs(int n) {
        return dynamicPrograming(n);
    }

    void helper(int n, int current) {
        if (current > n) return;
        if (current == n) {
            count++;
            return;
        }
        helper(n, current + 1);
        helper(n, current + 2);
    }

    int dynamicPrograming(int n) {
        if (n < 3)
            return n;
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    public static void main(String[] args) {
        ClimbStairs stairs = new ClimbStairs();
        Assertions.assertThat(stairs.climbStairs(1)).isEqualTo(1);
        Assertions.assertThat(stairs.climbStairs(2)).isEqualTo(2);
        Assertions.assertThat(stairs.climbStairs(3)).isEqualTo(3);
        Assertions.assertThat(stairs.climbStairs(4)).isEqualTo(5);
    }

}
