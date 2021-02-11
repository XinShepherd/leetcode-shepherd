package io.github.xinshepherd;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 703. 数据流中的第 K 大元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 *
 * @author Fuxin
 * @since 2021/2/11
 */
public class KthLargest {

    private final PriorityQueue<Integer> queue;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        assert k > 0;
        if (queue.size() >= k) {
            if (queue.peek() < val) {
                queue.poll();
                queue.add(val);
            }
        } else {
            queue.add(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        assertThat(kthLargest.add(3)).isEqualTo(4);   // return 4
        assertThat(kthLargest.add(5)).isEqualTo(5);   // return 5
        assertThat(kthLargest.add(10)).isEqualTo(5);  // return 5
        assertThat(kthLargest.add(9)).isEqualTo(8);   // return 8
        assertThat(kthLargest.add(4)).isEqualTo(8);   // return 8
    }

}
