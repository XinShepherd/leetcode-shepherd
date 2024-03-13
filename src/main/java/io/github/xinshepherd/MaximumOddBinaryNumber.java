package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/maximum-odd-binary-number/">2864. 最大二进制奇数</a>
 * @author Fuxin
 */
public class MaximumOddBinaryNumber {

    public String maximumOddBinaryNumber(String s) {
        int numOfOne = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                numOfOne++;
            }
        }
        numOfOne--;
        StringBuilder result = new StringBuilder(len);
        for (int i = 0; i < len - 1; i++) {
            if (numOfOne > 0) {
                numOfOne--;
                result.append('1');
            } else {
                result.append('0');
            }
        }
        result.append('1');
        return result.toString();
    }

    public static void main(String[] args) {
        MaximumOddBinaryNumber maximumOddBinaryNumber = new MaximumOddBinaryNumber();

        Assertions.assertThat(maximumOddBinaryNumber.maximumOddBinaryNumber("010")).isEqualTo("001");
        Assertions.assertThat(maximumOddBinaryNumber.maximumOddBinaryNumber("0101")).isEqualTo("1001");
    }

}
