package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * 78. 子集
 *
 * @author Fuxin
 * @since 2020/3/4 8:58
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();
        backtrack(nums, 0, stack, results);
        results.add(Collections.emptyList());
        return results;
    }

    void backtrack(int[] nums, int index, Deque<Integer> stack, List<List<Integer>> results) {
        if (index == nums.length)
            return;
        for (int i = index; i < nums.length; i++) {
            stack.addLast(nums[i]);
            results.add(new ArrayList<>(stack));
            backtrack(nums, i + 1, stack, results);
            stack.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        Assertions.assertThat(subsets.subsets(new int[]{})).isEqualTo(Arrays.asList(Arrays.asList()));
        Assertions.assertThat(subsets.subsets(new int[]{1, 2, 3})).isEqualTo(
                Arrays.asList(
                        Arrays.asList(1),
                        Arrays.asList(1, 2),
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 3),
                        Arrays.asList(2),
                        Arrays.asList(2, 3),
                        Arrays.asList(3),
                        Arrays.asList())
        );
    }

}
