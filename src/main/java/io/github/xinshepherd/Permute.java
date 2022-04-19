package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.*;


/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<Integer> array = new ArrayList<>();
        for (int num : nums) {
            array.add(num);
        }
        List<List<Integer>> results = new LinkedList<>();
        backtrack(0, nums.length, array, results);
        return results;
    }

    private void backtrack(int first, int n, List<Integer> array, List<List<Integer>> results) {
        if (first == n) {
            results.add(new ArrayList<>(array));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(array, first, i);
            backtrack(first + 1, n, array, results);
            // 再切换回来，回溯
            Collections.swap(array, first, i);
        }
    }

    public static void main(String[] args) {

        Permute permute = new Permute();
        Assertions.assertThat(permute.permute(new int[]{1, 2, 3})).hasSameElementsAs(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)
        ));
        Assertions.assertThat(permute.permute(new int[]{0, 1})).hasSameElementsAs(Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 0)
        ));

    }
}
