package io.github.xinshepherd;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. 数组中两个数的最大异或值
 *
 * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 *
 */
public class FindMaximumXOR {

    public int findMaximumXOR(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, num ^ nums[j]);
            }
        }
        return max;
    }

    // Hash
    // 利用 x = a ^ b => a = x ^ b;
    public int findMaximumXOR2(int[] nums) {
        int x = 0;
        // 从高位开始
        for (int i = 30; i >= 0; i--) {
            Set<Integer> seen = new HashSet<>();
            for (int num : nums) {
                seen.add(num >> i);
            }

            int xNext = x * 2 + 1;
            boolean found = false;
            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> i))) {
                    found = true;
                    break;

                }
            }
            if (found) {
                x = xNext;
            } else {
                x = xNext - 1;
            }

        }
        return x;
    }

}
