package io.github.xinshepherd;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 84. 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @author Fuxin
 * @since 2020/5/30
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        return helper(heights);
    }

    private int helper(int[] heights) {
        int len = heights.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return heights[0];

        int[] ints = new int[len + 2];
        System.arraycopy(heights, 0, ints, 1, len);
        len += 2;
        heights = ints;

        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < len; i++) {
            while (heights[stack.peekFirst()] > heights[i]){
                int h = heights[stack.pop()];
                int width = i - stack.peekFirst() - 1;
                area = Math.max(h * width, area);
            }
            stack.push(i);
        }
        return area;
    }

    private int violate(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int j = i + 1, k = i - 1;
            while (j < heights.length && heights[j] >= h) {
                j++;
            }
            while (k >= 0 && heights[k] >= h) {
                k--;
            }
            int w = j - k - 1;
            max = Math.max(w * h, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleArea area = new LargestRectangleArea();
        assertThat(area.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3})).isEqualTo(10);
    }

}
