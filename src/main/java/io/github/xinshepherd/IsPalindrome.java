package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 * @author Fuxin
 * @since 2020/6/20
 */
public class IsPalindrome {

    public final static int DISTANCE = 'a' - 'A';

    public final static char[] mapping = init();

    private static char[] init() {
        char[] mapping = new char[127];
        for (char i = 'a'; i <= 'z'; i++) {
            mapping[i] = i;
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            mapping[i] = (char) (i + DISTANCE);
        }
        for (char i = '0'; i <= '9'; i++) {
            mapping[i] = i;
        }
        return mapping;
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0, j = len - 1; i < len && j >=0;) {
            char start = 0;
            while (i < len && (start = mapping[chars[i++]]) == 0);
            char end = 0;
            while (j >= 0 && (end = mapping[chars[j--]]) == 0);
            if (end != start)
                return false;
            if (i > j)
                return true;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        StringBuilder stringBuilder = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = isValid(s.charAt(i));
            if (c != 0) {
                stringBuilder.append(c);
            }
        }
        int len = stringBuilder.length();
        if (len == 0) {
            return true;
        }
        boolean odd = len % 2 == 1;
        int left = odd ? len / 2 - 1 : len / 2 - 1;
        int right = odd ? len / 2 + 1 : len / 2;
        while (left >= 0 && right < len) {
            if (stringBuilder.charAt(left--) != stringBuilder.charAt(right++))
                return false;
        }
        return true;
    }

    char isValid(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return c;
        }
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + DISTANCE);
        }
        return 0;
    }

    public static void main(String[] args) {
        IsPalindrome palindrome = new IsPalindrome();
        assertThat(palindrome.isPalindrome("A man, a plan, a canal: Panama")).isTrue();
        assertThat(palindrome.isPalindrome("race a car")).isFalse();
        assertThat(palindrome.isPalindrome(" ")).isTrue();
        assertThat(palindrome.isPalindrome("a")).isTrue();
        assertThat(palindrome.isPalindrome("aa")).isTrue();
        assertThat(palindrome.isPalindrome("ab")).isFalse();
    }
}
