package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 763. 划分字母区间
 *
 * https://leetcode-cn.com/problems/partition-labels/
 *
 * @author Fuxin
 * @since 2020/10/22
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int len = S.length();
        int[] indexes = new int[26];
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            int idx = c - 'a';
            indexes[idx] = Math.max(indexes[idx], i);
        }
        List<Integer> ans = new ArrayList<>();
        int cur = 0, before = cur;
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            int idx = c - 'a';
            cur = Math.max(cur, indexes[idx]);
            if (i == cur) {
                ans.add(cur - before + 1);
                cur++;
                before = cur;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        assertThat(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"))
                .isEqualTo(Arrays.asList(9, 7, 8));
        assertThat(partitionLabels.partitionLabels("aaa"))
                .isEqualTo(Arrays.asList(3));
        assertThat(partitionLabels.partitionLabels("a"))
                .isEqualTo(Arrays.asList(1));
        assertThat(partitionLabels.partitionLabels("abc"))
                .isEqualTo(Arrays.asList(1, 1, 1));
        assertThat(partitionLabels.partitionLabels("vhaagbqkaq"))
                .isEqualTo(Arrays.asList(1, 1, 8));
    }

}
