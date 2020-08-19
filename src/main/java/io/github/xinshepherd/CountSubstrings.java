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

    // 暴力破解
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

    // 中心扩展法
    public int countSubstrings2(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int count = 0;
        for (int i = 0; i < n * 2 - 1 ; i++) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < n && chars[l] == chars[r]) {
                l--;
                r++;
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        assertThat(countSubstrings.countSubstrings("")).isEqualTo(0);
        assertThat(countSubstrings.countSubstrings("abc")).isEqualTo(3);
        assertThat(countSubstrings.countSubstrings("aaa")).isEqualTo(6);
        assertThat(countSubstrings.countSubstrings2("")).isEqualTo(0);
        assertThat(countSubstrings.countSubstrings2("abc")).isEqualTo(3);
        assertThat(countSubstrings.countSubstrings2("aaa")).isEqualTo(6);
    }

}
