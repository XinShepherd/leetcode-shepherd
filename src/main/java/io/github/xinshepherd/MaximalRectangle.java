package io.github.xinshepherd;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 85. 最大矩形
 *
 * https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * @author Fuxin
 * @since 2020/12/26
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0)
            return 0;
        int m = matrix[0].length;
        int[][] left = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = j == 0 ? 1 : left[i][j - 1] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(left[k][j], width);
                    area = Math.max(area, (i - k + 1) * width);
                }
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }

    public int maximalRectangle2(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = j == 0 ? 1 : left[i][j - 1] + 1;
                }
            }
        }
        int ans = 0;
        // 计算每列高度
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, helper(heights));
        }
        return ans;
    }

    // LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
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


    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();

        assertThat(maximalRectangle.maximalRectangle(new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'}
        })).isEqualTo(6);

        assertThat(maximalRectangle.maximalRectangle2(new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'}
        })).isEqualTo(6);
    }

}
