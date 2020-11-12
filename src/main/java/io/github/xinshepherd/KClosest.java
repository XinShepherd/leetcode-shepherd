package io.github.xinshepherd;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 973. 最接近原点的 K 个点
 *
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 *
 * @author Fuxin
 * @since 2020/11/9
 */
public class KClosest {

    class Node {
        int square;
        int[] point;
    }

    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; i++) {
            int[] point = points[i];
            int square = point[0] * point[0] + point[1] * point[1];
            Node node = new Node();
            node.square = square;
            node.point = point;
            nodes[i] = node;
        }
        Arrays.sort(nodes, Comparator.comparingInt(node -> node.square));
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            ans.add(nodes[i].point);
        }
        return ans.toArray(new int[][]{});
    }

    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(K, Comparator.comparingInt(node -> node.square));
        for (int[] point : points) {
            int square = point[0] * point[0] + point[1] * point[1];
            Node node = new Node();
            node.square = square;
            node.point = point;
            minHeap.offer(node);
        }
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        while (!minHeap.isEmpty() && i < K) {
            ans.add(minHeap.poll().point);
            i++;
        }
        return ans.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        KClosest kClosest = new KClosest();
        assertThat(kClosest.kClosest(new int[][]{
                new int[]{1, 3},
                new int[]{-2, 2}
        }, 1)).isEqualTo(new int[][]{new int[]{-2, 2}});
        assertThat(kClosest.kClosest(new int[][]{
                new int[]{3, 3},
                new int[]{5, -1},
                new int[]{-2, 4}
        }, 2)).isEqualTo(new int[][]{new int[]{3, 3}, new int[]{-2, 4}});
        assertThat(kClosest.kClosest2(new int[][]{
                new int[]{1, 3},
                new int[]{-2, 2}
        }, 1)).isEqualTo(new int[][]{new int[]{-2, 2}});
        assertThat(kClosest.kClosest2(new int[][]{
                new int[]{3, 3},
                new int[]{5, -1},
                new int[]{-2, 4}
        }, 2)).isEqualTo(new int[][]{new int[]{3, 3}, new int[]{-2, 4}});
    }

}
