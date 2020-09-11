package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 216. 组合总和 III
 * <p>
 * https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * @author Fuxin
 * @since 2020/9/11
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new LinkedList<>();
        Deque<Integer> result = new LinkedList<>();
        backtrack(k, n, 0, 1, ans, result);
        return ans;
    }

    void backtrack(int k, int n, int current, int i, List<List<Integer>> ans, Deque<Integer> result) {
        if (result.size() >= k)
            return;
        for (; i <= 9; i++) {
            int sum = current + i;
            if (sum > n)
                return;
            else if (sum == n) {
                if (result.size() + 1 == k) {
                    result.addLast(i);
                    ans.add(new ArrayList<>(result));
                    result.removeLast();
                }
                return;
            }
            result.addLast(i);
            backtrack(k, n, sum, i + 1, ans, result);
            result.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        assertThat(combinationSum3.combinationSum3(3, 7))
                .hasSameElementsAs(Arrays.asList(Arrays.asList(1, 2, 4)));
    }
}
