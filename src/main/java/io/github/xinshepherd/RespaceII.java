package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 面试题 17.13. 恢复空格
 * <p>
 * https://leetcode-cn.com/problems/re-space-lcci/
 *
 * @author Fuxin
 * @since 2021/5/7
 */
public class RespaceII {

    public int respace(String[] dictionary, String sentence) {
        int len = sentence.length();
        if (len == 0)
            return 0;
        Trie root = new Trie();
        for (String s : dictionary) {
            root.insert(s);
        }
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1;
            Trie cur = root;
            for (int j = i - 1; j >= 0; j--) {
                int index = sentence.charAt(j) - 'a';
                if (cur.next[index] == null) {
                    break;
                }
                if (cur.next[index].isEnd) {
                    dp[i] = Math.min(dp[j], dp[i]);
                }
                cur = cur.next[index];
            }
        }
        return dp[len];
    }

    static class Trie {
        Trie[] next;
        boolean isEnd;

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie cur = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new Trie();
                }
                cur = cur.next[index];
            }
            cur.isEnd = true;
        }

    }

    public static void main(String[] args) {
        RespaceII respaceII = new RespaceII();
        Assertions.assertThat(respaceII.respace(new String[]{"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother"))
                .isEqualTo(7);
    }

}
