package io.github.xinshepherd;

import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * 999. 车的可用捕获量
 *
 * @author Fuxin
 * @since 2020/3/26 9:08
 */
public class NumRookCaptures {

    public int numRookCaptures(char[][] board) {
        int i = 0, j = 0;
        outer:
        for (; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    break outer;
                }
            }
        }
        int count = 0;
        count += capture(i, j, board, k -> k >= 0, k -> k - 1, true);
        count += capture(i, j, board, k -> k < board.length, k -> k + 1, true);
        count += capture(i, j, board, k -> k >= 0, k -> k - 1, false);
        count += capture(i, j, board, k -> k < board.length, k -> k + 1, false);
        return count;
    }

    int capture(int x, int y, char[][] board, Predicate<Integer> condition, IntFunction<Integer> fuc, boolean X) {
        boolean flag = X ? condition.test(x) : condition.test(y);
        for (; flag;) {
            if (board[x][y] == 'B') {
                return 0;
            }
            if (board[x][y] == 'p') {
                return 1;
            }
            if (X)
                x = fuc.apply(x);
            else
                y = fuc.apply(y);
            flag = X ? condition.test(x) : condition.test(y);
        }
        return 0;
    }

    public static void main(String[] args) {
        NumRookCaptures numRookCaptures = new NumRookCaptures();
        System.out.println(numRookCaptures.numRookCaptures(new char[][]{
                new char[]{'.','.','.','.','.','.','.','.'},
                new char[]{'.','.','.','p','.','.','.','.'},
                new char[]{'.','.','.','R','.','.','.','p'},
                new char[]{'.','.','.','.','.','.','.','.'},
                new char[]{'.','.','.','.','.','.','.','.'},
                new char[]{'.','.','.','p','.','.','.','.'},
                new char[]{'.','.','.','.','.','.','.','.'},
                new char[]{'.','.','.','.','.','.','.','.'}
        }));
    }
}
