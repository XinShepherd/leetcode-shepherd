package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 389. 找不同
 *
 * https://leetcode-cn.com/problems/find-the-difference/
 *
 * @author Fuxin
 * @since 2020/12/18
 */
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        char ans = 0;
        for (char c : sChars) {
            ans ^= c;
        }
        for (char c : tChars) {
            ans ^= c;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindTheDifference findTheDifference = new FindTheDifference();
        assertThat(findTheDifference.findTheDifference("abcd", "abcde")).isEqualTo('e');
        assertThat(findTheDifference.findTheDifference("", "y")).isEqualTo('y');
        assertThat(findTheDifference.findTheDifference("a", "aa")).isEqualTo('a');

    }

}
