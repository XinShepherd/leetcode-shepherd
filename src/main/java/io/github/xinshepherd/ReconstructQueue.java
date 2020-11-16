package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 406. 根据身高重建队列
 *
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 *
 * @author Fuxin
 * @since 2020/11/16
 */
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            int diff = b[0] - a[0];
            if (diff == 0)
                return a[1] - b[1];
            return diff;
        });
        // [[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]]
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        ReconstructQueue queue = new ReconstructQueue();
        assertThat(queue.reconstructQueue(new int[][]{
                new int[]{7, 0},
                new int[]{4, 4},
                new int[]{7, 1},
                new int[]{5, 0},
                new int[]{6, 1},
                new int[]{5, 2}
        })).isEqualTo(new int[][]{
                new int[]{5, 0},
                new int[]{7, 0},
                new int[]{5, 2},
                new int[]{6, 1},
                new int[]{4, 4},
                new int[]{7, 1}
        });
    }

}
