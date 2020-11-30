package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 767. 重构字符串
 *
 * https://leetcode-cn.com/problems/reorganize-string/
 *
 * @author Fuxin
 * @since 2020/11/30
 */
public class ReorganizeString {

    public String reorganizeString(String S) {
        int len = S.length();
        if (len <= 1)
            return S;
        int[] nums = new int[26];
        char[] chars = S.toCharArray();
        int max = 0, index = 0;
        for (char c : chars) {
            int i = c - 'a';
            nums[i]++;
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        if (len - max < max - 1) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        while (max > 0) {
            ans.append((char) ('a' + index));
            for (int i = 0; i < 26 && len - max >= max - 1; i++) {
                if (nums[i] == 0 || i == index)
                    continue;
                ans.append((char) ('a' + i));
                nums[i]--;
                len--;
            }
            max--;
            len--;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        assertThat(reorganizeString.reorganizeString("aaab")).isEqualTo("");
        assertThat(reorganizeString.reorganizeString("aab")).isEqualTo("aba");
    }

}
