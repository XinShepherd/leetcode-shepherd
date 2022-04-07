package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 38. 外观数列
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * @author Fuxin
 * @since 2020/2/25 9:58
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n <= 0)
            return "";
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = generate(result);
        }
        return result;
    }

    String generate(String prev) {
        StringBuilder builder = new StringBuilder();
        char temp = prev.charAt(0);
        int count = 0;
        for (int i = 0; i < prev.length(); i++) {
            if (prev.charAt(i) != temp) {
                builder.append(count).append(temp);
                temp = prev.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        builder.append(count).append(temp);
        return builder.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        Assertions.assertThat(countAndSay.countAndSay(0)).isEqualTo("");
        Assertions.assertThat(countAndSay.countAndSay(1)).isEqualTo("1");
        Assertions.assertThat(countAndSay.countAndSay(3)).isEqualTo("21");
        Assertions.assertThat(countAndSay.countAndSay(4)).isEqualTo("1211");
        Assertions.assertThat(countAndSay.countAndSay(5)).isEqualTo("111221");
        Assertions.assertThat(countAndSay.countAndSay(6)).isEqualTo("312211");
    }

}
