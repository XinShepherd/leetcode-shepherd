package io.github.xinshepherd;

// 47. 全排列 II
import java.util.*;

public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        Deque<Integer> stack = new ArrayDeque<>(nums.length);
        List<List<Integer>> results = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, 0, nums.length, used, stack, results);
        return results;
    }

    private void backtrack(int[] nums, int first, int n, boolean[] used, Deque<Integer> stack, List<List<Integer>> results) {
        if (first == n) {
            results.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                // 修改 2：在 used[i - 1] 刚刚被撤销的时候剪枝，说明接下来会被选择，搜索一定会重复，故"剪枝"
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.addLast(nums[i]);
                backtrack(nums, first + 1, n, used, stack, results);
                stack.removeLast();
                // 回溯，撤销选择
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        PermuteUnique permute = new PermuteUnique();
        System.out.println(permute.permuteUnique(new int[]{1, 1, 3}));
    }
}
