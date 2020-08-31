package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 557. 反转字符串中的单词 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 * @author Fuxin
 * @since 2020/8/31
 */
public class ReverseWordsIII {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 0)
            return s;
        StringBuilder ans = new StringBuilder(len);
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                for (int j = i - 1; j >= start; j--) {
                    ans.append(chars[j]);
                }
                ans.append(' ');
                start = i + 1;
            }
        }
        for (int i = len -1; i >= start; i--) {
            ans.append(chars[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        ReverseWordsIII reverseWordsIII = new ReverseWordsIII();
        assertThat(reverseWordsIII.reverseWords("Let's take LeetCode contest")).isEqualTo("s'teL ekat edoCteeL tsetnoc");
        assertThat(reverseWordsIII.reverseWords("")).isEqualTo("");
    }

}
