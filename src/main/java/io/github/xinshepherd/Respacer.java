package io.github.xinshepherd;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 面试题 17.13. 恢复空格
 * https://leetcode-cn.com/problems/re-space-lcci/
 *
 * 字典树参考：https://oi-wiki.org/string/trie/#_1
 *
 * @author Fuxin
 * @since 2020/7/9
 */
public class Respacer {

    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie root = new Trie();
        for (String word: dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }

    class Trie {
        public Trie[] next;
        public boolean isEnd;

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String s) {
            Trie curPos = this;

            for (int i = s.length() - 1; i >= 0; --i) {
                int t = s.charAt(i) - 'a';
                if (curPos.next[t] == null) {
                    curPos.next[t] = new Trie();
                }
                curPos = curPos.next[t];
            }
            curPos.isEnd = true;
        }
    }

    public static void main(String[] args) {
        Respacer respacer = new Respacer();
        assertThat(respacer.respace(new String[]{"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother"))
                .isEqualTo(7);
        assertThat(respacer.respace(new String[]{"aaysaayayaasyya","yyas","yayysaaayasasssy","yaasassssssayaassyaayaayaasssasysssaaayysaaasaysyaasaaaaaasayaayayysasaaaa","aya","sya","ysasasy","syaaaa","aaaas","ysa","a","aasyaaassyaayaayaasyayaa","ssaayayyssyaayyysyayaasaaa","aya","aaasaay","aaaa","ayyyayssaasasysaasaaayassasysaaayaassyysyaysaayyasayaaysyyaasasasaayyasasyaaaasysasy","aaasa","ysayssyasyyaaasyaaaayaaaaaaaaassaaa","aasayaaaayssayyaayaaaaayaaays","s"}, "asasayaayaassayyayyyyssyaassasaysaaysaayaaaaysyaaaa"))
                .isEqualTo(7);
    }

}
