package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 696. 计数二进制子串
 * https://leetcode-cn.com/problems/count-binary-substrings/
 *
 * @author Fuxin
 * @since 2020/8/10
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int count = 0;
        for (int i = 0; i < len;) {
            char c = chars[i++];
            int current = 1;
            while (i < len && chars[i] == c) {
                current++;
                i++;
            }
            int other = 0;
            int j = i;
            while (other < current && j < len && chars[j] != c) {
                other++;
                j++;
            }
            count += other;
        }
        return count;
    }

    public static void main(String[] args) {
        CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();
        assertThat(countBinarySubstrings.countBinarySubstrings("00110011")).isEqualTo(6);
        assertThat(countBinarySubstrings.countBinarySubstrings("")).isEqualTo(0);
        assertThat(countBinarySubstrings.countBinarySubstrings("10101")).isEqualTo(4);
        assertThat(countBinarySubstrings.countBinarySubstrings("01")).isEqualTo(1);
    }

}
