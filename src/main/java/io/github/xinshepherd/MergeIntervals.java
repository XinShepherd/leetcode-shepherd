package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * @author Fuxin
 * @since 2020/4/16
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <=1) return intervals;
        Arrays.sort(intervals, Comparator.comparing(nums -> nums[0]));
        List<int[]> ans = new ArrayList<>();
        int[] temp = null;
        for (int[] interval : intervals) {
            if (temp == null) {
                temp = interval;
            } else {
                if (interval[0] <= temp[1]) {
                    temp[1] = Math.max(interval[1], temp[1]);
                } else {
                    ans.add(temp);
                    temp = interval;
                }
            }
        }
        ans.add(temp);
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        Util.printTwoDimensionalArray(mergeIntervals.merge(new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        }));
        Util.printTwoDimensionalArray(mergeIntervals.merge(new int[][]{
                new int[]{1, 4},
                new int[]{4, 5}
        }));
    }
}
