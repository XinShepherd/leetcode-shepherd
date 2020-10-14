package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1002. 查找常用字符
 *
 * https://leetcode-cn.com/problems/find-common-characters/
 *
 * @author Fuxin
 * @since 2020/10/14
 */
public class CommonChars {

    public List<String> commonChars(String[] A) {
        int length = A.length;
        int[][] counter = new int[length][26];
        for (int i = 0; i < length; i++) {
            char[] chars = A[i].toCharArray();
            for (char c : chars) {
                counter[i][c - 'a']++;
            }
        }
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            int commonCount = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                commonCount = Math.min(commonCount, counter[j][i]);
                if (commonCount == 0)
                    break;
            }
            for (int j = 0; j < commonCount; j++) {
                ans.add(String.valueOf((char) ('a' + i)));
            }
        }
        return ans;
    }

    // 3ms
    public List<String> commonChars2(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            boolean hasCommon = false;
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
                if (minfreq[i] > 0 && minfreq[i] != Integer.MAX_VALUE) {
                    hasCommon = true;
                }
            }
            if (!hasCommon) {
                return Collections.emptyList();
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CommonChars commonChars = new CommonChars();
        assertThat(commonChars.commonChars(new String[]{"bella", "label", "roller"})).isEqualTo(Arrays.asList("e", "l", "l"));
        assertThat(commonChars.commonChars(new String[]{"cool", "lock", "cook"})).isEqualTo(Arrays.asList("c","o"));
        assertThat(commonChars.commonChars2(new String[]{"bella", "label", "roller"})).isEqualTo(Arrays.asList("e", "l", "l"));
        assertThat(commonChars.commonChars2(new String[]{"cool", "lock", "cook"})).isEqualTo(Arrays.asList("c","o"));
    }

}
