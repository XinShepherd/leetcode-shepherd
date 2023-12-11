package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 1071. 字符串的最大公因子
 *
 * @author Fuxin
 * @since 2020/3/12 10:25
 */
public class GcdOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if (str2.length() == 0 || str1.length() == 0)
            return "";
        String temp;
        if (str1.length() < str2.length()) {
            temp = str1;
            str1 = str2;
            str2 = temp;
        }
        for (int step = 1; step <= str2.length(); ) {
            String sub = subString(str2, step);
            if ("".equals(sub))
                return "";
            if (str1.length() % sub.length() == 0) {
                boolean allEqual = isAllEqual(sub.length(), str1, sub, str1.length());
                if (allEqual)
                    return sub;
            }
            step = str2.length() / sub.length() + 1;
        }
        return "";
    }

    private String subString(String str, int step) {
        int len = str.length();
        for (; step < len; step ++) {
            if (len % step != 0) {
                continue;
            }
            int subLen = len / step;
            String s = str.substring(0, subLen);
            boolean allEqual = isAllEqual(subLen, str, s, len);
            if (!allEqual) continue;
            return s;
        }
        return "";
    }

    private boolean isAllEqual(int subLen, String str, String sub, int len) {
        for (int i = 0; i < len; i += subLen) {
            if (!str.substring(i, i + subLen).equals(sub)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GcdOfStrings gcdOfStrings = new GcdOfStrings();
        Assertions.assertThat(gcdOfStrings.gcdOfStrings("ABCABC", "ABC")).isEqualTo("ABC");
        Assertions.assertThat(gcdOfStrings.gcdOfStrings("ABABAB", "ABAB")).isEqualTo("AB");
        Assertions.assertThat(gcdOfStrings.gcdOfStrings("LEET", "CODE")).isEqualTo("");
        Assertions.assertThat(gcdOfStrings.gcdOfStrings("", "CODE")).isEqualTo("");
    }


}
