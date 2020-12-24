package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 135. 分发糖果
 *
 * https://leetcode-cn.com/problems/candy/
 *
 * @author Fuxin
 * @since 2020/12/24
 */
public class Candy {

    // O(n2)
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] < ratings[i - 1]) {
                int j = i;
                while (j > 0 && ratings[j] < ratings[j - 1]) {
                    candies[j - 1] = Math.max(candies[j] + 1, candies[j - 1]);
                    j--;
                }
            } else if (i > 0 && ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int ans = candies.length;
        for (int candy : candies) {
            ans += candy;
        }
        return ans;
    }

    // 可用贪心
    public int candy2(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        int top = 0;
        for (int i = 1; i < len; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
                top = i;
            }
            if ((i < len - 1 && ratings[i] <= ratings[i + 1]) || i == len - 1) {
                int width = i - top;
                if (width >= 1) {
                    for (int j = top; j < i; j++) {
                        candies[j] = Math.max(i - j, candies[j]);
                    }
                }
            }
        }
        int ans = candies.length;
        for (int candy : candies) {
            ans += candy;
        }
        return ans;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        assertThat(candy.candy(new int[]{1, 0, 2})).isEqualTo(5);
        assertThat(candy.candy(new int[]{1, 2, 2})).isEqualTo(4);
        assertThat(candy.candy(new int[]{3, 2, 2, 1, 4})).isEqualTo(8);
        assertThat(candy.candy2(new int[]{1, 3, 2, 2, 1})).isEqualTo(7);
        assertThat(candy.candy2(new int[]{1, 0, 2})).isEqualTo(5);
        assertThat(candy.candy2(new int[]{1, 2, 2})).isEqualTo(4);
        assertThat(candy.candy2(new int[]{3, 2, 2, 1, 4})).isEqualTo(8);

    }

}
