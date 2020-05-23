package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 76. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author Fuxin
 * @since 2020/5/23
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        int lenT = t.length();
        int lenS = s.length();

        if (lenS == 0 || lenT == 0 || lenS < lenT)
            return "";

        int[] freqS = new int[128];
        int[] freqT = new int[128];

        char[] charArrayT = t.toCharArray();
        char[] charArrayS = s.toCharArray();
        for (char c : charArrayT) {
            freqT[c]++;
        }

        int distance = 0;
        int minLen = lenS + 1;
        int begin = 0;

        int left = 0;
        int right = 0;
        while (right < lenS) {
            char charRight = charArrayS[right];
            if (freqT[charRight] == 0) {
                right++;
                continue;
            }

            if (freqS[charRight] < freqT[charRight]) {
                distance++;
            }
            right++;
            freqS[charRight]++;

            while (distance == lenT) {

                char charLeft = charArrayS[left];
                if (freqT[charLeft] == 0) {
                    left++;
                    continue;
                }

                if (freqS[charLeft] == freqT[charLeft]) {
                    distance--;
                    if (right - left < minLen) {
                        minLen = right - left;
                        begin = left;
                    }
                }
                left++;
                freqS[charLeft]--;
            }

        }

        if (minLen == lenS + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }

    public static void main(String[] args) {
        MinWindow window = new MinWindow();
        assertThat(window.minWindow("ADOBECODEBANC", "ABC")).isEqualTo("BANC");
        assertThat(window.minWindow("cabwefgewcwaefgcf", "cae")).isEqualTo("cwae");
    }

}
