package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * @author Fuxin
 * @since 2021/5/7
 */
public class LongestPalindromeII {

    public String longestPalindrome(String s) {
        int len = s.length();
        String result = "";
        for (int i = 0; i < len; i++) {
            result = findStr(s, i, i, result);
            result = findStr(s, i - 1, i, result);
        }
        return result;
    }

    private String findStr(String s, int left, int right, String result) {
        int len = s.length();
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > result.length()) {
            return s.substring(left + 1, right);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestPalindromeII longestPalindromeII = new LongestPalindromeII();
        Assertions.assertThat(longestPalindromeII.longestPalindrome("babad")).isEqualTo("bab");
        Assertions.assertThat(longestPalindromeII.longestPalindrome("cbbd")).isEqualTo("bb");
        Assertions.assertThat(longestPalindromeII.longestPalindrome("ac")).isEqualTo("a");
        Assertions.assertThat(longestPalindromeII.longestPalindrome("a")).isEqualTo("a");
    }

}
