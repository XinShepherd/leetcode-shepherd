package io.github.xinshepherd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1431. 拥有最多糖果的孩子
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 *
 * @author Fuxin
 * @since 2020/6/1
 */
public class KidsWithCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> ans = new ArrayList<>(candies.length);
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                ans.add(Boolean.TRUE);
            } else {
                ans.add(Boolean.FALSE);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        KidsWithCandies candies = new KidsWithCandies();
        List<Boolean> ans = candies.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
        assertThat(ans).isEqualTo(Arrays.asList(true, true, true, false, true));
    }
}
