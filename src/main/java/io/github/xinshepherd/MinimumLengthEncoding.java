package io.github.xinshepherd;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 820. 单词的压缩编码
 *
 * @author Fuxin
 * @since 2020/3/28
 */
public class MinimumLengthEncoding {

    // 暴力破解
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length).reversed());
        Util.printArray(words);
        boolean[] dp = new boolean[words.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (!dp[i]) {
                sb.append(words[i]).append('#');
                dp[i] = true;
                for (int j = i + 1; j < words.length; j++) {
                    if (!dp[j] && helper(words[i], words[j])) {
                        dp[j] = true;
                    }
                }

            }
        }
        return sb.length();
    }

    boolean helper(String longWord, String shortWord) {
        return longWord.substring(longWord.length() - shortWord.length()).equals(shortWord);
    }

    // 字符串反转
    public int minimumLengthEncoding2(String[] words) {
        String[] reversed = new String[words.length];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = new StringBuilder(words[i]).reverse().toString();
        }
        Arrays.sort(reversed);
        int ans = 0;
        for (int i = 0; i < reversed.length;) {
            String first = reversed[i];
            int j = i + 1;
            for ( ;j < reversed.length; j++) {
                String after = reversed[j];
                if (after.length() < first.length() || !after.substring(0, first.length()).equals(first)) {
                    break;
                }
                first = reversed[j];
            }
            ans += reversed[j - 1].length() + 1;
            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumLengthEncoding encoding = new MinimumLengthEncoding();
        int ans = encoding.minimumLengthEncoding2(new String[]{"time", "me", "bell"});
        System.out.println(ans);
        System.out.println(encoding.minimumLengthEncoding2(new String[]{"time", "me", "bell", "ll", "okay", "ay"}));
    }
}
