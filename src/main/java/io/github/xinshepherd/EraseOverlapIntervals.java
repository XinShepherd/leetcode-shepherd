package io.github.xinshepherd;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Fuxin
 * @since 2020/12/31
 */
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> {
            int diff = a[0] - b[0];
            if (diff == 0) {
                return a[1] - b[1];
            }
            return diff;
        });
        int ans = 0;
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[1] <= current[1]) {
                ans++;
                current = next;
            } else if (next[0] < current[1]) {
                ans++;
            } else {
                current = next;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        assertThat(eraseOverlapIntervals.eraseOverlapIntervals(new int[][]{

        }));
    }

}
