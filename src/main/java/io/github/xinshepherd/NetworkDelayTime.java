package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 740. 删除并获得点数
 *
 * https://leetcode-cn.com/problems/delete-and-earn/
 *
 * @author Fuxin
 * @since 2021/5/5
 */
public class NetworkDelayTime {

    // 狄杰斯特拉算法，从源点出发，一次找最短的的作为起点
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> mapping = new HashMap<>();
        for (int[] time : times) {
            List<int[]> routes = mapping.getOrDefault(time[0], new ArrayList<>());
            routes.add(time);
            mapping.put(time[0], routes);
        }
        int[] minTimes = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            minTimes[i] = Integer.MAX_VALUE;
        }
        minTimes[k] = 0;
        boolean[] seen = new boolean[n + 1];
        while (true) {
            int candidateNode = -1;
            int candidateTime = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (!seen[j] && minTimes[j] < candidateTime) {
                    // 找出最小耗时的节点
                    candidateNode = j;
                    candidateTime = minTimes[j];
                }
            }
            if (candidateNode < 0)
                break;
            seen[candidateNode] = true;
            if (mapping.containsKey(candidateNode)) {
                for (int[] routes : mapping.get(candidateNode)) {
                    // 更新节点的最小耗时
                    minTimes[routes[1]] = Math.min(candidateTime + routes[2], minTimes[routes[1]]);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (minTimes[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, minTimes[i]);
        }
        return max;
    }

    // 深度优先
    public int networkDelayTime1(int[][] times, int n, int k) {
        int[] minTimes = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            minTimes[i] = -1;
        }
        Map<Integer, List<int[]>> mapping = new HashMap<>();
        for (int[] time : times) {
            List<int[]> routes = mapping.getOrDefault(time[0], new ArrayList<>());
            routes.add(time);
            mapping.put(time[0], routes);
        }
        setMinTime(mapping, minTimes, k, 0);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (minTimes[i] == -1)
                return -1;
            max = Math.max(max, minTimes[i]);
        }
        return max;
    }

    private void setMinTime(Map<Integer, List<int[]>> mapping, int[] minTimes, int curIndex, int curTime) {
        if (minTimes[curIndex] != -1 && minTimes[curIndex] <= curTime) {
            return;
        }
        minTimes[curIndex] = curTime;
        if (!mapping.containsKey(curIndex)) {
            return;
        }
        List<int[]> routes = mapping.get(curIndex);
        for (int[] route : routes) {
            int sum = curTime + route[2];
            setMinTime(mapping, minTimes, route[1], sum);
        }
    }

    public int networkDelayTime2(int[][] times, int n, int k) {
        boolean[] flags = new boolean[n + 1];
        Map<Integer, List<int[]>> mapping = new HashMap<>();
        for (int[] time : times) {
            List<int[]> routes = mapping.getOrDefault(time[0], new ArrayList<>());
            routes.add(time);
            mapping.put(time[0], routes);
        }
        int time = getTime(mapping, flags, k);
        boolean all = true;
        for (int i = 1; i <= n; i++) {
            if (!flags[i]) {
                all = false;
                break;
            }
        }
        return all ? time : -1;
    }

    int getTime(Map<Integer, List<int[]>> mapping, boolean[] flags, int i) {
        if (!mapping.containsKey(i)) {
            flags[i] = true;
            return 0;
        }
        List<int[]> routes = mapping.get(i);
        int max = 0;
        flags[i] = true;
        for (int[] route : routes) {
            if (!flags[route[1]]) {
                int time = getTime(mapping, flags, route[1]);
                max = Math.max(time + route[2], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        NetworkDelayTime delayTime = new NetworkDelayTime();
        Assertions.assertThat(delayTime.networkDelayTime(new int[][]{
                new int[]{2, 1, 1},
                new int[]{2, 3, 1},
                new int[]{3, 4, 1}
        }, 4, 2)).isEqualTo(2);
        Assertions.assertThat(delayTime.networkDelayTime(new int[][]{
                new int[]{1, 2, 1}
        }, 2, 1)).isEqualTo(1);
        Assertions.assertThat(delayTime.networkDelayTime(new int[][]{
                new int[]{1, 2, 1}
        }, 2, 2)).isEqualTo(-1);
        Assertions.assertThat(delayTime.networkDelayTime(new int[][]{
                new int[]{1, 2, 1},
                new int[]{2, 1, 3}
        }, 2, 2)).isEqualTo(3);
        Assertions.assertThat(delayTime.networkDelayTime(new int[][]{
                new int[]{1, 2, 1},
                new int[]{2, 3, 2},
                new int[]{1, 3, 2}
        }, 3, 1)).isEqualTo(2);
    }

}
