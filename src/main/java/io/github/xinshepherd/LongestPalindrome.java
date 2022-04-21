package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 409. 最长回文串
 * https://leetcode-cn.com/problems/longest-palindrome/
 *
 * @author Fuxin
 * @since 2020/3/19 9:06
 */
public class LongestPalindrome {

    int sum = 0;

    public int longestPalindrome(String s) {
        sum = 0;
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a') {
                lower[c - 'a']++;
            } else {
                upper[c - 'A']++;
            }
        }
        boolean hasSingle = hasSingle(lower) | hasSingle(upper);
        return hasSingle ? sum + 1 : sum;
    }

    boolean hasSingle(int[] ascii) {
        boolean hasSingle = false;
        for (int i = 0; i < ascii.length; i++) {
            if (ascii[i] > 0) {
                if (ascii[i] % 2 == 1) {
                    hasSingle = true;
                    ascii[i]--;
                }
                sum += ascii[i];
            }
        }
        return hasSingle;
    }


    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        Assertions.assertThat(longestPalindrome.longestPalindrome("abccccdd")).isEqualTo(7);
        Assertions.assertThat(longestPalindrome.longestPalindrome("ccccccAAccBB")).isEqualTo(12);
        Assertions.assertThat(longestPalindrome.longestPalindrome("adam")).isEqualTo(3);
    }

}
