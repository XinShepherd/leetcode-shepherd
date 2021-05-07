package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 *
 * 14. 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author Fuxin
 * @since 2021/5/7
 */
public class LongestCommonPrefixII {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        String s = strs[0];
        int i = 0;
        for (; i < minLen; i++) {
            boolean matched = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != s.charAt(i)) {
                    matched = false;
                    break;
                }
            }
            if (!matched) {
                break;
            }
        }
        return s.substring(0, i);
    }

    public static void main(String[] args) {
        LongestCommonPrefixII longestCommonPrefixII = new LongestCommonPrefixII();
        Assertions.assertThat(longestCommonPrefixII.longestCommonPrefix(new String[]{"flower", "flow", "flight"})).isEqualTo("fl");
        Assertions.assertThat(longestCommonPrefixII.longestCommonPrefix(new String[]{"dog", "racecar", "car"})).isEqualTo("");

    }

}
