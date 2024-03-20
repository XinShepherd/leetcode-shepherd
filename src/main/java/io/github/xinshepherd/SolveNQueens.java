package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * 51. N皇后
 *
 * @author Fuxin
 * @since 2020/2/24 9:47
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return null;
        if (n == 1) return Arrays.asList(Arrays.asList("Q"));
        int[][] checkerboard = new int[n][n];
        List<List<String>> results = new LinkedList<>();
        boolean[] used = new boolean[n];
        solve(0, used, checkerboard, results);
        return results;
    }

    void solve(int index, boolean[] used, int[][] checkerboard, List<List<String>> results) {
        int len = checkerboard.length;
        if (index == len) {
            results.add(getResult(checkerboard));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            boolean leftUp = false;
            int j = 1;
            while (i - j >= 0 && index - j >= 0) {
                if (leftUp = checkerboard[index - j][i - j] == 1)
                    break;
                j++;
            }
            boolean rightUp = false;
            if (!leftUp) {
                int k = 1;
                while (i + k < len && index - k >= 0) {
                    if (rightUp = checkerboard[index - k][i + k] == 1)
                        break;
                    k++;
                }
            }
            if (leftUp || rightUp) {
                continue;
            }
            used[i] = true;
            checkerboard[index][i] = 1;
            solve(index + 1, used, checkerboard, results);
            // 回溯
            checkerboard[index][i] = 0;
            used[i] = false;
        }
    }

    List<String> getResult(int[][] checkerboard) {
        List<String> result = new ArrayList<>();
        for (int[] ints : checkerboard) {
            StringBuilder sb = new StringBuilder();
            for (int anInt : ints) {
                if (anInt == 1) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        SolveNQueens queens = new SolveNQueens();
        Assertions.assertThat(queens.solveNQueens(4)).isEqualTo(Arrays.asList(
                Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
                Arrays.asList("..Q.", "Q...", "...Q", ".Q..")
        ));
        Assertions.assertThat(queens.solveNQueens(5)).isEqualTo(Arrays.asList(
                Arrays.asList("Q....", "..Q..", "....Q", ".Q...", "...Q."),
                Arrays.asList("Q....", "...Q.", ".Q...", "....Q", "..Q.."),
                Arrays.asList(".Q...", "...Q.", "Q....", "..Q..", "....Q"),
                Arrays.asList(".Q...", "....Q", "..Q..", "Q....", "...Q."),
                Arrays.asList("..Q..", "Q....", "...Q.", ".Q...", "....Q"),
                Arrays.asList("..Q..", "....Q", ".Q...", "...Q.", "Q...."),
                Arrays.asList("...Q.", "Q....", "..Q..", "....Q", ".Q..."),
                Arrays.asList("...Q.", ".Q...", "....Q", "..Q..", "Q...."),
                Arrays.asList("....Q", ".Q...", "...Q.", "Q....", "..Q.."),
                Arrays.asList("....Q", "..Q..", "Q....", "...Q.", ".Q...")
        ));
    }

}
