package io.github.xinshepherd;

import java.util.HashMap;
import java.util.Map;

// 1. 两数之和
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(num, i);
            }
        }
        return null;
    }
}
