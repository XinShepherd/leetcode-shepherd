package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 130. 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * @author Fuxin
 * @since 2020/8/11
 */
public class Solve {

    int[] nr = new int[]{0, -1, 0, 1};
    int[] nc = new int[]{-1, 0, 1, 0};

    public void solve(char[][] board) {
        int height = board.length;
        if (height == 0)
            return;
        int width = board[0].length;
        int max = Math.max(height, width);
        boolean[][] dp = new boolean[height][width];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // 边界
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    if (board[i][j] == 'O') {
                        dp[i][j] = true;
                        int code = max * i + j;
                        queue.add(code);
                    }
                }
            }
        }
        // 宽度优先
        while (!queue.isEmpty()) {
            Integer code = queue.pollFirst();
            int i = code / max;
            int j = code % max;
            for (int k = 0; k < 4; k++) {
                int dr = i + nr[k];
                int dc = j + nc[k];
                if (dr >= 0 && dr < height
                        && dc >= 0 && dc < width
                        && board[dr][dc] == 'O' && !dp[dr][dc]) {
                    dp[dr][dc] = true;
                    queue.add(max * dr + dc);
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O' && !dp[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        Solve solve = new Solve();
        char[][] board = {
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'},
        };
        solve.solve(board);
        assertThat(board).isEqualTo(new char[][]{
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'X', 'X'},
        });
        board = new char[][]{
                new char[]{'X', 'X', 'O', 'X'},
        };
        solve.solve(board);
        assertThat(board).isEqualTo(new char[][]{
                new char[]{'X', 'X', 'O', 'X'},
        });
    }

}
