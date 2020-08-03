package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 415. 字符串相加
 * https://leetcode-cn.com/problems/add-strings/
 *
 * @author Fuxin
 * @since 2020/8/3
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int step = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = chars1.length - 1, j = chars2.length -1; i >= 0 || j >= 0;) {
            int sum = step;
            if (i >= 0) {
                sum += chars1[i] - '0';
                i--;
            }
            if (j >= 0) {
                sum += chars2[j] - '0';
                j--;
            }
            sb.append(sum % 10);
            step = sum / 10;
        }
        // 处理进位
        if (step > 0) {
            sb.append(step);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        assertThat(addStrings.addStrings("12", "2")).isEqualTo("14");
        assertThat(addStrings.addStrings("12", "9")).isEqualTo("21");
        assertThat(addStrings.addStrings("0", "0")).isEqualTo("0");
    }

}
