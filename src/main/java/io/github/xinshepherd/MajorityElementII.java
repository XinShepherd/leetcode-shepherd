package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.10. 主要元素
 *
 * https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class MajorityElementII {

    // O(N) O(N)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int half = len / 2;
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            ++count;
            if (count > half)
                return num;
            map.put(num, count);
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count++;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        int half = nums.length / 2;
        int total = 0;
        for (int num : nums) {
            if (num == candidate) {
                total++;
                if (total > half)
                    return candidate;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElementII majorityElementII = new MajorityElementII();
        Assertions.assertThat(majorityElementII.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5})).isEqualTo(5);
        Assertions.assertThat(majorityElementII.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
        Assertions.assertThat(majorityElementII.majorityElement(new int[]{3, 2})).isEqualTo(-1);
        Assertions.assertThat(majorityElementII.majorityElement2(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5})).isEqualTo(5);
        Assertions.assertThat(majorityElementII.majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
        Assertions.assertThat(majorityElementII.majorityElement2(new int[]{3, 2})).isEqualTo(-1);
    }

}
