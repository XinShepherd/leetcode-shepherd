package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * <p>
 * https://leetcode-cn.com/problems/word-break/
 *
 * @author Fuxin
 * @since 2021/5/6
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] flags = new boolean[length + 1];
        flags[0] = true;
        Set<String> words = new HashSet<>(wordDict);
        int maxWidth = 0;
        for (String s1 : wordDict) {
            maxWidth = Math.max(maxWidth, s1.length());
        }
        for (int i = 1; i <= length; i++) {
            for (int j = i; j >= 0 && j >= i - maxWidth; j--) {
                if (flags[j] && words.contains(s.substring(j, i))) {
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[length];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        Assertions.assertThat(wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code"))).isTrue();
        Assertions.assertThat(wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen"))).isTrue();
        Assertions.assertThat(wordBreak.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))).isFalse();
    }

}
