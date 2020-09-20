package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 *
 * @author Fuxin
 * @since 2020/9/20
 */
public class SubsetsII {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(Collections.emptyList());
        Deque<Integer> queue = new LinkedList<>();
        backtrack(nums, 0, ans, queue);
        return ans;
    }

    void backtrack(int[] nums, int current, List<List<Integer>> ans, Deque<Integer> queue) {
        for (; current < nums.length; current++) {
            queue.addLast(nums[current]);
            ans.add(new ArrayList<>(queue));
            backtrack(nums, current + 1, ans, queue);
            queue.removeLast();
        }
    }

    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        List<List<Integer>> subsets = subsetsII.subsets(new int[]{1, 2, 3});
        assertThat(subsets).hasSameElementsAs(Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2),
                Arrays.asList()
        ));
    }

}
