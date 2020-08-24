package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 459. 重复的子字符串
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 *
 * @author Fuxin
 * @since 2020/8/24
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len <= 1)
            return false;
        char delimiter = s.charAt(0);
        int half = len >> 1;
        for (int i = 1; i <= half; i++) {
            if (s.charAt(i) == delimiter && len % i == 0) {
                String base = s.substring(0, i);
                boolean flag = true;
                for (int j = i; j + i <= len; j += i) {
                    if (!base.equals(s.substring(j, j + i))) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern pattern = new RepeatedSubstringPattern();
        assertThat(pattern.repeatedSubstringPattern("abab")).isTrue();
        assertThat(pattern.repeatedSubstringPattern("aba")).isFalse();
        assertThat(pattern.repeatedSubstringPattern("abcabcabcabc")).isTrue();
        assertThat(pattern.repeatedSubstringPattern("ababba")).isFalse();
        assertThat(pattern.repeatedSubstringPattern("aabaaba")).isFalse();
    }


}
