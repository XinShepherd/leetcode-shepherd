package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * @author Fuxin
 * @since 2020/8/19
 */
public class CountSubstrings {

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (isEchoString(chars, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean isEchoString(char[] chars, int left, int right) {
        while (left <= right) {
            if (chars[left++] != chars[right--])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        assertThat(countSubstrings.countSubstrings("")).isEqualTo(0);
        assertThat(countSubstrings.countSubstrings("abc")).isEqualTo(3);
        assertThat(countSubstrings.countSubstrings("aaa")).isEqualTo(6);
    }

}
