package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 797. 所有可能的路径
 * <p>
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 */
public class AllPathsSourceTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(0);
        dfs(graph, ans, result, 0);
        return ans;
    }

    private void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> result, int i) {
        int[] nextNums = graph[i];
        if (i == graph.length -1) {
            ans.add(new ArrayList<>(result));
            return;
        }
        for (int nextNum : nextNums) {
            result.add(nextNum);
            dfs(graph, ans, result, nextNum);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        AllPathsSourceTarget target = new AllPathsSourceTarget();
        Assertions.assertThat(target.allPathsSourceTarget(new int[][]{
                new int[]{1, 2},
                new int[]{3},
                new int[]{3},
                new int[0]
        })).isEqualTo(Arrays.asList(
                Arrays.asList(0, 1, 3),
                Arrays.asList(0, 2, 3)
        ));

    }

}
