package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 *
 * @author Fuxin
 * @since 2020/9/2
 */
public class IsNumber {

    public boolean isNumber(String s) {
        try {
            if (s.charAt(s.length() - 1) - '9' > 0)
                return false;

            Double.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();
        assertThat(isNumber.isNumber("+100")).isTrue();
        assertThat(isNumber.isNumber("5e2")).isTrue();
        assertThat(isNumber.isNumber("-123")).isTrue();
        assertThat(isNumber.isNumber("3.1416")).isTrue();
        assertThat(isNumber.isNumber("-1E-16")).isTrue();
        assertThat(isNumber.isNumber("0123")).isTrue();

        assertThat(isNumber.isNumber("12e")).isFalse();
        assertThat(isNumber.isNumber("1a3.14")).isFalse();
        assertThat(isNumber.isNumber("1.2.3")).isFalse();
        assertThat(isNumber.isNumber("+-5")).isFalse();
        assertThat(isNumber.isNumber("12e+5.4")).isFalse();
        assertThat(isNumber.isNumber("959440.94f")).isFalse();

    }
}
