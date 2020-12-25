package io.github.xinshepherd;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 455. 分发饼干
 *
 * https://leetcode-cn.com/problems/assign-cookies/
 *
 * @author Fuxin
 * @since 2020/12/25
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        FindContentChildren children = new FindContentChildren();
        assertThat(children.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1})).isEqualTo(1);
        assertThat(children.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3})).isEqualTo(2);
        assertThat(children.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 2, 3})).isEqualTo(3);
        assertThat(children.findContentChildren(new int[]{1, 2, 3, 1}, new int[]{1, 2, 3})).isEqualTo(3);
        assertThat(children.findContentChildren(new int[]{1, 2, 3, 1, 5}, new int[]{1, 2, 3, 1})).isEqualTo(4);
    }
}
