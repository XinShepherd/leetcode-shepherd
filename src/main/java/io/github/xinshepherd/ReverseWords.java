package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 151. 翻转字符串里的单词
 *
 * @author Fuxin
 * @since 2020/4/10
 */
public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0 ; i--) {
            sb.append(split[i]).append(" ");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        Assertions.assertThat(reverseWords.reverseWords("the sky is blue")).isEqualTo("blue is sky the");
        Assertions.assertThat(reverseWords.reverseWords("  hello world  ")).isEqualTo("world hello");
        Assertions.assertThat(reverseWords.reverseWords("a good   example")).isEqualTo("example good a");
    }

}
