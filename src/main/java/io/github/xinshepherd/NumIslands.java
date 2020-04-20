package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 200. 岛屿数量
 *
 * @author Fuxin
 * @since 2020/4/20
 */
public class NumIslands {

    int[] nr = {-1, 0, 1, 0};
    int[] nc = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {

        int rowSize = grid.length;
        if (rowSize == 0) return 0;
        int colSize = grid[0].length;
        int maxLen = Math.max(rowSize, colSize);
        boolean[][] dp = new boolean[rowSize][colSize];
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize && !dp[i][j]; j++) {
                if (grid[i][j] == '1' && !dp[i][j]) {
                    int code = i * maxLen + j;
                    dp[i][j] = true;
                    stack.addLast(code);
                    ans++;
                }
                while (!stack.isEmpty()) {
                    Integer code = stack.pop();
                    int dr = code / maxLen;
                    int dc = code % maxLen;
                    for (int k = 0; k < 4; k++) {
                        int r = dr + nr[k];
                        int c = dc + nc[k];
                        if (r >= 0 && r < rowSize && c >= 0 && c < colSize && grid[r][c] == '1' && !dp[r][c]) {
                            dp[r][c] = true;
                            stack.addLast(r * maxLen + c);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands(new char[][]{
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray(),
        }));
        System.out.println(numIslands.numIslands(new char[][]{
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray(),
        }));
        System.out.println(numIslands.numIslands(new char[][]{
                "1".toCharArray(),
                "1".toCharArray(),
        }));
    }

}
