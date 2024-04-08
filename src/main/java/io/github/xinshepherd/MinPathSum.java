package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 64. 最小路径和
 *
 * @author Fuxin
 * @since 2020/2/25 10:39
 */
public class MinPathSum {

    public int calculate(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
    }
    public int minPathSum(int[][] grid) {
//        return calculate(grid, 0, 0);
        return dynamicProgramming(grid);
    }

    int dynamicProgramming(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (j == grid[0].length - 1 && i != grid.length - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (j != grid[0].length - 1 && i == grid.length - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (j != grid[0].length - 1 && i != grid.length - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        Assertions.assertThat(minPathSum.minPathSum(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        })).isEqualTo(7);
    }

}
