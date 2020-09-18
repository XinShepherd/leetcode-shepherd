package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author Fuxin
 * @since 2020/9/18
 */
public class PermuteUniqueII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        Deque<Integer> result = new LinkedList<>();
        boolean[] dp = new boolean[nums.length];
        backtrack(nums, ans, result, dp);
        return ans;
    }

    void backtrack(int[] nums, List<List<Integer>> ans, Deque<Integer> result, boolean[] dp) {
        if (result.size() == nums.length) {
            ans.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (dp[i])
                continue;
            // 修改 2：在 used[i - 1] 刚刚被撤销的时候剪枝，说明接下来会被选择，搜索一定会重复，故"剪枝"
            if (i > 0 && nums[i - 1] == nums[i] && !dp[i - 1]) {
                continue;
            }
            result.addLast(nums[i]);
            dp[i] = true;
            backtrack(nums, ans, result, dp);
            result.removeLast();
            dp[i] = false;
        }
    }

    public static void main(String[] args) {
        PermuteUniqueII permuteUniqueII = new PermuteUniqueII();
        List<List<Integer>> ans = permuteUniqueII.permuteUnique(new int[]{1, 1, 2});
        assertThat(ans).isEqualTo(Arrays.asList(Arrays.asList(1, 1, 2), Arrays.asList(1, 2, 1), Arrays.asList(2, 1, 1)));
    }
}
