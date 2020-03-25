package io.github.xinshepherd;

/**
 * 892. 三维形体的表面积
 *
 * @author Fuxin
 * @since 2020/3/25
 */
public class SurfaceArea {

    int[] dr = {0, -1, 0, 1};
    int[] dc = {-1, 0, 1, 0};

    public int surfaceArea(int[][] grid) {
        if (grid.length == 0) return 0;
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int v = grid[i][j];
                if (v == 0) continue;
                int area = v * 4 + 2;
                for (int k = 0; k < 4; k++) {
                    int nr = dr[k] + i;
                    int nc = dc[k] + j;
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] > 0) {
                        area -= Math.min(v, grid[nr][nc]);
                    }
                }
                total += area;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        SurfaceArea surfaceArea = new SurfaceArea();
        System.out.println(surfaceArea.surfaceArea(new int[][]{new int[]{2}}));
        System.out.println(surfaceArea.surfaceArea(new int[][]{
                new int[]{1, 2},
                new int[]{3, 4}
        }));
        System.out.println(surfaceArea.surfaceArea(new int[][]{
                new int[]{1, 0},
                new int[]{0, 2}
        }));
        System.out.println(surfaceArea.surfaceArea(new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 0, 1},
                new int[]{1, 1, 1}
        }));

    }
}
