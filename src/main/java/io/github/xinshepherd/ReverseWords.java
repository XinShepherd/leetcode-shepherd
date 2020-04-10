package io.github.xinshepherd;

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
        System.out.println(reverseWords.reverseWords("the sky is blue"));
        System.out.println(reverseWords.reverseWords("  hello world!  "));
        System.out.println(reverseWords.reverseWords("a good   example"));
    }

}
