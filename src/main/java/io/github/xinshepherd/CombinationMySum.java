package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * @author Fuxin
 * @since 2020/9/9
 */
public class CombinationMySum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Deque<Integer> result = new LinkedList<>();
        dfs(candidates, 0, target, 0, ans, result);
        return ans;
    }

    void dfs(int[] candidates, int current, int target, int i, List<List<Integer>> ans, Deque<Integer> result) {
        for (; i < candidates.length; i++) {
            int sum = current + candidates[i];
            // 由于排序，后面的都会大于前面的
            if (sum > target) {
               return;
            }
            result.add(candidates[i]);
            if (sum == target) {
                ans.add(new ArrayList<>(result));
                result.removeLast();
                return;
            }
            dfs(candidates, sum, target, i, ans, result);
            result.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationMySum combinationMySum = new CombinationMySum();
        assertThat(combinationMySum.combinationSum(new int[]{2, 3, 6, 7}, 7))
                .hasSameElementsAs(Arrays.asList(Arrays.asList(7), Arrays.asList(2, 2, 3)));
        assertThat(combinationMySum.combinationSum(new int[]{2, 3, 5}, 8))
                .hasSameElementsAs(Arrays.asList(Arrays.asList(2, 2, 2, 2), Arrays.asList(2, 3, 3), Arrays.asList(3, 5)));
    }
}
