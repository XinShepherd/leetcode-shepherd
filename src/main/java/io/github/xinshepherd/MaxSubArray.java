package io.github.xinshepherd;

/**
 * 53. 最大子序和
 *
 * @author Fuxin
 * @since 2020/2/28 9:19
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int max = nums[0], sum = max;
        for (int i = 1; i < nums.length; i++) {
            // 负数时直接赋值
            if (sum <= 0 && sum < nums[i]) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{1, -2}));
        System.out.println(maxSubArray.maxSubArray(new int[]{-2}));
        System.out.println(maxSubArray.maxSubArray(new int[]{2, -3, 2, -1}));
        System.out.println(maxSubArray.maxSubArray(new int[]{2, -3, 2, -1, 2, -1, 1, 3}));
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
