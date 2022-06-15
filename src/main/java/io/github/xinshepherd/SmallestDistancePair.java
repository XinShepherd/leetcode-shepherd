package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 719. 找出第 K 小的数对距离
 * https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 *
 * @author Fuxin
 */
public class SmallestDistancePair {

    public int smallestDistancePair(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int distance = Math.abs(nums[i] - nums[j]);
                priorityQueue.add(distance);
                if (priorityQueue.size() > k) {
                    priorityQueue.remove();
                }
            }
        }
        return priorityQueue.remove();
    }

    public static void main(String[] args) {
        SmallestDistancePair smallestDistancePair = new SmallestDistancePair();
        Assertions.assertThat(smallestDistancePair.smallestDistancePair(new int[]{1, 3, 1}, 1)).isEqualTo(0);
        Assertions.assertThat(smallestDistancePair.smallestDistancePair(new int[]{1, 1, 1}, 2)).isEqualTo(0);
        Assertions.assertThat(smallestDistancePair.smallestDistancePair(new int[]{1, 6, 1}, 3)).isEqualTo(5);
    }

}
