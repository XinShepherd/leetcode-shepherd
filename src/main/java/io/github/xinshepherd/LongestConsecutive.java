package io.github.xinshepherd;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 128. 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 * @author Fuxin
 * @since 2020/6/6
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num))
                continue;
            int count = 0;
            for (int i = num; i < Integer.MAX_VALUE; i++) {
                if (!set.remove(i))
                    break;
                count++;
            }
            for (int i = num - 1; i > Integer.MIN_VALUE; i--) {
                if (!set.remove(i))
                    break;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutive consecutive = new LongestConsecutive();
        assertThat(consecutive.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})).isEqualTo(4);
    }
}
