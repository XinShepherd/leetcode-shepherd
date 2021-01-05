package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 830. 较大分组的位置
 *
 * https://leetcode-cn.com/problems/positions-of-large-groups
 *
 * @author Fuxin
 * @since 2021/1/5
 */
public class LargeGroupPositions {

    public List<List<Integer>> largeGroupPositions(String s) {
        char[] chars = s.toCharArray();
        List<List<Integer>> ans = new ArrayList<>();
        int start = 0;
        int length = chars.length;
        for (int i = 0; i <= length; i++) {
            if (i == length || chars[i] != chars[start]) {
                int len = i - start;
                if (len >= 3) {
                    ans.add(Arrays.asList(start, i - 1));
                }
                start = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LargeGroupPositions positions = new LargeGroupPositions();
        assertThat(positions.largeGroupPositions("abbxxxxzzy")).isEqualTo(Arrays.asList(Arrays.asList(3, 6)));
        assertThat(positions.largeGroupPositions("abc")).isEqualTo(Collections.emptyList());
        assertThat(positions.largeGroupPositions("abcdddeeeeaabbbcd")).isEqualTo(Arrays.asList(
                Arrays.asList(3,5),
                Arrays.asList(6,9),
                Arrays.asList(12,14)
        ));
        assertThat(positions.largeGroupPositions("abcdddeeeeaabbbcdddd")).isEqualTo(Arrays.asList(
                Arrays.asList(3,5),
                Arrays.asList(6,9),
                Arrays.asList(12,14),
                Arrays.asList(16,19)
        ));
    }
}
