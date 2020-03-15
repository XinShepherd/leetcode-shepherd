package io.github.xinshepherd;

// 695. 岛屿的最大面积
public class MaxAreaOfIsland {

    int max = 0, counter = 0;
    int[] nx = {-1, 0, 1, 0};
    int[] ny = {0, -1, 0, 1};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean[][] flags = new boolean[grid.length][grid[0].length];
        max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int v = grid[i][j];
                if (v == 1 && !flags[i][j]) {
                    flags[i][j] = true;
                    counter = 1;
                    dp(grid, flags, i, j);
                }
            }
        }
        return max;
    }

    void dp(int[][] grid, boolean[][] flags, int x, int y) {

        for (int i = 0; i < 4; i++) {
            int r = x + nx[i];
            int c = y + ny[i];
            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && !flags[r][c] && grid[r][c] == 1) {
                flags[r][c] = true;
                counter++;
                dp(grid, flags, r, c);
            }
        }
        if (counter > max)
            max = counter;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(new int[][]{
                new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));


    }

}
