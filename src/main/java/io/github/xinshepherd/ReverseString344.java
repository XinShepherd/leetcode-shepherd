package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 344. 反转字符串
 * <p>
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * @author Fuxin
 * @since 2020/10/8
 */
public class ReverseString344 {

    public void reverseString(char[] s) {
        if (s == null)
            return;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseString344 reverseString344 = new ReverseString344();
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString344.reverseString(chars);
        assertThat(chars).isEqualTo(new char[]{'o', 'l', 'l', 'e', 'h'});
    }
}
