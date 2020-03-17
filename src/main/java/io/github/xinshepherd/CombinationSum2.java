package io.github.xinshepherd;

import java.util.*;

/**
 * 40. 组合总和 II
 *
 * @author Fuxin
 * @since 2020/3/17 11:30
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new LinkedList<>();
        Deque<Integer> result = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, results, result);
        return results;
    }

    void backtrack(int[] candidates, int target, int index, int sum, List<List<Integer>> results, Deque<Integer> result) {
        if (sum == target) {
            results.add(new ArrayList<>(result));
            return;
        }
        if (sum > target)
            return;
        int before = 0;
        for (int i = index; i < candidates.length; i++) {
            if (before == candidates[i]) {
                continue;
            }
            int s = sum + candidates[i];
            if (s > target)
                continue;
            before = candidates[i];
            result.add(candidates[i]);
            backtrack(candidates, target, i + 1, s, results, result);
            result.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

}
