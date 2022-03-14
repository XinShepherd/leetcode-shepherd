package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.*;

// 39. 组合总和
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        return solution1(candidates, target);
    }

    List<List<Integer>> solution1(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return null;
        Arrays.sort(candidates);
        List<List<Integer>> results = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();
        solution1(candidates, target, 0, 0, stack, results);
        return results;
    }

    void solution1(int[] candidates, int target, int current, int index, Deque<Integer> stack, List<List<Integer>> results) {
        if (current > target) { // 剪枝
            return;
        }
        if (current == target) {
            results.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int sum = current + candidates[i];
            if (sum > target) { // 剪枝
                continue;
            }
            stack.addLast(candidates[i]);
            // 再通过 i 剪枝
            solution1(candidates, target, sum, i, stack, results);
            // 回溯
            stack.removeLast();
        }
    }


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        Assertions.assertThat(combinationSum.combinationSum(new int[]{2, 3, 5}, 8)).isEqualTo(Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(3, 5)
        ));
        Assertions.assertThat(combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7)).isEqualTo(Arrays.asList(
                Arrays.asList(2, 2, 3),
                Arrays.asList(7)
        ));
    }

}
