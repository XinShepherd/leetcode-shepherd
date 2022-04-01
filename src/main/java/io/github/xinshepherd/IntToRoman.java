package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 12 整数转罗马数字
 *
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class IntToRoman {

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        Assertions.assertThat(intToRoman.intToRoman(3)).isEqualTo("III");
        Assertions.assertThat(intToRoman.intToRoman(4)).isEqualTo("IV");
        Assertions.assertThat(intToRoman.intToRoman(9)).isEqualTo("IX");
        Assertions.assertThat(intToRoman.intToRoman(58)).isEqualTo("LVIII");
        Assertions.assertThat(intToRoman.intToRoman(1994)).isEqualTo("MCMXCIV");
    }
}
