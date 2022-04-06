package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 *
 * 79. 单词搜索
 *
 * @author Fuxin
 * @since 2020/3/11 14:30
 */
public class ExistWord {

    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
        boolean[][] flags = new boolean[board.length][board[0].length];
        // 先确定起始点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flags[i][j] = true;
                    if (backtrack(board, word, 1, flags, i, j)) {
                        return true;
                    }
                    flags[i][j] = false;
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, String word, int current, boolean[][] flags, int x, int y) {
        if (current == word.length()) {
            return true;
        }
        char c = word.charAt(current);
        for (int i = 0; i < dr.length; i++) {
            int nr = x + dr[i];
            int nc = y + dc[i];
            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length) {
                if (flags[nr][nc] != true && board[nr][nc] == c) {
                    flags[nr][nc] = true;
                    boolean result = backtrack(board, word, current + 1, flags, nr, nc);
                    if (result)
                        return true;
                    flags[nr][nc] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ExistWord existWord = new ExistWord();
        char[][] board = new char[][]
                {
                        new char[]{'A', 'B', 'C', 'E'},
                        new char[]{'S', 'F', 'C', 'S'},
                        new char[]{'A', 'D', 'E', 'E'}
                };
        Assertions.assertThat(existWord.exist(board, "ABCCED")).isTrue();
        Assertions.assertThat(existWord.exist(board, "SEE")).isTrue();
        Assertions.assertThat(existWord.exist(board, "ABCB")).isFalse();
    }
}
