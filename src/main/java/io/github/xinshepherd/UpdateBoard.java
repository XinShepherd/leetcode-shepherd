package io.github.xinshepherd;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 529. 扫雷游戏
 * https://leetcode-cn.com/problems/minesweeper/
 *
 * @author Fuxin
 * @since 2020/8/20
 */
public class UpdateBoard {

    int[] nr = {-1, -1, -1, 0, 1, 1, 1, 0};
    int[] nc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int n = board.length;
        if (n == 0) return board;
        int m = board[0].length;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int max = Math.max(m, n);
        boolean[][] dp = new boolean[n][m];
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(max * click[0] + click[1]);
        while (!deque.isEmpty()) {
            int code = deque.removeFirst();
            int r = code / max;
            int c = code % max;
            int count = 0;
            for (int i = 0; i < 8; i++) {
                int dr = r + nr[i];
                int dc = c + nc[i];
                if (dr >= 0 && dr < n && dc >= 0 && dc < m) {
                    if (board[dr][dc] == 'M') {
                        count++;
                    }
                }
            }
            if (count == 0) {
                board[r][c] = 'B';
                for (int i = 0; i < 8; i++) {
                    int dr = r + nr[i];
                    int dc = c + nc[i];
                    if (dr >= 0 && dr < n && dc >= 0 && dc < m && board[dr][dc] == 'E' && !dp[dr][dc]) {
                        deque.addLast(max * dr + dc);
                        dp[dr][dc] = true;
                    }
                }
            } else if (count > 0) {
                board[r][c] = (char) ('0' + count);
            }
            dp[r][c] = true;
        }
        return board;
    }

    public static void main(String[] args) {
        UpdateBoard updateBoard = new UpdateBoard();
        char[][] board = {
                new char[]{'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'M', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E'}
        };
        board = updateBoard.updateBoard(board, new int[]{3, 0});
        assertThat(board).isEqualTo(new char[][]{
                new char[]{'B', '1', 'E', '1', 'B'},
                new char[]{'B', '1', 'M', '1', 'B'},
                new char[]{'B', '1', '1', '1', 'B'},
                new char[]{'B', 'B', 'B', 'B', 'B'}
        });
    }
}
