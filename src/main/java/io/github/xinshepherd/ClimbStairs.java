package io.github.xinshepherd;

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
        System.out.println(stairs.climbStairs(1));
        System.out.println(stairs.climbStairs(2));
        System.out.println(stairs.climbStairs(3));
        System.out.println(stairs.climbStairs(4));
    }

}
