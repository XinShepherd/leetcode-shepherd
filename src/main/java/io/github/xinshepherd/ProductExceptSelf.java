package io.github.xinshepherd;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 *
 * @author Fuxin
 * @since 2020/6/4
 */
public class ProductExceptSelf {

    // O(n) 空间复杂度 O(n) 时间复杂度
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0)
            return nums;
        int len = nums.length;
        int[] dp = new int[len];
        int[] ans = new int[len];
        dp[len - 1] = nums[len - 1] - 1;
        ans[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            ans[i] = nums[i] * ans[i + 1];
            dp[i] = (nums[i] - 1) * ans[i + 1];
        }
        int leftProduct = 1;
        for (int i = 0; i < len; i++) {
            ans[i] = (ans[i] - dp[i]) * leftProduct;
            leftProduct *= nums[i];
        }
        return ans;
    }

    // O(1) 空间复杂度 O(n) 时间复杂度
    public int[] productExceptSelf2(int[] nums) {
        if (nums.length == 0)
            return nums;
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, 1);
        int product = 1;
        for (int i = 0; i < len; i++) {
            ans[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] *= product;
            product *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        ProductExceptSelf self = new ProductExceptSelf();
        assertThat(self.productExceptSelf2(new int[]{1, 2, 3, 4})).isEqualTo(new int[]{24, 12, 8, 6});
        assertThat(self.productExceptSelf2(new int[]{1, 0, 3, 4})).isEqualTo(new int[]{0, 12, 0, 0});
        assertThat(self.productExceptSelf2(new int[]{1, -1, 3, 4})).isEqualTo(new int[]{-12, 12, -4, -3});
    }

}
