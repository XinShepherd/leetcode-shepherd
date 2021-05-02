package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * 554. 砖墙
 * <p>
 * https://leetcode-cn.com/problems/brick-wall/
 */
public class LeastBricks {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (List<Integer> integers : wall) {
            int sum = 0;
            for (int i = 0; i < integers.size() - 1; i++) {
                sum += integers.get(i);
                int count = map.getOrDefault(sum, 0) + 1;
                map.put(sum, count);
                max = Math.max(max, count);
            }
        }
        return wall.size() - max;
    }

    public int leastBricks2(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (List<Integer> integers : wall) {
            int sum = 0;
            for (int i = 0; i < integers.size() - 1; i++) {
                sum += integers.get(i);
                Integer count = map.getOrDefault(sum, 0);
                map.put(sum, ++count);
                max = Math.max(max, count);
            }
        }
        return wall.size() - max;
    }

    public static void main(String[] args) {
        LeastBricks leastBricks = new LeastBricks();
        int least = leastBricks.leastBricks(Arrays.asList(
                Arrays.asList(1, 2, 2, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 1, 1)
        ));
        Assertions.assertThat(least).isEqualTo(2);
        least = leastBricks.leastBricks(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1),
                Arrays.asList(1),
                Arrays.asList(1)
        ));
        Assertions.assertThat(least).isEqualTo(4);
    }

}
