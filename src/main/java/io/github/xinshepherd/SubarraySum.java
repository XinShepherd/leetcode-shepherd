package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * @author Fuxin
 * @since 2020/5/15
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            int prej = pre - k;
            if (map.containsKey(prej)) {
                count += map.get(prej);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum sum = new SubarraySum();
        Assertions.assertThat(sum.subarraySum(new int[]{1, 1, 1}, 2)).isEqualTo(2);
        Assertions.assertThat(sum.subarraySum2(new int[]{1, 1, 1}, 2)).isEqualTo(2);
    }

}
