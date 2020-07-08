package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 面试题 16.11. 跳水板
 * https://leetcode-cn.com/problems/diving-board-lcci/
 *
 * @author Fuxin
 * @since 2020/7/8
 */
public class DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0)
            return new int[]{};
        int[] ans = shorter == longer ? new int[1] : new int[k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += shorter;
        }
        ans[0] = sum;
        if (shorter != longer) {
            for (int i = 1; i < k + 1; i++) {
                sum -= shorter;
                sum += longer;
                ans[i] = sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DivingBoard board = new DivingBoard();
        assertThat(board.divingBoard(1, 2, 3)).isEqualTo(new int[]{3, 4, 5, 6});
        assertThat(board.divingBoard(1, 1, 3)).isEqualTo(new int[]{3});
    }

}
