package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 79. 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 *
 * @author Fuxin
 * @since 2020/9/13
 */
public class ExistsWord {

    boolean exists = false;

    int[] nr = new int[]{0, 1, 0, -1};
    int[] nc = new int[]{-1, 0, 1, 0};

    public boolean exist(char[][] board, String word) {
        exists = false;
        int m = board.length;
        if (m == 0 || word.length() == 0)
            return false;
        int n = board[0].length;
        boolean[][] dp = new boolean[m][n];
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == chars[0]) {
                    if (exists)
                        return true;
                    dp[i][j] = true;
                    backtrack(board, chars, 1, i, j, dp);
                    dp[i][j] = false;
                }
            }
        }
        return exists;
    }

    void backtrack(char[][] board, char[] chars, int current, int x, int y, boolean[][] dp) {
        if (exists)
            return;
        if (current == chars.length) {
            exists = true;
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < 4; i++) {
            int dr = x + nr[i];
            int dc = y + nc[i];
            if (dr >= 0 && dr < m && dc >= 0 && dc < n && !dp[dr][dc] && board[dr][dc] == chars[current]) {
                dp[dr][dc] = true;
                backtrack(board, chars, current + 1, dr, dc, dp);
                dp[dr][dc] = false;
            }
        }
    }

    public static void main(String[] args) {
        ExistsWord existsWord = new ExistsWord();
        char[][] board = {
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        };
        assertThat(existsWord.exist(board, "ABCCED")).isTrue();
        assertThat(existsWord.exist(board, "SEE")).isTrue();
        assertThat(existsWord.exist(board, "ABCB")).isFalse();
        board = new char[][]{
                new char[]{'a', 'a'}
        };
        assertThat(existsWord.exist(board, "aaa")).isFalse();
    }

}
