package io.github.xinshepherd;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 860. 柠檬水找零
 *
 * https://leetcode-cn.com/problems/lemonade-change/
 *
 * @author Fuxin
 * @since 2020/12/10
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int fiveCounts = 0;
        int tenCounts = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveCounts++;
            } else if (bill == 10) {
                if (fiveCounts == 0)
                    return false;
                tenCounts++;
                fiveCounts--;
            } else {
                if (tenCounts > 0 && fiveCounts > 0) {
                    tenCounts--;
                    fiveCounts--;
                } else if (fiveCounts >= 3) {
                    fiveCounts -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();
        assertThat(lemonadeChange.lemonadeChange(new int[]{5, 5, 10})).isTrue();
        assertThat(lemonadeChange.lemonadeChange(new int[]{10, 10})).isFalse();
        assertThat(lemonadeChange.lemonadeChange(new int[]{5, 5, 5, 10, 20})).isTrue();
        assertThat(lemonadeChange.lemonadeChange(new int[]{5, 5, 10, 10, 20})).isFalse();
    }

}
