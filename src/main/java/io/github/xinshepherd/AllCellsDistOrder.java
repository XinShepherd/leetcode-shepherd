package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

import java.util.Arrays;

/**
 * 1030. 距离顺序排列矩阵单元格
 *
 * https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 *
 * @author Fuxin
 * @since 2020/11/17
 */
public class AllCellsDistOrder {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int len = R * C;
        int[][] ans = new int[len][2];
        for (int i = 0; i < R; i++) {
            int base = i * C;
            for (int j = 0; j < C; j++) {
                ans[base + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ans, (a, b) -> {
            int aLen = Math.abs(a[0] - r0) + Math.abs(a[1] - c0);
            int bLen = Math.abs(b[0] - r0) + Math.abs(b[1] - c0);
            return aLen - bLen;
        });
        return ans;
    }

    // 方法二：桶排序

    public static void main(String[] args) {
        AllCellsDistOrder order = new AllCellsDistOrder();
        Assertions.assertThat(order.allCellsDistOrder(1, 2, 0, 0)).isEqualTo(new int[][]{
                new int[]{0, 0},
                new int[]{0, 1}
        });

    }


}
