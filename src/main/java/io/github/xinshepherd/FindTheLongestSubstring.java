package io.github.xinshepherd;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 *
 * @author Fuxin
 * @since 2020/5/20
 */
public class FindTheLongestSubstring {

    public int findTheLongestSubstring(String s) {

        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        int status = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                status ^= (1);
            } else if (c == 'e') {
                status ^= (1 << 1);
            } else if (c == 'i') {
                status ^= (1 << 2);
            } else if (c == 'o') {
                status ^= (1 << 3);
            } else if (c == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindTheLongestSubstring substring = new FindTheLongestSubstring();
        assertThat(substring.findTheLongestSubstring("eleetminicoworoep")).isEqualTo(13);
        assertThat(substring.findTheLongestSubstring("leetcodeisgreat")).isEqualTo(5);
    }

}
