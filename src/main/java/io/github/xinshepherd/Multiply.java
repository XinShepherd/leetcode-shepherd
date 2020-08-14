package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 43. 字符串相乘
 * https://leetcode-cn.com/problems/multiply-strings/
 *
 * @author Fuxin
 * @since 2020/8/13
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int len = m + n;
        int[] arr = new int[len];
        for (int i = m -1; i >= 0; i--) {
            int num = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                arr[i + j + 1] += (num2.charAt(j) - '0') * num;
            }
        }
        for (int i = len - 1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        int index = arr[0] == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        while (index < len) {
            sb.append(arr[index++]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        assertThat(multiply.multiply("2", "3")).isEqualTo("6");
        assertThat(multiply.multiply("123", "456")).isEqualTo("56088");
        assertThat(multiply.multiply("0", "456")).isEqualTo("0");
        assertThat(multiply.multiply("10", "0")).isEqualTo("0");
    }

}
