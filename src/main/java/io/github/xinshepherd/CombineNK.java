package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * @author Fuxin
 * @since 2020/2/26 9:31
 */
public class CombineNK {

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k > n)
            return Collections.emptyList();
        List<List<Integer>> results = new LinkedList<>();
        Integer[] ans = new Integer[k];
        backtrack(n, 1, 0, k, ans, results);
        return results;
    }

    void backtrack(int n, int current, int size, int k, Integer[] ans, List<List<Integer>> results) {
        if (size == k) {
            results.add(new ArrayList<>(Arrays.asList(ans)));
            return;
        }
        for (int i = current; i < n + 1; i++) {
            ans[size] = i;
            backtrack(n, i + 1, size + 1, k, ans, results);
        }
    }

    public static void main(String[] args) {
        CombineNK combineNK = new CombineNK();
        Assertions.assertThat(combineNK.combine(1, 1)).isEqualTo(Collections.singletonList(Collections.singletonList(1)));
        Assertions.assertThat(combineNK.combine(4, 2)).containsExactlyInAnyOrder(
                Arrays.asList(2, 4),
                Arrays.asList(3, 4),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4)
        );
        System.out.println();
    }

}
