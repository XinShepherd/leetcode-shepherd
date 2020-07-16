package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 90. 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/
 *
 * @author Fuxin
 * @since 2020/7/16
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();
        helper(ans, stack, nums, 0);
        ans.add(new ArrayList<>());
        return ans;
    }

    void helper(List<List<Integer>> ans, Deque<Integer> stack, int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            stack.push(nums[i]);
            ans.add(new ArrayList<>(stack));
            helper(ans, stack, nums, i + 1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        assertThat(subsetsWithDup.subsetsWithDup(new int[]{1, 2, 2}))
                .isNotEmpty();
    }

}
