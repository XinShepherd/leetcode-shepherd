package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 57. 插入区间
 *
 * https://leetcode-cn.com/problems/insert-interval/
 *
 * @author Fuxin
 * @since 2020/11/4
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][]{newInterval};
        List<int[]> ans = new ArrayList<>();
        int leftBound = newInterval[0];
        int rightBound = newInterval[1];
        boolean added = false;
        for (int[] interval : intervals) {
            // 不相交
            if (interval[1] < leftBound) {
                ans.add(interval);
            } else if (interval[0] > rightBound) {
                if (!added) {
                    ans.add(new int[]{leftBound, rightBound});
                    added = true;
                }
                ans.add(interval);
            } else {
                leftBound = Math.min(leftBound, interval[0]);
                rightBound = Math.max(rightBound, interval[1]);
            }
        }
        if (!added) {
            if (rightBound < intervals[0][1]) {
                ans.add(0, new int[]{leftBound, rightBound});
            } else {
                ans.add(new int[]{leftBound, rightBound});
            }
        }
        return ans.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] ints = insertInterval.insert(new int[][]{
                new int[]{1, 3},
                new int[]{6, 9}
        }, new int[]{2, 5});
        assertThat(ints).isEqualTo(new int[][]{
                new int[]{1, 5},
                new int[]{6, 9}
        });
        ints = insertInterval.insert(new int[][]{
                new int[]{1, 2},
                new int[]{3, 5},
                new int[]{6, 7},
                new int[]{8, 10},
                new int[]{12, 16}
        }, new int[]{4, 8});
        assertThat(ints).isEqualTo(new int[][]{
                new int[]{1, 2},
                new int[]{3, 10},
                new int[]{12, 16}
        });
    }

}
