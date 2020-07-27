package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 392. 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 *
 * @author Fuxin
 * @since 2020/7/27
 */
public class Subsequence {

    public boolean isSubsequence(String s, String t) {
        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();
        int i = 0;
        for (int j = 0; i < sChars.length && j < tChars.length; ) {
            if (sChars[i] == tChars[j]) {
                i++;
            }
            j++;
        }
        return i == sChars.length;
    }

    public static void main(String[] args) {
        Subsequence subsequence = new Subsequence();
        assertThat(subsequence.isSubsequence("", "abc")).isTrue();
        assertThat(subsequence.isSubsequence("abc", "ahbgdc")).isTrue();
        assertThat(subsequence.isSubsequence("axc", "ahbgdc")).isFalse();
    }

}
