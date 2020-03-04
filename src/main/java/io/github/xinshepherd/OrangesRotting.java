package io.github.xinshepherd;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 *
 * @author Fuxin
 * @since 2020/3/4 10:12
 */
public class OrangesRotting {

    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        // queue : all starting cells with rotten oranges
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        for (int[] row: grid)
            for (int v: row)
                if (v == 1)
                    return -1;
        return ans;

    }

    public static void main(String[] args) {
        OrangesRotting orangesRotting = new OrangesRotting();
        System.out.println(orangesRotting.orangesRotting(new int[][]{
                new int[]{2, 1, 1},
                new int[]{1, 1, 0},
                new int[]{0, 1, 1}
        }));
        System.out.println(orangesRotting.orangesRotting(new int[][]{
                new int[]{0, 2},
        }));
        System.out.println(orangesRotting.orangesRotting(new int[][]{
                new int[]{2, 1, 1},
                new int[]{0, 1, 1},
                new int[]{1, 0, 1}
        }));
        System.out.println(orangesRotting.orangesRotting(new int[][]{
                new int[]{1},
                new int[]{1},
                new int[]{1}
        }));
    }

}
