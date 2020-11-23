package io.github.xinshepherd;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 452. 用最少数量的箭引爆气球
 *
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * @author Fuxin
 * @since 2020/11/23
 */
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int ans = 1;
        int start = points[0][0];
        int end = points[0][1];
        for (int[] point : points) {
            if (point[0] >= start && point[0] <= end) {
                start = point[0];
                end = Math.min(end, point[1]);
            } else {
                ans++;
                start = point[0];
                end = point[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        assertThat(findMinArrowShots.findMinArrowShots(new int[][]{
                new int[]{10, 16},
                new int[]{2, 8},
                new int[]{1, 6},
                new int[]{7, 12}
        })).isEqualTo(2);
        assertThat(findMinArrowShots.findMinArrowShots(new int[][]{
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{5, 6},
                new int[]{7, 8}
        })).isEqualTo(4);
        assertThat(findMinArrowShots.findMinArrowShots(new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4},
                new int[]{4, 5}
        })).isEqualTo(2);
        assertThat(findMinArrowShots.findMinArrowShots(new int[][]{
                new int[]{1, 2},
        })).isEqualTo(1);
        assertThat(findMinArrowShots.findMinArrowShots(new int[][]{
                new int[]{2, 3},
                new int[]{2, 3},
        })).isEqualTo(1);
    }

}
