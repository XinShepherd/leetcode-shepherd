package io.github.xinshepherd;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    public static void main(String[] args) {
        CommonChars commonChars = new CommonChars();
        List<String> strings = commonChars.commonChars(new String[]{"bella", "label", "roller"});
        assertThat(strings).isEqualTo(Arrays.asList("e", "l", "l"));
        strings = commonChars.commonChars(new String[]{"cool", "lock", "cook"});
        assertThat(strings).isEqualTo(Arrays.asList("c","o"));
    }

}
