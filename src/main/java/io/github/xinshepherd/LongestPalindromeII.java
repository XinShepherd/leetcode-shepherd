package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 5. 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author Fuxin
 * @since 2021/5/7
 */
public class LongestPalindromeII {

    int left = -1;
    int right = -1;
    int max = 0;
    public String longestPalindrome(String s) {
        int len = s.length();
        left = -1;
        right = -1;
        max = 0;
        for (int i = 0; i < len; i++) {
            findStr(s, i, i);
            findStr(s, i - 1, i);
        }
        return left == -1 ? "" : s.substring(left, right);
    }

    private void findStr(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > max) {
            this.left = left + 1;
            this.right = right;
            this.max = right - left - 1;
        }
    }

    public static void main(String[] args) {
        LongestPalindromeII longestPalindromeII = new LongestPalindromeII();
        Assertions.assertThat(longestPalindromeII.longestPalindrome("babad")).isEqualTo("bab");
        Assertions.assertThat(longestPalindromeII.longestPalindrome("cbbd")).isEqualTo("bb");
        Assertions.assertThat(longestPalindromeII.longestPalindrome("ac")).isEqualTo("a");
        Assertions.assertThat(longestPalindromeII.longestPalindrome("a")).isEqualTo("a");
    }

}
