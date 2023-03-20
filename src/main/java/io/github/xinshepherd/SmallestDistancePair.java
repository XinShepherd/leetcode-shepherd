package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/find-k-th-smallest-pair-distance/">719. 找出第 K 小的数对距离</a>
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

    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) >> 1 ;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int i = binarySearch(nums, 0, j, nums[j] - mid);
                cnt += j - i;
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        SmallestDistancePair smallestDistancePair = new SmallestDistancePair();
        Assertions.assertThat(smallestDistancePair.smallestDistancePair(new int[]{1, 3, 1}, 1)).isEqualTo(0);
        Assertions.assertThat(smallestDistancePair.smallestDistancePair(new int[]{1, 1, 1}, 2)).isEqualTo(0);
        Assertions.assertThat(smallestDistancePair.smallestDistancePair(new int[]{1, 6, 1}, 3)).isEqualTo(5);
        Assertions.assertThat(smallestDistancePair.smallestDistancePair(new int[]{38, 33, 57, 65, 13, 2, 86, 75, 4, 56}, 26)).isEqualTo(36);

        Assertions.assertThat(smallestDistancePair.smallestDistancePair2(new int[]{1, 3, 1}, 1)).isEqualTo(0);
        Assertions.assertThat(smallestDistancePair.smallestDistancePair2(new int[]{1, 1, 1}, 2)).isEqualTo(0);
        Assertions.assertThat(smallestDistancePair.smallestDistancePair2(new int[]{1, 6, 1}, 3)).isEqualTo(5);
        Assertions.assertThat(smallestDistancePair.smallestDistancePair2(new int[]{38, 33, 57, 65, 13, 2, 86, 75, 4, 56}, 26)).isEqualTo(36);
    }

}
