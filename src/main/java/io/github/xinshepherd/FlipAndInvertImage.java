package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 832. 翻转图像
 *
 * https://leetcode-cn.com/problems/flipping-an-image/
 *
 * @author Fuxin
 * @since 2021/2/24
 */
public class FlipAndInvertImage {

    public int[][] flipAndInvertImage(int[][] A) {
        int n = A[0].length;
        for (int[] row : A) {
            for (int j = 0, k = n - 1; j <= k; j++, k--) {
                int temp = row[j] == 1 ? 0 : 1;
                row[j] = row[k] == 1 ? 0 : 1;
                row[k] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        FlipAndInvertImage flipAndInvertImage = new FlipAndInvertImage();
        assertThat(flipAndInvertImage.flipAndInvertImage(new int[][]{
                new int[]{1,1,0},
                new int[]{1,0,1},
                new int[]{0,0,0}
        })).isEqualTo(new int[][]{
                new int[]{1,0,0},
                new int[]{0,1,0},
                new int[]{1,1,1}
        });
        assertThat(flipAndInvertImage.flipAndInvertImage(new int[][]{
                new int[]{1,1,0,0},
                new int[]{1,0,0,1},
                new int[]{0,1,1,1},
                new int[]{1,0,1,0}
        })).isEqualTo(new int[][]{
                new int[]{1,1,0,0},
                new int[]{0,1,1,0},
                new int[]{0,0,0,1},
                new int[]{1,0,1,0}
        });
    }

}
