package io.github.xinshepherd;

import org.assertj.core.api.Assertions;

/**
 * 202. 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 *
 * @author Fuxin
 * @since 2020/4/30
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        int ans = n;
        while (ans != 1) {
            if (ans == 4)
                return false;
            int num = ans;
            int temp = 0;
            while (num != 0) {
                int i = num % 10;
                temp += i * i;
                num /= 10;
            }
            ans = temp;
        }
        return true;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        Assertions.assertThat(happyNumber.isHappy(18)).isFalse();
        Assertions.assertThat(happyNumber.isHappy(19)).isTrue();
        Assertions.assertThat(happyNumber.isHappy(2)).isFalse();
    }
}
