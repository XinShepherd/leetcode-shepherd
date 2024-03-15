package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. 有效的数独
 *
 * @author Fuxin
 * @since 2020/2/28 10:09
 */
public class ValidSudoku {

    private static final char COMMON_CHAR = '.';

    public boolean isValidSudoku(char[][] board) {
        if (!helper(board, true) || !helper(board, false)) {
            return false;
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                if (!isThreeValid(board, i, j))
                    return false;
            }
        }
        return true;
    }

    boolean isThreeValid(char[][] board, int i, int j) {
        Set<Character> dup = new HashSet<>();
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                char c = board[k][l];
                if (c != COMMON_CHAR) {
                    if (dup.contains(c)) {
                        return false;
                    } else {
                        dup.add(c);
                    }
                }
            }
        }
        return true;
    }

    boolean helper(char[][] board, boolean reverse) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> dup = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char c = reverse ? board[i][j] : board[j][i];
                if (c != COMMON_CHAR) {
                    if (dup.contains(c)) {
                        return false;
                    } else {
                        dup.add(c);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] invalidBoard = new char[][]{
                new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Assertions.assertThat(validSudoku.isValidSudoku(board)).isEqualTo(true);
        Assertions.assertThat(validSudoku.isValidSudoku(invalidBoard)).isEqualTo(false);
    }

}
