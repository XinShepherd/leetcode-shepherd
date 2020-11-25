package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 1370. 上升下降字符串
 *
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 *
 * @author Fuxin
 * @since 2020/11/25
 */
public class SortStringII {

    public String sortString(String s) {
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            counts[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder(chars.length);
        for (int i = 0; i < chars.length;) {
            for (int j = 0; j < 26; j++) {
                if (counts[j] > 0) {
                    sb.append((char) (j + 'a'));
                    counts[j]--;
                    i++;
                }
            }
            for (int j = 25; j >= 0; j--) {
                if (counts[j] > 0) {
                    sb.append((char) (j + 'a'));
                    counts[j]--;
                    i++;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SortStringII sortStringII = new SortStringII();
        Assertions.assertThat(sortStringII.sortString("aaaabbbbcccc")).isEqualTo("abccbaabccba");
        Assertions.assertThat(sortStringII.sortString("rat")).isEqualTo("art");
        Assertions.assertThat(sortStringII.sortString("leetcode")).isEqualTo("cdelotee");
        Assertions.assertThat(sortStringII.sortString("ggggggg")).isEqualTo("ggggggg");
        Assertions.assertThat(sortStringII.sortString("spo")).isEqualTo("ops");

    }

}
