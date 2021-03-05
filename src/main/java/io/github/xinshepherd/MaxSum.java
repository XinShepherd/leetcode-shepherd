package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * 假设有32,-40,60,25,-54,59,98,-92,-22,85十个数组成的数组a[10]。请用算法求出a[10]中sum(n,m)的最大值以及对应的n和m分别是多少,并写出对应的解题思路。
 * 说明：sum(n,m)表示数组从a[n]到a[m]的和。
 * 例如：sum(0,2)=32 +(-40)+60=52,sum(1,3)=(-40)+60+25=45。
 *
 * @author Fuxin
 * @since 2021/3/4
 */
public class MaxSum {

    int maxSum(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int n = 0, m = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (sum >= max) {
                n = start;
                m = i;
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        System.out.println("n:" + n + " ,m:" + m);
        return max;
    }

    public static void main(String[] args) {
        MaxSum maxSum = new MaxSum();
        assertThat(maxSum.maxSum(new int[]{32, -40, 60, 25, -54, 59, 98, -92, -22, 85})).isEqualTo(188);
        assertThat(maxSum.maxSum(new int[]{-1, -40, -2, -3, -54, -4, -5, -92, -22, -6})).isEqualTo(-1);
        assertThat(maxSum.maxSum(new int[]{-1, -40, -2, -3, -54, 0, -5, 6, -22, -6})).isEqualTo(6);
        assertThat(maxSum.maxSum(new int[]{-1, -40, -2, -3, -54, 6, -5, 6, -22, -6})).isEqualTo(7);
    }
}
