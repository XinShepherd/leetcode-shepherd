package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 491. 递增子序列
 * https://leetcode-cn.com/problems/increasing-subsequences/
 *
 * @author Fuxin
 * @since 2020/8/25
 */
public class FindSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2)
            return new ArrayList<>();
        // 采用 set 去重
        Set<List<Integer>> results = new HashSet<>();
        Deque<Integer> result = new LinkedList<>();
        findAndAdd(nums, 0, results, result);
        return new ArrayList<>(results);
    }

    void findAndAdd(int[] nums, int i, Set<List<Integer>> results, Deque<Integer> result) {
        if (result.size() >= 2) {
            results.add(new ArrayList<>(result));
        }
        int prev = Objects.isNull(result.peekLast()) ? -101 : result.peekLast();
        for (; i < nums.length; i++) {
            if (nums[i] >= prev) {
                result.addLast(nums[i]);
                findAndAdd(nums, i + 1, results, result);
                result.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        FindSubsequences findSubsequences = new FindSubsequences();
        List<List<Integer>> ans = findSubsequences.findSubsequences(new int[]{4, 6, 7, 7});
        assertThat(ans).hasSameElementsAs(Arrays.asList(
                Arrays.asList(4, 6),
                Arrays.asList(4, 7),
                Arrays.asList(4, 6, 7),
                Arrays.asList(4, 6, 7, 7),
                Arrays.asList(6, 7),
                Arrays.asList(6, 7, 7),
                Arrays.asList(7, 7),
                Arrays.asList(4, 7, 7)
        ));
    }

}
