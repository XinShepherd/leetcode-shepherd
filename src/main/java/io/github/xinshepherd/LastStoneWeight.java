package io.github.xinshepherd;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1046. 最后一块石头的重量
 *
 * https://leetcode-cn.com/problems/last-stone-weight/
 *
 * @author Fuxin
 * @since 2020/12/30
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int abs = Math.abs(queue.poll() - queue.poll());
            if (abs > 0) {
                queue.offer(abs);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        assertThat(lastStoneWeight.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1})).isEqualTo(1);
    }


}
