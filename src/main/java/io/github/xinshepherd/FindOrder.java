package io.github.xinshepherd;

import java.util.*;

/**
 * 210. 课程表 II
 * https://leetcode-cn.com/problems/course-schedule-ii/
 *
 * @author Fuxin
 * @since 2020/5/17
 */
public class FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] depth = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> list = adjList.getOrDefault(src, new ArrayList<>());
            list.add(dest);
            adjList.put(src, list);
            depth[dest] += 1;
        }

        for (int i = 0; i < numCourses; i++) {
            if (depth[i] == 0) {
                q.add(i);
            }
        }
        int i = 0;

        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;
            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    depth[neighbor]--;
                    if (depth[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        if (i == numCourses) {
            return topologicalOrder;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] ints = {
                new int[]{1, 0},
                new int[]{2, 0},
                new int[]{3, 1},
                new int[]{3, 2}
        };
        FindOrder findOrder = new FindOrder();
        Util.printArray(findOrder.findOrder(4, ints));
    }

}
