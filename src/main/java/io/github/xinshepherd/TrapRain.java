package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 42. 接雨水
 *
 * @author Fuxin
 * @since 2020/3/16 10:14
 */
public class TrapRain {

    int sum = 0;
    public int trap(int[] height) {
        sum = 0;
        int maxIndex = getMaxIndex(height);
        if (maxIndex < height.length - 1) {
            int[] reverse = new int[height.length - maxIndex];
            for (int i = 0, j = height.length - 1; i < reverse.length; i++, j--) {
                reverse[i] = height[j];
            }
            getMaxIndex(reverse);
        }
        return sum;
    }

    private int getMaxIndex(int[] height) {
        int maxIndex = 0;
        int current = 0;
        for (; current < height.length; current++) {
            if (height[current] >= height[maxIndex]) {
                if (height[maxIndex] != 0) {
                    for (int i = maxIndex; i < current; i++) {
                        sum += (height[maxIndex] - height[i]);
                    }
                }
                maxIndex = current;
            }
        }
        return maxIndex;
    }


    public static void main(String[] args) {
        TrapRain trapRain = new TrapRain();
        Assertions.assertThat(trapRain.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})).isEqualTo(6);

    }

}
