package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalNQueens {

    int count = 0;

    // 方法1 1ms
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        int[] colUsed = new int[n];
        count = 0;
        backtrack(board, colUsed, 0);
        return count;
    }

    void backtrack(int[][] board, int[] colUsed, int i) {
        int len = board.length;
        if (i == len) {
            count++;
            return;
        }
        for (int j = 0; j < len; j++) {
            if (colUsed[j] == 1 || hasQueen(board, i - 1, j)) {
                continue;
            }
            board[i][j] = 1;
            colUsed[j] = 1;
            backtrack(board, colUsed, i + 1);
            board[i][j] = 0;
            colUsed[j] = 0;
        }
    }

    boolean hasQueen(int[][] board, int row, int col) {
        int left = col - 1;
        int right = col + 1;
        while (row >= 0) {
            if (left >= 0 && board[row][left] == 1) {
                return true;
            }
            if (right < board.length && board[row][right] == 1) {
                return true;
            }
            row--;
            left--;
            right++;
        }
        return false;
    }

    int[] cols;
    int[] lefts;
    int[] rights;

    public int totalNQueens2(int n) {
        count = 0;
        cols = new int[n];
        lefts = new int[n * 2 - 1];
        rights = new int[n * 2 - 1];
        backtrack(n, 0);
        return count;
    }

    void backtrack(int n, int i) {
        if (i == n) {
            count++;
            return;
        }
        for (int j = 0; j < n; j++) {
            int leftIdx = j - i + n - 1;
            int rightIdx = j + i;
            if (cols[j] == 1 || lefts[leftIdx] == 1 || rights[rightIdx] == 1) {
                continue;
            }
            cols[j] = 1;
            lefts[leftIdx] = 1;
            rights[rightIdx] = 1;
            backtrack(n, i + 1);
            cols[j] = 0;
            lefts[leftIdx] = 0;
            rights[rightIdx] = 0;
        }
    }

    public static void main(String[] args) {
        TotalNQueens totalNQueens = new TotalNQueens();
        assertThat(totalNQueens.totalNQueens(4)).isEqualTo(2);
        assertThat(totalNQueens.totalNQueens(3)).isEqualTo(0);
        assertThat(totalNQueens.totalNQueens(2)).isEqualTo(0);
        assertThat(totalNQueens.totalNQueens(1)).isEqualTo(1);
        assertThat(totalNQueens.totalNQueens2(4)).isEqualTo(2);
        assertThat(totalNQueens.totalNQueens2(3)).isEqualTo(0);
        assertThat(totalNQueens.totalNQueens2(2)).isEqualTo(0);
        assertThat(totalNQueens.totalNQueens2(1)).isEqualTo(1);
    }

}
