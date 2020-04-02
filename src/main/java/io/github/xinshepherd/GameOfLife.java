package io.github.xinshepherd;

/**
 * 289. 生命游戏
 *
 * @author Fuxin
 * @since 2020/4/2
 */
public class GameOfLife {

    int[] nr = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    int[] nc = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

    public void gameOfLife(int[][] board) {
        int[][] ans = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int alive = 0;
                for (int k = 0; k < 8; k++) {
                    int dr = nr[k] + i;
                    int dc = nc[k] + j;
                    if (dr >= 0 && dr < board.length && dc >= 0 && dc < board[0].length && board[dr][dc] == 1) {
                        alive++;
                    }
                }
                if (board[i][j] == 0) {
                    if (alive == 3)
                        ans[i][j] = 1;
                } else {
                    if (alive < 2 || alive > 3)
                        ans[i][j] = 0;
                    else
                        ans[i][j] = 1;
                }
            }
        }
        System.arraycopy(ans, 0, board, 0, board.length);
    }

    public static void main(String[] args) {
        GameOfLife game = new GameOfLife();
        int[][] board = new int[][]{
                new int[]{0, 1, 0},
                new int[]{0, 0, 1},
                new int[]{1, 1, 1},
                new int[]{0, 0, 0}
        };
        game.gameOfLife(board);
        Util.printTwoDimensionalArray(board);
    }

}
