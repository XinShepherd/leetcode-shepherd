package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 面试题 01.06. 字符串压缩
 *
 * https://leetcode-cn.com/problems/compress-string-lcci/
 *
 * @author Fuxin
 * @since 2020/3/16 8:57
 */
public class CompressString {

    public String compressString(String S) {
        if (S == null || S.length() <= 2) {
            return S;
        }
        char current = S.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < S.length(); i++) {
            if (current == S.charAt(i)) {
                count++;
            } else {
                sb.append(current).append(count);
                current = S.charAt(i);
                count = 1;
            }
        }
        sb.append(current).append(count);
        if (sb.length() < S.length()) {
            return sb.toString();
        }
        return S;
    }

    public static void main(String[] args) {
        CompressString compressString = new CompressString();
        Assertions.assertThat(compressString.compressString("")).isEqualTo("");
        Assertions.assertThat(compressString.compressString("a")).isEqualTo("a");
        Assertions.assertThat(compressString.compressString("abc")).isEqualTo("abc");
        Assertions.assertThat(compressString.compressString("aaa")).isEqualTo("a3");
        Assertions.assertThat(compressString.compressString("aabcccccaaa")).isEqualTo("a2b1c5a3");
        Assertions.assertThat(compressString.compressString("abbccd")).isEqualTo("abbccd");
    }

}
