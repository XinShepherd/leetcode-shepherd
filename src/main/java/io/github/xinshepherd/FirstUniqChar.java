package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author Fuxin
 * @since 2020/12/24
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] counts = new int[26];
        for (char c : chars) {
            int i = c - 'a';
            counts[i]++;
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';
            if (counts[index] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        assertThat(firstUniqChar.firstUniqChar("leetcode")).isEqualTo(0);
        assertThat(firstUniqChar.firstUniqChar("loveleetcode")).isEqualTo(2);
        assertThat(firstUniqChar.firstUniqChar("aa")).isEqualTo(-1);
    }
}
