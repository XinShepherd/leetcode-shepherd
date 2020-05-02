package io.github.xinshepherd;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author Fuxin
 * @since 2020/5/2
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> mapping = new HashMap<>();
        int length = s.length();
        for (int i = 0, current = -1; i < length; i++) {
            char c = s.charAt(i);
            int index;
            if (mapping.containsKey(c) && (index = mapping.get(c)) > current) {
                ans = Math.max(i - index, ans);
                current = index;
            } else {
                ans = Math.max(i - current, ans);
            }
            mapping.put(c, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
        assertThat(substring.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        assertThat(substring.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
        assertThat(substring.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
        assertThat(substring.lengthOfLongestSubstring("abc")).isEqualTo(3);
        assertThat(substring.lengthOfLongestSubstring("aabc")).isEqualTo(3);
        assertThat(substring.lengthOfLongestSubstring("aab")).isEqualTo(2);
        assertThat(substring.lengthOfLongestSubstring("cdd")).isEqualTo(2);
        assertThat(substring.lengthOfLongestSubstring("abba")).isEqualTo(2);
        assertThat(substring.lengthOfLongestSubstring("tmmzuxt")).isEqualTo(5);
    }

}
