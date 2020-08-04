package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 207. 课程表
 * https://leetcode-cn.com/problems/course-schedule/
 *
 * @author Fuxin
 * @since 2020/8/4
 */
public class CanFinish {

    private List<List<Integer>> edges;
    private int[] visited;
    private boolean valid;

    // 拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        valid = true;
        for (int[] info : prerequisites) {
            edges.get(info[0]).add(info[1]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    void dfs(int u) {
        visited[u] = 1;
        List<Integer> list = edges.get(u);
        for (Integer edge : list) {
            if (visited[edge] == 0) {
                dfs(edge);
                if (!valid) {
                    return;
                }
            } else if (visited[edge] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        assertThat(canFinish.canFinish(2, new int[][]{new int[]{1, 0}})).isTrue();
        assertThat(canFinish.canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}})).isFalse();
    }

}
