package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 97. 交错字符串
 * https://leetcode-cn.com/problems/interleaving-string/
 *
 * @author Fuxin
 * @since 2020/7/18
 */
public class Interleave {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        if (s1.length() == 0)
            return s2.equals(s3);
        if (s2.length() == 0)
            return s1.equals(s3);
        return helper(s1, s2, s3, 0, 0, 0);
    }

    boolean helper(String s1, String s2, String s3, int i1, int i2, int i3) {
        if (i3 == s3.length())
            return true;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            boolean result = helper(s1, s2, s3, i1 + 1, i2, i3 + 1);
            if (result)
                return true;
        }
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            return helper(s1, s2, s3, i1, i2 + 1, i3 + 1);
        }
        return false;
    }


    public static void main(String[] args) {
        Interleave interleave = new Interleave();
        assertThat(interleave.isInterleave("aabcc", "dbbca", "aadbbcbcac")).isTrue();
        assertThat(interleave.isInterleave("aabcc", "dbbca", "aadbbbaccc")).isFalse();
        assertThat(interleave.isInterleave("a", "", "a")).isTrue();
    }

}
