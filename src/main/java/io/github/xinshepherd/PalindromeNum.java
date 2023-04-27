package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 9. 回文数
 *
 * @author Fuxin
 * @since 2020/3/6 8:36
 */
public class PalindromeNum {

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int sum = 0, temp = x;
        while (temp > 0) {
            sum = sum * 10 + temp % 10;
            temp = temp / 10;
        }
        return x == sum;
    }

    public static void main(String[] args) {
        PalindromeNum palindromeNum = new PalindromeNum();
        Assertions.assertThat(palindromeNum.isPalindrome(121)).isEqualTo(true);
        Assertions.assertThat(palindromeNum.isPalindrome(-121)).isEqualTo(false);
        Assertions.assertThat(palindromeNum.isPalindrome(0)).isEqualTo(true);
        Assertions.assertThat(palindromeNum.isPalindrome(10)).isEqualTo(false);
    }
}
