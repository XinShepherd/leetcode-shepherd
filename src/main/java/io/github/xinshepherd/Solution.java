package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {

    public int longestSubStr(String str) {
        int length = str.length();
        if (length == 0) return 0;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        int end = 0;
        for (; end < length ;) {

            char c = str.charAt(end);
            if (map.containsKey(c)) {
                Integer index = map.get(c);
                max = Math.max(max, end - index);
            }
            map.put(c, end);
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Assertions.assertThat(solution.longestSubStr("abcabcbb")).isEqualTo(3);
        Assertions.assertThat(solution.longestSubStr("bbbbb")).isEqualTo(1);
        Assertions.assertThat(solution.longestSubStr("pwwkew")).isEqualTo(3);
    }
}
